/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.GameModel;
import tictactoe.gameboard.GameBoardController;

public class SaveGame {

    protected static String folderPath;

    static {
        folderPath = "records";
    }

    public static void saveGameToFile(GameModel game) {
        if (game == null) {
            System.err.println("Error: GameModel is null.");
            return;
        }

        System.out.println("game.get player " + game.getPlayer() + "game.getRival" + game.getRival());
        String fileName = GameBoardController.gameModel.getPlayer().concat("-").concat(game.getRival());

        File folder = new File(folderPath);
        if (!folder.exists() && !folder.mkdirs()) {
            System.err.println("Failed to create folder: " + folderPath);
            return;
        }

        File file = new File(folder, fileName);
        System.out.println("Folder pathhhhhh: " + folder.getAbsolutePath());
        System.out.println("File pathhhhhhhh: " + file.getAbsolutePath());

        try (FileWriter writer = new FileWriter(file)) {
            Gson gson = new Gson();

            gson.toJson(game, writer);
            System.out.println("Game saved successfully");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Game Saved");
            alert.setHeaderText(null);
            alert.setContentText("The game has been saved successfully!");
           // alert.getDialogPane().getStylesheets().add("/alert-style.css");

            alert.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Save Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the game.");
            alert.showAndWait();
            System.out.println("Game save error");
        }
    }

}
