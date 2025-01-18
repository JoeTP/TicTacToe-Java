/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Ayat Gamal
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        hisTurn = false;
        name="computer";
    }
//b01
//    public static Button getButtonsByRowAndColumn(int c, int r, GridPane grid) {
//        for (Node n : grid.getChildren()) {
//            if (n instanceof Button) {                             
//                String bId = n.getId();
//                System.out.println("row " + bId);
//                 if (Character.forDigit(c,10) == bId.charAt(1) && Character.forDigit(r,10) == bId.charAt(2)) {
//                    System.out.println("col = " + c);
//                    System.out.println("row = " + r);
//                    System.out.println(n.getId());
//                    return (Button) n;                 
//                }
//            }
//        }
//        return null;
//    }

  

}
