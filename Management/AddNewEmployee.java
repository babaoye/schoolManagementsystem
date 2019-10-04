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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER1
 */
public class AddNewEmployee extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
PreparedStatement pst;
int xx;
int xy;
    /**
     * Creates new form AddNewEmployee
     */
    public AddNewEmployee() {
        initComponents();
        conn=JavaConnection.ConnectDB();
        
    }
    public void IsSelected(){
    if(jRadioButton2.isSelected()){
    jRadioButton1.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);    
    }
    else if(jRadioButton1.isSelected()){
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);
    }
    else if(jRadioButton3.isSelected()){
        jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton4.setSelected(false);
    }
    else if(jRadioButton4.isSelected()){
     jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
    }
    }
    
    public ArrayList<EmployeesTab> Employee(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab";
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
    
    public ArrayList<EmployeesTab> EmployeeSearch(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab where EmployeeId='"+jTextField4.getText()+"'";
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
     public ArrayList<EmployeesTab> EmployeeSearchByMonth(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab where Dept='"+jComboBox3.getSelectedItem()+"'";
        
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
     
      public ArrayList<EmployeesTab> EmployeeSearchByMale(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab where Gender='"+jRadioButton2.getText()+"'";        
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
      
       public ArrayList<EmployeesTab> EmployeeSearchByFemale(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab where Gender='"+jRadioButton3.getText()+"'";        
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
       
        public ArrayList<EmployeesTab> EmployeeSearchByLeft(){
        ArrayList<EmployeesTab> list=new ArrayList<>();
        String sql="select * from EmployeesTab where Left='"+jRadioButton4.getText()+"'";        
        Statement st;
        ResultSet rst;
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Babaoye Ayomide\\Documents\\NetBeansProjects\\SchoolMangementSystem\\SchoolManagement.sqlite");
        st=con.createStatement();
        rst=st.executeQuery(sql);
        EmployeesTab tab;
        while(rst.next()){
        tab=new EmployeesTab(rst.getInt("EmployeeId"),
                            rst.getString("EmployeeName"),
                            rst.getString("Dept"),
                            rst.getString("Designation"),
                            rst.getString("Qualification"),
                            rst.getString("Address"),
                            rst.getInt("Salary"),
                            rst.getInt("ContactNo"),
                            rst.getString("Course"),
                            rst.getString("Gender"),
                            rst.getString("DateOfBirth"),
                            rst.getString("DateJoining"),
                            rst.getString("Left"),
                            rst.getString("DateOfLeaving"));
        list.add(tab);
       
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        return list;
    
    }
    public void getConnection(){
    ArrayList<EmployeesTab> list=Employee();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();   
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);      }
//return list;    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField13 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

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

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("-");
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
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
                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DepartMent & Designation", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "SS1", "SS2", "SS3", "Teacher", "AssTeacher", "Principal", "Ass.Principal", "Secetary", "Receptionist", "ITstudent", "Guard", "SchoolBusDriver", "Bursar", "Accountant", "Clerk", "Councellor", "LibraryAttendance", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, 0, 161, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
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

        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("All Staff");
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

        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Male");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Female");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Left");
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(6, 6, 6)
                .addComponent(jRadioButton2)
                .addGap(10, 10, 10)
                .addComponent(jRadioButton3)
                .addGap(10, 10, 10)
                .addComponent(jRadioButton4)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

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

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER CONTACT NO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATE OF BIRTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NO OF EMPLOYEE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jCheckBox1.setText("Total Staff");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jTextField13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATE OF LEAVING", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER SALARY", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATE OF JOINING", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COURSE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jCheckBox2.setText("LEFT");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER ADDRESS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER QUALIFICATION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYER ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

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

        jCheckBox3.setText("Left Staff");
        jCheckBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox3ItemStateChanged(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("GENDER"));

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Male");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Female");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton5)
                .addGap(48, 48, 48)
                .addComponent(jRadioButton6)
                .addGap(36, 36, 36))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jCheckBox1))
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField13)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel7);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD NEW EMPLOYEE");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("STAFF RECORDS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp_ID", "Emp_Name", "Dept", "Designation", "qualification", "Address", "Salary", "Contact", "Course", "Gender", "DOB", "DOJ", "Left", "DOL"
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1090, 626));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        setVisible(false);
        AdminPage pg=new AdminPage();
        pg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       
    }//GEN-LAST:event_jLabel1MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
       int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseReleased
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel3MouseReleased

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      jRadioButton5.setActionCommand("Male");
      jRadioButton6.setActionCommand("Female");
        
        String sql="insert into EmployeesTab(EmployeeId ,EmployeeName,Dept,Designation,Qualification,Address,Salary,ContactNo,Course ,Gender,DateOfBirth,DateJoining,Left,DateOfLeaving) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
    try {
         pst=conn.prepareStatement(sql);
        pst.setString(1, jTextField1.getText());
        pst.setString(2, jTextField3.getText());
        pst.setString(3, jComboBox1.getSelectedItem().toString());
        pst.setString(4, jComboBox2.getSelectedItem().toString());
        pst.setString(5, jTextField5.getText());
        pst.setString(6, jTextField6.getText());
        pst.setString(7, jTextField7.getText());
        pst.setString(8, jTextField8.getText());
        pst.setString(9, jTextField9.getText());
        pst.setString(10, buttonGroup1.getSelection().getActionCommand());
        pst.setString(11, jTextField11.getText());
        pst.setString(12, jTextField12.getText());
         pst.setString(13, jCheckBox2.getText());
        pst.setString(14, jTextField13.getText());
         pst.executeUpdate();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        getConnection();
      
       
       JOptionPane.showMessageDialog(null,"All inputs done");
       
    } catch (SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
        jTable1.print();
    } catch (PrinterException ex) {      
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         jRadioButton5.setActionCommand("Male");
      jRadioButton6.setActionCommand("Female");
        
        String sql="update EmployeesTab set EmployeeId=? ,EmployeeName=?,Dept=?,Designation=?,Qualification=?,Address=?,Salary=?,ContactNo=?,Course=? ,Gender=?,DateOfBirth=?,DateJoining=?,Left=?,DateOfLeaving=? where EmployeeId='"+jTextField1.getText()+"'";
    try {
        pst=conn.prepareStatement(sql);
         pst.setString(1, jTextField1.getText());
        pst.setString(2, jTextField3.getText());
        pst.setString(3, jComboBox1.getSelectedItem().toString());
        pst.setString(4, jComboBox2.getSelectedItem().toString());
        pst.setString(5, jTextField5.getText());
        pst.setString(6, jTextField6.getText());
        pst.setString(7, jTextField7.getText());
        pst.setString(8, jTextField8.getText());
        pst.setString(9, jTextField9.getText());
        pst.setString(10, buttonGroup1.getSelection().getActionCommand());
        pst.setString(11, jTextField11.getText());
        pst.setString(12, jTextField12.getText());
         pst.setString(13, jCheckBox2.getText());
        pst.setString(14, jTextField13.getText());
         pst.executeUpdate();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        getConnection();
        JOptionPane.showMessageDialog(null,"All updates have been done.");
    } catch (SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
       
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String sql="delete from EmployeesTab where EmployeeId=?";
    try {
        pst=conn.prepareStatement(sql);
         pst.setString(1,jTextField1.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"All delete done");
    } catch (SQLException ex) {
        Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

      jTextField1.setText("");
         jTextField3.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jTextField7.setText("");
         jTextField8.setText("");
         jTextField9.setText("");         
        jTextField11.setText("");
        jTextField12.setText("");
         jTextField13.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jRadioButton5.setActionCommand("Male");
      jRadioButton6.setActionCommand("Female");
           String sql="select * from EmployeesTab where EmployeeId='"+jTextField4.getText()+"'";
           try {
               pst=conn.prepareStatement(sql);
                 rs=pst.executeQuery();
                 if(rs.next()){
                     jTextField1.setText(rs.getString(1));
                     jTextField3.setText(rs.getString(2));
                     jComboBox1.setSelectedItem(rs.getString(3));
                     jComboBox2.setSelectedItem(rs.getString(4));                     
                     jTextField5.setText(rs.getString(5));
                     jTextField6.setText(rs.getString(6));
                     jTextField7.setText(rs.getString(7));
                     jTextField8.setText(rs.getString(8));
                     jTextField9.setText(rs.getString(9));                    
                     jTextField11.setText(rs.getString(11));
                     jTextField12.setText(rs.getString(12));
                     jTextField13.setText(rs.getString(13));
                     
                     ArrayList<EmployeesTab> list=EmployeeSearch();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
                     rs.close();
                     pst.close();
                    
                     JOptionPane.showMessageDialog(null,"All inputs to the selected Item are all inputed");
                 }
                 else{
                 JOptionPane.showMessageDialog(null,"No ID of such in the dataBase Please check to see for mistakes");
                 }
           } catch (SQLException ex) {
               Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null,ex.getMessage());
           }
         
           
           
       }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
       







        if(jComboBox3.getSelectedItem().equals("Teacher")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();    
      model.addRow(row);
    }    
        }
        
       else if(jComboBox3.getSelectedItem().equals("AssTeacher")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
      
    }    
        }
        else   if(jComboBox3.getSelectedItem().equals("Principal")){         
     ArrayList<EmployeesTab> list= EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
          else  if(jComboBox3.getSelectedItem().equals("Ass.Principal")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
           else  if(jComboBox3.getSelectedItem().equals("Secetary")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
         else     if(jComboBox3.getSelectedItem().equals("Receptionist")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
         else if(jComboBox3.getSelectedItem().equals("Receptionist")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
      else   if(jComboBox3.getSelectedItem().equals("ITstudent")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
        else if(jComboBox3.getSelectedItem().equals("Guard")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
         else if(jComboBox3.getSelectedItem().equals("SchoolBusDriver")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
         else  if(jComboBox3.getSelectedItem().equals("Bursar")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        } 
           else if(jComboBox3.getSelectedItem().equals("Accountant")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
               else if(jComboBox3.getSelectedItem().equals("Accountant")){
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
                   else if(jComboBox3.getSelectedItem().equals("Clerk")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Councellor")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("LibraryAttendance")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
            else if(jComboBox3.getSelectedItem().equals("BabyClass")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
                else if(jComboBox3.getSelectedItem().equals("Kindergerting")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
                    else if(jComboBox3.getSelectedItem().equals("Nursery1")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Nursery2")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Pry1")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Pry2")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Pry3")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }    else if(jComboBox3.getSelectedItem().equals("Pry4")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
        
            else if(jComboBox3.getSelectedItem().equals("Pry5")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
        
            else if(jComboBox3.getSelectedItem().equals("Pry6")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
        
           
            else if(jComboBox3.getSelectedItem().equals("Jss1")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }           
            else if(jComboBox3.getSelectedItem().equals("Jss2")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }           
            
            else if(jComboBox3.getSelectedItem().equals("Jss3")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }           
            
             else if(jComboBox3.getSelectedItem().equals("SS1")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }           
        
            else if(jComboBox3.getSelectedItem().equals("SS2")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
                   
             else if(jComboBox3.getSelectedItem().equals("SS3")){         
     ArrayList<EmployeesTab> list=EmployeeSearchByMonth();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);
    }    
        }
               
                 else{
           JOptionPane.showMessageDialog(null,"Something is Wrong");
           }
        
           
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           if(jRadioButton1.isSelected()){
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);
   
        if(jRadioButton1.getText().equals("All Staff")){       
           ArrayList<EmployeesTab> list=Employee();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);      
    }
       }
           }
       }
       else{
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
         model.setRowCount(0);           
       }
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
      if(evt.getStateChange()==ItemEvent.SELECTED){
          if(jRadioButton2.isSelected()){
    jRadioButton1.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);   
        if(jRadioButton2.getText().equals("Male")){       
           ArrayList<EmployeesTab> list=EmployeeSearchByMale();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();
    
      model.addRow(row);      
    }
       }
        
    }
       }
       else{
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
         model.setRowCount(0);           
       }
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
          if(jRadioButton3.isSelected()){
        jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton4.setSelected(false);  
        if(jRadioButton3.getText().equals("Female")){       
           ArrayList<EmployeesTab> list=EmployeeSearchByFemale();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();    
      model.addRow(row);      
    }
       }        
    }
       }
       else{
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
         model.setRowCount(0);           
       }
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
          if(jRadioButton4.isSelected()){
     jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
        if(jRadioButton4.getText().equals("Left")){       
           ArrayList<EmployeesTab> list=EmployeeSearchByLeft();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    Object[] row=new Object[14];
    for(int i=0;i<list.size();i++){
    row[0]=list.get(i).getEmployeeId();
    row[1]=list.get(i).getEmployeeName();
    row[2]=list.get(i).getDept();
    row[3]=list.get(i).getDesignation();
    row[4]=list.get(i).getQualification();
    row[5]=list.get(i).getAddress();
    row[6]=list.get(i).getSalary();
    row[7]=list.get(i).getContactNo();
    row[8]=list.get(i).getCourse();
    row[9]=list.get(i).getGender();
    row[10]=list.get(i).getDateOfBirth();
    row[11]=list.get(i).getDateJoining();
    row[12]=list.get(i).getLeft();
    row[13]=list.get(i).getDateOfLeaving();    
      model.addRow(row);      
    }
       }        
    }
       }
       else{
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
         model.setRowCount(0);           
       }
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           jCheckBox2.setText("Left");           
       }
       else if(evt.getStateChange()==ItemEvent.DESELECTED){
           jCheckBox2.setText("StillStudying");
       }
      
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           if(jCheckBox1.isSelected()){
               jCheckBox1.setSelected(false);
       String sql="select count(*) from EmployeesTab ";
           try {
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
       while(rs.next()){
           jTextField2.setText(rs.getString(1));
       }
           } catch (SQLException ex) {
               Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
           }
           }
       }
        else if(evt.getStateChange()==ItemEvent.DESELECTED){
       jTextField2.setText("");
       }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox3ItemStateChanged
         if(evt.getStateChange()==ItemEvent.SELECTED){
             if(jCheckBox3.isSelected()){
                 jCheckBox3.setSelected(false);
             String left="Left";
       String sql="select count(*) from EmployeesTab where Left='"+left+"' ";
           try {
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
       while(rs.next()){
           jTextField2.setText(rs.getString(1));
       }
           } catch (SQLException ex) {
               Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
           }
             }
       }
        else if(evt.getStateChange()==ItemEvent.DESELECTED){
       jTextField2.setText("");
       }
    }//GEN-LAST:event_jCheckBox3ItemStateChanged

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
            java.util.logging.Logger.getLogger(AddNewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
