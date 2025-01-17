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
import models.GameModel;

/**
 *
 * @author Kimo Store
 */
public class SaveGame {
    protected static String folderPath;
    static{
        folderPath = "/resources/records";
    }
    public static void saveGameToFile(GameModel game){
        Gson gson = new Gson();
        File folder = new File (folderPath);
        if(!folder.exists()){
            if(folder.mkdir()){
                System.out.println("Folder created");
            }else{
                System.out.println("error");
            }
        }
        String fileName = game.getPlayer().concat("-".concat(game.getRival()));
        File file = new File(folder,fileName);
        try {
            FileWriter writer = new FileWriter(file);
            gson.toJson(game,writer);
            System.out.println("game saved");
        } catch (IOException ex) {
            Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("game saved error");
        }
    }
}
