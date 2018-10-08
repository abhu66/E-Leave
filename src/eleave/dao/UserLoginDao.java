/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.model.UserLogin;
import eleave.model.Karyawan;
import java.util.List;

/**
 *
 * @author khoerulAbu
 */
public interface UserLoginDao {
    
    public void simpan(UserLogin userLogin);
    public Karyawan login(UserLogin userLogin);
    public UserLogin findByNik(String nik);
    public List<Karyawan> listAll();
    public List<UserLogin> listByNik(String nik);
    public void hapus(UserLogin userLogin);
    
}
