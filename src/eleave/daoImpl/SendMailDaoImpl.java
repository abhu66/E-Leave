/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.dao.SendMailDao;
import eleave.koneksi.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoerulAbu
 */
public class SendMailDaoImpl implements SendMailDao{
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();
    @Override
    public String getSmtpHost(String parameter) {
        String hostName = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                hostName = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostName;
    }

    @Override
    public String getSmtpAuth(String parameter) {
       String auth = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                auth = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return auth;
    }

    @Override
    public String getSmtpPort(String parameter) {
       String port = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                port = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return port;
    }

    @Override
    public String getSmtpSender(String parameter) {
        String sender = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                sender = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sender;
    }

    @Override
    public String getSmtpPassword(String parameter) {
        String password = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                password = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }

    @Override
    public String getSubjectRequestCuti(String parameter) {
     String subject = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                subject = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    @Override
    public String getContentRequestCuti(String parameter) {
        //To change body of generated methods, choose Tools | Templates.
        String content = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                content = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }

    @Override
    public String getSmtp(String parameter) {
        //To change body of generated methods, choose Tools | Templates.
        String value = "";
        try {
            String sqlCariHost = "SELECT * FROM Parameter where nama = '"+parameter+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCariHost);
            if(rs.next()){
                value = rs.getString("isi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SendMailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
}
