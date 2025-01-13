/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Kimo Store
 */
public class DataModel implements Serializable{
     private static final long serialVersionUID = -5159020983329262064L;
     private transient ObservableList<String> usernames = FXCollections.observableArrayList();

    UserModel user;
    GameModel game;
    String activePlayers;

    public void setUsernames(ObservableList<String> usernames) {
        this.usernames = usernames;
    }

    public void setActivePlayers(String activePlayers) {
        this.activePlayers = activePlayers;
    }

    public DataModel(String activePlayers, int state) {
        this.activePlayers = activePlayers;
        this.state = state;
    }

    public ObservableList<String> getUsernames() {
        return usernames;
    }

    public String getActivePlayers() {
        return activePlayers;
    }
    
    
    int state;
      public DataModel(ObservableList<String> usernames, int state) {
        this.usernames = FXCollections.observableArrayList(usernames); // Create a new ObservableList
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
