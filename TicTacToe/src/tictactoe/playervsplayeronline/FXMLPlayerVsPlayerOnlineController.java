package tictactoe.playervsplayeronline;

import clientconnection.ClientConnection;


import static clientconnection.ClientConnection.dis;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.ps;
import static clientconnection.ClientConnection.socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
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

import sounds.AudioController;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

import tictactoe.gameboard.GameBoardController;


 
public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;

    ClientConnection client;

    public FXMLPlayerVsPlayerOnlineController(Stage stage, ClientConnection client) {
        //this.client = c;
        this.stage = stage;
        this.client = client;
        getActiveUsers();
        
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
        AppFunctions.goTo(actionEvent, new GameBoardController(stage));
    }

    @Override
    protected void handlerefreshBtn(ActionEvent actionEvent) {
        getActiveUsers();
    }

    protected void getActiveUsers() {
        new Thread(() -> {
            try {
                if (oos == null) {
                    throw new IllegalStateException("ObjectOutputStream (oos) is not initialized.");
                }
                client.sendData(new DataModel(ClientConnection.user,3));
                System.out.println("Object successfully written to server.");
                int activeUsersCount = ois.readInt();
                System.out.println(activeUsersCount);
                List<String> activeUsers = new ArrayList<>();
                String user;
                for(int i = 0; i < activeUsersCount-1; i++){
                    user = ois.readUTF();
                    activeUsers.add(user);
                    System.out.println(user);
                }
                    Platform.runLater(() -> {
                        activePlayersListView.getItems().clear();
                        activePlayersListView.getItems().addAll(activeUsers);
                    });             
            } catch (IOException ex) {
                Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }).start();

    }
    protected void sendGameRequest(){
        String rival = (String) activePlayersListView.getSelectionModel().getSelectedItem();
        
    }
}
