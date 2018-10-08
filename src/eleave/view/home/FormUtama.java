/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.view.home;

import eleave.controller.TransaksiCutiController;
import eleave.controller.UserLoginController;
import eleave.daoImpl.TransaksiCutiDaoImpl;
import eleave.model.Menu;
import eleave.model.Menus;
import eleave.setting.ui.TabePaneBase;
import eleave.setting.ui.TreeMenuBase;
import eleave.view.hrd.FormKaryawan;
import eleave.view.hrd.FormKategoriCuti;
import eleave.view.hrd.FormUser;
import eleave.view.karyawan.FormApproval;
import eleave.view.karyawan.FormCuti;
import eleave.view.karyawan.FormProfil;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author khoerulAbu
 */
public class FormUtama extends javax.swing.JFrame {
private final TransaksiCutiDaoImpl transaksiCutiDaoImpl = new TransaksiCutiDaoImpl();
private final TransaksiCutiController transaksiCutiController = new TransaksiCutiController();
public UserLoginController userLoginController;
private final TreeMenuBase treeMenuBase = new TreeMenuBase();
private final TabePaneBase tabePaneBase = new TabePaneBase();
private final FormCuti formCuti         = new FormCuti(new FlowLayout(FlowLayout.LEFT, 0, 0));
public final FormApproval formApproval = new FormApproval(new FlowLayout(FlowLayout.LEFT, 0, 0));
private final FormKategoriCuti formKategoriCuti = new FormKategoriCuti(new FlowLayout(FlowLayout.LEFT, 0, 0));
private final FormKaryawan formKaryawan = new FormKaryawan(new FlowLayout(FlowLayout.LEFT, 0, 0));
private final FormUser formUser = new FormUser(new FlowLayout(FlowLayout.LEFT, 0, 0));
private final FormProfil formProfil = new FormProfil(new FlowLayout(FlowLayout.LEFT, 0, 0));

    /**
     * Creates new form FormUtama
     */
    public FormUtama() {
        initComponents();
        treeMenuBase.TreeMenu(jTree1); 
        lblVersi.setText("1");
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void Menu(){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            Menu menu = (Menu) nodeInfo;
            if (jTabbedPane1.getTabCount() != 0) {
                if (menu.getNamaMenu().equalsIgnoreCase(Menus.Home.name().replace("_", " "))) {
                    if (formProfil.isVisible() == true) {
                        tabePaneBase.addTab(jTabbedPane1, formProfil, Menus.Home.name().replace("_", " "));
                    } else {
                        
                        jTabbedPane1.setSelectedComponent(formProfil);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Request_Cuti.name().replace("_", " "))) {
                    if (formCuti.isVisible() == true) {
                        formCuti.init();
                        tabePaneBase.addTab(jTabbedPane1, formCuti, Menus.Request_Cuti.name().replace("_", " "));
                    } else {
                        //transaksiCutiController.loadDefault();
                        formCuti.init();
                        jTabbedPane1.setSelectedComponent(formCuti);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Approval_Cuti.name().replace("_", " "))) {
                    if (formApproval.isVisible() == true) {
                        formApproval.init();
                        tabePaneBase.addTab(jTabbedPane1, formApproval, Menus.Approval_Cuti.name().replace("_", " "));
                    } else {
                        formApproval.init();
                        jTabbedPane1.setSelectedComponent(formApproval);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Kategori_Cuti.name().replace("_", " "))) {
                    if (formApproval.isVisible() == true) {
                        tabePaneBase.addTab(jTabbedPane1, formKategoriCuti, Menus.Kategori_Cuti.name().replace("_", " "));
                    } else {
                        jTabbedPane1.setSelectedComponent(formKategoriCuti);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Karyawan.name().replace("_", " "))) {
                    if (formKaryawan.isVisible() == true) {
                        tabePaneBase.addTab(jTabbedPane1, formKaryawan, Menus.Karyawan.name().replace("_", " "));
                    } else {
                        
                        jTabbedPane1.setSelectedComponent(formKaryawan);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Management_User.name().replace("_", " "))) {
                    if (formUser.isVisible() == true) {
                        tabePaneBase.addTab(jTabbedPane1, formUser, Menus.Management_User.name().replace("_", " "));
                    } else {
                        jTabbedPane1.setSelectedComponent(formUser);
                    }
                } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Keluar.name().replace("_", " "))) {
                    int jawab = JOptionPane.showConfirmDialog(rootPane, "Keluar ?", "Keluar", JOptionPane.YES_NO_OPTION);
                    if (jawab == 0) {
                        System.exit(jawab);
                    }
                }

            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Home.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formProfil, Menus.Home.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Request_Cuti.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formCuti, Menus.Request_Cuti.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Approval_Cuti.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formApproval, Menus.Approval_Cuti.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Kategori_Cuti.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formKategoriCuti, Menus.Kategori_Cuti.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Karyawan.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formKaryawan, Menus.Karyawan.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Management_User.name().replace("_", " "))) {
                tabePaneBase.addTab(jTabbedPane1, formUser, Menus.Management_User.name().replace("_", " "));
            } else if (menu.getNamaMenu().equalsIgnoreCase(Menus.Keluar.name().replace("_", " "))) {
                int jawab = JOptionPane.showConfirmDialog(rootPane, "Keluar ?", "Keluar", JOptionPane.YES_NO_OPTION);
                if (jawab == 0) {
                    System.exit(jawab);
                }
            }
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NIK = new javax.swing.JLabel();
        lblNikNama = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblVersi = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eleave/image/icon_1.jpg"))); // NOI18N
        jLabel1.setText("E-leave");

        jLabel2.setText("User :");

        NIK.setText("jLabel3");

        lblNikNama.setText("jLabel3");

        jLabel4.setText("Login As :");

        jLabel5.setText("Versi :");

        lblVersi.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NIK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNikNama, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVersi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNikNama)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIK)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVersi)
                            .addComponent(jLabel5))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTree1.setBackground(new java.awt.Color(240, 240, 240));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Home");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Menu Karyawan");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Request Cuti");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Menu Manager");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Cuti");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Menu HRD");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Karyawan");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Laporan Cuti");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Menu2");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        Menu();
    }//GEN-LAST:event_jTree1ValueChanged

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel NIK;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    public javax.swing.JLabel lblNikNama;
    public javax.swing.JLabel lblVersi;
    // End of variables declaration//GEN-END:variables
}
