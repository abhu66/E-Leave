/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.daoImpl;

import eleave.dao.RiwayatCutiDao;
import eleave.koneksi.MySQL;
import eleave.model.RiwayatCuti;
import eleave.setting.ui.Base;
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
public class RiwayatCutiDaoImpl  extends Base implements RiwayatCutiDao{
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private final Connection koneksi = MySQL.ambilKoneksi();

    @Override
    public void saveRiwayatCuti(RiwayatCuti riwayatCuti) {
        try {
            String sqlSimpan = "insert into riwayatCuti values(null,?,?,?,?,?,?,?,?,?,?,?) ";
            ps = koneksi.prepareStatement(sqlSimpan);
            ps.setString(1, riwayatCuti.getTanggal_request());
            ps.setString(2, riwayatCuti.getNik_karyawan());
            ps.setString(3, riwayatCuti.getAtasan_nik());
            ps.setString(4, riwayatCuti.getStatus());
            ps.setString(5, riwayatCuti.getTanggal_mulai());
            ps.setString(6, riwayatCuti.getTanggal_selesai());
            ps.setInt(7, riwayatCuti.getId_kategoricuti());
            ps.setString(8, riwayatCuti.getTanggalSetuju());
            ps.setString(9, riwayatCuti.getTanggalTolak());
            ps.setString(10, riwayatCuti.getTanggalBatal());
            ps.setInt(11, riwayatCuti.getTransaksicuti_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            errors("Gagal "+ex.getMessage());
            Logger.getLogger(RiwayatCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRiwayatCuti(RiwayatCuti riwayatCuti) {
        try {
            String sqlSimpan = "update riwayatCuti set status = ?, tanggalSetuju = ?, tanggalTolak = ?, tanggalBatal = ? "
                    + " where id = ?";
            ps = koneksi.prepareStatement(sqlSimpan);
           
            ps.setString(1, riwayatCuti.getStatus());
            ps.setString(2, riwayatCuti.getTanggalSetuju());
            ps.setString(3, riwayatCuti.getTanggalTolak());
            ps.setString(4, riwayatCuti.getTanggalBatal());
            ps.setInt(5, riwayatCuti.getId());
            ps.executeUpdate();
            sukses("Simpan");
        } catch (SQLException ex) {
            errors("Gagal "+ex.getMessage());
            Logger.getLogger(RiwayatCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RiwayatCuti findByTransaksiCutiId(Integer transaksiCutiId) {
        RiwayatCuti riwayatCuti = new RiwayatCuti();
        try {
            String sqlCari =  "Select * from RiwayatCuti where transaksi_id = '"+transaksiCutiId+"' ";
            st = koneksi.createStatement();
            rs = st.executeQuery(sqlCari);
           
            if(rs.next()){
                riwayatCuti.setId(rs.getInt(1));
                riwayatCuti.setTanggal_request(rs.getString(2));
                riwayatCuti.setNik_karyawan(rs.getString(3));
                riwayatCuti.setNik_karyawan(rs.getString(4));
                riwayatCuti.setStatus(rs.getString(5));
                riwayatCuti.setTanggal_mulai(rs.getString(6));
                riwayatCuti.setTanggal_selesai(rs.getString(7));
                riwayatCuti.setId_kategoricuti(rs.getInt(8));
                riwayatCuti.setTanggalSetuju(rs.getString(9));
                riwayatCuti.setTanggalTolak(rs.getString(10));
                riwayatCuti.setTanggalBatal(rs.getString(11));
                riwayatCuti.setTransaksicuti_id(rs.getInt(12));
            }} catch (SQLException ex) {
            Logger.getLogger(RiwayatCutiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return riwayatCuti;
    }
}
