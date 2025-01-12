package tictactoe.gameboard;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
=======
>>>>>>> 6aa3bb7b2d3e1bfd00c67d2a212f5aaa1e402acd
import javafx.scene.layout.GridPane;
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
   // private int[] winPattern = new int[3];
      int[] flatPlaces = new int[9];
    private int[][] places = new int[3][3];
    private boolean isEndOfGame = false;
 
    // private int[] winPattern = new int[3];
    int[] flatPlaces = new int[9];
    private int[][] board = new int[3][3];

    
    private final int[][] winPatterns = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //  rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //   columns
        {0, 4, 8}, {2, 4, 6} // diagonals
    };

    private final String x = "X";
    private final String o = "O";
    private int move = 1;

    /*
        [b00 b01 b02]
        [b10 b11 b12]
        [b20 b21 b22]
     */
    
    public GameBoardController(Stage stage) {
        this.stage = stage;

        //this is static but we need to make the user randomly be player one or two
        //now player one is always starting
        playerOne.setChar(x);
        playerTwo.setChar(o);
        playerOne.hisTurn = true;
        prinMoves();

    }

    /*
        [1 2 3]
        [4 5 6]
        [7 8 9] 
     */
    private void setTurn(Button b) {
        if (b.getText() == "") {
            if (playerOne.hisTurn) {
                b.setText(x);
            } else {
                b.setText(o);
            }
            playerTwo.hisTurn = !playerTwo.hisTurn;
            playerOne.hisTurn = !playerOne.hisTurn;

            Integer c = GridPane.getColumnIndex(b);
            Integer r = GridPane.getRowIndex(b);
            fillBoard(r, c);
        }

        prinMoves();

        String winner = checkWinner(board);
        if (playerOne.getChar() == winner) {
            //draw line for winner and do popup
            System.out.println("PLAYER ONE WINNER");
        } else if (playerTwo.getChar() == winner) {
            //draw line for winner and do popup   
            System.out.println("PLAYER TWO WINNER");
        } else if (move == 9) {
            //its draw (no line) and do popup
            System.out.println("NO WINNER ITS DRAW");
        }
    }

    /*
    if winPatern have 3 evens in consequence
     */
    private Player checkWinner() {  
       //test case
       /*
        1 2 3    
        4 6 5 
        7 8 0 
       */
       // 1 2 3 4 6 5 7 8 0 
       boolean even = false;
       boolean odd = false;
       
         for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                flatPlaces[row * 3 + col] = places[row][col];
            }
        }

        for (int[] pattern : winPatterns) {
            int a = flatPlaces[pattern[0]]; //if one of predefind win patterns is EXIST in sequence i the flat arr ]
            int b = flatPlaces[pattern[1]];
            int c = flatPlaces[pattern[2]];
            System.out.println(a + " " + b + " " +c );
            if (a != 0 && b != 0 && c != 0 && a % 2 == b % 2 && b % 2 == c % 2) {
                even = true;
             }else  if (a != 0 && b != 0 && c != 0 && a % 2 != b % 2 && b % 2 != c % 2){
                odd = true;
            }
            if(even){
            System.out.println("End of the game");// needd to be Handeld
                System.out.println("winner is even number =>  Second {OO} player wins");
                endGame(o, flatPlaces);
                return playerTwo;  
            }
            if (odd){
                endGame(x, flatPlaces);
                System.out.println("winner is ODDn number =>  Fisrts {XX} player wins");
                return playerOne;  
            }
        }
        return null; // Drawwwww
    }

    private void endGame(String winner, int winningPlaces[]){
        isEndOfGame = true;
        drawWinningLine(winningPlaces);
        System.out.println("End of the game, Winner is" + winner);
        
    }
    
    private void drawWinningLine(int winningPlaces[]){
       
        winingLine.setStartX(10 );
        winingLine.setStartY(10);
        winingLine.setEndX(winningPlaces[2]);
        winingLine.setEndY(winningPlaces[2]);
        
        winingLine.setTranslateX(winningPlaces[1]);
        winingLine.setTranslateY(winningPlaces[1]);
        
        winingLine.setVisible(true);
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

    private void prinMoves() {
        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[i][c] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private String checkWinner(int[][] board) {
        if (move >= 5) {
            for (int i = 0; i < 3; i++) {
                //rows
                if (checkLine(board[i][0], board[i][1], board[i][2])) {
                    //get the winner in the current itration
                    return getWinnerCharacter(board[i][0]);
                }
                //columns
                if (checkLine(board[0][i], board[1][i], board[2][i])) {
                    return getWinnerCharacter(board[0][i]);
                }
            }
            if (checkLine(board[0][0], board[1][1], board[2][2])) {
                return getWinnerCharacter(board[0][0]);
            }
            if (checkLine(board[0][2], board[1][1], board[2][0])) {
                return getWinnerCharacter(board[0][2]);
            }
        }
        //last condition if no winner
        return null;
    }

    public String checkRowsAndColumns(int[][] board) {
        for (int i = 0; i < 3; i++) {
            //rows
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                //get the winner in the current itration
                return getWinnerCharacter(board[i][0]);
            }
            //columns
            if (checkLine(board[0][i], board[1][i], board[2][i])) {
                return getWinnerCharacter(board[0][i]);
            }
        }
        return null;
    }

    /*
                    [x - -] [- - x]
                    [- x -] [- x -]
                    [- - x] [x - -]
     */
    public String checkDiagonals(int[][] board) {
        if (checkLine(board[0][0], board[1][1], board[2][2])) {
            return getWinnerCharacter(board[0][0]);
        }
        if (checkLine(board[0][2], board[1][1], board[2][0])) {
            return getWinnerCharacter(board[0][2]);
        }
        return null;
    }

    private boolean checkLine(int a, int b, int c) {
        return (a % 2 == b % 2) && (b % 2 == c % 2);
    }

    private String getWinnerCharacter(int value) {
        //return the value of the 1st itration
        return (value % 2 == 0) ? x : o;
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
