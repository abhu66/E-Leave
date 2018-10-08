/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.model.RiwayatCuti;

/**
 *
 * @author khoerulAbu
 */
public interface RiwayatCutiDao {
    
    public void saveRiwayatCuti(RiwayatCuti riwayatCuti);
    public void updateRiwayatCuti(RiwayatCuti riwayatCuti);
    public RiwayatCuti findByTransaksiCutiId(Integer transaksiCutiId);
    
}
