/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

//import com.toedter.calendar.JDateChooser;
import sekretaris.*;
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





/**
 *
 * @author albin
 */
public class LaporanKegiatan extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form daftarMenu
     */
    public LaporanKegiatan() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableDataKegiatan21552011235.setModel(table);
        table.addColumn("No. Kegiatan");
        table.addColumn("Nama Kegiatan");
        table.addColumn("Tanggal Kegiatan");
        table.addColumn("Lokasi");
        table.addColumn("Keterangan");
        table.addColumn("Kuota Pendonor");
        table.addColumn("Jumlah Petugas");
        table.addColumn("Perijinan Ketua");
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataKegiatan21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `data_kegiatan`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                    String no_kegiatan = rslt.getString("no_kegiatan");
                    String nama_kegiatan = rslt.getString("nama_kegiatan");
                    String tanggal_kegiatan = rslt.getString("tanggal_kegiatan");
                    String lokasi = rslt.getString("lokasi");
                    String keterangan = rslt.getString("keterangan");
                    String kuota_pendonor = rslt.getString("kuota_pendonor");
                    String jumlah_petugas = rslt.getString("jumlah_petugas");
                    String perijinan_ketua = rslt.getString("perijinan_ketua");
                    
                    
                //masukan semua data kedalam array
                String[] data = {no_kegiatan,nama_kegiatan,tanggal_kegiatan,lokasi,keterangan,kuota_pendonor,jumlah_petugas,perijinan_ketua};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataKegiatan21552011235.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }  

    
    private void clear(){
          //*no_pendonor
          txtFieldNamaKegiatanKelompok2.setText(null);
          jDateChooserTanggalKegiatan.setCalendar(null);
          txtFieldLokasiKelompok2.setText(null);
          txtFieldKeteranganKelompok2.setText(null);
          txtFieldKuotaPendonorKelompok2.setText(null);
          txtFieldJumlahPetugasKelompok2.setText(null);
          jComboBoxPerijinanKetuaKelompok2.setSelectedIndex(0);
    }
    
    
//    private void tambahData(){
//        //String no_kegiatan
//        String nama_kegiatan = txtFieldNamaKegiatan21552011235.getText();
//        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
//        String tanggal_kegiatan = tanggal.format(jDateChooserTanggalKegiatan.getDate());
//        String lokasi = txtFieldLokasi21552011235.getText();
//        String keterangan = txtFieldKeterangan21552011235.getText();
//        String kuota_pendonor = txtFieldKuotaPendonor21552011235.getText();
//        String jumlah_petugas = txtFieldJumlahPetugas21552011235.getText();
//        String perijinan_ketua = (String) jComboBoxPerijinanKetua21552011235.getSelectedItem();
//       
//        //panggil koneksi
//        java.sql.Connection connect = koneksi.getKoneksi();
//        //query untuk memasukan data
//        String query = "INSERT INTO `data_kegiatan` (`no_kegiatan`,`nama_kegiatan`,`tanggal_kegiatan`,`lokasi`,`keterangan`,`kuota_pendonor`,`jumlah_petugas`,`perijinan_ketua`) " 
//                     + "VALUES (NULL,'"+nama_kegiatan+"','"+tanggal_kegiatan+"','"+lokasi+"','"+keterangan+"','"+kuota_pendonor+"','"+jumlah_petugas+"','"+perijinan_ketua+"')";
//        
//        try{ 
//            //menyiapkan statement untuk di eksekusi
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//            ps.executeUpdate(query);
//            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
//            
//        }catch(SQLException | HeadlessException e){
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan!!!");
//            
//        }finally{
//            tampilData();
//            clear();
//            
//        }
//    }
//    
////    private void tanggal(){
////        Date now = new Date();  
////        jDateTanggalDaftar21552011235.setDate(now);    
////    }
//    
//    private void hapusData(){
//        //ambill data no pendaftaran
//        int i = tableDataKegiatan21552011235.getSelectedRow();
//        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
//            + "Menghapus Data ?","Konfirmasi Hapus Data Kegiatan ", JOptionPane.YES_NO_OPTION);
//        
//        if (ok==0){
//            String no_kegiatan = table.getValueAt(i, 0).toString();
//            java.sql.Connection connect = koneksi.getKoneksi();
//            String query = "DELETE FROM `data_kegiatan` WHERE `data_kegiatan`.`no_kegiatan` = "+no_kegiatan+" ";
//   
//            try {
//                PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//                ps.execute();
//                JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!!!"+e);
//            }finally{
//                tampilData();
//                clear();
//            }
//        }
//    }
    
    
    private void editData(){
        int i = tableDataKegiatan21552011235.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Mengedit Data ?","Konfirmasi Edit Kegiatan", JOptionPane.YES_NO_OPTION);
        
        //String no_kegiatan
        String nama = txtFieldNamaKegiatanKelompok2.getText();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_kegiatan = tanggal.format(jDateChooserTanggalKegiatan.getDate());
        String lokasi = txtFieldLokasiKelompok2.getText();
        String keterangan = txtFieldKeteranganKelompok2.getText();
        String kuota_pendonor = txtFieldKuotaPendonorKelompok2.getText();
        String jumlah_petugas = txtFieldJumlahPetugasKelompok2.getText();
        String perijinan_ketua = (String )jComboBoxPerijinanKetuaKelompok2.getSelectedItem();
        
        if (ok==0){
            String no_kegiatan = table.getValueAt(i, 0).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "UPDATE `data_kegiatan` SET `nama_kegiatan` = '"+nama+"',`tanggal_kegiatan` = '"+tanggal_kegiatan+"', `lokasi` = '"+lokasi+"',`keterangan` = '"+keterangan+"',`kuota_pendonor` = '"+kuota_pendonor+"',`jumlah_petugas` = '"+jumlah_petugas+"',`perijinan_ketua` = '"+perijinan_ketua+"'"
                + "WHERE `data_kegiatan`.`no_kegiatan` = '"+no_kegiatan+"';";
            
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
        int row = tableDataKegiatan21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
      String cari = txtFieldCari21552011235.getText();
      String query = "SELECT * FROM `data_kegiatan` WHERE "
                + "`no_kegiatan` LIKE '%"+cari+"%' OR"
                + "`nama_kegiatan`  LIKE '%"+cari+"%' OR "
                + "`tanggal_kegiatan` LIKE '%"+cari+"%' OR"
                + "`lokasi` LIKE '%"+cari+"%' OR"
                + "`keterangan` LIKE '%"+cari+"%' OR"
                + "`kuota_pendonor` LIKE '%"+cari+"%' OR"
                + "`jumlah_petugas` LIKE '%"+cari+"%' OR"
                + "`perijinan_ketua` LIKE '%"+cari+"%'  ";
                
       try{
           java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                    String no_kegiatan = rslt.getString("no_kegiatan");
                    String nama_kegiatan = rslt.getString("nama_kegiatan");
                    String tanggal_kegiatan = rslt.getString("tanggal_kegiatan");
                    String lokasi = rslt.getString("lokasi");
                    String keterangan = rslt.getString("keterangan");
                    String kuota_pendonor = rslt.getString("kuota_pendonor");
                    String jumlah_petugas = rslt.getString("jumlah_petugas");
                    String perijinan_ketua = rslt.getString("perijinan_ketua");
                    
                String[] data = {no_kegiatan,tanggal_kegiatan,nama_kegiatan,lokasi,keterangan,kuota_pendonor,jumlah_petugas,perijinan_ketua};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataKegiatan21552011235.setModel(table);
                
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
        PanelBackKelompok2 = new javax.swing.JPanel();
        BtnBackKelompok2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        PanelHelpKelompok2 = new javax.swing.JPanel();
        BtnHelpKelompok2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        line8 = new javax.swing.JLabel();
        PanelRefreshKelompok2 = new javax.swing.JPanel();
        BtnRefreshKelompok2 = new javax.swing.JLabel();
        PanelEditKelompok2 = new javax.swing.JPanel();
        BtnEditKelompok2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataKegiatan21552011235 = new javax.swing.JTable();
        txtFieldNamaKegiatanKelompok2 = new javax.swing.JTextField();
        line9 = new javax.swing.JLabel();
        txtFieldLokasiKelompok2 = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        txtFieldKeteranganKelompok2 = new javax.swing.JTextField();
        kondisi = new javax.swing.JLabel();
        line13 = new javax.swing.JLabel();
        txtFieldKuotaPendonorKelompok2 = new javax.swing.JTextField();
        alamat1 = new javax.swing.JLabel();
        line15 = new javax.swing.JLabel();
        txtFieldJumlahPetugasKelompok2 = new javax.swing.JTextField();
        BeartBadan = new javax.swing.JLabel();
        tanggalLahir = new javax.swing.JLabel();
        jDateChooserTanggalKegiatan = new com.toedter.calendar.JDateChooser();
        line16 = new javax.swing.JLabel();
        txtFieldCari21552011235 = new javax.swing.JTextField();
        PanelCari21552011235 = new javax.swing.JPanel();
        BtnCariKelompok2 = new javax.swing.JLabel();
        jComboBoxPerijinanKetuaKelompok2 = new javax.swing.JComboBox<>();
        NamaPendonor1 = new javax.swing.JLabel();
        tanggalLahir1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(32, 83, 117));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navbar.setBackground(new java.awt.Color(32, 83, 117));
        Navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        title.setText("Laporan Kegiatan");
        Navbar.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 390, 60));

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
        PanelHelpKelompok2.add(BtnHelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        Navbar.add(PanelHelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, -1, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        jPanel3.setBackground(new java.awt.Color(17, 43, 60));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("___________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 260, 20));

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

        jPanel3.add(PanelRefreshKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 290, 50));

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
        PanelEditKelompok2.add(BtnEditKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        jPanel3.add(PanelEditKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 950, 50));

        tableDataKegiatan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tableDataKegiatan21552011235.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDataKegiatan21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableDataKegiatan21552011235.setSelectionBackground(new java.awt.Color(32, 83, 117));
        tableDataKegiatan21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataKegiatan21552011235MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataKegiatan21552011235);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1320, 130));

        txtFieldNamaKegiatanKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaKegiatanKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaKegiatanKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaKegiatanKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaKegiatanKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaKegiatanKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 40));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("__________________________________________________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 610, 20));

        txtFieldLokasiKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldLokasiKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldLokasiKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldLokasiKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldLokasiKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldLokasiKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 600, 40));

        noTelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noTelp.setForeground(new java.awt.Color(255, 255, 255));
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noTelp.setText("Lokasi");
        jPanel3.add(noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 40));

        line12.setBackground(new java.awt.Color(255, 255, 255));
        line12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line12.setForeground(new java.awt.Color(255, 255, 255));
        line12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line12.setText("__________________________________________________________________");
        jPanel3.add(line12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 600, 20));

        txtFieldKeteranganKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldKeteranganKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldKeteranganKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldKeteranganKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldKeteranganKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldKeteranganKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 670, 40));

        kondisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi.setForeground(new java.awt.Color(255, 255, 255));
        kondisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi.setText("Keterangan");
        jPanel3.add(kondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 40));

        line13.setBackground(new java.awt.Color(255, 255, 255));
        line13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line13.setForeground(new java.awt.Color(255, 255, 255));
        line13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line13.setText("___________");
        jPanel3.add(line13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 100, 20));

        txtFieldKuotaPendonorKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldKuotaPendonorKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldKuotaPendonorKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldKuotaPendonorKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldKuotaPendonorKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldKuotaPendonorKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 100, 40));

        alamat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat1.setForeground(new java.awt.Color(255, 255, 255));
        alamat1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat1.setText("Kuota Pendonor");
        jPanel3.add(alamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 130, 40));

        line15.setBackground(new java.awt.Color(255, 255, 255));
        line15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line15.setForeground(new java.awt.Color(255, 255, 255));
        line15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line15.setText("___________");
        jPanel3.add(line15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 100, 20));

        txtFieldJumlahPetugasKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldJumlahPetugasKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlahPetugasKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlahPetugasKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlahPetugasKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldJumlahPetugasKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 100, 40));

        BeartBadan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BeartBadan.setForeground(new java.awt.Color(255, 255, 255));
        BeartBadan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BeartBadan.setText("Jumlah Petugas");
        jPanel3.add(BeartBadan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 110, 40));

        tanggalLahir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir.setText("Perijinan Ketua");
        jPanel3.add(tanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 120, 30));

        jDateChooserTanggalKegiatan.setDateFormatString("yyyy-MM-dd");
        jDateChooserTanggalKegiatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jDateChooserTanggalKegiatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 250, 40));

        line16.setBackground(new java.awt.Color(255, 255, 255));
        line16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line16.setForeground(new java.awt.Color(255, 255, 255));
        line16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        line16.setText("_________________");
        jPanel3.add(line16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 160, 20));

        txtFieldCari21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCari21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldCari21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCari21552011235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCari21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCari21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 160, 50));

        PanelCari21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelCari21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCari21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PanelCari21552011235.add(BtnCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel3.add(PanelCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 130, 50));

        jComboBoxPerijinanKetuaKelompok2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Belum di cek", "Mengizinkan", "Menolak" }));
        jComboBoxPerijinanKetuaKelompok2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBoxPerijinanKetuaKelompok2InputMethodTextChanged(evt);
            }
        });
        jPanel3.add(jComboBoxPerijinanKetuaKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 250, 40));

        NamaPendonor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor1.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor1.setText("Nama Kegiatan");
        jPanel3.add(NamaPendonor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 140, 40));

        tanggalLahir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir1.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir1.setText("Tanggal Kegiatan");
        jPanel3.add(tanggalLahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 120, 30));

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
        new admin.dashboardAdmin().setVisible(true);
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

    private void BtnRefreshKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseClicked
      tampilData();
    }//GEN-LAST:event_BtnRefreshKelompok2MouseClicked

    private void BtnRefreshKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseEntered
      changecolor(PanelRefreshKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnRefreshKelompok2MouseEntered

    private void BtnRefreshKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefreshKelompok2MouseExited
      changecolor(PanelRefreshKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnRefreshKelompok2MouseExited

    private void tableDataKegiatan21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataKegiatan21552011235MouseClicked
        // TODO add your handling code here:
          int baris = tableDataKegiatan21552011235.getSelectedRow();
          
          //String no_kegiatan = table.getValueAt(baris,0).toString();
          String nama = table.getValueAt(baris,1).toString();
          txtFieldNamaKegiatanKelompok2.setText(nama);
          
          String lokasi = table.getValueAt(baris,3).toString();
          txtFieldLokasiKelompok2.setText(lokasi);
          
          String keterangan = table.getValueAt(baris,4).toString();
          txtFieldKeteranganKelompok2.setText(keterangan);

          String kuota_pendonor = table.getValueAt(baris,5).toString();
          txtFieldKuotaPendonorKelompok2.setText(kuota_pendonor);
          
          String jumlah_petugas =  table.getValueAt(baris,6).toString();
          txtFieldJumlahPetugasKelompok2.setText(jumlah_petugas);
          
          String perijinan_ketua = table.getValueAt(baris,7).toString();
          for (int i = 0; i <jComboBoxPerijinanKetuaKelompok2.getItemCount(); i++ ){
              if (jComboBoxPerijinanKetuaKelompok2.getItemAt(i).equalsIgnoreCase(perijinan_ketua)){
                  jComboBoxPerijinanKetuaKelompok2.setSelectedIndex(i);
              }
          }
          
        Date tanggal_kegiatan = null;
        try{
            tanggal_kegiatan = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(baris,2));
        }catch(ParseException e){  
            System.out.println(e);
        }
        jDateChooserTanggalKegiatan.setDate(tanggal_kegiatan); 
    }//GEN-LAST:event_tableDataKegiatan21552011235MouseClicked

    private void BtnCariKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseClicked
        cari();
    }//GEN-LAST:event_BtnCariKelompok2MouseClicked

    private void BtnCariKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseEntered
        changecolor(PanelCari21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnCariKelompok2MouseEntered

    private void BtnCariKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseExited
        changecolor(PanelCari21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnCariKelompok2MouseExited

    private void jComboBoxPerijinanKetuaKelompok2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBoxPerijinanKetuaKelompok2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPerijinanKetuaKelompok2InputMethodTextChanged

    private void BtnHelpKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHelpKelompok2MouseClicked
        new admin.PetunjukLaporanKegiatan().setVisible(true);
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
            java.util.logging.Logger.getLogger(LaporanKegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanKegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanKegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanKegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new LaporanKegiatan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeartBadan;
    private javax.swing.JLabel BtnBackKelompok2;
    private javax.swing.JLabel BtnCariKelompok2;
    private javax.swing.JLabel BtnEditKelompok2;
    private javax.swing.JLabel BtnHelpKelompok2;
    private javax.swing.JLabel BtnRefreshKelompok2;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelBackKelompok2;
    private javax.swing.JPanel PanelCari21552011235;
    private javax.swing.JPanel PanelEditKelompok2;
    private javax.swing.JPanel PanelHelpKelompok2;
    private javax.swing.JPanel PanelRefreshKelompok2;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBoxPerijinanKetuaKelompok2;
    private com.toedter.calendar.JDateChooser jDateChooserTanggalKegiatan;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kondisi;
    private javax.swing.JLabel line12;
    private javax.swing.JLabel line13;
    private javax.swing.JLabel line15;
    private javax.swing.JLabel line16;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel line9;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tableDataKegiatan21552011235;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel tanggalLahir1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFieldCari21552011235;
    private javax.swing.JTextField txtFieldJumlahPetugasKelompok2;
    private javax.swing.JTextField txtFieldKeteranganKelompok2;
    private javax.swing.JTextField txtFieldKuotaPendonorKelompok2;
    private javax.swing.JTextField txtFieldLokasiKelompok2;
    private javax.swing.JTextField txtFieldNamaKegiatanKelompok2;
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
