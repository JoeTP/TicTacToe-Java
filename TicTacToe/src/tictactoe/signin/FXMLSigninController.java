/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

import clientconnection.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.signup.FXMLSignupController;

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;
    Client c = new Client();

    public FXMLSigninController(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void goToSignup(ActionEvent event) {

        AppFunctions.goTo(event, new FXMLSignupController(stage));

    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void goToActiveUsers(ActionEvent actionEvent) {//sign in button

        c.connectToServer();
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage));
    }

}
