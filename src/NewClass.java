
import java.awt.Color;
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
public class NewClass {

    public static void main(String args []){
        
   
    } 
        
   
    public void fun(){
    load x = new load();
    x.setVisible(true);
    x.mass.setForeground(Color.white);
    try{
        
        for(int i = 0 ; i <101; i++){
        Thread.sleep(100);
        x.value.setText(i+"%");
         
        if(i==10){x.mass.setText("Turning on Happy Grade Bord...");}
        if(i==20){x.mass.setText("Loading Happy Grade...");}
        if(i==50){x.mass.setText("connecting to DataBase...") ;}
        if(i==70){x.mass.setText("Connection Successful !");}
        if(i==80){x.mass.setText("Launching App...");}
        if(i==98){
            x.mass.setForeground(Color.green);
            x.mass.setText("Welcome");//Iwill add the name of the user here so iwill look like welcome user x
                                      //this will be done after we finish data base we will search for the id and get user name and print it here !
                                      //By majdy.
        }
        if(i==100){
            
            x.dispose();
           // StudentDetailsInterface a = new StudentDetailsInterface();
            //a.setVisible(true);
            switch ( LogInInterface.role ) {
                        case "stu":
                            new home_for_stu().setVisible(true);
                            break;
                        case "Prof":
                            new home_for_prof().setVisible(true);
                            break;
                        case "TA":
                            new home_for_teacher().setVisible(true);
                            break;
                        default:
                            new home_for_teacher().setVisible(true);
                            break;
                    } 
        }
        x.loadbar.setValue(i);
        }
        
    }
    catch(Exception e){e.printStackTrace();}
    }}

        

