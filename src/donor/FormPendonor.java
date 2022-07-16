/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donor;

//import com.toedter.calendar.JDateChooser;
import petugas.*;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;


//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;
//import laporan.*;

//    String tanggal_daftar = 
//    String no_pendonor = 
//    String nama = 
//    String jenis_kelamin =
//    String tanggal_lahir =
//    String no_telp = 
//    String gmail =
//    String golongan_darah =
//    String usia = 
//    String berat_badan = 
//    String alamat = 
//    String hemoglobin = 
//    String riwayat_penyakit =
//    String jumlah_transfusi = 
//    String tanggal_terakhir_transfusi = 



/**
 *
 * @author albin
 */
public class FormPendonor extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form daftarMenu
     */
    public FormPendonor() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableDataPendonorKelompok2.setModel(table);
        table.addColumn("Tanggal Daftar");//0
        table.addColumn("No. Pendonor");//1
        table.addColumn("Nama");//2
        table.addColumn("Jenis  Kelamin");//3
        table.addColumn("Tanggal Lahir");//4
        table.addColumn("No.Telp");//5
        table.addColumn("Gmail");//6
        table.addColumn("ID darah");//7
        table.addColumn("Golongan Darah");//8
        table.addColumn("Usia");//9
        table.addColumn("Berat Badan");//10
        table.addColumn("Alamat");//11
        table.addColumn("Hemoglobin");//12
        table.addColumn("Riwayat Penyakit");//13
        table.addColumn("Total Donor");//14
        table.addColumn("Tanggal terakhir transfusi");//15
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataPendonorKelompok2.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `data_pendonor`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    String no_pendonor = rslt.getString("no_pendonor");
                    String nama = rslt.getString("nama");
                    String jenis_kelamin = rslt.getString("jenis_kelamin");
                    String tanggal_lahir = rslt.getString("tanggal_lahir");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String id_darah = rslt.getString("id_darah");
                    String golongan_darah = rslt.getString("golongan_darah");
                    String usia = rslt.getString("usia");
                    String berat_badan = rslt.getString("berat_badan");
                    String alamatpendonor = rslt.getString("alamat");
                    String hemoglobin = rslt.getString("hemoglobin");
                    String riwayat_penyakit = rslt.getString("riwayat_penyakit");
                    String total_donor = rslt.getString("total_donor");
                    String tanggal_terakhir_donor = rslt.getString("tanggal_terakhir_donor");
                    
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pendonor,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,id_darah,golongan_darah,usia,berat_badan,alamatpendonor,hemoglobin,riwayat_penyakit,total_donor,tanggal_terakhir_donor};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPendonorKelompok2.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }  

    
    private void clear(){
          //txtTanggalDaftar21552011235.setCalendar(null);
          //*no_pendonor
          txtFieldNamaPendonorKelompok2.setText(null);
          buttonGroup2.clearSelection();
          jDateChooserTanggalLahirKelompok2.setCalendar(null);
          txtFieldNoTelpKelompok2.setText(null);
          txtFieldAkunGmailKelompok2.setText(null);
          txtFieldGolonganDarahKelompok2.setText(null);
          //jComboBoxGolDarah.setSelectedIndex(0);
          txtFieldUsiaKelompok2.setText(null);
          txtFieldBeratBadanKelompok2.setText(null);
          txtFieldAlamatKelompok2.setText(null);
          jComboBoxHemoglobinKelompok2.setSelectedIndex(0);
          txtFieldRiwayatPenyakitKelompok2.setText(null);
          txtFieldTotalDonorKelompok2.setText(null);
          txtFieldIdDarahKelompok2.setText(null);
          txtFieldJumlahLabuKelompok2.setText(null);
          jDateChooserTerakhirDonorKelompok2.setCalendar(null);
    }
    
    
    private void tambahData(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_daftar = date.format(jDateTanggalDaftarKelompok2.getDate());
        //String no_pendonor = 
        String nama = txtFieldNamaPendonorKelompok2.getText();
        String jk;
        if (jRadioButtonLakiLakiKelompok2.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        SimpleDateFormat tgl_lahir = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_lahir = tgl_lahir.format(jDateChooserTanggalLahirKelompok2.getDate());
        String no_telp = txtFieldNoTelpKelompok2.getText();
        String gmail = txtFieldAkunGmailKelompok2.getText();
        String id_darah = txtFieldIdDarahKelompok2.getText();
        String golongan_darah = txtFieldGolonganDarahKelompok2.getText();
        String jumlah_labu = txtFieldJumlahLabuKelompok2.getText();
        //String id_darah = txtFieldDarah21552011235.getText();
        //String golongan_darah = (String) jComboBoxGolDarah.getSelectedItem();
        String usia = txtFieldUsiaKelompok2.getText();
        String berat_badan = txtFieldBeratBadanKelompok2.getText();
        String alamatpendonor = txtFieldAlamatKelompok2.getText();
        String hemoglobin = (String) jComboBoxHemoglobinKelompok2.getSelectedItem();
        String riwayat_penyakit = txtFieldRiwayatPenyakitKelompok2.getText(); 
        String total_donor = txtFieldTotalDonorKelompok2.getText();
        SimpleDateFormat tgl_tt = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_terakhir_donor = tgl_tt.format(jDateChooserTerakhirDonorKelompok2.getDate());
        
        
        //panggil koneksi
        java.sql.Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `data_pendonor` (`tanggal_daftar`,no_pendonor,`id_darah`,`nama`,`jenis_kelamin`,`tanggal_lahir`,`no_telp`,`gmail`,`golongan_darah`,`jumlah_labu`,`usia`,`berat_badan`,`alamat`,`hemoglobin`,`riwayat_penyakit`,`total_donor`,`tanggal_terakhir_donor`) " 
                     + "VALUES ('"+tanggal_daftar+"',NULL,'"+id_darah+"','"+nama+"','"+jk+"','"+tanggal_lahir+"','"+no_telp+"','"+gmail+"','"+golongan_darah+"','"+jumlah_labu+"','"+usia+"','"+berat_badan+"','"+alamatpendonor+"','"+hemoglobin+"','"+riwayat_penyakit+"','"+total_donor+"','"+tanggal_terakhir_donor+"')"; 
        
        try{ 
            //menyiapkan statement untuk di eksekusi
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            tampilData();
            clear();
        }
    }
    
//    private void darahMasuk(){
//        String darah_masuk = "CALL `darah_masuk`()";
//        
//        try{
//            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
//            Statement sttmnt = connect.createStatement();//membuat statement
//            ResultSet rslt = sttmnt.executeQuery(darah_masuk);//menjalanakn query\
//                while(rslt.next()){
//                    txtFieldJumlahLabu21552011235.setText(rslt.getString(1));
//                }
//                
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//    }
    
    private void tanggal(){
        Date now = new Date();  
        jDateTanggalDaftarKelompok2.setDate(now);    
    }
    
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tableDataPendonorKelompok2.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data ?","Konfirmasi Hapus Data Pendonor ", JOptionPane.YES_NO_OPTION);
        
        if (ok==0){
            String no_pendonor = table.getValueAt(i, 1).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "DELETE FROM `data_pendonor` WHERE `data_pendonor`.`no_pendonor` = "+no_pendonor+" ";
            //String sql="delete from tb_barang where kode_part='"+txtKodePart.getText()+"'";
            try {
                PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
                ps.execute();
                JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
            }finally{
                tampilData();
                clear();
            }
        }
    }
    
    
    private void editData(){
        int i = tableDataPendonorKelompok2.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Mengedit Data ?","Konfirmasi Edit Pendonor", JOptionPane.YES_NO_OPTION);
        
        //SimpleDateFormat tgl_daftar = new SimpleDateFormat("yyyy-MM-dd");
       // String tanggal_daftar = tgl_daftar.format(jDateTanggalDaftar21552011235.getDate());
        //String no_pendonor = table.getValueAt(i, 1).toString();
        String nama = txtFieldNamaPendonorKelompok2.getText();
        String jk;
        if (jRadioButtonLakiLakiKelompok2.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        SimpleDateFormat tgl_lahir = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_lahir = tgl_lahir.format(jDateChooserTanggalLahirKelompok2.getDate());
        String no_telp = txtFieldNoTelpKelompok2.getText();
        String gmail = txtFieldAkunGmailKelompok2.getText();
        String id_darah = txtFieldIdDarahKelompok2.getText();
        String golongan_darah = txtFieldGolonganDarahKelompok2.getText();
        String jumlah_labu = txtFieldJumlahLabuKelompok2.getText();
        //String golongan_darah = (String) jComboBoxGolDarah.getSelectedItem();
        String usia = txtFieldUsiaKelompok2.getText();
        String berat_badan = txtFieldBeratBadanKelompok2.getText();
        String alamatpendonor = txtFieldAlamatKelompok2.getText();
        String hemoglobin = (String) jComboBoxHemoglobinKelompok2.getSelectedItem();
        String riwayat_penyakit = txtFieldRiwayatPenyakitKelompok2.getText(); 
        String total_donor = txtFieldTotalDonorKelompok2.getText();
        SimpleDateFormat tgl_tt = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_terakhir_donor = tgl_tt.format(jDateChooserTerakhirDonorKelompok2.getDate());
        
        if (ok==0){
            String no_pendonor = table.getValueAt(i, 1).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "UPDATE `data_pendonor` SET `nama` = '"+nama+"',`jenis_kelamin` = '"+jk+"', `tanggal_lahir` = '"+tanggal_lahir+"',`no_telp` = '"+no_telp+"',`gmail` = '"+gmail+"',`id_darah` = '"+id_darah+"',`golongan_darah` = '"+golongan_darah+"',`jumlah_labu` = '"+jumlah_labu+"',`usia` = '"+usia+"',`berat_badan` = '"+berat_badan+"',`alamat` = '"+alamatpendonor+"',`hemoglobin` = '"+hemoglobin+"',`riwayat_penyakit` = '"+riwayat_penyakit+"',`total_donor` = '"+total_donor+"',`tanggal_terakhir_donor` = '"+tanggal_terakhir_donor+"'"
                + "WHERE `data_pendonor`.`no_pendonor` = '"+no_pendonor+"';";
            //String sql="delete from tb_barang where kode_part='"+txtKodePart.getText()+"'";
            try {
                PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
                ps.execute(query);
                JOptionPane.showMessageDialog(null , "Data Berhasil Di Edit");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Edit!!!"+e);
            }finally{
                tampilData();
                clear();
            }
        }   
    }
    
  
        
       
    private void cari(){
        int row = tableDataPendonorKelompok2.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
      String cari = txtFieldCariKelompok2.getText();
      String query = "SELECT * FROM `data_pendonor` WHERE "
                + "`tanggal_daftar` LIKE '%"+cari+"%' OR"
                + "`no_pendonor`  LIKE '%"+cari+"%' OR "
                + "`nama` LIKE '%"+cari+"%' OR"
                + "`jenis_kelamin` LIKE '%"+cari+"%' OR"
                + "`tanggal_lahir` LIKE '%"+cari+"%' OR"
                + "`no_telp` LIKE '%"+cari+"%' OR"
                + "`gmail` LIKE '%"+cari+"%' OR"
                + "`golongan_darah` LIKE '%"+cari+"%' OR"
                + "`usia` LIKE '%"+cari+"%' OR"
                + "`berat_badan` LIKE '%"+cari+"%' OR"
                + "`alamat` LIKE '%"+cari+"%' OR"
                + "`hemoglobin` LIKE '%"+cari+"%' OR"
                + "`riwayat_penyakit` LIKE '%"+cari+"%' OR"
                + "`total_donor` LIKE '%"+cari+"%' OR"
                + "`tanggal_terakhir_donor` LIKE '%"+cari+"%' ";
                
       try{
           java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    String no_pendonor = rslt.getString("no_pendonor");
                    String nama = rslt.getString("nama");
                    String jenis_kelamin = rslt.getString("jenis_kelamin");
                    String tanggal_lahir = rslt.getString("tanggal_lahir");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String golongan_darah = rslt.getString("golongan_darah");
                    String usia = rslt.getString("usia");
                    String berat_badan = rslt.getString("berat_badan");
                    String alamatpendonor = rslt.getString("alamat");
                    String hemoglobin = rslt.getString("hemoglobin");
                    String riwayat_penyakit = rslt.getString("riwayat_penyakit");
                    String total_donor = rslt.getString("total_donor");
                    String tanggal_terakhir_donor = rslt.getString("tanggal_terakhir_donor");
                    
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pendonor,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,golongan_darah,usia,berat_badan,alamatpendonor,hemoglobin,riwayat_penyakit,total_donor,tanggal_terakhir_donor};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPendonorKelompok2.setModel(table);
                
    }catch(SQLException e){
           System.out.println(e);
    }
  }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param hover
     * @param rand
     */
    @SuppressWarnings("unchecked")
    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        Navbar = new javax.swing.JPanel();
        PanelHelpKelompok2 = new javax.swing.JPanel();
        BtnHelpKelompok2 = new javax.swing.JLabel();
        PanelBackKelompok2 = new javax.swing.JPanel();
        BtnBackKelompok2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PanelAddKelompok2 = new javax.swing.JPanel();
        BtnAddKelompok2 = new javax.swing.JLabel();
        NamaPendonor = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        golDarah = new javax.swing.JLabel();
        TotalHarga = new javax.swing.JLabel();
        PanelClearKelompok2 = new javax.swing.JPanel();
        BtnClearKelompok2 = new javax.swing.JLabel();
        PanelRefreshKelompok2 = new javax.swing.JPanel();
        BtnRefreshKelompok2 = new javax.swing.JLabel();
        PanelDeleteKelompok2 = new javax.swing.JPanel();
        BtnDeleteKelompok2 = new javax.swing.JLabel();
        PanelEditKelompok2 = new javax.swing.JPanel();
        BtnEditKelompok2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataPendonorKelompok2 = new javax.swing.JTable();
        jComboBoxHemoglobinKelompok2 = new javax.swing.JComboBox<>();
        txtFieldNamaPendonorKelompok2 = new javax.swing.JTextField();
        line9 = new javax.swing.JLabel();
        txtFieldNoTelpKelompok2 = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        line10 = new javax.swing.JLabel();
        txtFieldAlamatKelompok2 = new javax.swing.JTextField();
        alamat = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        txtFieldAkunGmailKelompok2 = new javax.swing.JTextField();
        kondisi = new javax.swing.JLabel();
        kondisi1 = new javax.swing.JLabel();
        line11 = new javax.swing.JLabel();
        txtFieldTotalDonorKelompok2 = new javax.swing.JTextField();
        jumlahTransfusi = new javax.swing.JLabel();
        line13 = new javax.swing.JLabel();
        txtFieldUsiaKelompok2 = new javax.swing.JTextField();
        alamat1 = new javax.swing.JLabel();
        line14 = new javax.swing.JLabel();
        txtFieldRiwayatPenyakitKelompok2 = new javax.swing.JTextField();
        alamat2 = new javax.swing.JLabel();
        line15 = new javax.swing.JLabel();
        txtFieldBeratBadanKelompok2 = new javax.swing.JTextField();
        BeartBadan = new javax.swing.JLabel();
        jDateChooserTerakhirDonorKelompok2 = new com.toedter.calendar.JDateChooser();
        jDateChooserTanggalLahirKelompok2 = new com.toedter.calendar.JDateChooser();
        jDateTanggalDaftarKelompok2 = new com.toedter.calendar.JDateChooser();
        line16 = new javax.swing.JLabel();
        txtFieldCariKelompok2 = new javax.swing.JTextField();
        PanelDarahKelompok2 = new javax.swing.JPanel();
        BtnDarahKelompok2 = new javax.swing.JLabel();
        PanelCariKelompok2 = new javax.swing.JPanel();
        BtnCariKelompok2 = new javax.swing.JLabel();
        NamaPendonor1 = new javax.swing.JLabel();
        jRadioButtonLakiLakiKelompok2 = new javax.swing.JRadioButton();
        jRadioButtonPerempuanKelompok2 = new javax.swing.JRadioButton();
        line19 = new javax.swing.JLabel();
        line22 = new javax.swing.JLabel();
        line20 = new javax.swing.JLabel();
        txtFieldIdDarahKelompok2 = new javax.swing.JTextField();
        tanggalLahir1 = new javax.swing.JLabel();
        txtFieldGolonganDarahKelompok2 = new javax.swing.JTextField();
        jumlahlabu = new javax.swing.JLabel();
        Goldarah = new javax.swing.JLabel();
        IDdarah = new javax.swing.JLabel();
        txtFieldJumlahLabuKelompok2 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(32, 83, 117));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navbar.setBackground(new java.awt.Color(32, 83, 117));
        Navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelHelpKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        PanelHelpKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnHelpKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnHelpKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnHelpKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnHelpKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-help-48_1.png"))); // NOI18N
        BtnHelpKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnHelpKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnHelpKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnHelpKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnHelpKelompok2MouseExited(evt);
            }
        });
        PanelHelpKelompok2.add(BtnHelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        Navbar.add(PanelHelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 100, 60));

        PanelBackKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        PanelBackKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBackKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnBackKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnBackKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBackKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-back-48.png"))); // NOI18N
        BtnBackKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBackKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBackKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBackKelompok2MouseExited(evt);
            }
        });
        PanelBackKelompok2.add(BtnBackKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        Navbar.add(PanelBackKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText(" Form Pendonor");
        Navbar.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 390, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        jPanel3.setBackground(new java.awt.Color(17, 43, 60));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAddKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelAddKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelAddKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAddKelompok2.setBackground(new java.awt.Color(255, 255, 255));
        BtnAddKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAddKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAddKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-plus-+-24.png"))); // NOI18N
        BtnAddKelompok2.setText("Add Data");
        BtnAddKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAddKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAddKelompok2MouseExited(evt);
            }
        });
        PanelAddKelompok2.add(BtnAddKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 50));

        jPanel3.add(PanelAddKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 610, 50));

        NamaPendonor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor.setText("Jenis Kelamin");
        jPanel3.add(NamaPendonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 100, 50));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("___________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, 20));

        golDarah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        golDarah.setForeground(new java.awt.Color(255, 255, 255));
        golDarah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        golDarah.setText("Terakhir Tanggal Donor *opsional");
        jPanel3.add(golDarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 250, 30));

        TotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        TotalHarga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalHarga.setText("Tanggal");
        TotalHarga.setToolTipText("");
        jPanel3.add(TotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 40));

        PanelClearKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelClearKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelClearKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnClearKelompok2.setBackground(new java.awt.Color(255, 255, 255));
        BtnClearKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnClearKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnClearKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnClearKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-minus-sign-24.png"))); // NOI18N
        BtnClearKelompok2.setText("Clear Form");
        BtnClearKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnClearKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnClearKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnClearKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnClearKelompok2MouseExited(evt);
            }
        });
        PanelClearKelompok2.add(BtnClearKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelClearKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 430, 290, 50));

        PanelRefreshKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelRefreshKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelRefreshKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnRefreshKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnRefreshKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnRefreshKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnRefreshKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-available-updates-24.png"))); // NOI18N
        BtnRefreshKelompok2.setText("Refresh");
        BtnRefreshKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRefreshKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRefreshKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRefreshKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRefreshKelompok2MouseExited(evt);
            }
        });
        PanelRefreshKelompok2.add(BtnRefreshKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelRefreshKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 240, 290, 50));

        PanelDeleteKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelDeleteKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDeleteKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDeleteKelompok2.setBackground(new java.awt.Color(255, 255, 255));
        BtnDeleteKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDeleteKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeleteKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnDeleteKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-trash-24.png"))); // NOI18N
        BtnDeleteKelompok2.setText("Delete Data");
        BtnDeleteKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeleteKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDeleteKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnDeleteKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnDeleteKelompok2MouseExited(evt);
            }
        });
        PanelDeleteKelompok2.add(BtnDeleteKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelDeleteKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 510, 290, 50));

        PanelEditKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelEditKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelEditKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnEditKelompok2.setBackground(new java.awt.Color(255, 255, 255));
        BtnEditKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEditKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnEditKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-edit-24.png"))); // NOI18N
        BtnEditKelompok2.setText("Edit Data");
        BtnEditKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEditKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEditKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEditKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEditKelompok2MouseExited(evt);
            }
        });
        PanelEditKelompok2.add(BtnEditKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelEditKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 290, 50));

        tableDataPendonorKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tableDataPendonorKelompok2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataPendonorKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableDataPendonorKelompok2.setSelectionBackground(new java.awt.Color(32, 83, 117));
        tableDataPendonorKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPendonorKelompok2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataPendonorKelompok2);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1320, 130));

        jComboBoxHemoglobinKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxHemoglobinKelompok2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- pilih --", "Baik", "Cukup", "Kurang" }));
        jComboBoxHemoglobinKelompok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHemoglobinKelompok2ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxHemoglobinKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 240, 40));

        txtFieldNamaPendonorKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaPendonorKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaPendonorKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaPendonorKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaPendonorKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaPendonorKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("___________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 20));

        txtFieldNoTelpKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNoTelpKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNoTelpKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNoTelpKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNoTelpKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNoTelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 250, 40));

        noTelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noTelp.setForeground(new java.awt.Color(255, 255, 255));
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noTelp.setText("No Telephone");
        jPanel3.add(noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 40));

        line10.setBackground(new java.awt.Color(255, 255, 255));
        line10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line10.setForeground(new java.awt.Color(255, 255, 255));
        line10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line10.setText("___________________________");
        jPanel3.add(line10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 250, 20));

        txtFieldAlamatKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAlamatKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAlamatKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAlamatKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAlamatKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAlamatKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 250, 40));

        alamat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat.setText("Alamat");
        jPanel3.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 120, 40));

        line12.setBackground(new java.awt.Color(255, 255, 255));
        line12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line12.setForeground(new java.awt.Color(255, 255, 255));
        line12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line12.setText("___________________________");
        jPanel3.add(line12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 260, 20));

        txtFieldAkunGmailKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAkunGmailKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAkunGmailKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAkunGmailKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAkunGmailKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAkunGmailKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 260, 40));

        kondisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi.setForeground(new java.awt.Color(255, 255, 255));
        kondisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi.setText("Gmail");
        jPanel3.add(kondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 120, 40));

        kondisi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi1.setForeground(new java.awt.Color(255, 255, 255));
        kondisi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi1.setText("Hemoglobin");
        jPanel3.add(kondisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 130, 30));

        line11.setBackground(new java.awt.Color(255, 255, 255));
        line11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line11.setForeground(new java.awt.Color(255, 255, 255));
        line11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line11.setText("___________________________");
        jPanel3.add(line11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 260, 20));

        txtFieldTotalDonorKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldTotalDonorKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldTotalDonorKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldTotalDonorKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldTotalDonorKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldTotalDonorKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 260, 40));

        jumlahTransfusi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jumlahTransfusi.setForeground(new java.awt.Color(255, 255, 255));
        jumlahTransfusi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahTransfusi.setText("Total Donor");
        jPanel3.add(jumlahTransfusi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 240, 40));

        line13.setBackground(new java.awt.Color(255, 255, 255));
        line13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line13.setForeground(new java.awt.Color(255, 255, 255));
        line13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line13.setText("___________");
        jPanel3.add(line13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 100, 20));

        txtFieldUsiaKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldUsiaKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldUsiaKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldUsiaKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldUsiaKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldUsiaKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, 40));

        alamat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat1.setForeground(new java.awt.Color(255, 255, 255));
        alamat1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat1.setText("Usia");
        jPanel3.add(alamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, 40));

        line14.setBackground(new java.awt.Color(255, 255, 255));
        line14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line14.setForeground(new java.awt.Color(255, 255, 255));
        line14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line14.setText("___________________________");
        jPanel3.add(line14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 250, 20));

        txtFieldRiwayatPenyakitKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldRiwayatPenyakitKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldRiwayatPenyakitKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldRiwayatPenyakitKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldRiwayatPenyakitKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldRiwayatPenyakitKelompok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldRiwayatPenyakitKelompok2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldRiwayatPenyakitKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 240, 40));

        alamat2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat2.setForeground(new java.awt.Color(255, 255, 255));
        alamat2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat2.setText("Riwayat Penyakit");
        jPanel3.add(alamat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 120, 40));

        line15.setBackground(new java.awt.Color(255, 255, 255));
        line15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line15.setForeground(new java.awt.Color(255, 255, 255));
        line15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line15.setText("___________");
        jPanel3.add(line15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 100, 20));

        txtFieldBeratBadanKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldBeratBadanKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldBeratBadanKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldBeratBadanKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldBeratBadanKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldBeratBadanKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 100, 40));

        BeartBadan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BeartBadan.setForeground(new java.awt.Color(255, 255, 255));
        BeartBadan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BeartBadan.setText("Berat Badan *Kg");
        jPanel3.add(BeartBadan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 110, 40));

        jDateChooserTerakhirDonorKelompok2.setDateFormatString("yyyy-MM-dd");
        jDateChooserTerakhirDonorKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jDateChooserTerakhirDonorKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 240, 40));

        jDateChooserTanggalLahirKelompok2.setDateFormatString("yyyy-MM-dd");
        jDateChooserTanggalLahirKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jDateChooserTanggalLahirKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 240, 40));

        jDateTanggalDaftarKelompok2.setDateFormatString("d MMM, yyyy");
        jDateTanggalDaftarKelompok2.setEnabled(false);
        jDateTanggalDaftarKelompok2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jDateTanggalDaftarKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateTanggalDaftarKelompok2MouseClicked(evt);
            }
        });
        jPanel3.add(jDateTanggalDaftarKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 180, 40));

        line16.setBackground(new java.awt.Color(255, 255, 255));
        line16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line16.setForeground(new java.awt.Color(255, 255, 255));
        line16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        line16.setText("_________________");
        jPanel3.add(line16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, 180, 20));

        txtFieldCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCariKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCariKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCariKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCariKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 140, 150, 50));

        PanelDarahKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelDarahKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDarahKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDarahKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDarahKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnDarahKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnDarahKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-rh+-48.png"))); // NOI18N
        BtnDarahKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDarahKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDarahKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnDarahKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnDarahKelompok2MouseExited(evt);
            }
        });
        PanelDarahKelompok2.add(BtnDarahKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 150));

        jPanel3.add(PanelDarahKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 70, 150));

        PanelCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelCariKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCariKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnCariKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnCariKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnCariKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-search-24.png"))); // NOI18N
        BtnCariKelompok2.setText("Cari Data");
        BtnCariKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCariKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCariKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCariKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCariKelompok2MouseExited(evt);
            }
        });
        PanelCariKelompok2.add(BtnCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel3.add(PanelCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 130, 50));

        NamaPendonor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor1.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor1.setText("Nama");
        jPanel3.add(NamaPendonor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 40));

        jRadioButtonLakiLakiKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup2.add(jRadioButtonLakiLakiKelompok2);
        jRadioButtonLakiLakiKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonLakiLakiKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonLakiLakiKelompok2.setText("Laki-laki");
        jRadioButtonLakiLakiKelompok2.setActionCommand("");
        jPanel3.add(jRadioButtonLakiLakiKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        jRadioButtonPerempuanKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup2.add(jRadioButtonPerempuanKelompok2);
        jRadioButtonPerempuanKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonPerempuanKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPerempuanKelompok2.setText("Perempuan");
        jRadioButtonPerempuanKelompok2.setActionCommand("");
        jPanel3.add(jRadioButtonPerempuanKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        line19.setBackground(new java.awt.Color(255, 255, 255));
        line19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line19.setForeground(new java.awt.Color(255, 255, 255));
        line19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line19.setText("_________________");
        jPanel3.add(line19, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 160, 20));

        line22.setBackground(new java.awt.Color(255, 255, 255));
        line22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line22.setForeground(new java.awt.Color(255, 255, 255));
        line22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line22.setText("______");
        jPanel3.add(line22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 60, 20));

        line20.setBackground(new java.awt.Color(255, 255, 255));
        line20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line20.setForeground(new java.awt.Color(255, 255, 255));
        line20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line20.setText("__________");
        jPanel3.add(line20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 90, 20));

        txtFieldIdDarahKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldIdDarahKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldIdDarahKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldIdDarahKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldIdDarahKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldIdDarahKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldIdDarahKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 60, 50));

        tanggalLahir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir1.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir1.setText("Tanggal Lahir");
        jPanel3.add(tanggalLahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 120, 30));

        txtFieldGolonganDarahKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldGolonganDarahKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldGolonganDarahKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldGolonganDarahKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldGolonganDarahKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldGolonganDarahKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldGolonganDarahKelompok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldGolonganDarahKelompok2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldGolonganDarahKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 90, 50));

        jumlahlabu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jumlahlabu.setForeground(new java.awt.Color(255, 255, 255));
        jumlahlabu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahlabu.setText("Jumlah Labu");
        jPanel3.add(jumlahlabu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 100, 50));

        Goldarah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Goldarah.setForeground(new java.awt.Color(255, 255, 255));
        Goldarah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Goldarah.setText("Gol_darah");
        jPanel3.add(Goldarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 100, 30));

        IDdarah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IDdarah.setForeground(new java.awt.Color(255, 255, 255));
        IDdarah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IDdarah.setText("ID");
        jPanel3.add(IDdarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 40, 30));

        txtFieldJumlahLabuKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldJumlahLabuKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlahLabuKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlahLabuKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldJumlahLabuKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlahLabuKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldJumlahLabuKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 160, 50));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hexa-shape.png"))); // NOI18N
        jPanel3.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 1390, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1382, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackKelompok2MouseClicked
        new petugas.dashboardPetugas().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBackKelompok2MouseClicked

    private void BtnBackKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackKelompok2MouseEntered
        changecolor(PanelBackKelompok2, new Color (255,24,24));
    }//GEN-LAST:event_BtnBackKelompok2MouseEntered

    private void BtnBackKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackKelompok2MouseExited
        changecolor(PanelBackKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnBackKelompok2MouseExited

    private void BtnEditKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditKelompok2MouseClicked
        editData();
    }//GEN-LAST:event_BtnEditKelompok2MouseClicked

    private void BtnEditKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditKelompok2MouseEntered
        changecolor(PanelEditKelompok2, new Color (255,209,36));
    }//GEN-LAST:event_BtnEditKelompok2MouseEntered

    private void BtnEditKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditKelompok2MouseExited
        changecolor(PanelEditKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnEditKelompok2MouseExited

    private void BtnAddKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddKelompok2MouseClicked
      tambahData();
    }//GEN-LAST:event_BtnAddKelompok2MouseClicked

    private void BtnAddKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddKelompok2MouseEntered
      changecolor(PanelAddKelompok2, new Color (78,159,61));
    }//GEN-LAST:event_BtnAddKelompok2MouseEntered

    private void BtnAddKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddKelompok2MouseExited
      changecolor(PanelAddKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnAddKelompok2MouseExited

    private void BtnClearKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClearKelompok2MouseClicked
      clear();
    }//GEN-LAST:event_BtnClearKelompok2MouseClicked

    private void BtnClearKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClearKelompok2MouseEntered
      changecolor(PanelClearKelompok2, new Color (246,107,14));
    }//GEN-LAST:event_BtnClearKelompok2MouseEntered

    private void BtnClearKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClearKelompok2MouseExited
      changecolor(PanelClearKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnClearKelompok2MouseExited

    private void BtnDeleteKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteKelompok2MouseClicked
      hapusData();
    }//GEN-LAST:event_BtnDeleteKelompok2MouseClicked

    private void BtnDeleteKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteKelompok2MouseEntered
      changecolor(PanelDeleteKelompok2, new Color (255,24,24));
    }//GEN-LAST:event_BtnDeleteKelompok2MouseEntered

    private void BtnDeleteKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteKelompok2MouseExited
      changecolor(PanelDeleteKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnDeleteKelompok2MouseExited

    private void BtnRefreshKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseClicked
      tampilData();
    }//GEN-LAST:event_BtnRefreshKelompok2MouseClicked

    private void BtnRefreshKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseEntered
      changecolor(PanelRefreshKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnRefreshKelompok2MouseEntered

    private void BtnRefreshKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseExited
      changecolor(PanelRefreshKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnRefreshKelompok2MouseExited

    private void tableDataPendonorKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPendonorKelompok2MouseClicked
        // TODO add your handling code here:
          int baris = tableDataPendonorKelompok2.getSelectedRow();
          
          //String tanggal_daftar = table.getValueAt(baris,0).toString(); 
          
          //String no_pendonor = table.getValueAt(baris,1).toString();
          String nama = table.getValueAt(baris,2).toString();
          txtFieldNamaPendonorKelompok2.setText(nama);
          
          String jenis_kelamin = table.getValueAt(baris,3).toString();
          if (jenis_kelamin.equals("Laki-laki")){
              jRadioButtonPerempuanKelompok2.setSelected(true);
          } else {
              jRadioButtonLakiLakiKelompok2.setSelected(true);
          }
          
          String no_telp = table.getValueAt(baris,5).toString();
          txtFieldNoTelpKelompok2.setText(no_telp);
          
          String gmail = table.getValueAt(baris,6).toString();
          txtFieldAkunGmailKelompok2.setText(gmail);
          
          String id_darah = table.getValueAt(baris,7).toString();
          txtFieldIdDarahKelompok2.setText(id_darah);
          
          String golongan_darah = table.getValueAt(baris,8).toString();
          txtFieldGolonganDarahKelompok2.setText(golongan_darah);
          
          String usia = table.getValueAt(baris,9).toString();
          txtFieldUsiaKelompok2.setText(usia);
          
          String berat_badan =  table.getValueAt(baris,10).toString();
          txtFieldBeratBadanKelompok2.setText(berat_badan);
          
          String alamatpendonor =  table.getValueAt(baris,11).toString();
          txtFieldAlamatKelompok2.setText(alamatpendonor);
          
          //String hemoglobin =  table.getValueAt(baris,11).toString();
          String hemoglobin = table.getValueAt(baris,12).toString();
          for (int i = 0; i <jComboBoxHemoglobinKelompok2.getItemCount(); i++ ){
              if (jComboBoxHemoglobinKelompok2.getItemAt(i).equalsIgnoreCase(hemoglobin)){
                  jComboBoxHemoglobinKelompok2.setSelectedIndex(i);
              }
          }
          
          String riwayat_penyakit =  table.getValueAt(baris,13).toString();
          txtFieldRiwayatPenyakitKelompok2.setText(riwayat_penyakit);
          
          String total_donor = table.getValueAt(baris,14).toString();
          txtFieldTotalDonorKelompok2.setText(total_donor);
         

       
        //Date convert = null;
        Date tanggal_lahir = null;
        Object tanggal_terakhir_transfusi = null;
        Object ex = null;
        try{
            //convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_daftar);
            tanggal_lahir = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(baris,4));
            tanggal_terakhir_transfusi = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(baris,15));
        }catch(ParseException e){  
            System.out.println(e);
            Logger.getLogger(FormPendonor.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FormPendonor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //jDateTanggalDaftar21552011235.setDate(convert);
        jDateChooserTanggalLahirKelompok2.setDate(tanggal_lahir);
        jDateChooserTerakhirDonorKelompok2.setDate((Date) tanggal_terakhir_transfusi);
   
    }//GEN-LAST:event_tableDataPendonorKelompok2MouseClicked

    private void jComboBoxHemoglobinKelompok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHemoglobinKelompok2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxHemoglobinKelompok2ActionPerformed

    private void txtFieldRiwayatPenyakitKelompok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldRiwayatPenyakitKelompok2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldRiwayatPenyakitKelompok2ActionPerformed

    private void jDateTanggalDaftarKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateTanggalDaftarKelompok2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateTanggalDaftarKelompok2MouseClicked

    private void BtnDarahKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDarahKelompok2MouseClicked
        new stokDarahIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnDarahKelompok2MouseClicked

    private void BtnDarahKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDarahKelompok2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDarahKelompok2MouseEntered

    private void BtnDarahKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDarahKelompok2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDarahKelompok2MouseExited

    private void txtFieldGolonganDarahKelompok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldGolonganDarahKelompok2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldGolonganDarahKelompok2ActionPerformed

    private void BtnCariKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseClicked
        cari();
    }//GEN-LAST:event_BtnCariKelompok2MouseClicked

    private void BtnCariKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseEntered
        changecolor(PanelCariKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnCariKelompok2MouseEntered

    private void BtnCariKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseExited
        changecolor(PanelCariKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnCariKelompok2MouseExited

    private void BtnHelpKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHelpKelompok2MouseClicked
        new donor.PetunjukDonor().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnHelpKelompok2MouseClicked

    private void BtnHelpKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHelpKelompok2MouseEntered
        changecolor(PanelHelpKelompok2, new Color (50,118,163));
    }//GEN-LAST:event_BtnHelpKelompok2MouseEntered

    private void BtnHelpKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHelpKelompok2MouseExited
        changecolor(PanelHelpKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnHelpKelompok2MouseExited
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormPendonor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeartBadan;
    private javax.swing.JLabel BtnAddKelompok2;
    private javax.swing.JLabel BtnBackKelompok2;
    private javax.swing.JLabel BtnCariKelompok2;
    private javax.swing.JLabel BtnClearKelompok2;
    public javax.swing.JLabel BtnDarahKelompok2;
    private javax.swing.JLabel BtnDeleteKelompok2;
    private javax.swing.JLabel BtnEditKelompok2;
    private javax.swing.JLabel BtnHelpKelompok2;
    private javax.swing.JLabel BtnRefreshKelompok2;
    private javax.swing.JLabel Goldarah;
    private javax.swing.JLabel IDdarah;
    private javax.swing.JLabel NamaPendonor;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelAddKelompok2;
    private javax.swing.JPanel PanelBackKelompok2;
    private javax.swing.JPanel PanelCariKelompok2;
    private javax.swing.JPanel PanelClearKelompok2;
    private javax.swing.JPanel PanelDarahKelompok2;
    private javax.swing.JPanel PanelDeleteKelompok2;
    private javax.swing.JPanel PanelEditKelompok2;
    private javax.swing.JPanel PanelHelpKelompok2;
    private javax.swing.JPanel PanelRefreshKelompok2;
    private javax.swing.JLabel TotalHarga;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel alamat2;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel golDarah;
    private javax.swing.JComboBox<String> jComboBoxHemoglobinKelompok2;
    private com.toedter.calendar.JDateChooser jDateChooserTanggalLahirKelompok2;
    private com.toedter.calendar.JDateChooser jDateChooserTerakhirDonorKelompok2;
    private com.toedter.calendar.JDateChooser jDateTanggalDaftarKelompok2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonLakiLakiKelompok2;
    private javax.swing.JRadioButton jRadioButtonPerempuanKelompok2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahTransfusi;
    private javax.swing.JLabel jumlahlabu;
    private javax.swing.JLabel kondisi;
    private javax.swing.JLabel kondisi1;
    private javax.swing.JLabel line10;
    private javax.swing.JLabel line11;
    private javax.swing.JLabel line12;
    private javax.swing.JLabel line13;
    private javax.swing.JLabel line14;
    private javax.swing.JLabel line15;
    private javax.swing.JLabel line16;
    private javax.swing.JLabel line19;
    private javax.swing.JLabel line20;
    private javax.swing.JLabel line22;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel line9;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tableDataPendonorKelompok2;
    private javax.swing.JLabel tanggalLahir1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFieldAkunGmailKelompok2;
    private javax.swing.JTextField txtFieldAlamatKelompok2;
    private javax.swing.JTextField txtFieldBeratBadanKelompok2;
    private javax.swing.JTextField txtFieldCariKelompok2;
    public javax.swing.JTextField txtFieldGolonganDarahKelompok2;
    public javax.swing.JTextField txtFieldIdDarahKelompok2;
    public javax.swing.JTextField txtFieldJumlahLabuKelompok2;
    private javax.swing.JTextField txtFieldNamaPendonorKelompok2;
    private javax.swing.JTextField txtFieldNoTelpKelompok2;
    private javax.swing.JTextField txtFieldRiwayatPenyakitKelompok2;
    private javax.swing.JTextField txtFieldTotalDonorKelompok2;
    private javax.swing.JTextField txtFieldUsiaKelompok2;
    // End of variables declaration//GEN-END:variables

   

    private static class Connection {

        public Connection() {
        }

        private Statement createStatement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    

    private static class txtTanggalDaftar21552011235 {

        public txtTanggalDaftar21552011235() {
        }
    }
    
   
}
