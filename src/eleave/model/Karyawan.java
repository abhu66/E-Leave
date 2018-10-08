/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author khoerulAbu
 */
public class Karyawan {
    
    private String nik,nama,jenisKelamin,alamat,statusPernikahan,statusKerja,email,telpon,status;
    private String tanggalBergabung,tanggalTerminate,tanggalLahir,atasan_nik;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatusPernikahan() {
        return statusPernikahan;
    }

    public void setStatusPernikahan(String statusPernikahan) {
        this.statusPernikahan = statusPernikahan;
    }

    public String getStatusKerja() {
        return statusKerja;
    }

    public void setStatusKerja(String statusKerja) {
        this.statusKerja = statusKerja;
    }

    public String getTanggalBergabung() {
        return tanggalBergabung;
    }

    public void setTanggalBergabung(String tanggalBergabung) {
        this.tanggalBergabung = tanggalBergabung;
    }

    public String getTanggalTerminate() {
        return tanggalTerminate;
    }

    public void setTanggalTerminate(String tanggalTerminate) {
        this.tanggalTerminate = tanggalTerminate;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nik);
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
        final Karyawan other = (Karyawan) obj;
        if (!Objects.equals(this.nik, other.nik)) {
            return false;
        }
        return true;
    }

    public String getAtasan_nik() {
        return atasan_nik;
    }

    public void setAtasan_nik(String atasan_nik) {
        this.atasan_nik = atasan_nik;
    }
    

    @Override
    public String toString() {
        return "Karyawan{" + "nik=" + nik + ", nama=" + nama + '}';
    }
    
    
    
}
