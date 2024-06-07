package Core.System;

import Core.Connection.SqlConnection;
import Core.Specification.DatabaseSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class LocalDatabaseInitialization {


    protected DatabaseSpecification spec;
    private List<Consumer<InitializationState>> systemObservers = new ArrayList<>();

    record InitializationState(String message, String state){}

    public void addObserver(Consumer<InitializationState> observer){
        synchronized (this){
            if(systemObservers.contains(observer)){
                return;
            }
            systemObservers.add(observer);
        }
    }
    private void notifyObservers(InitializationState newState){
        synchronized (this){
            if(systemObservers.isEmpty()) {
                return;
            }
            systemObservers.forEach(consumer -> consumer.accept(newState));

        }
    }

    public SqlConnection initialize(DatabaseSpecification spec) throws Exception {
        this.spec = spec;
        if(!databaseExists()){
            createDatabase();
            beforeConnect();
            return connect();
        }
        return connect();
    }

    protected abstract Boolean databaseExists();
    protected abstract void createDatabase() throws Exception;
    protected abstract SqlConnection connect();
    protected abstract void beforeConnect();
}
