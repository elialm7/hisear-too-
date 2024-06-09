package App;
import Controller.MainViewController;
import Connection.SqlConnection;
import Specification.DatabaseSpecification;
import Errors.ErrorCode;
import Persistance.JDBC.HistorieSearchDaoImp;
import Service.UseCaseService;
import UIState.MainViewModel;
import org.apache.log4j.Logger;
import View.MainView;

import java.util.Optional;


public class MainAppLauncher {

    private static String systemVersion = "v0.1.0";

    private static final Logger log = Logger.getLogger(MainAppLauncher.class.getName());
    public static void main(String...args){
       init();
    }
    private static DatabaseSpecification createDatabaseSpecification(){
        var spec = new DatabaseSpecification();
        var databaseName = "data"+systemVersion+".db";
        spec.setBaseurl("jdbc:sqlite:");
        spec.setDatabaseName(databaseName);
        return spec;
    }
    private static SqlConnection tryDatabaseInitialization(){
        return null;
    }
    private static void init(){
        var connection = tryDatabaseInitialization();
        UseCaseService service = new UseCaseService(new HistorieSearchDaoImp(connection));
        MainViewModel uiModel = new MainViewModel();
        MainView mainView = new MainView(uiModel);
        MainViewController mainViewController = new MainViewController(uiModel, mainView, service);
        mainViewController.start();
    }
}
