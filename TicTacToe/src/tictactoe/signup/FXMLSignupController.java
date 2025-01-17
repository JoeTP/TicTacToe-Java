/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signup;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.listeningThread;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.socket;
import static clientconnection.ClientConnection.startListeningThread;

import static clientconnection.ClientConnection.user;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.DataModel;
import models.UserModel;
import static shared.AppConstants.CONNECTION_FLAG;
import shared.AppFunctions;
import shared.AppString;
import static shared.AppString.ICON_PATHS;
import static shared.AppString.TOOLTIP;
import sounds.AudioController;
import tictactoe.playervsplayerlocal.FXMLRequestToPlayController;
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
    public ClientConnection client;
    int currentImageIndex;

    public FXMLSignupController(Stage stage) {
        this.stage = stage;
        characterImageView.setImage(new Image(ICON_PATHS[currentImageIndex]));
        Tooltip.install(helperImageView, new Tooltip(TOOLTIP));
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void goToSignin(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.goTo(actionEvent, new FXMLSigninController(stage, true));
    }

    @Override

    protected void goToActiveUsers(ActionEvent actionEvent) {

        ClientConnection.user = getNewUserData();

        AudioController.clickSound();

        if (user != null) {
            DataModel data = new DataModel(user, 1);
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
            Thread th = new Thread(() -> {

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
                    return; // Exit the thread early on failure
                }

                String finalResponse = response;
                Platform.runLater(() -> {
                    if (finalResponse.equals(AppString.SIGNUP_DONE)) {
                        try {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signup was successful.");
                            alert.showAndWait();
                            if (!FXMLSigninController.signInFromHomeScreen) {
                                AppFunctions.closePopup(actionEvent);
                                AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage, client));
                            } else {
                                AppFunctions.closePopup(actionEvent);

                            }
                            CONNECTION_FLAG.set(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username or email are already used.");
                        alert.showAndWait();
                        ClientConnection.terminateClient();
                    }
                });
                if (finalResponse.equals(AppString.SIGNUP_DONE)) {
                    ClientConnection.startListeningThread();
                }
            });
        }

    }

    @Override
    protected void showPreviousIcon(ActionEvent actionEvent) {
        currentImageIndex = (currentImageIndex - 1 + ICON_PATHS.length) % ICON_PATHS.length;
        characterImageView.setImage(new Image(ICON_PATHS[currentImageIndex]));
    }

    @Override
    protected void showNextIcon(ActionEvent actionEvent) {
        currentImageIndex = (currentImageIndex + 1) % ICON_PATHS.length;
        characterImageView.setImage(new Image(ICON_PATHS[currentImageIndex]));

    }

    protected UserModel getNewUserData() {
        UserModel user = new UserModel();
        boolean valid = true;
        String regexPattern = "[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (usernameTextField.getText().length() > 6) {
            user.setName(usernameTextField.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username is smaller than 6 letters.");
            alert.showAndWait();
            valid = false;
        }
        if (emailTextField.getText().matches(regexPattern)) {
            user.setEmail(emailTextField.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid email address");
            alert.showAndWait();
            valid = false;
        }
        if (passwordField.getText().length() > 6) {
            user.setPassword(passwordField.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Password is smaller than 6 letters.");
            alert.showAndWait();
            valid = false;
        }
        user.setImage(Integer.toString(currentImageIndex));
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
