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
          txtFieldNamaKegiatan21552011235.setText(null);
          jDateChooserTanggalKegiatan.setCalendar(null);
          txtFieldLokasi21552011235.setText(null);
          txtFieldKeterangan21552011235.setText(null);
          txtFieldKuotaPendonor21552011235.setText(null);
          txtFieldJumlahPetugas21552011235.setText(null);
          jComboBoxPerijinanKetua21552011235.setSelectedIndex(0);
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
        String nama = txtFieldNamaKegiatan21552011235.getText();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_kegiatan = tanggal.format(jDateChooserTanggalKegiatan.getDate());
        String lokasi = txtFieldLokasi21552011235.getText();
        String keterangan = txtFieldKeterangan21552011235.getText();
        String kuota_pendonor = txtFieldKuotaPendonor21552011235.getText();
        String jumlah_petugas = txtFieldJumlahPetugas21552011235.getText();
        String perijinan_ketua = (String )jComboBoxPerijinanKetua21552011235.getSelectedItem();
        
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
        PanelBack21552011235 = new javax.swing.JPanel();
        BtnBack21552011235 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Navbar1 = new javax.swing.JPanel();
        PanelBack77174756 = new javax.swing.JPanel();
        BtnBack77174756 = new javax.swing.JLabel();
        DaftarMenu1 = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        PanelRefresh21552011235 = new javax.swing.JPanel();
        BtnRefresh21552011235 = new javax.swing.JLabel();
        PanelEdit21552011235 = new javax.swing.JPanel();
        BtnEdit21552011235 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataKegiatan21552011235 = new javax.swing.JTable();
        txtFieldNamaKegiatan21552011235 = new javax.swing.JTextField();
        line9 = new javax.swing.JLabel();
        txtFieldLokasi21552011235 = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        txtFieldKeterangan21552011235 = new javax.swing.JTextField();
        kondisi = new javax.swing.JLabel();
        line13 = new javax.swing.JLabel();
        txtFieldKuotaPendonor21552011235 = new javax.swing.JTextField();
        alamat1 = new javax.swing.JLabel();
        line15 = new javax.swing.JLabel();
        txtFieldJumlahPetugas21552011235 = new javax.swing.JTextField();
        BeartBadan = new javax.swing.JLabel();
        tanggalLahir = new javax.swing.JLabel();
        jDateChooserTanggalKegiatan = new com.toedter.calendar.JDateChooser();
        line16 = new javax.swing.JLabel();
        txtFieldCari21552011235 = new javax.swing.JTextField();
        PanelCari21552011235 = new javax.swing.JPanel();
        BtnCari21552011235 = new javax.swing.JLabel();
        jComboBoxPerijinanKetua21552011235 = new javax.swing.JComboBox<>();
        NamaPendonor1 = new javax.swing.JLabel();
        tanggalLahir1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(32, 83, 117));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navbar.setBackground(new java.awt.Color(32, 83, 117));
        Navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBack21552011235.setBackground(new java.awt.Color(32, 83, 117));
        PanelBack21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBack21552011235.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnBack21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBack21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-back-48.png"))); // NOI18N
        BtnBack21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBack21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBack21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBack21552011235MouseExited(evt);
            }
        });
        PanelBack21552011235.add(BtnBack21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        Navbar.add(PanelBack21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Laporan Kegiatan");
        Navbar.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 390, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        jPanel3.setBackground(new java.awt.Color(17, 43, 60));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navbar1.setBackground(new java.awt.Color(32, 83, 117));
        Navbar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBack77174756.setBackground(new java.awt.Color(32, 83, 117));
        PanelBack77174756.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBack77174756.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnBack77174756.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack77174756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBack77174756.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-back-48.png"))); // NOI18N
        BtnBack77174756.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBack77174756MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBack77174756MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBack77174756MouseExited(evt);
            }
        });
        PanelBack77174756.add(BtnBack77174756, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        Navbar1.add(PanelBack77174756, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        DaftarMenu1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DaftarMenu1.setForeground(new java.awt.Color(255, 255, 255));
        DaftarMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DaftarMenu1.setText("Formulir Pendaftaran Pendonor");
        Navbar1.add(DaftarMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 60));

        jPanel3.add(Navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("___________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 260, 20));

        PanelRefresh21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelRefresh21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelRefresh21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnRefresh21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnRefresh21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnRefresh21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnRefresh21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-available-updates-24.png"))); // NOI18N
        BtnRefresh21552011235.setText("Refresh");
        BtnRefresh21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRefresh21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRefresh21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRefresh21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRefresh21552011235MouseExited(evt);
            }
        });
        PanelRefresh21552011235.add(BtnRefresh21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelRefresh21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 290, 50));

        PanelEdit21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelEdit21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelEdit21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnEdit21552011235.setBackground(new java.awt.Color(255, 255, 255));
        BtnEdit21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEdit21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnEdit21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnEdit21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-edit-24.png"))); // NOI18N
        BtnEdit21552011235.setText("Edit Data");
        BtnEdit21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEdit21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEdit21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEdit21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEdit21552011235MouseExited(evt);
            }
        });
        PanelEdit21552011235.add(BtnEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        jPanel3.add(PanelEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 950, 50));

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

        txtFieldNamaKegiatan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaKegiatan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaKegiatan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaKegiatan21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaKegiatan21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaKegiatan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 40));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("__________________________________________________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 610, 20));

        txtFieldLokasi21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldLokasi21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldLokasi21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldLokasi21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldLokasi21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldLokasi21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 600, 40));

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

        txtFieldKeterangan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldKeterangan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldKeterangan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldKeterangan21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldKeterangan21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldKeterangan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 670, 40));

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

        txtFieldKuotaPendonor21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldKuotaPendonor21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldKuotaPendonor21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldKuotaPendonor21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldKuotaPendonor21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldKuotaPendonor21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 100, 40));

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

        txtFieldJumlahPetugas21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldJumlahPetugas21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlahPetugas21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlahPetugas21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlahPetugas21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldJumlahPetugas21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 100, 40));

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

        BtnCari21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCari21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnCari21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnCari21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-search-24.png"))); // NOI18N
        BtnCari21552011235.setText("Cari Data");
        BtnCari21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCari21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCari21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCari21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCari21552011235MouseExited(evt);
            }
        });
        PanelCari21552011235.add(BtnCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel3.add(PanelCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 130, 50));

        jComboBoxPerijinanKetua21552011235.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Belum di cek", "Mengizinkan", "Menolak" }));
        jComboBoxPerijinanKetua21552011235.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBoxPerijinanKetua21552011235InputMethodTextChanged(evt);
            }
        });
        jPanel3.add(jComboBoxPerijinanKetua21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 250, 40));

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

    private void BtnBack21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseClicked
        new admin.dashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
        changecolor(PanelBack21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    private void BtnBack21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseExited
        changecolor(PanelBack21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnBack21552011235MouseExited

    private void BtnEdit21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseClicked
        editData();
    }//GEN-LAST:event_BtnEdit21552011235MouseClicked

    private void BtnEdit21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseEntered
        changecolor(PanelEdit21552011235, new Color (255,209,36));
    }//GEN-LAST:event_BtnEdit21552011235MouseEntered

    private void BtnEdit21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseExited
        changecolor(PanelEdit21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnEdit21552011235MouseExited

    private void BtnBack77174756MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack77174756MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBack77174756MouseClicked

    private void BtnBack77174756MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack77174756MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBack77174756MouseEntered

    private void BtnBack77174756MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack77174756MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBack77174756MouseExited

    private void BtnRefresh21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseClicked
      tampilData();
    }//GEN-LAST:event_BtnRefresh21552011235MouseClicked

    private void BtnRefresh21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseEntered
      changecolor(PanelRefresh21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnRefresh21552011235MouseEntered

    private void BtnRefresh21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseExited
      changecolor(PanelRefresh21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnRefresh21552011235MouseExited

    private void tableDataKegiatan21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataKegiatan21552011235MouseClicked
        // TODO add your handling code here:
          int baris = tableDataKegiatan21552011235.getSelectedRow();
          
          //String no_kegiatan = table.getValueAt(baris,0).toString();
          String nama = table.getValueAt(baris,1).toString();
          txtFieldNamaKegiatan21552011235.setText(nama);
          
          String lokasi = table.getValueAt(baris,3).toString();
          txtFieldLokasi21552011235.setText(lokasi);
          
          String keterangan = table.getValueAt(baris,4).toString();
          txtFieldKeterangan21552011235.setText(keterangan);

          String kuota_pendonor = table.getValueAt(baris,5).toString();
          txtFieldKuotaPendonor21552011235.setText(kuota_pendonor);
          
          String jumlah_petugas =  table.getValueAt(baris,6).toString();
          txtFieldJumlahPetugas21552011235.setText(jumlah_petugas);
          
          String perijinan_ketua = table.getValueAt(baris,7).toString();
          for (int i = 0; i <jComboBoxPerijinanKetua21552011235.getItemCount(); i++ ){
              if (jComboBoxPerijinanKetua21552011235.getItemAt(i).equalsIgnoreCase(perijinan_ketua)){
                  jComboBoxPerijinanKetua21552011235.setSelectedIndex(i);
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

    private void BtnCari21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseClicked
        cari();
    }//GEN-LAST:event_BtnCari21552011235MouseClicked

    private void BtnCari21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseEntered
        changecolor(PanelCari21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnCari21552011235MouseEntered

    private void BtnCari21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseExited
        changecolor(PanelCari21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnCari21552011235MouseExited

    private void jComboBoxPerijinanKetua21552011235InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBoxPerijinanKetua21552011235InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPerijinanKetua21552011235InputMethodTextChanged
    
   
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
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnBack77174756;
    private javax.swing.JLabel BtnCari21552011235;
    private javax.swing.JLabel BtnEdit21552011235;
    private javax.swing.JLabel BtnRefresh21552011235;
    private javax.swing.JLabel DaftarMenu1;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel Navbar1;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelBack77174756;
    private javax.swing.JPanel PanelCari21552011235;
    private javax.swing.JPanel PanelEdit21552011235;
    private javax.swing.JPanel PanelRefresh21552011235;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBoxPerijinanKetua21552011235;
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
    private javax.swing.JTextField txtFieldJumlahPetugas21552011235;
    private javax.swing.JTextField txtFieldKeterangan21552011235;
    private javax.swing.JTextField txtFieldKuotaPendonor21552011235;
    private javax.swing.JTextField txtFieldLokasi21552011235;
    private javax.swing.JTextField txtFieldNamaKegiatan21552011235;
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
