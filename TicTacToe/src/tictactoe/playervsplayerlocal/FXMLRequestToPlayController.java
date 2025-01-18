/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayerlocal;

import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.startListeningThread;
import static clientconnection.ClientConnection.stopListeningThread;
import static clientconnection.ClientConnection.user;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import models.DataModel;
import models.Player;
import shared.AppFunctions;
import static tictactoe.TicTacToe.appStage;
import tictactoe.gameboard.GameBoardController;
import tictactoe.onlinegmaeboard.OnlineGameBoardController;
import tictactoe.playervsplayerlocal.FXMLRequestToPlayBase;

public class FXMLRequestToPlayController extends FXMLRequestToPlayBase {

    String rival;

    public FXMLRequestToPlayController(String rival) {
        this.rival = rival;
        playerNameLabel.setText(rival);
    }

    @Override
    protected void handleAcceptButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);

        new Thread(() -> {
            DataModel data = new DataModel(5, user.getName(),rival);
            synchronized (oos) {
                try {
                    oos.writeObject(data);
                    oos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLRequestToPlayController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }).start();
        stopListeningThread();
        AppFunctions.goTo(actionEvent, new OnlineGameBoardController(appStage, user.getName(), rival, "online"));
        
    }

    @Override
    protected void handleDeclineButton(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
        DataModel data = new DataModel(7, user.getName(),rival);
        try {
            oos.writeObject(data);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(FXMLRequestToPlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        startListeningThread();
    }

}
