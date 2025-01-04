package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineBase;
import tictactoe.onlinegmaeboard.*;

import tictactoe.signin.FXMLSigninController;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.playervsplayer.FXMLPlayerVsPlayerController;
import tictactoe.homescreen.FXMLHomeScreenController;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import tictactoe.offlinegameboard.FXMLOfflineGameBoardBase;

import tictactoe.setting.FXMLSettingController;

import tictactoe.splashscreengui.FXMLSplashScreenBase;

import tictactoe.signup.FXMLSignupController;
import tictactoe.splashscreengui.FXMLSplashScreenController;

public class TicTacToe extends Application {

   
    

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = new FXMLSplashScreenController(stage);
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
