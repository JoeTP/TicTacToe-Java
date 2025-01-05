package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.splashscreengui.FXMLSplashScreenController;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new FXMLSplashScreenController(stage);


        stage.setTitle("TicTacToe");


        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("offlinegameboard/fxmlofflinegameboard.css").toExternalForm());
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
