/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import laporan.*;

/**
 *
 * @author albin
 */
public class dataPendonor extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form daftarMenu
     */
    public dataPendonor() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        tanggal();
        
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
        
        
        tableDataPendonor21552011235.setModel(table);
        table.addColumn("Kode Menu");
        table.addColumn("Nama Menu");
        table.addColumn("Harga");
        table.addColumn("Stok");
        table.addColumn("Tanggal Masuk");
            
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataPendonor21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `tb_menu`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode_menu");
                    String nama = rslt.getString("nama_menu");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    String tanggal = rslt.getString("tanggal");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,stok,tanggal};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPendonor21552011235.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    
    private void clear(){

        txtFieldNamaPendonor21552011235.setText(null);
        
        
    }
    
    
    private void tambahData(){
//        String kode = txt_kodebarang.getText();
        String nama = txtFieldNamaMenu21552011235.getText();
        String harga = txtFieldHarga21552011235.getText();
        String stok = txtFieldStok21552011235.getText();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(txtTanggal21552011235.getDate());
        
        //panggil koneksi
        java.sql.Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `tb_menu` (kode_menu, `nama_menu`, `harga`, `stok`, `tanggal`) "
                     + "VALUES (NULL, '"+nama+"', '"+harga+"', '"+stok+"', '"+tanggal+"')";
        
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
    
    public void tanggal(){
        Date now = new Date();  
        txtTanggal21552011235.setDate(now);    
    }
    
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tableDataPendonor21552011235.getSelectedRow();
        
        String kode = table.getValueAt(i, 0).toString();
        
        java.sql.Connection connect = koneksi.getKoneksi();
        
        String query = "DELETE FROM `tb_menu` WHERE `tb_menu`.`kode_menu` = "+kode+" ";
        try{
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.execute();
            JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }finally{
            tampilData();
            clear();
        }
        
    }
    
    
    private void editData(){
        int i = tableDataPendonor21552011235.getSelectedRow();
        
        String kode = table.getValueAt(i, 0).toString();
        String nama = txtFieldNamaMenu21552011235.getText();
        String harga =txtFieldHarga21552011235.getText();
        String stok = txtFieldStok21552011235.getText();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(date.format(txtTanggal21552011235.getDate()));
        
        java.sql.Connection connect = koneksi.getKoneksi();
        
        String query = "UPDATE `tb_menu` SET `nama_menu` = '"+nama+"', `harga` = '"+harga+"', `stok` = '"+stok+"', `tanggal` = '"+tanggal+"' "
                + "WHERE `tb_menu`.`kode_menu` = '"+kode+"';";

        try{
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Data Update");
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Gagal Update");
        }finally{
            tampilData();
            clear();
        }
    }
    
//    private void cari(){
//        int row = tableMenu21552011235.getRowCount();
//        for(int a = 0 ; a < row ; a++){
//            table.removeRow(0);
//        }
//        
//        String cari = txtFieldCari21552011235.getText();
//        
//        String query = "SELECT * FROM `tb_menu` WHERE `kode_menu`  LIKE '%"+cari+"%' OR `nama_menu` LIKE '%"+cari+"%' ";
//                
//       try{
//           java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
//           Statement sttmnt = connect.createStatement();//membuat statement
//           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
//           
//           while (rslt.next()){
//                //menampung data sementara
//                   
//                    String kode = rslt.getString("kode_menu");
//                    String nama = rslt.getString("nama_menu");
//                    String harga = rslt.getString("harga");
//                    String stok = rslt.getString("stok");
//                    String tanggal = rslt.getString("tanggal");
//                    
//                //masukan semua data kedalam array
//                String[] data = {kode,nama,harga,stok,tanggal};
//                //menambahakan baris sesuai dengan data yang tersimpan diarray
//                table.addRow(data);
//            }
//                //mengeset nilai yang ditampung agar muncul di table
//                tableMenu21552011235.setModel(table);
//           
//        
//    }catch(Exception e){
//           System.out.println(e);
//    }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        PanelAdd21552011235 = new javax.swing.JPanel();
        BtnAdd21552011235 = new javax.swing.JLabel();
        NamaPendonor = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        golDarah = new javax.swing.JLabel();
        TotalHarga = new javax.swing.JLabel();
        PanelClear21552011235 = new javax.swing.JPanel();
        BtnClear21552011235 = new javax.swing.JLabel();
        PanelRefresh21552011235 = new javax.swing.JPanel();
        BtnRefresh21552011235 = new javax.swing.JLabel();
        PanelDelete21552011235 = new javax.swing.JPanel();
        BtnDelete21552011235 = new javax.swing.JLabel();
        PanelEdit21552011235 = new javax.swing.JPanel();
        BtnEdit21552011235 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataPendonor21552011235 = new javax.swing.JTable();
        txtTanggal21552011235 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtFieldNamaPendonor21552011235 = new javax.swing.JTextField();
        line9 = new javax.swing.JLabel();
        txtFieldNoTelp21552011235 = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        line10 = new javax.swing.JLabel();
        txtFieldAlamat21552011235 = new javax.swing.JTextField();
        alamat = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        txtFieldAkunGmail21552011235 = new javax.swing.JTextField();
        kondisi = new javax.swing.JLabel();
        kondisi1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        golDarah1 = new javax.swing.JLabel();
        jDateChooserTerakhirTransfusi = new com.toedter.calendar.JDateChooser();
        line11 = new javax.swing.JLabel();
        txtFieldJumlahTransfusi21552011235 = new javax.swing.JTextField();
        jumlahTransfusi = new javax.swing.JLabel();
        line13 = new javax.swing.JLabel();
        txtFieldUsia21552011235 = new javax.swing.JTextField();
        alamat1 = new javax.swing.JLabel();
        line14 = new javax.swing.JLabel();
        txtFieldRiwayatPenyakit21552011235 = new javax.swing.JTextField();
        alamat2 = new javax.swing.JLabel();
        line15 = new javax.swing.JLabel();
        txtFieldBeratBadan21552011235 = new javax.swing.JTextField();
        BeartBadan = new javax.swing.JLabel();
        jDateChooserTanggalLahir = new com.toedter.calendar.JDateChooser();
        tanggalLahir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(64, 49, 33));
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
        title.setText(" Data Pendonor");
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

        PanelAdd21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelAdd21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelAdd21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAdd21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAdd21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnAdd21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAdd21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-plus-+-24.png"))); // NOI18N
        BtnAdd21552011235.setText("Add Data");
        BtnAdd21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAdd21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAdd21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAdd21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAdd21552011235MouseExited(evt);
            }
        });
        PanelAdd21552011235.add(BtnAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 200, 290, 50));

        NamaPendonor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor.setText("Nama Pendonor");
        jPanel3.add(NamaPendonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 40));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("___________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, 20));

        golDarah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        golDarah.setForeground(new java.awt.Color(255, 255, 255));
        golDarah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        golDarah.setText("Terakhir Transfusi");
        jPanel3.add(golDarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 120, 30));

        TotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        TotalHarga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalHarga.setText("Tanggal daftar *otomatis");
        TotalHarga.setToolTipText("");
        jPanel3.add(TotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 180, 40));

        PanelClear21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelClear21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelClear21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnClear21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnClear21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnClear21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnClear21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-minus-sign-24.png"))); // NOI18N
        BtnClear21552011235.setText("Clear Form");
        BtnClear21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnClear21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnClear21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnClear21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnClear21552011235MouseExited(evt);
            }
        });
        PanelClear21552011235.add(BtnClear21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelClear21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 390, 290, 50));

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
        PanelRefresh21552011235.add(BtnRefresh21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        jPanel3.add(PanelRefresh21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 960, 50));

        PanelDelete21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelDelete21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDelete21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDelete21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDelete21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnDelete21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-trash-24.png"))); // NOI18N
        BtnDelete21552011235.setText("Delete Data");
        BtnDelete21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDelete21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDelete21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnDelete21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnDelete21552011235MouseExited(evt);
            }
        });
        PanelDelete21552011235.add(BtnDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 490, 290, 50));

        PanelEdit21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelEdit21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelEdit21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PanelEdit21552011235.add(BtnEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 290, 290, 50));

        tableDataPendonor21552011235.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDataPendonor21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableDataPendonor21552011235.setSelectionBackground(new java.awt.Color(64, 49, 33));
        tableDataPendonor21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPendonor21552011235MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataPendonor21552011235);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 1320, 130));

        txtTanggal21552011235.setEnabled(false);
        txtTanggal21552011235.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTanggal21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTanggal21552011235MouseClicked(evt);
            }
        });
        jPanel3.add(txtTanggal21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, 290, 40));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Cukup", "Kurang" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 240, 40));

        txtFieldNamaPendonor21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaPendonor21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaPendonor21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaPendonor21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaPendonor21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaPendonor21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 40));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("___________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 260, 20));

        txtFieldNoTelp21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNoTelp21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNoTelp21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNoTelp21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNoTelp21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNoTelp21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, 40));

        noTelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noTelp.setForeground(new java.awt.Color(255, 255, 255));
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noTelp.setText("No Telephone");
        jPanel3.add(noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 40));

        line10.setBackground(new java.awt.Color(255, 255, 255));
        line10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line10.setForeground(new java.awt.Color(255, 255, 255));
        line10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line10.setText("____________________________________________________________________");
        jPanel3.add(line10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 620, 20));

        txtFieldAlamat21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAlamat21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAlamat21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAlamat21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAlamat21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAlamat21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 610, 40));

        alamat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat.setText("Alamat");
        jPanel3.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 120, 40));

        line12.setBackground(new java.awt.Color(255, 255, 255));
        line12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line12.setForeground(new java.awt.Color(255, 255, 255));
        line12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line12.setText("___________________________");
        jPanel3.add(line12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 260, 20));

        txtFieldAkunGmail21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAkunGmail21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAkunGmail21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAkunGmail21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAkunGmail21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAkunGmail21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 260, 40));

        kondisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi.setForeground(new java.awt.Color(255, 255, 255));
        kondisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi.setText("Akun Gmail");
        jPanel3.add(kondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 120, 40));

        kondisi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi1.setForeground(new java.awt.Color(255, 255, 255));
        kondisi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi1.setText("Hemoglobin");
        jPanel3.add(kondisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 130, 30));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O+", "A+", "B+", "AB+", "O-", "A-", "B-", "Rh-null-" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 240, 40));

        golDarah1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        golDarah1.setForeground(new java.awt.Color(255, 255, 255));
        golDarah1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        golDarah1.setText("Golongan Darah");
        jPanel3.add(golDarah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 120, 30));
        jPanel3.add(jDateChooserTerakhirTransfusi, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 240, 40));

        line11.setBackground(new java.awt.Color(255, 255, 255));
        line11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line11.setForeground(new java.awt.Color(255, 255, 255));
        line11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line11.setText("___________________________");
        jPanel3.add(line11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 260, 20));

        txtFieldJumlahTransfusi21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldJumlahTransfusi21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlahTransfusi21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlahTransfusi21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlahTransfusi21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldJumlahTransfusi21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 260, 40));

        jumlahTransfusi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jumlahTransfusi.setForeground(new java.awt.Color(255, 255, 255));
        jumlahTransfusi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahTransfusi.setText("Jumlah Transfusi");
        jPanel3.add(jumlahTransfusi, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 120, 40));

        line13.setBackground(new java.awt.Color(255, 255, 255));
        line13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line13.setForeground(new java.awt.Color(255, 255, 255));
        line13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line13.setText("___________");
        jPanel3.add(line13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 100, 20));

        txtFieldUsia21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldUsia21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldUsia21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldUsia21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldUsia21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldUsia21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, 40));

        alamat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat1.setForeground(new java.awt.Color(255, 255, 255));
        alamat1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat1.setText("Usia");
        jPanel3.add(alamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 40));

        line14.setBackground(new java.awt.Color(255, 255, 255));
        line14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line14.setForeground(new java.awt.Color(255, 255, 255));
        line14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line14.setText("___________________________");
        jPanel3.add(line14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 250, 20));

        txtFieldRiwayatPenyakit21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldRiwayatPenyakit21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldRiwayatPenyakit21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldRiwayatPenyakit21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldRiwayatPenyakit21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldRiwayatPenyakit21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldRiwayatPenyakit21552011235ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldRiwayatPenyakit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 240, 40));

        alamat2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat2.setForeground(new java.awt.Color(255, 255, 255));
        alamat2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat2.setText("Riwayat Penyakit");
        jPanel3.add(alamat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 120, 40));

        line15.setBackground(new java.awt.Color(255, 255, 255));
        line15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line15.setForeground(new java.awt.Color(255, 255, 255));
        line15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line15.setText("___________");
        jPanel3.add(line15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 100, 20));

        txtFieldBeratBadan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldBeratBadan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldBeratBadan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldBeratBadan21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldBeratBadan21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldBeratBadan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 100, 40));

        BeartBadan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BeartBadan.setForeground(new java.awt.Color(255, 255, 255));
        BeartBadan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BeartBadan.setText("Berat Badan *Kg");
        jPanel3.add(BeartBadan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 110, 40));
        jPanel3.add(jDateChooserTanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 240, 40));

        tanggalLahir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir.setText("Tanggal Lahir");
        jPanel3.add(tanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 120, 30));

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
        changecolor(PanelEdit21552011235, new Color (45,35,23));
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

    private void BtnAdd21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAdd21552011235MouseClicked
       tambahData();
    }//GEN-LAST:event_BtnAdd21552011235MouseClicked

    private void BtnAdd21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAdd21552011235MouseEntered
       changecolor(PanelAdd21552011235, new Color (78,159,61));
    }//GEN-LAST:event_BtnAdd21552011235MouseEntered

    private void BtnAdd21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAdd21552011235MouseExited
       changecolor(PanelAdd21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnAdd21552011235MouseExited

    private void BtnClear21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseClicked
        clear();
    }//GEN-LAST:event_BtnClear21552011235MouseClicked

    private void BtnClear21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseEntered
      changecolor(PanelClear21552011235, new Color (224,77,1));
    }//GEN-LAST:event_BtnClear21552011235MouseEntered

    private void BtnClear21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseExited
      changecolor(PanelClear21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnClear21552011235MouseExited

    private void BtnDelete21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseClicked
        hapusData();
    }//GEN-LAST:event_BtnDelete21552011235MouseClicked

    private void BtnDelete21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseEntered
      changecolor(PanelDelete21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnDelete21552011235MouseEntered

    private void BtnDelete21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseExited
       changecolor(PanelDelete21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnDelete21552011235MouseExited

    private void BtnRefresh21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseClicked
        tampilData();
    }//GEN-LAST:event_BtnRefresh21552011235MouseClicked

    private void BtnRefresh21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseEntered
       changecolor(PanelRefresh21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnRefresh21552011235MouseEntered

    private void BtnRefresh21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRefresh21552011235MouseExited
        changecolor(PanelRefresh21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnRefresh21552011235MouseExited

    private void tableDataPendonor21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPendonor21552011235MouseClicked
        // TODO add your handling code here:
        int baris = tableDataPendonor21552011235.getSelectedRow();
        
        String nama = table.getValueAt(baris,1).toString();
        txtFieldNamaMenu21552011235.setText(nama);
        
        String harga = table.getValueAt(baris, 2).toString();
        txtFieldHarga21552011235.setText(harga);
        
        String stok = table.getValueAt(baris, 3).toString();
        txtFieldStok21552011235.setText(stok);
        
        String tanggal = table.getValueAt(baris, 4).toString();
        
        Date convert = null;
        try{
            convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);   
        }catch(ParseException e){
            System.out.println(e);
        }
        txtTanggal21552011235.setDate(convert);
    }//GEN-LAST:event_tableDataPendonor21552011235MouseClicked

    private void txtTanggal21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTanggal21552011235MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggal21552011235MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtFieldRiwayatPenyakit21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldRiwayatPenyakit21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldRiwayatPenyakit21552011235ActionPerformed

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
            java.util.logging.Logger.getLogger(dataPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataPendonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeartBadan;
    private javax.swing.JLabel BtnAdd21552011235;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnBack77174756;
    private javax.swing.JLabel BtnClear21552011235;
    private javax.swing.JLabel BtnDelete21552011235;
    private javax.swing.JLabel BtnEdit21552011235;
    private javax.swing.JLabel BtnRefresh21552011235;
    private javax.swing.JLabel DaftarMenu1;
    private javax.swing.JLabel NamaPendonor;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel Navbar1;
    private javax.swing.JPanel PanelAdd21552011235;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelBack77174756;
    private javax.swing.JPanel PanelClear21552011235;
    private javax.swing.JPanel PanelDelete21552011235;
    private javax.swing.JPanel PanelEdit21552011235;
    private javax.swing.JPanel PanelRefresh21552011235;
    private javax.swing.JLabel TotalHarga;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel alamat2;
    private javax.swing.JLabel golDarah;
    private javax.swing.JLabel golDarah1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooserTanggalLahir;
    private com.toedter.calendar.JDateChooser jDateChooserTerakhirTransfusi;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahTransfusi;
    private javax.swing.JLabel kondisi;
    private javax.swing.JLabel kondisi1;
    private javax.swing.JLabel line10;
    private javax.swing.JLabel line11;
    private javax.swing.JLabel line12;
    private javax.swing.JLabel line13;
    private javax.swing.JLabel line14;
    private javax.swing.JLabel line15;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel line9;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tableDataPendonor21552011235;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFieldAkunGmail21552011235;
    private javax.swing.JTextField txtFieldAlamat21552011235;
    private javax.swing.JTextField txtFieldBeratBadan21552011235;
    private javax.swing.JTextField txtFieldJumlahTransfusi21552011235;
    private javax.swing.JTextField txtFieldNamaPendonor21552011235;
    private javax.swing.JTextField txtFieldNoTelp21552011235;
    private javax.swing.JTextField txtFieldRiwayatPenyakit21552011235;
    private javax.swing.JTextField txtFieldUsia21552011235;
    private com.toedter.calendar.JDateChooser txtTanggal21552011235;
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
}