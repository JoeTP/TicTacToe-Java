package tictactoe.splashscreengui;

import javafx.animation.PauseTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


import shared.AppFunctions;

import shared.AppConstants;

import tictactoe.homescreen.FXMLHomeScreenController;

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

        PauseTransition pause = new PauseTransition(Duration.seconds(AppConstants.SPLASH_SCREEN_TIMER));
        pause.play();
        pause.setOnFinished(event -> {
            stage.setScene(new Scene(new FXMLHomeScreenController(stage)));
            stage.show();
        });
    }
}
