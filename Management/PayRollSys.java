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
public class PayRollSys extends javax.swing.JFrame {
int xx;
PreparedStatement pst;
Connection conn;
ResultSet rs;
int xy;
    /**
     * Creates new form PayRollSys
     */
    public PayRollSys() {
        initComponents();
        conn=JavaConnection.ConnectDB();
        CalculateMthd();       
    }
      public ArrayList<PayRollClass> UserList(){
      ArrayList<PayRollClass> list=new ArrayList<>();
      
    try {
        Class.forName("org.sqlite.JDBC");
              Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
              String sql="select * from PayRollsystem";
              Statement st;
              st=con.createStatement();
              rs=st.executeQuery(sql);
              PayRollClass clas;
              while(rs.next()){
              clas=new PayRollClass(rs.getInt("EmpId"),
                                    rs.getString("Name"),
                                    rs.getString("Department"),
                                    rs.getString("Designation"),
                                    rs.getInt("Day"),
                                    rs.getString("Month"),
                                    rs.getInt("Year"),
                                    rs.getInt("Bsalary"),
                                    rs.getInt("Psalary"),
                                    rs.getInt("salary"),
                                    rs.getInt("deduction"),
                                    rs.getInt("NetSalary"),
                                    rs.getInt("SNo"));
              list.add(clas);
              }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
      
      return list;
      }
       public ArrayList<PayRollClass> UpdateJCombo(){
      ArrayList<PayRollClass> list=new ArrayList<>();
      
    try {
        Class.forName("org.sqlite.JDBC");
              Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
              String sql="select * from PayRollsystem where Month='"+jComboBox4.getSelectedItem()+"'";
              Statement st;
              st=con.createStatement();
              rs=st.executeQuery(sql);
              PayRollClass clas;
              while(rs.next()){
              clas=new PayRollClass(rs.getInt("EmpId"),
                                    rs.getString("Name"),
                                    rs.getString("Department"),
                                    rs.getString("Designation"),
                                    rs.getInt("Day"),
                                    rs.getString("Month"),
                                    rs.getInt("Year"),
                                    rs.getInt("Bsalary"),
                                    rs.getInt("Psalary"),
                                    rs.getInt("salary"),
                                    rs.getInt("deduction"),
                                    rs.getInt("NetSalary"),
                                    rs.getInt("SNo"));
              list.add(clas);
              }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
      
      return list;
      }
      
         public ArrayList<PayRollClass> UpdateJCombo3(){
      ArrayList<PayRollClass> list=new ArrayList<>();
      
    try {
        Class.forName("org.sqlite.JDBC");
              Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
              String sql="select * from PayRollsystem where Year='"+jComboBox3.getSelectedItem()+"'";
              Statement st;
              st=con.createStatement();
              rs=st.executeQuery(sql);
              PayRollClass clas;
              while(rs.next()){
              clas=new PayRollClass(rs.getInt("EmpId"),
                                    rs.getString("Name"),
                                    rs.getString("Department"),
                                    rs.getString("Designation"),
                                    rs.getInt("Day"),
                                    rs.getString("Month"),
                                    rs.getInt("Year"),
                                    rs.getInt("Bsalary"),
                                    rs.getInt("Psalary"),
                                    rs.getInt("salary"),
                                    rs.getInt("deduction"),
                                    rs.getInt("NetSalary"),
                                    rs.getInt("SNo"));
              list.add(clas);
              }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
      
      return list;
      }
       public ArrayList<PayRollClass> UpdateJcombo2(){
       ArrayList<PayRollClass> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        Statement st;
        ResultSet rs;
        String sql="select *from PayRollsystem where Department='"+jComboBox5.getSelectedItem()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        PayRollClass pay;
        while(rs.next()){
        pay=new PayRollClass(rs.getInt("EmpId"),
                                    rs.getString("Name"),
                                    rs.getString("Department"),
                                    rs.getString("Designation"),
                                    rs.getInt("Day"),
                                    rs.getString("Month"),
                                    rs.getInt("Year"),
                                    rs.getInt("Bsalary"),
                                    rs.getInt("Psalary"),
                                    rs.getInt("salary"),
                                    rs.getInt("deduction"),
                                    rs.getInt("NetSalary"),
                                    rs.getInt("SNo"));
              list.add(pay);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
       return list;
       }
            public ArrayList<PayRollClass> UpdateJcombo4(){
       ArrayList<PayRollClass> list=new ArrayList<>();
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        Statement st;
        ResultSet rs;
        String sql="select *from PayRollsystem where Designation='"+jComboBox6.getSelectedItem()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        PayRollClass pay;
        while(rs.next()){
        pay=new PayRollClass(rs.getInt("EmpId"),
                                    rs.getString("Name"),
                                    rs.getString("Department"),
                                    rs.getString("Designation"),
                                    rs.getInt("Day"),
                                    rs.getString("Month"),
                                    rs.getInt("Year"),
                                    rs.getInt("Bsalary"),
                                    rs.getInt("Psalary"),
                                    rs.getInt("salary"),
                                    rs.getInt("deduction"),
                                    rs.getInt("NetSalary"),
                                    rs.getInt("SNo"));
              list.add(pay);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
       return list;
       }
      
      public void CalculateMthd(){
       jTextField7.setText(Integer.toString(0));
       jTextField8.setText(Integer.toString(0));
       jTextField9.setText(Integer.toString(0));
       jTextField10.setText(Integer.toString(0));
       jTextField11.setText(Integer.toString(0));
       jTextField12.setText(Integer.toString(0));       
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField14 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel3MouseReleased(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YEAR", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, 0, 94, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setToolTipText("");
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "SEARCH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("All Staff Salary As Per Month");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox4, 0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DEPARTMENT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox5, 0, 95, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESIGNATION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "AssTeacher", "Principal", "Ass.Principal", "Secetary", "Receptionist", "ITstudent", "Guard", "SchoolBusDriver", "Bursar", "Accountant", "Clerk", "Councellor", "LibraryAttendance", " " }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox6, 0, 89, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jRadioButton4)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DEPARTMENT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRESENT DAYS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });

        jTextField11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ABSENT DAYS SALARY DEDUCTION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SNO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BASIC SALARY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ABSENT DAYS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NET SALARY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRESENT DAYS SALARY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMP ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESIGNATION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "AssTeacher", "Principal", "Ass.Principal", "Secetary", "Receptionist", "ITstudent", "Guard", "SchoolBusDriver", "Bursar", "Accountant", "Clerk", "Councellor", "LibraryAttendance", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTextField14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAID MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DAY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox8, 0, 77, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox8, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YEAR", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox10, 0, 81, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField11)
                    .addComponent(jTextField10)
                    .addComponent(jTextField9)
                    .addComponent(jTextField8)
                    .addComponent(jTextField7)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14))
                    .addComponent(jTextField3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jScrollPane1.setViewportView(jPanel7);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PAY ROLL SYSTEM");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmpID", "Name", "Dept", "Desig", "Date", "Month", "Year", "BSalary", "PDays", "Salary", "Deduuction", "NetSalary", "S-No"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("INSERT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("CLEAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("PRINT TABLE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField5.setText("months");
        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        setVisible(false);
        AdminPage pg=new AdminPage();
       pg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseReleased
        setOpacity((float)1.0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseReleased

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       String sql="insert into PayRollsystem (EmpId,Name,Department, Designation, Day, Month, Year,Bsalary, Psalary, salary,deduction, NetSalary, SNo,AbsentDays,PaidMonths) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        pst=conn.prepareStatement(sql);
        pst.setString(1,jTextField1.getText());      
        pst.setString(2,jTextField3.getText());      
        pst.setString(3,jComboBox1.getSelectedItem().toString());      
        pst.setString(4,jComboBox2.getSelectedItem().toString());      
        pst.setString(5,jComboBox8.getSelectedItem().toString());      
        pst.setString(6,jComboBox10.getSelectedItem().toString());      
        pst.setString(7,jComboBox9.getSelectedItem().toString());      
        pst.setString(8,jTextField7.getText());      
        pst.setString(9,jTextField8.getText());      
        pst.setString(10,jTextField9.getText());                  
        pst.setString(11,jTextField11.getText());      
        pst.setString(12,jTextField12.getText());          
        pst.setString(13,jTextField2.getText());
        pst.setString(14,jTextField10.getText());
        pst.setString(15,jTextField14.getText());
         pst.executeUpdate();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
       
        JOptionPane.showMessageDialog(null,"All Query is inserted into the database");
    } catch (SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);        
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField12.setText(null);      
        jTextField14.setText(null);
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String sql="delete from PayRollsystem where EmpId=?";
    try {
        pst=conn.prepareStatement(sql);
        pst.setString(1,jTextField1.getText());
        pst.execute();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        JOptionPane.showMessageDialog(null,"Deleted from data base sucessfully");
    } catch (SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String sql="update PayRollsystem set EmpId=?,Name=?,Department=?, Designation=?, Day=?, Month=?, Year=?,Bsalary=?, Psalary=?, salary=?,deduction=?, NetSalary=?, SNo=?,AbsentDays=?,PaidMonths=? where EmpId='"+jTextField1.getText()+"'";        
    try {
        pst=conn.prepareStatement(sql);
        pst.setString(1,jTextField1.getText());      
        pst.setString(2,jTextField3.getText());      
        pst.setString(3,jComboBox1.getSelectedItem().toString());      
        pst.setString(4,jComboBox2.getSelectedItem().toString());      
        pst.setString(5,jComboBox8.getSelectedItem().toString());      
        pst.setString(6,jComboBox10.getSelectedItem().toString());      
        pst.setString(7,jComboBox9.getSelectedItem().toString());      
        pst.setString(8,jTextField7.getText());      
        pst.setString(9,jTextField8.getText());      
        pst.setString(10,jTextField9.getText());                  
        pst.setString(11,jTextField11.getText());      
        pst.setString(12,jTextField12.getText());          
        pst.setString(13,jTextField2.getText());
        pst.setString(14,jTextField10.getText());
        pst.setString(15,jTextField14.getText());      
        pst.execute();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);        
        JOptionPane.showMessageDialog(null,"Updated Query sucessfully");
    } catch (SQLException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
       String sql="select * from PayRollsystem where EmpId='"+jTextField4.getText()+"'";      
           try {
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
       if(rs.next()){
       jTextField1.setText(rs.getString(1));
       jTextField3.setText(rs.getString(2));
       jComboBox1.setSelectedItem(rs.getString(3));
       jComboBox2.setSelectedItem(rs.getString(4));
       jComboBox8.setSelectedItem(rs.getString(5));
       jComboBox10.setSelectedItem(rs.getString(6));
       jComboBox9.setSelectedItem(rs.getString(7));
       jTextField7.setText(rs.getString(8));
       jTextField8.setText(rs.getString(9));
       jTextField9.setText(rs.getString(10));
       jTextField11.setText(rs.getString(11));
       jTextField12.setText(rs.getString(12));
       jTextField2.setText(rs.getString(13));
       jTextField10.setText(rs.getString(14));
       jTextField14.setText(rs.getString(15));
       rs.close();
       pst.close();
       
       JOptionPane.showMessageDialog(null,"All entries Retrived");
       }
       else{
       JOptionPane.showMessageDialog(null,"The entry is incorret and does not correspond to database");
       }
           } catch (SQLException ex) {
               Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null,ex.getMessage());
           }          
       }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
        jTable1.print();
    } catch (PrinterException ex) {
        Logger.getLogger(PayRollSys.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
          int mon=Integer.parseInt(jTextField5.getText());   
       int presentday=Integer.parseInt(jTextField8.getText());
       int changes=mon-presentday;
       jTextField10.setText(Integer.toString(changes));           
             float cal=Float.parseFloat(jTextField8.getText());
       int salary=Integer.parseInt(jTextField7.getText());          
        float totalcal=(cal/mon*salary);
       jTextField9.setText(""+totalcal);
       int removedMony=Integer.parseInt(jTextField7.getText());
       float money=Float.parseFloat(jTextField9.getText());
       float removedBalance=removedMony-money;      
       jTextField11.setText(""+removedBalance);
       jTextField12.setText(""+jTextField9.getText());
       
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
       
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        if(jComboBox10.getSelectedItem().equals("Feb")){
        jTextField5.setText(Integer.toString(29));
        }
        else if(jComboBox10.getSelectedItem().equals("September")||jComboBox10.getSelectedItem().equals("June")
                ||jComboBox10.getSelectedItem().equals("April")||jComboBox10.getSelectedItem().equals("November")){
        jTextField5.setText(Integer.toString(30));
        }
        else{
        jTextField5.setText(Integer.toString(31));
        }
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
       if(jComboBox4.getSelectedItem().equals(jComboBox4.getSelectedItem())){
       ArrayList<PayRollClass> list=UpdateJCombo();
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
       Object[]row=new Object[14];
       for(int i=0;i<list.size();i++){
      row[0] =list.get(i).getEmpId();
      row[1]=list.get(i).getName();
      row[2]=list.get(i).getDepartment();
      row[3]=list.get(i).getDesignation();
      row[4]=list.get(i).getDay();
      row[5]=list.get(i).getMonth();
      row[6]=list.get(i).getYear();
      row[7]=list.get(i).getBsalary();
      row[8]=list.get(i).getPsalary();
      row[9]=list.get(i).getSalary();
      row[10]=list.get(i).getDeduction();
      row[11]=list.get(i).getNetSalary();
      row[12]=list.get(i).getSNo();
      model.addRow(row);
       }      
       }
       
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
       if(jComboBox3.getSelectedItem().equals(jComboBox3.getSelectedItem())){
       ArrayList<PayRollClass> list=UpdateJCombo3();
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       Object[]row=new Object[13];
       for(int i=0;i<list.size();i++){
      row[0]=list.get(i).getEmpId();
      row[1]=list.get(i).getName();
      row[2]=list.get(i).getDepartment();
      row[3]=list.get(i).getDesignation();
      row[4]=list.get(i).getDay();
      row[5]=list.get(i).getMonth();
      row[6]=list.get(i).getYear();
      row[7]=list.get(i).getBsalary();
      row[8]=list.get(i).getPsalary();
      row[9]=list.get(i).getSalary();
      row[10]=list.get(i).getDeduction();
      row[11]=list.get(i).getNetSalary();
      row[12]=list.get(i).getSNo();
      model.addRow(row);
       }
       }
     
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
         if(jComboBox5.getSelectedItem().equals(jComboBox5.getSelectedItem())){
       ArrayList<PayRollClass> list=UpdateJcombo2();
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       Object[]row=new Object[13];
       for(int i=0;i<list.size();i++){
      row[0]=list.get(i).getEmpId();
      row[1]=list.get(i).getName();
      row[2]=list.get(i).getDepartment();
      row[3]=list.get(i).getDesignation();
      row[4]=list.get(i).getDay();
      row[5]=list.get(i).getMonth();
      row[6]=list.get(i).getYear();
      row[7]=list.get(i).getBsalary();
      row[8]=list.get(i).getPsalary();
      row[9]=list.get(i).getSalary();
      row[10]=list.get(i).getDeduction();
      row[11]=list.get(i).getNetSalary();
      row[12]=list.get(i).getSNo();
      model.addRow(row);
       }
       }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
    if(jComboBox6.getSelectedItem().equals(jComboBox6.getSelectedItem())){
       ArrayList<PayRollClass> list=UpdateJcombo4();
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       Object[]row=new Object[13];
       for(int i=0;i<list.size();i++){
      row[0]=list.get(i).getEmpId();
      row[1]=list.get(i).getName();
      row[2]=list.get(i).getDepartment();
      row[3]=list.get(i).getDesignation();
      row[4]=list.get(i).getDay();
      row[5]=list.get(i).getMonth();
      row[6]=list.get(i).getYear();
      row[7]=list.get(i).getBsalary();
      row[8]=list.get(i).getPsalary();
      row[9]=list.get(i).getSalary();
      row[10]=list.get(i).getDeduction();
      row[11]=list.get(i).getNetSalary();
      row[12]=list.get(i).getSNo();
      model.addRow(row);
       }
       }
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
       if(jRadioButton4.isSelected()){
       ArrayList<PayRollClass> list=UserList();
      DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
      Object[]row= new Object[13];
      for(int i=0;i<list.size();i++){
      row[0]=list.get(i).getEmpId();
      row[1]=list.get(i).getName();
      row[2]=list.get(i).getDepartment();
      row[3]=list.get(i).getDesignation();
      row[4]=list.get(i).getDay();
      row[5]=list.get(i).getMonth();
      row[6]=list.get(i).getYear();
      row[7]=list.get(i).getBsalary();
      row[8]=list.get(i).getPsalary();
      row[9]=list.get(i).getSalary();
      row[10]=list.get(i).getDeduction();
      row[11]=list.get(i).getNetSalary();
      row[12]=list.get(i).getSNo();
      model.addRow(row);      
      }     
       }
       
       else if(!jRadioButton4.isSelected()){
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PayRollSys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayRollSys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayRollSys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayRollSys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayRollSys().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
