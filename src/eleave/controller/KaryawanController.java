/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.controller;

import eleave.daoImpl.KaryawanDaoImpl;
import eleave.model.Karyawan;
import eleave.setting.ui.Base;
import eleave.view.hrd.FormKaryawan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoerulAbu
 */
public class KaryawanController  extends  Base{
    private final KaryawanDaoImpl karyawanDaoImpl = new KaryawanDaoImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public FormKaryawan formKaryawan;
    
    public void loadDefault(){
        Tabel();
        formKaryawan.jTabbedPane2.setVisible(false);
        formKaryawan.btnEdit.setEnabled(false);
        formKaryawan.btnHapus.setEnabled(false);
        formKaryawan.fieldNik.setEditable(false);
        comboboxListAtasan();
        clear();
    }
    public void simpan(){
        Karyawan k = karyawanDaoImpl.findByNik(formKaryawan.fieldNik.getText());
        if(k != null ){
            simpanEdit();
        }
        else {
            Karyawan karyawans = new Karyawan();
            karyawans.setNik(formKaryawan.fieldNik.getText());
            karyawans.setNama(formKaryawan.fieldNama.getText());
            karyawans.setJenisKelamin(formKaryawan.fieldJenisKelamin.getSelectedItem().toString());
            karyawans.setAlamat(formKaryawan.fieldAlamat.getText());
            karyawans.setStatusPernikahan(formKaryawan.fieldPernikahan.getSelectedItem().toString());
            karyawans.setStatusKerja(formKaryawan.fieldStatusKerja.getSelectedItem().toString());
            karyawans.setTanggalBergabung(sdf.format(formKaryawan.fieldTanggalGabung.getDate()));
            if(formKaryawan.fieldTanggalTerminate.getDate() != null){
                  karyawans.setTanggalTerminate(sdf.format(formKaryawan.fieldTanggalTerminate.getDate()));
            }
            else {
                karyawans.setTanggalTerminate(null);
            }
            karyawans.setTanggalLahir(sdf.format(formKaryawan.fieldTanggalLahir.getDate()));
            karyawans.setEmail(formKaryawan.fieldEmail.getText());
            karyawans.setTelpon(formKaryawan.fieldTelpon.getText());
            karyawans.setStatus(formKaryawan.fieldStatus.getSelectedItem().toString());
            String nik = formKaryawan.fieldAtasanNik.getSelectedItem().toString();
            if(nik.contains("|")){
                karyawans.setAtasan_nik(nik.substring(0,nik.indexOf("|"))); 
            }
            else {
               karyawans.setAtasan_nik(null); 
            }
           
            karyawanDaoImpl.simpan(karyawans);
            loadDefault();
        }
    }
    
    public void simpanEdit(){
        Karyawan karyawans = karyawanDaoImpl.findByNik(formKaryawan.fieldNik.getText());
        karyawans.setNik(formKaryawan.fieldNik.getText());
        karyawans.setNama(formKaryawan.fieldNama.getText());
        karyawans.setJenisKelamin(formKaryawan.fieldJenisKelamin.getSelectedItem().toString());
        karyawans.setAlamat(formKaryawan.fieldAlamat.getText());
        karyawans.setStatusPernikahan(formKaryawan.fieldPernikahan.getSelectedItem().toString());
        karyawans.setStatusKerja(formKaryawan.fieldStatusKerja.getSelectedItem().toString());
        karyawans.setTanggalBergabung(sdf.format(formKaryawan.fieldTanggalGabung.getDate()));
        if(formKaryawan.fieldTanggalTerminate.getDate() != null){
              karyawans.setTanggalTerminate(sdf.format(formKaryawan.fieldTanggalTerminate.getDate()));
        }
        else {
            karyawans.setTanggalTerminate(null);
        }
        karyawans.setTanggalLahir(sdf.format(formKaryawan.fieldTanggalLahir.getDate()));
        karyawans.setEmail(formKaryawan.fieldEmail.getText());
        karyawans.setTelpon(formKaryawan.fieldTelpon.getText());
        karyawans.setStatus(formKaryawan.fieldStatus.getSelectedItem().toString());
        String nik = formKaryawan.fieldAtasanNik.getSelectedItem().toString();
        karyawans.setAtasan_nik(nik.substring(0,nik.indexOf("|")));
        karyawanDaoImpl.edit(karyawans);
        loadDefault();
    }
    
     public void Tabel(){
        List<Karyawan> karyawans = karyawanDaoImpl.listByNikOrName(formKaryawan.fieldcari.getText());
        String [] header = {"NIK","NAMA","JENIS KELAMIN","TANGGAL LAHIR","EMAIL","TELPON","STATUS"};
        DefaultTableModel tabelModel = new DefaultTableModel(null,header);
        formKaryawan.tabelKaryawan.setModel(tabelModel);
        for(Karyawan kr : karyawans){
            tabelModel.addRow(new Object[]{
                kr.getNik(),
                kr.getNama(),
                kr.getJenisKelamin(),
                kr.getTanggalLahir(),
                kr.getEmail(),
                kr.getTelpon(),
                kr.getStatus()
            });
        } 
    }
     
    public void buttonBuatBaru(){
        loadDefault();
        formKaryawan.fieldNik.setEditable(true);
        formKaryawan.jTabbedPane2.setVisible(true);
        formKaryawan.jTabbedPane2.add("Data Baru", formKaryawan.jPanel3);
        formKaryawan.jTabbedPane2.remove(formKaryawan.jPanel2);
    }
    
    public void buttonEdit(){
        
        formKaryawan.jTabbedPane2.setVisible(true);
        formKaryawan.jTabbedPane2.remove(formKaryawan.jPanel2);
        formKaryawan.jTabbedPane2.add("Edit Data", formKaryawan.jPanel3);
        formKaryawan.jTabbedPane2.remove(formKaryawan.jPanel2);
        int row = formKaryawan.tabelKaryawan.getSelectedRow();
        Karyawan k = karyawanDaoImpl.findByNik(formKaryawan.tabelKaryawan.getValueAt(row, 0).toString());
        if(k != null){
            formKaryawan.fieldNik.setEditable(false);
            formKaryawan.fieldNik.setText(k.getNik());
            formKaryawan.fieldNama.setText(k.getNama());
            formKaryawan.fieldAlamat.setText(k.getAlamat());
            formKaryawan.fieldStatusKerja.setSelectedItem(k.getStatusKerja());
            formKaryawan.fieldStatus.setSelectedItem(k.getStatus());
            formKaryawan.fieldPernikahan.setSelectedItem(k.getStatusPernikahan());
            formKaryawan.fieldJenisKelamin.setSelectedItem(k.getJenisKelamin());
            try {
                formKaryawan.fieldTanggalLahir.setDate(sdf.parse(k.getTanggalLahir()));
                formKaryawan.fieldTanggalGabung.setDate(sdf.parse(k.getTanggalBergabung()));
                if(k.getTanggalTerminate() != null){
                    formKaryawan.fieldTanggalTerminate.setDate(sdf.parse(k.getTanggalTerminate()));
                }
               
            } catch (ParseException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            formKaryawan.fieldEmail.setText(k.getEmail());
            formKaryawan.fieldTelpon.setText(k.getTelpon());
        }
    }
    
    public void buttonDelete(){
        int row = formKaryawan.tabelKaryawan.getSelectedRow();
        karyawanDaoImpl.hapus(formKaryawan.tabelKaryawan.getValueAt(row, 0).toString());
        loadDefault();
    }
    

    public void tableClickView(){
        formKaryawan.fieldAlamatView.setEditable(false);
        formKaryawan.btnEdit.setEnabled(true);
        formKaryawan.btnHapus.setEnabled(true);
        formKaryawan.jTabbedPane2.setVisible(true);
        formKaryawan.jTabbedPane2.add("Informasi", formKaryawan.jPanel2);
        formKaryawan.jTabbedPane2.remove(formKaryawan.jPanel3);
        int baris = formKaryawan.tabelKaryawan.getSelectedRow();
        Karyawan k = karyawanDaoImpl.findByNik(formKaryawan.tabelKaryawan.getValueAt(baris, 0).toString());
        if(k != null){
            formKaryawan.lblNik.setText(k.getNik());
            formKaryawan.lblNama.setText(k.getNama());
            formKaryawan.fieldAlamatView.setText(k.getAlamat());
            formKaryawan.lblStatusKerja.setText(k.getStatusKerja());
            formKaryawan.lblStatus.setText(k.getStatus());
            formKaryawan.lblPernikahan.setText(k.getStatusPernikahan());
            formKaryawan.lblTanggalLhir.setText(k.getTanggalLahir());
            formKaryawan.lblEmail.setText(k.getEmail());
            formKaryawan.lblTelpon.setText(k.getTelpon());
            formKaryawan.lblTanggalBergabung.setText(k.getTanggalBergabung());
            formKaryawan.lblTanggalTerminate.setText(k.getTanggalTerminate());
            formKaryawan.lblJenisKelamin.setText(k.getJenisKelamin());
            formKaryawan.lblAtasanView.setText(k.getAtasan_nik());
        }
    }

    public void clear(){
        formKaryawan.fieldNik.setText(null);
        formKaryawan.fieldNama.setText(null);
        formKaryawan.fieldAlamat.setText(null);
        formKaryawan.fieldEmail.setText(null);
        formKaryawan.fieldTelpon.setText(null);
        formKaryawan.fieldJenisKelamin.setSelectedIndex(0);
        formKaryawan.fieldPernikahan.setSelectedIndex(0);
        formKaryawan.fieldStatusKerja.setSelectedIndex(0);
        formKaryawan.fieldStatus.setSelectedIndex(0);
        formKaryawan.fieldTanggalGabung.setDate(null);
        formKaryawan.fieldTanggalLahir.setDate(null);
        formKaryawan.fieldTanggalTerminate.setDate(null);
    }
    
    public void comboboxListAtasan(){
        List<Karyawan> listKaryawans = karyawanDaoImpl.getAll();
        if(formKaryawan.fieldAtasanNik.getItemCount() != 0){
            formKaryawan.fieldAtasanNik.removeAllItems(); 
            formKaryawan.fieldAtasanNik.addItem("---Pilih Atasan---");
        }
        if(listKaryawans != null){
            for(Karyawan k : listKaryawans){
                formKaryawan.fieldAtasanNik.addItem(k.getNik()+"|"+k.getNama()); 
            } 
        }
    }
    
}
