/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayerpopup;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.playervsplayerlocal.FXMLPlayerVsPlayerLocalController;
import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.signup.FXMLSignupController;
/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLPlayerVsPlayerPopupController extends FXMLPlayerVsPlayerPopupBase{
    Stage stage;

    public FXMLPlayerVsPlayerPopupController(Stage stage) {
      this.stage = stage;  
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void handleLocalButton(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerLocalController(stage));
    }

    @Override
    protected void handleOnlineButton(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLSignupController(stage));

    }

    /**
     * Initializes the controller class.
     */
      
    
}
