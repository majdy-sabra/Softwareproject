

import database.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CourseGradesProf extends javax.swing.JFrame {

    static int index = 0;
    boolean p1, p2 = false;
    /**
     * Creates new form CourseGrades
     */
    public CourseGradesProf() {
        initComponents();
        jTable_Grades.getTableHeader().setDefaultRenderer(new HeaderSpecifications());
        
        jTable_Grades.setRowHeight(25);
        jScrollPane_Grades.getViewport().setBackground(new Color(253, 252, 246));
        try {
            this.display_all_grades();
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(LogInInterface.role.equals("TA")){
            DefaultTableModel model = (DefaultTableModel) jTable_Grades.getModel();
                jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Assignments a_to_ev = em.find(Assignments.class, BigDecimal.valueOf(TACourseSections.sel_sec));
                if(a_to_ev == null)
                {
                    
                jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                    
                }
                else {
                    if(a_to_ev.getPermission().equals("F")){
                        jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                        if(a_to_ev.getPermission2().equals("F"))
                            jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(2));
                        else
                            p2 = true;
                    }
                    else{
                        p1 = true;
                        if(a_to_ev.getPermission2().equals("F"))
                            jTable_Grades.removeColumn(jTable_Grades.getColumnModel().getColumn(3));
                        else
                            p2 = true;
                    
                    
                    }
                }
            
        }
        
    }
    //~J
    public void display_all_grades() throws SQLException{
            {DefaultTableModel model = (DefaultTableModel) jTable_Grades.getModel();
                model.setRowCount(0);}
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "select students_sections.studentid\n" +
                         "from students_sections\n" +
                         "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec ; 
            if(LogInInterface.role.equals("TA")){
                sql = "select students_sections.studentid\n" +
                         "from students_sections\n" +
                         "where students_sections.sectionno = " + TACourseSections.sel_sec ; 
            }
            Statement smt = con.createStatement();
            ResultSet stu_ids  = smt.executeQuery(sql);
            String sql2 = "";
            Statement smt2 = con.createStatement();
            String sql3 = "";
            Statement smt3 = con.createStatement();
            
            while(stu_ids.next()){
                DefaultTableModel model = (DefaultTableModel) jTable_Grades.getModel();
                sql2 = "select students.studentname\n" +
                      "from students\n" +
                      "where students.studentid = " + stu_ids.getInt(1);
                smt2 = con.createStatement();
                ResultSet sname = smt2.executeQuery(sql2);
                String sn = "";
                while(sname.next())
                    sn = sname.getString(1);
                sql3 = "select FIRSTEXAM, SECONDEXAM,  FINALEXAM, ASSIGNMENT1, ASSIGNMENT2\n" +
                        "from grades\n" +
                        "where grades.id = (select students_sections.id \n" +
                        "from students_sections \n" +
                        "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                        "and students_sections.studentid = " + stu_ids.getInt(1) + " )";
                if(LogInInterface.role.equals("TA")){
                    sql3 = "select FIRSTEXAM, SECONDEXAM,  FINALEXAM, ASSIGNMENT1, ASSIGNMENT2\n" +
                        "from grades\n" +
                        "where grades.id = (select students_sections.id \n" +
                        "from students_sections \n" +
                        "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                        "and students_sections.studentid = " + stu_ids.getInt(1) + " )";
                
                }
                smt3 = con.createStatement();
                ResultSet sgrades = smt3.executeQuery(sql3);
                sgrades.next();
                model.addRow(new Object[]{stu_ids.getInt(1), sn, sgrades.getInt(1), sgrades.getInt(2), sgrades.getInt(3), sgrades.getInt(4), sgrades.getInt(5)});
                
                
            }
            
    
    
    }
    public boolean search_student(int id) throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String user,url,Password; 
        url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
        user="C##happygrades";
        Password="scranton";
        Connection con = DriverManager.getConnection(url,user,Password);
        con.setAutoCommit(false);
        String sql = "select students_sections.studentid\n" +
                     "from students_sections\n" +
                     "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec; 
        if(LogInInterface.role.equals("TA")){
            sql = "select students_sections.studentid\n" +
                     "from students_sections\n" +
                     "where students_sections.sectionno = " + TACourseSections.sel_sec; 
        }
        Statement smt = con.createStatement();
        ResultSet stu_ids  = smt.executeQuery(sql);       
        while(stu_ids.next()){
            if(stu_ids.getInt(1) == id)
                return true;
        }
        return false;
    }
    //~J
    //This function is a timer that specifies the time of showing the notification, once you need
    //to display a notification, then you must pass the notification to this timer to view the
    //notification for some time then hide it.
    private void callTimer(JFrame notification) {
        Timer timer = new Timer();
        notification.setVisible(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                notification.setVisible(false);
            }
        }, 6000);
    }
    
    //Function to make the label's background white when the mouse entered.
    public void scaleimage__backcwhite(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        label.setIcon(scaledIcon);
    }
    
    //Function to return the label's original background when the mouse exited.
    public void scaleimage__backc_white_remove(JLabel label) {
        ImageIcon icon = new ImageIcon("");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        label.setIcon(scaledIcon);
    }
    
    //Function to replace the button with another one with a different color.
    public void scaleimage__replaceButton(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        label.setIcon(scaledIcon);
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
        jLbl_GradeIcon = new javax.swing.JLabel();
        jLbl_header = new javax.swing.JLabel();
        jLbl_SearchEye = new javax.swing.JLabel();
        jTxt_SearchID = new javax.swing.JTextField();
        jLbl_returnBack = new javax.swing.JLabel();
        jLbl_UpBar = new javax.swing.JLabel();
        jTxt_StuID = new javax.swing.JTextField();
        jTxt_Grade = new javax.swing.JTextField();
        jLbl_update = new javax.swing.JLabel();
        jLbl_save = new javax.swing.JLabel();
        jLbl_Remove = new javax.swing.JLabel();
        jScrollPane_Grades = new javax.swing.JScrollPane();
        jTable_Grades = new javax.swing.JTable();
        jLbl_Add1 = new javax.swing.JLabel();
        jComboBox_ChooseEvaluationType = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(1283, 694));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(253, 252, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbl_GradeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GradeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/GradesIcon.png"))); // NOI18N
        jPanel1.add(jLbl_GradeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jLbl_header.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLbl_header.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_header.setText("Grading System");
        jPanel1.add(jLbl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 8, 420, 60));

        jLbl_SearchEye.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_SearchEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/OrangeSearch.png"))); // NOI18N
        jLbl_SearchEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_SearchEyeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_SearchEyeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_SearchEyeMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_SearchEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 17, 30, 30));

        jTxt_SearchID.setBackground(new Color(255, 255, 255, 0));
        jTxt_SearchID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTxt_SearchID.setForeground(new java.awt.Color(255, 255, 255));
        jTxt_SearchID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_SearchID.setText("Enter a student's ID");
        jTxt_SearchID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jTxt_SearchID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_SearchIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_SearchIDFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_SearchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 16, 310, 40));

        jLbl_returnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/OrangeExit.png"))); // NOI18N
        jLbl_returnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_returnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_returnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_returnBackMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_returnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 40, 40));

        jLbl_UpBar.setBackground(new java.awt.Color(38, 50, 54));
        jLbl_UpBar.setOpaque(true);
        jPanel1.add(jLbl_UpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 70));

        jTxt_StuID.setBackground(new Color(255, 255, 255, 0));
        jTxt_StuID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTxt_StuID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_StuID.setText("Type the student's ID");
        jTxt_StuID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_StuID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_StuIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_StuIDFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_StuID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 310, 40));

        jTxt_Grade.setBackground(new Color(255, 255, 255, 0));
        jTxt_Grade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTxt_Grade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_Grade.setText("Type the grade");
        jTxt_Grade.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_Grade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_GradeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_GradeFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_Grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 310, 40));

        jLbl_update.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_update.setForeground(new java.awt.Color(0, 0, 0));
        jLbl_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_update.setText("Update Grade");
        jLbl_update.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_updateMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 180, 50));

        jLbl_save.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_save.setForeground(new java.awt.Color(0, 0, 0));
        jLbl_save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_save.setText("Save");
        jLbl_save.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_saveMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 180, 50));

        jLbl_Remove.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_Remove.setForeground(new java.awt.Color(0, 0, 0));
        jLbl_Remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Remove.setText("Remove Grade");
        jLbl_Remove.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_Remove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_RemoveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_RemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_RemoveMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_Remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 180, 50));

        jTable_Grades.setBackground(new java.awt.Color(240, 240, 240));
        jTable_Grades.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable_Grades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "      Student ID", "      Student Name", "      First Grade", "      Second Grade", "      Final Grade", "      Assignment 1", "      Assignment 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Grades.setGridColor(new java.awt.Color(73, 129, 189));
        jTable_Grades.setRowHeight(25);
        jTable_Grades.setSelectionBackground(new java.awt.Color(147, 194, 210));
        jTable_Grades.setShowGrid(true);
        jTable_Grades.getTableHeader().setReorderingAllowed(false);
        jScrollPane_Grades.setViewportView(jTable_Grades);

        jPanel1.add(jScrollPane_Grades, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 800, 630));

        jLbl_Add1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_Add1.setForeground(new java.awt.Color(0, 0, 0));
        jLbl_Add1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Add1.setText("Add Grade");
        jLbl_Add1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_Add1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_Add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_Add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_Add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_Add1MouseExited(evt);
            }
        });
        jPanel1.add(jLbl_Add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 180, 50));

        jComboBox_ChooseEvaluationType.setBackground(new java.awt.Color(255, 255, 255,0));
        jComboBox_ChooseEvaluationType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_ChooseEvaluationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Evaluation Type", "First Exam Grade", "Second Exam Grade", "Final Exam Grade", "Assignment 1 Grade", "Assignment 2 Grade", " " }));
        jComboBox_ChooseEvaluationType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel1.add(jComboBox_ChooseEvaluationType, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLbl_RemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_RemoveMouseExited
        scaleimage__backc_white_remove(jLbl_Remove);
        jLbl_Remove.setForeground(Color.black);
    }//GEN-LAST:event_jLbl_RemoveMouseExited

    private void jLbl_RemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_RemoveMouseEntered
        scaleimage__backcwhite(jLbl_Remove, "src\\photo\\white.png");
        jLbl_Remove.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_RemoveMouseEntered

    private void jLbl_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_saveMouseExited
        scaleimage__backc_white_remove(jLbl_save);
        jLbl_save.setForeground(Color.black);

    }//GEN-LAST:event_jLbl_saveMouseExited

    private void jLbl_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_saveMouseEntered
        scaleimage__backcwhite(jLbl_save, "src\\photo\\white.png");
        jLbl_save.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_saveMouseEntered

    private void jLbl_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_updateMouseExited
        scaleimage__backc_white_remove(jLbl_update);
        jLbl_update.setForeground(Color.black);
    }//GEN-LAST:event_jLbl_updateMouseExited

    private void jLbl_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_updateMouseEntered
        scaleimage__backcwhite(jLbl_update, "src\\photo\\white.png");
        jLbl_update.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_updateMouseEntered

    private void jTxt_GradeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_GradeFocusLost
        if (jTxt_Grade.getText().equals("")) {
            jTxt_Grade.setText("Type the grade");
        }
    }//GEN-LAST:event_jTxt_GradeFocusLost

    private void jTxt_GradeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_GradeFocusGained
        if (jTxt_Grade.getText().equals("Type the grade")) {
            jTxt_Grade.setText("");
        }
    }//GEN-LAST:event_jTxt_GradeFocusGained

    private void jTxt_StuIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_StuIDFocusLost
        if (jTxt_StuID.getText().equals("")) {
            jTxt_StuID.setText("Type the student's ID");
        }
    }//GEN-LAST:event_jTxt_StuIDFocusLost

    private void jTxt_StuIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_StuIDFocusGained
        if (jTxt_StuID.getText().equals("Type the student's ID")) {
            jTxt_StuID.setText("");
        }
    }//GEN-LAST:event_jTxt_StuIDFocusGained

    private void jLbl_returnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseExited
        scaleimage__replaceButton(jLbl_returnBack, "src\\photo\\botton\\OrangeExit.png");
    }//GEN-LAST:event_jLbl_returnBackMouseExited

    private void jLbl_returnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseEntered
        scaleimage__backcwhite(jLbl_returnBack, "src\\photo\\botton\\rel_exit.png");
    }//GEN-LAST:event_jLbl_returnBackMouseEntered

    private void jTxt_SearchIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_SearchIDFocusLost
        if (jTxt_SearchID.getText().equals("")) {
            jTxt_SearchID.setText("Enter a student's ID");
        }
    }//GEN-LAST:event_jTxt_SearchIDFocusLost

    private void jTxt_SearchIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_SearchIDFocusGained
        if (jTxt_SearchID.getText().equals("Enter a student's ID")) {
            jTxt_SearchID.setText("");
        }
    }//GEN-LAST:event_jTxt_SearchIDFocusGained

    private void jLbl_SearchEyeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_SearchEyeMouseExited
        scaleimage__replaceButton(jLbl_SearchEye, "src\\photo\\OrangeSearch.png");

    }//GEN-LAST:event_jLbl_SearchEyeMouseExited

    private void jLbl_SearchEyeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_SearchEyeMouseEntered
        scaleimage__backcwhite(jLbl_SearchEye, "src\\photo\\WhiteSearch.png");
    }//GEN-LAST:event_jLbl_SearchEyeMouseEntered

    //Once this button is clicked, you must store the data in the database, and view the new stored data in the jTable_Grades.
    private void jLbl_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_updateMouseClicked
        // TODO add your handling code here:
        try {                                       
            // TODO add your handling code here:
            if(jTxt_StuID.getText().isEmpty() || jTxt_Grade.getText().isEmpty() || (jComboBox_ChooseEvaluationType.getSelectedIndex() == 0)){
                
                callTimer(new WarningNotification("Make sure to fill all fields!"));
                return;
            }
            {boolean isNumeric = jTxt_StuID.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
                
                callTimer(new WarningNotification("Invalid Input type for Student ID!"));
                return;
                
            }
            }
            {boolean isNumeric = jTxt_Grade.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
                
                callTimer(new WarningNotification("Invalid Input type for entered grade!"));
                return;
                
            }
            }
            try {
                if(!search_student(Integer.valueOf(jTxt_StuID.getText())))
                 {
                    callTimer(new WarningNotification("Student doesn't belong to this section!"));
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "";
            if(LogInInterface.role.equals("TA")){
                sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            
            }
            else{
            sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            }
            Statement smt = con.createStatement();
            ResultSet sgrade = smt.executeQuery(sql);
            int gid = 0;
            while(sgrade.next())
                gid = sgrade.getInt(1);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Grades grade_to_add = em.find(Grades.class, new BigDecimal(gid));
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 1){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getFirstexam() == null) || (grade_to_add.getFirstexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("No grade to update. Use Add Grade button."));
                    return; 
                
                }
                grade_to_add.setFirstexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            else if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 2){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getSecondexam() == null)|| (grade_to_add.getSecondexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("No grade to update. Use Add Grade button."));
                    return; 
                
                }
                grade_to_add.setSecondexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 3){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getFinalexam() == null)|| (grade_to_add.getFinalexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("No grade to update. Use Add Grade button."));
                    return; 
                
                }
                grade_to_add.setFinalexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 4){
                if(LogInInterface.role.equals("TA")){
                    if(!p1){
                        callTimer(new ErrorNotification("Task Failed! Ypu don't have permission."));
                        return; 
                    }
                    }
                if((grade_to_add.getAssignment1() == null)|| (grade_to_add.getAssignment1() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("No grade to update. Use Add Grade button."));
                    return; 
                
                }
                grade_to_add.setAssignment1(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 5){
                if(LogInInterface.role.equals("TA")){
                    if(!p2){
                        callTimer(new ErrorNotification("Task Failed! Ypu don't have permission."));
                        return; 
                    }
                }
                if((grade_to_add.getAssignment2() == null)|| (grade_to_add.getAssignment2() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("No grade to update. Use Add Grade button."));
                    return; 
                
                }
                grade_to_add.setAssignment2(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            callTimer(new SuccessNotification("Grade Updated Successfully"));
            display_all_grades();
                    return; 
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLbl_updateMouseClicked
    
    //Once this button is clicked, you must delete the data from both the database and the jTable_Grades.
    //To delete a specific grade you must search for a specific student using the search button.
    //If the data is deleted, then a notification interface called "successNotification" will appear.
    //Note: You pass the following statement to the notification in case of a successful delete "The garde is successfully deleted!".
    
    //otherwise, a notification interface called "ErrorNotification" will appear.
    //Note: You pass the following statement to the notification in case of an unsuccessful addition "The garde can't be added!".
    private void jLbl_RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_RemoveMouseClicked
        // TODO add your handling code here:
        try {                                       
            // TODO add your handling code here:
            if(jTxt_StuID.getText().isEmpty() || (jComboBox_ChooseEvaluationType.getSelectedIndex() == 0)){
                
                callTimer(new WarningNotification("Make sure to fill all fields!"));
                return;
            }
            {boolean isNumeric = jTxt_StuID.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
                
                callTimer(new WarningNotification("Invalid Input type for Student ID!"));
                return;
                
            }
            }
            
            try {
                if(!search_student(Integer.valueOf(jTxt_StuID.getText())))
                 {
                    callTimer(new WarningNotification("Student doesn't belong to this section!"));
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "";
            if(LogInInterface.role.equals("TA")){
                sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            }
            else{
            sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            }
            Statement smt = con.createStatement();
            ResultSet sgrade = smt.executeQuery(sql);
            int gid = 0;
            while(sgrade.next())
                gid = sgrade.getInt(1);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Grades grade_to_add = em.find(Grades.class, new BigDecimal(gid));
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 1){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getFirstexam() == null)|| (grade_to_add.getFirstexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already doesn't exist!"));
                    return; 
                
                }
                grade_to_add.setFirstexam(null);
                em.getTransaction().commit();
                em.close();
            }
            else if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 2){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getSecondexam() == null)|| (grade_to_add.getSecondexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already doesn't exist!"));
                    return; 
                
                }
                grade_to_add.setSecondexam(null);
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 3){
                if(LogInInterface.role.equals("TA")){
                        callTimer(new ErrorNotification("Task Failed! Professors Only."));
                        return; 
                    }
                if((grade_to_add.getFinalexam() == null)|| (grade_to_add.getFinalexam() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already doesn't exist!"));
                    return; 
                
                }
                grade_to_add.setFinalexam(null);
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 4){
                if(LogInInterface.role.equals("TA")){
                    if(!p1){
                        callTimer(new ErrorNotification("Task Failed! Ypu don't have permission."));
                        return; 
                    }
                    }
                if((grade_to_add.getAssignment1() == null)|| (grade_to_add.getAssignment1() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already doesn't exist!"));
                    return; 
                
                }
                grade_to_add.setAssignment1(null);
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 5){
                if(LogInInterface.role.equals("TA")){
                    if(!p2){
                        callTimer(new ErrorNotification("Task Failed! Ypu don't have permission."));
                        return; 
                    }
                    }
                if((grade_to_add.getAssignment2() == null)|| (grade_to_add.getAssignment2() == BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already doesn't exist!"));
                    return; 
                
                }
                grade_to_add.setAssignment2(null);
                em.getTransaction().commit();
                em.close();
            }
            callTimer(new SuccessNotification("Grade Deleted Successfully"));
            display_all_grades();
                    return; 
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLbl_RemoveMouseClicked
    
    //Once this button is clicked, you must update existing data in both the database and the jTable_Grades.
    //To update a specific grade you must search for a specific student  using the search button.
    //If the data is updated, then a notification interface called "successNotification" will appear.
    //Note: You pass the following statement to the notification in case of a successful delete "The garde is successfully updated!".
    
    //otherwise, a notification interface called "ErrorNotification" will appear.
    //Note: You pass the following statement to the notification in case of an unsuccessful deletion "The garde can't be deleted!".
    private void jLbl_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_saveMouseClicked
        // TODO add your handling code here:
        
         DefaultTableModel model = (DefaultTableModel) jTable_Grades.getModel();

        for (int i = 0; model.getRowCount() > i; i++) {
            
             try {
                 String user,url,Password;
                 url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
                 user="C##happygrades";
                 Password="scranton";
                 Connection con = DriverManager.getConnection(url,user,Password);
                 con.setAutoCommit(false);
                 String sql = "";
                 if(LogInInterface.role.equals("TA")){
                 sql = "select grades.id\n" +
                         "from grades\n" +
                         "where grades.id = (select students_sections.id \n" +
                         "from students_sections \n" +
                         "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                         "and students_sections.studentid = " + jTable_Grades.getValueAt(i, 0) + " )";
                 
                 }
                 else{
                 sql = "select grades.id\n" +
                         "from grades\n" +
                         "where grades.id = (select students_sections.id \n" +
                         "from students_sections \n" +
                         "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                         "and students_sections.studentid = " + jTable_Grades.getValueAt(i, 0) + " )";
                 }
                 Statement smt = con.createStatement();
                 ResultSet sgrade = smt.executeQuery(sql);
                 int gid = 0;
                 while(sgrade.next())
                     gid = sgrade.getInt(1);
                 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                 EntityManager em = emf.createEntityManager();
                 em.getTransaction().begin();
                 Grades grade_to_save = em.find(Grades.class, new BigDecimal(gid));
                 if(LogInInterface.role.equals("TA")){
                     if(p1){
                         grade_to_save.setAssignment1(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 2)));
                         if(p2)
                             grade_to_save.setAssignment2(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 3)));
                     }
                     else{
                         if(p2)
                             grade_to_save.setAssignment2(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 2)));
                     
                     
                     }
                 
                 }
                 else{
                    grade_to_save.setFirstexam(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 2)));
                    grade_to_save.setSecondexam(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 3)));
                    grade_to_save.setFinalexam(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 4)));
                    grade_to_save.setAssignment1(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 5)));
                    grade_to_save.setAssignment2(BigInteger.valueOf((Integer)jTable_Grades.getValueAt(i, 6)));
                }
                 em.getTransaction().commit();
                em.close();
             } catch (SQLException ex) {
                 Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        try {
            callTimer(new SuccessNotification("Grades Saved Successfully"));
            display_all_grades();
                    return; 
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jLbl_saveMouseClicked

    //Once this button is clicked, you must search for the student with the specified ID in the jTxt_SearchID field, and fill his/her ID in 
    //jTxt_StuID field, and his/her grade in jTxt_Grade field.
    
    //If the data is found, then a notification interface called "successNotification" will appear.
    //Note: You pass the following statement to the notification in case of a successful search "The student ID is successfully found!".
    
    //otherwise, a notification interface called "ErrorNotification" will appear.
    //Note: You pass the following statement to the notification in case of an unsuccessful deletion "The student ID isn't found!".
    private void jLbl_SearchEyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_SearchEyeMouseClicked
        try {                                            
            // TODO add your handling code here:
            boolean isNumeric = jTxt_SearchID.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
            
            callTimer(new WarningNotification("Invalid Input!"));
                    return;
            
            }
            if(jTxt_SearchID.getText().isEmpty()){
                try {
                    display_all_grades();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
            try {
                if(!search_student(Integer.valueOf(jTxt_SearchID.getText()))){
                    callTimer(new WarningNotification("ID doesn't belong to this section!"));
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DefaultTableModel model = (DefaultTableModel) jTable_Grades.getModel();
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            {DefaultTableModel tmodel = (DefaultTableModel) jTable_Grades.getModel();
                tmodel.setRowCount(0);}
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql2 = "select students.studentname\n" +
                    "from students\n" +
                    "where students.studentid = " + jTxt_SearchID.getText();
            Statement smt2 = con.createStatement();
            ResultSet sname = smt2.executeQuery(sql2);
            String sn = "";
            while(sname.next())
                sn = sname.getString(1);
            String sql3 = "select FIRSTEXAM, SECONDEXAM,  FINALEXAM, ASSIGNMENT1, ASSIGNMENT2\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_SearchID.getText() + " )";
            if(LogInInterface.role.equals("TA")){
                sql3 = "select FIRSTEXAM, SECONDEXAM,  FINALEXAM, ASSIGNMENT1, ASSIGNMENT2\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_SearchID.getText() + " )";
            
            }
            Statement smt3 = con.createStatement();
            ResultSet sgrades = smt3.executeQuery(sql3);
            sgrades.next();
            model.addRow(new Object[]{jTxt_SearchID.getText(), sn, sgrades.getInt(1), sgrades.getInt(2), sgrades.getInt(3), sgrades.getInt(4), sgrades.getInt(5)});
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }//GEN-LAST:event_jLbl_SearchEyeMouseClicked

    private void jLbl_returnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseClicked
        if(LogInInterface.role.equals("TA")){
            try {
                new TACourseSections(TACourseSections.secs.size()).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            new ProfessorGradingInterface().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLbl_returnBackMouseClicked

    private void jLbl_Add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_Add1MouseClicked
        try {                                       
            // TODO add your handling code here:
            if(jTxt_StuID.getText().isEmpty() || jTxt_Grade.getText().isEmpty() || (jComboBox_ChooseEvaluationType.getSelectedIndex() == 0)){
                
                callTimer(new WarningNotification("Make sure to fill all fields!"));
                return;
            }
            {boolean isNumeric = jTxt_StuID.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
                
                callTimer(new WarningNotification("Invalid Input type for Student ID!"));
                return;
                
            }
            }
            {boolean isNumeric = jTxt_Grade.getText().chars().allMatch( Character::isDigit );
            if(!isNumeric)
            {
                
                callTimer(new WarningNotification("Invalid Input type for entered grade!"));
                return;
                
            }
            }
            try {
                if(!search_student(Integer.valueOf(jTxt_StuID.getText())))
                 {
                    callTimer(new WarningNotification("Student doesn't belong to this section!"));
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "";
            if(LogInInterface.role.equals("TA")){
            sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + TACourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            
            
            }
            else{
            sql = "select grades.id\n" +
                    "from grades\n" +
                    "where grades.id = (select students_sections.id \n" +
                    "from students_sections \n" +
                    "where students_sections.sectionno = " + ProfessorCourseSections.sel_sec+ "\n" +
                    "and students_sections.studentid = " + jTxt_StuID.getText() + " )";
            }
            Statement smt = con.createStatement();
            ResultSet sgrade = smt.executeQuery(sql);
            int gid = 0;
            while(sgrade.next())
                gid = sgrade.getInt(1);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Grades grade_to_add = em.find(Grades.class, new BigDecimal(gid));
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 1){
                if(LogInInterface.role.equals("TA")){
                    callTimer(new ErrorNotification("Task Failed! Professors Only."));
                    return; 
                
                }
                if((grade_to_add.getFirstexam() != null)&& (grade_to_add.getFirstexam() != BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already exists. Use the update button."));
                    return; 
                
                }
                grade_to_add.setFirstexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            else if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 2){
                if(LogInInterface.role.equals("TA")){
                    callTimer(new ErrorNotification("Task Failed! Professors Only."));
                    return; 
                
                }
                if((grade_to_add.getSecondexam() != null)&& (grade_to_add.getSecondexam() != BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already exists. Use the update button."));
                    return; 
                
                }
                grade_to_add.setSecondexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 3){
                if(LogInInterface.role.equals("TA")){
                    callTimer(new ErrorNotification("Task Failed! Professors Only."));
                    return; 
                
                }
                if((grade_to_add.getFinalexam() != null)&& (grade_to_add.getFinalexam() != BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already exists. Use the update button."));
                    return; 
                
                }
                grade_to_add.setFinalexam(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 4){
                if(LogInInterface.role.equals("TA")){
                    if(!p1){
                        callTimer(new ErrorNotification("Task Failed! You don't have permission."));
                        return; 
                    }
                }
                if((grade_to_add.getAssignment1() != null)&& (grade_to_add.getAssignment1() != BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already exists. Use the update button."));
                    return; 
                
                }
                grade_to_add.setAssignment1(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            if(jComboBox_ChooseEvaluationType.getSelectedIndex() == 5){
                if(LogInInterface.role.equals("TA")){
                    if(!p2){
                        callTimer(new ErrorNotification("Task Failed! Ypu don't have permission."));
                        return; 
                    }
                    }
                if((grade_to_add.getAssignment2() != null)&& (grade_to_add.getAssignment2() != BigInteger.ZERO)){
                   callTimer(new WarningNotification("Grade already exists. Use the update button."));
                    return; 
                
                }
                grade_to_add.setAssignment2(new BigInteger(jTxt_Grade.getText()));
                em.getTransaction().commit();
                em.close();
            }
            callTimer(new SuccessNotification("Grade Assigned Successfully"));
            display_all_grades();
                    return; 
        } catch (SQLException ex) {
            Logger.getLogger(CourseGradesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLbl_Add1MouseClicked

    private void jLbl_Add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_Add1MouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_Add1, "src\\photo\\white.png");
        jLbl_Add1.setForeground(new Color(98, 168, 243));
        
    }//GEN-LAST:event_jLbl_Add1MouseEntered

    private void jLbl_Add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_Add1MouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove(jLbl_Add1);
        jLbl_Add1.setForeground(Color.black);
        
    }//GEN-LAST:event_jLbl_Add1MouseExited

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
            java.util.logging.Logger.getLogger(CourseGradesProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseGradesProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseGradesProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseGradesProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseGradesProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_ChooseEvaluationType;
    private javax.swing.JLabel jLbl_Add1;
    private javax.swing.JLabel jLbl_GradeIcon;
    private javax.swing.JLabel jLbl_Remove;
    private javax.swing.JLabel jLbl_SearchEye;
    private javax.swing.JLabel jLbl_UpBar;
    private javax.swing.JLabel jLbl_header;
    private javax.swing.JLabel jLbl_returnBack;
    private javax.swing.JLabel jLbl_save;
    private javax.swing.JLabel jLbl_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane_Grades;
    private javax.swing.JTable jTable_Grades;
    private javax.swing.JTextField jTxt_Grade;
    private javax.swing.JTextField jTxt_SearchID;
    private javax.swing.JTextField jTxt_StuID;
    // End of variables declaration//GEN-END:variables

    static public class HeaderSpecifications extends DefaultTableCellRenderer {
        public HeaderSpecifications() {
        setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable myTable, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(myTable, value, selected, focused, row, column);
            setBackground(new Color(38,50,54));
            setFont(new Font("Segoe UI", Font.BOLD, 12));
            setForeground(Color.white);
            return this;
        }
    }
}
