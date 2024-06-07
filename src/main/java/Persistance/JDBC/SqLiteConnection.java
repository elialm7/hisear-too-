package Persistance.JDBC;

import Core.Connection.SqlConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class SqLiteConnection implements SqlConnection {

    private static final Logger log = Logger.getLogger(SqLiteConnection.class);
    private String url;



    public SqLiteConnection(String url) {
        this.url = url;
    }

    @Override
    public Optional<Connection> connect(){
        Connection conn = null;
        try {
           conn = DriverManager.getConnection(url);
           return Optional.of(conn);
        }catch (SQLException ex) {
            log.error("Error creating the connection: ", ex);
            return Optional.ofNullable(conn);
        }
    }
}
