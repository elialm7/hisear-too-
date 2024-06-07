package Persistance.SqlLiteInitialization;

import Core.Connection.SqlConnection;
import Core.System.LocalDatabaseInitialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.Objects;

public class SqLiteInitialization extends LocalDatabaseInitialization {


    private static final Logger log = LoggerFactory.getLogger(SqLiteInitialization.class);

    public SqLiteInitialization(){

    }

    @Override
    protected Boolean databaseExists() {
        Path base = Path.of(new File(".").toURI());
        Path file = Path.of(new File(spec.databaseName()).toURI());
        Path finalpath = base.resolve(file);
        return finalpath.toFile().exists();
    }

    @Override
    protected void createDatabase() throws Exception {

    }

    @Override
    protected SqlConnection connect() {
        return null;
    }


    @Override
    protected void beforeConnect() {

    }
}
