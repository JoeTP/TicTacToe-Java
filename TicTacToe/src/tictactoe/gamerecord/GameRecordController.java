package tictactoe.gamerecord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        getDataFromFile();
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
        fillBoard(game);
        
        
        
    }
     public void fillBoard(GameModel game) {
    
        Integer[][] board = game.getBoard();

        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                
                Integer value = board[row][col];
                
                
                Button button = getButtonsByRowAndColumn(col, row);

                
                if (value != null) {
                    if (value %2 == 0) {
                        button.setText("O"); 
                    } else {
                        button.setText("X"); 
                    }
                } else {
                    button.setText(""); 
                }
            }
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

    @Override
    protected void handlePreviousBtn(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleNextBtn(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
