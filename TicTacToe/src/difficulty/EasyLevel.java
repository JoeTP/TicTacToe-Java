/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difficulty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import models.ComputerPlayer;

/**
 *
 * @author Ayat Gamal
 */
public class EasyLevel extends ComputerPlayer {
    
    public EasyLevel() {
    }

    public static Integer moveComputerMove(Integer board[][]) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    return r*10+c;
                }
            }
        }
        System.out.println("No empty cells available for automatic move.");
        return null;
    }

}
