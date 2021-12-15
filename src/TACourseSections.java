


import database.Sections;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class TACourseSections extends javax.swing.JFrame {

    static int index = 0;
    public static int course_no = 0;
    public static List<Sections> secs = new ArrayList<Sections>();
    public static List<Integer> numstu = new ArrayList<Integer>();//contains the number of students for each section stored in a list
    public static int sel_sec;//selected section number

    /**
     * Creates new form CourseGradesProf
     */
    public TACourseSections() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public TACourseSections(int numberOfSections) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        determineNumberOfCourses(numberOfSections);
    }

    //A function to determine number of sections for each course for this professor.
    private void determineNumberOfCourses(int numOfSections) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String user,url,Password;
            url="jdbc:oracle:thin:@LAPTOP-1270LE9S:1521:XE";
            user="C##happygrades";
            Password="scranton";
            Connection con = DriverManager.getConnection(url,user,Password);
            con.setAutoCommit(false);
            String sql = "select sections.sectionno, sections.datee\n" +
                         "from sections, teachers_sections\n" +
                         "where sections.sectionno = teachers_sections.sectionno\n" +
                         "and teachers_sections.teacherid ="+LogInInterface.id+"\n" +
                         "and sections.courseno = "+ course_no;      
            Statement smt = con.createStatement();
            ResultSet rs  = smt.executeQuery(sql);//receives resultset from sql statement
            numstu.clear();
            secs.clear();
            while(rs.next()) {
                secs.add(new Sections(rs.getBigDecimal("sectionno"), rs.getString("datee")));
                sql = "select count(students_sections.id)\n" +
                  "from students_sections\n" +
                  "where students_sections.sectionno = " + rs.getBigDecimal("sectionno") + "\n" +
                  "group by (students_sections.sectionno)";
                smt = con.createStatement();
                ResultSet tmp = smt.executeQuery(sql);
                tmp.next();
                numstu.add(Integer.valueOf(tmp.getInt(1)));
                }
        //if the number of the sections for this course is 3, then do the following.
        if (numOfSections == 3) {
            //Make the first section visible.
            //~Jenan --> display sections' info
            jLbl_Sec1Number.setText(""+secs.get(0).getSectionno());
            jLbl_Sec1StudentsNum.setText(String.valueOf(numstu.get(0)));
            jLbl_Sec1Date.setText(secs.get(0).getDatee());
            
            jLbl_Sec2Number.setText(""+secs.get(1).getSectionno());
            jLbl_Sec2StudentsNum.setText(String.valueOf(numstu.get(1)));
            jLbl_Sec2Date.setText(secs.get(1).getDatee());
            
            jLbl_Sec3Number.setText(""+secs.get(2).getSectionno());
            jLbl_Sec3StudentsNum.setText(String.valueOf(numstu.get(2)));
            jLbl_Sec3Date.setText(secs.get(2).getDatee());
            //~J
            
            jLbl_Sec1NumIcon.setVisible(true);
            jLbl_Sec1Number.setVisible(true);
            
            jLbl_Sec1StudentsNumIcon.setVisible(true);
            jLbl_Sec1StudentsNum.setVisible(true);

            jLbl_Sec1DateIcon.setVisible(true);
            jLbl_Sec1Date.setVisible(true);

            jLbl_GoToGradingOfSec1.setVisible(true);

            //Make the second section visible.
            jLbl_Sec2NumIcon.setVisible(true);
            jLbl_Sec2Number.setVisible(true);
            
            jLbl_Sec2StudentsNumIcon.setVisible(true);
            jLbl_Sec2StudentsNum.setVisible(true);

            jLbl_Sec2DateIcon.setVisible(true);
            jLbl_Sec2Date.setVisible(true);

            jLbl_GoToGradingOfSec2.setVisible(true);

            //Make the third section visible.
            jLbl_Sec3NumIcon.setVisible(true);
            jLbl_Sec3Number.setVisible(true);
            
            jLbl_Sec3StudentsNumIcon.setVisible(true);
            jLbl_Sec3StudentsNum.setVisible(true);

            jLbl_Sec3DateIcon.setVisible(true);
            jLbl_Sec3Date.setVisible(true);

            jLbl_GoToGradingOfSec3.setVisible(true);
        } 

        //if the number of the sections for this course is 2, then do the following.
        else if (numOfSections == 2) {
            //~Jenan --> display sections' info
            jLbl_Sec1Number.setText(""+secs.get(0).getSectionno());
            jLbl_Sec1StudentsNum.setText(String.valueOf(numstu.get(0)));
            jLbl_Sec1Date.setText(secs.get(0).getDatee());
            
            jLbl_Sec2Number.setText(""+secs.get(1).getSectionno());
            jLbl_Sec2StudentsNum.setText(String.valueOf(numstu.get(1)));
            jLbl_Sec2Date.setText(secs.get(1).getDatee());
            //~J
            
            //Make the first section visible.
            jLbl_Sec1NumIcon.setVisible(true);
            jLbl_Sec1Number.setVisible(true);
            
            jLbl_Sec1StudentsNumIcon.setVisible(true);
            jLbl_Sec1StudentsNum.setVisible(true);
            
            jLbl_Sec1DateIcon.setVisible(true);
            jLbl_Sec1Date.setVisible(true);

            jLbl_GoToGradingOfSec1.setVisible(true);

            //Make the second section visible.
            jLbl_Sec2NumIcon.setVisible(true);
            jLbl_Sec2Number.setVisible(true);
            
            jLbl_Sec2StudentsNumIcon.setVisible(true);
            jLbl_Sec2StudentsNum.setVisible(true);

            jLbl_Sec2DateIcon.setVisible(true);
            jLbl_Sec2Date.setVisible(true);

            jLbl_GoToGradingOfSec2.setVisible(true);

            //Make the third section invisible.
            jLbl_Sec3NumIcon.setVisible(false);
            jLbl_Sec3Number.setVisible(false);
            
            jLbl_Sec3StudentsNumIcon.setVisible(false);
            jLbl_Sec3StudentsNum.setVisible(false);

            jLbl_Sec3DateIcon.setVisible(false);
            jLbl_Sec3Date.setVisible(false);

            jLbl_GoToGradingOfSec3.setVisible(false);

        } 
        
        //if the number of the sections for this course is 1, then do the following.        
        else if (numOfSections == 1) {
            //~Jenan --> display sections' info
            jLbl_Sec1Number.setText(""+secs.get(0).getSectionno());
            jLbl_Sec1StudentsNum.setText(String.valueOf(numstu.get(0)));
            jLbl_Sec1Date.setText(secs.get(0).getDatee());
            //~J
            
            //Make the first section visible.
            jLbl_Sec1NumIcon.setVisible(true);
            jLbl_Sec1Number.setVisible(true);
            
            jLbl_Sec1StudentsNumIcon.setVisible(true);
            jLbl_Sec1StudentsNum.setVisible(true);

            jLbl_Sec1DateIcon.setVisible(true);
            jLbl_Sec1Date.setVisible(true);

            jLbl_GoToGradingOfSec1.setVisible(true);

            //Make the second section invisible.
            jLbl_Sec2NumIcon.setVisible(false);
            jLbl_Sec2Number.setVisible(false);
            
            jLbl_Sec2StudentsNumIcon.setVisible(false);
            jLbl_Sec2StudentsNum.setVisible(false);

            jLbl_Sec2DateIcon.setVisible(false);
            jLbl_Sec2Date.setVisible(false);

            jLbl_GoToGradingOfSec2.setVisible(false);

            //Make the third section invisible.
            jLbl_Sec3NumIcon.setVisible(false);
            jLbl_Sec3Number.setVisible(false);
            
            jLbl_Sec3StudentsNumIcon.setVisible(false);
            jLbl_Sec3StudentsNum.setVisible(false);

            jLbl_Sec3DateIcon.setVisible(false);
            jLbl_Sec3Date.setVisible(false);

            jLbl_GoToGradingOfSec3.setVisible(false);

        }
        //The number of sections for each course is in range of 1 to 3 sections, there are no other cases.
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
        jLbl_Header = new javax.swing.JLabel();
        jLbl_returnBack = new javax.swing.JLabel();
        jLbl_UpBar = new javax.swing.JLabel();
        jLbl_Sec1NumIcon = new javax.swing.JLabel();
        jLbl_Sec1Number = new javax.swing.JLabel();
        jLbl_Sec1DateIcon = new javax.swing.JLabel();
        jLbl_Sec1Date = new javax.swing.JLabel();
        jLbl_Sec2NumIcon = new javax.swing.JLabel();
        jLbl_Sec2Number = new javax.swing.JLabel();
        jLbl_Sec2DateIcon = new javax.swing.JLabel();
        jLbl_Sec2Date = new javax.swing.JLabel();
        jLbl_GoToGradingOfSec2 = new javax.swing.JLabel();
        jLbl_Sec3NumIcon = new javax.swing.JLabel();
        jLbl_Sec3Number = new javax.swing.JLabel();
        jLbl_Sec3DateIcon = new javax.swing.JLabel();
        jLbl_Sec3Date = new javax.swing.JLabel();
        jLbl_GoToGradingOfSec3 = new javax.swing.JLabel();
        jLbl_InformationalMsg = new javax.swing.JLabel();
        jLbl_GoToGradingOfSec1 = new javax.swing.JLabel();
        jLbl_Sec1StudentsNumIcon = new javax.swing.JLabel();
        jLbl_Sec1StudentsNum = new javax.swing.JLabel();
        jLbl_Sec2StudentsNumIcon = new javax.swing.JLabel();
        jLbl_Sec2StudentsNum = new javax.swing.JLabel();
        jLbl_Sec3StudentsNumIcon = new javax.swing.JLabel();
        jLbl_Sec3StudentsNum = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(830, 384));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 252, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbl_GradeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GradeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/GradesIcon.png"))); // NOI18N
        jPanel1.add(jLbl_GradeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jLbl_Header.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLbl_Header.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Header.setText("Grading System");
        jPanel1.add(jLbl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 8, 420, 60));

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
        jPanel1.add(jLbl_returnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, 40));

        jLbl_UpBar.setBackground(new java.awt.Color(38, 50, 54));
        jLbl_UpBar.setOpaque(true);
        jPanel1.add(jLbl_UpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 70));

        jLbl_Sec1NumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec1NumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec1NumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/number1.png"))); // NOI18N
        jLbl_Sec1NumIcon.setText("Section Number:");
        jPanel1.add(jLbl_Sec1NumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 40));

        jLbl_Sec1Number.setText("1192423");
        jPanel1.add(jLbl_Sec1Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, 20));

        jLbl_Sec1DateIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec1DateIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec1DateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec1DateIcon.setText("Date:");
        jPanel1.add(jLbl_Sec1DateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 70, -1));

        jLbl_Sec1Date.setText("16/2/2001");
        jPanel1.add(jLbl_Sec1Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 272, 120, 20));

        jLbl_Sec2NumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec2NumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec2NumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/number2.png"))); // NOI18N
        jLbl_Sec2NumIcon.setText("Section Number:");
        jPanel1.add(jLbl_Sec2NumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 130, 40));

        jLbl_Sec2Number.setText("1192423");
        jPanel1.add(jLbl_Sec2Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 80, 20));

        jLbl_Sec2DateIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec2DateIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec2DateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec2DateIcon.setText("Date:");
        jPanel1.add(jLbl_Sec2DateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 70, -1));

        jLbl_Sec2Date.setText("16/2/2001");
        jPanel1.add(jLbl_Sec2Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 272, 120, 20));

        jLbl_GoToGradingOfSec2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLbl_GoToGradingOfSec2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec2.setText("Go To Grading");
        jLbl_GoToGradingOfSec2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_GoToGradingOfSec2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec2MouseExited(evt);
            }
        });
        jPanel1.add(jLbl_GoToGradingOfSec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 200, 30));

        jLbl_Sec3NumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec3NumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec3NumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/number3.png"))); // NOI18N
        jLbl_Sec3NumIcon.setText("Section Number:");
        jPanel1.add(jLbl_Sec3NumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 130, 40));

        jLbl_Sec3Number.setText("1192423");
        jPanel1.add(jLbl_Sec3Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 160, 80, 20));

        jLbl_Sec3DateIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec3DateIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec3DateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec3DateIcon.setText("Date:");
        jPanel1.add(jLbl_Sec3DateIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 70, -1));

        jLbl_Sec3Date.setText("16/2/2001");
        jPanel1.add(jLbl_Sec3Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 272, 120, 20));

        jLbl_GoToGradingOfSec3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLbl_GoToGradingOfSec3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec3.setText("Go To Grading");
        jLbl_GoToGradingOfSec3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_GoToGradingOfSec3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec3MouseExited(evt);
            }
        });
        jPanel1.add(jLbl_GoToGradingOfSec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 200, 30));

        jLbl_InformationalMsg.setBackground(new java.awt.Color(78, 111, 207));
        jLbl_InformationalMsg.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLbl_InformationalMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_InformationalMsg.setText("        These are the sections you are teaching this semester for this course.");
        jLbl_InformationalMsg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_InformationalMsg.setOpaque(true);
        jPanel1.add(jLbl_InformationalMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 830, 50));

        jLbl_GoToGradingOfSec1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLbl_GoToGradingOfSec1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec1.setText("Go To Grading");
        jLbl_GoToGradingOfSec1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_GoToGradingOfSec1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_GoToGradingOfSec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_GoToGradingOfSec1MouseExited(evt);
            }
        });
        jPanel1.add(jLbl_GoToGradingOfSec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 200, 30));

        jLbl_Sec1StudentsNumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec1StudentsNumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec1StudentsNumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec1StudentsNumIcon.setText("Number Of Students:");
        jPanel1.add(jLbl_Sec1StudentsNumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 160, -1));

        jLbl_Sec1StudentsNum.setText("100");
        jPanel1.add(jLbl_Sec1StudentsNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 212, 60, 20));

        jLbl_Sec2StudentsNumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec2StudentsNumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec2StudentsNumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec2StudentsNumIcon.setText("Number Of Students:");
        jPanel1.add(jLbl_Sec2StudentsNumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 160, -1));

        jLbl_Sec2StudentsNum.setText("100");
        jPanel1.add(jLbl_Sec2StudentsNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 212, 60, 20));

        jLbl_Sec3StudentsNumIcon.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLbl_Sec3StudentsNumIcon.setForeground(new java.awt.Color(78, 111, 207));
        jLbl_Sec3StudentsNumIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/Date.png"))); // NOI18N
        jLbl_Sec3StudentsNumIcon.setText("Number Of Students:");
        jPanel1.add(jLbl_Sec3StudentsNumIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 160, -1));

        jLbl_Sec3StudentsNum.setText("100");
        jPanel1.add(jLbl_Sec3StudentsNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 212, 60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLbl_returnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseExited
        scaleimage__replaceButton(jLbl_returnBack, "src\\photo\\botton\\OrangeExit.png");
    }//GEN-LAST:event_jLbl_returnBackMouseExited

    private void jLbl_returnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseEntered
        scaleimage__backcwhite(jLbl_returnBack, "src\\photo\\botton\\rel_exit.png");
    }//GEN-LAST:event_jLbl_returnBackMouseEntered

    private void jLbl_returnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseClicked
        //You must determine the number of courses again for this TA to display the home
        //page again when we click on return back, new home2_for_teacher(numOfCourses)
        //.setVisible(true); or you could make a reference to the courses
        //page of this prof and use it each time. Feel free to do what you need!
        //this.setVisible(false);
        dispose();
        new home_for_teacher().setVisible(true);
    }//GEN-LAST:event_jLbl_returnBackMouseClicked

    private void jLbl_GoToGradingOfSec1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec1MouseClicked
        // TODO add your handling code here:
        //Once this button is clicked, a CourseGradesTA filled
        //with the selected section information will be displayed.
        sel_sec = Integer.valueOf(jLbl_Sec1Number.getText());
        new CourseGradesProf().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLbl_GoToGradingOfSec1MouseClicked

    private void jLbl_GoToGradingOfSec1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec1MouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_GoToGradingOfSec1, "src\\photo\\white.png");
        jLbl_GoToGradingOfSec1.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_GoToGradingOfSec1MouseEntered

    private void jLbl_GoToGradingOfSec1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec1MouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove(jLbl_GoToGradingOfSec1);
        jLbl_GoToGradingOfSec1.setForeground(Color.black);
    }//GEN-LAST:event_jLbl_GoToGradingOfSec1MouseExited

    private void jLbl_GoToGradingOfSec2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec2MouseClicked
        // TODO add your handling code here:
        //Once this button is clicked, a CourseGradesTA filled
        //with the selected section information will be displayed.
        sel_sec = Integer.valueOf(jLbl_Sec2Number.getText());
        new CourseGradesProf().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLbl_GoToGradingOfSec2MouseClicked

    private void jLbl_GoToGradingOfSec2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec2MouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_GoToGradingOfSec2, "src\\photo\\white.png");
        jLbl_GoToGradingOfSec2.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_GoToGradingOfSec2MouseEntered

    private void jLbl_GoToGradingOfSec2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec2MouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove(jLbl_GoToGradingOfSec2);
        jLbl_GoToGradingOfSec2.setForeground(Color.black);
    }//GEN-LAST:event_jLbl_GoToGradingOfSec2MouseExited

    private void jLbl_GoToGradingOfSec3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec3MouseClicked
        // TODO add your handling code here:
        //Once this button is clicked, a CourseGradesTA filled
        //with the selected section information will be displayed.
        sel_sec = Integer.valueOf(jLbl_Sec3Number.getText());
        new CourseGradesProf().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLbl_GoToGradingOfSec3MouseClicked

    private void jLbl_GoToGradingOfSec3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec3MouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_GoToGradingOfSec3, "src\\photo\\white.png");
        jLbl_GoToGradingOfSec3.setForeground(new Color(98, 168, 243));
    }//GEN-LAST:event_jLbl_GoToGradingOfSec3MouseEntered

    private void jLbl_GoToGradingOfSec3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GoToGradingOfSec3MouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove(jLbl_GoToGradingOfSec3);
        jLbl_GoToGradingOfSec3.setForeground(Color.black);
    }//GEN-LAST:event_jLbl_GoToGradingOfSec3MouseExited

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
                try {
                    new TACourseSections(3).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TACourseSections.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbl_GoToGradingOfSec1;
    private javax.swing.JLabel jLbl_GoToGradingOfSec2;
    private javax.swing.JLabel jLbl_GoToGradingOfSec3;
    private javax.swing.JLabel jLbl_GradeIcon;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_InformationalMsg;
    private javax.swing.JLabel jLbl_Sec1Date;
    private javax.swing.JLabel jLbl_Sec1DateIcon;
    private javax.swing.JLabel jLbl_Sec1NumIcon;
    private javax.swing.JLabel jLbl_Sec1Number;
    private javax.swing.JLabel jLbl_Sec1StudentsNum;
    private javax.swing.JLabel jLbl_Sec1StudentsNumIcon;
    private javax.swing.JLabel jLbl_Sec2Date;
    private javax.swing.JLabel jLbl_Sec2DateIcon;
    private javax.swing.JLabel jLbl_Sec2NumIcon;
    private javax.swing.JLabel jLbl_Sec2Number;
    private javax.swing.JLabel jLbl_Sec2StudentsNum;
    private javax.swing.JLabel jLbl_Sec2StudentsNumIcon;
    private javax.swing.JLabel jLbl_Sec3Date;
    private javax.swing.JLabel jLbl_Sec3DateIcon;
    private javax.swing.JLabel jLbl_Sec3NumIcon;
    private javax.swing.JLabel jLbl_Sec3Number;
    private javax.swing.JLabel jLbl_Sec3StudentsNum;
    private javax.swing.JLabel jLbl_Sec3StudentsNumIcon;
    private javax.swing.JLabel jLbl_UpBar;
    private javax.swing.JLabel jLbl_returnBack;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
