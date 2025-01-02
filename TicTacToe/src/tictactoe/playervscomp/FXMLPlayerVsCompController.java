/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervscomp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLPlayerVsCompController extends FXMLPlayerVsCompBase implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public FXMLPlayerVsCompController() {
        handlingDifficultySlider();
    }
    
    private void handlingDifficultySlider(){
        ChangeListener<Number> difficultyChangeListener =(observable, oldValue, newValue)->{
        switch((int)newValue.intValue()){
            case 0:
                difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/easy.png")));
                break;
            case 1:
                difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/norml.png")));
                break;
            case 2:
                difficultyImg.setImage(new Image(getClass().getResourceAsStream("/assets/icons/extreme.png")));
                break;
        }
        };
        difficultySlider.valueProperty().addListener(difficultyChangeListener);
    }
}
