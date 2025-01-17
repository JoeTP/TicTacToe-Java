package tictactoe.playervscomp;

import difficulty.EasyLevel;
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

    Stage stage;
    private Player playerOne = new Player();
    private Player playerTwo = new ComputerPlayer();
    public static ComputerPlayer comp;
    public static int level = 0;

    public FXMLPlayerVsCompController(Stage stage) {
        this.stage = stage;
        setDifficultyLabels();
        handlingDifficultySlider();

    }

    private void handlingDifficultySlider() {
        ChangeListener<Number> difficultyChangeListener = (observable, oldValue, newValue) -> {
            switch ((int) newValue.intValue()) {
                case 0:
                    level = 0;
                    difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/easy.png")));
                    System.out.println("in easy slider ");
                    break;
                case 1:
                    level = 1;
                    difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/norml.png")));
                    break;
                case 2:
                    level = 2;
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
        System.out.println("Level is " + level);
        AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOne.getName(), playerTwo.getName() ,"computer"));
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
