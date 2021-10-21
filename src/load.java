
import javax.swing.ImageIcon;


public class load extends javax.swing.JFrame {

  
    public load() {
        initComponents();
        jLabel1.setText("<html>Detail's matter, it's worth waiting to get it right!</html>");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadbar = new javax.swing.JProgressBar();
        value = new javax.swing.JLabel();
        mass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backgif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loading...");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadbar.setForeground(new java.awt.Color(0, 255, 0));
        getContentPane().add(loadbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 540, 15));

        value.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        value.setForeground(new java.awt.Color(255, 255, 255));
        value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        value.setText("0%");
        getContentPane().add(value, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, 40, -1));

        mass.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        mass.setForeground(new java.awt.Color(255, 255, 255));
        mass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mass.setText("Hang on...");
        getContentPane().add(mass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 290, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 530, 50));

        backgif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loading.gif"))); // NOI18N
        getContentPane().add(backgif, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 661));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src\\icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new load().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgif;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JProgressBar loadbar;
    public javax.swing.JLabel mass;
    public javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
