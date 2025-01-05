/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervscomp;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.offlinegameboard.FXMLOfflineGameBoardController;


public class FXMLPlayerVsCompController extends FXMLPlayerVsCompBase {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    Stage stage;    

    public FXMLPlayerVsCompController(Stage stage) {
        this.stage = stage;
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
     @FXML
    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        
        AppFunctions.goTo(actionEvent, new FXMLOfflineGameBoardController(stage));
        
    }
    @FXML
    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }
}