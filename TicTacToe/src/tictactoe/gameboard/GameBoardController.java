package tictactoe.gameboard;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Player;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

/*TODO:
    - end game when A player wins / draw (9 moves) => show popup 
    - draw line for winner 
 */
public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private boolean isEndOfGame = false;
    String startLine;
    String endLine;

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
        }
    }

    private void endGame(String winner, int winningPlaces[]) {
        isEndOfGame = true;
        System.out.println("End of the game, Winner is" + winner);

    }

    private void drawWinningLine(String startLine, String endLine) {
        int r1 = getRow(startLine);
        int c1 = getCol(startLine);
        int r2 = getRow(endLine);
        int c2 = getCol(endLine);
        //start point
        double btnWidth = grid.getWidth() / 3;
        double btnHeight = grid.getHeight() / 3;

        double gridX = grid.getLayoutX();
        double gridY = grid.getLayoutY();

        double x1 = gridX + (c1 * btnWidth) + btnWidth / 2;
        double y1 = gridY + (r1 * btnHeight) + btnHeight / 2;

        double x2 = gridX + (c2 * btnWidth) + btnWidth / 2;
        double y2 = gridY + (r2 * btnHeight) + btnHeight / 2;

        Line line = new Line(x1, y1, x2, y2);
        anchorPane.getChildren().add(line);

        line.setStroke(Color.GREENYELLOW.darker());
        line.setStrokeWidth(5);
        line.setVisible(true);

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
            drawWinningLine(getStartLine(), getEndLine());
            //do popup
            System.out.println("PLAYER ONE WINNER");
        } else if (playerTwo.getChar() == winner) {
            drawWinningLine(getStartLine(), getEndLine());
            //do popup
            System.out.println("PLAYER TWO WINNER");
        } else if (move > 9) {
            drawWinningLine(getStartLine(), getEndLine());
            //do popup
            System.out.println("NO WINNER ITS DRAW");
        }
    }

    private int getCol(String btnString) {
        char c = btnString.charAt(1);
        int col = Character.getNumericValue(c);
        return col;
    }

    private int getRow(String btnString) {
        char r = btnString.charAt(0);
        int row = Character.getNumericValue(r);
        return row;
    }

    private void setStartLine(String s) {
        startLine = s;
    }

    private void setEndLine(String s) {
        endLine = s;
    }

    private String getStartLine() {
        return startLine;
    }

    private String getEndLine() {
        return endLine;
    }

    private String checkWinnerChar(Integer[][] board) {

        if (move > 5) {
            for (int i = 0; i < 3; i++) {
                //rows
                if (checkLine(board[i][0], board[i][1], board[i][2])) {
                    //get the winner in the current itration
                    setStartLine(i + "0"); // extract index off BUTTONS
                    setEndLine(i + "2");
                    return getWinnerCharacter(board[i][0]);
                }
                //columns
                if (checkLine(board[0][i], board[1][i], board[2][i])) {
                    setStartLine("0" + i);
                    setEndLine("2" + i);
                    return getWinnerCharacter(board[0][i]);
                }
            }
            if (checkLine(board[0][0], board[1][1], board[2][2])) {
                setStartLine("00");
                setEndLine("22");
                return getWinnerCharacter(board[0][0]);
            }
            if (checkLine(board[0][2], board[1][1], board[2][0])) {
                setStartLine("02");
                setEndLine("20");
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
