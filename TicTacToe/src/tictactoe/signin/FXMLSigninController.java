/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signin;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.socket;
import static clientconnection.ClientConnection.user;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import models.DataModel;
import models.UserModel;
import shared.AppFunctions;

import shared.*;
import static shared.AppConstants.CONNECTION_FLAG;
import static shared.AppString.TOOLTIP;
import sounds.AudioController;
import static tictactoe.TicTacToe.appStage;

import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;
import tictactoe.signup.FXMLSignupController;

public class FXMLSigninController extends FXMLSigninBase {

    Stage stage;
    public static ClientConnection client;

    public static boolean signInFromHomeScreen;

    public FXMLSigninController(Stage stage, boolean state) {

        this.stage = stage;
        this.signInFromHomeScreen = state;
        Tooltip.install(helperImageView, new Tooltip(TOOLTIP));

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

            System.out.println("User is not null" + user.getName());
            DataModel data = new DataModel(user, 2);
            client = new ClientConnection();
            try {
                client.connectToServer();
            } catch (IOException ex) {
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                    double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                    double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                    alert.initOwner(appStage);
                    alert.setOnShown(e -> {
                        alert.setX(centerXPosition);
                        alert.setY(centerYPosition);
                    });
                    alert.showAndWait();
                });
                ex.printStackTrace();
                return;
            }
            Thread th = new Thread(() -> {

                String response = "";

                try {
                    client.sendData(data);
                    DataModel newData = ClientConnection.receveData();
                    user = newData.getUser();
                    response = newData.getResponse();
                    System.out.println(response);
                } catch (IOException ex) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                        double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                        double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                        alert.initOwner(appStage);
                        alert.setOnShown(e -> {
                            alert.setX(centerXPosition);
                            alert.setY(centerYPosition);
                        });
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
                                double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                                double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                                alert.initOwner(appStage);
                                alert.setOnShown(e -> {
                                    alert.setX(centerXPosition);
                                    alert.setY(centerYPosition);
                                });
                                alert.showAndWait();
                                if (!signInFromHomeScreen) {
//                                    AppFunctions.closeAndGo(actionEvent, stage, new FXMLPlayerVsPlayerOnlineController(stage, client));
                                    AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage, client));
                                } else {
                                    AppFunctions.closePopup(actionEvent);
                                }
                                CONNECTION_FLAG.set(true);
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ClientConnection.startListeningThread();
                        break;
                    case AppString.SIGNIN_ALREADY_FOUND:
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are logged in from another device");
                            double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                            double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                            alert.initOwner(appStage);
                            alert.setOnShown(e -> {
                                alert.setX(centerXPosition);
                                alert.setY(centerYPosition);
                            });
                            alert.showAndWait();
                            ClientConnection.terminateClient();
                        });
                        break;
                    default:
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username or password are incorrect.");
                            double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                            double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                            alert.initOwner(appStage);
                            alert.setOnShown(e -> {
                                alert.setX(centerXPosition);
                                alert.setY(centerYPosition);
                            });
                            alert.showAndWait();
                            ClientConnection.terminateClient();
                        });
                        break;
                }
            });
            th.start();
//            try {
//                th.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(FXMLSigninController.class.getName()).log(Level.SEVERE, null, ex);
//            }
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
                double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                alert.initOwner(appStage);
                alert.setOnShown(e -> {
                    alert.setX(centerXPosition);
                    alert.setY(centerYPosition);
                });
                alert.showAndWait();
                valid = false;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username is smaller than 6 letters.");
            double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
            double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
            alert.initOwner(appStage);
            alert.setOnShown(e -> {
                alert.setX(centerXPosition);
                alert.setY(centerYPosition);
            });
            alert.showAndWait();
            valid = false;
        }
        if (valid) {
            return user;
        } else {
            return null;

        }

    }

    @Override
    protected void handleConnectToServerButton(ActionEvent actionEvent) {
        try {
            if (ipTextField != null) {
                ClientConnection.SERVER_IP = ipTextField.getText();
                ClientConnection.connectToServer();
                System.out.println(socket);
            }
            if (socket != null) {
                helperImageView.setImage(new Image("/assets/icons/Accept.png"));
            }
        } catch (IOException ex) {
            helperImageView.setImage(new Image("/assets/icons/cancel.png"));
        }
    }
}
