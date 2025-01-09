/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.onlinegmaeboard;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.popupwin.FXMLPopUpWinController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class FXMLGameBoardOnlineController extends FXMLGameBoardOnlineBase {

    private Stage stage;

    public FXMLGameBoardOnlineController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void winOrLossPopup(ActionEvent actionEvent) {
        //go back to this line later
        //AppFunctions.openPopup(stage, new FXMLPopUpWinController(stage, false));
        AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));

    }

}
