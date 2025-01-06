/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayeronline;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */

public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase  {

    private Stage stage;

    public FXMLPlayerVsPlayerOnlineController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new FXMLGameBoardOnlineController(stage));
    }

    

}
