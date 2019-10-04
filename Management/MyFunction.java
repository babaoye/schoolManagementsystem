/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER1
 */
public class MyFunction {
    
    public static int countdata(String Tablename){
    int Total=0;
    Connection con=JavaConnection.ConnectDB();
    Statement st ;
    
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(*) As 'Total' From Admission");
            
            while(rs.next()){
            Total=rs.getInt(1);
            }
        } catch (SQLException ex) {
           // Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       
    return Total;
    }
}
