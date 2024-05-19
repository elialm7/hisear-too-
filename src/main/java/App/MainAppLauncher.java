package App;
import com.formdev.flatlaf.FlatDarculaLaf;
import org.apache.log4j.Logger;
import View.MainView;
import javax.swing.*;


public class MainAppLauncher {

    private static final Logger log = Logger.getLogger(MainAppLauncher.class.getName());

    public static void main(String...args){

        java.awt.EventQueue.invokeLater(() -> {
            try {
                log.debug("We are setting up the lookandfeel");
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } catch( Exception ex ) {
                log.error(ex.getMessage());
            }
            log.debug("calling the mainview.");
            new MainView().setVisible(true);
        });
    }


}
