/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.setting.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTree;

/**
 *
 * @author khoerulAbu
 */
public class TreeScanner extends MouseMotionAdapter{

    static int lastSelected=-1;
 
    public void mouseExited(MouseEvent e){
       JTree tree=(JTree) e.getSource();
       lastSelected=-1;
       tree.clearSelection();
    }
 
    @Override
    public void mouseMoved(MouseEvent e){
       JTree tree=(JTree) e.getSource();
       int selRow=tree.getRowForLocation(e.getX(), e.getY());
       if(selRow==-1){
           tree.clearSelection();
           lastSelected=-1;
       }
       else if(selRow!=lastSelected){
           tree.setSelectionRow(selRow);
           lastSelected=selRow;
       }
    }
}
