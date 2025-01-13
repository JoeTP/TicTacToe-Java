/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;

import clientconnection.ClientConnection;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static shared.AppConstants.CONNECTION_FLAG;
import shared.AppFunctions;
import shared.AppString;
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

    public FXMLHomeScreenController(Stage stage) {
        this.stage = stage;
        observeConnection();
    }

    private void observeConnection() {
        if (CONNECTION_FLAG == null) {
            CONNECTION_FLAG = new SimpleBooleanProperty(false);
        }
        chatBtn.disableProperty().bind(CONNECTION_FLAG.not());
        CONNECTION_FLAG.addListener((observable, oldValue, newValue) -> {
            //to keep updating
            updateConnectionLabel();
        });

        //applied on initial
        Platform.runLater(this::updateConnectionLabel);
    }

    private void updateConnectionLabel() {
        if (CONNECTION_FLAG.get()) {
            connectionIndicatorImageView.setImage(new Image("/assets/icons/Wifi-on.png"));
            connectionLabel.setText(AppString.ONLINE);
        } else {
            connectionIndicatorImageView.setImage(new Image("/assets/icons/Wifi-off.png"));
            connectionLabel.setText(AppString.OFFLINE);
        }
    }

    @Override
    protected void exitApp(ActionEvent actionEvent) {

        ClientConnection.stopThreads();
        System.exit(0);
    }

    @Override
    protected void openSettingsScreen(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLSettingController(stage));
    }

    @Override
    protected void openPlayerVsComputerPopup(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLPlayerVsCompController(stage));
    }

    @Override
    protected void openPlayerVsPlayerPopup(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLPlayerVsPlayerPopupController(stage));
    }

    @Override
    protected void singIn(ActionEvent actionEvent) {
        AppFunctions.openPopup(stage, new FXMLSigninController(stage));
        CONNECTION_FLAG.set(true);
    }

    @Override
    protected void openChat(ActionEvent actionEvent) {
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
}
