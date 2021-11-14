/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import database.Students;
import database.Teachers;
import java.awt.Image;
import java.math.BigDecimal;
import java.util.List;
/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;*/
import javax.swing.ImageIcon;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



public class Reset_pass extends javax.swing.JFrame {

    boolean allow = false;
    public Reset_pass(){
         initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass_2 = new javax.swing.JTextField();
        pass_1 = new javax.swing.JTextField();
        pass_re = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pass_2_checker = new javax.swing.JLabel();
        Pass_1_checker = new javax.swing.JLabel();
        Gif_pass_back = new javax.swing.JLabel();
        Pass_back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reset Password");
        setMinimumSize(new java.awt.Dimension(700, 700));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pass_2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(pass_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 300, 30));

        pass_1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(pass_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 300, 30));

        pass_re.setBackground(new java.awt.Color(153, 255, 102));
        pass_re.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        pass_re.setText("Reset Password");
        pass_re.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass_reMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pass_reMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pass_reMouseExited(evt);
            }
        });
        pass_re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_reActionPerformed(evt);
            }
        });
        getContentPane().add(pass_re, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 140, 40));

        exit.setBackground(new java.awt.Color(255, 102, 102));
        exit.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        exit.setText("Undo");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 140, 40));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Enter Your new Password :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 180, 30));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Conform Password :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 140, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Create a New Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 410, 40));
        getContentPane().add(Pass_2_checker, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 30, 30));
        getContentPane().add(Pass_1_checker, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 30, 30));

        Gif_pass_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resetpass/gif_pass.gif"))); // NOI18N
        getContentPane().add(Gif_pass_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 350, 650, 410));

        Pass_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resetpass/back_.jpg"))); // NOI18N
        getContentPane().add(Pass_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 700));

        setSize(new java.awt.Dimension(700, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pass_reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_reActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_pass_reActionPerformed
 
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         ImageIcon icon = new ImageIcon ("src\\resetpass\\icons8_lock_database_50px_1.png");
        setIconImage(icon.getImage());
        
    }//GEN-LAST:event_formWindowActivated

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void pass_reMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_reMouseEntered
        // TODO add your handling code here:
       // System.out.print(Password_new);
        if(pass_1.getText().equals(pass_2.getText()) && !pass_1.getText().isEmpty() && 
                !pass_2.getText().isEmpty() &&pass_1.getText().length()>=6&&pass_2.getText().length()>=6){
        this.Pass_1_checker.setVisible(true);
        this.Pass_2_checker.setVisible(true);
        this.Pass_2_checker.setIcon(new ImageIcon ("src\\resetpass\\true.png"));
        this.Pass_1_checker.setIcon(new ImageIcon ("src\\resetpass\\true.png"));
        }
        else{
        this.Pass_1_checker.setVisible(true);
        this.Pass_2_checker.setVisible(true);
        this.Pass_2_checker.setIcon(new ImageIcon ("src\\resetpass\\fal.png"));
         if(pass_1.getText().length()>=6){
         this.Pass_1_checker.setIcon(new ImageIcon ("src\\resetpass\\true.png"));}
         else{
         this.Pass_1_checker.setIcon(new ImageIcon ("src\\resetpass\\fal.png"));
         }
        }
        
    }//GEN-LAST:event_pass_reMouseEntered

    
    
    
    
    private void pass_reMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_reMouseExited
        // TODO add your handling code here:
        
        this.Pass_1_checker.setVisible(false);
        this.Pass_2_checker.setVisible(false);
    }//GEN-LAST:event_pass_reMouseExited

    private void pass_reMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_reMouseClicked
        // TODO add your handling code here:
        //~J 
        if(allow){ //if entered password is approved
            if (LogInInterface.role.equals("stu")) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Students s = em.find(Students.class, BigDecimal.valueOf(LogInInterface.id));
                s.setStudentpassword(pass_1.getText().trim());
                em.getTransaction().commit();
                em.close();
            } //change password for student
            else {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Teachers t = em.find(Teachers.class, BigDecimal.valueOf(LogInInterface.id));
                t.setTeacherpassword(pass_1.getText().trim());
                em.getTransaction().commit();
                em.close();
            } //change password for teachers(p&t)
            this.dispose();
            // StudentDetailsInterface a = new StudentDetailsInterface();
            //a.setVisible(true);
        }
        else{
                    JOptionPane.showMessageDialog(null,"Task Failed!\n*Your new password must be at least 6 characters\n*Both fields must match\n*No spaces allowed\nTry Again!","Information",JOptionPane.INFORMATION_MESSAGE);
                    //entered password not accepted
        
        }
        
        
        //~J
    }//GEN-LAST:event_pass_reMouseClicked


    
    
    
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
            java.util.logging.Logger.getLogger(Reset_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset_pass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gif_pass_back;
    private javax.swing.JLabel Pass_1_checker;
    private javax.swing.JLabel Pass_2_checker;
    private javax.swing.JLabel Pass_back;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField pass_1;
    private javax.swing.JTextField pass_2;
    private javax.swing.JButton pass_re;
    // End of variables declaration//GEN-END:variables
        }
