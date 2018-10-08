/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.controller;

import eleave.daoImpl.KaryawanDaoImpl;
import eleave.daoImpl.KategoriCutiDaoImpl;
import eleave.daoImpl.RiwayatCutiDaoImpl;
import eleave.daoImpl.SendMailDaoImpl;
import eleave.daoImpl.TransaksiCutiDaoImpl;
import eleave.model.Karyawan;
import eleave.model.KategoriCuti;
import eleave.model.RiwayatCuti;
import eleave.model.TransaksiCuti;
import eleave.sendMail.SendMail;
import eleave.setting.ui.Base;
import eleave.setting.ui.ScheduledTask;
import eleave.view.home.FormUtama;
import eleave.view.karyawan.FormApproval;
import eleave.view.karyawan.FormCuti;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khoerulAbu
 */
public class TransaksiCutiController extends  Base{
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final TransaksiCutiDaoImpl transaksiCutiDaoImpl = new TransaksiCutiDaoImpl();
    private final KategoriCutiDaoImpl kategoriCutiDaoImpl = new KategoriCutiDaoImpl();
    private final KaryawanDaoImpl     karyawanDaoImpl = new KaryawanDaoImpl();
    private final RiwayatCutiDaoImpl riwayatCutiDaoImpl = new RiwayatCutiDaoImpl();
    private UserLoginController userLoginController;
    public FormUtama formUtama;
    public FormCuti formCuti;
    public FormApproval formApproval;
    private final SendMail sendMail = new SendMail();
    private final SendMailDaoImpl sendMailDaoImpl = new SendMailDaoImpl();
    public  void loadDefault(){
        Tabel();
        comboboxTipeCuti();
        formCuti.jTabbedPane1.setVisible(false);
        clear();
        ScheduledTask st = new ScheduledTask();
        st.run();
        Thread.interrupted();
    }
    public void loadDefaultApproval(){
        TabelApproval();
        formApproval.jTabbedPane1.setVisible(false);
        formApproval.btnSetujui.setEnabled(false);
        formApproval.btnBatalkan.setEnabled(false);
        formApproval.btnTolak.setEnabled(false);
    }
    public void simpan(){
      //  userLoginController.transaksiCutiController = this;
        TransaksiCuti t = new TransaksiCuti();
        t.setNik_karyawan(karyawan.getNik());
        t.setAtasan_nik(karyawan.getAtasan_nik());
        t.setTanggal_request(sdf.format(formCuti.fieldTanggalRequest.getDate()));
        t.setTanggal_mulai(sdf.format(formCuti.fieldTanggalMulai.getDate()));
        t.setTanggal_selesai(sdf.format(formCuti.fieldTanggalSelesai.getDate()));
        Integer tahun = Integer.valueOf(t.getTanggal_request().substring(0, 4));
        t.setTahun(String.valueOf(tahun));
        String id  = formCuti.fieldTipeCuti.getSelectedItem().toString();
        t.setId_kategoricuti(Integer.valueOf(id.substring(0,id.indexOf("|"))));
        t.setStatus("Submit");
        t.setDeskripsi(formCuti.fieldDeskripsi.getText());
        t.setRemark("");
        t.setTanggalsetuju(null);
        t.setTanggaltolak(null);
        t.setTanggalbatal(null);
        transaksiCutiDaoImpl.simpan(t);
         RiwayatCuti riwayatCuti = new RiwayatCuti();
        riwayatCuti.setNik_karyawan(t.getNik_karyawan());
        riwayatCuti.setTanggal_request(t.getTanggal_request());
        riwayatCuti.setAtasan_nik(t.getAtasan_nik());
        riwayatCuti.setStatus(t.getStatus());
        riwayatCuti.setId_kategoricuti(t.getId_kategoricuti());
        riwayatCuti.setTanggal_selesai(t.getTanggal_selesai());
        riwayatCuti.setTanggal_mulai(t.getTanggal_mulai());
        riwayatCuti.setTanggalSetuju(null);
        riwayatCuti.setTanggalTolak(null);
        riwayatCuti.setTanggalBatal(null);
        System.out.println(t.getId()+1);
        riwayatCuti.setTransaksicuti_id(t.getId()+1);
        //simpan riwayat
        riwayatCutiDaoImpl.saveRiwayatCuti(riwayatCuti);
        loadDefault();
        
        String subject = sendMailDaoImpl.getSubjectRequestCuti("MAIL_SUBJECT_REQUEST_CUTI");
        String content = sendMailDaoImpl.getContentRequestCuti("MAIL_CONTENT_REQUEST_CUTI");
        if(content.contains("{Manager}")){
            content = content.replace("Manager", "Abu Khoerul");
        }
        String mailSmtp = "khoirulabhu@gmail.com";
        sendMail.semdEmail(mailSmtp, subject, content);
        
    }
    public void comboboxTipeCuti(){
        List<KategoriCuti> kategoriCutis = kategoriCutiDaoImpl.listAll();
         if(formCuti.fieldTipeCuti.getItemCount() != 0){
            formCuti.fieldTipeCuti.removeAllItems(); 
            formCuti.fieldTipeCuti.addItem("---Pilih Cuti---");
        }
        if(kategoriCutis != null){
            for(KategoriCuti k : kategoriCutis){
            formCuti.fieldTipeCuti.addItem(k.getId()+"|"+k.getNama()); 
            } 
        }  
    }
     public void Tabel(){
        
        List<TransaksiCuti> transaksiCutis = transaksiCutiDaoImpl.listByNik(karyawan.getNik());
        String [] header = {"ID","NIK","NAMA","NAMMA CUTI","TANGGAL MULAI","TANGGAL SELESAI","STATUS"};
        DefaultTableModel tabelModel = new DefaultTableModel(null,header);
        formCuti.jTable1.setModel(tabelModel);
        for(TransaksiCuti tr : transaksiCutis){
            Karyawan k = karyawanDaoImpl.findByNik(tr.getNik_karyawan());
            KategoriCuti kg = kategoriCutiDaoImpl.findById(tr.getId_kategoricuti());
            tabelModel.addRow(new Object[]{
                tr.getId(),
                tr.getNik_karyawan(),
                k.getNama(),
                kg.getNama(),
                tr.getTanggal_mulai(),
                tr.getTanggal_selesai(),
                tr.getStatus()
            });
        } 
    }
     public void TabelApproval(){
        List<TransaksiCuti> transaksiCutis = transaksiCutiDaoImpl.listByAtasan(karyawan.getNik());
       
        String [] header = {"ID","NIK","NAMA","NAMA CUTI","TANGGAL REQUEST","TANGGAL MULAI","TANGGAL SELESAI","STATUS"};
        DefaultTableModel tabelModel = new DefaultTableModel(null,header);
        formApproval.jTable1.setModel(tabelModel);
        for(TransaksiCuti tr : transaksiCutis){
            Karyawan k = karyawanDaoImpl.findByNik(tr.getNik_karyawan());
            KategoriCuti kg = kategoriCutiDaoImpl.findById(tr.getId_kategoricuti());
            tabelModel.addRow(new Object[]{
                tr.getId(),
                tr.getNik_karyawan(),
                k.getNama(),
                kg.getNama(),
                tr.getTanggal_request(),
                tr.getTanggal_mulai(),
                tr.getTanggal_selesai(),
                tr.getStatus()
            });
        } 
    }
    public void tableClickViewApproval(){
        int baris = formApproval.jTable1.getSelectedRow();
        formApproval.jTabbedPane1.setVisible(true);
        formApproval.jTabbedPane1.add("Informasi", formApproval.jPanel1);
        TransaksiCuti tr = transaksiCutiDaoImpl.findById(Integer.valueOf(formApproval.jTable1.getValueAt(baris, 0).toString()));
        if(tr != null){
            if(tr.getStatus().equalsIgnoreCase("Dibatalkan")){
                formApproval.btnSetujui.setEnabled(false);
                formApproval.btnBatalkan.setEnabled(false);
                formApproval.btnTolak.setEnabled(false);
            }
            else {
                formApproval.btnSetujui.setEnabled(true);
                formApproval.btnBatalkan.setEnabled(true);
                formApproval.btnTolak.setEnabled(true);
            }
            formApproval.lblTanggalRequest.setText(tr.getTanggal_request());
            formApproval.lblTanggalMulai.setText(tr.getTanggal_request());
            formApproval.lblTanggalSelesai.setText(tr.getTanggal_request());
            formApproval.lblTipeCuti.setText(formApproval.jTable1.getValueAt(baris, 3).toString());
            formApproval.lblTanggalRequest.setText(tr.getTanggal_request());
            formApproval.lblStatus.setText(tr.getStatus()); 
        }
    }
    public void tableClickView(){
        int baris = formCuti.jTable1.getSelectedRow();
        formCuti.jTabbedPane1.setVisible(true);
        formCuti.jTabbedPane1.remove(formCuti.jPanel1);
        formCuti.jTabbedPane1.add("Informasi", formCuti.jPanel2);
        
        TransaksiCuti tr = transaksiCutiDaoImpl.findById(Integer.valueOf(formCuti.jTable1.getValueAt(baris, 0).toString()));
        if(tr != null){
            formCuti.lblTanggalRequestView.setText(tr.getTanggal_request());
            formCuti.lblTanggalMulaiView.setText(tr.getTanggal_mulai());
            formCuti.lblTanggalSelesaiView.setText(tr.getTanggal_selesai());
            formCuti.lblTipeCutiView.setText(formCuti.jTable1.getValueAt(baris, 3).toString());
            formCuti.lblTahun.setText(tr.getTahun());
            formCuti.fieldDeskripsiView.setText(tr.getDeskripsi());
        }
    }
     
     public void buttonBuatBaru(){
        loadDefault();
        formCuti.jTabbedPane1.setVisible(true);
        formCuti.jTabbedPane1.add("Data Baru", formCuti.jPanel1);
        formCuti.jTabbedPane1.remove(formCuti.jPanel2);
        formCuti.fieldTanggalRequest.setDate(new Date());
        formCuti.fieldTanggalRequest.setEnabled(false);
    }
     
    public void clear(){
        formCuti.fieldTanggalRequest.setDate(null);
        formCuti.fieldTipeCuti.setSelectedIndex(0);
        formCuti.fieldTanggalMulai.setDate(null);
        formCuti.fieldTanggalSelesai.setDate(null);
        formCuti.fieldDeskripsi.setText(null);
    }
    
    public void tombolSetuju(){
        int baris = formApproval.jTable1.getSelectedRow();
        TransaksiCuti tr = transaksiCutiDaoImpl.findById(Integer.valueOf(formApproval.jTable1.getValueAt(baris, 0).toString()));
        if(!tr.getStatus().equalsIgnoreCase("Disetujui")){
            tr.setStatus("Disetujui");
            tr.setTanggalsetuju(sdf.format(new Date()));
            tr.setTanggaltolak(null);
            tr.setTanggalbatal(null);
            transaksiCutiDaoImpl.update(tr);
           
             //create riwayatcuti
            RiwayatCuti riwayatCuti = riwayatCutiDaoImpl.findByTransaksiCutiId(tr.getId());
            riwayatCuti.setStatus(tr.getStatus());
            riwayatCuti.setTanggalSetuju(sdf.format(new Date()));
            riwayatCuti.setTanggalTolak(riwayatCuti.getTanggalTolak());
            riwayatCuti.setTanggalBatal(riwayatCuti.getTanggalBatal());
            riwayatCuti.setTransaksicuti_id(riwayatCuti.getId());
            riwayatCutiDaoImpl.updateRiwayatCuti(riwayatCuti);
            loadDefaultApproval(); 
            String subject = sendMailDaoImpl.getSubjectRequestCuti("MAIL_SUBJECT_REQUEST_CUTI");
            String content = sendMailDaoImpl.getContentRequestCuti("MAIL_CONTENT_APPROVE_CUTI");
            if(content.contains("{Karyawan}")){
                content = content.replace("{Karyawan}", tr.getNik_karyawan());
            }
            String mailSmtp = "khoirulabhu@gmail.com";
            sendMail.semdEmail(mailSmtp, subject, content);
            }
            else {
                errors("Transaksi sudah disetujui !");
            }
       
    }
    public void tombolTolak(){
        int baris = formApproval.jTable1.getSelectedRow();
        TransaksiCuti tr = transaksiCutiDaoImpl.findById(Integer.valueOf(formApproval.jTable1.getValueAt(baris, 0).toString()));
        if(tr.getStatus().equalsIgnoreCase("Submit")){
            JScrollPane jcs = new JScrollPane();
            JTextArea fieldRemark = new JTextArea();
             fieldRemark.setColumns(20);
             fieldRemark.setRows(5);
             jcs.setViewportView(fieldRemark);
             JOptionPane.showMessageDialog(formUtama, fieldRemark, "Remark",JOptionPane.PLAIN_MESSAGE);
             if(fieldRemark.getText().isEmpty()){
                 errors("Remark tidak boleh kosong !");
             }
             else {
                tr.setRemark(fieldRemark.getText());
                tr.setStatus("Ditolak");
                tr.setTanggalsetuju(tr.getTanggalsetuju());
                tr.setTanggaltolak(sdf.format(new Date()));
                tr.setTanggalbatal(tr.getTanggalbatal());
                transaksiCutiDaoImpl.update(tr);
                RiwayatCuti riwayatCuti = riwayatCutiDaoImpl.findByTransaksiCutiId(tr.getId());
                riwayatCuti.setStatus(tr.getStatus());
                riwayatCuti.setTanggalSetuju(riwayatCuti.getTanggalSetuju());
                riwayatCuti.setTanggalTolak(sdf.format(new Date()));
                riwayatCuti.setTanggalBatal(tr.getTanggalbatal());
                riwayatCuti.setTransaksicuti_id(riwayatCuti.getId());
                riwayatCutiDaoImpl.updateRiwayatCuti(riwayatCuti);
                loadDefaultApproval(); 
             }
        }
        else {
            errors("Hanya Untuk Status Submit");
        }
    }
    public void tombolBatalkan() {
        int baris = formApproval.jTable1.getSelectedRow();
        TransaksiCuti tr = transaksiCutiDaoImpl.findById(Integer.valueOf(formApproval.jTable1.getValueAt(baris, 0).toString()));
        if(tr.getStatus().equalsIgnoreCase("Disetujui")){
            JScrollPane jcs = new JScrollPane();
            JTextArea fieldRemark = new JTextArea();
             fieldRemark.setColumns(20);
             fieldRemark.setRows(5);
             jcs.setViewportView(fieldRemark);
             JOptionPane.showMessageDialog(formUtama, fieldRemark, "Remark",JOptionPane.PLAIN_MESSAGE);
             if(fieldRemark.getText().isEmpty()){
                 errors("Remark tidak boleh kosong !");
             }
             else {
                tr.setRemark(fieldRemark.getText());
                tr.setStatus("Dibatalkan");
                tr.setTanggalsetuju(tr.getTanggalsetuju());
                tr.setTanggaltolak(tr.getTanggaltolak());
                tr.setTanggalbatal(sdf.format(new Date()));
                transaksiCutiDaoImpl.update(tr);
                
                RiwayatCuti riwayatCuti = riwayatCutiDaoImpl.findByTransaksiCutiId(tr.getId());
                riwayatCuti.setStatus(tr.getStatus());
                riwayatCuti.setTanggalSetuju(riwayatCuti.getTanggalSetuju());
                riwayatCuti.setTanggalTolak(riwayatCuti.getTanggalTolak());
                riwayatCuti.setTanggalBatal(sdf.format(new Date()));
                riwayatCuti.setTransaksicuti_id(riwayatCuti.getId());
                riwayatCutiDaoImpl.updateRiwayatCuti(riwayatCuti);
                loadDefaultApproval(); 
             }
        }
        else {
            errors("Hanya Untuk Status Disetujui");
        }
    }
}
