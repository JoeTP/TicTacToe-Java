package tictactoe.offlinegameboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.homescreen.FXMLHomeScreenController;

public class FXMLOfflineGameBoardController extends FXMLOfflineGameBoardBase {

    Stage stage;

    public FXMLOfflineGameBoardController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void handleLeaveBtn(ActionEvent actionEvent) {
        AppFunctions.goTo(actionEvent, new FXMLHomeScreenController(stage));
    }
    
    
}
