/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayerlocal;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tictactoe.playervsplayerlocal.FXMLRequestToPlayBase;

public class FXMLRequestToPlayController extends FXMLRequestToPlayBase {

    @FXML
    private Button acceptBtn;
    @FXML
    private Button declineBtn;
    @FXML
    private Text playerNameTextField;

    public FXMLRequestToPlayController(String rival) {
        playerNameTextField.setText(rival);
    }

    /**
     * Initializes the controller class.
     */
    
}
