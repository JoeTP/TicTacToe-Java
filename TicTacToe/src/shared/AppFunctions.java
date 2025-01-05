package shared;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tictactoe.TicTacToe;
import tictactoe.setting.FXMLSettingController;

/**
 * Here we handle commonly used functions like navigating to another scene.
 */
public abstract class AppFunctions {

    public static void goTo(ActionEvent actionEvent, Parent root) {
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void openPopup(Stage ownerStage, Parent root) {
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initOwner(ownerStage);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();
    }
    
    public static void closePopup(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
