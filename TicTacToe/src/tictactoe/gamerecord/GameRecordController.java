/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gamerecord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.homescreen.FXMLHomeScreenController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class GameRecordController extends GameRecordBase {
   Stage stage;

     public GameRecordController(Stage stage) {
        this.stage = stage;  
    }  

    @Override
    protected void handleExitButton(ActionEvent actionEvent) {
        AudioController.clickSound();
       AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));
    }

    
}
