/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GameModel;
import static records.SaveGame.folderPath;

/**
 *
 * @author Kimo Store
 */
public class LaodGame {
    public static GameModel loadGameFromFile(String fileName){
        Gson gson = new Gson();
        File file = new File(folderPath,fileName);
        if (!file.exists()){
            System.out.println("game not found");
            return null;
        }
        try {
            FileReader reader = new FileReader(file);
           
            GameModel game = gson.fromJson(reader, GameModel.class);
            return game;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LaodGame.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
