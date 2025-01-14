/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayerpopup;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.playervsplayerlocal.FXMLPlayerVsPlayerLocalController;
import tictactoe.signin.FXMLSigninController;
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
         AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void handleLocalButton(ActionEvent actionEvent) {
         AudioController.clickSound();
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerLocalController(stage));
    }

    @Override
    protected void handleOnlineButton(ActionEvent actionEvent) {

         AudioController.clickSound();

        AppFunctions.goTo(actionEvent, new FXMLSigninController(stage,true));


    }
}
