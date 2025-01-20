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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.GameModel;
import static tictactoe.TicTacToe.appStage;
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
        if (game.getPlayDate() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String dateTimeStr = formatter.format(game.getPlayDate());

            String fileName = GameBoardController.gameModel.getPlayer().concat("-").concat(game.getRival()).concat("-").concat(dateTimeStr);

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
                double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                alert.initOwner(appStage);
                alert.setOnShown(e -> {
                    alert.setX(centerXPosition);
                    alert.setY(centerYPosition);
                });
                alert.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Save Error");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while saving the game.");
                double centerXPosition = appStage.getX() + appStage.getWidth() / 2d - alert.getDialogPane().getWidth() / 2d;
                double centerYPosition = appStage.getY() + appStage.getHeight() / 2d - alert.getDialogPane().getHeight() / 2d;
                alert.initOwner(appStage);
                alert.setOnShown(e -> {
                    alert.setX(centerXPosition);
                    alert.setY(centerYPosition);
                });
                alert.showAndWait();
                System.out.println("Game save error");
            }
        }
    }

}
