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
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import json.JSONConverters;
import models.UserModel;

public class ClientHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    ObjectInputStream ois;
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();
    Socket client;  // Add a reference to the client socket

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

    @Override
    public void run() {
       
        try {

            System.out.println("Waiting for client input...");

            String jsonRequest = dis.readUTF();
            System.out.println("Received jsonRequest: " + jsonRequest);
            UserModel user = JSONConverters.jsonToUserModel(jsonRequest);
            System.out.println("after converson user: " + user.getPassword());

            
            String response = handleRequest(user);
            System.out.println("response" +response);
            ps.writeUTF(response);
            ps.flush();
        } catch (EOFException e) {
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);

        }

        try {
            clients.remove(this);
            dis.close();
            ps.close();
            client.close();
        } catch (IOException ex) {

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

    private String handleRequest(UserModel user) {
        String response = "Failure";
       
  
      
        UserModel userFromSql = DataAccessLayer.getUserDataLogin(user.getName());

        if (userFromSql == null) {
            System.out.println("User not found in database for username: " + user.getName());
 
        } else {
            System.out.println("Retrieved user from database: " + userFromSql.getName());
            if (user.getPassword().equals(userFromSql.getPassword())) {
                System.out.println("Password matches for user: " + userFromSql.getName());
                response = JSONConverters.userModelToJson(userFromSql);
            } else {
                System.out.println("Password does not match for user: " + userFromSql.getName());

            }
        }

        return response;
    }

}
