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

    private static final long serialVersionUID = 1L;
    UserModel user;
    int gameMove;
    int state;
    String player;
    String rival;
    String response;
    int rivalScore;

    public int getRivalScore() {
        return rivalScore;
    }

    public void setRivalScore(int rivalScore) {
        this.rivalScore = rivalScore;
    }

    public DataModel(int state) {
        this.state = state;
    }

    public DataModel(String response) {
        this.response = response;
    }

    public DataModel() {

    }

    public DataModel(String rival, String response) {
        this.rival = rival;
        this.response = response;
    }

    public DataModel(UserModel user, int state) {
        this.user = user;
        this.state = state;
    }

    public DataModel(UserModel user, String response) {
        this.user = user;
        this.response = response;
    }

    public DataModel(int game, int state) {
        this.gameMove = game;
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

    public int getGameMove() {
        return gameMove;
    }

    public void setGameMove(int game) {
        this.gameMove = game;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
