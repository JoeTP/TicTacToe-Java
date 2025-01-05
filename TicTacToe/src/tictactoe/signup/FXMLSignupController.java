/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signup;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.signin.FXMLSigninController;

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSignupController extends FXMLSignupBase {

    Parent singingParent;
    Stage stage;

    public FXMLSignupController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void goToSignin(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLSigninController(stage));
    }

}
