package tictactoe.playervsplayeronline;

import clientconnection.Client;
import static clientconnection.Client.socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.DataModel;
import shared.AppFunctions;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;
    private ScheduledExecutorService executorService;
    Client client;

    public FXMLPlayerVsPlayerOnlineController(Stage stage, Client c) {
        this.client = c;
        this.stage = stage;

        startListeningForUpdates();
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        stopListeningForUpdates();
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new FXMLGameBoardOnlineController(stage));
    }

    protected void stopListeningForUpdates() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
        }
    }

    protected void startListeningForUpdates() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.execute(() -> {
            try {
                while (!executorService.isShutdown()) {
                    // Receive the number of users
                    int numberOfUsers = client.receveResponseInt();
                    List<String> activeUsers = new ArrayList<>();

                    // Receive each active username
                    for (int i = 0; i < numberOfUsers; i++) {
                        activeUsers.add(client.receveResponseString());
                    }

                    // Update the UI with the latest active users list
                    Platform.runLater(() -> {
                        activePlayersListView.getItems().setAll(activeUsers);
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
                stopListeningForUpdates(); // Stop listening for updates if an error occurs
            }
        });
    }

    protected List<String> fetchActivePlayersFromServer() {
        List<String> activeUsers = new ArrayList<>();

        try {
            // Send a request to get active players data
            DataModel data = new DataModel("activePlayers", 3);
            client.sendData(data);

            // Receive the response (list of active users)
            Object response = client.recieveObject();
            if (response instanceof List<?>) {
                activeUsers = (List<String>) response;
            } else {
                System.err.println("Invalid response from server: not a List");
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLPlayerVsPlayerOnlineController.class.getName()).log(Level.SEVERE, "Error fetching active players", ex);
        }

        // Return the fetched active users list (this could be displayed in the UI or used elsewhere)
        return activeUsers;
    }

    @Override
    protected void handlerefreshBtn(ActionEvent actionEvent) {
       refreshBtn.setDisable(true); // Disable the button
    
    List<String> activePlayers = fetchActivePlayersFromServer();
    
    // Update the ListView with the fetched active players
    Platform.runLater(() -> activePlayersListView.getItems().setAll(activePlayers));
    
    // Re-enable the button after the update
    refreshBtn.setDisable(false);
    }

}
