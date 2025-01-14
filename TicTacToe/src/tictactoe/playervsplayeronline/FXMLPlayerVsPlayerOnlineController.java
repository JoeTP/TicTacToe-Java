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
import tictactoe.gameboard.GameBoardController;

 
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
                
                oos = new ObjectOutputStream(socket.getOutputStream());
                
                if (oos == null) {
                    throw new IllegalStateException("ObjectOutputStream (oos) is not initialized.");
                }
                client.sendData(new DataModel(3));
                System.out.println("Object successfully written to server.");
                int activeUsersCount = dis.readInt();
                List<String> activeUsers = new ArrayList<>();
                String user;
                for(int i = 0; i < activeUsersCount; i++){
                    user = dis.readUTF();
                    activeUsers.add(user);
                     System.out.println(user);
                }
                
                
                    Platform.runLater(() -> {
                        activePlayersListView.getItems().addAll(activeUsers);
                    });             
            } catch (IOException ex) {
                Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }).start();

    }

}
