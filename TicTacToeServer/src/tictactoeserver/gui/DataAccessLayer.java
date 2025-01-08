/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UserModel;
import shared.AppStrings;

/**
 *
 * @author Kimo Store
 */
public class DataAccessLayer {

    private static Connection conection;
    private static ResultSet rs;
    protected static int i;

    static {
        i = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            conection = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getUserData() {
        UserModel user = new UserModel();
        try {
            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS");
            rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(AppStrings.USER_ID));
                user.setScore(rs.getInt(AppStrings.USER_SCORE));
                user.setNumOfGames(rs.getInt(AppStrings.NO_OF_GAMES));
                user.setWins(rs.getInt(AppStrings.NO_OF_WINS));
                user.setLosses(rs.getInt(AppStrings.NO_OF_LOSSES));
                user.setIsOnline(rs.getInt(AppStrings.IS_ONLINE) != 0); //false
                user.setIsInGame(rs.getInt(AppStrings.IS_INGAME) != 0); //false
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
