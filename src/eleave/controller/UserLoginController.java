/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.controller;

import eleave.daoImpl.KaryawanDaoImpl;
import eleave.model.UserLogin;
import eleave.daoImpl.UserLoginDaoImpl;
import eleave.model.Karyawan;
import eleave.setting.ui.Base;
import eleave.view.home.FormLogin;
import eleave.view.home.FormUtama;
import eleave.view.hrd.FormUser;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoerulAbu
 */
public class UserLoginController extends Base{
    
    private final UserLoginDaoImpl userLoginDaoImpl = new UserLoginDaoImpl();
    private final KaryawanDaoImpl karyawanDaoImpl = new KaryawanDaoImpl();
    public FormLogin formLogin;
    public FormUtama formUtama;
    public FormUser formUser;
    public String nik_karyawan;
    public String nik;
    public TransaksiCutiController transaksiCutiController;
   
    
    
    public void loadDefault(){
        Tabel();
        formUser.jTabbedPane2.setVisible(false);
        formUser.btnHapus.setEnabled(false);
        //formUser.field.setEditable(false);
        tombolComboboxListKaryawan();
    }
    public void simpan(){
        UserLogin userLoginFromdb = userLoginDaoImpl.findByNik(nik);
        if(userLoginFromdb.getNik() == null){
            UserLogin userLogin = new UserLogin();
            userLogin.setNik(nik);
            userLogin.setPassword(formUser.fieldPassword.getText());
            String hak_akses = "";
            if(formUser.jrAdmin.isSelected()){
                hak_akses = formUser.jrAdmin.getText();
            }
            else {
                 hak_akses = formUser.jrUser.getText();
            }
            userLogin.setHak_akses(hak_akses);
            userLogin.setStatus(formUser.cmbStatus.getSelectedItem().toString());
            userLoginDaoImpl.simpan(userLogin);
            loadDefault();
        }
        else {
             errors("Data sudah ada !");
        }
        
    }
    public void hapus(){
        int row = formUser.tabelUser.getSelectedRow();
        UserLogin userLogin = userLoginDaoImpl.findByNik(formUser.tabelUser.getValueAt(row, 0).toString());
        if(userLogin != null){
            userLoginDaoImpl.hapus(userLogin);
        }
        loadDefault();
    }
    
    public void tableClickView(){
        int row = formUser.tabelUser.getSelectedRow();
        formUser.btnHapus.setEnabled(true);
        formUser.jTabbedPane2.setVisible(true);
        formUser.jTabbedPane2.add("Informasi", formUser.jPanel2);
        formUser.jTabbedPane2.remove(formUser.jPanel3);
        UserLogin userLogin = userLoginDaoImpl.findByNik(formUser.tabelUser.getValueAt(row, 0).toString());
        Karyawan k = karyawanDaoImpl.findByNik(userLogin.getNik());
        formUser.lblNik.setText(userLogin.getNik()+"|"+k.getNama());
        formUser.lblHakAkses.setText(userLogin.getHak_akses());
        formUser.lblStatus.setText(userLogin.getStatus());
        
    }
    public void Tabel(){
        List<UserLogin> userLogins = userLoginDaoImpl.listByNik(formUser.fieldCari.getText());
        String [] header = {"NIK","NAMA","HAK AKSES","STATUS"};
        DefaultTableModel tabelModel = new DefaultTableModel(null,header);
        formUser.tabelUser.setModel(tabelModel);
        for(UserLogin us : userLogins){
            Karyawan k = karyawanDaoImpl.findByNik(us.getNik());
            tabelModel.addRow(new Object[]{
                us.getNik(),
                k.getNama(),
                us.getHak_akses(),
                us.getStatus()
            });
        } 
    }
    
    public void buttonBuatBaru(){
        loadDefault();
        //formUser.fi.setEditable(true);
        formUser.jTabbedPane2.setVisible(true);
        formUser.jTabbedPane2.add("Data Baru", formUser.jPanel3);
        formUser.jTabbedPane2.remove(formUser.jPanel2);
    }
    public void buttonLogin(){
       UserLogin userLogin = userLoginDaoImpl.findByNik(formLogin.jTextField1.getText());
       if(userLogin != null){
            if(formLogin.jPasswordField1.getText().equals(userLogin.getPassword())){
               Karyawan k = userLoginDaoImpl.login(userLogin);
                nik_karyawan = k.getNik();
                FormUtama formUtamas = new FormUtama();
                formUtamas.userLoginController = this;
                formUtamas.lblNikNama.setText(k.getNama());
                formUtamas.NIK.setText(userLogin.getHak_akses());
                formUtamas.setVisible(true); 
                formLogin.dispose();
            }
            else {
                errors("Password salah !");
            }
       }
       else {
           errors("Nik / Karyawan Tidak terdaftar !");
       }
    }
    
    public void tombolComboboxListKaryawan(){
        List<Karyawan> listKaryawans = userLoginDaoImpl.listAll();
        if(formUser.cmbKaryawan.getItemCount() != 0){
            formUser.cmbKaryawan.removeAllItems(); 
            formUser.cmbKaryawan.addItem("---Pilih Karyawan---");
        }
        if(listKaryawans != null){
            for(Karyawan k : listKaryawans){
            formUser.cmbKaryawan.addItem(k.getNik()+"|"+k.getNama()); 
            } 
        }
    }
    public void defaultPassword(){
        if(formUser.cmbKaryawan.getItemCount() != 0){
            if(formUser.cmbKaryawan.getSelectedIndex() != 0){
                String karyawanTerpilih = formUser.cmbKaryawan.getSelectedItem().toString();
                nik = karyawanTerpilih.substring(0, karyawanTerpilih.indexOf("|"));
                Karyawan k = karyawanDaoImpl.findByNik(nik);
                formUser.fieldPassword.setText(k.getTanggalLahir().replace("-", "")); 
            }
            else {
                formUser.fieldPassword.setText(null);
            }
        }
    }

    public String getNik_karyawan() {
        return nik_karyawan;
    }

    public void setNik_karyawan(String nik_karyawan) {
        this.nik_karyawan = nik_karyawan;
    }
    
    
    
}
