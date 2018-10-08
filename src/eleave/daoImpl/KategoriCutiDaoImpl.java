/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.koneksi.MySQL;
import eleave.model.KategoriCuti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import eleave.dao.KategoriCutiDao;
import eleave.setting.ui.Base;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khoerulAbu
 */
public class KategoriCutiDaoImpl extends Base implements KategoriCutiDao{
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();

    @Override
    public void simpan(KategoriCuti kategoryCuti) {
        try {
            String sqlSimpan = "INSERT INTO KategoriCuti values (null,?,?,?,?,?,?,?,?)";
            ps = koneksi.prepareStatement(sqlSimpan);
            ps.setString(1, kategoryCuti.getNama());
            ps.setInt(2, kategoryCuti.getMasaBerlaku());
            ps.setString(3, kategoryCuti.getDeskripsi());
            ps.setString(4, kategoryCuti.getJenisKelamin());
            ps.setString(5, kategoryCuti.getTipeMasaKerja());
            ps.setInt(6, kategoryCuti.getMasaKerja());
            ps.setString(7, kategoryCuti.getStatusKaryawan());
            ps.setString(8, kategoryCuti.getStatus());
            ps.executeUpdate();
            sukses("Simpan");
            ps.close();
        } catch (SQLException ex) {
            errors(ex.getMessage());
            Logger.getLogger(KategoriCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<KategoriCuti> listByNama(String namaCuti) {
        List<KategoriCuti> kategoriCutis = new ArrayList<>();
        try {
            String sqlList= "";
            if(namaCuti == null || namaCuti.isEmpty()){
                sqlList = "SELECT * FROM KategoriCuti ";  
            }
            else{
                sqlList = "SELECT * FROM KategoriCuti where nama_cuti = '"+namaCuti+"'";
            }
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlList);
            while(rs.next()){
                KategoriCuti kategoriCuti = new KategoriCuti();
                kategoriCuti.setId(rs.getInt("id"));
                kategoriCuti.setNama(rs.getString("nama_cuti"));
                kategoriCuti.setMasaBerlaku(rs.getInt("masa_berlaku"));
                kategoriCuti.setDeskripsi(rs.getString("deskripsi"));
                kategoriCuti.setJenisKelamin(rs.getString("validasi_jk"));
                kategoriCuti.setTipeMasaKerja(rs.getString("validasi_tipemasa"));
                kategoriCuti.setMasaKerja(rs.getInt("validasi_masakeerja"));
                kategoriCuti.setStatusKaryawan(rs.getString("validasi_status"));
                kategoriCuti.setStatus(rs.getString("status"));
                kategoriCutis.add(kategoriCuti);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategoriCutis;
    }

    @Override
    public KategoriCuti findByName(String namaCuti) {
        KategoriCuti kategoriCuti = new KategoriCuti();
        try {
            String sqlCari = "SELECT * FROM KategoriCuti where nama_cuti = '"+namaCuti+"' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCari);
            if(rs.next()){
                kategoriCuti.setId(rs.getInt("id"));
                kategoriCuti.setNama(rs.getString("nama_cuti"));
                kategoriCuti.setMasaBerlaku(rs.getInt("masa_berlaku"));
                kategoriCuti.setDeskripsi(rs.getString("deskripsi"));
                kategoriCuti.setJenisKelamin(rs.getString("validasi_jk"));
                kategoriCuti.setTipeMasaKerja(rs.getString("validasi_tipemasa"));
                kategoriCuti.setMasaKerja(rs.getInt("validasi_masakeerja"));
                kategoriCuti.setStatusKaryawan(rs.getString("validasi_status"));
                kategoriCuti.setStatus(rs.getString("status")); 
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategoriCuti;
    }

    @Override
    public List<KategoriCuti> listAll() {
         List<KategoriCuti> kategoriCutis = new ArrayList<>();
        try {
            //To change body of generated methods, choose Tools | Templates.
            String sqlList = "SELECT * FROM Kategoricuti where status = 'Aktif' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlList);
            while(rs.next()){
                KategoriCuti kategoriCuti = new KategoriCuti();
                kategoriCuti.setId(rs.getInt("id"));
                kategoriCuti.setNama(rs.getString("nama_cuti"));
                kategoriCuti.setMasaBerlaku(rs.getInt("masa_berlaku"));
                kategoriCuti.setDeskripsi(rs.getString("deskripsi"));
                kategoriCuti.setJenisKelamin(rs.getString("validasi_jk"));
                kategoriCuti.setTipeMasaKerja(rs.getString("validasi_tipemasa"));
                kategoriCuti.setMasaKerja(rs.getInt("validasi_masakeerja"));
                kategoriCuti.setStatusKaryawan(rs.getString("validasi_status"));
                kategoriCuti.setStatus(rs.getString("status"));
                kategoriCutis.add(kategoriCuti);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategoriCutis;
    }

    @Override
    public KategoriCuti findById(Integer id) {
       KategoriCuti kategoriCuti = new KategoriCuti();
        try {
            String sqlCari = "SELECT * FROM KategoriCuti where id = '"+id+"' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCari);
            if(rs.next()){
                kategoriCuti.setId(rs.getInt("id"));
                kategoriCuti.setNama(rs.getString("nama_cuti"));
                kategoriCuti.setMasaBerlaku(rs.getInt("masa_berlaku"));
                kategoriCuti.setDeskripsi(rs.getString("deskripsi"));
                kategoriCuti.setJenisKelamin(rs.getString("validasi_jk"));
                kategoriCuti.setTipeMasaKerja(rs.getString("validasi_tipemasa"));
                kategoriCuti.setMasaKerja(rs.getInt("validasi_masakeerja"));
                kategoriCuti.setStatusKaryawan(rs.getString("validasi_status"));
                kategoriCuti.setStatus(rs.getString("status")); 
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategoriCuti; //To change body of generated methods, choose Tools | Templates.
    }
}
