package Persistance.JDBC;
import Connection.SqlConnection;
import Specification.DatabaseSpecification;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqLiteConnection implements SqlConnection {

    private static final Logger log = Logger.getLogger(SqLiteConnection.class);
    private DatabaseSpecification spec;

    public SqLiteConnection(DatabaseSpecification spec) {
        this.spec = spec;
    }

    private void initializeConnection(){
        
    }
    @Override
    public Connection connect(){
        Connection conn = null;
        try {
           conn = DriverManager.getConnection(spec.url());
           return null;
        }catch (SQLException ex) {
            log.error("Error creating the connection: ", ex);
            return null;
        }
    }
}
