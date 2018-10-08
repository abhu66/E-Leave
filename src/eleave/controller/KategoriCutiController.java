/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.controller;

import eleave.daoImpl.KategoriCutiDaoImpl;
import eleave.model.KategoriCuti;
import eleave.setting.ui.Base;
import eleave.view.hrd.FormKategoriCuti;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoerulAbu
 */
public class KategoriCutiController extends Base{
    private final KategoriCutiDaoImpl kategoriCutiDaoImpl = new KategoriCutiDaoImpl();
    private KategoriCuti kategoriCuti;
    public FormKategoriCuti formKategoriCuti;
    
    
    public void loadDefault(){
        Tabel();
        formKategoriCuti.jTabbedPane2.setVisible(false);
        clear();
    }
   
    public void Simpan(){
        if(validasiFieldForm()){
            kategoriCuti = new KategoriCuti();
            kategoriCuti.setNama(formKategoriCuti.jTextField2.getText());
            System.out.println("Test1 " +formKategoriCuti.jTextField2.getText());
            System.out.println("Test " +formKategoriCuti.jTextField3.getText());
            if(!formKategoriCuti.jTextField3.getText().isEmpty() || formKategoriCuti.jTextField3.getText() != null){
                kategoriCuti.setMasaBerlaku(Integer.valueOf(formKategoriCuti.jTextField3.getText())); 
            }
            else{
                kategoriCuti.setMasaBerlaku(null);
            }
            kategoriCuti.setDeskripsi(formKategoriCuti.jTextArea2.getText());
            kategoriCuti.setJenisKelamin(formKategoriCuti.jComboBox2.getSelectedItem().toString());
            kategoriCuti.setTipeMasaKerja(formKategoriCuti.jComboBox3.getSelectedItem().toString());
            kategoriCuti.setMasaKerja(Integer.valueOf(formKategoriCuti.jTextField4.getText()));
            kategoriCuti.setStatusKaryawan(formKategoriCuti.jComboBox4.getSelectedItem().toString());
            kategoriCuti.setStatus(formKategoriCuti.jComboBox5.getSelectedItem().toString());
            kategoriCutiDaoImpl.simpan(kategoriCuti);
            loadDefault(); 
        }
        
    }
    
    public void Tabel(){
        List<KategoriCuti> kategoriCutis = kategoriCutiDaoImpl.listByNama(formKategoriCuti.jTextField1.getText());
        String [] header = {"NAMA CUTI","MASA BERLAKU","STATUS"};
        DefaultTableModel tabelModel = new DefaultTableModel(null,header);
        formKategoriCuti.jTable1.setModel(tabelModel);
        for(KategoriCuti kt : kategoriCutis){
            tabelModel.addRow(new Object[]{
                kt.getNama(),
                kt.getMasaBerlaku(),
                kt.getStatus()
            });
        } 
    }
    
   
    public void buttonBuatBaru(){
        formKategoriCuti.jTabbedPane2.setVisible(true);
        formKategoriCuti.jTabbedPane2.add("Data Baru", formKategoriCuti.jPanel3);
        formKategoriCuti.jTabbedPane2.remove(formKategoriCuti.jPanel2);
    }
    public void tableClickView(){
        formKategoriCuti.jTabbedPane2.setVisible(true);
        formKategoriCuti.jTabbedPane2.add("Informasi", formKategoriCuti.jPanel2);
        formKategoriCuti.jTabbedPane2.remove(formKategoriCuti.jPanel3);
        int baris = formKategoriCuti.jTable1.getSelectedRow();
        KategoriCuti kc = kategoriCutiDaoImpl.findByName(formKategoriCuti.jTable1.getValueAt(baris, 0).toString());
        if(kc != null){
            formKategoriCuti.jLabel1.setText(kc.getNama());
            formKategoriCuti.jLabel2.setText(String.valueOf(kc.getMasaBerlaku()));
            formKategoriCuti.jTextArea1.setText(kc.getDeskripsi());
            formKategoriCuti.jLabel4.setText(kc.getJenisKelamin());
            formKategoriCuti.jLabel5.setText(kc.getTipeMasaKerja());
            formKategoriCuti.jLabel3.setText(String.valueOf(kc.getMasaKerja()));
            formKategoriCuti.jLabel6.setText(kc.getStatusKaryawan());
            formKategoriCuti.jLabel7.setText(kc.getStatus());
        }
    }
    public void clear(){
        formKategoriCuti.jTextField1.setText(null);
        formKategoriCuti.jTextField2.setText(null);
        formKategoriCuti.jTextField3.setText(null);
        formKategoriCuti.jTextField4.setText(null);
        formKategoriCuti.jTextArea1.setText(null);
        formKategoriCuti.jComboBox2.setSelectedIndex(0);
        formKategoriCuti.jComboBox3.setSelectedIndex(0);
        formKategoriCuti.jComboBox4.setSelectedIndex(0);
        formKategoriCuti.jComboBox5.setSelectedIndex(0);  
    }
    
    public boolean validasiFieldForm() {
        if (!validateFieldsForm(formKategoriCuti.jTextField2, "Nama tidak boleh kosong !"))
            return false;
        else 
            return true;
    }
    
    public void validasiTipeMasa(){
        if(formKategoriCuti.jComboBox3.getSelectedIndex() == 0){
            formKategoriCuti.jTextField4.setEditable(false);
        }
        else {
            formKategoriCuti.jTextField4.setEditable(true);
        }
    }
    public void validasiNumberOnly(){
        int x;
        try {
        x = Integer.parseInt(formKategoriCuti.jTextField4.getText());
        } 
        catch (NumberFormatException nfe) {
        errors("Number Only");
        formKategoriCuti.jTextField4.setText(null);
        }
    }

    //setter getter
     public KategoriCuti getKategoriCuti() {
        return kategoriCuti;
    }

    public void setKategoriCuti(KategoriCuti kategoriCuti) {
        this.kategoriCuti = kategoriCuti;
    }
    
}
