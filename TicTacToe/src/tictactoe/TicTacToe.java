/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import tictactoe.homescreen.FXMLHomeScreenController;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;

/**
 *
 * @author Youssif
 */
public class TicTacToe extends Application {

    private double xOffset = 0.0;
    private double yOffset = 0.0;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new FXMLHomeScreenController();
        
        
        Scene scene = new Scene(root);

       //stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
