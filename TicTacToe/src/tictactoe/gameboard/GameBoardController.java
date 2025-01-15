package tictactoe.gameboard;

import gameboard.WinningLine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Platform;

import javafx.animation.PauseTransition;

import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Player;
import shared.AppFunctions;
import sounds.AudioController;
import static shared.AppFunctions.openPopup;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.popupwin.FXMLPopUpWinController;

/*TODO:
    - end game when A player wins / draw (9 moves) => show popup 

 */
//https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html
public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private boolean isEndOfGame = false;

    private Timeline timeLine;
    private int countdownTime;
    boolean isTimeOut = false;

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

    public GameBoardController(Stage stage, Player playerOne, Player playerTwo) {
        this.stage = stage;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        assignPlayers();
        changingLabelsStyles();

    }

    private void assignPlayers() {
        playerOneLabel.setText(playerOne.getName());
        playerTwoLabel.setText(playerTwo.getName());

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

        startCountdownTimer();
    }

    private void setTurn(Button b) {
        Media media = null;
        String clickSound = getClass().getResource("/audios/gameClick.wav").toExternalForm();
        String timeOutSound = getClass().getResource("/audios/turnTimeOut.wav").toExternalForm();
        if (b.getText().isEmpty() && isEndOfGame == false) {
            if (isTimeOut == false) {
                media = new Media(clickSound);
            } else {
                media = new Media(timeOutSound);
            }

            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            System.out.println("current char: " + (playerOne.hisTurn ? playerOne.getChar() : playerTwo.getChar()));
            System.out.println("current Move: " + move);
            if (playerOne.hisTurn) {
                b.setText(playerOne.getChar());
            } else {
                b.setText(playerTwo.getChar());
            }
            changingLabelsStyles();

            playerTwo.hisTurn = !playerTwo.hisTurn;
            playerOne.hisTurn = !playerOne.hisTurn;

            Integer c = GridPane.getColumnIndex(b);
            Integer r = GridPane.getRowIndex(b);
            fillBoard(r, c);

            checkPlayerWinner();
            printGame();
            startCountdownTimer();

        }

    }

    private void startCountdownTimer() {
        countdownTime = 7;

        if (timeLine != null) {
            timeLine.stop();   //3l4an law startCountdownTimer 3mnlnlha call multiple time
        }


        if (!isEndOfGame) {
            timeLine = new Timeline(
                    new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
                        timer.setStyle("-fx-text-fill: #3E5879;");
                        timer.setText(" " + countdownTime + "");

                        if (countdownTime < 4) {
                            timer.setStyle("-fx-text-fill: red;");
                        }
                        countdownTime--;
                        if (countdownTime < 0) {
                            timeLine.stop();
                            isTimeOut = true;
                            makeAutomaticMove();
                            timer.setText("Oops! Time is up!");
                        }
                        isTimeOut = false;



                    })
            );
            timeLine.setCycleCount(Timeline.INDEFINITE);
            timeLine.play();
        }
    }

    private Button getButtonsByRowAndColumn(int c, int r) {

        if (c == 0 && r == 0) {
            return b00;
        }
        if (c == 0 && r == 1) {
            return b01;
        }
        if (c == 0 && r == 2) {
            return b02;
        }
        if (c == 1 && r == 0) {
            return b10;
        }
        if (c == 1 && r == 1) {
            return b11;
        }
        if (c == 1 && r == 2) {
            return b12;
        }
        if (c == 2 && r == 0) {
            return b20;
        }
        if (c == 2 && r == 1) {
            return b21;
        }
        if (c == 2 && r == 2) {
            return b22;
        }

        return null;

    }

//    private void makeAutomaticMove() {
//
//        String currentChar = playerOne.hisTurn ? playerOne.getChar() : playerTwo.getChar();
//        System.out.println("automatic char: " + currentChar);
//        System.out.println("automatic Move: " + move);
//
//        for (int r = 0; r < board.length; r++) {
//            for (int c = 0; c < board[r].length; c++) {
//                if (board[r][c] == null) {
//                    // board[r][c] = move; 
//                    Button button = getButtonsByRowAndColumn(c, r);
//                    if (button != null) {
//
//                        System.out.println("insiidee makeAutomaticMove and the button existt");
//                        setTurn(button);
//
//                    } else {
//                        System.out.println("insiidee makeAutomaticMove and the button not existt");
//                    }
//
//                    return;
//                }
//            }
//        }
//        System.out.println("No empty cells available for automatic move.");
//        return;
//    }
    
    
    
    private void makeAutomaticMove() {
        String currentChar = playerOne.hisTurn ? playerOne.getChar() : playerTwo.getChar();
        System.out.println("automatic char: " + currentChar);
        System.out.println("automatic Move: " + move);
        System.out.println("Automatic move caused");
        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    emptyCells.add(new int[]{i, j});
                    System.out.println("nnnull cell at: (" + i + ", " + j + ")");
                }
            }
        }

        if (!emptyCells.isEmpty()) {
            Random random = new Random();
            int[] selectedCell = emptyCells.get(random.nextInt(emptyCells.size()));
            System.out.println("Selected cell for move: (" + selectedCell[0] + ", " + selectedCell[1] + ")");
                  Button button = getButtonsByRowAndColumn(selectedCell[1], selectedCell[0]);
                    if (button != null) {
                          emptyCells.remove(selectedCell);
                        System.out.println("insiidee makeAutomaticMove and the button existt");
                        setTurn(button);
                       

                    } else {
                        System.out.println("insiidee makeAutomaticMove and the button not existt");
                    }

                    return;
          

 
           
           
        } else {
            System.out.println("No empty cells found.");
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



    private void endGame() {

        isEndOfGame = true;
        playerOne.hisTurn = false;
        playerTwo.hisTurn = false;
        timeLine.stop();
        timer.setText("--");
        System.out.println("End of the game");

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
            endGame();
            waitAndShowPopup(winner);
        } else if (playerTwo.getChar() == winner) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);

            System.out.println("PLAYER TWO WINNER");
            endGame();
            waitAndShowPopup(winner);
        } else if (move > 9) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);
            waitAndShowPopup(winner);
        }
    }

    private void waitAndShowPopup(String winnerChar) {
        if (playerOne.getChar() == winnerChar || playerTwo.getChar() == winnerChar) {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                AppFunctions.openPopup(stage, new FXMLPopUpWinController(stage, true, playerOne, playerTwo));
            });

            pause.play();
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

    void changingLabelsStyles() {
        Platform.runLater(() -> {
            if (playerOne.hisTurn) {
                playerOneLabel.setTextFill(Paint.valueOf("#21bd5c")); //green
                playerOneCharacter.setTextFill(Paint.valueOf("#3e5879"));
                playerTwoLabel.setTextFill(Paint.valueOf("#3e5879"));
                playerTwoCharacter.setTextFill(Paint.valueOf("#21bd5c")); //green
            }
            if (playerTwo.hisTurn) {
                playerTwoLabel.setTextFill(Paint.valueOf("#21bd5c")); //green
                playerTwoCharacter.setTextFill(Paint.valueOf("#3e5879"));
                playerOneLabel.setTextFill(Paint.valueOf("#3e5879"));
                playerOneCharacter.setTextFill(Paint.valueOf("#21bd5c")); //green
            }
        });
    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {


        endGame();
        AudioController.clickSound();
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
