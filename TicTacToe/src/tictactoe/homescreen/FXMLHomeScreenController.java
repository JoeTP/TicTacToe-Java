/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import shared.AppFunctions;
import shared.AppString;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.setting.FXMLSettingController;

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

    public FXMLHomeScreenController(Stage stage) {
        this.stage = stage;
        //stage.initStyle(StageStyle.DECORATED.UNDECORATED);

        dragWindow();
        checkConnection();
        setLogo();
    }

    public FXMLHomeScreenController(Stage stage, boolean isOffline) {
        this.isOffline = isOffline;
        this.stage = stage;
       // stage.initStyle(StageStyle.DECORATED.UNDECORATED);

        dragWindow();
        checkConnection();
        setLogo();
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
            connectionLabel.setText(AppString.OFFLINE);
            profileImageView.setImage(new Image(getClass().getResourceAsStream("/assets/icons/profile.png")));
        } else {
            imgPath = "/assets/icons/online.png";
            chatBtn.setDisable(isOffline);
            connectionLabel.setText(AppString.ONLINE);
            ///TODO: get the user profile image from server
            profileImageView.setImage(new Image(getClass().getResourceAsStream("/assets/icons/profile.png")));
        }
        image = new Image(getClass().getResourceAsStream(imgPath));

        connectionIndicatorImageView.setImage(image);
    }

    void dragWindow() {

        header.setOnMousePressed((event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        header.setOnMouseDragged((event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    @Override
    protected void exitApp(ActionEvent actionEvent) {
        Platform.exit();
    }

    @Override
    protected void openChat(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void openSettingsScreen(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLSettingController(stage));
    }

    @Override
    protected void openPlayerVsComputerPopup(ActionEvent actionEvent) {
        AppFunctions.pop( stage, new FXMLPlayerVsCompController());
    }

    @Override
    protected void openPlayerVsPlayerPopup(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
