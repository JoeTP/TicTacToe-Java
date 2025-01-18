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

    Integer[][] currentBoard = new Integer[3][3]; 
    List<Integer[][]> boardStates = new ArrayList<>(); 
    int currentMoveIndex = 0; 

       public GameRecordController(Stage stage, String fileName) {
        this.stage = stage;
        this.fileName = fileName;
        getDataFromFile();
    }

    @Override
    protected void handleExitButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }

    protected void getDataFromFile() {
        game = LaodGame.loadGameFromFile(fileName);
        generateBoardStates(game);
        showInGameBoard(boardStates.get(currentMoveIndex));
    }

    private void generateBoardStates(GameModel game) {
        Integer[][] board = game.getBoard();
        boardStates.add(copyBoard(board));

        for (int moveIndex = 1; moveIndex <= 9; moveIndex++) {
            Integer[][] newBoard = copyBoard(board);
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (newBoard[row][col] != null && newBoard[row][col] == moveIndex) {
                        if (moveIndex % 2 == 1) {
                            newBoard[row][col] = 1;
                        } else {
                            newBoard[row][col] = 2;
                        }
                    }
                }
            }
            boardStates.add(newBoard);
        }
    }

    private Integer[][] copyBoard(Integer[][] board) {
        Integer[][] newBoard = new Integer[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, 3);
        }
        return newBoard;
    }

    public void showInGameBoard(Integer[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Integer value = board[row][col];
                Button button = getButtonsByRowAndColumn(col, row);

                if (value != null) {
                    if (value == 1) {
                        button.setText("X");
                    } else if (value == 2) {
                        button.setText("O");
                    }
                } else {
                    button.setText("");
                }
            }
        }
    }

    private Button getButtonsByRowAndColumn(int c, int r) {
        String key = c + "," + r;
        switch (key) {
            case "0,0": return b00;
            case "0,1": return b01;
            case "0,2": return b02;
            case "1,0": return b10;
            case "1,1": return b11;
            case "1,2": return b12;
            case "2,0": return b20;
            case "2,1": return b21;
            case "2,2": return b22;
            default: return null;
        }
    }

    @Override
    protected void handlePreviousBtn(ActionEvent actionEvent) {
              AudioController.clickSound();
        if (currentMoveIndex > 0) {
            currentMoveIndex--;
            currentBoard = boardStates.get(currentMoveIndex);
            showInGameBoard(currentBoard);
        }
    }

    @Override
    protected void handleNextBtn(ActionEvent actionEvent) {
              AudioController.clickSound();
        if (currentMoveIndex < boardStates.size() - 1) {
            currentMoveIndex++;
            currentBoard = boardStates.get(currentMoveIndex);
            showInGameBoard(currentBoard);
        }
    }
    }

    
   


