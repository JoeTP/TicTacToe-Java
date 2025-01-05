/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

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

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;

    public FXMLSigninController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void goToSignup(ActionEvent event)  {

        try {
            System.out.println("im here in scener FSITSt");
            Parent singingParent = FXMLLoader.load(getClass().getResource("/tictactoe/signup/FXMLSignup.fxml"));
            Scene signinScene = new Scene(singingParent);
            Stage signinStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("im here in scener");
            signinStage.setScene(signinScene);
            signinStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

}
