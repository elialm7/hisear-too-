package Core.System;
import Core.Connection.SqlConnection;
import Core.Specification.DatabaseSpecification;
import Entities.ObservableProperty;
import java.util.Optional;

public  class LocalDatabaseInitialization {
    private DatabaseSpecification spec;

    private ObservableProperty<InitializationStateMessage> observableState;

    public record InitializationStateMessage(String message, String state){}

    public LocalDatabaseInitialization(){
        this.observableState = new ObservableProperty<>(
                new InitializationStateMessage("", "")
        );
    }

    public ObservableProperty<InitializationStateMessage> getObservableState(){
        return this.observableState;
    }

    public Optional<SqlConnection> initialize(DatabaseSpecification spec){


        this.observableState.set(new InitializationStateMessage(
                "",
                ""
        ));

        /*
            todo: steps for the initialization
                    1. check if spec.file() exists
                    2. if it exists, then just return the sqlconecction
                    3. if it doesn't exist , then attempt the connection to create the file
                    4. run the table creation.
                    5. after that, return the sqlconecction
         */




        return Optional.empty();

    }

}
