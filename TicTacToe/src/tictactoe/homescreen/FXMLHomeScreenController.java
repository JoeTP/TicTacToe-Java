/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Youssif
 */
public class FXMLHomeScreenController extends FXMLHomeScreenBase {

    boolean isOffline;

    public FXMLHomeScreenController(boolean isOffline) {
        this.isOffline = isOffline;

        setLogo();
        checkConnection();
        exitApp();
    }

    void setLogo() {
        Image logo = new Image(getClass().getResourceAsStream("/assets/icons/logo.png"));
        logoImageViewer.setImage(logo);
    }

    void checkConnection() {
        Image image;
        String imgPath;
        if (isOffline) {
            imgPath = "/assets/icons/offline.png";
            chatBtn.setDisable(isOffline);
            connectionLabel.setText("Offline");
        } else {
            imgPath = "/assets/icons/online.png";
            chatBtn.setDisable(isOffline);
            connectionLabel.setText("Online");
        }
        image = new Image(getClass().getResourceAsStream(imgPath));

        connectionIndicatorImageView.setImage(image);
    }

    void exitApp() {
        exitBtn.setOnAction((event) -> Platform.exit());
    }

}
