/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import models.DataModel;
import models.UserModel;
import shared.AppFunctions;
import shared.AppString;
import static tictactoe.TicTacToe.appStage;
import tictactoe.gameboard.GameBoardController;
import tictactoe.onlinegmaeboard.OnlineGameBoardController;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.playervsplayerlocal.FXMLRequestToPlayController;
import tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController;
import static tictactoe.playervsplayeronline.FXMLPlayerVsPlayerOnlineController.requestActionEvent;

/**
 *
 * @author Ayat Gamal
 */
public class ClientConnection {

    public static DataInputStream dis;

    public static DataOutputStream dos;
    public static PrintStream ps;
    public static Socket socket;
    public static boolean serverStatus = false;
    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;
    public static Thread listeningThread;
    public static UserModel user;
    public static String rival;
    public static List<String> activeUsers = new ArrayList<>();
    public static String SERVER_IP = AppString.SERVER_HOST;

    public static void connectToServer() throws IOException {
        socket = new Socket(SERVER_IP, 5001);
        System.out.println("Cleint connection Established !");
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public static void stopThreads() {
        try {
            terminateClient();
            socket.close();
            Platform.exit();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void terminateClient() {
        try {
            stopListeningThread();
            oos.close();
            ois.close();
            socket.close();
            System.out.println("client killed");
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized static void sendData(DataModel d) throws IOException {
        oos.writeObject(d);
        oos.flush();
    }

    public static String receveResponse() throws IOException {
        String response = dis.readUTF();
        return response;
    }

    public synchronized static DataModel receveData() {
        DataModel data = null;
        try {

            data = (DataModel) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);

        }
        return data;
    }

    public static void startListeningThread() {

        listeningThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("startListeningThread");
                DataModel newData = ClientConnection.receveData();
                if (newData == null) {
                    continue;
                }
                String newResponse = newData.getResponse();
                ClientConnection.rival = newData.getRival();
                System.out.println(newResponse);

                if (newResponse.equals("Game_Request")) {
                    System.out.println(rival + newData.getRivalScore());
                    Platform.runLater(() -> {
                        AppFunctions.openPopup(appStage, new FXMLRequestToPlayController(rival, appStage,newData.getRivalScore()));
                    });
                    stopListeningThread();
                }
                if (newResponse.equals("GAME_ACCEPT")) {
                    Platform.runLater(() -> {
                        //AppFunctions.goToGameBoard(appStage, new OnlineGameBoardController(appStage, rival, user.getName(), "online"));
                        AppFunctions.closeAndGo(requestActionEvent, appStage, new OnlineGameBoardController(appStage, rival, user.getName(), "online"));
                    });
                    stopListeningThread();
                }

                if (newResponse.equals("Active_Users")) {
                    try {
                        synchronized (ois) {
                            activeUsers.clear();
                            int activeUsersCount = ois.readInt();
                            System.out.println(activeUsersCount);
                            String user;
                            for (int i = 0; i < activeUsersCount - 1; i++) {
                                user = ois.readUTF();
                                activeUsers.add(user);
                                System.out.println(user);
                            }
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newResponse.equals("GAME_DECLINE")) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your request was declined");
                        double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                        double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                        alert.initOwner(appStage);
                        alert.setOnShown(e -> {
                            alert.setX(centerXPosition);
                            alert.setY(centerYPosition);
                        });
                        alert.showAndWait();
                    });
                }

                if (newResponse.equals("DISCONNECT")) {
                    terminateClient();
                }
            }
        });
        listeningThread.start();
    }

    public static void stopListeningThread() {
        if (listeningThread != null && listeningThread.isAlive()) {
            listeningThread.interrupt();
            listeningThread.stop();
            System.out.println("stopListeningThread");
        }
    }
}
