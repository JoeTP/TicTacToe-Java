package tictactoe.gamerecord;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.GameModel;
import records.LaodGame;
import shared.AppFunctions;
import sounds.AudioController;

public class GameRecordController extends GameRecordBase {

    Stage stage;
    GameModel game = null;
    String fileName;
    Integer[][] board;
    int currentStep = 1;

    public GameRecordController(Stage stage, String fileName) {
        this.stage = stage;
        this.fileName = fileName;

        loadGameData();
    }

    private void loadGameData() {
        game = LaodGame.loadGameFromFile(fileName);
        board = game.getBoard();
        playerOneLabel.setText(game.getPlayer());
        playerTwoLabel.setText(game.getRival());
        showBoard(currentStep);

    }

    private void showBoard(int step) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Integer value = board[row][col];
                Button button = getButtonsByRowAndColumn(col, row);
                AudioController.showCharSound();
                if (value != null && value <= step) {
                    button.setStyle("-fx-border-color: #3E5879; -fx-background-color: transparent;");
                    if (value % 2 == 1) {
                        button.setText("X");
                    } else {
                        button.setText("O");
                    }
                    if (value == step) {
                        button.setStyle("-fx-border-color: #3E5879; -fx-background-color: #3E5879; -fx-text-fill: white;"); // Green background, white text
                    }
                } else {
                    button.setText("");
                    button.setStyle("-fx-border-color: #3E5879; -fx-background-color: transparent;");

                }
            }
        }
    }

    private Button getButtonsByRowAndColumn(int c, int r) {
        String key = c + "," + r;

        if ("0,0".equals(key)) {
            return b00;
        }
        if ("0,1".equals(key)) {
            return b01;
        }
        if ("0,2".equals(key)) {
            return b02;
        }
        if ("1,0".equals(key)) {
            return b10;
        }
        if ("1,1".equals(key)) {
            return b11;
        }
        if ("1,2".equals(key)) {
            return b12;
        }
        if ("2,0".equals(key)) {
            return b20;
        }
        if ("2,1".equals(key)) {
            return b21;
        }
        if ("2,2".equals(key)) {
            return b22;
        }

        return null;
    }

    @Override
    protected void handlePreviousBtn(ActionEvent actionEvent) {
        if (currentStep > 1) {
            currentStep--;
            showBoard(currentStep);
        }
    }

   @Override
protected void handleNextBtn(ActionEvent actionEvent) {
    if (currentStep < 9) { 
        boolean hasNextStep = false;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Integer value = board[row][col];
                if (value != null && value > currentStep) {
                    hasNextStep = true;
                    break;
                }
            }
            if (hasNextStep) break;
        }

        if (hasNextStep) {
            currentStep++;
            showBoard(currentStep);
        } else {
            System.out.println("No more steps to display.");
        }
    }
}


    @Override
    protected void handleExitButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }
}
