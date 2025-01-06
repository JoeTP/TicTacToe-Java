/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Youssif
 */
public class GameModel {

    int id;
    int userOneId;
    int userTowId;
    String winner;
    Date playDate;

    public GameModel(int id, int userOneId, int userTowId, String winner, Date playDate) {
        this.id = id;
        this.userOneId = userOneId;
        this.userTowId = userTowId;
        this.winner = winner;
        this.playDate = playDate;
    }
    
}
