/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class SchoolDataBase {
    Connection conn;
    public static Connection ConnectDB(){
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER1\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        return con;
    
    }catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex);
    return null;
    }

    }
}
