/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.setting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSettingController extends FXMLSettingBase implements Initializable {

    private Stage stage;

    public FXMLSettingController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Pane accountDetailsPane;

    @FXML
    private VBox accountHeaderVBox;

    private boolean isDetailsVisible = false;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        accountDetailsPane.setVisible(false);
        accountHeaderVBox.setOnMouseClicked(event -> {
            isDetailsVisible = !isDetailsVisible;
            accountDetailsPane.setVisible(isDetailsVisible);
        });

    }

    @Override
    protected void handleBackBtn(ActionEvent actionEvent) {
            AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));
    }

}
