/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER1
 */
public class SearchStdDetails extends javax.swing.JFrame {
int xx;
int xy;
Connection con;
PreparedStatement pst;
ResultSet rs;
    /**
     * Creates new form SearchStdDetails
     */
    public SearchStdDetails() {
        initComponents();
        con=JavaConnection.ConnectDB();
        StudentsList();
    }
    public ArrayList<SearchStdDetailsjnr> Populate(){
    ArrayList<SearchStdDetailsjnr> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        String sql="select * from Admission";
        Statement st;
        ResultSet rs;
        st=con.createStatement();
        rs=st.executeQuery(sql);
        SearchStdDetailsjnr c_list;
        while(rs.next()){
           c_list=new SearchStdDetailsjnr(rs.getString("Add_Id"),
                                          rs.getString("Name"),
                                          rs.getString("F_name"),
                                          rs.getString("Class"),
                                          rs.getString("Term"),
                                          rs.getInt("Doa"),
                                          rs.getString("last_schl"),
                                          rs.getInt("Tel_no"),
                                          rs.getInt("C_fee"),
                                          rs.getString("Discount"),
                                          rs.getString("left"),
                                          rs.getString("P_add"),
                                          rs.getString("ExamPassed")); 
         list.add(c_list);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);        
    }
    
    
   return list;
    }
    public ArrayList<SearchStdDetailsjnr> PopulateByDpt(){
    ArrayList<SearchStdDetailsjnr> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        String sql="select * from Admission where Class='"+jComboBox1.getSelectedItem()+"'";
        Statement st;
        ResultSet rs;
        st=con.createStatement();
        rs=st.executeQuery(sql);
        SearchStdDetailsjnr c_list;
        while(rs.next()){
           c_list=new SearchStdDetailsjnr(rs.getString("Add_Id"),
                                          rs.getString("Name"),
                                          rs.getString("F_name"),
                                          rs.getString("Class"),
                                          rs.getString("Term"),
                                          rs.getInt("Doa"),
                                          rs.getString("last_schl"),
                                          rs.getInt("Tel_no"),
                                          rs.getInt("C_fee"),
                                          rs.getString("Discount"),
                                          rs.getString("left"),
                                          rs.getString("P_add"),
                                          rs.getString("ExamPassed")); 
         list.add(c_list);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);        
    }  
   return list;
    }
    public ArrayList<SearchStdDetailsjnr> PopulateByYear(){
    ArrayList<SearchStdDetailsjnr> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        String sql="select * from Admission where Term='"+jComboBox2.getSelectedItem()+"'";
        Statement st;
        ResultSet rs;
        st=con.createStatement();
        rs=st.executeQuery(sql);
        SearchStdDetailsjnr c_list;
        while(rs.next()){
           c_list=new SearchStdDetailsjnr(rs.getString("Add_Id"),
                                          rs.getString("Name"),
                                          rs.getString("F_name"),
                                          rs.getString("Class"),
                                          rs.getString("Term"),
                                          rs.getInt("Doa"),
                                          rs.getString("last_schl"),
                                          rs.getInt("Tel_no"),
                                          rs.getInt("C_fee"),
                                          rs.getString("Discount"),
                                          rs.getString("left"),
                                          rs.getString("P_add"),
                                          rs.getString("ExamPassed")); 
         list.add(c_list);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);        
    }  
   return list;
    }
    public ArrayList<SearchStdDetailsjnr> PopulateByLeft(){
    ArrayList<SearchStdDetailsjnr> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        String sql="select * from Admission where left='"+jRadioButton2.getText()+"'";
        Statement st;
        ResultSet rs;
        st=con.createStatement();
        rs=st.executeQuery(sql);
        SearchStdDetailsjnr c_list;
        while(rs.next()){
           c_list=new SearchStdDetailsjnr(rs.getString("Add_Id"),
                                          rs.getString("Name"),
                                          rs.getString("F_name"),
                                          rs.getString("Class"),
                                          rs.getString("Term"),
                                          rs.getInt("Doa"),
                                          rs.getString("last_schl"),
                                          rs.getInt("Tel_no"),
                                          rs.getInt("C_fee"),
                                          rs.getString("Discount"),
                                          rs.getString("left"),
                                          rs.getString("P_add"),
                                          rs.getString("ExamPassed")); 
         list.add(c_list);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);        
    }  
   return list;
    }
     public ArrayList<SearchStdDetailsjnr> PopulateBySearch(){
    ArrayList<SearchStdDetailsjnr> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        String sql="select *from Admission where Add_Id='"+jTextField1.getText()+"'";
        Statement st;
        ResultSet rs;
        st=con.createStatement();
        rs=st.executeQuery(sql);
        SearchStdDetailsjnr c_list;
        while(rs.next()){
           c_list=new SearchStdDetailsjnr(rs.getString("Add_Id"),
                                          rs.getString("Name"),
                                          rs.getString("F_name"),
                                          rs.getString("Class"),
                                          rs.getString("Term"),
                                          rs.getInt("Doa"),
                                          rs.getString("last_schl"),
                                          rs.getInt("Tel_no"),
                                          rs.getInt("C_fee"),
                                          rs.getString("Discount"),
                                          rs.getString("left"),
                                          rs.getString("P_add"),
                                          rs.getString("ExamPassed")); 
         list.add(c_list);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);        
    }  
   return list;
    }
   
    
    public void StudentsList(){
    String sql="select count(*) from Admission"; 
    try {
        pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
    while(rs.next()){
    jTextField6.setText(Integer.toString(rs.getInt(1)));
    StudentList2();
    StudentList3();
    }
    } catch (SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void StudentList2(){
    String sql="select count(*) from Admission where left='Left'";
    try {
        pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
    while(rs.next()){
    jTextField7.setText(Integer.toString(rs.getInt(1)));
    }
    } catch (SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void StudentList3(){
    String sql="select count(*) from Admission where left='Studying'";
    try {
        pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
    while(rs.next()){
    jTextField8.setText(Integer.toString(rs.getInt(1)));
    }
    } catch (SQLException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlabel_username = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();

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

        jlabel_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel_username.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_username.setText("SEARCH STUDENTS DETAILS(COLLEGE) ");

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
                .addGap(26, 26, 26)
                .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("ALL");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FACULTY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, 158, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YEAR", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstTerm", "SecondTerm", "ThirdTerm" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 128, Short.MAX_VALUE)
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
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Left ");
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STUDENT DETAILS    :");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel5))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)))))
        );

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTAL STUDENT"));

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
                "ID", "NAME", "FNAME", "CLASS", "SEC", "DOA", "LASTCOLLEGE", "PHONE NO", "FEE", "FEE TYPE", "STATUS", "ADDRESS", "EXAM PASSED"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder("LEFT STUDENT"));

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder("STUDYING STUDENT"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 157, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))))
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

        setSize(new java.awt.Dimension(1055, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       setVisible(false);
       StudentSearchFpage ff=new StudentSearchFpage();
       ff.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       if(jRadioButton1.isSelected()){
       jRadioButton2.setSelected(false);
       } 
        if(jRadioButton1.isSelected()){
                ArrayList<SearchStdDetailsjnr> list=Populate();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[13];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getAdd_Id();
        row[1]=list.get(i).getName();
        row[2]=list.get(i).getF_name();
        row[3]=list.get(i).getLass();
        row[4]=list.get(i).getTerm();
        row[5]=list.get(i).getDoa();
        row[6]=list.get(i).getLast_schl();
        row[7]=list.get(i).getTel_no();
        row[8]=list.get(i).getC_fee();
        row[9]=list.get(i).getDiscount();
        row[10]=list.get(i).getLeft();
        row[11]=list.get(i).getP_add();
        row[12]=list.get(i).getExamPassed();        
        model.addRow(row);
        }
            }
            else if(!jRadioButton1.isSelected()){
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            }         
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            jRadioButton1.setSelected(false);
        }
        jRadioButton2.setText("Left");
        if(jRadioButton2.getText().equals("Left")){            
        if(jRadioButton2.isSelected()){
        ArrayList<SearchStdDetailsjnr> list=PopulateByLeft();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[13];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getAdd_Id();
        row[1]=list.get(i).getName();
        row[2]=list.get(i).getF_name();
        row[3]=list.get(i).getLass();
        row[4]=list.get(i).getTerm();
        row[5]=list.get(i).getDoa();
        row[6]=list.get(i).getLast_schl();
        row[7]=list.get(i).getTel_no();
        row[8]=list.get(i).getC_fee();
        row[9]=list.get(i).getDiscount();
        row[10]=list.get(i).getLeft();
        row[11]=list.get(i).getP_add();
        row[12]=list.get(i).getExamPassed();       
        model.addRow(row);
        }
            }
        }
              if(!jRadioButton2.isSelected()){       
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            }    
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
      setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
       setOpacity((float)1.0);
           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
       this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals(jComboBox1.getSelectedItem())){
        ArrayList<SearchStdDetailsjnr> list=PopulateByDpt();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[13];
        for(int i=0;i<list.size();i++){
       row[0]=list.get(i).getAdd_Id();
        row[1]=list.get(i).getName();
        row[2]=list.get(i).getF_name();
        row[3]=list.get(i).getLass();
        row[4]=list.get(i).getTerm();
        row[5]=list.get(i).getDoa();
        row[6]=list.get(i).getLast_schl();
        row[7]=list.get(i).getTel_no();
        row[8]=list.get(i).getC_fee();
        row[9]=list.get(i).getDiscount();
        row[10]=list.get(i).getLeft();
        row[11]=list.get(i).getP_add();
        row[12]=list.get(i).getExamPassed();     
        model.addRow(row);
        }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
       if(jComboBox2.getSelectedItem().equals(jComboBox2.getSelectedItem())){
        ArrayList<SearchStdDetailsjnr> list=PopulateByYear();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[13];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getAdd_Id();
        row[1]=list.get(i).getName();
        row[2]=list.get(i).getF_name();
        row[3]=list.get(i).getLass();
        row[4]=list.get(i).getTerm();
        row[5]=list.get(i).getDoa();
        row[6]=list.get(i).getLast_schl();
        row[7]=list.get(i).getTel_no();
        row[8]=list.get(i).getC_fee();
        row[9]=list.get(i).getDiscount();
        row[10]=list.get(i).getLeft();
        row[11]=list.get(i).getP_add();
        row[12]=list.get(i).getExamPassed();         
        model.addRow(row);
        }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
      ArrayList<SearchStdDetailsjnr> list=PopulateBySearch();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[13];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getAdd_Id();
        row[1]=list.get(i).getName();
        row[2]=list.get(i).getF_name();
        row[3]=list.get(i).getLass();
        row[4]=list.get(i).getTerm();
        row[5]=list.get(i).getDoa();
        row[6]=list.get(i).getLast_schl();
        row[7]=list.get(i).getTel_no();
        row[8]=list.get(i).getC_fee();
        row[9]=list.get(i).getDiscount();
        row[10]=list.get(i).getLeft();
        row[11]=list.get(i).getP_add();
        row[12]=list.get(i).getExamPassed();         
        model.addRow(row);
        }       
      }     
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        jTable1.print();
    } catch (PrinterException ex) {
        Logger.getLogger(SearchStdDetails.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchStdDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchStdDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchStdDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchStdDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchStdDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public javax.swing.JLabel jlabel_username;
    // End of variables declaration//GEN-END:variables
}
