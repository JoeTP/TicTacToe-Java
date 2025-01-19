/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difficulty;

import gameboard.WinningLine;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import models.ComputerPlayer;

/**
 *
 * @author Ayat Gamal
 */
public class MediumLevel extends ComputerPlayer{

    public MediumLevel() {
    }
   public static Integer moveComputerMove(Integer board[][]) {

            // Check for a winning move
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == null) {
                    board[r][c] = 1; // Simulate computer move
                    if (isWinnerStep(board)) {
                        board[r][c] = null; // Undo move
                        return r * 10 + c;
                    }
                    board[r][c] = null; // Undo move
                }
            }
        }
        
        // If no winning move, return null or implement another strategy
        return new EasyLevel().moveComputerMove(board);
  
    }
   
     public static String getWinnerCharacter(int value) {
        //return the value of the 1st itration
        return (value % 2 == 0) ? "O" : "X";
    }

   
    public static boolean isWinnerStep(Integer[][] board) {
    
            for (int i = 0; i < 3; i++) {
                //rows
                if (checkLine(board[i][0], board[i][1], board[i][2])) {
             
                    return true;
                }
                //columns
                if (checkLine(board[0][i], board[1][i], board[2][i])) {
                   return true;
                }
            }
            if (checkLine(board[0][0], board[1][1], board[2][2])) {
                return true;
            }
            if (checkLine(board[0][2], board[1][1], board[2][0])) {
               return true;
            }
            return false;
        }
  

  public static boolean checkLine(Integer a, Integer b, Integer c) {
        if (a == null || b == null || c == null) {
            return false;
        }
        boolean state = ((a % 2 == b % 2) && (b % 2 == c % 2));
        return state;
    }
}
