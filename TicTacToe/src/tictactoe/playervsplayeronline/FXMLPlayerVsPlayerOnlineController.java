/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayeronline;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */

public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase  {



    Stage stage;

    public FXMLPlayerVsPlayerOnlineController(Stage stage) {
        this.stage = stage;
    }

    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    

}