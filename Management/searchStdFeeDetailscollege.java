/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER1
 */
public class searchStdFeeDetailscollege extends javax.swing.JFrame {
int xx;
        int xy;
    /**
     * Creates new form searchStdFeeDetailscollege
     */
    public searchStdFeeDetailscollege() {
        initComponents();
       Connection con=JavaConnection.ConnectDB();
    }
    public void getRowCount(){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int occur=0;
    String occurrence=JOptionPane.showInputDialog("please input");
    for(int i=0; i<jTable1.getRowCount(); i++){
    for(int col=0; col<jTable1.getColumnCount();col++){
    if(jTable1.getValueAt(i, col).equals(occurrence)){
        
    occur++;
    }
    }
    }
    System.out.println(occur);
    
    }

    public ArrayList<UserNew> List(){
        ArrayList<UserNew> list=new ArrayList<>();
        String sql="select * from searchFeescollege where R_No='"+jTextField1.getText()+"'";
        String sql1="select *from searchFeescollege";
   Statement st;
   ResultSet rs;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
   st=con.createStatement();
   rs=st.executeQuery(sql1);
   UserNew tus;
   while(rs.next()){
   tus=new UserNew(rs.getInt("R_no"),
               rs.getInt("ID"),
               rs.getString("Name"),
               rs.getString("F_name"),
               rs.getString("Class"),
               rs.getInt("Day"),
               rs.getString("month"),
               rs.getInt("year"),
               rs.getInt("MonthlyFee"),
               rs.getInt("AnnualFee"),
               rs.getInt("OtherCharge"),
               rs.getInt("TotalFee"),
               rs.getInt("Received"),
               rs.getInt("Balance"),
               rs.getInt("FeeReceipt"));
     list.add(tus);
   
   }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list;
    } 
     public ArrayList<UserNew> Class(){
        ArrayList<UserNew> list=new ArrayList<>();
        String sql="select * from searchFeescollege where Class='"+jComboBox3.getSelectedItem()+"'";
        
   Statement st;
   ResultSet rs;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
   st=con.createStatement();
   rs=st.executeQuery(sql);
   UserNew tus;
   while(rs.next()){
   tus=new UserNew(rs.getInt("R_no"),
               rs.getInt("ID"),
               rs.getString("Name"),
               rs.getString("F_name"),
               rs.getString("Class"),
               rs.getInt("Day"),
               rs.getString("month"),
               rs.getInt("year"),
               rs.getInt("MonthlyFee"),
               rs.getInt("AnnualFee"),
               rs.getInt("OtherCharge"),
               rs.getInt("TotalFee"),
               rs.getInt("Received"),
               rs.getInt("Balance"),
               rs.getInt("FeeReceipt"));
     list.add(tus);
   
   }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list;
    } 
    
     public ArrayList<UserNew> Search(){
        ArrayList<UserNew> list=new ArrayList<>();
        String sql="select * from searchFeescollege where ID='"+jTextField1.getText()+"'";
        
   Statement st;
   ResultSet rs;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
   st=con.createStatement();
   rs=st.executeQuery(sql);
   UserNew tus;
   while(rs.next()){
   tus=new UserNew(rs.getInt("R_no"),
               rs.getInt("ID"),
               rs.getString("Name"),
               rs.getString("F_name"),
               rs.getString("Class"),
               rs.getInt("Day"),
               rs.getString("month"),
               rs.getInt("year"),
               rs.getInt("MonthlyFee"),
               rs.getInt("AnnualFee"),
               rs.getInt("OtherCharge"),
               rs.getInt("TotalFee"),
               rs.getInt("Received"),
               rs.getInt("Balance"),
               rs.getInt("FeeReceipt"));
     list.add(tus);
   
   }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list;
    } 
     public ArrayList<UserNew> Year(){
        ArrayList<UserNew> list=new ArrayList<>();
        String sql="select * from searchFeescollege where Year='"+jComboBox2.getSelectedItem()+"'";
        
   Statement st;
   ResultSet rs;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
   st=con.createStatement();
   rs=st.executeQuery(sql);
   UserNew tus;
   while(rs.next()){
   tus=new UserNew(rs.getInt("R_no"),
               rs.getInt("ID"),
               rs.getString("Name"),
               rs.getString("F_name"),
               rs.getString("Class"),
               rs.getInt("Day"),
               rs.getString("month"),
               rs.getInt("year"),
               rs.getInt("MonthlyFee"),
               rs.getInt("AnnualFee"),
               rs.getInt("OtherCharge"),
               rs.getInt("TotalFee"),
               rs.getInt("Received"),
               rs.getInt("Balance"),
               rs.getInt("FeeReceipt"));
     list.add(tus);
   
   }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list;
    } 
      public ArrayList<UserNew> Month(){
        ArrayList<UserNew> list=new ArrayList<>();
        String sql="select * from searchFeescollege where Month='"+jComboBox1.getSelectedItem()+"'";
        
   Statement st;
   ResultSet rs;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
   st=con.createStatement();
   rs=st.executeQuery(sql);
   UserNew tus;
   while(rs.next()){
   tus=new UserNew(rs.getInt("R_no"),
               rs.getInt("ID"),
               rs.getString("Name"),
               rs.getString("F_name"),
               rs.getString("Class"),
               rs.getInt("Day"),
               rs.getString("month"),
               rs.getInt("year"),
               rs.getInt("MonthlyFee"),
               rs.getInt("AnnualFee"),
               rs.getInt("OtherCharge"),
               rs.getInt("TotalFee"),
               rs.getInt("Received"),
               rs.getInt("Balance"),
               rs.getInt("FeeReceipt"));
     list.add(tus);
   
   }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list;
      }
     public void getSum(){
   
          int total=0;
     int received=0;
     int balance=0;    
     for(int i=0;i<jTable1.getRowCount(); i++){     
         total=total+Integer.parseInt(jTable1.getValueAt(i,11).toString());
         received=received+Integer.parseInt(jTable1.getValueAt(i,12).toString());
         balance=balance+Integer.parseInt(jTable1.getValueAt(i,13).toString());         
     }
            jTextField7.setText(Integer.toString(total));
            jTextField5.setText(Integer.toString(received));
            jTextField6.setText(Integer.toString(balance));       
            jTextField7.setEditable(false);
            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
             
               
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
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlabel_username = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, 106, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YEAR", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jComboBox2, 0, 117, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "STUDENT ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("School Management System");
        jLabel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("×");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jlabel_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabel_username.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_username.setText("Search Student Fee Details(Senior School)");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("-");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DEFAULT STUDENTS CLASS");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLASS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nusery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, 0, 101, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox3))
        );

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("All Months");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PRINT TABLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "R_No", "ID", "Name", "S_Name", "Class", "Day", "Month", "Year", "MontlyFee", "AnnualFee", "CopyChar", "TotalFee", "RecievedFee", "Balance"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(986, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        setVisible(false);
        FeeTab pf=new FeeTab();
        pf.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();

        this.setLocation(x-xx, y-xy); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float)1.0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           
        ArrayList<UserNew> list= List();
         DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Object[] row=new Object[14];
         for(int i=0; i<list.size(); i++){
     row[0]=list.get(i).getR_no();
     row[1]=list.get(i).getID();
     row[2]=list.get(i).getName();
     row[3]=list.get(i).getF_name();
     row[4]=list.get(i).getClass();
     row[5]=list.get(i).getDay();
     row[6]=list.get(i).getmonth();
     row[7]=list.get(i).getyear();
     row[8]=list.get(i).getMonthlyFee();
     row[9]=list.get(i).getAnnualFee();
     row[10]=list.get(i).getOtherCharge();
     row[11]=list.get(i).getTotalFee();
     row[12]=list.get(i).getReceived();
     row[13]=list.get(i).getBalance();
model.addRow(row);
     }
         getSum();
       }
       else if(evt.getStateChange()==ItemEvent.DESELECTED){
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
        jTextField7.setText(Integer.toString(0));
            jTextField5.setText(Integer.toString(0));
            jTextField6.setText(Integer.toString(0));
       }
        
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if(jComboBox3.getSelectedItem().equals(jComboBox3.getSelectedItem())){                        
        ArrayList<UserNew> list= Class();
         DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Object[] row=new Object[14];
         for(int i=0; i<list.size(); i++){
     row[0]=list.get(i).getR_no();
     row[1]=list.get(i).getID();
     row[2]=list.get(i).getName();
     row[3]=list.get(i).getF_name();
     row[4]=list.get(i).getClass();
     row[5]=list.get(i).getDay();
     row[6]=list.get(i).getmonth();
     row[7]=list.get(i).getyear();
     row[8]=list.get(i).getMonthlyFee();
     row[9]=list.get(i).getAnnualFee();
     row[10]=list.get(i).getOtherCharge();
     row[11]=list.get(i).getTotalFee();
     row[12]=list.get(i).getReceived();
     row[13]=list.get(i).getBalance();
     model.addRow(row);
     }
         getSum();                   
        } 
      
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){            
            ArrayList<UserNew> list= Search();
         DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Object[] row=new Object[14];
         for(int i=0; i<list.size(); i++){
     row[0]=list.get(i).getR_no();
     row[1]=list.get(i).getID();
     row[2]=list.get(i).getName();
     row[3]=list.get(i).getF_name();
     row[4]=list.get(i).getClass();
     row[5]=list.get(i).getDay();
     row[6]=list.get(i).getmonth();
     row[7]=list.get(i).getyear();
     row[8]=list.get(i).getMonthlyFee();
     row[9]=list.get(i).getAnnualFee();
     row[10]=list.get(i).getOtherCharge();
     row[11]=list.get(i).getTotalFee();
     row[12]=list.get(i).getReceived();
     row[13]=list.get(i).getBalance();
model.addRow(row);
     }
         getSum();
       }
       
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if(jComboBox2.getSelectedItem().equals(jComboBox2.getSelectedItem())){                        
        ArrayList<UserNew> list= Year();
         DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Object[] row=new Object[14];
         for(int i=0; i<list.size(); i++){
     row[0]=list.get(i).getR_no();
     row[1]=list.get(i).getID();
     row[2]=list.get(i).getName();
     row[3]=list.get(i).getF_name();
     row[4]=list.get(i).getClass();
     row[5]=list.get(i).getDay();
     row[6]=list.get(i).getmonth();
     row[7]=list.get(i).getyear();
     row[8]=list.get(i).getMonthlyFee();
     row[9]=list.get(i).getAnnualFee();
     row[10]=list.get(i).getOtherCharge();
     row[11]=list.get(i).getTotalFee();
     row[12]=list.get(i).getReceived();
     row[13]=list.get(i).getBalance();
     model.addRow(row);
     }
         getSum();                   
        } 
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals(jComboBox1.getSelectedItem())){                        
        ArrayList<UserNew> list= Month();
         DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Object[] row=new Object[14];
         for(int i=0; i<list.size(); i++){
     row[0]=list.get(i).getR_no();
     row[1]=list.get(i).getID();
     row[2]=list.get(i).getName();
     row[3]=list.get(i).getF_name();
     row[4]=list.get(i).getClass();
     row[5]=list.get(i).getDay();
     row[6]=list.get(i).getmonth();
     row[7]=list.get(i).getyear();
     row[8]=list.get(i).getMonthlyFee();
     row[9]=list.get(i).getAnnualFee();
     row[10]=list.get(i).getOtherCharge();
     row[11]=list.get(i).getTotalFee();
     row[12]=list.get(i).getReceived();
     row[13]=list.get(i).getBalance();
     model.addRow(row);
     }
         getSum();                   
        } 
       
        
        
        
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        jTable1.print();
    } catch (PrinterException ex) {
        Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c=evt.getKeyChar();
       if(!((Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER))){
       evt.consume();
       getToolkit().beep();
       }
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchStdFeeDetailscollege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchStdFeeDetailscollege().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public javax.swing.JLabel jlabel_username;
    // End of variables declaration//GEN-END:variables
}
