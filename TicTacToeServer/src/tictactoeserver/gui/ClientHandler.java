/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssif
 */
public class ClientHandler extends Thread {

    DataInputStream dis;
    DataOutputStream ps;
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();

    public ClientHandler(Socket client) {
        try {
            System.out.println("IM CLIENT HANDLER");

            dis = new DataInputStream(client.getInputStream());
            System.out.println(dis);
            ps = new DataOutputStream(client.getOutputStream());
            ClientHandler.clients.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println("IM BLOCKING CODE IN CLIENT HANDLER");

                String str = dis.readUTF();
                broadCastMsg(str);
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
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