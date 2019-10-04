/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER1
 */
public class SchoolAttendanceCollege extends javax.swing.JFrame {
int xx;
int xy;
Connection con;
PreparedStatement pst;
ResultSet rs;
    /**
     * Creates new form SchoolAttendanceCollege
     */
    public SchoolAttendanceCollege() {
        initComponents();
        con=JavaConnection.ConnectDB();
    }
    public void SelectByCombo(){
    if(jComboBox6.getSelectedItem().equals(jComboBox6.getSelectedItem())){
      String sql="select * from StudentsRecord where Month='"+jComboBox6.getSelectedItem()+"'";
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
             jTextField10.setText(rs.getString(1));               
                jTextField12.setText(rs.getString(2));
                jTextField14.setText(rs.getString(3));
                jComboBox4.setSelectedItem(rs.getString(4));
                jTextField20.setText(rs.getString(5));                
                jComboBox5.setSelectedItem(rs.getString(6));
                jTextField21.setText(rs.getString(7));
                jTextField24.setText(rs.getString(8));
                jTextField25.setText(rs.getString(9));
                jTextField28.setText(rs.getString(10));
                jTextField22.setText(rs.getString(11));
                jTextField23.setText(rs.getString(12));
                jTextField26.setText(rs.getString(13));
                jTextField27.setText(rs.getString(14)); 
                jComboBox6.setSelectedItem(rs.getString(15));
                pst.close();
                rs.close();
                
            }
            else{
            JOptionPane.showMessageDialog(null,"Incorrect droped down Value"+";"+
                    "Hint:check your Month drop down for errors in selection");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    }    
    }
    public void GetRowCount(){       
        con=JavaConnection.ConnectDB();
    String sql="select count(*) as Std_Id from StudentsRecord where Std_Id='"+jTextField3.getText()+"'";
    try {
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         while(rs.next()){          
         jTextField4.setText( rs.getString("Std_Id"));        
         }         
    } catch (SQLException ex) {
        Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }
    
     public void GetRowCountYear(){       
        con=JavaConnection.ConnectDB();
    String sql="select count(*) as Std_Id from StudentsRecord where Std_Id='"+jTextField10.getText()+"'";
    try {
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         while(rs.next()){          
         jTextField8.setText( rs.getString("Std_Id"));        
         }         
    } catch (SQLException ex) {
        Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    int TotalPercentage=100;
         String percent="%";
         int dayText=Integer.parseInt(jTextField8.getText());
     int days=Integer.parseInt(jTextField21.getText());
     int t_days=days*dayText;
     jTextField21.setText(Integer.toString(t_days));
     int attend=Integer.parseInt(jTextField24.getText());
     int t_atnd=attend*dayText;
     jTextField24.setText(Integer.toString(t_atnd));
     int absence=Integer.parseInt(jTextField25.getText());
     int t_abs=absence*dayText;
     jTextField25.setText(Integer.toString(t_abs));
     int leave=Integer.parseInt(jTextField28.getText());
     int t_leave=leave*dayText;
     jTextField28.setText(Integer.toString(t_leave));
     
     double day=Double.parseDouble(jTextField21.getText());
     double p_days=Double.parseDouble(jTextField21.getText());
     double p_attend=Double.parseDouble(jTextField24.getText());          
     double p_absence=Double.parseDouble(jTextField25.getText());    
     double p_Abs=(p_absence/day)*TotalPercentage;
     p_Abs=Math.round(p_Abs);
     jTextField26.setText(Double.toString(p_Abs)+percent);
     double p_Atnd=p_attend/day*TotalPercentage;
      p_Atnd=Math.round(p_Atnd);
     jTextField23.setText(Double.toString(p_Atnd)+percent);
     double p_day=p_days/day*TotalPercentage;
    p_day=Math.round(p_day);
     jTextField22.setText(Double.toString(p_day)+percent);
      double p_leave=Double.parseDouble(jTextField28.getText());
     double p_lev=p_leave/day*TotalPercentage;
      p_lev=Math.round(p_lev);
     jTextField27.setText(Double.toString(p_lev)+percent);
    }
     public void CalculateByIds(){
         int TotalPercentage=100;
         String percent="%";
     int days=Integer.parseInt(jTextField9.getText());
     int attend=Integer.parseInt(jTextField11.getText());
     int absence=Integer.parseInt(jTextField13.getText());
     int leave=Integer.parseInt(jTextField15.getText());
     int subtraction=days-attend;
     jTextField13.setText(Integer.toString(subtraction));
     int p_Abs=absence/days*TotalPercentage;
     jTextField18.setText(Integer.toString(p_Abs)+percent);
     int p_Atnd=attend/days*TotalPercentage;
     jTextField17.setText(Integer.toString(p_Atnd)+percent);
     int p_day=days/days*TotalPercentage;
     jTextField16.setText(Integer.toString(p_day)+percent);
     int p_lev=leave/days*TotalPercentage;
     jTextField19.setText(Integer.toString(p_lev)+percent);
    
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField20 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STUDENT ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("School Management System");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("×");
        jLabel4.setToolTipText("");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("-");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 611, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTHS RECORD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STUDENT NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FATHER NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3" }));

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SECTION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));

        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL DAYS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jTextField11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ATTENDANCE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });

        jTextField13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ABSENCE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LEAVES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL DAYS %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ATTENDANCE %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ABSENCE %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LEAVES %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTHS RECORD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField10.setToolTipText("This is used to search students Id");
        jTextField10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });

        jTextField12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STUDENT NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FATHER NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3" }));

        jTextField20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SECTION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox6.setToolTipText("This selects the value Month and helps to search in relating to students attendance");

        jTextField21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL DAYS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL DAYS %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ATTENDANCE %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ATTENDANCE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ABSENCE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL ABSENCE %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LEAVES %", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LEAVES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENTS ATTENDANCE ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("YEARLY ATTENDANCE RECORD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField9)
                                .addComponent(jComboBox2, 0, 151, Short.MAX_VALUE))
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField16)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       setVisible(false);
       StartPage pg=new StartPage();
       pg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
         setOpacity((float)1.0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
       this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String sql="insert into StudentsRecord (Std_Id,Std_name,Fths_name,Class,Section,Year,Days,Attendance,Absence,Leaves,D_P,A_P,Ab_P,L_P,Month) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        pst=con.prepareStatement(sql);
        pst.setString(1,jTextField3.getText());      
        pst.setString(2,jTextField5.getText());
        pst.setString(3,jTextField6.getText());
        pst.setString(4,jComboBox1.getSelectedItem().toString());
        pst.setString(5,jTextField7.getText());       
        pst.setString(6,jComboBox3.getSelectedItem().toString());
        pst.setString(7,jTextField9.getText());
        pst.setString(8,jTextField11.getText());
        pst.setString(9,jTextField13.getText());
        pst.setString(10,jTextField15.getText());
        pst.setString(11,jTextField16.getText());
        pst.setString(12,jTextField17.getText());
        pst.setString(13,jTextField18.getText());
        pst.setString(14,jTextField19.getText());
        pst.setString(15,jComboBox2.getSelectedItem().toString());
        pst.executeUpdate();
        GetRowCount();        
        JOptionPane.showMessageDialog(null,"All inputs Done");
    } catch (SQLException ex) {
        Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String sql="update StudentsRecord set Std_Id=?,Std_name=?,Fths_name=?,Class=?,Section=?,Year=?,Days=?,Attendance=?,Absence=?,Leaves=?,D_P=?,A_P=?,Ab_P=?,L_P=?,Month=? where Std_Id='"+jTextField3.getText()+"'";
    try {
        pst=con.prepareStatement(sql);
        pst.setString(1,jTextField3.getText());       
        pst.setString(2,jTextField5.getText());
        pst.setString(3,jTextField6.getText());
        pst.setString(4,jComboBox1.getSelectedItem().toString());
        pst.setString(5,jTextField7.getText());      
        pst.setString(6,jComboBox3.getSelectedItem().toString());
        pst.setString(7,jTextField9.getText());
        pst.setString(8,jTextField11.getText());
        pst.setString(9,jTextField13.getText());
        pst.setString(10,jTextField15.getText());
        pst.setString(11,jTextField16.getText());
        pst.setString(12,jTextField17.getText());
        pst.setString(13,jTextField18.getText());
        pst.setString(14,jTextField19.getText());
        pst.setString(15,jComboBox2.getSelectedItem().toString());
        pst.execute();
        JOptionPane.showMessageDialog(null,"All inputs Done");
    } catch (SQLException ex) {
        Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String sql="delete from StudentsRecord where Std_Id=?";
    try {
        pst=con.prepareStatement(sql);
         pst.setString(1,jTextField3.getText());
         pst.execute();
         JOptionPane.showMessageDialog(null,"DELETED STUDENT FROM RECORD");
    } catch (SQLException ex) {
        Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jTextField3.setText(null);
       jTextField4.setText(null);
       jTextField3.setText(null);
       jTextField4.setText(null);
       jTextField5.setText(null);
       jTextField6.setText(null);
       jTextField7.setText(null);
       jTextField8.setText(null);
       jTextField9.setText(null);
       jTextField10.setText(null);
       jTextField11.setText(null);
       jTextField12.setText(null);
       jTextField13.setText(null);
       jTextField14.setText(null);
       jTextField15.setText(null);
       jTextField16.setText(null);
       jTextField17.setText(null);
       jTextField18.setText(null);
       jTextField19.setText(null);
       jTextField20.setText(null);
       jTextField21.setText(null);
       jTextField22.setText(null);
       jTextField23.setText(null);
       jTextField24.setText(null);
       jTextField25.setText(null);
       jTextField26.setText(null);
       jTextField27.setText(null);
       jTextField28.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
        String sql="select * from StudentsRecord where Std_Id='"+jTextField10.getText()+"'";
            try {
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                SelectByCombo();
                GetRowCountYear();
                 JOptionPane.showMessageDialog(null,"All search is completed");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check the Registration and Retype");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            
            }
        
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           int TotalPercentage=100;
         String percent="%";
        int days=Integer.parseInt(jTextField9.getText());
        int p_day=days/days*TotalPercentage;
     jTextField16.setText(Integer.toString(p_day)+percent);
       }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            double TotalPercentage=100;
         String percent="%";
     double days=Double.parseDouble(jTextField9.getText());
     double attend=Double.parseDouble(jTextField11.getText());     
     double subtraction=days-attend;
     jTextField13.setText(Double.toString(subtraction));
     double absence=Double.parseDouble(jTextField13.getText());    
     double p_Abs=(absence/days)*TotalPercentage;
     p_Abs=Math.round(p_Abs);
     jTextField18.setText(Double.toString(p_Abs)+percent);
     double p_Atnd=attend/days*TotalPercentage;
      p_Atnd=Math.round(p_Atnd);
     jTextField17.setText(Double.toString(p_Atnd)+percent);
     double p_day=days/days*TotalPercentage;
    p_day=Math.round(p_day);
     jTextField16.setText(Double.toString(p_day)+percent);
      double leave=Double.parseDouble(jTextField15.getText());
     double p_lev=leave/days*TotalPercentage;
      p_lev=Math.round(p_lev);
     jTextField19.setText(Double.toString(p_lev)+percent);
     
       }
    }//GEN-LAST:event_jTextField11KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolAttendanceCollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolAttendanceCollege().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
