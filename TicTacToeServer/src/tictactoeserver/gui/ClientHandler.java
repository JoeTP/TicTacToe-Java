/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import models.DataModel;
import models.UserModel;
import shared.AppStrings;

public class ClientHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    UserModel user;
    String response;
    Socket client;
    int state;
    static ObservableList<ClientHandler> clients = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
    static ObservableList<String> usernames = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
    static ObservableList<String> inGameUsers = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());

            synchronized (clients) {
                clients.add(this);
            }
            System.out.println("##OF CLIENTS" + clients.size());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataModel data = (DataModel) ois.readObject();
                state = data.getState();
                System.out.println(state);
                switch (state) {
                    case 1: // Sign-up
                        user = data.getUser();
                        System.out.println(user.getName());
                        response = DataAccessLayer.insertData(user);
                        updateUserData();
                        sendUserData(user, response);
                        if (response.equals(AppStrings.SIGNUP_DONE)) {
                            synchronized (usernames) {
                                usernames.add(user.getName());
                            }
                        }

                        break;
                    case 2: // sign in
                        user = data.getUser();
                        System.out.println(user.getName());
                        response = DataAccessLayer.getUserDataLogin(user.getName(), user.getPassword());
                        boolean isNotLoggedin = isNotLoggedin(user.getName());
                        if (isNotLoggedin == false) {
                            response = AppStrings.SIGNIN_ALREADY_FOUND;
                        }
                        updateUserData();
                        sendUserData(user, response);
                        if (response.equals(AppStrings.SIGNIN_DONE)) {
                            synchronized (usernames) {
                                usernames.add(user.getName());
                            }
                        }

                        break;
                    case 3:
                        System.out.println("in case 3 : ");
                        user = data.getUser();
                        findClientHandler(user.getName()).sendActiveUsersList();
                        break;
                    case 4: // send game request
                        if(!inGameUsers.contains(data.getRival())){
                            ClientHandler op = findClientHandler(data.getRival());
                        if (data.getPlayer().isEmpty()) {
                            System.out.println("player is null");
                        } else {
                            System.out.println(data.getPlayer());
                        }
                        op.sendRequest(data.getPlayer());
                        }                       
                        break;
                    case 5: // Game Accepted
                        ClientHandler ch = findClientHandler(data.getRival());
                        ch.sendRequestResponse(data.getPlayer());
                        synchronized (inGameUsers) {
                            inGameUsers.addAll(data.getPlayer(), data.getRival());
                            System.out.println(data.getPlayer()+" Playing "+data.getRival());
                        }
                        break;
                    case 6:
                        System.out.println(data.getRival());
                        ClientHandler gamePlayer = findClientHandler(data.getRival());
                        gamePlayer.sendGameMove(data);
                        System.out.println("Sent game move");
                        if (data.getResponse().equals("YES_ENDED")) {
                            synchronized (inGameUsers) {
                                inGameUsers.removeAll(data.getPlayer(), data.getRival());
                                System.out.println(data.getPlayer()+" finshed "+data.getRival());
                            }
                        }
                        break;
                    case 7:
                        ClientHandler ch2 = findClientHandler(data.getRival());
                        ch2.sendRequestResponseDecline(data.getPlayer());
                        break;
                    case 8:
                        ClientHandler ch3 = findClientHandler(data.getRival());
                        ch3.sendGameMove(data);
                        break;
//                    case 9 :
//                        ClientHandler ch4 = findClientHandler(data.getRival());
//                        ch4.sendGameMove(data);
//                    default:
//                        System.out.println("Unknown state: " + state);
//                        ps.writeUTF("Unknown request");
//                        ps.flush();
                }

            }

        } catch (IOException ex) {
            disconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void broadCastMsg(String msg) {
        for (ClientHandler client : clients) {
            try {
                client.ps.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected void sendActiveUsersList() {
        try {
            oos.writeObject(new DataModel("Active_Users"));
            oos.writeInt(usernames.size() - inGameUsers.size());
            System.out.println(usernames.size() - inGameUsers.size());
            for (String username : usernames) {
                System.out.println(username);
                if (!username.equals(user.getName()) && !inGameUsers.contains(username)) {
                    oos.writeUTF(username);
                }
            }
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUserName() {
        return user != null ? user.getName() : "Unknown User";
    }

    public ClientHandler findClientHandler(String username) {
        int index = usernames.indexOf(username);
        if (index == -1) {
            return null;
        } else {
            return clients.get(index);
        }
    }

    public void disconnect() {
        try {
            synchronized (clients) {
                clients.remove(this);
            }
            if (response != null && !response.equals(AppStrings.SIGNIN_ALREADY_FOUND)
                    && !response.equals(AppStrings.SIGNUP_FAILED)
                    && !response.equals(AppStrings.SIGNIN_FAILED)) {

                synchronized (usernames) {
                    if (user != null && user.getName() != null) {
                        usernames.remove(user.getName());
                    }
                }
            }
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
            if (client != null) {
                client.close();
            }
            this.stop();
            System.out.println("## Number of Clients: " + clients.size());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isNotLoggedin(String username) {
        for (String u : usernames) {
            if (username.equals(u)) {
                return false;
            }
        }
        return true;
    }

    private void sendUserData(UserModel user, String response) throws IOException {
        if (client != null && client.isConnected() && !client.isClosed()) {
            if (oos != null) {  // Check if ObjectOutputStream is initialized
                try {
                    DataModel data = new DataModel(user, response);
                    oos.writeObject(data);  // Send data
                    oos.flush();  // Ensure it's sent
                    System.out.println("User data sent successfully");
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, "Failed to send user data", ex);
                    disconnect();  // Disconnect in case of failure
                }
            } else {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, "ObjectOutputStream is not initialized or is closed");
                disconnect();  // Handle uninitialized or closed ObjectOutputStream
            }
        } else {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, "Client disconnected or socket is closed, cannot send data");
            disconnect();  // Disconnect if client socket is not connected or closed
        }

    }

    private void updateUserData() {

        user = DataAccessLayer.getUserData(user.getName(), user.getPassword());

    }

    private void sendRequest(String rival) throws IOException {
        DataModel data = new DataModel(rival, "Game_Request");
        oos.writeObject(data);
        oos.flush();
    }

    private void sendRequestResponse(String rival) throws IOException {
        DataModel data = new DataModel(rival, "GAME_ACCEPT");
        oos.writeObject(data);
        oos.flush();
    }

    public static void broadCastActiveUsers() {
        clients.forEach((c) -> {
            if(!inGameUsers.contains(c.user.getName())){
                System.out.println("sending to "+c.user.getName());
                c.sendActiveUsersList();
            }          
        });
    }

    public void broadCastToUsers() throws IOException {
        DataModel data = new DataModel("DISCONNECT");
        oos.writeObject(data);
        oos.flush();
    }

    public static void broadCastDisconnect() {
        clients.forEach((c) -> {
            try {
                c.broadCastToUsers();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void sendGameMove(DataModel gameMove) {
        try {

            oos.writeObject(gameMove);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendRequestResponseDecline(String rival) {
        DataModel data = new DataModel(rival, "GAME_DECLINE");
        try {
            oos.writeObject(data);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
