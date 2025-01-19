package tictactoe.popupwin;

import static clientconnection.ClientConnection.startListeningThread;
import static clientconnection.ClientConnection.user;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import static clientconnection.ClientConnection.user;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.ComputerPlayer;
import models.GameModel;
import models.Player;
import records.SaveGame;
import shared.AppFunctions;
import shared.AppString;
import tictactoe.gameboard.GameBoardController;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.popupwin.FXMLPopUpWinBase;

public class FXMLPopUpWinController extends FXMLPopUpWinBase {

    Stage stage;
    Player playerOne;
    Player playerTwo;
    MediaPlayer mediaPlayer;
    String mode;

    public FXMLPopUpWinController(Stage stage, String roundState, Player playerOne, Player playerTwo, String mode) {
        this.stage = stage;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.mode = mode;
        System.out.println("Round State string : " + roundState);
        showPopup(roundState, mode);

    }

    private void showPopup(String roundState, String mode) {

        if (roundState.equals("draw")) {
            displayDraw();
            return;
        }
        switch (mode) {

            case "local": {

                if (roundState.equals("X")) {
                    displayWin(playerOne.getName());
                    break;
                } else {
                    displayWin(playerTwo.getName());
                    break;
                }

            }
            case "computer": {

                if (roundState.equals("computer")) {
                    displayLose();
                    break;
                } else {
                    displayWin(playerOne.getName());
                    break;
                }
            }
            case "online": {

                if (roundState.equals("X")) {
                    if (playerOne.getName().equals(user.getName())) {
                        user.updateUserData(true);
                        displayWin(playerOne.getName());

                    } else {
                        displayLose();
                        user.updateUserData(false);

                    }
                    break;
                } else {

                    if (playerTwo.getName().equals(user.getName())) {
                        user.updateUserData(true);
                        displayWin(playerTwo.getName());
                    } else {
                        displayLose();
                        user.updateUserData(false);

                    }
                    break;
                }

            }

        }
    }

    private void displayWin(String playerName) {
        System.out.println("RWinnner is === " + playerName);
        winAndLoseLabel.setStyle("-fx-text-fill: #21bd5c;");
        winAndLoseLabel.setText(playerName + " Win!");
        congratsLable.setText(AppString.CONGRATS);
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        Media loadVideo = new Media(this.getClass().getResource(AppString.WIN_VIDEO_URL).toExternalForm());
        mediaPlayer = new MediaPlayer(loadVideo);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        winOrLoseVideo.setMediaPlayer(mediaPlayer);
    }

    private void displayLose() {

        winAndLoseLabel.setStyle("-fx-text-fill: #99003d;");
        winAndLoseLabel.setText("You Lost!");
        congratsLable.setText("OH NOOO!!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    private void displayDraw() {
        winAndLoseLabel.setText("It's DRAW ");
        congratsLable.setText("OH No Winner!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    @Override
    protected void handleSaveGameButton(ActionEvent actionEvent) {
        SaveGame.saveGameToFile(GameBoardController.gameModel);
        mediaPlayer.pause();

    }

    @Override
    protected void handlePlayAgainButton(ActionEvent actionEvent
    ) {
        mediaPlayer.pause();
        AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOne.getName(), playerTwo.getName(), mode));

    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        mediaPlayer.pause();
        AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));
        if (mode.equals("online")) {
            startListeningThread();
        }
    }

}
