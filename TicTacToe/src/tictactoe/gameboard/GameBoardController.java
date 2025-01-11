package tictactoe.gameboard;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.Player;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne;
    private Player playerTwo;

    public GameBoardController(Stage stage) {
        this.stage = stage;

    }

    @Override
    protected void handleSendButton(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));
    }
}
