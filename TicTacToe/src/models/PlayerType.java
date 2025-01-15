/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ayat Gamal
 */
public class PlayerType<T> {
    private T player;
    
    public PlayerType(T player){
        this.player = player;
    }
    
    public T getPlayer() {
        return player;
    }

    public void setPlayer(T player) {
        this.player = player;
    }
     public void displayType() {
        System.out.println("Player : " + player);
    }
}
