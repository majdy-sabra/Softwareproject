
import database.Students;
import database.Teachers;
import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class thr extends Thread {

    public void run() {
   
      try
     {
        NewClass c= new NewClass ();
        c.fun();
  
     }
     catch(Exception e)
     {
        System.out.println("my thread interrupted");
     }
    }

}
public class LogInInterface extends javax.swing.JFrame {

    /**
     * Creates new form LogInInterface
     */
     static int count = 0;
     // specify the roles for every user
    // s -> student , p -> professor , t -> Ta
    public static String role ;
    // srore the id for the user
    public static int id;
    // name for the user
    public static String name;
    public LogInInterface() {
        initComponents();
        scaleimage__backrel();
       scaleimage__pass();
       scaleimage__user();
       scaleimage__unvis();
       scaleimage__login();
       scaleimage__logo();
    }
    
    
    
    
    //jLbl_ReturnBack
    /*public void scaleimage__backclick(){
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\pressed.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_ReturnBack.getWidth(),this.jLbl_ReturnBack.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_ReturnBack.setIcon(scaledIcon);
    }
    */
    
    
    public void scaleimage__logo(){
        ImageIcon icon = new ImageIcon ("src\\photo\\logo_1.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Logo.getWidth(),this.jLbl_Logo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Logo.setIcon(scaledIcon);
    }
    
    public void scaleimage__vis(){
        ImageIcon icon = new ImageIcon ("src\\photo\\vis.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Visible.getWidth(),this.jLbl_Visible.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Visible.setIcon(scaledIcon);
    }
   
   public void scaleimage__unvis(){
        ImageIcon icon = new ImageIcon ("src\\photo\\inv.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Visible.getWidth(),this.jLbl_Visible.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Visible.setIcon(scaledIcon);
    }
    
   public void scaleimage__backclick(){
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\pressed.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_ReturnBack.getWidth(),this.jLbl_ReturnBack.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_ReturnBack.setIcon(scaledIcon);
    }
   
   public void scaleimage__user(){
        ImageIcon icon = new ImageIcon ("src\\photo\\user.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_ID.getWidth(),this.jLbl_ID.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_ID.setIcon(scaledIcon);
    }
   public void scaleimage__login(){
        ImageIcon icon = new ImageIcon ("src\\photo\\LogIn.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Img.getWidth(),this.jLbl_Img.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Img.setIcon(scaledIcon);
    }
   public void scaleimage__pass(){
        ImageIcon icon = new ImageIcon ("src\\photo\\password (2).png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_Password.getWidth(),this.jLbl_Password.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_Password.setIcon(scaledIcon);
    }
   public void scaleimage__backcwhite(){
        ImageIcon icon = new ImageIcon ("src\\photo\\white.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_LogIn.getWidth(),this.jLbl_LogIn.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_LogIn.setIcon(scaledIcon);
    }
    public void scaleimage__backc_white_remove(){
        ImageIcon icon = new ImageIcon ("");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_LogIn.getWidth(),this.jLbl_LogIn.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_LogIn.setIcon(scaledIcon);
    }
      public void scaleimage__backrel(){
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\back_rel.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_ReturnBack.getWidth(),this.jLbl_ReturnBack.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_ReturnBack.setIcon(scaledIcon);
    }
      
      public void scaleimage__backpre(){
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\back_pre.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(this.jLbl_ReturnBack.getWidth(),this.jLbl_ReturnBack.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLbl_ReturnBack.setIcon(scaledIcon);
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
        jLbl_ReturnBack = new javax.swing.JLabel();
        jLbl_Border = new javax.swing.JLabel();
        jLbl_Logo = new javax.swing.JLabel();
        jLbl_ID = new javax.swing.JLabel();
        jTxt_ID = new javax.swing.JTextField();
        jLbl_Password = new javax.swing.JLabel();
        jLbl_Visible = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLbl_LogIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLbl_Img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1282, 672));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbl_ReturnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_ReturnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_ReturnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_ReturnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_ReturnBackMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_ReturnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 70, 50));

        jLbl_Border.setBackground(new java.awt.Color(255, 255, 255));
        jLbl_Border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/SignIn.gif"))); // NOI18N
        jLbl_Border.setOpaque(true);
        jPanel1.add(jLbl_Border, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 400, 560));

        jLbl_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/Logo_LogIn.png"))); // NOI18N
        jPanel1.add(jLbl_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 260, 190));

        jLbl_ID.setToolTipText("");
        jPanel1.add(jLbl_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 40, 40));

        jTxt_ID.setBackground(new Color(255, 255, 255, 0));
        jTxt_ID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTxt_ID.setForeground(new java.awt.Color(255, 255, 255));
        jTxt_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTxt_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 310, 40));

        jLbl_Password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Password.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLbl_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 40, 40));

        jLbl_Visible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Visible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_VisibleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbl_VisibleMousePressed(evt);
            }
        });
        jPanel1.add(jLbl_Visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 50, 40));

        jPasswordField.setBackground(new Color(255, 255, 255, 0));
        jPasswordField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel1.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 310, 40));

        jLbl_LogIn.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLbl_LogIn.setForeground(new java.awt.Color(0, 153, 0));
        jLbl_LogIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_LogIn.setText("Log In");
        jLbl_LogIn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 204, 0)));
        jLbl_LogIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLbl_LogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbl_LogInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_LogInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_LogInMouseExited(evt);
            }
        });
        jPanel1.add(jLbl_LogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 230, 50));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Olny One Step Left");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 430, 50));

        jLbl_Img.setBackground(new java.awt.Color(28, 58, 67));
        jPanel1.add(jLbl_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -6, 940, 730));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLbl_VisibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_VisibleMousePressed
        // TODO add your handling code here:
    
       
    }//GEN-LAST:event_jLbl_VisibleMousePressed

    private void jLbl_ReturnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ReturnBackMouseEntered
        // TODO add your handling code here:
        //jLbl_ReturnBack.setBackground(Color.BLUE);
        //jLbl_ReturnBack.setOpaque(true);
        scaleimage__backpre();
    }//GEN-LAST:event_jLbl_ReturnBackMouseEntered

    private void jLbl_ReturnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ReturnBackMouseClicked
        // TODO add your handling code here:
        
        scaleimage__backrel();
        
        new Main_frame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLbl_ReturnBackMouseClicked

    private void jLbl_ReturnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ReturnBackMouseExited
        // TODO add your handling code here:
        scaleimage__backclick();
        scaleimage__backrel();
        
        
    }//GEN-LAST:event_jLbl_ReturnBackMouseExited

    private void jLbl_LogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_LogInMouseEntered
        // TODO add your handling code here:
        scaleimage__backcwhite();
        jLbl_LogIn.setForeground(Color.black);
        
    }//GEN-LAST:event_jLbl_LogInMouseEntered

    private void jLbl_LogInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_LogInMouseExited
        // TODO add your handling code here:
        scaleimage__backc_white_remove();
        jLbl_LogIn.setForeground(new Color(0,153,0));
    
    }//GEN-LAST:event_jLbl_LogInMouseExited

    private void jLbl_VisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_VisibleMouseClicked
        // TODO add your handling code here:
        
        // 0 mean state 1 visilbe (initial one)
        // 1  mean state 2 un vis (secound state )
        // 2 back to initial state
        // by majdy
        
 
        if(count == 0 ){
            scaleimage__vis(); 
        jPasswordField.setEchoChar((char) 0);
       }

        
        if(count == 1){
            scaleimage__unvis(); 
        jPasswordField.setEchoChar('*');
      
        }
        count++;
        
        if(count == 2)
        count = 0;
    }//GEN-LAST:event_jLbl_VisibleMouseClicked

    private void jLbl_LogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_LogInMouseClicked
        // TODO add your handling code here:
        // Mayar Abdulkareem start 
            // check that the user has entered both id aand password 
        if (!jTxt_ID.getText().isEmpty() && !(jPasswordField.getPassword().length==0)){
   
             
             int id_temp;
             // check that the id is integer
        try{
            // may cause NumberFormatException
              id  = Integer.parseInt(jTxt_ID.getText()) ;
              id_temp = id;
              int digit =0;
              while (id_temp >0){
              id_temp/=10;
              digit++;
               }
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("Software_ProjectPU" );
              EntityManager em = emf.createEntityManager();
               // check for student 
                if (digit == 8){
                    TypedQuery<Students> q = em.createQuery("SELECT s FROM Students s WHERE s.studentid = :studentid and s.studentpassword =:password",Students.class);
                    // may cause NoResultException ex
                    Students stu = q.setParameter("studentid", BigDecimal.valueOf(Long.parseLong(jTxt_ID.getText()))).setParameter("password",new String(jPasswordField.getPassword())).getSingleResult();
                        // move to Home_for_student  
                           role = "stu";
                           name = stu.getStudentname();
                           this.dispose();
                           thr x = new thr();
                           x.start();
                }
                else if (digit == 4 || digit == 5){
                    TypedQuery<Teachers> q = em.createQuery("SELECT t FROM Teachers t WHERE t.teacherid = :teacherid and t.teacherpassword =:teacherpassword",Teachers.class);
                    // may cause NoResultException ex
                    Teachers t = q.setParameter("teacherid", BigDecimal.valueOf(Long.parseLong(jTxt_ID.getText()))).setParameter("teacherpassword",new String(jPasswordField.getPassword())).getSingleResult();
                         // move to home for teacher 
                           role = t.getTmode();
                           name = t.getTeachername();
                           this.dispose();
                           thr x = new thr();
                           x.start();
                }
              else  
                    // not a stu or prof or ta
                     throw new NoResultException();
        }
        catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"The id  must be a number","Information",JOptionPane.INFORMATION_MESSAGE);
           }
        catch(NoResultException ex){
               JOptionPane.showMessageDialog(null,"There is no user with this ID","Information",JOptionPane.INFORMATION_MESSAGE); 
        }
        catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);  
        }              
    }                                       
     else 
        JOptionPane.showMessageDialog(null,"Please enter both ID and password","Information",JOptionPane.INFORMATION_MESSAGE);
    // Mayar end
    }//GEN-LAST:event_jLbl_LogInMouseClicked

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
            java.util.logging.Logger.getLogger(LogInInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInInterface().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbl_Border;
    private javax.swing.JLabel jLbl_ID;
    private javax.swing.JLabel jLbl_Img;
    private javax.swing.JLabel jLbl_LogIn;
    private javax.swing.JLabel jLbl_Logo;
    private javax.swing.JLabel jLbl_Password;
    private javax.swing.JLabel jLbl_ReturnBack;
    private javax.swing.JLabel jLbl_Visible;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTxt_ID;
    // End of variables declaration//GEN-END:variables
}
