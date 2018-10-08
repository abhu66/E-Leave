/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.model;

import java.util.Objects;

/**
 *
 * @author khoerulAbu
 */
public class KategoriCuti {
    private Integer id, masaBerlaku, masaKerja;
    private String nama,deskripsi,jenisKelamin,tipeMasaKerja,statusKaryawan,status;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nama);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KategoriCuti other = (KategoriCuti) obj;
        return Objects.equals(this.nama, other.nama);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMasaBerlaku() {
        return masaBerlaku;
    }

    public void setMasaBerlaku(Integer masaBerlaku) {
        this.masaBerlaku = masaBerlaku;
    }

    public Integer getMasaKerja() {
        return masaKerja;
    }

    public void setMasaKerja(Integer masaKerja) {
        this.masaKerja = masaKerja;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTipeMasaKerja() {
        return tipeMasaKerja;
    }

    public void setTipeMasaKerja(String tipeMasaKerja) {
        this.tipeMasaKerja = tipeMasaKerja;
    }
    
    public String getStatusKaryawan() {
        return statusKaryawan;
    }

    public void setStatusKaryawan(String statusKaryawan) {
        this.statusKaryawan = statusKaryawan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    

    @Override
    public String toString() {
        return "KategoryCuti{" + "nama=" + nama + '}';
    }
 
}
