package tictactoe.gameboard;

import difficulty.EasyLevel;
import difficulty.ExtremeLevel;
import difficulty.MediumLevel;
import gameboard.WinningLine;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import models.ComputerPlayer;
import models.GameModel;
import models.Player;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.homescreen.FXMLHomeScreenController;

import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.popupwin.FXMLPopUpWinController;

/*TODO:
    - end game when A player wins / draw (9 moves) => show popup 
 */
//https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html
public class GameBoardController extends FXMLGameBoardBase {

    Stage stage;
    private Player playerOne;
    private Player playerTwo;
    public static GameModel gameModel;
    private boolean isEndOfGame = false;
    // public static boolean isOnline=false;
    private Timeline timeLine;
    private int countdownTime;
    boolean isTimeOut = false;

    private double xOffset;
    private double yOffset;

    /*
        [b00 b01 b02]
        [b10 b11 b12]
        [b20 b21 b22]
     */
    private Integer[][] board = new Integer[3][3];

    private final String X_CHAR = "X";
    private final String O_CHAR = "O";
    private int move = 1;

    private String mode;

    public GameBoardController(Stage stage, String playerOne, String playerTwo, String mode) {
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.stage = stage;
        this.playerOne.setName(playerOne);
        System.out.println("in constr player1 = " + playerOne);
        this.playerTwo.setName(playerTwo);
        System.out.println("in constr player2 = " + playerTwo);

        this.mode = mode;

        if ("computer".equals(mode)) {

            this.playerTwo = new ComputerPlayer();
        }
        assignPlayers(mode);
        changingLabelsStyles();

    }

    private void assignPlayers(String mode) {

        playerOne.setChar(X_CHAR);
        playerTwo.setChar(O_CHAR);

        switch (mode) {
            case "computer": {

                playerOneLabel.setText("You");
                playerOneChar.setText(playerOne.getChar());

                playerTwoLabel.setText("Computer");
                playerTwoChar.setText(playerTwo.getChar());

            }

            break;
            case "local": {

                playerTwo.setChar(O_CHAR);
                playerOneLabel.setText(playerOne.getName());
                playerOneChar.setText(playerOne.getChar());

                playerTwoLabel.setText(playerTwo.getName());
                playerTwoChar.setText(playerTwo.getChar());

            }
            break;
        }

        playerOne.hisTurn = true;
        playerTwo.hisTurn = false;

        startCountdownTimer();
    }

    private void setTurn(Button b) {

        String timeOutSound = getClass().getResource("/audios/turnTimeOut.wav").toExternalForm();

        if (b.getText().isEmpty() && isEndOfGame == false) {
            if (isTimeOut == false) {
                AudioController.clickSound();
            } else {
                Media media = new Media(timeOutSound);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }

            System.out.println("current char: " + (playerOne.hisTurn ? playerOne.getChar() : playerTwo.getChar()));
            System.out.println("current Move: " + move);

            if (playerOne.hisTurn) {
                startCountdownTimer();
                enableButtons();//enable for palyer
                b.setText(playerOne.getChar());
            } else {
                System.out.println("elseeeeeeeeee");
                startCountdownTimer();

                b.setText(playerTwo.getChar());
            }

            playerOne.hisTurn = !playerOne.hisTurn;
            playerTwo.hisTurn = !playerTwo.hisTurn;

            changingLabelsStyles();

            Integer c = GridPane.getColumnIndex(b);
            Integer r = GridPane.getRowIndex(b);
            fillBoard(r, c);

            checkPlayerWinner();

            if (!isEndOfGame) {
                if (playerTwo instanceof ComputerPlayer && playerTwo.hisTurn) {
                    disableButtons();//disable for computer

                    startCountdownTimer();
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.seconds(1.4),
                            event -> {
                                switch (FXMLPlayerVsCompController.level) {
                                    case 0:
                                        System.out.println("level 0");
                                        makeLevel0Move();
                                        break;

                                    case 1:
                                        System.out.println("level 1");

                                        makeLevel1Move();
                                        break;
                                    case 2:
                                        System.out.println("level 2");

                                        makeMaxMinMove();

                                        break;
                                }

                                Platform.runLater(() -> {
                                    enableButtons();
                                });
                            }
                    ));

                    timeline.setCycleCount(1);
                    timeline.play();
                } else {
                    startCountdownTimer();
                }
            }
            printGame();
        }
    }

    //  makeComputerMove();
    private void startCountdownTimer() {
        countdownTime = 8;
        if (timeLine != null) {
            timeLine.stop();   //3l4an law startCountdownTimer 3mnlnlha call multiple time
        }

        if (!isEndOfGame) {
            timeLine = new Timeline(
                    new KeyFrame(Duration.seconds(0.65), (ActionEvent event) -> {
                        timer.setStyle("-fx-text-fill: #3E5879;");
                        timer.setText(" " + countdownTime + "");

                        if (countdownTime < 4) {
                            timer.setStyle("-fx-text-fill: red;");
                        }
                        countdownTime--;

                        if (countdownTime < 0) {
                            timeLine.stop();
                            isTimeOut = true;
                            makeLevel0Move();
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

    private void makeLevel0Move() {
        Integer cP = EasyLevel.moveComputerMove(board);
        Button b = getButtonsByRowAndColumn((cP % 10), (cP / 10));
        setTurn(b);
    }

    private void makeLevel1Move() {
        System.out.println("miduinm heeh");
        Integer cP = MediumLevel.moveComputerMove(board);
        Button b = getButtonsByRowAndColumn((cP % 10), (cP / 10));
        setTurn(b);

    }

    private void makeMaxMinMove() {
        System.out.println("in xtrrrrrrrem");
        int[] cP = ExtremeLevel.getBestMove(board);
        Button b = getButtonsByRowAndColumn(cP[1], cP[0]);
        setTurn(b);

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

        if (playerOne.getChar().equals(winner)) {
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);
            saveDataToGameModel(playerOne.getName());
            System.out.println("PLAYER ONE WINNER");
            endGame();

            waitAndShowPopup(winner);
        } else if (playerTwo.getChar().equals(winner)) {
            if (playerTwo instanceof ComputerPlayer) {

                winner = "computer";
                saveDataToGameModel(winner);
                //  saveDataToGameModel(winner);
            } else {
                saveDataToGameModel(playerTwo.getName());
            }
            WinningLine.drawWinningLine(WinningLine.getStartLine(), WinningLine.getEndLine(), grid);

            System.out.println("PLAYER TWO WINNER");
            endGame();
            waitAndShowPopup(winner);
        } else if (move > 9) {
            winner = "draw";
            saveDataToGameModel(winner);
            endGame();
            waitAndShowPopup(winner);
        }
    }

    private void saveDataToGameModel(String winner) {
        if (playerOne == null || playerTwo == null) {
            System.err.println("Error: Players are not initialized!");
            return;
        }
        System.out.println("Player Two comp : " + playerTwo.getName() + "player One Comp " + playerOne.getName());
        gameModel = new GameModel(1, playerOne.getName(), playerTwo.getName(), winner, DateNow(), board);

        System.out.println("The Game Model created, the cur player: "
                + gameModel.getPlayer()
                + ", the other player: " + gameModel.getRival()
                + ", the winner: " + gameModel.getWinner());
    }

    private Date DateNow() {

        LocalDateTime currentDateTime = LocalDateTime.now();
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private void waitAndShowPopup(String roundState) {

        System.out.println("RS in waitand show : " + roundState + "case");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            AppFunctions.openPopup(stage, new FXMLPopUpWinController(stage, roundState, playerOne, playerTwo, mode));
        });
        pause.play();

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
        return (value % 2 == 0) ? O_CHAR : X_CHAR;
    }

    private void changingLabelsStyles() {
        Platform.runLater(() -> {
            if (playerOne.hisTurn) {
                playerOneLabel.setTextFill(Paint.valueOf("#21bd5c")); //green
                playerOneChar.setTextFill(Paint.valueOf("#21bd5c"));
                playerTwoLabel.setTextFill(Paint.valueOf("#3e5879"));
                playerTwoChar.setTextFill(Paint.valueOf("#3e5879")); //green
            }
            if (playerTwo.hisTurn) {
                playerTwoLabel.setTextFill(Paint.valueOf("#21bd5c")); //green
                playerTwoChar.setTextFill(Paint.valueOf("#21bd5c"));
                playerOneLabel.setTextFill(Paint.valueOf("#3e5879"));
                playerOneChar.setTextFill(Paint.valueOf("#3e5879")); //green
            }
        });
    }

    private void disableButtons() {
        for (Node n : grid.getChildren()) {
            if (n instanceof Button) {
                n.setDisable(true);
            }
        }
    }

    private void enableButtons() {
        for (Node n : grid.getChildren()) {
            if (n instanceof Button) {
                n.setDisable(false);
            }
        }
    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        timeLine.stop();
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

    @Override
    protected void dragWindow(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
    }

    @Override
    protected void getOffset(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }
}
