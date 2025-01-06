package tictactoe.offlinegameboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class FXMLOfflineGameBoardController extends FXMLOfflineGameBoardBase {

    Stage stage;

    public FXMLOfflineGameBoardController(Stage stage) {
        this.stage = stage;
    }
}
