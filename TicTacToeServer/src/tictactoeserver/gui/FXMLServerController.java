/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.chart.PieChart;
import shared.AppStrings;
import tictactoeserver.MainServer;


public class FXMLServerController extends FXMLServerBase {

 
    private boolean serverRunning = false;
    private int count;
    ServerSocket server;
    Socket client;
    Thread th;

    public FXMLServerController() {
        count = DataAccessLayer.getUsersCount();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data(AppStrings.ONLINE, count),
                new PieChart.Data(AppStrings.OFFLINE, 4));
        usersPieChart.setData(pieChartData);
        serverIndicator.setFill(Color.CRIMSON);
        usersPieChart.getData().get(0).getNode().setStyle("-fx-pie-color: DARKSLATEBLUE;");
        usersPieChart.getData().get(1).getNode().setStyle("-fx-pie-color: D8C4B6;");

    }

    @Override
    protected void handleServerState(ActionEvent actionEvent) {
        

        if (!serverRunning) {
            serverRunning = true;
            th = new Thread(() -> {
                try {
                    server = new ServerSocket(5001);
                    while (serverRunning) {
                        try {
                            client = server.accept();
                            System.out.println("BLOCKING CODE");
                            new ClientHandler(client);
                        } catch (SocketException ex) {
                            if (!serverRunning) {
                                break;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            th.start();
            System.out.println("SERVER STARTED");

        } else {
            serverRunning = false;
            try {
                server.close();
                th.join();
                System.out.println("SERVER STOPPED");
            } catch (IOException ex) {
                Logger.getLogger(FXMLServerController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLServerController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!serverRunning) {
            serverStateToggleButton.setText(AppStrings.START);
        } else {
            serverStateToggleButton.setText(AppStrings.STOP);
        }
    }

}
