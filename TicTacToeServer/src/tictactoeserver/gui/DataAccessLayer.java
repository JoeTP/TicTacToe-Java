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

    public static Boolean getUserDataLogin(String userName, String pass) {

        Boolean isExist = false;
        try {

            PreparedStatement pst = conection.prepareStatement("SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
            pst.setString(1, userName);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("User found: " + rs.getString("USER_NAME"));
                return true;
            } else {
                System.out.println("No user found with the given credentials.");
            }

        } catch (SQLException ex) {
                  System.out.println("not on try on DataAccessLayer");
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

        return isExist;
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

    public static boolean insertData(UserModel u) {
        try {
            PreparedStatement pst = conection.prepareStatement("INSERT INTO USERS (USER_NAME,USER_EMAIL,USER_PASSWORD,USER_IMG) VALUES (?,?,?,?)");

            pst.setString(1, u.getName());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            pst.setString(4, u.getImage());
            int isUpdate = pst.executeUpdate();
            if (isUpdate > 0) {
                System.out.println("Inserted succ.");
                return true;
            } else {
                System.out.println("Inserted failed");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
