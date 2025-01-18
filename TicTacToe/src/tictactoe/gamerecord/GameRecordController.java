/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gamerecord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import models.GameModel;
import records.LaodGame;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gameboard.GameBoardController;
import tictactoe.historypopup.RecordListPopUpController;
import tictactoe.homescreen.FXMLHomeScreenController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class GameRecordController extends GameRecordBase {

    Stage stage;
    GameModel game = null;
    String fileName;

    public GameRecordController(Stage stage,String fileName) {
        this.stage = stage;
        this.fileName=fileName;
    }

    @Override
    protected void handleExitButton(ActionEvent actionEvent) {
        AudioController.clickSound();

        AppFunctions.closePopup(actionEvent);
    }

    protected void getDataFromFile() {
       game = LaodGame.loadGameFromFile(fileName);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game.getBoard()[i][j] + " ");
            }
            System.out.println(" ");
        }
        
        
        
    }

}
