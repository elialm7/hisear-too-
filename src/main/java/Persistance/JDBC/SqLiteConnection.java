package Persistance.JDBC;

import Connection.SqlConnection;
import Specification.DatabaseSpecification;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class SqLiteConnection implements SqlConnection {

    private static final Logger log = Logger.getLogger(SqLiteConnection.class);
    private DatabaseSpecification spec;



    public SqLiteConnection(DatabaseSpecification spec) {
        this.spec = spec;
    }

    @Override
    public Optional<Connection> connect(){
        Connection conn = null;
        try {
           conn = DriverManager.getConnection(spec.url());
           return Optional.of(conn);
        }catch (SQLException ex) {
            log.error("Error creating the connection: ", ex);
            return Optional.empty();
        }
    }
}
