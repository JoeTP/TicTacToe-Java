
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineBase;
import tictactoe.onlinegmaeboard.*;





public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      // Parent root = FXMLLoader.load(getClass().getResource("/tictactoe/onlinegmaeboard/FXMLGameBoardOnlineBase.fxml"));

 Parent root = new FXMLGameBoardOnlineBase();

        
        Scene scene = new Scene(root,1000,720);
        //String css = this.getClass().getResource().
        scene.getStylesheets().add(getClass().getResource("onlinegmaeboard/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
