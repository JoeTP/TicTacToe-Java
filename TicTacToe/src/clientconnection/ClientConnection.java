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
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import models.DataModel;
import models.UserModel;
import shared.AppFunctions;
import tictactoe.playervscomp.FXMLPlayerVsCompController;
import tictactoe.playervsplayerlocal.FXMLRequestToPlayController;

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

    public void connectToServer() throws IOException {
        socket = new Socket("127.0.0.1", 5001);
        System.out.println("Cleint connection Established !");
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());

    }

    public static void stopThreads() {
        try {
            socket.close();
            Platform.exit();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void terminateClient() {
        try {
            oos.close();
            ois.close();
            listeningThread.stop();
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
                String newResponse = newData.getResponse();
                System.out.println(newResponse + " " + newData.getRival());

                if (newResponse.equals("Game_Request")) {
                    Platform.runLater(() -> {

                        AppFunctions.openReqPopup(new FXMLRequestToPlayController());
                    });
                }
            }
        });
        listeningThread.start();
    }

    public static void stopListeningThread() {
        if (listeningThread != null && listeningThread.isAlive()) {
            listeningThread.interrupt();
            try {
                listeningThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
