/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.homescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Youssif
 */
public class FXMLHomeScreenController extends FXMLHomeScreenBase implements Initializable {

    void setLogo(){
        Image logo = new Image(getClass().getResourceAsStream(""));
        logoImageViewer.setImage(logo);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLogo();
        
    }    
    
}
