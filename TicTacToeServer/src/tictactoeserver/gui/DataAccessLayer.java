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
import shared.AppStrings;

public class DataAccessLayer {

    private static Connection conection;
    private static ResultSet rs;
    protected static int usersCount;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            conection = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getUserDataLogin(String userName, String pass) {
        try {

            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
            pst.setString(1, userName);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("User found: " + rs.getString("USER_NAME"));
                return AppStrings.SIGNIN_DONE;
            } else {
                System.out.println("No user found with the given credentials.");
                return AppStrings.SIGNIN_FAILED;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            return AppStrings.SIGNIN_FAILED;
        } catch (NullPointerException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            return AppStrings.SIGNIN_FAILED;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("rs != null");
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int getUsersCount() {
        usersCount = 0;
        try {
            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS");
            rs = pst.executeQuery();
            while (rs.next()) {

                usersCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersCount;

    }

    public static String insertData(UserModel u) {
        try {
            PreparedStatement pst = conection.prepareStatement("INSERT INTO USERS (USER_NAME,USER_EMAIL,USER_PASSWORD,USER_IMG) VALUES (?,?,?,?)");

            pst.setString(1, u.getName());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            pst.setString(4, u.getImage());
            int isUpdate = pst.executeUpdate();
            if (isUpdate > 0) {
                System.out.println("Inserted succ.");
                return AppStrings.SIGNUP_DONE;
            } else {
                System.out.println("Inserted failed");
                return AppStrings.SIGNUP_FAILED;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            return AppStrings.SIGNUP_FAILED;
        }

    }

    public static UserModel getUserData(String userName, String pass) {

        UserModel user = new UserModel();
        try {

            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
            pst.setString(1, userName);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(AppStrings.USER_ID));
                user.setName(rs.getString(AppStrings.USER_NAME));
                user.setEmail(rs.getString(AppStrings.USER_EMAIL));
                user.setImage(rs.getString(AppStrings.USER_IMG));
                user.setIsInGame(rs.getBoolean(AppStrings.IS_INGAME));
                user.setIsOnline(rs.getBoolean(AppStrings.IS_ONLINE));
                user.setLosses(rs.getInt(AppStrings.NO_OF_LOSSES));
                user.setWins(rs.getInt(AppStrings.NO_OF_WINS));
                user.setScore(rs.getInt(AppStrings.USER_SCORE));
                user.setNumOfGames(rs.getInt(AppStrings.NO_OF_GAMES));
                System.out.println("User found: " + rs.getString("USER_NAME"));
                return user;
            } else {
                System.out.println("No user found with the given credentials.");
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);

        } catch (NullPointerException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("rs != null");
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
