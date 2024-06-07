package Core.System;

import Core.Connection.SqlConnection;
import Core.Specification.DatabaseSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public  class LocalDatabaseInitialization {


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

    public Optional<SqlConnection> initialize(DatabaseSpecification spec){

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
