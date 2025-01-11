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
public class Player extends UserModel {

    public boolean hisTurn;
    private String character;

    public Player() {
        hisTurn = false;
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
    public String getChat() {
        return character;
    }

}
