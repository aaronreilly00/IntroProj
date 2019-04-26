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
    
        
    
        try{
            //Get a connection to a database
            myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/webdev2?user=webdev2&password=Nm0JS9J_b!9X");
        
            
            System.out.println("connected?");
                 
            //Create a statement
            myStmt = myConn.createStatement();
        
            //Execute SQL query 
            myRs = myStmt.executeQuery("select * from QUESTIONS");
        
            //Process Model and Price Columns 
            while (myRs.next()) {
                System.out.println(myRs.getString("question")); //+ ", " + myRs.getString("answer"));
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
