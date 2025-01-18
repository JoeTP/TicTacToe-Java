/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayerlocal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import models.Player;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gameboard.GameBoardController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLPlayerVsPlayerLocalController extends FXMLPlayerVsPlayerLocalBase {

    /**
     * Initializes the controller class.
     */
    private final Stage stage;

    public FXMLPlayerVsPlayerLocalController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerPopupController(stage));
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOneTextField.getText(), playerTwoTextField.getText(), "local"));

    }

}
