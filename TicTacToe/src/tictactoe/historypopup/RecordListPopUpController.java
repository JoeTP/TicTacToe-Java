/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.historypopup;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gamerecord.GameRecordController;
import tictactoe.setting.FXMLSettingController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class RecordListPopUpController extends HistoryListBase {

    Stage stage;
    int count = 0;

    public RecordListPopUpController(Stage stage) {
        this.stage = stage;
        showList();
    }

    protected void showList() {
        listView.getItems().addAll(
                "Game 3 Date 17-1-2024 12:19",
                "Game 2 Date 17-1-2024 18:19",
                "Game 6 Date 17-1-2024 10:19");
        
    }

    @Override
    protected void handleCellClick(MouseEvent mouseEvent) {
        
        String selectedItem = listView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {

            count++;

            System.out.println("count : " + count);
        }
          AudioController.clickSound();
          AppFunctions.goTo(mouseEvent, new GameRecordController(stage));
    }

}
