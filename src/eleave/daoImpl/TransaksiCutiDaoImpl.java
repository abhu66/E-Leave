/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.dao.TransaksiCutiDao;
import eleave.koneksi.MySQL;
import eleave.model.TransaksiCuti;
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
public class TransaksiCutiDaoImpl extends Base implements TransaksiCutiDao {
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();

    @Override
    public void simpan(TransaksiCuti transaksiCuti) {
    try {
            //To change body of generated methods, choose Tools | Templates.
            String sqlSimpan = "INSERT INTO TransaksiCuti values (null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = koneksi.prepareStatement(sqlSimpan);
            ps.setString(1, transaksiCuti.getTanggal_request());
            ps.setString(2, transaksiCuti.getNik_karyawan());
            ps.setInt(3, transaksiCuti.getId_kategoricuti());
            ps.setString(4, transaksiCuti.getTanggal_mulai());
            ps.setString(5, transaksiCuti.getTanggal_selesai());
            ps.setString(6, transaksiCuti.getTahun());
            ps.setString(7, transaksiCuti.getStatus());
            ps.setString(8, transaksiCuti.getAtasan_nik());
            ps.setString(9, transaksiCuti.getDeskripsi());
            ps.setString(10, transaksiCuti.getRemark());
            ps.setString(11, transaksiCuti.getTanggalsetuju());
            ps.setString(12, transaksiCuti.getTanggaltolak());
            ps.setString(13,transaksiCuti.getTanggalbatal());
            ps.executeUpdate();
            sukses("Simpan");
            
        } catch (SQLException ex) {
            errors(ex.getMessage());
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TransaksiCuti> listByNik(String nik) {
        List<TransaksiCuti> listTransaksiCutis = new ArrayList<>();
        try {
            String sqlSelectByNik = "SELECT * FROM TransaksiCuti where nik_karyawan like '%" + nik + "%'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNik);
            while (rs.next()) { 
                TransaksiCuti transaksiCuti = new TransaksiCuti();
                transaksiCuti.setId(rs.getInt("id"));
                transaksiCuti.setTanggal_request(rs.getString("tanggal_request"));
                transaksiCuti.setNik_karyawan(rs.getString("nik_karyawan"));
                transaksiCuti.setId_kategoricuti(rs.getInt("id_kategoricuti"));
                transaksiCuti.setTanggal_mulai(rs.getString("tanggal_mulai"));
                transaksiCuti.setTanggal_selesai(rs.getString("tanggal_selesai"));
                transaksiCuti.setTahun(rs.getString("tahun"));
                transaksiCuti.setStatus(rs.getString("status"));
                transaksiCuti.setAtasan_nik(rs.getString("atasan_nik"));
                transaksiCuti.setDeskripsi(rs.getString("deskripsi"));
                transaksiCuti.setRemark(rs.getString("remark"));
                listTransaksiCutis.add(transaksiCuti);
            }
            rs.close();
                
        }   catch (SQLException ex) {
            Logger.getLogger(TransaksiCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTransaksiCutis;
    }

    @Override
    public List<TransaksiCuti> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransaksiCuti findById(Integer id) {
        TransaksiCuti transaksiCuti = null;
        try {
            String sqlSelectByNik = "SELECT * FROM TransaksiCuti where id =  '"+ id + "'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNik);
            if(rs.next()) { 
                transaksiCuti = new TransaksiCuti();
                transaksiCuti.setId(rs.getInt("id"));
                transaksiCuti.setTanggal_request(rs.getString("tanggal_request"));
                transaksiCuti.setNik_karyawan(rs.getString("nik_karyawan"));
                transaksiCuti.setId_kategoricuti(rs.getInt("id_kategoricuti"));
                transaksiCuti.setTanggal_mulai(rs.getString("tanggal_mulai"));
                transaksiCuti.setTanggal_selesai(rs.getString("tanggal_selesai"));
                transaksiCuti.setTahun(rs.getString("tahun"));
                transaksiCuti.setStatus(rs.getString("status"));
                transaksiCuti.setAtasan_nik(rs.getString("atasan_nik"));
                transaksiCuti.setDeskripsi(rs.getString("deskripsi"));
                transaksiCuti.setRemark(rs.getString("remark"));
            }
            rs.close();
                
        }   catch (SQLException ex) {
            Logger.getLogger(TransaksiCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaksiCuti;
    }
    

    @Override
    public List<TransaksiCuti> listByAtasan(String atasan_nik) {
        //To change body of generated methods, choose Tools | Templates.
        List<TransaksiCuti> listTransaksiCutis = new ArrayList<>();
        try {
            String sqlSelectByNik = "SELECT * FROM TransaksiCuti where atasan_nik =  '"+ atasan_nik + "'";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNik);
            while (rs.next()) { 
                TransaksiCuti transaksiCuti = new TransaksiCuti();
                transaksiCuti.setId(rs.getInt("id"));
                transaksiCuti.setTanggal_request(rs.getString("tanggal_request"));
                transaksiCuti.setNik_karyawan(rs.getString("nik_karyawan"));
                transaksiCuti.setId_kategoricuti(rs.getInt("id_kategoricuti"));
                transaksiCuti.setTanggal_mulai(rs.getString("tanggal_mulai"));
                transaksiCuti.setTanggal_selesai(rs.getString("tanggal_selesai"));
                transaksiCuti.setTahun(rs.getString("tahun"));
                transaksiCuti.setStatus(rs.getString("status"));
                transaksiCuti.setAtasan_nik(rs.getString("atasan_nik"));
                transaksiCuti.setDeskripsi(rs.getString("deskripsi"));
                transaksiCuti.setRemark(rs.getString("remark"));
                listTransaksiCutis.add(transaksiCuti);
            }
            rs.close();
                
        }   catch (SQLException ex) {
            Logger.getLogger(TransaksiCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTransaksiCutis;
    }

    @Override
    public void update(TransaksiCuti transaksiCuti) {
        try {
            String update = "UPDATE TransaksiCuti set status = ? , remark = ?, tanggalsetuju = ?,"
                    + " tanggaltolak = ?, tanggalbatal = ? where id = ? ";
            ps = koneksi.prepareStatement(update);
            ps.setString(1, transaksiCuti.getStatus());
            ps.setString(2, transaksiCuti.getRemark());
            ps.setString(3, transaksiCuti.getTanggalsetuju());
            ps.setString(4, transaksiCuti.getTanggaltolak());
            ps.setString(5, transaksiCuti.getTanggalbatal());
            
            ps.setInt(6, transaksiCuti.getId());
            ps.executeUpdate();
            ps.close();
            sukses(transaksiCuti.getStatus());
            
        } catch (SQLException ex) {
            errors(transaksiCuti.getStatus());
            Logger.getLogger(TransaksiCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TransaksiCuti> listByNikAtasanAndStatus(String atasan_nik) {
        List<TransaksiCuti> listTransaksiCutis = new ArrayList<>();
        try {
            String sqlSelectByNik = "SELECT * FROM TransaksiCuti where atasan_nik =  '"+ atasan_nik + "' and status = 'Submit' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlSelectByNik);
            while (rs.next()) { 
                TransaksiCuti transaksiCuti = new TransaksiCuti();
                transaksiCuti.setId(rs.getInt("id"));
                transaksiCuti.setTanggal_request(rs.getString("tanggal_request"));
                transaksiCuti.setNik_karyawan(rs.getString("nik_karyawan"));
                transaksiCuti.setId_kategoricuti(rs.getInt("id_kategoricuti"));
                transaksiCuti.setTanggal_mulai(rs.getString("tanggal_mulai"));
                transaksiCuti.setTanggal_selesai(rs.getString("tanggal_selesai"));
                transaksiCuti.setTahun(rs.getString("tahun"));
                transaksiCuti.setStatus(rs.getString("status"));
                transaksiCuti.setAtasan_nik(rs.getString("atasan_nik"));
                transaksiCuti.setDeskripsi(rs.getString("deskripsi"));
                transaksiCuti.setRemark(rs.getString("remark"));
                listTransaksiCutis.add(transaksiCuti);
            }
            rs.close();
                
        }   catch (SQLException ex) {
            Logger.getLogger(TransaksiCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTransaksiCutis; //To change body of generated methods, choose Tools | Templates.
    }
    
}
