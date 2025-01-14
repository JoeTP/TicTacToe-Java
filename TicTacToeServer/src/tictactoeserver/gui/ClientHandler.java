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

    Socket client;  // Add a reference to the client socket
    int state;
    static ObservableList<ClientHandler> clients = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
    static ObservableList<String> usernames = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            ps = new DataOutputStream(client.getOutputStream());
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

                ois = new ObjectInputStream(client.getInputStream());
                DataModel data = (DataModel) ois.readObject();
                state = data.getState();
                user = data.getUser();

                System.out.println(user.getName());
                System.out.println(user.getEmail());
                switch (state) {
                    case 1: // Sign-up
                        response = DataAccessLayer.insertData(user);
                        if (response.equals(AppStrings.SIGNUP_DONE)) {
                            synchronized (usernames) {
                                usernames.add(user.getName());
                            }
                        }
                        ps.writeUTF(response);
                        break;
                    case 2: // sign in
                        response = DataAccessLayer.getUserDataLogin(user.getName(), user.getPassword());
                        boolean isNotLoggedin = isNotLoggedin(user.getName());
                        if (isNotLoggedin == false) {
                            response = AppStrings.SIGNIN_ALREADY_FOUND;
                        }
                        if (response.equals(AppStrings.SIGNIN_DONE)) {
                            synchronized (usernames) {
                                usernames.add(user.getName());
                            }
                        }
                        ps.writeUTF(response);

                        break;
//                    case 3:
//                        System.out.println("in case 3 : ");
//                        sendActiveUsersList();

                    default:
                        System.out.println("Unknown state: " + state);
                        ps.writeUTF("Unknown request");
                        ps.flush();
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
//
//    private void sendActiveUsersList() {
//       
//            try {
//                System.out.println("the count in sendActiveUsersList " + usernames.size());
//                ps.writeInt(usernames.size());
//
//                for (String username : usernames) {
//                    System.out.println("username in sendActiveUsersList" + username);
//                    ps.writeUTF(username);
//
//                }
//                ps.flush();
//            } catch (IOException ex) {
//                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//    }

    public String getUserName() {
        return user != null ? user.getName() : "Unknown User";
    }

    public void disconnect() {
        try {
            synchronized (clients) {
                    clients.remove(this);
                }
            if (!response.equals(AppStrings.SIGNIN_ALREADY_FOUND) && !response.equals(AppStrings.SIGNUP_FAILED)&&!response.equals(AppStrings.SIGNIN_FAILED)) {
                
                synchronized (usernames) {
                    usernames.remove(user.getName());
                }
            }
            
            dis.close();
            ps.close();
            ois.close();
            client.close();
            this.stop();
            this.join();
            System.out.println("## Number of Clients: " + clients.size());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isNotLoggedin(String username) {
        for (String u : usernames) {
            if (user.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }

}
