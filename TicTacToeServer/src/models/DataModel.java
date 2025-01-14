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
