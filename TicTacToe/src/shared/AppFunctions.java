package shared;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        newStage.initStyle(StageStyle.DECORATED.UNDECORATED);
        newStage.setResizable(false);
        newStage.setScene(new Scene(root));
        newStage.initOwner(ownerStage);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();
    }

    public static void closePopup(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Used with Popups
     * closing it first then go to new scene
     */
    public static void closeAndGo(ActionEvent actionEvent, Parent root) {
        closePopup( actionEvent);
        goTo(actionEvent, root);
    }

}
