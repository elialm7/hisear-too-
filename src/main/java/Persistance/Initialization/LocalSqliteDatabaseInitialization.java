package Persistance.Initialization;
import Connection.SqlConnection;
import Specification.DatabaseSpecification;
import Entities.ObservableProperty;
import Persistance.JDBC.SqLiteConnection;
import com.ibatis.common.jdbc.ScriptRunner;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public  class LocalSqliteDatabaseInitialization {

    private static final Logger log = Logger.getLogger(LocalSqliteDatabaseInitialization.class);
    private DatabaseSpecification spec;
    private ObservableProperty<InitializationStateMessage> observableState;

    public record InitializationStateMessage(String message, String state){}

    public LocalSqliteDatabaseInitialization(){
        this.observableState = new ObservableProperty<>(
                new InitializationStateMessage("", "")
        );
    }

    public ObservableProperty<InitializationStateMessage> getObservableState(){
        return this.observableState;
    }

    private void notifyState(String state, String message){
        this.observableState.set(
                new InitializationStateMessage(message, state)
        );
    }

    private boolean fileExists(String filename){
        return new File(filename).exists();
    }


    public Optional<SqlConnection> initialize(DatabaseSpecification spec){

        if(Objects.isNull(spec)){
            notifyState("Error", "A database specification wasn't passed.");
            log.error("The database specification is null");
            return Optional.empty();
        }
        if(fileExists(spec.databaseName())){
            notifyState("Succesful", "The database file exists");
            return Optional.of(new SqLiteConnection(spec));
        }
        var temporalConnection = new SqLiteConnection(spec);
        Optional<Connection> result = temporalConnection.connect();
        if(result.isEmpty()){
            notifyState("Error", "Connection is empty");
            log.error("The connection was empty, something bad happened");
            return Optional.empty();
        }
        try {
            var runner = new ScriptRunner(result.get(), false, false);
            runner.runScript(new FileReader(spec.databaseName()));
        }catch (IOException | SQLException e){
            notifyState("ErrorOnRunningScript","an error happened during the database creation");
            log.error("An error happened during the database creation", e);
            return Optional.empty();
        }
        return Optional.of(new SqLiteConnection(spec));

    }

}
