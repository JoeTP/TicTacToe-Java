/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

import clientconnection.Client;
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
import javafx.stage.Stage;
import json.JSONConverters;
import models.DataModel;
import models.UserModel;
import shared.AppFunctions;
import shared.*;
import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;
import tictactoe.signup.FXMLSignupController;

public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;

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

    @Override

    protected void goToActiveUsers(ActionEvent actionEvent) {
        try {
            Client c = new Client();
            System.out.println("" + c.serverStatus);
            c.connectToServer();
            if (c.serverStatus == false) {  //connect
                System.out.println("connect connection");
                UserModel user = new UserModel();
                
                user.setName(usernameTextField.getText());
                user.setPassword(passwordField.getText());
                System.out.println("AL --before sendLoginRequest " + user.getName());
                DataModel data = new DataModel(user, 2);
                System.out.println("get state : " + data.getState());
                boolean response = false;
                System.out.println("get state : " + data.getState());
                System.out.println("get user and state " + data.getUser().getName());
                // String jsonRequest = JSONConverters.DataModelToJson(data);
                // System.out.println("jsonRequest " + jsonRequest);
                try {
                    
                    c.sendData(data);
                    
                    try {
                        
                        response = c.receveResponse();
                        
                    } catch (SocketTimeoutException e) {
                        System.out.println("Server Timeout. Please try again.");
                    } catch (IOException ex) {
                        System.out.println("Connection failed. Please check the server.");
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (response==true) {
                    System.out.println("response: should be true :" + response);
                    
                    //user = JSONConverters.jsonToUserModel(response);
                    AppFunctions.closeAndGo(actionEvent, stage);
                    
                } else {
                    System.out.println("should be failure " + response);
                    
                    wrongLabel.setVisible(true);
                    wrongLabel.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
                    wrongLabel.setText("Please Enter Correct Info");
                    
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
