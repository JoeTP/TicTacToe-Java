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

import tictactoe.signup.FXMLSignupController;

public class TicTacToe extends Application {

    private double xOffset = 0.0;
    private double yOffset = 0.0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLSettingController();
        //Parent root = new FXMLSignupController();

        //  Parent root = new FXMLOfflineGameBoardBase();
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //Parent root = new FXMLSigninController();       
        // Parent root = new FXMLPlayerVsCompController();        
        //   Parent root = new FXMLHomeScreenController();

// Parent root = new FXMLOfflineGameBoardBase();
        //Parent root = new FXMLHomeScreenController();
        //Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("offlinegameboard/fxmlofflinegameboard.css").toExternalForm());
         //String css = this.getClass().getResource().
        //scene.getStylesheets().add(getClass().getResource("onlinegmaeboard/style.css").toExternalForm());
        //stage.setTitle("TicTacToe");
      //  Parent root = new FXMLHomeScreenController(stage, false);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("offlinegameboard/fxmlofflinegameboard.css").toExternalForm());
        stage.setTitle("TicTacToe");

        //Parent root = new FXMLOfflineGameBoardBase();
        //Parent root = new FXMLHomeScreenController();
        //Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("offlinegameboard/fxmlofflinegameboard.css").toExternalForm());
        //String css = this.getClass().getResource().
        //scene.getStylesheets().add(getClass().getResource("onlinegmaeboard/style.css").toExternalForm());
        //stage.setTitle("TicTacToe");
        //Parent root = new FXMLHomeScreenController(stage,false);
        //Scene scene = new Scene(root);
        stage.setTitle("TicTacToe");
       // stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
