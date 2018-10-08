/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.model.KategoriCuti;
import java.util.List;

/**
 *
 * @author khoerulAbu
 */
public interface KategoriCutiDao {
    public void simpan(KategoriCuti kategoryCuti);
    public List<KategoriCuti> listByNama(String namaCuti);
    public KategoriCuti findByName(String namaCuti);
    public List<KategoriCuti> listAll();
    public KategoriCuti findById(Integer id);
    
}
