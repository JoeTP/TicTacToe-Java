/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;


import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import tictactoeserver.DataAccessLayer;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLServerController extends FXMLServerBase {

    /**
     * Initializes the controller class.
     */
    private boolean serverRunning = false;
    private int count;
        

    public FXMLServerController() {
        count = DataAccessLayer.getData();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Online", count),
                new PieChart.Data("Offline", 4));
        usersPieChart.setData(pieChartData);
        serverIndicator.setFill(Color.CRIMSON);
        usersPieChart.getData().get(0).getNode().setStyle("-fx-pie-color: DARKSLATEBLUE;");
        usersPieChart.getData().get(1).getNode().setStyle("-fx-pie-color: D8C4B6;");
    }
    
}
