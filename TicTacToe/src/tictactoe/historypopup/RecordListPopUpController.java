/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.historypopup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gamerecord.GameRecordController;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class RecordListPopUpController extends HistoryListBase {

    Stage stage;
    private int count = 0;
    private List<String> fileNames = new ArrayList<>();

    public RecordListPopUpController(Stage stage) {
        this.stage = stage;
        showList();
    }

protected void showList() {
        
        listView.getItems().clear();

        
        File folder = new File("records");
        if (folder.exists() && folder.isDirectory()) {
           File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName());
                }
            }
        }

        
        listView.getItems().addAll(fileNames);
    }

    @Override
    protected void handleCellClick(MouseEvent mouseEvent) {
        String selectedItem = listView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            count++;
            System.out.println("count : " + count);
        }

        
        AudioController.clickSound();
        AppFunctions.goTo(mouseEvent, new GameRecordController(stage, selectedItem));  
    }

}
