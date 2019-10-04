/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author USER1
 */
public class JavaConnection {
    Connection conn;
    public static Connection ConnectDB(){
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    return con;
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
    }
    }
}
