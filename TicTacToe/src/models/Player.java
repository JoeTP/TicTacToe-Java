/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Youssif
 */
public class Player   {

    public boolean hisTurn;
    private String character;
    public String name; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Player() {
        hisTurn = false;
        name = "You";
    }

//    public boolean isHisTurn() {
//        return hisTurn;
//    }
//    public void setTurn(boolean b) {
//        hisTurn = b;
//    }

    public void setChar(String c) {
        character = c;
    }
    public String getChar() {
        return character;
    }

}
