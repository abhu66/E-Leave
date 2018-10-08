/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.model.UserLogin;
import eleave.dao.UserLoginDao;
import eleave.koneksi.MySQL;
import eleave.model.Karyawan;
import eleave.setting.ui.Base;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoerulAbu
 */
public class UserLoginDaoImpl extends Base implements UserLoginDao{
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();

    @Override
    public void simpan(UserLogin userLogin) {
        try {
            String sqlSimpan = "INSERT INTO Userlogin values (?,?,?,?) ";
            ps = koneksi.prepareStatement(sqlSimpan);
            ps.setString(1, userLogin.getNik());
            ps.setString(2, userLogin.getPassword());
            ps.setString(3, userLogin.getHak_akses());
            ps.setString(4, userLogin.getStatus());
            ps.executeUpdate();
            sukses("Simpan");
        } catch (SQLException ex) {
            errors("Simpan "+ex.getMessage());
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Karyawan login(UserLogin userLogin) {
        Karyawan k = new Karyawan();
        try {
            //To change body of generated methods, choose Tools | Templates.
            String selectKaryawan = "Select * from Karyawan where nik = '"+userLogin.getNik()+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(selectKaryawan);
            if(rs.next()){
                k.setNik(rs.getString("nik"));
                k.setNama(rs.getString("nama"));
                k.setJenisKelamin(rs.getString("jenisKelamin"));
                k.setAlamat(rs.getString("alamat"));
                k.setStatusPernikahan(rs.getString("status_pernikahan"));
                k.setStatusKerja(rs.getString("status_kerja"));
                k.setTanggalBergabung(rs.getString("tanggalbergabung"));
                k.setTanggalTerminate(rs.getString("tanggalterminate"));
                k.setTanggalLahir(rs.getString("tanggallahir"));
                k.setEmail(rs.getString("email"));
                k.setTelpon(rs.getString("telpon"));
                k.setStatus(rs.getString("status"));
                k.setAtasan_nik(rs.getString("atasan_nik"));
                getKaryawan(k);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    @Override
    public UserLogin findByNik(String nik) {
        UserLogin userLogin = new UserLogin();
        try {
            String cariUserByNik = "SELECT * FROM UserLogin where nik_user = '"+nik+"'and status = 'aktif' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(cariUserByNik);
            if(rs.next()){
                userLogin.setNik(rs.getString("nik_user"));
                userLogin.setPassword(rs.getString("password_user"));
                userLogin.setHak_akses(rs.getString("hak_akses")); 
                userLogin.setStatus(rs.getString("status")); 
                rs.close();
            }} catch (SQLException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userLogin;
    }

    @Override
    public List<Karyawan> listAll() {
        
        List<Karyawan> listKaryawans = new ArrayList<>();
        listKaryawans.clear();
        try {
            String sqlList = " select * from Karyawan order by nik desc";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlList);
            while(rs.next()){
                Karyawan k = new Karyawan();
                k.setNik(rs.getString("nik"));
                k.setNama(rs.getString("nama"));
                k.setJenisKelamin(rs.getString("jenisKelamin"));
                k.setAlamat(rs.getString("alamat"));
                k.setStatusPernikahan(rs.getString("status_pernikahan"));
                k.setStatusKerja(rs.getString("status_kerja"));
                k.setTanggalBergabung(rs.getString("tanggalbergabung"));
                k.setTanggalTerminate(rs.getString("tanggalterminate"));
                k.setTanggalLahir(rs.getString("tanggallahir"));
                k.setEmail(rs.getString("email"));
                k.setTelpon(rs.getString("telpon"));
                k.setStatus(rs.getString("status"));
                k.setAtasan_nik(rs.getString("atasan_nik"));
                listKaryawans.add(k);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKaryawans;
    }

    @Override
    public List<UserLogin> listByNik(String nik) {
        List<UserLogin> userLogins = new ArrayList<>();
        try {
            String sql = "";
            if(nik != null){
                sql = "select * from UserLogin where nik_user = '"+ nik +"' or nik_user like  '%" + nik + "%' ";
                
            }
            else {
                sql = "SELECT * FROM UserLogin ";
                System.out.println("n :"+nik);
               
            }
            st = koneksi.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                UserLogin userLogin =  new UserLogin();
                userLogin.setNik(rs.getString("nik_user"));
                userLogin.setHak_akses(rs.getString("hak_akses"));
                userLogin.setStatus(rs.getString("status"));
                userLogins.add(userLogin);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userLogins;
    }

    @Override
    public void hapus(UserLogin userLogin) {
        try {
            String sqlUpdate = "UPDATE Userlogin set status = ? where nik_user = ? ";
            ps = koneksi.prepareStatement(sqlUpdate);
            ps.setString(1, "Tidak aktif");
            ps.setString(2, userLogin.getNik());
            ps.executeUpdate();
            sukses("User dinonaktifkan !");
            ps.close();
        } catch (SQLException ex) {
            errors("Hapus");
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
