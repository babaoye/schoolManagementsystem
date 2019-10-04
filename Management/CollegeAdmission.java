/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class CollegeAdmission extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
PreparedStatement pst;

int xx;
int xy;
    /**
     * Creates new form CollegeAdmission
     */
    public CollegeAdmission() {
        initComponents();
       
        conn=JavaConnection.ConnectDB();    
    }
    
    public void TotalStudentBySelection(){
    String sql="select count(*) As Class from Admission where Class='"+jComboBox1.getSelectedItem()+"'";
    try {
        pst=conn.prepareStatement(sql);
         rs=pst.executeQuery();
    while(rs.next()){
        jTextField37.setText(rs.getString("Class"));
    }
    } catch (SQLException ex) {
        Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
   
    }
    public void Random(){
    Random ran=new Random();
     jTextField19.setText("BF/12/343"+ran.nextInt(1000+1));
    }
    
    public void search(){
    String val=jTextField19.getText();
        String sql="select * from Admission where Add_id='"+val+"' ";
      try{
     
          pst=conn.prepareStatement(sql);
          rs=pst.executeQuery();
          if(rs.next()){
         jTextField19.setText(rs.getString(1));
          jTextField1.setText(rs.getString(2));
          jTextField2.setText(rs.getString(3));
        jTextField3.setText(rs.getString(4));
        jTextField5.setText(rs.getString(5));
        jTextField4.setText(rs.getString(6));
        jTextField6.setText(rs.getString(7));
        jTextField8.setText(rs.getString(8));
        jTextField36.setText(rs.getString(9));
        jTextField9.setText(rs.getString(10));
        jTextField10.setText(rs.getString(11));
        jTextField12.setText(rs.getString(12));
        jTextField11.setText(rs.getString(13));
         jCheckBox1.setText(rs.getString(14));
          if(jCheckBox2.getText().equalsIgnoreCase("Discounted")){
        jCheckBox2.setSelected(true);
        }
        else{
         jCheckBox2.setSelected(false);   
        }      
        jTextField13.setText(rs.getString(15));
        jTextField14.setText(rs.getString(16));
        jTextField15.setText(rs.getString(17));
        jCheckBox2.setText(rs.getString(18));
        jComboBox1.setSelectedItem(rs.getString(19));
        jComboBox2.setSelectedItem(rs.getString(20));
        jTextField16.setText(rs.getString(21));
        jTextField17.setText(rs.getString(22));
        jTextField18.setText(rs.getString(23));
        jTextField20.setText(rs.getString(24));
        jTextField21.setText(rs.getString(25));
        jTextField22.setText(rs.getString(26));
        jTextField23.setText(rs.getString(27));
        jTextField24.setText(rs.getString(28));
        jTextField25.setText(rs.getString(29));
        jTextField26.setText(rs.getString(30));
        jTextField27.setText(rs.getString(31));
        jTextField28.setText(rs.getString(32));
        jTextField29.setText(rs.getString(33));
        jTextField30.setText(rs.getString(34));
        jTextField31.setText(rs.getString(35));
        jTextField32.setText(rs.getString(36));
        jTextField33.setText(rs.getString(37));
        jTextField34.setText(rs.getString(38));
        jTextField35.setText(rs.getString(39));
        rs.close();
        pst.close();
        JOptionPane.showMessageDialog(null,"All entries Retrieved Sucessfully");
          }
          else {
                JOptionPane.showMessageDialog(null,"No record of such Found");
                }
          
      }catch(Exception ex){
      JOptionPane.showMessageDialog(null,ex.getMessage());
      }
    
    }
    
    public void printComponents(){
    
    PrinterJob pj=PrinterJob.getPrinterJob();
    pj.setJobName("Print Admission Form");
    pj.setPrintable(new Printable(){
   
        @Override
        public int print(Graphics pg, PageFormat pf, int pagenum) throws PrinterException {
          if(pagenum>0)
              return Printable.NO_SUCH_PAGE; 
          
          Graphics2D g2= (Graphics2D) pg;
         AffineTransform originalTransform=g2.getTransform();
          double scaleX=pf.getImageableWidth()/jPanel3.getWidth();
          double scaley=pf.getImageableHeight()/jPanel3.getHeight();
          double scale=Math.min(scaleX, scaley);
          g2.translate(pf.getImageableX(), pf.getImageableY());
          g2.scale(scale, scale);
          jPanel3.paint(pg);
          jPanel3.printAll(g2);
          g2.setTransform(originalTransform);
          return Printable.PAGE_EXISTS;
         }
    });
    //if(pj.printDialog()==false)
    //return;
    try{
    pj.print();
    }catch(PrinterException ex){
    
    }
   // C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Microsoft Office
    
    
    }
    
    public void FileChooser(){
    JFileChooser fs=new JFileChooser(new File("c://"));
    fs.setDialogTitle("Save A FILE");
    fs.showSaveDialog(null);
    fs.setFileFilter(new FileTypeFilter(".oxps","oxps File"));
    int result=fs.showSaveDialog(null);
    if(result ==JFileChooser.APPROVE_OPTION){
    //String content =jPanel1.paint(grphcs);
    File fi=fs.getSelectedFile();
    try{
    FileWriter fw=new FileWriter(fi.getPath());
   // fw.Write(content);
    fw.flush();
    fw.close();
    
    
    }catch(Exception e2){
    JOptionPane.showMessageDialog(null,e2.getMessage());
    }
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField16 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();

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
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("BRIGHT HOPE GROUP OF SCHOOL");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(226, 40, 446, 39);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 830, 40);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INSERT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 107, 124, 23);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 148, 124, 23);

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(10, 189, 124, 23);

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("FEETAB");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(10, 230, 124, 23);

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REFRESH");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 271, 124, 23);

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("PRINT");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(10, 312, 124, 23);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Year Of Admission");

        jCheckBox1.setText("Left");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("8.");

        jTextField22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Compulsary Subject");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("present Address of school");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("3.");

        jTextField5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("permanent Address of school");

        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Religion");

        jTextField11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BabyClass", "Kindergerting", "Nursery1", "Nursery2", "Pry1", "Pry2", "Pry3", "Pry4", "Pry5", "Pry6", "Jss1", "Jss2", "Jss3", "Jss3Examination", "SS1", "SS2", "SS3", "Waec" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "G-Fee", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jTextField10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Last school /College Attended");

        jTextField25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Name");

        jTextField21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Date of Admission");

        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Examination Passed");

        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("(b). ");

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nationality");

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("7.");

        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Optional Subject");

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("6.");

        jTextField20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Subject To Be Offered For Both SSCE And Pry Schl ");

        jTextField4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("English Language");

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Date of of leaving");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("1.");

        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Date of Birth");

        jTextField14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("3.");

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("4.");

        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("(a). ");

        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("6.");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstTerm", "SecondTerm", "ThirdTerm" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Faculty");

        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("3.");

        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setText("5.");

        jTextField19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true), "Student No", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField19KeyPressed(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("9.");

        jTextField8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Tel no");

        jTextField24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("5.");

        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("11.");

        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Yoruba Language");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("2.");

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("Mathematics");

        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("10.");

        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("4.");

        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("Term");

        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Father`s Name");

        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("2.");

        jTextField18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "Discount", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Guadians Name");

        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("12.");

        jTextField15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jCheckBox2.setText("Discounted");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("1.");

        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("2.");

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Town");

        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("1.");

        jTextField17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "Discounted Fee", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField17KeyPressed(evt);
            }
        });

        jTextField26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("7.");

        jTextField27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("8.");

        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("9.");

        jTextField28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("10.");

        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("11.");

        jTextField30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jTextField31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("12.");

        jTextField32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("13.");

        jLabel60.setForeground(new java.awt.Color(102, 102, 102));
        jLabel60.setText("14.");

        jLabel61.setForeground(new java.awt.Color(102, 102, 102));
        jLabel61.setText("16.");

        jTextField34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel62.setForeground(new java.awt.Color(102, 102, 102));
        jLabel62.setText("15.");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(102, 102, 102));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Application Form For Admission");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("I Declear that the statement made above is correct and do here by agree that if am admitted that i will abide to the schools rules and");

        jLabel64.setForeground(new java.awt.Color(102, 102, 102));
        jLabel64.setText("and do confirm to the rules and regulations laid down by the school. I also abide myself");

        jLabel65.setForeground(new java.awt.Color(102, 102, 102));
        jLabel65.setText("Powered by Ayomide and the intelegence company");

        jTextField36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jTextField37.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true), "Total Student", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });
        jTextField37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField37KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField36))
                                        .addComponent(jTextField9)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField14))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel26)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField6)
                                        .addComponent(jTextField4))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel44)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel46)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel48)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel47)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel49)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel50)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel51)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel52)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel54)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel53)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel55)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel56)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel57)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel58)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel62)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel61)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel60)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel59)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel65)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(52, 52, 52)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addGap(41, 41, 41))
        );

        jScrollPane1.setViewportView(jPanel3);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(152, 85, 680, 420);

        jLabel24.setToolTipText("Logout");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24);
        jLabel24.setBounds(715, 51, 0, 21);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(832, 554));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
   
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       setVisible(false);
       StartPage page=new StartPage();
       page.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextField19.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jTextField8.setText("");
        jTextField36.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField12.setText("");
        jTextField11.setText("");
        jCheckBox1.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jCheckBox2.setText("");
        
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
        jTextField27.setText("");
        jTextField28.setText("");
        jTextField29.setText("");
        jTextField30.setText("");
        jTextField31.setText("");
        jTextField32.setText("");
        jTextField33.setText("");
        jTextField34.setText("");
        jTextField35.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String sql="insert into Admission (Add_Id,Name,F_name,G_name,Tel_no,Schl_add,P_add,Religion,Nationality,Town,Dob,AdmissionYear,Doa,left,Dol,last_schl,ExamPassed,Discount,Class,Term,G_fee,D_fee,C_fee,course1,course2,course3,course4,course5,course6,course7,course8,course9,course10,course11,course12,course13,course14,course15,course16) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        pst=conn.prepareStatement(sql);
        pst.setString(1,jTextField19.getText());
        pst.setString(2,jTextField1.getText());
        pst.setString(3,jTextField2.getText());
        pst.setString(4,jTextField3.getText());
        pst.setString(5,jTextField5.getText());
        pst.setString(6,jTextField4.getText());
        pst.setString(7,jTextField6.getText());
        pst.setString(8,jTextField8.getText());
        pst.setString(9,jTextField36.getText());
        pst.setString(10,jTextField9.getText());
        pst.setString(11,jTextField10.getText());
        pst.setString(12,jTextField12.getText());
        pst.setString(13,jTextField11.getText());
        pst.setString(14,jCheckBox1.getText());
        pst.setString(15,jTextField13.getText());
        pst.setString(16,jTextField14.getText());
        pst.setString(17,jTextField15.getText());
        pst.setString(18,jCheckBox2.getText());
        pst.setString(19,jComboBox1.getSelectedItem().toString());
        pst.setString(20,jComboBox2.getSelectedItem().toString());
        pst.setString(21,jTextField16.getText());
        pst.setString(22,jTextField17.getText());
        pst.setString(23,jTextField18.getText());
        pst.setString(24,jTextField20.getText());
        pst.setString(25,jTextField21.getText());
        pst.setString(26,jTextField22.getText());
        pst.setString(27,jTextField23.getText());
        pst.setString(28,jTextField24.getText());
        pst.setString(29,jTextField25.getText());
        pst.setString(30,jTextField26.getText());
        pst.setString(31,jTextField27.getText());
        pst.setString(32,jTextField28.getText());
        pst.setString(33,jTextField29.getText());
        pst.setString(34,jTextField30.getText());
        pst.setString(35,jTextField31.getText());
        pst.setString(36,jTextField32.getText());
        pst.setString(37,jTextField33.getText());
        pst.setString(38,jTextField34.getText());
        pst.setString(39,jTextField35.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null,"All inputs are Sucessfully inserted into the database");
    } 
    catch (SQLException ex) {
        Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String sql="delete from Admission where Add_id=? ";
    try {
        pst=conn.prepareStatement(sql);
        pst.setString(1,jTextField19.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null,"deleted sucessfully");
    } catch (SQLException ex) {
        Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       setVisible(false);
       HelloPage pg=new HelloPage();
       pg.setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String sql="update Admission set Add_Id=?,Name=?,F_name=?,G_name=?,Tel_no=?,Schl_add=?,P_add=?,Religion=?,Nationality=?,Town=?,Dob=?,AdmissionYear=?,Doa=?,left=?,Dol=?,last_schl=?,ExamPassed=?,Discount=?,Class=?,Term=?,G_fee=?,D_fee=?,C_fee=?,course1=?,course2=?,course3=?,course4=?,course5=?,course6=?,course7=?,course8=?,course9=?,course10=?,course11=?,course12=?,course13=?,course14=?,course15=?,course16=? where Add_id='"+jTextField19.getText()+"' ";   
    try {
        pst=conn.prepareStatement(sql);
         pst.setString(1,jTextField19.getText());
        pst.setString(2,jTextField1.getText());
        pst.setString(3,jTextField2.getText());
        pst.setString(4,jTextField3.getText());
        pst.setString(5,jTextField5.getText());
        pst.setString(6,jTextField4.getText());
        pst.setString(7,jTextField6.getText());
        pst.setString(8,jTextField8.getText());
        pst.setString(9,jTextField36.getText());
        pst.setString(10,jTextField9.getText());
        pst.setString(11,jTextField10.getText());
        pst.setString(12,jTextField12.getText());
        pst.setString(13,jTextField11.getText());
        pst.setString(14,jCheckBox1.getText());
        pst.setString(15,jTextField13.getText());
        pst.setString(16,jTextField14.getText());
        pst.setString(17,jTextField15.getText());
        pst.setString(18,jCheckBox2.getText());
        pst.setString(19,jComboBox1.getSelectedItem().toString());
        pst.setString(20,jComboBox2.getSelectedItem().toString());
        pst.setString(21,jTextField16.getText());
        pst.setString(22,jTextField17.getText());
        pst.setString(23,jTextField18.getText());
        pst.setString(24,jTextField20.getText());
        pst.setString(25,jTextField21.getText());
        pst.setString(26,jTextField22.getText());
        pst.setString(27,jTextField23.getText());
        pst.setString(28,jTextField24.getText());
        pst.setString(29,jTextField25.getText());
        pst.setString(30,jTextField26.getText());
        pst.setString(31,jTextField27.getText());
        pst.setString(32,jTextField28.getText());
        pst.setString(33,jTextField29.getText());
        pst.setString(34,jTextField30.getText());
        pst.setString(35,jTextField31.getText());
        pst.setString(36,jTextField32.getText());
        pst.setString(37,jTextField33.getText());
        pst.setString(38,jTextField34.getText());
        pst.setString(39,jTextField35.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"All input update are done");
    } catch (SQLException ex) {
        Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
       

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
       search();
       }
    }//GEN-LAST:event_jTextField19KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

printComponents();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        AdminLogin log=new AdminLogin();
        log.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       setOpacity((float)0.7);
        xx=evt.getX();
        xy=evt.getY();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float)1.0);
         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
      if(evt.getStateChange()==ItemEvent.SELECTED){
      jCheckBox1.setText("Left");
      }
      else if(evt.getStateChange()==ItemEvent.DESELECTED){
      jCheckBox1.setText("Studying");
      }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           jCheckBox2.setText("Discounted");
           jTextField17.setEnabled(true);
       }
       else if(evt.getStateChange()==ItemEvent.DESELECTED){
           jCheckBox2.setText("normal");
           jTextField17.setEnabled(false);
       }
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
          if(jComboBox1.getSelectedItem().equals("BabyClass")){
            TotalStudentBySelection();
        String sql="select BabyClass from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("BabyClass"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("BabyClass"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select BabyClassFirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("BabyClassFirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("BabyClass"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select BabyClassSecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("BabyClassSecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("BabyClass"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select BabyClassThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("BabyClassThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if(jComboBox1.getSelectedItem().equals("Kindergerting")){
            TotalStudentBySelection();
        String sql="select Kindergerting from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Kindergerting"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Kindergerting"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select KindergertingFirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("KindergertingFirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Kindergerting"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select KindergertingSecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("KindergertingSecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Kindergerting"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select KindergertingThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("KindergertingThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Nursery1")){
            TotalStudentBySelection();
        String sql="select Nursery1 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Nursery1"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Nursery1"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Nursery1FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery1FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Nursery1"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Nursery1SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery1SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Nursery1"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Nursery1ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery1ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Nursery2")){
            TotalStudentBySelection();
        String sql="select Nursery2 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Nursery2"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Nursery2"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Nursery2FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery2FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Nursery2"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Nursery2SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery2SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Nursery2"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Nursery2ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Nursery2ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry1")){
            TotalStudentBySelection();
        String sql="select Pry1 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry1"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry1"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry1FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry1FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry1"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry1SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry1SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry1"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry1ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry1ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry2")){
            TotalStudentBySelection();
        String sql="select Pry2 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry2"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry2"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry2FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry2FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry2"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry2SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry2SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry2"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry2ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry2ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry3")){
            TotalStudentBySelection();
        String sql="select Pry3 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry3"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry3"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry3FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry3FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry3"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry3SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry3SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry3"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry3ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry3ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry4")){
            TotalStudentBySelection();
        String sql="select Pry4 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry4"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry4"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry4FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry4FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry4"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry4SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry4SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry4"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry4ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry4ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry5")){
            TotalStudentBySelection();
        String sql="select Pry5 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry5"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry5"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry5FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry5FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry5"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry5SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry5SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry5"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry5ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry5ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
          if(jComboBox1.getSelectedItem().equals("Pry6")){
            TotalStudentBySelection();
        String sql="select Pry6 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Pry6"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Pry6"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Pry6FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry6FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry6"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Pry6SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry6SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        if((jComboBox1.getSelectedItem().equals("Pry6"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Pry6ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Pry6ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }  
       }
        
        if(jComboBox1.getSelectedItem().equals("Jss1")){
            TotalStudentBySelection();
        String sql="select Jss1 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss1"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if((jComboBox1.getSelectedItem().equals("Jss1"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Jss1FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss1FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
        if((jComboBox1.getSelectedItem().equals("Jss1"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Jss1SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss1SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
         if((jComboBox1.getSelectedItem().equals("Jss1"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Jss1ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss1ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
          if(jComboBox1.getSelectedItem().equals("Jss2")){
              TotalStudentBySelection();
        String sql="select Jss2 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss2"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if((jComboBox1.getSelectedItem().equals("Jss2"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Jss2FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss2FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
           if((jComboBox1.getSelectedItem().equals("Jss2"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Jss2SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss2SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
            if((jComboBox1.getSelectedItem().equals("Jss2"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Jss2ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss2ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
             if(jComboBox1.getSelectedItem().equals("Jss3")){
                 TotalStudentBySelection();
        String sql="select Jss3 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss3"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             if((jComboBox1.getSelectedItem().equals("Jss3"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select Jss3FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss3FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
              if((jComboBox1.getSelectedItem().equals("Jss3"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select Jss3SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss3SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
             if((jComboBox1.getSelectedItem().equals("Jss3"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select Jss3ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("Jss3ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
              if(jComboBox1.getSelectedItem().equals("SS1")){
                  TotalStudentBySelection();
        String sql="select SS1 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("SS1"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
              if((jComboBox1.getSelectedItem().equals("SS1"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select SS1FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS1FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
               if((jComboBox1.getSelectedItem().equals("SS1"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select SS1SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS1SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                if((jComboBox1.getSelectedItem().equals("SS1"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select SS1ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS1ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                 if(jComboBox1.getSelectedItem().equals("SS2")){
                     TotalStudentBySelection();
        String sql="select SS2 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("SS2"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                 if((jComboBox1.getSelectedItem().equals("SS2"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select SS2FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS2FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                  if((jComboBox1.getSelectedItem().equals("SS2"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select SS2SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS2SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                   if((jComboBox1.getSelectedItem().equals("SS2"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select SS2ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS2ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                    if(jComboBox1.getSelectedItem().equals("SS3")){
                        TotalStudentBySelection();
        String sql="select SS3 from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("SS3"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    if((jComboBox1.getSelectedItem().equals("SS3"))&&(jComboBox2.getSelectedItem().equals("FirstTerm"))){
        String sql="select SS3FirstTerm from FeeTabOne where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS3FirstTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                     if((jComboBox1.getSelectedItem().equals("SS3"))&&(jComboBox2.getSelectedItem().equals("SecondTerm"))){
        String sql="select SS3SecondTerm from FeeTabTwo where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS3SecondTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        }
                      if((jComboBox1.getSelectedItem().equals("SS3"))&&(jComboBox2.getSelectedItem().equals("ThirdTerm"))){
        String sql="select SS3ThirdTerm from FeeTabThree where Year='"+jTextField12.getText()+"'";
            try {
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
        while(rs.next()){
       jTextField16.setText(rs.getString("SS3ThirdTerm"));
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
         if(jComboBox1.getSelectedItem().equals("Jss3Examination")){ 
             TotalStudentBySelection();
        String sql="select Jss3Examination from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss3Examination"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(jComboBox1.getSelectedItem().equals("Jss3Examination")){ 
             TotalStudentBySelection();
        String sql="select Jss3Examination from FeeTabOne where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss3Examination"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           if(jComboBox1.getSelectedItem().equals("Jss3Examination")){ 
             TotalStudentBySelection();
        String sql="select Jss3Examination from FeeTabTwo where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss3Examination"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            if(jComboBox1.getSelectedItem().equals("Jss3Examination")){ 
             TotalStudentBySelection();
        String sql="select Jss3Examination from FeeTabThree where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Jss3Examination"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
              if(jComboBox1.getSelectedItem().equals("Waec")){
             TotalStudentBySelection();
        String sql="select Waec from FeeTab where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Waec"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(jComboBox1.getSelectedItem().equals("Waec")){
             TotalStudentBySelection();
        String sql="select Waec from FeeTabOne where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Waec"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(jComboBox1.getSelectedItem().equals("Waec")){
             TotalStudentBySelection();
        String sql="select Waec from FeeTabTwo where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Waec"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(jComboBox1.getSelectedItem().equals("Waec")){
             TotalStudentBySelection();
        String sql="select Waec from FeeTabThree where Year='"+jTextField12.getText()+"'";     
            try {
                pst = conn.prepareStatement(sql);    
                 rs=pst.executeQuery();                
          while(rs.next()){
          jTextField16.setText(rs.getString("Waec"));
          }
            } catch (SQLException ex) {
                Logger.getLogger(CollegeAdmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
     int what= Integer.parseInt(jTextField16.getText());
        int that=  Integer.parseInt(jTextField17.getText());
        int Total=what-that;
         
          jTextField18.setText(Integer.toString(Total));
      }
    }//GEN-LAST:event_jTextField17KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
    
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    private void jTextField37KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField37KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37KeyPressed

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
            java.util.logging.Logger.getLogger(CollegeAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CollegeAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CollegeAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CollegeAdmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CollegeAdmission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
