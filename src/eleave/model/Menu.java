/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.model;

/**
 *
 * @author khoerulAbu
 */
public class Menu {
    private String namaMenu;
    private String icon;
    
    public Menu(String namaMenu, String icon){
        this.namaMenu = namaMenu;
        this.icon     = icon;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
    
}
