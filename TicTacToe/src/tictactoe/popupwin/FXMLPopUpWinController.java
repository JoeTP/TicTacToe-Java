package tictactoe.popupwin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import shared.AppString;
import tictactoe.popupwin.FXMLPopUpWinBase;

public class FXMLPopUpWinController extends FXMLPopUpWinBase{

    
    Stage stage;

    public FXMLPopUpWinController(Stage stage, Boolean isWinner) {
        this.stage = stage;

        showPopup(isWinner);
    }

    public void showPopup(boolean isWinner) {

        //winOrLosePopUp.setVisible(true);
        if (isWinner) {
            winAndLoseLabel.setText(AppString.WIN_LABLE);
            winnerImg.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
        } else {
            winAndLoseLabel.setText(AppString.LOSE_LABLE);
            winnerImg.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
        }
    }

}
