

import database.Grades;
import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import database.*;
import java.math.BigInteger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class GradeSpecifications extends javax.swing.JFrame {

    /**
     * Creates new form GradeSpecifications
     */
    public GradeSpecifications() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
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
    public void scaleimage__backc_white_remove() {
        ImageIcon icon = new ImageIcon("");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Confirm.getWidth(), this.jLbl_Confirm.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Confirm.setIcon(scaledIcon);
    }
    
    //Function to replace the button with another one with a different color.   
    public void scaleimage__replaceButton() {
        ImageIcon icon = new ImageIcon("src\\photo\\botton\\OrangeExit.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(jLbl_returnBack.getWidth(), jLbl_returnBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_returnBack.setIcon(scaledIcon);
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
        jLabel2 = new javax.swing.JLabel();
        jLbl_Header = new javax.swing.JLabel();
        jLbl_returnBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxt_First = new javax.swing.JTextField();
        jTxt_Second = new javax.swing.JTextField();
        jTxt_Final = new javax.swing.JTextField();
        jTxt_assignment2 = new javax.swing.JTextField();
        jTxt_assignment1 = new javax.swing.JTextField();
        jLbl_Confirm = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 252, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprint#3Images/GradesIcon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jLbl_Header.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLbl_Header.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Header.setText("Grade Specifications");
        jPanel1.add(jLbl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 8, 350, 60));

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
        jPanel1.add(jLbl_returnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, 40));

        jLabel1.setBackground(new java.awt.Color(38, 50, 54));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 70));

        jTxt_First.setBackground(new Color(255, 255, 255, 0));
        jTxt_First.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_First.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_First.setText("Type the first exam weight");
        jTxt_First.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_First.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_FirstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_FirstFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 40));

        jTxt_Second.setBackground(new Color(255, 255, 255, 0));
        jTxt_Second.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_Second.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_Second.setText("Type the second exam weight");
        jTxt_Second.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_Second.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_SecondFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_SecondFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_Second, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 200, 40));

        jTxt_Final.setBackground(new Color(255, 255, 255, 0));
        jTxt_Final.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_Final.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_Final.setText("Type the final exam weight");
        jTxt_Final.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_Final.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_FinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_FinalFocusLost(evt);
            }
        });
        jPanel1.add(jTxt_Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 40));

        jTxt_assignment2.setBackground(new Color(255, 255, 255, 0));
        jTxt_assignment2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_assignment2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_assignment2.setText("Type assignment 2 weight");
        jTxt_assignment2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_assignment2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_assignment2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_assignment2FocusLost(evt);
            }
        });
        jPanel1.add(jTxt_assignment2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 200, 40));

        jTxt_assignment1.setBackground(new Color(255, 255, 255, 0));
        jTxt_assignment1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_assignment1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_assignment1.setText("Type assignment 1 weight");
        jTxt_assignment1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jTxt_assignment1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxt_assignment1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_assignment1FocusLost(evt);
            }
        });
        jPanel1.add(jTxt_assignment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 200, 40));

        jLbl_Confirm.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_Confirm.setForeground(new java.awt.Color(0, 0, 0));
        jLbl_Confirm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Confirm.setText("Confirm");
        jLbl_Confirm.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(98, 168, 243)));
        jLbl_Confirm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_ConfirmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_ConfirmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_ConfirmMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 180, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_FirstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_FirstFocusGained
        // TODO add your handling code here:
        if(jTxt_First.getText().equals("Type the first exam weight")) {
            jTxt_First.setText("");
        }
    }//GEN-LAST:event_jTxt_FirstFocusGained

    private void jTxt_FirstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_FirstFocusLost
        // TODO add your handling code here:
        if(jTxt_First.getText().equals("")) {
            jTxt_First.setText("Type the first exam weight");
        }
    }//GEN-LAST:event_jTxt_FirstFocusLost

    private void jTxt_SecondFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_SecondFocusGained
        // TODO add your handling code here:
        if(jTxt_Second.getText().equals("Type the second exam weight")) {
            jTxt_Second.setText("");
        }
    }//GEN-LAST:event_jTxt_SecondFocusGained

    private void jTxt_SecondFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_SecondFocusLost
        // TODO add your handling code here:
        if(jTxt_Second.getText().equals("")) {
            jTxt_Second.setText("Type the second exam weight");
        }
    }//GEN-LAST:event_jTxt_SecondFocusLost

    private void jTxt_FinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_FinalFocusGained
        // TODO add your handling code here:
        if(jTxt_Final.getText().equals("Type the final exam weight")) {
            jTxt_Final.setText("");
        }
    }//GEN-LAST:event_jTxt_FinalFocusGained

    private void jTxt_FinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_FinalFocusLost
        // TODO add your handling code here:
        if(jTxt_Final.getText().equals("")) {
            jTxt_Final.setText("Type the final exam weight");
        }
    }//GEN-LAST:event_jTxt_FinalFocusLost

    private void jTxt_assignment2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_assignment2FocusGained
        // TODO add your handling code here:
        if(jTxt_assignment2.getText().equals("Type assignment 2 weight")) {
            jTxt_assignment2.setText("");
        }
    }//GEN-LAST:event_jTxt_assignment2FocusGained

    private void jTxt_assignment2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_assignment2FocusLost
        // TODO add your handling code here:
        if(jTxt_assignment2.getText().equals("")) {
            jTxt_assignment2.setText("Type assignment 2 weight");
        }
    }//GEN-LAST:event_jTxt_assignment2FocusLost

    private void jTxt_assignment1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_assignment1FocusGained
        // TODO add your handling code here:
        if(jTxt_assignment1.getText().equals("Type assignment 1 weight")) {
            jTxt_assignment1.setText("");
        }
    }//GEN-LAST:event_jTxt_assignment1FocusGained

    private void jTxt_assignment1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_assignment1FocusLost
        // TODO add your handling code here:
        if(jTxt_assignment1.getText().equals("")) {
            jTxt_assignment1.setText("Type assignment 1 weight");
        }
    }//GEN-LAST:event_jTxt_assignment1FocusLost

    private void jLbl_ConfirmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ConfirmMouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_Confirm, "src\\photo\\white.png");
        jLbl_Confirm.setForeground(new Color(98,168,243));


    }//GEN-LAST:event_jLbl_ConfirmMouseEntered

    private void jLbl_ConfirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ConfirmMouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove();
        jLbl_Confirm.setForeground(Color.black);

    }//GEN-LAST:event_jLbl_ConfirmMouseExited

    private void jLbl_returnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite(jLbl_returnBack, "src\\photo\\botton\\rel_exit.png");
    }//GEN-LAST:event_jLbl_returnBackMouseEntered

    private void jLbl_returnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseExited
        // TODO add your handling code here:
        scaleimage__replaceButton();
    }//GEN-LAST:event_jLbl_returnBackMouseExited

    private void jLbl_ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ConfirmMouseClicked
        // TODO add your handling code here:
        //~J
        if(jTxt_First.getText().isEmpty() || jTxt_Second.getText().isEmpty() || jTxt_Final.getText().isEmpty() || jTxt_assignment1.getText().isEmpty() || jTxt_assignment2.getText().isEmpty()){
            callTimer(new WarningNotification("Make sure to fill all fields!"));
            return;
        }
        if(!(jTxt_First.getText().chars().allMatch( Character::isDigit ) && jTxt_Second.getText().chars().allMatch( Character::isDigit ) && jTxt_Final.getText().chars().allMatch( Character::isDigit ) && jTxt_assignment1.getText().chars().allMatch( Character::isDigit )&& jTxt_assignment2.getText().chars().allMatch( Character::isDigit )))
        {
            callTimer(new WarningNotification("Insert numbers only!"));
            return;
            
        }
        if(Integer.valueOf(jTxt_First.getText()) + Integer.valueOf(jTxt_Second.getText()) +Integer.valueOf(jTxt_Final.getText())+Integer.valueOf(jTxt_assignment1.getText())+Integer.valueOf(jTxt_assignment2.getText()) != 100){
            callTimer(new WarningNotification("The sum must equal 100!"));
            return;
        
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Courses course_to_edit = em.find(Courses.class, BigDecimal.valueOf(ProfessorCourseSections.course_no));
        
        course_to_edit.setFirstweight(BigInteger.valueOf(Integer.valueOf(jTxt_First.getText())));
        course_to_edit.setSecondweight(BigInteger.valueOf(Integer.valueOf(jTxt_Second.getText())));
        course_to_edit.setFinalweight(BigInteger.valueOf(Integer.valueOf(jTxt_Final.getText())));
        course_to_edit.setAssignment1weight(BigInteger.valueOf(Integer.valueOf(jTxt_assignment1.getText())));
        course_to_edit.setAssignment2weight(BigInteger.valueOf(Integer.valueOf(jTxt_assignment2.getText())));
        
        em.getTransaction().commit();
        em.close();
        callTimer(new SuccessNotification("Changes confirmed!"));
        new ProfessorCourseSections().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLbl_ConfirmMouseClicked

    private void jLbl_returnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_returnBackMouseClicked
        try {
            // TODO add your handling code here:
            //You must determine the number of sections again for this Prof. to display the sections
            //page again when we click on return back, new ProfessorCourseSections(numOfSections)
            //.setVisible(true); or you could make a reference to the sections
            //page of this prof and use it each time. Feel free to do what you need!
            //this.setVisible(false);
            new ProfessorCourseSections(ProfessorCourseSections.secs.size()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GradeSpecifications.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jLbl_returnBackMouseClicked

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
            java.util.logging.Logger.getLogger(GradeSpecifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeSpecifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeSpecifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeSpecifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeSpecifications().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbl_Confirm;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_returnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxt_Final;
    private javax.swing.JTextField jTxt_First;
    private javax.swing.JTextField jTxt_Second;
    private javax.swing.JTextField jTxt_assignment1;
    private javax.swing.JTextField jTxt_assignment2;
    // End of variables declaration//GEN-END:variables
}
