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
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import models.DataModel;
import models.UserModel;

public class ClientHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    ObjectInputStream ois;

    ObjectOutputStream oos;
    UserModel user;
    boolean response;

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
                System.out.println("Waiting for client input...");

                System.out.println("State: " + state);

                // Handle requests based on state
                UserModel user = data.getUser();
                System.out.println(user.getName());
                System.out.println(user.getEmail());
                switch (state) {
                    case 1: // Sign-up
                        boolean response = false;
                        response = DataAccessLayer.insertData(user);
                        ps.writeBoolean(response);
                        break;
                    case 2: // Sign-in
                        boolean responseLogin = false;
                        responseLogin = DataAccessLayer.getUserDataLogin(user.getName(), user.getPassword());
                        ps.writeBoolean(responseLogin);

                        break;

                    default:
                        System.out.println("Unknown state: " + state);
                        ps.writeUTF("Unknown request");
                        ps.flush();
                }

            }

            /*try {
            while (true) {
            String str = dis.readUTF();
            broadCastMsg(str);
            }
            } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            // Client disconnected, remove from clients vector
            try {
            clients.remove(this);
            dis.close();
            ps.close();
            client.close();
            
            System.out.println("##OF CLIENTS" + clients.size());
            } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (IOException ex) {
            disconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void broadCastMsg(String msg
    ) {
        for (ClientHandler client : clients) {
            try {
                client.ps.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getUserName() {
        return user != null ? user.getName() : "Unknown User";
    }

    void disconnect() {
        try {
            synchronized (clients) {
                clients.remove(this);
            }
            synchronized (usernames) {
                usernames.remove(user.getName());
            }
            dis.close();
            ps.close();
            ois.close();
            client.close();
            System.out.println("## Number of Clients: " + clients.size());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
