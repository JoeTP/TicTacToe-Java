package tictactoe.splashscreengui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLSplashScreenController extends FXMLSplashScreenBase {

    Thread th;
    Stage stage;
    Parent root;
    Scene scene;

    public FXMLSplashScreenController(Stage stage) {
        this.stage = stage;

        th = new Thread(() -> {
            try {
                Thread.sleep(3000);
                Platform.runLater(() -> {
                    try {
                        root = FXMLLoader.load(getClass().getResource("homescreen/FXMLHomeScreen.fxml"));
                        scene = new Scene(root);
                        stage.setScene(scene);

                    } catch (Exception ex) {
                        Logger.getLogger(FXMLSplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLSplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        th.start();
    }
}
