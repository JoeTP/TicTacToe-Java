package shared;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tictactoe.gameboard.GameBoardController;
import tictactoe.offlinegameboard.FXMLOfflineGameBoardController;
import tictactoe.popupwin.FXMLPopUpWinController;

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
        public static void goTo(MouseEvent event, Parent root) {
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void openPopup(Stage ownerStage, Parent root) {
        Stage newStage = new Stage();
        // newStage.initStyle(StageStyle.UNDECORATED);
        newStage.setResizable(false);
        newStage.setScene(new Scene(root));
        newStage.initOwner(ownerStage);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();

    }
    
    public static void openReqPopup( Parent root) {
        Stage newStage = new Stage();
        // newStage.initStyle(StageStyle.UNDECORATED);
        newStage.setResizable(false);
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.show();

    }
    public static void closePopup(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Used with Popups closing it first then go to new scene
     */
    public static void closeAndGo(ActionEvent actionEvent, Stage stage, Parent root) {
        closePopup(actionEvent);
        stage.setScene(new Scene(root));
    }

    
}
