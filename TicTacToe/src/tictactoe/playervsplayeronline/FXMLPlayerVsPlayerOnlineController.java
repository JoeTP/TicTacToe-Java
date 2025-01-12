/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.playervsplayeronline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import shared.AppFunctions;
import tictactoe.onlinegmaeboard.FXMLGameBoardOnlineController;

/**
 * FXML Controller class
 *
 * @author Kimo Store
 */
public class FXMLPlayerVsPlayerOnlineController extends FXMLPlayerVsPlayerOnlineBase {

    private Stage stage;

    private ScheduledExecutorService executorService;

    public FXMLPlayerVsPlayerOnlineController(Stage stage) {
        this.stage = stage;
        startActivePlayersUpdater();
    }

    @Override
    protected void handleBackButton(ActionEvent actionEvent) {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
        }
        AppFunctions.closePopup(actionEvent);
    }

    @Override
    protected void openGameBoard(ActionEvent actionEvent) {
        AppFunctions.closePopup(actionEvent);
        AppFunctions.goTo(actionEvent, new FXMLGameBoardOnlineController(stage));
    }

    private void startActivePlayersUpdater() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                // Generate a mock list of active players for testing
                List<String> activePlayers = createTestPlayerList();

                // Update the UI on the JavaFX Application Thread
                Platform.runLater(() -> {
                    //   activePlayersListView.getItems().setAll("Test1", "Test2", "Test3");

                    activePlayersListView.getItems().setAll(activePlayers);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS); // Update every 5 seconds
    }

//   private void startActivePlayersUpdater() {
//        executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                // Fetch active players from the server
//              //  List<String> activePlayers = fetchActivePlayersFromServer();
//
//                // Update the UI on the JavaFX Application Thread
//                Platform.runLater(() -> {
//                    activePlayersListView.getItems().setAll(activePlayers);
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 0, 5, TimeUnit.SECONDS); // Update every 5 seconds
//    }
    private List<String> createTestPlayerList() {
        // Simulate changing player lists by generating random names
        List<String> players = new ArrayList<>();
        players.add("Player1");
        players.add("Player2");
        players.add("Player3");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player4");
        players.add("Player" + (int) (Math.random() * 100)); // Adds some dynamic behavior
        return players;
    }

//    private List<String> fetchActivePlayersFromServer() throws Exception {
//        // Replace this with the actual call to your server's API
//        OnlineUsersClient client = new OnlineUsersClient();
//        return client.getOnlineUsers();
//    }
}
