/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.onlinegmaeboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.popupwin.FXMLPopUpWinController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLGameBoardOnlineController extends FXMLGameBoardOnlineBase implements Initializable {
    
    private Stage stage;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public FXMLGameBoardOnlineController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void winOrLossPopup(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLPopUpWinController(stage, false));
    }
    
}
