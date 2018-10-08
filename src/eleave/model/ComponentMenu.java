/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.model;

import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author khoerulAbu
 */
public class ComponentMenu implements TreeCellRenderer{
    
    private JLabel label;

    public ComponentMenu() {
        label = new JLabel();
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
         //To change body of generated methods, choose Tools | Templates.
         Object o = ((DefaultMutableTreeNode)value).getUserObject();
         if(o instanceof Menu){
             Menu menu = (Menu) o;
             URL imageUrl = getClass().getResource(menu.getIcon());
             if(imageUrl != null){
                 label.setIcon(new ImageIcon(imageUrl));
             }
             label.setText(menu.getNamaMenu());
         }
         else {
             label.setIcon(null);
             label.setText(" "+value);
         }
         return label;
    }
    
}
