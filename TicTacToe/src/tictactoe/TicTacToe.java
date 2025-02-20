package tictactoe;

import clientconnection.ClientConnection;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import shared.AppString;
import tictactoe.splashscreengui.FXMLSplashScreenController;

public class TicTacToe extends Application {

    public static Stage appStage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {

        appStage = stage;

        Parent root = new FXMLSplashScreenController(appStage);
//        Parent root = new FXMLHomeScreenController(appStage);
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        stage.setTitle(AppString.APP_TITLE);
        stage.getIcons().add(new Image("/assets/icons/icon.png"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @Override
    public void stop() {
        ClientConnection.stopThreads();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
