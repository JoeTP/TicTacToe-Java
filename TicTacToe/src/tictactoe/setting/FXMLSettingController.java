/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.setting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSettingController extends FXMLSettingBase implements Initializable {

    @FXML
    private Pane accountDetailsPane;

    @FXML
    private VBox accountHeaderVBox;

    private boolean isDetailsVisible = false;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        // Set initial state
        accountDetailsPane.setVisible(false);

        // Toggle visibility on click
        accountHeaderVBox.setOnMouseClicked(event -> {
            isDetailsVisible = !isDetailsVisible;
            accountDetailsPane.setVisible(isDetailsVisible);
        });

    }

}
