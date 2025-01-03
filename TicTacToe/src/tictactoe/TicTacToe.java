/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.signin.FXMLSigninController;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.signup.FXMLSignupController;

/**
 *
 * @author Youssif
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       //Parent root = new FXMLSigninController();       
      // Parent root = new FXMLPlayerVsCompController();        
       Parent root = new FXMLSignupController();        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
