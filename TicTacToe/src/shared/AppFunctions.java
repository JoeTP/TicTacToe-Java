package shared;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public abstract class AppFunctions {

    public static List<Stage> stages = new ArrayList<>();

    public static void goTo(ActionEvent actionEvent, Parent root) {
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void goTo(MouseEvent actionEvent, Parent root) {
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void goToGameBoard(Stage ownerStage, Parent root) {
        Scene scene = new Scene(root);
        Stage stage = ownerStage;
        stage.setScene(scene);
        stage.show();
    }

    public static void openPopup(Stage ownerStage, Parent root) {
        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.initStyle(StageStyle.DECORATED.UNDECORATED);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.setScene(new Scene(root));
        newStage.initOwner(ownerStage);
        newStage.show();
        double centerXPosition = ownerStage.getX() + ownerStage.getWidth() / 2d - newStage.getWidth() / 2d;
        double centerYPosition = ownerStage.getY() + ownerStage.getHeight() / 2d - newStage.getHeight() / 2d;
        newStage.setX(centerXPosition);
        newStage.setY(centerYPosition);
        stages.add(newStage);
        System.out.println("#OF STAGES = " + stages.size());
    }

    public static void closePopup(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stages.remove(stage);
        System.out.println("#OF STAGES = " + stages.size());
    }

    public static void closeAndGo(ActionEvent actionEvent, Stage stage, Parent root) {
        if (actionEvent != null) {
            closePopup(actionEvent);
        }
        stage.setScene(new Scene(root));
    }

    public static void closeAllStages() {
        stages.forEach(stage -> stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST)));
    }

    public static void closeAllStagesExcept(Stage primaryStage) {
        List<Stage> stagesToClose = new ArrayList<>(stages);
        stagesToClose.remove(primaryStage);
        stagesToClose.forEach(stage -> stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST)));
        stages.clear();
        stages.add(primaryStage);
    }
}
