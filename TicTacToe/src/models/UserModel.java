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
public class UserModel {

    int id;
    String name;
    String password;
    String email;
    String image;
    int score;
    int numOfGames;
    int wins;
    int losses;

    public UserModel(int id, String name, String password, String email, String image, int score, int numOfGames, int wins, int losses) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.image = image;
        this.score = score;
        this.numOfGames = numOfGames;
        this.wins = wins;
        this.losses = losses;
    }

}
