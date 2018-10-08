/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.model.TransaksiCuti;
import java.util.List;

/**
 *
 * @author khoerulAbu
 */
public interface TransaksiCutiDao {
    
    public void simpan(TransaksiCuti transaksiCuti);
    public List<TransaksiCuti> listByNik(String nik);
    public List<TransaksiCuti> getAll();
    public TransaksiCuti findById(Integer id);
    public List<TransaksiCuti> listByAtasan(String atasan_nik);
    public void update(TransaksiCuti transaksiCuti);
    public List<TransaksiCuti> listByNikAtasanAndStatus(String atasan_nik);
    //public TransaksiCuti findByNi(String n);
    
}
