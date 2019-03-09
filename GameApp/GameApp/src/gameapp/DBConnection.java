/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author x17124719
 */
public class DBConnection {
    public static void main (String[] args) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
    
        String user = "";
        String pass = "";
    
    
        try{
            myConn = DriverManager.getConnection("", user, pass);
        
                 
            myStmt = myConn.createStatement();
        
            myRs = myStmt.executeQuery("select * from questions");
        
            while (myRs.next()) {
                System.out.println(myRs.getString("")+ "" + myRs.getString("Question_one"));
            }
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
             if (myRs != null){
                myRs.close();
            }
    
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null){
                myConn.close();
            
            }
        }
    }
}
