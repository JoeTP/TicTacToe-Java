/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoeserver.gui.FXMLServerController;

public class MainServer extends Application {

    
    @Override
    public void start(Stage stage) {
        Parent root = new FXMLServerController();
        Scene scene = new Scene(root);
      //  scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
