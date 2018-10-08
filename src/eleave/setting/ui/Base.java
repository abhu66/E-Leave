/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.setting.ui;

import com.toedter.calendar.JDateChooser;
import eleave.model.Karyawan;
import java.util.Timer;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author khoerulAbu
 */
public class Base {
    
    public static Karyawan  karyawan;
    public Karyawan getKaryawan(Karyawan k){
        karyawan = k;
        return  karyawan;
    }
    
    public void sukses(String pesan){
        JOptionPane.showMessageDialog(null, "Sukses ! "+pesan);
    }
    public void errors(String pesan){
        JOptionPane.showMessageDialog(null, "Error ! "+pesan);
    }
    
     public boolean validateFieldsForm(JTextField f,String errormsg){
      if ( f.getText().equals("") )
        return failedMessage( f, errormsg );
      else
        return true; // validation successful
    }
    public boolean validateFieldsForm(JTextArea f,String errormsg){
      if ( f.getText().equals("") )
        return failedMessage( f, errormsg );
      else
        return true; // validation successful
    }
    public boolean validateFieldsForm(JDateChooser f,String errormsg){
      if ( f.getDate() == null )
        return failedMessage( f, errormsg );
      else
        return true; // validation successful
    }
    public boolean failedMessage(JTextField f, String errormsg){
        JOptionPane.showMessageDialog(null, errormsg); // give user feedback
        f.requestFocus(); // set focus on field, so user can change
        return false; 
    }
    public boolean failedMessage(JTextArea f, String errormsg){
        JOptionPane.showMessageDialog(null, errormsg); // give user feedback
        f.requestFocus(); // set focus on field, so user can change
        return false; 
     }
    public boolean failedMessage(JDateChooser f, String errormsg){
        JOptionPane.showMessageDialog(null, errormsg); // give user feedback
        f.requestFocus(); // set focus on field, so user can change
        return false; 
    }
    
    public void jobsManager() throws InterruptedException{
        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
        time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
        //for demo only.
        System.out.println("Execution in Main Thread....");
        Thread.sleep(2000);
    }
}
