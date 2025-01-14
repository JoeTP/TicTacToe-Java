package tictactoe.playervsplayeronline;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.oos;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.DataModel;
import shared.AppFunctions;
import tictactoe.gameboard.GameBoardController;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;

    ClientConnection client;

    public FXMLPlayerVsPlayerOnlineController(Stage stage, ClientConnection client) {
        //this.client = c;
        this.stage = stage;
        this.client = client;
        getActiveUsers();
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

    protected void getActiveUsers() {
        new Thread(() -> {
            try {
                oos.writeObject(new DataModel(3));
                Object obj = ois.readObject();
                if (obj instanceof ObservableList) {
                    ObservableList<String> activeUsers = (ObservableList<String>) obj;
                    Platform.runLater(() -> {
                        activePlayersListView.getItems().addAll(activeUsers);
                    });
                }

            } catch (IOException ex) {
                Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

    }

}
