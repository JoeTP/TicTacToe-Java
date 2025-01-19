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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.chart.PieChart;
import shared.AppStrings;
import tictactoeserver.MainServer;
import static tictactoeserver.gui.ClientHandler.broadCastActiveUsers;
import static tictactoeserver.gui.ClientHandler.clients;
import static tictactoeserver.gui.ClientHandler.usernames;

public class FXMLServerController extends FXMLServerBase {

    private boolean serverRunning = false;
    private int usersCount;
    private int onlineUsersCount;
    ServerSocket server;
    Socket client;
    Thread th;
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    public FXMLServerController() {
        System.out.println("FXMLServerController initialized");
        usernames.addListener((ListChangeListener<String>) change -> {
            updatePieChart();
            updateActiveUsersList(change);
        });
        updatePieChart();
        serverIndicator.setFill(Color.CRIMSON);        
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
            serverIndicator.setFill(Color.GREEN);
        } else {
            serverRunning = false;
            ClientHandler.broadCastDisconnect();
            try {
                server.close();
                th.stop();
                th.join();
                System.out.println("SERVER STOPPED");
                serverIndicator.setFill(Color.CRIMSON);
            } catch (IOException ex) {
                Logger.getLogger(FXMLServerController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLServerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!serverRunning) {
            serverStateToggle.setText(AppStrings.START);
        } else {
            serverStateToggle.setText(AppStrings.STOP);
        }
    }

    protected void updatePieChart() {
        usersCount = DataAccessLayer.getUsersCount();
        onlineUsersCount = clients.size();
        System.out.println("Total users count: " + usersCount);
        System.out.println("Total online users count: " + onlineUsersCount);
        Platform.runLater(() -> {
            if (usersPieChart != null) {
                ObservableList<PieChart.Data> pieChartData = usersPieChart.getData();
                if (pieChartData.size() == 2) {
                    pieChartData.get(0).setPieValue(onlineUsersCount); // Online
                    pieChartData.get(1).setPieValue(usersCount - onlineUsersCount); // Offline
                } else {
                    pieChartData.setAll(
                            new PieChart.Data(AppStrings.ONLINE, onlineUsersCount),
                            new PieChart.Data(AppStrings.OFFLINE, usersCount - onlineUsersCount)
                    );                    
                }
                usersPieChart.getData().get(0).getNode().setStyle("-fx-pie-color: DARKSLATEBLUE;");
                usersPieChart.getData().get(1).getNode().setStyle("-fx-pie-color: D8C4B6;");
                totalUsersNoLabel.setText(Integer.toString(usersCount));
                ActiceUsersNoLabel.setText(Integer.toString(onlineUsersCount));
            }
        });
    }

    protected void updateActiveUsersList(ListChangeListener.Change<? extends String> change) {
        synchronized (usernames) {
            while (change.next()) {
                if (change.wasAdded()) {
                    String lastUserName = change.getAddedSubList().get(change.getAddedSubList().size() - 1);
                    Platform.runLater(() -> usersList.getItems().add(lastUserName));
                    System.out.println("Last added user: " + lastUserName);
                }
                if (change.wasRemoved()) {
                    for (String removedUser : change.getRemoved()) {
                        Platform.runLater(() -> {
                            usersList.getItems().remove(removedUser);
                            System.out.println("Removed user: " + removedUser);
                        });
                    }
                }
            }
        }
        ClientHandler.broadCastActiveUsers();
    }
}
