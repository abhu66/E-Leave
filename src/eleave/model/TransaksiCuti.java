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
public class TransaksiCuti {
    private int id,id_kategoricuti;
    private String nik_karyawan,tanggal_request,tanggal_mulai,tanggal_selesai,tahun,status,atasan_nik,
            deskripsi,remark,tanggalsetuju, tanggaltolak, tanggalbatal;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kategoricuti() {
        return id_kategoricuti;
    }

    public void setId_kategoricuti(int id_kategoricuti) {
        this.id_kategoricuti = id_kategoricuti;
    }

    public String getNik_karyawan() {
        return nik_karyawan;
    }

    public void setNik_karyawan(String nik_karyawan) {
        this.nik_karyawan = nik_karyawan;
    }

    public String getTanggal_request() {
        return tanggal_request;
    }

    public void setTanggal_request(String tanggal_request) {
        this.tanggal_request = tanggal_request;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAtasan_nik() {
        return atasan_nik;
    }

    public void setAtasan_nik(String atasan_nik) {
        this.atasan_nik = atasan_nik;
    } 

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTanggalsetuju() {
        return tanggalsetuju;
    }

    public void setTanggalsetuju(String tanggalsetuju) {
        this.tanggalsetuju = tanggalsetuju;
    }

    public String getTanggaltolak() {
        return tanggaltolak;
    }

    public void setTanggaltolak(String tanggaltolak) {
        this.tanggaltolak = tanggaltolak;
    }

    public String getTanggalbatal() {
        return tanggalbatal;
    }

    public void setTanggalbatal(String tanggalbatal) {
        this.tanggalbatal = tanggalbatal;
    }
}
