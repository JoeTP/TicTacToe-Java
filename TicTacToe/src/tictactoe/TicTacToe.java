package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;


import tictactoe.splashscreengui.FXMLSplashScreenController;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //   Parent root = new FXMLSettingController();
        //Parent root = new FXMLSignupController();


        Parent root = new FXMLSplashScreenController(stage);



        Scene scene = new Scene(root);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
