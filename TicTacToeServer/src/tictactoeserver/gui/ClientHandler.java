/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.UserModel;
import models.DataModel;


public class ClientHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    UserModel user;
    boolean response;
    Socket client;  // Add a reference to the client socket
    int state;
    static ObservableList<ClientHandler> clients = FXCollections.observableArrayList();

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            ps = new DataOutputStream(client.getOutputStream());
            ClientHandler.clients.add(this);

            System.out.println("##OF CLIENTS" + clients.size());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        
        try {
            while(true){
                ois = new ObjectInputStream(client.getInputStream());
                DataModel data = (DataModel) ois.readObject();
                state = data.getState();
                switch(state){
                    case 1:
                        user = data.getUser();
                        System.out.println(user.getName());
                        System.out.println(user.getEmail());
                        response = DataAccessLayer.insertData(user);
                        ps.writeBoolean(response);
                        break;
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
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
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
}
