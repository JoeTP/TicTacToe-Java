package tictactoeserver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictactoeserver.gui.FXMLServerController;

public class MainServer extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = new FXMLServerController();
        Scene scene = new Scene(root);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        stage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
