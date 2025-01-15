/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;

import clientconnection.ClientConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.UserModel;
import static shared.AppConstants.CONNECTION_FLAG;
import shared.AppFunctions;
import shared.AppString;
import sounds.AudioController;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.playervsplayerpopup.FXMLPlayerVsPlayerPopupController;
import tictactoe.setting.FXMLSettingController;
import tictactoe.signin.FXMLSigninController;

/**
 * FXML Controller class
 *
 * @author Youssif
 */
public class FXMLHomeScreenController extends FXMLHomeScreenBase {

    Stage stage;
    private double xOffset;
    private double yOffset;
    ClientConnection client;

    public FXMLHomeScreenController(Stage stage) {
        this.stage = stage;
        observeConnection();
    }

    private void observeConnection() {
        if (CONNECTION_FLAG == null) {
            CONNECTION_FLAG = new SimpleBooleanProperty(false);
        }
        chatBtn.disableProperty().bind(CONNECTION_FLAG.not());
        accInfoRect.visibleProperty().bind(CONNECTION_FLAG);
        CONNECTION_FLAG.addListener((observable, oldValue, newValue) -> {
            //to keep updating
            updateConnectionLabel();
        });

        //applied on initial
        updateConnectionLabel();
    }

    private void updateConnectionLabel() {
        Platform.runLater(() -> {
            if (CONNECTION_FLAG.get()) {
                nameLabel.setText(ClientConnection.user.getName());
                wonGamesLabel.setText(ClientConnection.user.getWins() + "");
                playedGamesLabel.setText(ClientConnection.user.getNumOfGames() + "");
                profileImageView.setImage(new Image(AppString.ICON_PATHS[Integer.parseInt(ClientConnection.user.getImage())]));
                connectionIndicatorImageView.setImage(new Image("/assets/icons/Wifi-on.png"));
                connectionLabel.setText(AppString.ONLINE);
            } else {
                nameLabel.setText("FAIL");
                connectionIndicatorImageView.setImage(new Image("/assets/icons/Wifi-off.png"));
                connectionLabel.setText(AppString.OFFLINE);
            }
        });

    }

    @Override
    protected void exitApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    protected void openSettingsScreen(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.goTo(actionEvent, new FXMLSettingController(stage));
    }

    @Override
    protected void openPlayerVsComputerPopup(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.openPopup(stage, new FXMLPlayerVsCompController(stage));
    }

    @Override
    protected void openPlayerVsPlayerPopup(ActionEvent actionEvent) {
        AudioController.clickSound();
        AppFunctions.openPopup(stage, new FXMLPlayerVsPlayerPopupController(stage));
    }

    @Override
    protected void openChat(ActionEvent actionEvent) {
        AudioController.clickSound();
        CONNECTION_FLAG.set(false);

    }

    @Override
    protected void dragWindow(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
    }

    @Override
    protected void getOffset(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }

    @Override
    public void handleSignInButton(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLSigninController(stage, true));
    }

    @Override
    protected void handleHistoryButton(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleLogoutButton(ActionEvent actionEvent) {
        if (ClientConnection.user != null) {
            ClientConnection.terminateClient();
            CONNECTION_FLAG.set(false);
        }
    }
}
