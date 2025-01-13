/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signup;

import clientconnection.ClientConnection;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.DataModel;
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
        UserModel user = getNewUserData();
        if (user != null) {
            DataModel data = new DataModel(user, 1);

            // Start a new thread for background operations
            new Thread(() -> {
                ClientConnection client = new ClientConnection();
                boolean response = false;
                try {
                    // Perform network operations
                    client.connectToServer();
                    client.sendData(data);
                    response = client.receveResponse();
                    System.out.println("Received response: " + response); // Debugging output
                } catch (IOException ex) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                        alert.showAndWait();
                    });
                    ex.printStackTrace();
                    return; // Exit the thread early on failure
                }
                boolean finalResponse = response;
                System.out.println("Final response: " + finalResponse); // Debugging output
                // Update the UI on the JavaFX Application Thread
                Platform.runLater(() -> {
                    System.out.println("Updating UI with finalResponse: " + finalResponse); // Debugging output
                    if (finalResponse) {
                        try {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signup was successful.");
                            alert.showAndWait();
                            AppFunctions.closePopup(actionEvent);
                            AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage, client));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username or email are already used.");
                        alert.showAndWait();
                        AppFunctions.closePopup(actionEvent);
                        AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage, client));
                    }
                });
            }).start(); // Start the background thread
        }
    }

    /*
@Override
protected void goToActiveUsers(ActionEvent actionEvent) {
        UserModel user = getNewUserData();
        if (user != null) {
            DataModel data = new DataModel(user, 1);
            // Start a new thread for background operations
            new Thread(() -> {
                ClientConnection client = new ClientConnection();
                boolean response = false;
                try {
                    // Perform network operations
                    client.connectToServer();
                    client.sendData(data);
                    response = client.receveResponse();
                    System.out.println("Received response: " + response); // Debugging output
                } catch (IOException ex) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't connect to server.");
                        alert.showAndWait();
                    });
                    ex.printStackTrace();
                    return; // Exit the thread early on failure
                }
                boolean finalResponse = response;
                System.out.println("Final response: " + finalResponse); // Debugging output

                // Update the UI on the JavaFX Application Thread
                Platform.runLater(() -> {
                    System.out.println("Updating UI with finalResponse: " + finalResponse); // Debugging output
                    if (finalResponse) {
                        try {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Signup was successful.");
                            alert.showAndWait();
                            AppFunctions.closePopup(actionEvent);
                            AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage,client));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username or email are already used.");
                        alert.showAndWait();
                        AppFunctions.closePopup(actionEvent);
                      //  AppFunctions.goTo(actionEvent, new FXMLPlayerVsPlayerOnlineController(stage));
                    }
                });
            }).start();
        }
    }
     */
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
}
