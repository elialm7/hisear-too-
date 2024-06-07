package Controller;

import Service.UseCaseService;
import UIState.MainViewModel;
import View.MainView;
import com.formdev.flatlaf.FlatDarculaLaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class MainViewController {

    private static final Logger log = LoggerFactory.getLogger(MainViewController.class);
    private MainViewModel mainViewModel;
    private MainView mainView;
    private UseCaseService service;



    public MainViewController(MainViewModel model, MainView view, UseCaseService service){
        this.mainView = view;
        this.mainViewModel = model;
        this.service = service;
    }


    public void start(){

        java.awt.EventQueue.invokeLater(() -> {
            try {
                log.debug("We are setting up the lookandfeel");
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } catch( Exception ex ) {
                log.error(ex.getMessage());
            }
            log.debug("calling the mainview.");
            mainView.setVisible(true);
        });
    }

}
