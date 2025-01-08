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

/**
 *
 * @author Ayat Gamal
 */
public class Client {
  
    DataInputStream dis;
    PrintStream ps;
    Socket socket;
    public static boolean clientStatus = false;
   
    
    public void connectToServer(){
    
          try {
            socket = new Socket("127.0.0.1", 5001);
            
            System.out.println("Cleint connection Established !");

            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());

        } catch (IOException e) {
            dis = null;
            ps = null;
            socket = null;
         }

        // thread for each client
        Thread th;
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String reply = dis.readLine(); // my message as a client
                       clientStatus =  socket.isConnected();
                        System.out.println(clientStatus);
                    } catch (IOException e) {
                     }
                }
            }
        });
        th.start();
    }

    
}
