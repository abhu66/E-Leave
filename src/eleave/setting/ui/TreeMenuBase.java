/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.setting.ui;

import eleave.controller.TransaksiCutiController;
import eleave.daoImpl.TransaksiCutiDaoImpl;
import eleave.model.ComponentMenu;
import eleave.model.Menu;
import eleave.model.Menus;
import eleave.model.TransaksiCuti;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author khoerulAbu
 */
public class TreeMenuBase extends Base{
    TransaksiCutiDaoImpl transaksiCutiDaoImpl = new TransaksiCutiDaoImpl();
    public void TreeMenu(JTree jTree){
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode(new Menu("Menu","/eleave/image/home_icon.png"));
        DefaultMutableTreeNode home = new DefaultMutableTreeNode(new Menu("Home","/eleave/image/home_icon.png"));
        treeNode1.add(home);
        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode(new Menu("Menu Karyawan","/eleave/image/employee_icon.png"));
        Menu[] menus= new Menu[]{
            new Menu(Menus.Request_Cuti.name().replace("_"," "),""),
        };
        for(Menu menu : menus){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(menu);
            treeNode2.add(node);
            
        }
        treeNode1.add(treeNode2);
        System.out.println("NIk : "+karyawan.getNik());
       
       
        DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode(new Menu("Manager","/eleave/image/user_icon.png"));
        Menu[] managers = new Menu[]{
            new Menu(Menus.Approval_Cuti.name().replace("_"," "),""),
        };
        for(Menu menu : managers){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(menu);
            treeNode3.add(node);
        }
        treeNode1.add(treeNode3);
        
        DefaultMutableTreeNode treeNode4 = new DefaultMutableTreeNode(new Menu("HRD","/eleave/image/user_icon.png"));
        Menu[] hrd = new Menu[]{
            new Menu(Menus.Karyawan.name().replace("_"," "),""),
            new Menu(Menus.Kategori_Cuti.name().replace("_"," "),""),
            new Menu(Menus.Management_User.name().replace("_"," "),""),
            new Menu(Menus.Laporan_Cuti.name().replace("_"," "),""),
            
        };
        for(Menu menu : hrd){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(menu);
            treeNode4.add(node);
        }
        treeNode1.add(treeNode4);
        
        DefaultMutableTreeNode treeNode5 = new DefaultMutableTreeNode(new Menu("Keluar","/eleave/image/logout-icon.png"));
        treeNode1.add(treeNode5);
        jTree.setRootVisible(false);
        
       
       jTree.setModel(new DefaultTreeModel(treeNode1));
       jTree.setCellRenderer(new ComponentMenu());
       
    }
    
    
}
