package tictactoe.playervsplayeronline;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.activeUsers;

import static clientconnection.ClientConnection.dis;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.ps;
import static clientconnection.ClientConnection.socket;
import static clientconnection.ClientConnection.user;
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
import models.Player;
import models.UserModel;
import shared.AppFunctions;
import sounds.AudioController;
import tictactoe.gameboard.GameBoardController;

public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;

    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    public static ActionEvent requestActionEvent = new ActionEvent();

    ClientConnection client;

    public FXMLPlayerVsPlayerOnlineController(Stage stage, ClientConnection client) {
        //this.client = c;
        this.stage = stage;
        this.client = client;
        //getActiveUsers();
        Platform.runLater(() -> {
            activePlayersListView.getItems().clear();
            activePlayersListView.getItems().addAll(activeUsers);
        });

    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {

        AudioController.clickSound();
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        requestActionEvent = actionEvent;
        AudioController.clickSound();
        String rival = (String) activePlayersListView.getSelectionModel().getSelectedItem();
        if (!rival.isEmpty()) {
            System.out.println(rival);
            new Thread(() -> {
                DataModel data = new DataModel(4, user.getName(), rival);
                data.setRivalScore(user.score);
                try {
                    synchronized (oos) {
                        oos.writeObject(data);
                        oos.flush();
                    }

                    //ois.
                } catch (IOException ex) {
                    Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        }

        //AppFunctions.closePopup(actionEvent);
        //AppFunctions.goTo(actionEvent, new GameBoardController(stage, playerOne, playerTwo));
    }

    @Override
    protected void handlerefreshBtn(ActionEvent actionEvent) {
        getActiveUsers();
    }

    protected void getActiveUsers() {
        //ClientConnection.stopListeningThread();
//        new Thread(() -> {
//            try {
//                if (oos == null) {
//                    throw new IllegalStateException("ObjectOutputStream (oos) is not initialized.");
//                }
//                client.sendData(new DataModel(ClientConnection.user, 3));
//                System.out.println("Object successfully written to server.");
//                synchronized (ois) {
//                    int activeUsersCount = ois.readInt();
//                    System.out.println(activeUsersCount);
//                    List<String> activeUsers = new ArrayList<>();
//                    String user;
//                    for (int i = 0; i < activeUsersCount - 1; i++) {
//                        user = ois.readUTF();
//                        activeUsers.add(user);
//                        System.out.println(user);
//                    }
//                    Platform.runLater(() -> {
//                        activePlayersListView.getItems().clear();
//                        activePlayersListView.getItems().addAll(activeUsers);
//                    });
//                }
//
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }).start();
        //ClientConnection.startListeningThread();
        Platform.runLater(() -> {
            activePlayersListView.getItems().clear();
            activePlayersListView.getItems().addAll(activeUsers);
        });
    }

    protected void sendGameRequest() {
        String rival = (String) activePlayersListView.getSelectionModel().getSelectedItem();
    }
}
