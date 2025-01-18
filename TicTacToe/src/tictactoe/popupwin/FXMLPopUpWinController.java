package tictactoe.popupwin;

import static clientconnection.ClientConnection.startListeningThread;
import static clientconnection.ClientConnection.user;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;

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
        showPopup(roundState);

    }

    private void showPopup(String roundState) {

        //winOrLosePopUp.setVisible(true);
        switch (roundState) {
            case "X":
                if(playerOne.getName().equals("You")){
                    displayWin(playerOne.getName());
                    break;
                }
                
                if (playerOne.getName().equals(user.getName()) ) {
                    displayWin(playerOne.getName());
                } else {
                    displayLose();
                }
                break;
            case "O":
                if (playerTwo.getName().equals(user.getName())) {
                    displayWin(playerTwo.getName());

                } else {
                    displayLose();
                }
                break;
            case "computer":
                    displayLose();
            break;
            case "draw":
                displayDraw();
                break;
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
        congratsLable.setText("OH,NOooo!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    private void displayDraw() {
        winAndLoseLabel.setText("It's DRAW ");
        congratsLable.setText("OH, No Winner!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    @Override
    protected void handleSaveGameButton(ActionEvent actionEvent) {
        saveGameInFileGson(GameBoardController.gameModel);
        mediaPlayer.pause();

    }

    protected void saveGameInFileGson(GameModel game) {
        SaveGame.saveGameToFile(game);
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
        startListeningThread();
    }

}
