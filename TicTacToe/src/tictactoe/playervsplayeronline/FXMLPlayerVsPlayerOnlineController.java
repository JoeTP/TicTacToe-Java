package tictactoe.playervsplayeronline;

import clientconnection.ClientConnection;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.gameboard.GameBoardController;

 
public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;
   
    ClientConnection client;

    public FXMLPlayerVsPlayerOnlineController(Stage stage) {
        //this.client = c;
        this.stage = stage;

       // startListeningForUpdates();
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new GameBoardController(stage));
    }

    @Override
    protected void handlerefreshBtn(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
