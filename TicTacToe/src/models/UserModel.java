/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Youssif
 */
public class UserModel implements Serializable {

    private static final long serialVersionUID = -5159020983329262064L;

    int id;
    String name;
    String password;
    String email;
    String image;
    public int score = 0;
    public int numOfGames = 0;
    public int wins = 0;
    public int losses = 0;
    public double rate = 0;
    // boolean isInGame;
    // boolean isOnline;

    public UserModel(int id, String name, String password, String email, String image, int score, int numOfGames, int wins, int losses, boolean isInGame, boolean isOnline, double rate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.image = image;
        this.score = score;
        this.numOfGames = numOfGames;
        this.wins = wins;
        this.losses = losses;
        this.rate = rate;

    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public UserModel() {
        id = 0;
        name = "No name";
        password = "No password";
        email = "No email";
        image = "No img";
//        score = 0;
//        numOfGames = 0;
//        wins = 0;
//        losses = 0;

    }

    public UserModel(int id, String name) { // for Login Request
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void updateUserData(boolean isWinner) {

        numOfGames++;
        if (isWinner == true) {
            score += 5;
            wins++;
        } else {
            if (score > 0) {
                score -= 2;
            }
            losses++;
        }
        rate = (wins / numOfGames) * 100;        
    }

}
