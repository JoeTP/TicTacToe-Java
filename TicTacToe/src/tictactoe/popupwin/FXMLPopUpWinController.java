package tictactoe.popupwin;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import models.Player;
import shared.AppFunctions;
import shared.AppString;
import tictactoe.gameboard.GameBoardController;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.popupwin.FXMLPopUpWinBase;

public class FXMLPopUpWinController extends FXMLPopUpWinBase {

    Stage stage;
    Player playerOne;
    Player playerTwo;

    public static MediaPlayer mediaPlayer;

    public FXMLPopUpWinController(Stage stage, Boolean isWinner, Player playerOne, Player playerTwo) {
        this.stage = stage;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        showPopup(isWinner);

    }

    public void showPopup(boolean isWinner) {

        //winOrLosePopUp.setVisible(true);
        if (isWinner) {

            winAndLoseLabel.setText(AppString.WIN_LABLE);
            congratsLable.setText(AppString.CONGRATS);
            rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
            leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

            Media loadVideo = new Media(this.getClass().getResource(AppString.WIN_VIDEO_URL).toExternalForm());
            mediaPlayer = new MediaPlayer(loadVideo);

            mediaPlayer.setVolume(0.5);
            mediaPlayer.play();
            winOrLoseVideo.setMediaPlayer(mediaPlayer);

        } else {

            winAndLoseLabel.setText(AppString.LOSE_LABLE);
            congratsLable.setText(AppString.BAD_LUCK);
            rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
            leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));

            mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.WIN_VIDEO_URL).toExternalForm()));
            winOrLoseVideo.setMediaPlayer(mediaPlayer);

            mediaPlayer.setVolume(0.5);
            mediaPlayer.play();

        }
    }

    @Override
    protected void handleSaveGameButton(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handlePlayAgainButton(ActionEvent actionEvent) {
        AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOne, playerTwo));
    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        mediaPlayer.pause();

        AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));
    }

}
