
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
public class Main_frame extends javax.swing.JFrame {

    /**
     * Creates new form Main_frame
     */
    public Main_frame() {
        initComponents();
        scalehead();
        scaleimage_rel_exit();
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        scalehead_logo();
        scalehead_login();
        scalehead_camp();
//       scalehead_photo1();
        scalehead_ad();
        this.flipedimage.setVisible(false);
    }
    
    
    
     public void scalehead_ad(){
        ImageIcon icon = new ImageIcon ("src\\photo\\237-color.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(ad1.getWidth(),ad1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        ad1.setIcon(scaledIcon);
        
        ImageIcon icon1 = new ImageIcon ("src\\photo\\237-color.png");
        Image img1 = icon1.getImage();
        Image imgscale1 = img1.getScaledInstance(ad2.getWidth(),ad2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgscale1);
        ad2.setIcon(scaledIcon1);
        
        ImageIcon icon2 = new ImageIcon ("src\\photo\\237-color.png");
        Image img2 = icon2.getImage();
        Image imgscale2 = img2.getScaledInstance(ad3.getWidth(),ad3.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgscale2);
        ad3.setIcon(scaledIcon2);
        
        ImageIcon icon3 = new ImageIcon ("src\\photo\\237-color.png");
        Image img3 = icon3.getImage();
        Image imgscale3 = img3.getScaledInstance(ad4.getWidth(),ad4.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgscale3);
        ad4.setIcon(scaledIcon);
    }
     
    

//    public void scalehead_photo1(){
//        ImageIcon icon = new ImageIcon ("src\\photo\\Trial.gif");
//        Image img = icon.getImage();
//        Image imgscale = img.getScaledInstance(photo1.getWidth(),photo1.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(imgscale);
//        photo1.setIcon(scaledIcon);
//    }
    
    public void scalehead_login(){
//        ImageIcon icon = new ImageIcon ("src\\photo\\login_panel.png");
//        Image img = icon.getImage();
//        Image imgscale = img.getScaledInstance(login_frame.getWidth(),login_frame.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(imgscale);
//        login_frame.setIcon(scaledIcon);
    }
     public void scalehead_camp(){
        ImageIcon icon = new ImageIcon ("src\\photo\\GreenUni.jpg");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(camp.getWidth(),camp.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        camp.setIcon(scaledIcon);
    }
    //login_panel
public void scalehead_logo(){
        ImageIcon icon = new ImageIcon ("src\\photo\\logo.gif");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        logo.setIcon(scaledIcon);
    }
    
     public void scalehead(){
        ImageIcon icon = new ImageIcon ("src\\photo\\Untitled - Made with DesignCap (11).jpg");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(head.getWidth(),head.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        head.setIcon(scaledIcon);
    }
     
     
     
    
  
    
     public void scaleimage_butt1(){
        
        ImageIcon icon = new ImageIcon ("src\\photo\\white.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance( butt1.getWidth(), butt1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
         butt1.setIcon(scaledIcon);

    }
    
    
    
      
    public void scaleimage_press_exit(){
        
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\press_exit.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance( exit.getWidth(), exit.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
         exit.setIcon(scaledIcon);

    }
     public void scaleimage_rel_exit(){
        
        ImageIcon icon = new ImageIcon ("src\\photo\\botton\\cross.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance( exit.getWidth(), exit.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
         exit.setIcon(scaledIcon);

    }
     public void flipedimage(){
        
        ImageIcon icon = new ImageIcon ("src\\photo\\dark.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance( flipedimage.getWidth(), flipedimage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        flipedimage.setIcon(scaledIcon);

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        butt1 = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLbl_LOGO = new javax.swing.JLabel();
        jLbl_History = new javax.swing.JLabel();
        jLbl_AnNajahLOGO = new javax.swing.JLabel();
        jLbl_Facts = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLbl_Sustainability = new javax.swing.JLabel();
        jLbl_Social = new javax.swing.JLabel();
        jLbl_Image = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLbl_VisionMissions = new javax.swing.JLabel();
        jLbl_Mission = new javax.swing.JLabel();
        jLbl_Visions1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLbl_seperator1 = new javax.swing.JLabel();
        photo1 = new javax.swing.JLabel();
        flipedimage = new javax.swing.JLabel();
        jLbl_ContactDetails = new javax.swing.JLabel();
        jLbl_ClassroomsGuide = new javax.swing.JLabel();
        camp = new javax.swing.JLabel();
        jLbl_ContactUs = new javax.swing.JLabel();
        jLbl_GuidingDetails = new javax.swing.JLabel();
        jLbl_StudyPlansGIF = new javax.swing.JLabel();
        jLbl_StudyPlans = new javax.swing.JLabel();
        jLbl_GuideStudent = new javax.swing.JLabel();
        jLbl_StudentGuideGIF = new javax.swing.JLabel();
        ad4 = new javax.swing.JLabel();
        ad1 = new javax.swing.JLabel();
        ad2 = new javax.swing.JLabel();
        ad3 = new javax.swing.JLabel();
        jLbl_seperator3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLbl_seperator2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLbl_seperator4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLbl_seperator5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Main");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 120));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("We Callenge the Present to Shape the future");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 540, 40));

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
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, 30, 30));

        butt1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        butt1.setForeground(new java.awt.Color(255, 255, 255));
        butt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butt1.setText("Sign In");
        butt1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        butt1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butt1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butt1MouseExited(evt);
            }
        });
        jPanel1.add(butt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 230, 40));
        butt1.getAccessibleContext().setAccessibleName("butt1");

        head.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1280, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 140));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbl_LOGO.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_LOGO.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_LOGO.setText("An-Najah National University Logo:");
        jLbl_LOGO.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1590, 550, 60));

        jLbl_History.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_History.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_History.setText("History and Traditions:");
        jLbl_History.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_History, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1280, 320, 50));

        jLbl_AnNajahLOGO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_AnNajahLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/AnNajahLogo.jpg"))); // NOI18N
        jPanel2.add(jLbl_AnNajahLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1620, 300, 180));

        jLbl_Facts.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_Facts.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_Facts.setText("Facts and Figures: Our Success through Numbers  ");
        jLbl_Facts.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_Facts, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1920, 670, 60));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(15);
        jTextArea1.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n\n\n \n An-Najah National University is a vibrant hub of learning which nourishes science,\n knowledge and understanding. An-Najah offers undergraduate instruction in the fields\n of Medicine, Engineering, Humanities, Social Sciences and the Natural Sciences, as well\n as numerous courses of graduate study in the humanities and the social sciences.\n\n Since it was chartered as a full-fledged university in 1977, An-Najah has promoted the\n acquisition of modern knowledge whilst remaining committed to the transmission and\n preservation of Palestinian history, heritage and culture. Today, as the largest \n University in Palestine, An-Najah educates over 22,000 students and is home to 13\n faculties, offering numerous undergraduate and graduate specialisations.\n\n\n");
        jTextArea1.setBorder(null);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1270, 740, 540));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(15);
        jTextArea2.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("\n \n\n\nAn-Najah National University continues on its ways ‎to success nationally\n and internationally. The University occupied ‎advanced positions in \n international rankings and obtained several world ‎awards. Since establishment,\n An-Najah keeps updated with recent ‎developments and employ all resources\n to serve the educational system ‎and become an international university.‎\n\n Through offering a high quality ‎education, the University is promoting ‎the\n development of qualified and ‎competitive human resources. ‎Maintaining\n this goal over the past thirty-six years, An-Najah has ‎been ‎an integral part \n in enhancing the capacity of local, regional and ‎international markets.‎\n\n As a pivotal institution in Palestine, it is vital that An-Najah continues ‎to inspire\n its student body to realize their own potential to have a ‎positive impact upon the\n society in which they reside. By equipping ‎them with the essential tools of knowledge,\n professionalism and ‎leadership, we believe that their personal development will create\n a more ‎prosperous future for Palestine.‎\n\n The University consists of five campuses: the ‎New Campus, the Old ‎Campus, Hisham\n Hijjawi College of Technology, Khadouri Campus in ‎‎Tulkarm (which offers programs in\n the fields of agriculture and ‎veterinary medicine) and An-Najah National Hospital.‎\n\n There are currently around 23.000 student enrollees. An-Najah is ‎‎comprised of 11 \n faculties located throughout the different campuses, ‎offering 113 Bachelor degree \n programs. It also offers 69 Masters' ‎programs and 9 PhD programs. ");
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1910, 740, 540));

        jLbl_Sustainability.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_Sustainability.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_Sustainability.setText("Sustainability:");
        jLbl_Sustainability.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_Sustainability, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 2570, 670, 50));

        jLbl_Social.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_Social.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_Social.setText("Social Responsibility:");
        jLbl_Social.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_Social, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 2740, 670, 50));

        jLbl_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/SocialResponsibility.PNG"))); // NOI18N
        jPanel2.add(jLbl_Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 2880, 530, 200));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(15);
        jTextArea3.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("\n\n\n\n An-Najah National University is committed to pursuing the sustainable development\n goals (SDGs) and leaving a positive impact on the environment through teaching and\n learning, innovative research, community participation, operational sustainability and \n partnerships. \n\n\n\n\n\n An-Najah National University is dedicated to promoting understanding, providing the\n highest quality undergraduate and graduate education, and serving as a leader in \n scientific research. It acts as a base for sustainable development by encouraging \n students and the University community to assume leadership roles and to participate\n in serving society.");
        jTextArea3.setBorder(null);
        jScrollPane4.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 2550, 740, 540));

        jLbl_VisionMissions.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_VisionMissions.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_VisionMissions.setText("Vision, Mission and Values:");
        jLbl_VisionMissions.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_VisionMissions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3200, 670, 50));

        jLbl_Mission.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_Mission.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_Mission.setText("Mission:");
        jLbl_Mission.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_Mission, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3470, 670, 40));

        jLbl_Visions1.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLbl_Visions1.setForeground(new java.awt.Color(0, 51, 102));
        jLbl_Visions1.setText("Vision:");
        jLbl_Visions1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLbl_Visions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3320, 670, 40));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(15);
        jTextArea4.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("\n \n\n\n Based on its vision, mission and values, An- Najah has published its Strategic Purposes\n \"ANU2020\" for the years 2016-2020.\n\n\n\n An-Najah National University is dedicated to promoting understanding, providing the\n highest quality undergraduate and graduate education, and serving as a leader in \n scientific research. An-Najah acts as a base for sustainable development by \n encouraging students and the University community to assume leadership roles \n and to participate in serving society.\n\n\n\n An-Najah National University is a public institution whose mission is to advance \n learning, share knowledge and foster the skills needed in young men and women to\n succeed as people and professionals in all spheres of life. An-Najah also aims to instill\n a love of understanding in the students and to promote a culture of scientific \n excellence. The University strives to equip its students with the skills necessary to be\n productive and creative members of the Palestinian society and to compete in the \n domestic, Arab and international work markets. The University is also dedicated to \n advancing scientific research on a global level and to meeting the community’s needs\n by participating in sustainable economic, technical and human development. \n Additionally,  An-Najah strives to preserve the cultural and religious heritage of the \n Palestinian people and to increase knowledge of this heritage.");
        jTextArea4.setBorder(null);
        jScrollPane5.setViewportView(jTextArea4);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3190, 740, 540));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Why to choose An-Najah National University as my upcoming university?");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1130, 1160, 90));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("We put you here in a world of ease and technology!");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 720, 60));

        jLbl_seperator1.setBackground(new java.awt.Color(56, 56, 97));
        jLbl_seperator1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_seperator1.setOpaque(true);
        jPanel2.add(jLbl_seperator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1060, 1280, 210));

        photo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/Info1.gif"))); // NOI18N
        jPanel2.add(photo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 1270, 540, 540));

        flipedimage.setBackground(new java.awt.Color(102, 153, 255));
        flipedimage.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        flipedimage.setForeground(new java.awt.Color(255, 255, 255));
        flipedimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        flipedimage.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 3, new java.awt.Color(63, 112, 216)));
        flipedimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(flipedimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 260, 200));

        jLbl_ContactDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_ContactDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/ContactUs.gif"))); // NOI18N
        jLbl_ContactDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_ContactDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_ContactDetailsMouseExited(evt);
            }
        });
        jPanel2.add(jLbl_ContactDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, -1, -1));

        jLbl_ClassroomsGuide.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLbl_ClassroomsGuide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_ClassroomsGuide.setText("ClassRooms Guide");
        jLbl_ClassroomsGuide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_ClassroomsGuideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_ClassroomsGuideMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbl_ClassroomsGuideMousePressed(evt);
            }
        });
        jPanel2.add(jLbl_ClassroomsGuide, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 910, 260, 50));
        jPanel2.add(camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -86, 1290, 670));

        jLbl_ContactUs.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLbl_ContactUs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_ContactUs.setText("Contact Us");
        jLbl_ContactUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_ContactUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_ContactUsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbl_ContactUsMousePressed(evt);
            }
        });
        jPanel2.add(jLbl_ContactUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 910, 260, 50));

        jLbl_GuidingDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GuidingDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/Classrooms.gif"))); // NOI18N
        jPanel2.add(jLbl_GuidingDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 720, -1, -1));

        jLbl_StudyPlansGIF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_StudyPlansGIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/StudyPlans.gif"))); // NOI18N
        jPanel2.add(jLbl_StudyPlansGIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, -1, -1));

        jLbl_StudyPlans.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLbl_StudyPlans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_StudyPlans.setText("Study Plans");
        jLbl_StudyPlans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_StudyPlansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_StudyPlansMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbl_StudyPlansMousePressed(evt);
            }
        });
        jPanel2.add(jLbl_StudyPlans, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 910, 260, 50));

        jLbl_GuideStudent.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLbl_GuideStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_GuideStudent.setText("Student Guide");
        jLbl_GuideStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbl_GuideStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbl_GuideStudentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbl_GuideStudentMousePressed(evt);
            }
        });
        jPanel2.add(jLbl_GuideStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 910, 260, 50));

        jLbl_StudentGuideGIF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_StudentGuideGIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/StudentGuide.gif"))); // NOI18N
        jPanel2.add(jLbl_StudentGuideGIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 720, -1, -1));

        ad4.setBackground(new java.awt.Color(237, 237, 237));
        ad4.setOpaque(true);
        jPanel2.add(ad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 260, 240));

        ad1.setBackground(new java.awt.Color(237, 237, 237));
        ad1.setOpaque(true);
        jPanel2.add(ad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 720, 260, 240));

        ad2.setBackground(new java.awt.Color(237, 237, 237));
        ad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ad2.setOpaque(true);
        jPanel2.add(ad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, 260, 240));

        ad3.setBackground(new java.awt.Color(237, 237, 237));
        ad3.setOpaque(true);
        jPanel2.add(ad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 720, 260, 240));

        jLbl_seperator3.setBackground(new java.awt.Color(56, 56, 97));
        jLbl_seperator3.setOpaque(true);
        jPanel2.add(jLbl_seperator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2450, 1280, 100));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/Info2.gif"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1910, 540, 540));

        jLbl_seperator2.setBackground(new java.awt.Color(56, 56, 97));
        jLbl_seperator2.setOpaque(true);
        jPanel2.add(jLbl_seperator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1810, 1280, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/Info3.gif"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2550, 540, 540));

        jLbl_seperator4.setBackground(new java.awt.Color(56, 56, 97));
        jLbl_seperator4.setOpaque(true);
        jPanel2.add(jLbl_seperator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3090, 1280, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GIFs/Info4.gif"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 3190, 540, 540));

        jLbl_seperator5.setBackground(new java.awt.Color(56, 56, 97));
        jLbl_seperator5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLbl_seperator5.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_seperator5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_seperator5.setText("\"We Challenge the Present to Shape the Future\"");
        jLbl_seperator5.setOpaque(true);
        jPanel2.add(jLbl_seperator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3730, 1280, 210));

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 132, 1280, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon ("src\\photo\\icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void jLbl_ClassroomsGuideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ClassroomsGuideMouseEntered
        // TODO add your handling code here:
        jLbl_ClassroomsGuide.setForeground(Color.blue);
        String classroom = "<html>  <u> Classroom Guide </u>";
        jLbl_ClassroomsGuide.setText(classroom);
    }//GEN-LAST:event_jLbl_ClassroomsGuideMouseEntered

    private void jLbl_ClassroomsGuideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ClassroomsGuideMouseExited
        // TODO add your handling code here:
        jLbl_ClassroomsGuide.setForeground(Color.black);
        jLbl_ClassroomsGuide.setText("Classroom Guide");
    }//GEN-LAST:event_jLbl_ClassroomsGuideMouseExited

    private void jLbl_ClassroomsGuideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ClassroomsGuideMousePressed
        // TODO add your handling code here:
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI GuideURL = new URI("https://zajelbs.najah.edu/servlet/ClaRomDir");
            desktop.browse(GuideURL);
        }
        catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLbl_ClassroomsGuideMousePressed

    private void jLbl_StudyPlansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_StudyPlansMouseEntered
        // TODO add your handling code here:
        jLbl_StudyPlans.setForeground(Color.blue);
        String plans = "<html>  <u> Study Plans </u>";
        jLbl_StudyPlans.setText(plans);
    }//GEN-LAST:event_jLbl_StudyPlansMouseEntered

    private void jLbl_StudyPlansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_StudyPlansMouseExited
        // TODO add your handling code here:
        jLbl_StudyPlans.setForeground(Color.black);
        jLbl_StudyPlans.setText("Study Plans");
    }//GEN-LAST:event_jLbl_StudyPlansMouseExited

    private void jLbl_StudyPlansMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_StudyPlansMousePressed
        // TODO add your handling code here:
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI PlansURL = new URI("https://zajelbs.najah.edu/servlet/UniCurricula");
            desktop.browse(PlansURL);
        }
        catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLbl_StudyPlansMousePressed

    private void jLbl_GuideStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GuideStudentMouseEntered
        // TODO add your handling code here:
        jLbl_GuideStudent.setForeground(Color.blue);
        String stuGuide = "<html>  <u> Student Guide </u>";
        jLbl_GuideStudent.setText(stuGuide);
    }//GEN-LAST:event_jLbl_GuideStudentMouseEntered

    private void jLbl_GuideStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GuideStudentMouseExited
        // TODO add your handling code here:
        jLbl_GuideStudent.setForeground(Color.black);
        jLbl_GuideStudent.setText("Student Guide");
    }//GEN-LAST:event_jLbl_GuideStudentMouseExited

    private void jLbl_GuideStudentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_GuideStudentMousePressed
        // TODO add your handling code here:
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI stuGuideURL = new URI("https://www.najah.edu/ar/academic/admissions/student-guide-book/");
            desktop.browse(stuGuideURL);
        }
        catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLbl_GuideStudentMousePressed

    private void jLbl_ContactUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ContactUsMouseEntered
        // TODO add your handling code here:
        jLbl_ContactUs.setForeground(Color.blue);
        String contactUs = "<html>  <u> Contact Us </u>";
        jLbl_ContactUs.setText(contactUs);
    }//GEN-LAST:event_jLbl_ContactUsMouseEntered

    private void jLbl_ContactUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ContactUsMouseExited
        // TODO add your handling code here:
        jLbl_ContactUs.setForeground(Color.black);
        jLbl_ContactUs.setText("Contact Us");
    }//GEN-LAST:event_jLbl_ContactUsMouseExited

    private void jLbl_ContactDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ContactDetailsMouseEntered
        // TODO add your handling code here:
        flipedimage();
         flipedimage.setText("<html>Contact Us on Happy Grades!<br/> <br/>        happygrades2@gmail.com</html>");
        flipedimage.setVisible(true);
    }//GEN-LAST:event_jLbl_ContactDetailsMouseEntered

    private void jLbl_ContactDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ContactDetailsMouseExited
        // TODO add your handling code here:
         flipedimage.setVisible(false);
    }//GEN-LAST:event_jLbl_ContactDetailsMouseExited

    private void jLbl_ContactUsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_ContactUsMousePressed
        // TODO add your handling code here:
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI stuGuideURL = new URI("mailto:happygrades2@gmail.com");
            desktop.browse(stuGuideURL);
        }
        catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLbl_ContactUsMousePressed

    private void butt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt1MouseExited
        // TODO add your handling code here:
        butt1.setForeground(new Color(255,255,255));
        butt1.setIcon(null);
    }//GEN-LAST:event_butt1MouseExited

    private void butt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt1MouseEntered
        // TODO add your handling code here:
        butt1.setForeground(new Color(0,0,0));
        scaleimage_butt1();
    }//GEN-LAST:event_butt1MouseEntered

    private void butt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt1MouseClicked
        // TODO add your handling code here:
        LogInInterface x = new LogInInterface();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_butt1MouseClicked

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        scaleimage_rel_exit();
    }//GEN-LAST:event_exitMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        scaleimage_press_exit();
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

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
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_frame().setVisible(true);

            }
        });
    }
    
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad1;
    private javax.swing.JLabel ad2;
    private javax.swing.JLabel ad3;
    private javax.swing.JLabel ad4;
    private javax.swing.JLabel butt1;
    private javax.swing.JLabel camp;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel flipedimage;
    private javax.swing.JLabel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbl_AnNajahLOGO;
    private javax.swing.JLabel jLbl_ClassroomsGuide;
    private javax.swing.JLabel jLbl_ContactDetails;
    private javax.swing.JLabel jLbl_ContactUs;
    private javax.swing.JLabel jLbl_Facts;
    private javax.swing.JLabel jLbl_GuideStudent;
    private javax.swing.JLabel jLbl_GuidingDetails;
    private javax.swing.JLabel jLbl_History;
    private javax.swing.JLabel jLbl_Image;
    private javax.swing.JLabel jLbl_LOGO;
    private javax.swing.JLabel jLbl_Mission;
    private javax.swing.JLabel jLbl_Social;
    private javax.swing.JLabel jLbl_StudentGuideGIF;
    private javax.swing.JLabel jLbl_StudyPlans;
    private javax.swing.JLabel jLbl_StudyPlansGIF;
    private javax.swing.JLabel jLbl_Sustainability;
    private javax.swing.JLabel jLbl_VisionMissions;
    private javax.swing.JLabel jLbl_Visions1;
    private javax.swing.JLabel jLbl_seperator1;
    private javax.swing.JLabel jLbl_seperator2;
    private javax.swing.JLabel jLbl_seperator3;
    private javax.swing.JLabel jLbl_seperator4;
    private javax.swing.JLabel jLbl_seperator5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel photo1;
    // End of variables declaration//GEN-END:variables
}
