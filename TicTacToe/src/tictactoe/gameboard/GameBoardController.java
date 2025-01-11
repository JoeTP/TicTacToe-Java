package tictactoe.gameboard;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Player;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    private int[][] places = new int[3][3];
    private final String x = "X";
    private final String o = "O";

    public GameBoardController(Stage stage) {
        this.stage = stage;

        //this is static but we need to make the user randomly be player one or two
        //now player one is always starting
        playerOne.setChar(x);
        playerTwo.setChar(o);
        playerOne.hisTurn = true;
    }

    /*
        [1 2 3]
        [4 5 6]
        [7 8 9] 
     */
    //here we handle filling the array too
    private void setTurn(Button b) {
        if (b.getText() == "") {
            if (playerOne.hisTurn) {
                b.setText(x);
            } else {
                b.setText(o);
            }
            playerTwo.hisTurn = !playerTwo.hisTurn;
            playerOne.hisTurn = !playerOne.hisTurn;
        }
    }

    //    @Override
    //    protected void handleSendButton(ActionEvent actionEvent) {
    //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));
    }

    @Override
    protected void handleB22(ActionEvent actionEvent) {
        setTurn(b22);
    }

    @Override
    protected void handleB20(ActionEvent actionEvent) {
        setTurn(b20);
    }

    @Override
    protected void handleB12(ActionEvent actionEvent) {
        setTurn(b12);
    }

    @Override
    protected void handleB02(ActionEvent actionEvent) {
        setTurn(b02);
    }

    @Override
    protected void handleB21(ActionEvent actionEvent) {
        setTurn(b21);
    }

    @Override
    protected void handleB01(ActionEvent actionEvent) {
        setTurn(b01);
    }

    @Override
    protected void handleB10(ActionEvent actionEvent) {
        setTurn(b10);
    }

    @Override
    protected void handleB11(ActionEvent actionEvent) {
        setTurn(b11);
    }

    @Override
    protected void handleB00(ActionEvent actionEvent) {
        setTurn(b00);
    }
}
