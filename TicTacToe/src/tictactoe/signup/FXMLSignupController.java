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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.UserModel;
import shared.AppFunctions;
import static shared.AppString.ICON_PATHS;
import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
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

    @Override
    protected void goToActiveUsers(ActionEvent actionEvent) {
        UserModel user = new UserModel();
        user = getNewUserData();
        System.out.println(user.getName()+"\n"+user.getEmail()+"\n"+user.getPassword()+"\n"+user.getImage());
        //AppFunctions.closePopup(actionEvent);
        //AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage));
    }

    @Override
    protected void showPreviousIcon(ActionEvent actionEvent) {
        currentImageIndex = (currentImageIndex - 1 + ICON_PATHS.length) % ICON_PATHS.length;
        characterImageView.setImage(new Image(ICON_PATHS[currentImageIndex]));
    }

    @Override
    protected void showNextIcon(ActionEvent actionEvent) {
        currentImageIndex = (currentImageIndex + 1 ) % ICON_PATHS.length;
        characterImageView.setImage(new Image(ICON_PATHS[currentImageIndex]));
        
    }
    protected UserModel getNewUserData(){
        UserModel user = new UserModel();
        user.setName(usernameTextField.getText());
        user.setEmail(emailTextField.getText());
        user.setImage(Integer.toString(currentImageIndex));
        user.setPassword(passwordField.getText());
        return user;
    }
}
