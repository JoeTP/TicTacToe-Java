package tictactoe.popupwin;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import static shared.AppFunctions.openPopup;
import shared.AppString;
import tictactoe.popupwin.FXMLPopUpWinBase;

public class FXMLPopUpWinController extends FXMLPopUpWinBase {

    Stage stage;
    public static MediaPlayer mediaPlayer;

    public FXMLPopUpWinController(Stage stage, Boolean isWinner) {
        this.stage = stage;
        showPopup(isWinner);   
    }


    public void showPopup(boolean isWinner) {

        //winOrLosePopUp.setVisible(true);
        if (isWinner) {
            try {
                winAndLoseLabel.setText(AppString.WIN_LABLE);
                congratsLable.setText(AppString.CONGRATS);
                rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
                leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

                Media loadVideo = new Media(getClass().getResource(AppString.WIN_VIDEO_URL).toURI().toString());
                mediaPlayer = new MediaPlayer(loadVideo);
                mediaPlayer.setAutoPlay(true);
                winOrLoseVideo.setMediaPlayer(mediaPlayer);
                stage.setOnCloseRequest(e -> mediaPlayer.stop());
            } catch (URISyntaxException ex) {
                Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            winAndLoseLabel.setText(AppString.LOSE_LABLE);
            congratsLable.setText(AppString.BAD_LUCK);
            rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
            leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
             mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.WIN_VIDEO_URL).toExternalForm()));
            mediaPlayer.setAutoPlay(true);
            winOrLoseVideo.setMediaPlayer(mediaPlayer);
            stage.setOnCloseRequest(e -> mediaPlayer.stop());

        }
    }

}
