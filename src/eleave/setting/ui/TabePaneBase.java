/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.setting.ui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author khoerulAbu
 */
public class TabePaneBase {
    //untuk nama tab dan close button
    public JPanel getTitlePanel(final JTabbedPane jTabbedPane1, final JPanel panel, String title) {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titlePanel.setOpaque(false);
        JLabel titleLbl = new JLabel(title);
        titleLbl.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 10));
        titlePanel.add(titleLbl);
        JLabel labelClose = new JLabel("x");
        //labelClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClose.setToolTipText("Close");
        labelClose.setPreferredSize(new java.awt.Dimension(30, 20));

        labelClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelClose.setOpaque(true);
                labelClose.setBackground(new java.awt.Color(255, 102, 102));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelClose.setOpaque(false);
                labelClose.setBackground(UIManager.getColor("control"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.remove(panel);
            }

        });
        titlePanel.add(labelClose);

        return titlePanel;
    }
    //untuk tambah tab
    public void addTab(JTabbedPane jTabbedPane, JPanel jPanel, String label){
        jTabbedPane.add(jPanel);
        jTabbedPane.setTabComponentAt(jTabbedPane.indexOfComponent(jPanel), getTitlePanel(jTabbedPane, jPanel, label));
        jTabbedPane.setSelectedComponent(jPanel); 
    }
    
}
