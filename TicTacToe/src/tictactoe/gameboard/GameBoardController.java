package tictactoe.gameboard;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;

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
