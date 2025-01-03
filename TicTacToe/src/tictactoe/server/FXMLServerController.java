/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.server;


import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLServerController extends FXMLServerBase implements Initializable {

    /**
     * Initializes the controller class.
     */
    private boolean serverRunning = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public FXMLServerController() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Online", 10),
                new PieChart.Data("Offline", 20));
        usersPieChart.setData(pieChartData);
        serverIndicator.setFill(Color.CRIMSON);
        usersPieChart.getData().get(0).getNode().setStyle("-fx-pie-color: DARKSLATEBLUE;");
        usersPieChart.getData().get(1).getNode().setStyle("-fx-pie-color: D8C4B6;");
        
    }
    
}
