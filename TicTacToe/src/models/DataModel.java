/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Kimo Store
 */
public class DataModel implements Serializable {

    UserModel user;
    GameModel game;
    int state;
    String player;
    String rival;

    public DataModel() {
    }

    public DataModel(int state) {
        this.state = state;
    }

    public DataModel(UserModel user, int state) {
        this.user = user;
        this.state = state;
    }

    public DataModel(GameModel game, int state) {
        this.game = game;
        this.state = state;
    }

    public DataModel(int state, String player, String rival) {
        this.state = state;
        this.player = player;
        this.rival = rival;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
