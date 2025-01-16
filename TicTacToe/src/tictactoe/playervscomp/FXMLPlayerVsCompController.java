/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervscomp;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import models.ComputerPlayer;
import models.Player;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gameboard.GameBoardController;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.offlinegameboard.FXMLOfflineGameBoardController;

public class FXMLPlayerVsCompController extends FXMLPlayerVsCompBase {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    Stage stage;

    private Player playerOne = new Player();
    private Player playerTwo = new ComputerPlayer();

    public FXMLPlayerVsCompController(Stage stage) {
        this.stage = stage;
        setDifficultyLabels();
        handlingDifficultySlider();
    }

    private void handlingDifficultySlider() {
        ChangeListener<Number> difficultyChangeListener = (observable, oldValue, newValue) -> {
            switch ((int) newValue.intValue()) {
                case 0:
                    difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/easy.png")));
                    break;
                case 1:
                    difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/norml.png")));
                    break;
                case 2:
                    difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/extreme.png")));
                    break;
            }
        };
        difficultySlider.valueProperty().addListener(difficultyChangeListener);
    }

    @FXML
    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOne, playerTwo));
    }

    @FXML
    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }

    protected void setDifficultyLabels() {

        difficultySlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if (object == 0) {
                    return "Easy";
                }
                if (object == 1) {
                    return "Medium";
                }
                if (object == 2) {
                    return "Extreme";
                }
                return String.format("%.0f%%", object);
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
    }

}
