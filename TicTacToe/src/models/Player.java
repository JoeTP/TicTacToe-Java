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

    boolean hisTurn;

    public Player() {
        hisTurn = false;
    }

    public boolean isHisTurn() {
        return hisTurn;
    }

}
