package shared;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.TicTacToe;
import tictactoe.setting.FXMLSettingController;

/**
 * Here we handle commonly used functions like navigating to another scene.
 */
public abstract class AppFunctions {

    public static void goTo(ActionEvent actionEvent, Parent root){
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
