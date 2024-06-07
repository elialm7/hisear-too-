package App;
import Controller.MainViewController;
import Connection.SqlConnection;
import Specification.DatabaseSpecification;
import Persistance.Initialization.LocalSqliteDatabaseInitialization;
import Errors.ErrorCode;
import Persistance.JDBC.HistorieSearchDaoImp;
import Service.UseCaseService;
import UIState.MainViewModel;
import org.apache.log4j.Logger;
import View.MainView;

import java.util.Optional;


public class MainAppLauncher {

    private static final Logger log = Logger.getLogger(MainAppLauncher.class.getName());
    public static void main(String...args){
       init();
    }
    private static DatabaseSpecification createDatabaseSpecification(){
        //todo: improve later
        var spec = new DatabaseSpecification();
        spec.setBaseurl("jdbc:sqlite:");
        spec.setDatabaseName("data.db");
        return spec;
    }
    private static SqlConnection tryDatabaseInitialization(){
        log.debug("Initializing database");
        LocalSqliteDatabaseInitialization systemInitialization = new LocalSqliteDatabaseInitialization();
        var dbspec = createDatabaseSpecification();
        Optional<SqlConnection> result = systemInitialization.initialize(dbspec);
        if(result.isEmpty()){
            log.error("Local database loading failed.");
            System.exit(ErrorCode.FAILED_DATABASE_INITIALIZATION);
        }
        return result.get();
    }
    private static void init(){
        log.debug("Initializing system.");
        var connection = tryDatabaseInitialization();
        UseCaseService service = new UseCaseService(new HistorieSearchDaoImp(connection));
        MainViewModel uiModel = new MainViewModel();
        MainView mainView = new MainView(uiModel);
        MainViewController mainViewController = new MainViewController(uiModel, mainView, service);
        mainViewController.start();
    }
}
