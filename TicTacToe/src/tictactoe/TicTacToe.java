package tictactoe;

import clientconnection.ClientConnection;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.AppString;
import tictactoe.homescreen.FXMLHomeScreenBase;
import tictactoe.homescreen.FXMLHomeScreenController;
 


import tictactoe.splashscreengui.FXMLSplashScreenController;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {
 

//        Parent root = new FXMLSplashScreenController(stage);
        Parent root = new FXMLHomeScreenController(stage);
        Scene scene = new Scene(root);
        //stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        stage.setTitle(AppString.APP_TITLE);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    @Override
    public void stop(){
        ClientConnection.stopThreads();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
