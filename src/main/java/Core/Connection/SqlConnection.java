package Core.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface SqlConnection {
    Optional<Connection> connect();
}
