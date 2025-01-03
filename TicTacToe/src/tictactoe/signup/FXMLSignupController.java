/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ayat Gamal
 */
public class FXMLSignupController extends FXMLSignupBase   {

    Parent singingParent;

    public FXMLSignupController() {
        try {
            goToSignin();
        } catch (IOException ex) {
            Logger.getLogger(FXMLSignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @FXML
    public void goToSignin() throws IOException {
        signinBtn.setOnAction((event) -> {

            System.out.println("im here in scener FSITSt");
            try {
                singingParent = FXMLLoader.load(getClass().getResource("/tictactoe/signin/FXMLSignin.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FXMLSignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene signinScene = new Scene(singingParent);
            Stage signinStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("im here in scener");
            signinStage.setScene(signinScene);
            signinStage.show();
        });
    }
}
