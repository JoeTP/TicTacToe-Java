/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

import clientconnection.ClientConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

import tictactoe.gameboard.GameBoardController;

import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;
import tictactoe.signup.FXMLSignupController;

public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;

    ClientConnection c = new ClientConnection();

    public FXMLSigninController(Stage stage) {

        this.stage = stage;

    }

    @Override
    public void goToSignup(ActionEvent event) {
        AppFunctions.goTo(event, new FXMLSignupController(stage));
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerPopupController(stage));
    }

    protected void goToActiveUsers(ActionEvent actionEvent) {
        UserModel user = getNewUserData();
        if (user != null) {
            DataModel data = new DataModel(user, 2);

            new Thread(() -> {
                ClientConnection client = new ClientConnection();
                String response = "";

                try {
                    client.connectToServer();
                    client.sendData(data);
                    response = client.receveResponse();
                } catch (IOException ex) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                        alert.showAndWait();
                    });
                    ex.printStackTrace();
                    return; // Exit the thread early on failure
                }

                String finalResponse = response;
                Platform.runLater(() -> {
                    if (finalResponse.equals(AppString.SIGNIN_DONE)) {
                        try {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signin was successful.");
                            alert.showAndWait();
                            AppFunctions.closePopup(actionEvent);
                            AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if(finalResponse.equals(AppString.SIGNIN_ALREADY_FOUND)){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are logged in from another device");
                        alert.showAndWait();
                        ClientConnection.terminateClient();
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username orpassword are incorrect.");
                        alert.showAndWait();
                        ClientConnection.terminateClient();
                    }
                });
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

//    @Override
//    protected void goToActiveUsers(ActionEvent actionEvent) {
//
//        ClientConnection client = new ClientConnection();
//
//        try {
//            client.connectToServer();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("" + client.serverStatus);
//        if (client.serverStatus == false) {  //connect
//            System.out.println("connect connection");
//            UserModel user = new UserModel();
//
//            user.setName(usernameTextField.getText());
//            user.setPassword(passwordField.getText());
//            System.out.println("AL --before sendLoginRequest " + user.getName());
//            DataModel data = new DataModel(user, 2);
//            System.out.println("get state : " + data.getState());
//            boolean response = false;
//
//            System.out.println("get user and state " + data.getUser().getName());
//            System.out.println("get user and state pass " + data.getUser().getPassword());
//
//            try {
//
//                client.sendData(data);
//
//                response = client.receveResponse();
//
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            if (response == true) {
//                System.out.println("response: should be true :" + response);
//
//                //user = JSONConverters.jsonToUserModel(response);
//                AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage));
//
//            } else {
//                System.out.println("should be failure " + response);
//
//                wrongLabel.setVisible(true);
//                wrongLabel.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
//                wrongLabel.setText("Please Enter Correct Info");
//
//            }
//
//            wrongLabel.setVisible(true);
//            wrongLabel.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
//            wrongLabel.setText("Please Enter Correct Info");
//
//        }
//
//    }
}
