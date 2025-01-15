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
    public static UserModel user;

    public void connectToServer() throws IOException {
        socket = new Socket("127.0.0.1", 5001);
        System.out.println("Cleint connection Established !");
        //dis = new DataInputStream(socket.getInputStream());
        //ps = new PrintStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());

        /*
=======
       
       
/*
>>>>>>> M-sendrequest
        // thread for each client
        Thread th;
        th = new Thread(() -> {
            while (true) {
                try {
                    String reply = dis.readLine();
                    serverStatus = socket.isClosed();
                    System.out.println(serverStatus);
                } catch (IOException ex) {
                    Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        );
        th.start();*/
    }

    public static void stopThreads() {
        try {            
            oos.close();
            socket.close();
            Platform.exit();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void terminateClient() {
        try { 
            oos.close();
            socket.close();
            System.out.println("client killed");
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void sendData(DataModel d) {
        try {
            oos.writeObject(d);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }finally {
//        if (oos != null) {
//            try {
//                oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    }

    public static String receveResponse() throws IOException {
        String response = dis.readUTF();
        return response;
    }

    public static DataModel receveData() {       
        DataModel data = null;
        try {
            
            data = (DataModel) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }finally {
//        if (ois != null) {
//            try {
//                ois.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
        return data;
    }
    
//      public static int receveResponseInt() throws IOException{
//        int response = dis.readInt();
//        return response;
//    }
//            public static String receveResponseString() throws IOException{
//        String response = dis.readUTF();
//        return response;
//    }
//      public static DataModel recieveObject() throws IOException{
//          DataModel response=null;
//        try {
//             response = (DataModel) ois.readObject();
//          
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          return response;
//    }
      

}
