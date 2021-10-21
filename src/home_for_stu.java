
import Tables.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
//import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;
import java.util.ArrayList;


public class home_for_stu extends javax.swing.JFrame {

    JLabel arr1[];// for Title 
    JLabel arr2[];// for profname and Asses
    JLabel arr3[];// for CourseId
    JLabel arr4[];// for Photo courses
    JLabel arr5[];// for Photo courses title

    static int count = 0;
    int id;
    
    public home_for_stu() {
        initComponents();
        int length;
        this.id=LogInInterface.id;
        
        try{
              user_name.setText(LogInInterface.name);
              // Mayar start
              // count for courses
              Connection con = new Unit().connectOracle();
              Statement s = con.createStatement();
              String count = "select  count(distinct courses.courseno)\n" +
                           "from courses,sections,students_sections,students\n" +
                           "where  students_sections.STUDENTID = "+id+"and students_sections.sectionno= sections.sectionno and " +
                          "sections.courseno=courses.courseno";
               ResultSet rs = s.executeQuery(count); 
               rs.next();
               length = rs.getInt(1);
                 con.close();
               // End
               fun(length);
                
                this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
               for5_courses.setVisible(false);
               for4_courses.setVisible(false);
               for6_courses.setVisible(false);
               for7_courses.setVisible(false);

               if (length == 4) {
               for4_courses.setVisible(true);
               for5_courses.setVisible(false);
               for6_courses.setVisible(false);
               for7_courses.setVisible(false);
               }
               if (length == 5) {
               for5_courses.setVisible(true);
               for4_courses.setVisible(false);
               for6_courses.setVisible(false);
               for7_courses.setVisible(false);
               }
               if (length == 6) {
               for6_courses.setVisible(true);
               for5_courses.setVisible(false);
               for4_courses.setVisible(false);
               for7_courses.setVisible(false);
                }
               if (length == 7) {
               for7_courses.setVisible(true);
               for5_courses.setVisible(false);
               for4_courses.setVisible(false);
               for6_courses.setVisible(false);
               }
                  //After Getting the name from database
            jLabel3.setText("<html>Your Personal Page <br/>Welcome <html>" + LogInInterface.name);


        //constractor
        scaleimage__logo("src\\photo\\user_.png", user_photo);
        scaleimage__logo("src\\photo\\prop_rel.png", properties);
        scaleimage__logo("src\\photo\\botton\\cross.png", properties1);
        scaleimage__logo("src\\photo\\botton\\min_rel.png", min_max);
        Setting_panel.setVisible(false);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
      
      
        

    }

    public void scaleimage_butt1() {

        ImageIcon icon = new ImageIcon("src\\photo\\white.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(change_pass.getWidth(), change_pass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        change_pass.setIcon(scaledIcon);

    }
 

    public void scaleimage__logo(String path, JLabel a) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        a.setIcon(scaledIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        properties1 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        basicbody = new javax.swing.JPanel();
        for7_courses = new javax.swing.JLabel();
        for5_courses = new javax.swing.JLabel();
        for6_courses = new javax.swing.JLabel();
        for4_courses = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        user_photo = new javax.swing.JLabel();
        min_max = new javax.swing.JLabel();
        properties = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Setting_panel = new javax.swing.JPanel();
        change_pass = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        properties1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                properties1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                properties1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                properties1MouseExited(evt);
            }
        });
        body.add(properties1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 30, 30));

        user_name.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));
        user_name.setText("   User Name for Student");
        body.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 270, 30));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicbodyLayout.createSequentialGroup()
                .addContainerGap(852, Short.MAX_VALUE)
                .addComponent(for4_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(for6_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(for5_courses)
                .addGap(40, 40, 40)
                .addComponent(for7_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        basicbodyLayout.setVerticalGroup(
            basicbodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicbodyLayout.createSequentialGroup()
                .addGap(645, 645, 645)
                .addGroup(basicbodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(for4_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for6_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for5_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(for7_courses, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(basicbody);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1040, 630));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1040, 720));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_photo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(user_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, 70));

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
        jPanel1.add(min_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 30, 30));

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
        jPanel1.add(properties, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 30, 30));

        jLabel2.setBackground(new java.awt.Color(98, 168, 243));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 90));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Your Personal Page ");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(98, 168, 234)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 240, 100));

        Setting_panel.setBackground(new java.awt.Color(38, 50, 54));

        change_pass.setBackground(new java.awt.Color(255, 255, 255));
        change_pass.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        change_pass.setForeground(new java.awt.Color(255, 255, 255));
        change_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_pass.setText("Change Password");
        change_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        change_pass.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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

        javax.swing.GroupLayout Setting_panelLayout = new javax.swing.GroupLayout(Setting_panel);
        Setting_panel.setLayout(Setting_panelLayout);
        Setting_panelLayout.setHorizontalGroup(
            Setting_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(change_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        Setting_panelLayout.setVerticalGroup(
            Setting_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Setting_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(change_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
        );

        jPanel1.add(Setting_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 240, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void propertiesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\prop_press.png", properties);
    }//GEN-LAST:event_propertiesMouseEntered

    private void propertiesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\prop_rel.png", properties);
    }//GEN-LAST:event_propertiesMouseExited

    private void properties1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_properties1MouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\press_exit.png", properties1);
    }//GEN-LAST:event_properties1MouseEntered

    private void properties1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_properties1MouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\cross.png", properties1);
    }//GEN-LAST:event_properties1MouseExited

    private void properties1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_properties1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_properties1MouseClicked

    private void min_maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_min_maxMouseClicked

    private void min_maxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\min_rel.png", min_max);
    }//GEN-LAST:event_min_maxMouseExited

    private void min_maxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_maxMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\botton\\min_press.png", min_max);
    }//GEN-LAST:event_min_maxMouseEntered

    private void change_passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseEntered
        change_pass.setForeground(new Color(0, 0, 0));
        scaleimage_butt1();

    }//GEN-LAST:event_change_passMouseEntered

    private void change_passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseExited

        change_pass.setForeground(new Color(255, 255, 255));
        change_pass.setIcon(null);
    }//GEN-LAST:event_change_passMouseExited

    private void propertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMouseClicked
        // TODO add your handling code here:
        count++;
        if (count == 1) {
            Setting_panel.setVisible(true);
        }
        if (count == 2) {
            Setting_panel.setVisible(false);
            count = 0;
        }

    }//GEN-LAST:event_propertiesMouseClicked

    private void change_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_passMouseClicked
        // TODO add your handling code here:
        dispose();
        new Reset_pass().setVisible(true);
        //~J
        
    }//GEN-LAST:event_change_passMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });

    }

    public void fun(int ln) {
        // iwill assume that the data base base is ready and i have 4 courses for this student 
        // now iwill generate the label i want 
        int lenth = ln;
        Border border = BorderFactory.createLineBorder(new Color(255, 204, 51));
        arr1 = new JLabel[lenth];
        arr2 = new JLabel[lenth];
        arr3 = new JLabel[lenth];
        arr4 = new JLabel[lenth];
        arr5 = new JLabel[lenth];
        // initial values we will start with
        for (int i = 0; i < lenth; i++) {
            arr1[i] = new JLabel();
            arr2[i] = new JLabel();
            arr3[i] = new JLabel();
            arr4[i] = new JLabel();
            arr5[i] = new JLabel("", JLabel.CENTER);
        }
        JLabel size = new JLabel();
        size.setLocation(720, 90);
        size.setSize(1, lenth * 204);
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
        
        try {
              Connection con = new Unit().connectOracle();
               Statement s = con.createStatement();
            String query = "select distinct courses.coursename,courses.courseno,courses.image,teachers.teachername,teachers.tmode\n" +
                           "from courses,sections,students_sections,students,teachers_sections,teachers \n" +
                           "where  students_sections.STUDENTID = "+id+" and students_sections.sectionno=sections.sectionno and sections.courseno=courses.courseno\n" +
                           "and sections.sectionno=teachers_sections.sectionno and teachers_sections.teacherid=teachers.teacherid";
            ResultSet rs = s.executeQuery(query);
         
            
          
            
        ArrayList<Integer>cNum = new ArrayList<Integer>();
        ArrayList<String> ta = new ArrayList<String>();
        int i=-1;
        while(rs.next()) {
             
              if(rs == null)break;
             System.out.print(rs.getString("Tmode"));
              if (rs.getString("Tmode").equals("TA"))
              {
                  cNum.add(rs.getInt("COURSENO"));
                  ta.add(rs.getString("TEACHERNAME"));
              }
              else 
              {
                   i++;
            arr1[i].setLocation(hight_title, width_title);
            arr1[i].setSize(title_Height_size, title_width_size);
            arr2[i].setLocation(hight_teacher, width_tacher);
            arr2[i].setSize(teacher_Height_size, teacher_width_size);
            arr3[i].setLocation(hight_courseID, width_courseID);
            arr3[i].setSize(courseID_Height_size, courseID_width_size);
            arr4[i].setLocation(hight_photo, width_photo);
            arr4[i].setSize(photo_width_size, photo_Height_size);
            arr5[i].setLocation(hight_photo_dec, width_photo_dec);
            arr5[i].setSize(photo_dec_width_size, photo_dec_Height_size);
            //incremanting
            width_title += 180;
            width_tacher += 180;
            width_courseID += 180;
            width_photo += 180;
            width_photo_dec += 180;
            
            // start Mayar
            // Title 
             arr1[i].setText(rs.getString("coursename"));
            // Course id
            arr2[i].setText(rs.getString("COURSENO"));
            // Name of the prof
            arr3[i].setText(rs.getString("TEACHERNAME"));
            // course image
            arr4[i].setIcon(new ImageIcon(rs.getString("image")));
            // course name
            arr5[i].setText(rs.getString("coursename"));
            // end code Mayar
            
            arr1[i].setForeground(new Color(177, 67, 77));
            arr5[i].setForeground(new Color(177, 67, 77));        
            arr1[i].setVisible(true);
            arr2[i].setVisible(true);
            arr3[i].setVisible(true);
            arr1[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
            arr2[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
            arr3[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
            arr2[i].setForeground(new Color(152, 152, 152));
            arr3[i].setForeground(new Color(102, 102, 102));
            //arr4[i].setBackground(Color.red);
            // arr5[i].setBorder(border);
            arr5[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
            arr5[i].setHorizontalTextPosition(JLabel.CENTER);
            arr4[i].setOpaque(true);
            arr5[i].setOpaque(true);
            arr5[i].setBackground(new Color(230, 235, 237));

            this.basicbody.add(arr1[i]);
            this.basicbody.add(arr2[i]);
            this.basicbody.add(arr3[i]);
            this.basicbody.add(arr4[i]);
            this.basicbody.add(arr5[i]);

        }
        }
        
         System.out.print(cNum);
        System.out.print(ta);
        int inc =0;
        for (int j=0;j<lenth;j++){
            int id = Integer.parseInt(arr2[j].getText());
            for(Integer temp:cNum)
                if(id==temp){
                    arr3[j].setText("<html>"+arr3[j].getText()+"<br/>"+ta.get(inc)+"<html>");
                    inc++;
                }
        }
          con.close();
          }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Setting_panel;
    private javax.swing.JPanel basicbody;
    private javax.swing.JPanel body;
    private javax.swing.JLabel change_pass;
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
    private javax.swing.JLabel min_max;
    private javax.swing.JLabel properties;
    private javax.swing.JLabel properties1;
    private javax.swing.JLabel user_name;
    private javax.swing.JLabel user_photo;
    // End of variables declaration//GEN-END:variables
}
