/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.socket;
import static clientconnection.ClientConnection.user;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import json.JSONConverters;
import models.DataModel;
import models.UserModel;
import shared.AppFunctions;

import shared.*;
import static shared.AppConstants.CONNECTION_FLAG;
import sounds.AudioController;

import tictactoe.gameboard.GameBoardController;

import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;
import tictactoe.signup.FXMLSignupController;

public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;
    public ClientConnection client;

    boolean signInFromInside;

    public FXMLSigninController(Stage stage, boolean state) {

        this.stage = stage;
        this.signInFromInside = state;

    }

    @Override
    public void goToSignup(ActionEvent event) {
        AudioController.clickSound();
        AppFunctions.goTo(event, new FXMLSignupController(stage));
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerPopupController(stage));
    }

    protected void goToActiveUsers(ActionEvent actionEvent) {
        ClientConnection.user = getNewUserData();

        AudioController.clickSound();

        if (user != null) {

            System.out.println("User is not null"+ user.getName());
            DataModel data = new DataModel(user, 2);
            client = new ClientConnection();
            try {
                client.connectToServer();
            } catch (IOException ex) {
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                    alert.showAndWait();
                });
                ex.printStackTrace();
                return;
            }
            new Thread(() -> {

                String response = "";


                try {
                    client.sendData(data);
                    DataModel newData = ClientConnection.receveData();
                    user = newData.getUser();
                    response = newData.getResponse();
                } catch (IOException ex) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                        alert.showAndWait();
                    });
                    ex.printStackTrace();
                    return;
                }
                String finalResponse = response;

                switch (finalResponse) {
                    case AppString.SIGNIN_DONE:                        
                        try {
                            Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signin was successful.");
                                alert.showAndWait();
                                AppFunctions.closePopup(actionEvent);
                                CONNECTION_FLAG.set(true);
                                AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage, client));
                            });
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }   break;
                    case AppString.SIGNIN_ALREADY_FOUND:
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are logged in from another device");
                            alert.showAndWait();
                            ClientConnection.terminateClient();
                        }); break;
                    default:
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username or password are incorrect.");
                            alert.showAndWait();
                            ClientConnection.terminateClient();
                        }); break;
                }

            }).start();
        }
    }

    protected UserModel getNewUserData() {
        UserModel user = new UserModel();
        boolean valid = true;
        if (usernameTextField.getText().length() >= 6) {
            user.setName(usernameTextField.getText());
            if (passwordField.getText().length() >= 6) {
                user.setPassword(passwordField.getText());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Password is smaller than 6 letters.");
                alert.showAndWait();
                valid = false;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username is smaller than 6 letters.");
            alert.showAndWait();
            valid = false;
        }
        if (valid) {
            return user;
        } else {
            return null;

        }

    }
}
