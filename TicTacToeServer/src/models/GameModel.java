/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Youssif
 */
public class GameModel implements Serializable{

    

 
        int id;
    String player ;
    String rival;
    String winner;
    Date playDate;
    Integer board[][];

    public GameModel(int id, String player, String rival, String winner, Date playDate,Integer [][] board) {
        this.id = id;
        this.player = player;
        this.rival = rival;
        this.winner = winner;
        this.playDate = playDate;
        this.board=board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public Integer[][] getBoard() {
        return board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(String player) {
//        this.player = player;
//    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }
    
}
