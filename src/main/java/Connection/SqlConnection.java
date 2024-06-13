package Connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlConnection {
    Connection connect() throws SQLException;
}
