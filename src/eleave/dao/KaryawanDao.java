/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.model.Karyawan;
import java.util.List;

/**
 *
 * @author khoerulAbu
 */
public interface KaryawanDao {
    
    public void simpan(Karyawan karyawan);
    public List<Karyawan> listByNikOrName(String params);
    public List<Karyawan> getAll();
    public Karyawan findByNik(String nik);
    public void hapus(String nik);
    public void edit(Karyawan karyawan);
    public List<Karyawan> listByAtasanNik(String atasan_nik);
    
    
}
