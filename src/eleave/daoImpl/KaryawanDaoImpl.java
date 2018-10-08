/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.dao.KaryawanDao;
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
public class KaryawanDaoImpl extends Base implements KaryawanDao{

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();
    
    @Override
    public void simpan(Karyawan karyawan) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            String sqlSimpan = "INSERT INTO Karyawan values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = koneksi.prepareStatement(sqlSimpan);
            ps.setString(1, karyawan.getNik());
            ps.setString(2, karyawan.getNama());
            ps.setString(3, karyawan.getJenisKelamin());
            ps.setString(4, karyawan.getAlamat());
            ps.setString(5, karyawan.getStatusPernikahan());
            ps.setString(6, karyawan.getStatusKerja());
            ps.setString(7, karyawan.getTanggalBergabung());
            ps.setString(8, karyawan.getTanggalTerminate());
            ps.setString(9, karyawan.getTanggalLahir());
            ps.setString(10, karyawan.getEmail());
            ps.setString(11, karyawan.getTelpon());
            ps.setString(12, karyawan.getStatus());
            ps.setString(13, karyawan.getAtasan_nik());
            ps.executeUpdate();
            sukses("Simpan");
            
        } catch (SQLException ex) {
            errors(ex.getMessage());
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Karyawan> listByNikOrName(String params) {
        List<Karyawan> listKaryawans = new ArrayList<>();
        try {

            String sqlSelectByNikOrName = "";
            if (params != null) {
                sqlSelectByNikOrName = "SELECT * FROM Karyawan where nik = '" + params + "' or nama like  '%" + params + "%'";
            } else {
                sqlSelectByNikOrName = "SELECT * FROM Karyawan order by nik DESC ";
            }
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNikOrName);
            while (rs.next()) {
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
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKaryawans;
    }

    @Override
    public List<Karyawan> getAll() {
        List<Karyawan> listKaryawans = new ArrayList<>();
        try {
            String sqlSelectByNikOrName = "SELECT * FROM Karyawan order by nik DESC ";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNikOrName);
            while (rs.next()) {
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
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKaryawans;
        }

    @Override
    public Karyawan findByNik(String nik) {
        Karyawan k = null;
        try {
            
            String sqlSelectByNik = "SELECT * FROM Karyawan where nik = '"+nik+"'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNik);
            if(rs.next()){
                k = new Karyawan();
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
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
     }

    @Override
    public void hapus(String nik) {
        try {
            String sqlHapus = "Delete from Karyawan where nik = ? ";
            ps = koneksi.prepareStatement(sqlHapus);
            ps.setString(1, nik);
            ps.executeUpdate();
            ps.close();
            sukses("Dihapus");
        } catch (SQLException ex) {
            errors("Dihapus "+ex.getMessage());
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Karyawan karyawan) {
       //To change body of generated methods, choose Tools | Templates.
       try {
            //To change body of generated methods, choose Tools | Templates.
            String sqlEdit = "UPDATE Karyawan  set nama = ?, jeniskelamin = ?, alamat = ? , status_pernikahan = ?,"
                    + " status_kerja = ?, tanggalBergabung = ?, tanggalterminate = ?, tanggallahir = ?,"
                    + " email = ?, telpon = ?, status = ?, atasan_nik = ? where nik = ? ";
            ps = koneksi.prepareStatement(sqlEdit);
            
            ps.setString(1, karyawan.getNama());
            ps.setString(2, karyawan.getJenisKelamin());
            ps.setString(3, karyawan.getAlamat());
            ps.setString(4, karyawan.getStatusPernikahan());
            ps.setString(5, karyawan.getStatusKerja());
            ps.setString(6, karyawan.getTanggalBergabung());
            ps.setString(7, karyawan.getTanggalTerminate());
            ps.setString(8, karyawan.getTanggalLahir());
            ps.setString(9, karyawan.getEmail());
            ps.setString(10, karyawan.getTelpon());
            ps.setString(11, karyawan.getStatus());
            ps.setString(12, karyawan.getAtasan_nik());
            ps.setString(13, karyawan.getNik());
            ps.executeUpdate();
            sukses("Update");
            
        } catch (SQLException ex) {
            errors(ex.getMessage());
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Karyawan> listByAtasanNik(String atasan_nik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
       

