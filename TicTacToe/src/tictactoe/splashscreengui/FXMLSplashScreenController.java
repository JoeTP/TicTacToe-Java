package tictactoe.splashscreengui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.AppFunctions;

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
    }
}
