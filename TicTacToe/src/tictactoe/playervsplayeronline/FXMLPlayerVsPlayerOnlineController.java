package tictactoe.playervsplayeronline;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.DataModel;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

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
         AudioController.clickSound();
      
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
         AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new FXMLGameBoardOnlineController(stage));
    }

    @Override
    protected void handlerefreshBtn(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
