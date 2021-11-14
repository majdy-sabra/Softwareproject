
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
/*
        try {
        JFileChooser x = new JFileChooser();
        int responce = x.showOpenDialog(null);
        
        if (responce == JFileChooser.APPROVE_OPTION){
            File file = new File(x.getSelectedFile().getAbsolutePath());
            //Desktop.getDesktop().open(file);
            System.out.println(file);
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }

*/
public class assignment_student extends javax.swing.JFrame {

    /**
     * Creates new form assignment_student
     */
    public assignment_student() {
        initComponents();
        scaleimage__logo("src\\upload.png" , up1);
        scaleimage__logo("src\\upload.png" , up2);
        scaleimage__logo("src\\background.jpg" , background);
        scaleimage__logo("src\\exit.png" , exit);
        
    }

    
       public void scaleimage__logo(String path , JLabel a){
        ImageIcon icon = new ImageIcon (path);
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        a.setIcon(scaledIcon);
    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        up1 = new javax.swing.JLabel();
        up2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assingment");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 40, 50));

        jLabel1.setBackground(new java.awt.Color(248, 147, 29));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assignment");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 50));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Assignemt 2");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(239, 122, 52)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 560, 50));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Assignemt 1");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(239, 122, 52)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 560, 50));

        up1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                up1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                up1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                up1MouseExited(evt);
            }
        });
        getContentPane().add(up1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, 60, 50));

        up2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                up2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                up2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                up2MouseExited(evt);
            }
        });
        getContentPane().add(up2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 60, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Save");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 643, 250, 50));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\exit.png" , exit);
         scaleimage__logo("src\\photo\\exit.png" , exit);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\exit.png" , exit);
    }//GEN-LAST:event_exitMouseExited

    private void up1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up1MouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\imgup.png" , up1);
    }//GEN-LAST:event_up1MouseEntered

    private void up1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up1MouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\upload.png" , up1);
    }//GEN-LAST:event_up1MouseExited

    private void up2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up2MouseEntered
        // TODO add your handling code here:
        scaleimage__logo("src\\photo\\imgup.png" , up2);
    }//GEN-LAST:event_up2MouseEntered

    private void up2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up2MouseExited
        // TODO add your handling code here:
        scaleimage__logo("src\\upload.png" , up2);
    }//GEN-LAST:event_up2MouseExited

    private void up1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up1MouseClicked
        // TODO add your handling code here:
        
         try {
        JFileChooser x = new JFileChooser();
        int responce = x.showOpenDialog(null);
        
        if (responce == JFileChooser.APPROVE_OPTION){
            File file = new File(x.getSelectedFile().getAbsolutePath());
            //Desktop.getDesktop().open(file);
            //System.out.println(file);
            jLabel2.setText(file.toString());
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
         
         
    }//GEN-LAST:event_up1MouseClicked

    private void up2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up2MouseClicked
        // TODO add your handling code here:
           try {
        JFileChooser x = new JFileChooser();
        int responce = x.showOpenDialog(null);
        
        if (responce == JFileChooser.APPROVE_OPTION){
            File file = new File(x.getSelectedFile().getAbsolutePath());
            //Desktop.getDesktop().open(file);
            //System.out.println(file);
            jLabel3.setText(file.toString());
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_up2MouseClicked

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
            java.util.logging.Logger.getLogger(assignment_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assignment_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assignment_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assignment_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assignment_student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel up1;
    private javax.swing.JLabel up2;
    // End of variables declaration//GEN-END:variables
}
