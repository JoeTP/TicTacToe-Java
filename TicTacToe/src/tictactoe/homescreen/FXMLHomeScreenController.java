/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssif
 */
public class FXMLHomeScreenController extends FXMLHomeScreenBase {

    boolean isOffline;
    Stage stage;
    private double xOffset;
    private double yOffset;

    public FXMLHomeScreenController(Stage stage,boolean isOffline) {
        this.isOffline = isOffline;
        this.stage = stage;
        
        
        setLogo();
        checkConnection();
        exitApp();
        dragWindow();
    }

    void setLogo() {
        logoImageViewer.setImage(new Image(getClass().getResourceAsStream("/assets/icons/logo.png")));
    }

    void checkConnection() {
        Image image;
        String imgPath;
        if (isOffline) {
            imgPath = "/assets/icons/offline.png";
            chatBtn.setDisable(isOffline);
            connectionLabel.setText("Offline");
            profileImageView.setImage(new Image(getClass().getResourceAsStream("/assets/icons/profile.png")));
        } else {
            imgPath = "/assets/icons/online.png";
            chatBtn.setDisable(isOffline);
            connectionLabel.setText("Online");
            ///TODO: get the user profile image from server
            profileImageView.setImage(new Image(getClass().getResourceAsStream("/assets/icons/profile.png")));
        }
        image = new Image(getClass().getResourceAsStream(imgPath));

        connectionIndicatorImageView.setImage(image);
    }

    void exitApp() {
        exitBtn.setOnAction((event) -> Platform.exit());
    }

    void dragWindow() {

        header.setOnMousePressed((event)->{
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        header.setOnMouseDragged((event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }
}
