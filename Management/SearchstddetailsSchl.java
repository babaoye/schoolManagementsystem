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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER1
 */
public class SearchstddetailsSchl extends javax.swing.JFrame {
    int xx;
    int xy;
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form SearchstddetailsSchl
     */
    
    public SearchstddetailsSchl() {
        con=JavaConnection.ConnectDB();
        initComponents();
        CountTotalStd();
        CountStudyingStd();
        CountLeftStd();
        CountMaleStd();
        CountFemaleStd();
    }

     public void CountTotalStd(){
        try {
            String sql="select count(*) as Class from SchlAdmission";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jTextField8.setText(rs.getString("Class"));
            }   } catch (SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
    
      public void CountStudyingStd(){
        try {
            String sql="select count(*) as StudyStatus from SchlAdmission where StudyStatus='Studying'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jTextField9.setText(rs.getString("StudyStatus"));
            }   } catch (SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
      
       public void CountLeftStd(){
        try {
            String sql="select count(*) as StudyStatus from SchlAdmission where StudyStatus='Left'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jTextField6.setText(rs.getString("StudyStatus"));
            }   } catch (SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
       
        public void CountMaleStd(){
        try {
            String sql="select count(*) as Sex from SchlAdmission where Sex='Male'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jTextField5.setText(rs.getString("Sex"));
            }   } catch (SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
        
         public void CountFemaleStd(){
        try {
            String sql="select count(*) as Sex from SchlAdmission where Sex='Female'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jTextField7.setText(rs.getString("Sex"));
            }   } catch (SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
    
    public ArrayList<StdDetailsSchlGeneric> PopulateFrmDataBase(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    String sql="select * from SchlAdmission where Std_No='"+jTextField1.getText()+"'";
    ResultSet rs;
    Statement st;
    try {
        Class.forName("org.sqlite.JDBC");
         Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric pop;
    while(rs.next()){
        
    pop =new StdDetailsSchlGeneric (rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(pop);
    }
    }   
    catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
    
    public ArrayList<StdDetailsSchlGeneric> PopulateByClass(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    String sql="select * from SchlAdmission where Class='"+jComboBox1.getSelectedItem()+"'";
    ResultSet rs;
    Statement st;;
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric gen;
    while(rs.next()){
    gen=new StdDetailsSchlGeneric(rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(gen);
    }
    
    }
    catch(ClassNotFoundException | SQLException ex){
             Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public ArrayList<StdDetailsSchlGeneric> PopulateAll(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    ResultSet rs;
    Statement st;
    String sql="select * from SchlAdmission ";
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric pop;
    while(rs.next()){
    pop=new StdDetailsSchlGeneric(rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(pop);
    }
          
    }   catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
       public ArrayList<StdDetailsSchlGeneric> PopulateByMale(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    ResultSet rs;
    Statement st;
    String sql="select * from SchlAdmission where Sex='"+jRadioButton4.getText()+"' ";
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric pop;
    while(rs.next()){
    pop=new StdDetailsSchlGeneric(rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(pop);
    }
          
    }   catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
       public ArrayList<StdDetailsSchlGeneric> PopulateByFemale(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    ResultSet rs;
    Statement st;
    String sql="select * from SchlAdmission where Sex='"+jRadioButton3.getText()+"'";
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric pop;
    while(rs.next()){
    pop=new StdDetailsSchlGeneric(rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(pop);
    }
          
    }   catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
       public ArrayList<StdDetailsSchlGeneric> PopulateByLeft(){
    ArrayList<StdDetailsSchlGeneric> list=new ArrayList<>();
    try{
    Class.forName("org.sqlite.JDBC");
    Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
    ResultSet rs;
    Statement st;
    String sql="select * from SchlAdmission where Sex='"+jRadioButton2.getText()+"'";
    st=con.createStatement();
    rs=st.executeQuery(sql);
    StdDetailsSchlGeneric pop;
    while(rs.next()){
    pop=new StdDetailsSchlGeneric(rs.getInt("Std_No"),
                                    rs.getString("Name"),
                                        rs.getString("FathersName"),
                                        rs.getString("Class"),
                                            rs.getString("DOB"), 
                                                rs.getString("DateOfAdmission"), 
                                                rs.getString("LeavingDate"),
                                            rs.getInt("MobileTelNo"),
                                                rs.getInt("Emergency"),
                                            rs.getInt("AdmissionFee"),
                                            rs.getString("StudyStatus"),
                                            rs.getString("HomeAdd"),
                                            rs.getString("Sex"),
                                            rs.getInt("HomeTelNo"));
    list.add(pop);
    }
          
    }   catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jTextField1 = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();

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
        jlabel_username.setText("SEARCH STUDENTS DETAILS");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jlabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("ALL");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLASS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

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

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("LEFT STUDENT");
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

        jRadioButton3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("FEMALE");
        jRadioButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("MALE");
        jRadioButton4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3))
                        .addGap(31, 31, 31))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "FNAME", "CLASS", "DOB", "DOA", "DOL", "PHONE NO", "EMERGENCY NO", "FEE", "STATUS", "ADDRESS", "GENDER", "FAMILY-NO"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FEMALE STUDENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MALE STUDENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LEFT STUDENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PRINT TABLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL STUDENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STUDYING STUDENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7))
                        .addGap(0, 29, Short.MAX_VALUE))))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       setVisible(false);
       FeeTab pp=new FeeTab();
       pp.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
        ArrayList<StdDetailsSchlGeneric> list=PopulateAll();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[ 14];
        for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getStd_No();
        row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);           
        }
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton1.isSelected()){
        ArrayList<StdDetailsSchlGeneric> list=PopulateByMale();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[ 14];
        for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getStd_No();
        row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);           
        }
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
         if(jRadioButton1.isSelected()){
        ArrayList<StdDetailsSchlGeneric> list=PopulateByFemale();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[ 14];
        for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getStd_No();
        row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);           
        }
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
         if(jRadioButton1.isSelected()){
        ArrayList<StdDetailsSchlGeneric> list=PopulateByLeft();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[ 14];
        for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getStd_No();
        row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);           
        }
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
        
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
       
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try {
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(SearchstddetailsSchl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           ArrayList<StdDetailsSchlGeneric> list=PopulateFrmDataBase();
           DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
           model.setRowCount(0);
           Object[] row=new Object[14];
           for(int i=0; i<list.size();i++){
           row[0] =list.get(i).getStd_No();
           row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);
           }      
       }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.equals(jComboBox1.getSelectedItem())){
        ArrayList<StdDetailsSchlGeneric> list=PopulateByClass();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[14];
        for(int i=0; i<list.size();i++){
        row[0]=list.get(i).getStd_No();
        row[1]=list.get(i).getName();
           row[2]=list.get(i).getFathersName();
           row[3]=list.get(i).getClass();
           row[4]=list.get(i).getDOB();
           row[5]=list.get(i).getDateOfAdmission();
           row[6]=list.get(i).getLeavingDate();
           row[7]=list.get(i).getMobileTelNo();
           row[8]=list.get(i).getEmergency();
           row[9]=list.get(i).getAdmissionFee();
           row[10]=list.get(i).getStudyStatus();
           row[11]=list.get(i).getHomeAdd();
           row[12]=list.get(i).getSex();
           row[13]=list.get(i).getHomeTelNo();
           model.addRow(row);
        }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
      char c=evt.getKeyChar();
      if(!((Character.isDigit(c))||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
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
            java.util.logging.Logger.getLogger(SearchstddetailsSchl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchstddetailsSchl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchstddetailsSchl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchstddetailsSchl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchstddetailsSchl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    public javax.swing.JLabel jlabel_username;
    // End of variables declaration//GEN-END:variables
}
