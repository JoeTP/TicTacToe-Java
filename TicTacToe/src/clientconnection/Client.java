/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconnection;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayat Gamal
 */
public class Client {
  
    DataInputStream dis;
    PrintStream ps;
    Socket socket;
    public boolean serverStatus = false;
   
    
    public void connectToServer(){
    
          try {
            socket = new Socket("127.0.0.1", 5001);
            
            System.out.println("Cleint connection Established !");

            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());

        } catch (IOException ex) { 
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        // thread for each client
        Thread th;
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                   
                        //String reply = dis.readLine(); // my message as a client
                        serverStatus =  socket.isClosed();
                }
            }
        });
        th.start();
    }

    
}
