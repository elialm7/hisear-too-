package Persistance.JDBC;
import Connection.SqlConnection;
import Specification.DatabaseSpecification;

import java.sql.Connection;

public class SqLiteConnection implements SqlConnection {


    private DatabaseSpecification spec;

    public SqLiteConnection(DatabaseSpecification spec) {
        this.spec = spec;
    }

    private void runScript(){

    }
    @Override
    public Connection connect(){


        return null;
    }
}
