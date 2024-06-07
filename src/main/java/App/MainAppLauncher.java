package App;
import Controller.MainViewController;
import Core.Connection.SqlConnection;
import Core.Specification.DatabaseSpecification;
import Core.System.LocalDatabaseInitialization;
import Errors.ErrorCode;
import Persistance.JDBC.HistorieSearchDaoImp;
import Persistance.SqlLiteInitialization.SqLiteInitialization;
import Service.UseCaseService;
import UIState.MainViewModel;
import org.apache.log4j.Logger;
import View.MainView;
import javax.swing.*;


public class MainAppLauncher {

    private static final Logger log = Logger.getLogger(MainAppLauncher.class.getName());
    public static void main(String...args){
       init();
    }
    private static DatabaseSpecification getDatabaseSpecification(){
        //todo: improve later
        var spec = new DatabaseSpecification();
        spec.setBaseurl("jdbc:sqlite:");
        spec.setDatabaseName("data.db");
        return spec;
    }
    private static SqlConnection tryDatabaseInitialization(){
        try {
            log.debug("Attempting local database initialization");
            LocalDatabaseInitialization systemInitialization = new SqLiteInitialization();
            var dbspec = getDatabaseSpecification();
            return systemInitialization.initialize(dbspec);
        }catch (Exception ex){
            log.error("Local database failed.", ex);
            JOptionPane.showMessageDialog(null,
                    "Local Database loading failed.",
                    "Error at startup", JOptionPane.ERROR_MESSAGE);
            System.exit(ErrorCode.FAILED_DATABASE_INITIALIZATION);
            return null; //unreachable
        }
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
