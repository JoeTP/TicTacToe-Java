/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kimo Store
 */
public class DataAccessLayer {
    private static Connection con;
    private static ResultSet rs;
    protected static int i;
    static {
        i = 0;
        try {
            Class.forName("org.sqlite.JDBC");           
             con = DriverManager.getConnection ("jdbc:sqlite:database.sqlite");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int getEx(){
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM USERS");
            rs = pst.executeQuery();
            while(rs.next()){
                i++;                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
