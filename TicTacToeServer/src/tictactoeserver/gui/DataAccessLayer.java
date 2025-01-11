
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

    public static UserModel getUserData(String userName) {
        UserModel user = new UserModel();
        try {
            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS WHERE USER_NAME = ?");
            pst.setString (1, userName);
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
        return user;
    }
    public static int getUsersCount() {
        try {
            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS");
            rs = pst.executeQuery();
            while (rs.next()) {
                i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        return i;
    }
    public static boolean insertData(UserModel u){
        try {
            PreparedStatement pst = conection.prepareStatement("INSERT INTO USERS (USER_NAME,USER_EMAIL,USER_PASSWORD,USER_IMG) VALUES (?,?,?,?)");
            
            pst.setString (1, u.getName());
            pst.setString (2, u.getEmail());
            pst.setString (3, u.getPassword());
            pst.setString (4, u.getImage());
            int isUpdate= pst.executeUpdate();
            if(isUpdate > 0)
            {
                System.out.println("Inserted succ.");            
                return true;
            }
            else{
                System.out.println("Inserted failed");
                return false;
            }                     
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }
}
