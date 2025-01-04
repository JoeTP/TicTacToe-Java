
package tictactoe.popupwin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tictactoe.popupwin.FXMLPopUpWinBase;


public class FXMLPopUpWinController extends FXMLPopUpWinBase implements Initializable {
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
    Stage stage;


   
  public FXMLPopUpWinController(Stage stage,Boolean isWinner){
     this.stage=stage;
     
showPopup(isWinner);
 }
           public void showPopup(boolean isWinner) {
 
       //winOrLosePopUp.setVisible(true);

   
        if (isWinner) {
            winAndLoseLabel.setText("🎉Congratulations!You Win!");
            winnerImg.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
        } else {
            winAndLoseLabel.setText("     😢 Oops! You Lose! 😢");
            winnerImg.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
        }
    }
    
    
}
