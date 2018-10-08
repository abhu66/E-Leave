/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.setting.ui;

import eleave.daoImpl.TransaksiCutiDaoImpl;
import eleave.model.TransaksiCuti;
import static eleave.setting.ui.Base.karyawan;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author khoerulAbu
 */
public class ScheduledTask extends TimerTask {
    TransaksiCutiDaoImpl transaksiCutiDaoImpl = new TransaksiCutiDaoImpl();
     // to display current timer
	// Add your task here
    
        public static Integer sizes = null;
        
        @Override
	public void run() {
		
	}
    
}
