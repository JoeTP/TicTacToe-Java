package tictactoe.gameboard;

import gameboard.WinningLine;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Player;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.popupwin.FXMLPopUpWinController;

/*TODO:
    - end game when A player wins / draw (9 moves) => show popup 
    - draw line for winner 
 */
public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private boolean isEndOfGame = false;
    //  String startLine;
    //String endLine;

    /*
        [b00 b01 b02]
        [b10 b11 b12]
        [b20 b21 b22]
     */
    private Integer[][] board = new Integer[3][3];

    private final String X_CHAR = "X";
    private final String O_CHAR = "O";
    private int move = 1;

    public GameBoardController(Stage stage) {
        this.stage = stage;
        assignPlayers();
    }

    private void assignPlayers() {
        Random random = new Random();
        if (random.nextBoolean()) {
            playerOne.setChar(X_CHAR);
            playerTwo.setChar(O_CHAR);
            playerOne.hisTurn = true;
        } else {
            playerOne.setChar(O_CHAR);
            playerTwo.setChar(X_CHAR);
            playerTwo.hisTurn = true;
        }
    }

    private void setTurn(Button b) {
        if (b.getText().isEmpty()) {
            if (playerOne.hisTurn) {
                b.setText(playerOne.getChar());
            } else {
                b.setText(playerTwo.getChar());
            }
            playerTwo.hisTurn = !playerTwo.hisTurn;
            playerOne.hisTurn = !playerOne.hisTurn;

            Integer c = GridPane.getColumnIndex(b);
            Integer r = GridPane.getRowIndex(b);
            fillBoard(r, c);

            checkPlayerWinner();
            printGame();
        }

    }

    private void printGame() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private void endGame(String winner) {
        isEndOfGame = true;
        System.out.println("End of the game, Winner is" + winner);

    }

    private void setPlayerXMove() {

    }

    private void setPlayerOMove() {

    }

    private void traceMoves(Integer r, Integer c) {
    }

    private void fillBoard(Integer r, Integer c) {
        if (r == null) {
            r = 0;
        }
        if (c == null) {
            c = 0;
        }
        board[r][c] = move;
        move++;
    }

    private void checkPlayerWinner() {
        String winner = checkWinnerChar(board);
        if (playerOne.getChar() == winner) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);
            System.out.println("PLAYER ONE WINNER");
            AppFunctions.waitAndShowPopup(stage, this.getScene(), true);

        } else if (playerTwo.getChar() == winner) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);
            System.out.println("PLAYER TWO WINNER");
            AppFunctions.waitAndShowPopup(stage, this.getScene(), true);

        } else if (move > 9) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);
            AppFunctions.waitAndShowPopup(stage, this.getScene(), true);
        }
    }

    private String checkWinnerChar(Integer[][] board) {

        if (move > 5) {
            for (int i = 0; i < 3; i++) {
                //rows
                if (checkLine(board[i][0], board[i][1], board[i][2])) {
                    //get the winner in the current itration
                    WinningLine.setStartLine(i + "0"); // extract index off BUTTONS
                    WinningLine.setEndLine(i + "2");
                    return getWinnerCharacter(board[i][0]);
                }
                //columns
                if (checkLine(board[0][i], board[1][i], board[2][i])) {
                    WinningLine.setStartLine("0" + i);
                    WinningLine.setEndLine("2" + i);
                    return getWinnerCharacter(board[0][i]);
                }
            }
            if (checkLine(board[0][0], board[1][1], board[2][2])) {
                WinningLine.setStartLine("00");
                WinningLine.setEndLine("22");
                return getWinnerCharacter(board[0][0]);
            }
            if (checkLine(board[0][2], board[1][1], board[2][0])) {
                WinningLine.setStartLine("02");
                WinningLine.setEndLine("20");
                return getWinnerCharacter(board[0][2]);
            }
        }
        //last condition if no winner
        return null;
    }

//    public String checkRowsAndColumns(int[][] board) {
//        for (int i = 0; i < 3; i++) {
//            //rows
//            if (checkLine(board[i][0], board[i][1], board[i][2])) {
//                //get the winner in the current itration
//                return getWinnerCharacter(board[i][0]);
//            }
//            //columns
//            if (checkLine(board[0][i], board[1][i], board[2][i])) {
//                return getWinnerCharacter(board[0][i]);
//            }
//        }
//        return null;
//    }

    /*
                    [x - -] [- - x]
                    [- x -] [- x -]
                    [- - x] [x - -]
     */
//    public String checkDiagonals(int[][] board) {
//        if (checkLine(board[0][0], board[1][1], board[2][2])) {
//            return getWinnerCharacter(board[0][0]);
//        }
//        if (checkLine(board[0][2], board[1][1], board[2][0])) {
//            return getWinnerCharacter(board[0][2]);
//        }
//        return null;
//    }
    private boolean checkLine(Integer a, Integer b, Integer c) {
        if (a == null || b == null || c == null) {
            return false;
        }
        boolean state = ((a % 2 == b % 2) && (b % 2 == c % 2));
        return state;
    }

    private String getWinnerCharacter(int value) {
        //return the value of the 1st itration
        return (value % 2 == 0) ? X_CHAR : O_CHAR;
    }

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
