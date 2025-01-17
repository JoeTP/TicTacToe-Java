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
public class GameModel implements Serializable {

    int id;
    int userOneId;
    int userTowId;
    int gameBoard;
    String winner;
    Date playDate;

    public GameModel() {
    }

    public GameModel(int id, int userOneId, int userTowId, int gameBoard, String winner, Date playDate) {
        this.id = id;
        this.userOneId = userOneId;
        this.userTowId = userTowId;
        this.gameBoard = gameBoard;
        this.winner = winner;
        this.playDate = playDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserOneId() {
        return userOneId;
    }

    public void setUserOneId(int userOneId) {
        this.userOneId = userOneId;
    }

    public int getUserTowId() {
        return userTowId;
    }

    public void setUserTowId(int userTowId) {
        this.userTowId = userTowId;
    }

    public int getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int gameBoard) {
        this.gameBoard = gameBoard;
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
