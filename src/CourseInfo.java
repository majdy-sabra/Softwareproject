
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Legion
 */
public class CourseInfo extends javax.swing.JFrame {

    /**
     * Creates new form CourseInfo
     */
    String tit="";
    public CourseInfo() {
       initComponents();

    }
    public CourseInfo (String head){
        initComponents();
        tit= head;
        title.setText(tit);
        scaleimage__logo("src\\photo\\backforcousesInfo.jpg", back); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        second = new javax.swing.JButton();
        First = new javax.swing.JButton();
        Final = new javax.swing.JButton();
        Assignment = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Couse Name");
        title.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 7, 0, new java.awt.Color(248, 147, 29)));
        title.setOpaque(true);
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 74));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText(" Waht to Do ?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        second.setBackground(new java.awt.Color(255, 255, 255));
        second.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        second.setText("second");
        second.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondActionPerformed(evt);
            }
        });
        getContentPane().add(second, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 230, 40));

        First.setBackground(new java.awt.Color(255, 255, 255));
        First.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        First.setText("First");
        First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstActionPerformed(evt);
            }
        });
        getContentPane().add(First, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 230, 40));

        Final.setBackground(new java.awt.Color(255, 255, 255));
        Final.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Final.setText("Final");
        Final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalActionPerformed(evt);
            }
        });
        getContentPane().add(Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 230, 40));

        Assignment.setBackground(new java.awt.Color(255, 255, 255));
        Assignment.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Assignment.setText("Assignment");
        Assignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignmentActionPerformed(evt);
            }
        });
        getContentPane().add(Assignment, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 230, 40));

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        back.setOpaque(true);
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 720, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignmentActionPerformed
        // TODO add your handling code here:
        //creating assignment interface
        assignment_student tmp = new assignment_student();
        tmp.setVisible(true);
    }//GEN-LAST:event_AssignmentActionPerformed

    private void FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstActionPerformed
        // TODO add your handling code here:
        Firstframe ob = new Firstframe();
        ob.setVisible(true);
        
    }//GEN-LAST:event_FirstActionPerformed

    private void secondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondActionPerformed
        // TODO add your handling code here:
       secondframe x = new secondframe();
       x.setVisible(true);
    }//GEN-LAST:event_secondActionPerformed

    private void FinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalActionPerformed
        // TODO add your handling code here:
        finalframe y = new finalframe();
        y.setVisible(true);
    }//GEN-LAST:event_FinalActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    //
     public void scaleimage__logo(String path , JLabel a){
        ImageIcon icon = new ImageIcon (path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        a.setIcon(scaledIcon);
    }
     
     
     
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
            java.util.logging.Logger.getLogger(CourseInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assignment;
    private javax.swing.JButton Final;
    private javax.swing.JButton First;
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton second;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}