/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoerulAbu
 */
public class MySQL {
    private static Connection koneksi;
    public static Connection ambilKoneksi(){
        try{
            String url  = "jdbc:mysql://localhost/cuti_db";
            String user = "root";
            String pass = "";
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }
}
