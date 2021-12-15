/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Legion
 */


import database.Courses;
import database.Department;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class home_for_teacher extends javax.swing.JFrame{

   JLabel arr1[];//for Title 
   JLabel arr2[];// for profname and Asses
   JLabel arr3[];// for CourseId
   JLabel arr4[];// for Photo courses
   JLabel arr5[];// for courses title
   //JLabel arr6[];// for chating Icon's

   int len;
   static StringBuffer Database = new  StringBuffer("");
   String couse_name="";
    ResultSet rs;//Contains all courses of teacher -used once- ~J
    List<Courses> c = new ArrayList<Courses>();//Contains all courses -for any manipulation use this- ~J
    /**
     * Creates new form home
     */
    static int count = 0;
    
    public home_for_teacher() {
        this(0);//Call other constructor ~J
    }
    public home_for_teacher(int lenth) {
        //~J 
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "select *\n" +
                    "from courses\n" +
                    "where courses.courseno in (select sections.courseno from sections where sections.sectionno in (select sectionno from teachers_sections where teacherid =" +LogInInterface.id+ "))";
            Statement smt = con.createStatement();
            rs = smt.executeQuery(sql);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            while(rs.next()) {
                c.add(new Courses(rs.getBigDecimal("courseno"), rs.getString("coursename"), rs.getString("outlineplan"), rs.getString("image"), rs.getString("message"), null, em.find(Department.class, rs.getBigDecimal("depno"))));
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(home_for_prof.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lenth = c.size();// ~J Find all courses for this teacher and store them in resultset and list to use later 
        len = lenth;
        arr1 = new JLabel[lenth];                   
        arr2 = new JLabel[lenth];
        arr3 = new JLabel[lenth];
        arr4 = new JLabel[lenth];
        arr5 = new JLabel[lenth];
        //arr6 = new JLabel[lenth];
         for(int i = 0 ; i< lenth ; i++){
         arr1[i] = new JLabel();
         arr2[i] = new JLabel();
         arr3[i] = new JLabel();
         arr4[i] = new JLabel();
         //arr6[i] = new JLabel("",JLabel.CENTER);
         arr5[i] = new JLabel("",JLabel.CENTER);
        }
        
        //Iwill add all the action manual 
        // Please DON'T CHANGE ANY THING IN THIS CODE ( by : majdy )
        // Addin a n lenth TIlite Action ,Exit and click and Enter 
        for (int i = 0 ; i < lenth ; i++){
          arr1[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    myActionMouseFunclick(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(home_for_teacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myActionMouseFunexit(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myActionMouseFunenter(evt);
            }
        });
          /*
          arr6[i].addMouseListener(new java.awt.event.MouseAdapter(){
           public void mouseEntered(java.awt.event.MouseEvent evt) {
                myActionMouseEnterchat(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                 myActionMouseExitchat(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myActionMouseClickChat(evt);
            }
        });*/
        }
        
        
        
        initComponents();
        fun (lenth);
        
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        for5_courses.setVisible(false);
        for4_courses.setVisible(false);
        for6_courses.setVisible(false);
        for7_courses.setVisible(false);
        
        
        if(lenth==4){for4_courses.setVisible(true);
        for5_courses.setVisible(false);
       
        for6_courses.setVisible(false);
        for7_courses.setVisible(false);
        }
         if(lenth==5){for5_courses.setVisible(true);
          
        for4_courses.setVisible(false);
        for6_courses.setVisible(false);
        for7_courses.setVisible(false);
         }
          if(lenth==6){for6_courses.setVisible(true);
          for5_courses.setVisible(false);
        for4_courses.setVisible(false);
        
        for7_courses.setVisible(false);}
           if(lenth==7){for7_courses.setVisible(true);
           for5_courses.setVisible(false);
        for4_courses.setVisible(false);
        for6_courses.setVisible(false);
    }
           //After Getting the name from database
        jLabel3.setText("<html>Your Personal Page <br/>Welcome <html>" + LogInInterface.name);
        user_name.setText(""+LogInInterface.name);//~J+MS display name
        
           //constractor
            scaleimage__logo("src\\photo\\user_.png",user_photo);
            scaleimage__logo("src\\photo\\prop_rel.png",properties);
            scaleimage__logo("src\\photo\\botton\\cross.png",exit);
            scaleimage__logo("src\\photo\\botton\\min_rel.png",min_max);
            Setting_panel.setVisible(false);
            
    }
    public void scaleimage_butt1(){
        
        ImageIcon icon = new ImageIcon ("src\\photo\\white.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance( change_pass.getWidth(), change_pass.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
         change_pass.setIcon(scaledIcon);

    }
    //user_
    
    public void scaleimage__logo(String path , JLabel a){
        ImageIcon icon = new ImageIcon (path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        a.setIcon(scaledIcon);
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        min_max = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        basicbody = new javax.swing.JPanel();
        for7_courses = new javax.swing.JLabel();
        for5_courses = new javax.swing.JLabel();
        for6_courses = new javax.swing.JLabel();
        for4_courses = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        properties = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Setting_panel = new javax.swing.JPanel();
        change_pass = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        user_photo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        min_max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                min_maxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                min_maxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                min_maxMouseExited(evt);
            }
        });
        body.add(min_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 30, 30));

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        body.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 30, 30));

        head.setBackground(new java.awt.Color(98, 168, 243));
        head.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        head.setForeground(new java.awt.Color(102, 102, 102));
        head.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        head.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        head.setOpaque(true);
        body.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 90));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        basicbody.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout basicbodyLayout = new javax.swing.GroupLayout(basicbody);
        basicbody.setLayout(basicbodyLayout);
        basicbodyLayout.setHorizontalGroup(
            basicbodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicbodyLayout.createSequentialGroup()
                .addGap(866, 866, 866)
                .addComponent(for4_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(for6_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(for5_courses)
                .addGap(40, 40, 40)
                .addComponent(for7_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        basicbodyLayout.setVerticalGroup(
            basicbodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicbodyLayout.createSequentialGroup()
                .addGap(599, 599, 599)
                .addGroup(basicbodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(for4_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for6_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for5_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for7_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setViewportView(basicbody);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1040, 630));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1040, 720));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        properties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propertiesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                propertiesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                propertiesMouseExited(evt);
            }
        });
        jPanel1.add(properties, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 50));

        jLabel2.setBackground(new java.awt.Color(98, 168, 243));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 90));

        Setting_panel.setBackground(new java.awt.Color(38, 50, 54));
        Setting_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        change_pass.setBackground(new java.awt.Color(38, 50, 54));
        change_pass.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        change_pass.setForeground(new java.awt.Color(255, 255, 255));
        change_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_pass.setText("Change Password");
        change_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        change_pass.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        change_pass.setOpaque(true);
        change_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                change_passMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                change_passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                change_passMouseExited(evt);
            }
        });
        Setting_panel.add(change_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 140, 380, 50));

        user_name.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));
        user_name.setText("User Name");
        Setting_panel.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 150, 50));
        Setting_panel.add(user_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        Setting_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 20));

        jPanel1.add(Setting_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 240, 530));

        jLabel3.setBackground(new java.awt.Color(98, 168, 243));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/icons8_moodle_48px_1.png"))); // NOI18N
        jLabel3.setText("Happy Grade's");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 240, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    Border border = BorderFactory.createLineBorder ( new Color (102,102,102));
    private void myActionMouseFunclick(java.awt.event.MouseEvent evt) throws SQLException{
    
       for(int i = 0 ; i < len;i++){
        if(evt.getSource() == arr1[i]){
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "select count(teachers_sections.sectionno)\n" +
                         "from teachers_sections, sections\n" +
                         "where sections.courseno = "+c.get(i).getCourseno()+"\n" +
                         "and sections.sectionno = teachers_sections.sectionno\n" +
                         "and teachers_sections.teacherid ="+LogInInterface.id+ "\n" +
                         "group by teachers_sections.teacherid";      
            Statement smt = con.createStatement();
            ResultSet sec_cnt_rslt  = smt.executeQuery(sql);//receives resultset from sql statement
            int sec_cnt = 0;
            while(sec_cnt_rslt.next())
                sec_cnt = sec_cnt_rslt.getInt(1);//translate resultset into integer value-number of sections for chosen course-
            
            TACourseSections.course_no = c.get(i).getCourseno().intValue();
            new TACourseSections(sec_cnt).setVisible(true);
            dispose();
        }}
    
    }
    /*
    private void myActionMouseClickChat(java.awt.event.MouseEvent evt){

       if(len==1){
        if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
        }
        if(len==2){
         if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
         if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
        }
        if(len==3){
        if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
        if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
        if(evt.getSource()==arr6[2]){couse_name = arr1[2].getText();}
        }
        if(len==4){
       if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
       if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
       if(evt.getSource()==arr6[2]){couse_name = arr1[2].getText();}
       if(evt.getSource()==arr6[3]){couse_name = arr1[3].getText();}

        }
        if(len==5){
       if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
       if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
       if(evt.getSource()==arr6[2]){couse_name = arr1[2].getText();}
       if(evt.getSource()==arr6[3]){couse_name = arr1[3].getText();}
       if(evt.getSource()==arr6[4]){couse_name = arr1[4].getText();}
        }
        if(len==6){
         if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
         if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
         if(evt.getSource()==arr6[2]){couse_name = arr1[2].getText();}
         if(evt.getSource()==arr6[3]){couse_name = arr1[3].getText();}
         if(evt.getSource()==arr6[4]){couse_name = arr1[4].getText();}
         if(evt.getSource()==arr6[5]){couse_name = arr1[5].getText();}
        }
          if(len==7){
         if(evt.getSource()==arr6[0]){couse_name = arr1[0].getText();}
         if(evt.getSource()==arr6[1]){couse_name = arr1[1].getText();}
         if(evt.getSource()==arr6[2]){couse_name = arr1[2].getText();}
         if(evt.getSource()==arr6[3]){couse_name = arr1[3].getText();}
         if(evt.getSource()==arr6[4]){couse_name = arr1[4].getText();}
         if(evt.getSource()==arr6[5]){couse_name = arr1[5].getText();}
         if(evt.getSource()==arr6[6]){couse_name = arr1[6].getText();}
        
        }
          
       
         // System.out.print(couse_name+"\n");
        
    } 
    */
    private void myActionMouseFunexit(java.awt.event.MouseEvent evt){
        if(len==1){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102));
        }
        
        }
        if(len==2){
            
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102)); }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));
        }
        }
        if(len==3){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102)); }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
       
        }
        if(len==4){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(border);
        this.arr1[3].setForeground(new Color (102,102,102));}
        
        }
        if(len==5){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(border);
        this.arr1[3].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(border);
        this.arr1[4].setForeground(new Color (102,102,102));}
        
        }
        if(len==6){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(border);
        this.arr1[3].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(border);
        this.arr1[4].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(border);
        this.arr1[5].setForeground(new Color (102,102,102));}
        
        }
         if(len==6){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102)); }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(border);
        this.arr1[3].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(border);
        this.arr1[4].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(border);
        this.arr1[5].setForeground(new Color (102,102,102));}
       
        }
          if(len==7){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(border);
        this.arr1[0].setForeground(new Color (102,102,102));   }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(border);
        this.arr1[1].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(border);
        this.arr1[2].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(border);
        this.arr1[3].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(border);
        this.arr1[4].setForeground(new Color (102,102,102));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(border);
        this.arr1[5].setForeground(new Color (102,102,102));}
         if(evt.getSource()==arr1[6]){arr1[6].setBorder(border);
        this.arr1[6].setForeground(new Color (102,102,102));}
     
        }
    
    }
    private void myActionMouseFunenter(java.awt.event.MouseEvent evt){
   
    if(len==1){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));
        }}
        if(len==2){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));
        }
        
        }
        if(len==3){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        
        }
        if(len==4){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(null);
        this.arr1[3].setForeground(new Color (177,67,77));}
        
        }
        if(len==5){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));   }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(null);
        this.arr1[3].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(null);
        this.arr1[4].setForeground(new Color (177,67,77));}
     
        }
        if(len==6){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));  }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(null);
        this.arr1[3].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(null);
        this.arr1[4].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(null);
        this.arr1[5].setForeground(new Color (177,67,77));}
        }
      
         if(len==6){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));    }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(null);
        this.arr1[3].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(null);
        this.arr1[4].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(null);
        this.arr1[5].setForeground(new Color (177,67,77));}
        }
    
          if(len==7){
        if(evt.getSource()==arr1[0]){arr1[0].setBorder(null);
        this.arr1[0].setForeground(new Color (177,67,77));  }
        if(evt.getSource()==arr1[1]){arr1[1].setBorder(null);
        this.arr1[1].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[2]){arr1[2].setBorder(null);
        this.arr1[2].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[3]){arr1[3].setBorder(null);
        this.arr1[3].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[4]){arr1[4].setBorder(null);
        this.arr1[4].setForeground(new Color (177,67,77));}
        if(evt.getSource()==arr1[5]){arr1[5].setBorder(null);
        this.arr1[5].setForeground(new Color (177,67,77));}
         //if(evt.getSource()==arr1[6]){arr1[6].setBorder(null);
        //this.arr1[6].setForeground(new Color (177,67,77));}
        }
      
    
    
    
    }
    /*
    private void myActionMouseEnterchat (java.awt.event.MouseEvent evt){
     if(len==1){
        if(evt.getSource()==arr6[0]){
        this.arr6[0].setOpaque(true);
        }
        
        }
        if(len==2){ 
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        }
        if(len==3){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,255,255));}
        
        }
        if(len==4){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,255,255));}
        
        }
        if(len==5){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,255,255));}
        
        }
         if(len==6){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[5]){arr6[5].setBackground(new Color (255,255,255));}
        }
          if(len==7){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[5]){arr6[5].setBackground(new Color (255,255,255));}
        if(evt.getSource()==arr6[6]){arr6[6].setBackground(new Color (255,255,255));}
        }
    }
    private void myActionMouseExitchat (java.awt.event.MouseEvent evt){
    
         if(len==1){
        if(evt.getSource()==arr6[0]){
        this.arr6[0].setOpaque(true);
        }
        
        }
        if(len==2){ 
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        }
        if(len==3){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,204,51));}
        
        }
        if(len==4){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,204,51));}
        
        }
        if(len==5){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,204,51));}
        
        }
         if(len==6){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[5]){arr6[5].setBackground(new Color (255,204,51));}
        }
          if(len==7){
        if(evt.getSource()==arr6[0]){arr6[0].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[1]){arr6[1].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[2]){arr6[2].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[3]){arr6[3].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[4]){arr6[4].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[5]){arr6[5].setBackground(new Color (255,204,51));}
        if(evt.getSource()==arr6[6]){arr6[6].setBackground(new Color (255,204,51));}
        }
        
    }
    */
    
    //****************************************************************
    
    
    
    private void change_passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseEntered
      change_pass.setForeground(new Color(0,0,0));
      change_pass.setBackground(Color.WHITE);
        
    }//GEN-LAST:event_change_passMouseEntered

    private void change_passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseExited
    
        change_pass.setForeground(new Color(255,255,255));
        change_pass.setBackground(new Color(38,50,54));
         change_pass.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_change_passMouseExited

    private void min_maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_min_maxMouseClicked

    private void min_maxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\min_press.png",min_max);
    }//GEN-LAST:event_min_maxMouseEntered

    private void min_maxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\min_rel.png",min_max);
    }//GEN-LAST:event_min_maxMouseExited

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Main_frame().setVisible(true);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\press_exit.png",exit);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\cross.png",exit);
    }//GEN-LAST:event_exitMouseExited

    private void propertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseClicked
        // TODO add your handling code here:
        count++;
        if(count == 1){Setting_panel.setVisible(true);}
        if(count == 2 ){Setting_panel.setVisible(false); count = 0;}

    }//GEN-LAST:event_propertiesMouseClicked

    private void propertiesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\prop_press.png",properties);
    }//GEN-LAST:event_propertiesMouseEntered

    private void propertiesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\prop_rel.png",properties);
    }//GEN-LAST:event_propertiesMouseExited

    private void change_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseClicked
        // TODO add your handling code here:
        Reset_pass a = new Reset_pass();
        a.setVisible(true);
    }//GEN-LAST:event_change_passMouseClicked

    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(home_for_stu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_for_stu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_for_stu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_for_stu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
        
    }
    
    public void fun (int ln){
    // iwill assume that the data base base is ready and i have 4 courses for this student 
    // now iwill generate the label i want 
    int lenth = ln ;
    Border border = BorderFactory.createLineBorder(new Color (255,204,51));
    
    // initial values we will start with
   
    JLabel size = new JLabel();
    size.setLocation(720,90);
    size.setSize(1,lenth*204);
    //size.setText("0");
    
    
    int hight_photo = 450;
    int width_photo = 100; 
    int photo_Height_size = 120;
    int photo_width_size = 160;
    
    int hight_photo_dec = 450;
    int width_photo_dec = 220; 
    int photo_dec_Height_size = 40;
    int photo_dec_width_size = 160;
     
    
    int hight_title = 100;
    int width_title = 100; 
    int title_Height_size = 300;
    int title_width_size = 40;
    
    int hight_teacher = 80;
    int width_tacher = 150;
    int teacher_Height_size = 350;
    int teacher_width_size = 20;
    
    int hight_courseID = 80;
    int width_courseID = 180;
    int courseID_Height_size = 350;
    int courseID_width_size = 20;
    
    int hight_chat = 400;
    int width_chat = 100; 
    int chat_Height_size = 50;
    int chat_width_size = 40;
    
    for(int i = 0 ; i< lenth ; i++){
    
        arr1[i].setLocation(hight_title,width_title);
        arr1[i].setSize(title_Height_size,title_width_size);
        arr2[i].setLocation(hight_teacher,width_tacher);
        arr2[i].setSize(teacher_Height_size,teacher_width_size);
        arr3[i].setLocation(hight_courseID,width_courseID);
        arr3[i].setSize(courseID_Height_size,courseID_width_size);
        arr4[i].setLocation(hight_photo,width_photo);
        arr4[i].setSize(photo_width_size,photo_Height_size);
        arr5[i].setLocation(hight_photo_dec,width_photo_dec);
        arr5[i].setSize(photo_dec_width_size,photo_dec_Height_size);
        //arr6[i].setLocation(hight_chat,width_chat);
        //arr6[i].setSize(chat_Height_size,chat_width_size);
        //incremanting
        width_title += 180; 
        width_tacher +=180;
        width_courseID +=180;
        width_photo+=180;
        width_photo_dec+=180;
        width_chat+=180;
        arr1[i].setText(c.get(i).getCoursename());
        arr1[i].setForeground(new Color(177,67,77));
        arr5[i].setForeground(new Color(177,67,77));
        arr2[i].setText(String.valueOf(c.get(i).getCourseno()));
        arr1[i].setVisible(true);
        arr2[i].setVisible(true);
        arr3[i].setVisible(true);
        arr1[i].setFont(new Font ("Trebuchet MS" ,Font.PLAIN , 24));
        arr2[i].setFont(new Font ("Trebuchet MS" ,Font.PLAIN , 15));
        arr3[i].setFont(new Font ("Trebuchet MS" ,Font.PLAIN , 15));
        arr2[i].setForeground(new Color (152,152,152));
        arr3[i].setForeground(new Color (102,102,102));
        //arr4[i].setBackground(Color.red);
        
       // arr5[i].setBorder(border);
        arr5[i].setFont(new Font("Trebuchet MS" ,Font.PLAIN , 14));
        arr5[i].setHorizontalTextPosition(JLabel.CENTER);
        arr4[i].setOpaque(true);
        arr5[i].setOpaque(true);
        arr5[i].setBackground(new Color(230, 235, 237));
        //arr6[i].setText("C");
        //arr6[i].setFont(new Font("Arial Rounded MT" ,Font.BOLD, 40));
        //arr6[i].setBorder(border);
        //arr6[i].setOpaque(true);
        //arr6[i].setBackground(new Color (255,204,51));
        /*
        arr1[0].setText("Computer Programming");
        arr1[1].setText("Computer Architecture 1");
        arr1[2].setText("Electrical Circuits lab");
        arr1[3].setText("Electronic Circuits 1");
        arr1[4].setText("Dumpy Boy");
        */

        this.basicbody.add(arr1[i]);
        this.basicbody.add(arr2[i]);
        this.basicbody.add(arr3[i]);
        this.basicbody.add(arr4[i]);
        this.basicbody.add(arr5[i]);
        //this.basicbody.add(arr6[i]);
        
        
    }
   
    
     EntityManager em = Persistence.createEntityManagerFactory("Software_ProjectPU").createEntityManager();
        Query qry = em.createNamedQuery("Courses.findAll");
        List<Courses> chat = qry.getResultList();
        for(Courses x  : chat){
            for(int i =  0 ; i < lenth ;i ++){
                
            if(x.getCoursename().toString().toUpperCase().equals(arr1[i].getText().toUpperCase())){
                String path = x.getImage();
                arr4[i].setIcon(new ImageIcon(path));
                System.out.print(path);
            }
            }
        }
   
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Setting_panel;
    private javax.swing.JPanel basicbody;
    private javax.swing.JPanel body;
    private javax.swing.JLabel change_pass;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel for4_courses;
    private javax.swing.JLabel for5_courses;
    private javax.swing.JLabel for6_courses;
    private javax.swing.JLabel for7_courses;
    private javax.swing.JLabel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel min_max;
    private javax.swing.JLabel properties;
    private javax.swing.JLabel user_name;
    private javax.swing.JLabel user_photo;
    // End of variables declaration//GEN-END:variables

   
}

