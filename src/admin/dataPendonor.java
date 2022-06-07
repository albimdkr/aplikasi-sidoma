/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

//import com.toedter.calendar.JDateChooser;
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
        table.addColumn("Tanggal Daftar");
        table.addColumn("No. Pendonor");
        table.addColumn("Nama");
        table.addColumn("Jenis Kelamin");
        table.addColumn("Tanggal Lahir");
        table.addColumn("No.Telp");
        table.addColumn("Gmail");
        table.addColumn("Golongan Darah");
        table.addColumn("Usia");
        table.addColumn("Berat Badan");
        table.addColumn("Alamat");
        table.addColumn("Hemoglobin");
        table.addColumn("Riwayat Penyakit");
        table.addColumn("Jumlah Transfusi");
        table.addColumn("Tanggal terakhir transfusi");
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataPendonor21552011235.getRowCount();
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
                    String golongan_darah = rslt.getString("golongan_darah");
                    String usia = rslt.getString("usia");
                    String berat_badan = rslt.getString("berat_badan");
                    String alamatpendonor = rslt.getString("alamat");
                    String hemoglobin = rslt.getString("hemoglobin");
                    String riwayat_penyakit = rslt.getString("riwayat_penyakit");
                    String jumlah_transfusi = rslt.getString("jumlah_transfusi");
                    String tanggal_terakhir_transfusi = rslt.getString("tanggal_terakhir_transfusi");
                    
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pendonor,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,golongan_darah,usia,berat_badan,alamatpendonor,hemoglobin,riwayat_penyakit,jumlah_transfusi,tanggal_terakhir_transfusi};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPendonor21552011235.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }  

    
    private void clear(){
          //*no_pendonor
          txtFieldNamaPendonor21552011235.setText(null);
//          txtTanggalDaftar21552011235.setDate(null);
          //jenis kelamin
          jDateChooserTanggalLahir.setDate(null);
          txtFieldNoTelp21552011235.setText(null);
          txtFieldAkunGmail21552011235.setText(null);
          //gol darah
          txtFieldUsia21552011235.setText(null);
          txtFieldBeratBadan21552011235.setText(null);
          txtFieldAlamat21552011235.setText(null);
          //hemoglobin
          txtFieldRiwayatPenyakit21552011235.setText(null);
          txtFieldJumlahTransfusi21552011235.setText(null);
          jDateChooserTerakhirTransfusi.setDate(null);
    }
    
    
    private void tambahData(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_daftar = date.format(jDateTanggalDaftar21552011235.getDate());
        //String no_pendonor = 
        String nama = txtFieldNamaPendonor21552011235.getText();
        String jk;
        if (jRadioButtonLakiLaki21552011235.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        SimpleDateFormat tgl_lahir = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_lahir = tgl_lahir.format(jDateChooserTanggalLahir.getDate());
        String no_telp = txtFieldNoTelp21552011235.getText();
        String gmail = txtFieldAkunGmail21552011235.getText();
        String golongan_darah = (String) jComboBoxGolDarah.getSelectedItem();
        String usia = txtFieldUsia21552011235.getText();
        String berat_badan = txtFieldBeratBadan21552011235.getText();
        String alamatpendonor = txtFieldAlamat21552011235.getText();
        String hemoglobin = (String) jComboBoxHemoglobin.getSelectedItem();
        String riwayat_penyakit = txtFieldRiwayatPenyakit21552011235.getText(); 
        String jumlah_transfusi = txtFieldJumlahTransfusi21552011235.getText();
        SimpleDateFormat tgl_tt = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_terakhir_transfusi = tgl_tt.format(jDateChooserTerakhirTransfusi.getDate());
        
        
        //panggil koneksi
        java.sql.Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `data_pendonor` (`tanggal_daftar`,no_pendonor,`nama`,`jenis_kelamin`,`tanggal_lahir`,`no_telp`,`gmail`,`golongan_darah`,`usia`,`berat_badan`,`alamat`,`hemoglobin`,`riwayat_penyakit`,`jumlah_transfusi`,`tanggal_terakhir_transfusi`) " 
                     + "VALUES ('"+tanggal_daftar+"',NULL,'"+nama+"','"+jk+"','"+tanggal_lahir+"','"+no_telp+"','"+gmail+"','"+golongan_darah+"','"+usia+"','"+berat_badan+"','"+alamatpendonor+"','"+hemoglobin+"','"+riwayat_penyakit+"','"+jumlah_transfusi+"','"+tanggal_terakhir_transfusi+"')"; 
        
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
    
    private void tanggal(){
        Date now = new Date();  
        jDateTanggalDaftar21552011235.setDate(now);    
    }
    
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tableDataPendonor21552011235.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        
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
        int i = tableDataPendonor21552011235.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Mengedit Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        
        SimpleDateFormat tgl_daftar = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_daftar = tgl_daftar.format(jDateTanggalDaftar21552011235.getDate());
        //String no_pendonor = table.getValueAt(i, 1).toString();
        String nama = txtFieldNamaPendonor21552011235.getText();
        String jk;
        if (jRadioButtonLakiLaki21552011235.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        SimpleDateFormat tgl_lahir = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_lahir = tgl_lahir.format(jDateChooserTanggalLahir.getDate());
        String no_telp = txtFieldNoTelp21552011235.getText();
        String gmail = txtFieldAkunGmail21552011235.getText();
        String golongan_darah = (String) jComboBoxGolDarah.getSelectedItem();
        String usia = txtFieldUsia21552011235.getText();
        String berat_badan = txtFieldBeratBadan21552011235.getText();
        String alamatpendonor = txtFieldAlamat21552011235.getText();
        String hemoglobin = (String) jComboBoxHemoglobin.getSelectedItem();
        String riwayat_penyakit = txtFieldRiwayatPenyakit21552011235.getText(); 
        String jumlah_transfusi = txtFieldJumlahTransfusi21552011235.getText();
        SimpleDateFormat tgl_tt = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_terakhir_transfusi = tgl_tt.format(jDateChooserTerakhirTransfusi.getDate());
        
        if (ok==0){
            String no_pendonor = table.getValueAt(i, 1).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "UPDATE `data_pendonor` SET `tanggal_daftar` = '"+tanggal_daftar+"',`nama` = '"+nama+"',`jenis_kelamin` = '"+jk+"', `tanggal_lahir` = '"+tanggal_lahir+"',`no_telp` = '"+no_telp+"',`gmail` = '"+gmail+"',`golongan_darah` = '"+golongan_darah+"',`usia` = '"+usia+"',`berat_badan` = '"+berat_badan+"',`alamat` = '"+alamatpendonor+"',`hemoglobin` = '"+hemoglobin+"',`riwayat_penyakit` = '"+riwayat_penyakit+"',`jumlah_transfusi` = '"+jumlah_transfusi+"',`tanggal_terakhir_transfusi` = '"+tanggal_terakhir_transfusi+"'"
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
        int row = tableDataPendonor21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
      String cari = txtFieldCari21552011235.getText();
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
                + "`jumlah_transfusi` LIKE '%"+cari+"%' OR"
                + "`tanggal_terakhir_transfusi` LIKE '%"+cari+"%' ";
                
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
                    String jumlah_transfusi = rslt.getString("jumlah_transfusi");
                    String tanggal_terakhir_transfusi = rslt.getString("tanggal_terakhir_transfusi");
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pendonor,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,golongan_darah,usia,berat_badan,alamatpendonor,hemoglobin,riwayat_penyakit,jumlah_transfusi,tanggal_terakhir_transfusi};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPendonor21552011235.setModel(table);
                
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jComboBoxHemoglobin = new javax.swing.JComboBox<>();
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
        jComboBoxGolDarah = new javax.swing.JComboBox<>();
        golDarah1 = new javax.swing.JLabel();
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
        jDateChooserTerakhirTransfusi = new com.toedter.calendar.JDateChooser();
        tanggalLahir = new javax.swing.JLabel();
        jDateChooserTanggalLahir = new com.toedter.calendar.JDateChooser();
        jDateTanggalDaftar21552011235 = new com.toedter.calendar.JDateChooser();
        line16 = new javax.swing.JLabel();
        txtFieldCari21552011235 = new javax.swing.JTextField();
        PanelCari21552011235 = new javax.swing.JPanel();
        BtnCari21552011235 = new javax.swing.JLabel();
        jRadioButtonLakiLaki21552011235 = new javax.swing.JRadioButton();
        jRadioButtonPerempuan21552011235 = new javax.swing.JRadioButton();
        NamaPendonor1 = new javax.swing.JLabel();
        NamaPendonor2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        BtnAdd21552011235.setBackground(new java.awt.Color(255, 255, 255));
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
        PanelAdd21552011235.add(BtnAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        jPanel3.add(PanelAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 950, 50));

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
        golDarah.setText("Terakhir Tanggal Transfusi *opsional");
        jPanel3.add(golDarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 250, 30));

        TotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        TotalHarga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalHarga.setText("Tanggal daftar");
        TotalHarga.setToolTipText("");
        jPanel3.add(TotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 40));

        PanelClear21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelClear21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelClear21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnClear21552011235.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel3.add(PanelClear21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 430, 290, 50));

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

        jPanel3.add(PanelRefresh21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 240, 290, 50));

        PanelDelete21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelDelete21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDelete21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDelete21552011235.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel3.add(PanelDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 510, 290, 50));

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
        PanelEdit21552011235.add(BtnEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel3.add(PanelEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 290, 50));

        tableDataPendonor21552011235.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1320, 130));

        jComboBoxHemoglobin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxHemoglobin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --", "Baik", "Cukup", "Kurang" }));
        jComboBoxHemoglobin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHemoglobinActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxHemoglobin, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 240, 40));

        txtFieldNamaPendonor21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaPendonor21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaPendonor21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaPendonor21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaPendonor21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaPendonor21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("___________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 20));

        txtFieldNoTelp21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNoTelp21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNoTelp21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNoTelp21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNoTelp21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNoTelp21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 250, 40));

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

        txtFieldAlamat21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAlamat21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAlamat21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAlamat21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAlamat21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAlamat21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 250, 40));

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

        txtFieldAkunGmail21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAkunGmail21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAkunGmail21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAkunGmail21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAkunGmail21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAkunGmail21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 260, 40));

        kondisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi.setForeground(new java.awt.Color(255, 255, 255));
        kondisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi.setText("Gmail");
        jPanel3.add(kondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 120, 40));

        kondisi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi1.setForeground(new java.awt.Color(255, 255, 255));
        kondisi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi1.setText("Hemoglobin");
        jPanel3.add(kondisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 130, 30));

        jComboBoxGolDarah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxGolDarah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --", "O+", "A+", "B+", "AB+", "O-", "A-", "B-", "Rh-null-" }));
        jComboBoxGolDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGolDarahActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxGolDarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 240, 40));

        golDarah1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        golDarah1.setForeground(new java.awt.Color(255, 255, 255));
        golDarah1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        golDarah1.setText("Golongan Darah");
        jPanel3.add(golDarah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 120, 30));

        line11.setBackground(new java.awt.Color(255, 255, 255));
        line11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line11.setForeground(new java.awt.Color(255, 255, 255));
        line11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line11.setText("___________________________");
        jPanel3.add(line11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 260, 20));

        txtFieldJumlahTransfusi21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldJumlahTransfusi21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlahTransfusi21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlahTransfusi21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlahTransfusi21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldJumlahTransfusi21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 260, 40));

        jumlahTransfusi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jumlahTransfusi.setForeground(new java.awt.Color(255, 255, 255));
        jumlahTransfusi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahTransfusi.setText("Jumlah Transfusi ");
        jPanel3.add(jumlahTransfusi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 240, 40));

        line13.setBackground(new java.awt.Color(255, 255, 255));
        line13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line13.setForeground(new java.awt.Color(255, 255, 255));
        line13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line13.setText("___________");
        jPanel3.add(line13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 100, 20));

        txtFieldUsia21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldUsia21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldUsia21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldUsia21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldUsia21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldUsia21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, 40));

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
        jPanel3.add(txtFieldRiwayatPenyakit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 240, 40));

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

        txtFieldBeratBadan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldBeratBadan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldBeratBadan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldBeratBadan21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldBeratBadan21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldBeratBadan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 100, 40));

        BeartBadan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BeartBadan.setForeground(new java.awt.Color(255, 255, 255));
        BeartBadan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BeartBadan.setText("Berat Badan *Kg");
        jPanel3.add(BeartBadan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 110, 40));

        jDateChooserTerakhirTransfusi.setDateFormatString("d MMM, yyyy");
        jDateChooserTerakhirTransfusi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jDateChooserTerakhirTransfusi, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 240, 40));

        tanggalLahir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir.setText("Tanggal Lahir");
        jPanel3.add(tanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 120, 30));

        jDateChooserTanggalLahir.setDateFormatString("d  MMM, yyyy");
        jDateChooserTanggalLahir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jDateChooserTanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 240, 40));

        jDateTanggalDaftar21552011235.setEnabled(false);
        jDateTanggalDaftar21552011235.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jDateTanggalDaftar21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateTanggalDaftar21552011235MouseClicked(evt);
            }
        });
        jPanel3.add(jDateTanggalDaftar21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 140, 40));

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

        jRadioButtonLakiLaki21552011235.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup1.add(jRadioButtonLakiLaki21552011235);
        jRadioButtonLakiLaki21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonLakiLaki21552011235.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonLakiLaki21552011235.setSelected(true);
        jRadioButtonLakiLaki21552011235.setText("Laki-laki");
        jRadioButtonLakiLaki21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLakiLaki21552011235ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButtonLakiLaki21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        jRadioButtonPerempuan21552011235.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup1.add(jRadioButtonPerempuan21552011235);
        jRadioButtonPerempuan21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonPerempuan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPerempuan21552011235.setText("Perempuan");
        jRadioButtonPerempuan21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPerempuan21552011235ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButtonPerempuan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        NamaPendonor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor1.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor1.setText("Nama");
        jPanel3.add(NamaPendonor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 40));

        NamaPendonor2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor2.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor2.setText("Nama");
        jPanel3.add(NamaPendonor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hexa-shape.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 1390, -1));

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
      changecolor(PanelClear21552011235, new Color (246,107,14));
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
          String tanggal_daftar = table.getValueAt(baris,0).toString();   
          //String no_pendonor = table.getValueAt(baris,1).toString();
          
          String nama = table.getValueAt(baris,2).toString();
          txtFieldNamaPendonor21552011235.setText(nama);
          
          String jenis_kelamin = table.getValueAt(baris,3).toString();
//          jRadioButtonLakiLaki21552011235.setText(jenis_kelamin);
//          jRadioButtonPerempuan21552011235.setText(jenis_kelamin);
          
          String tanggal_lahir = table.getValueAt(baris,4).toString();
          
          String no_telp = table.getValueAt(baris,5).toString();
          txtFieldNoTelp21552011235.setText(no_telp);
          
          String gmail = table.getValueAt(baris,6).toString();
          txtFieldAkunGmail21552011235.setText(gmail);
          
          String golongan_darah = table.getValueAt(baris,7).toString();
          
          String usia = table.getValueAt(baris,8).toString();
          txtFieldUsia21552011235.setText(usia);
          
          String berat_badan =  table.getValueAt(baris,9).toString();
          txtFieldBeratBadan21552011235.setText(berat_badan);
          
          String alamatpendonor =  table.getValueAt(baris,10).toString();
          txtFieldAlamat21552011235.setText(alamatpendonor);
          
          String hemoglobin =  table.getValueAt(baris,11).toString();
          
          String riwayat_penyakit =  table.getValueAt(baris,12).toString();
          txtFieldRiwayatPenyakit21552011235.setText(riwayat_penyakit);
          
          String jumlah_transfusi = table.getValueAt(baris,13).toString();
          txtFieldJumlahTransfusi21552011235.setText(jumlah_transfusi);
          
          String tanggal_terakhir_transfusi = table.getValueAt(baris,14).toString();

       
        Date convert = null;
        try{
            convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_daftar);  
            convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_lahir);
            convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_terakhir_transfusi);
        }catch(ParseException e){
            System.out.println(e);
        }
        jDateTanggalDaftar21552011235.setDate(convert);
        jDateChooserTanggalLahir.setDate(convert);
        jDateChooserTerakhirTransfusi.setDate(convert);
    }//GEN-LAST:event_tableDataPendonor21552011235MouseClicked

    private void jComboBoxHemoglobinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHemoglobinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxHemoglobinActionPerformed

    private void jComboBoxGolDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGolDarahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGolDarahActionPerformed

    private void txtFieldRiwayatPenyakit21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldRiwayatPenyakit21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldRiwayatPenyakit21552011235ActionPerformed

    private void BtnCari21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseClicked
        cari();
    }//GEN-LAST:event_BtnCari21552011235MouseClicked

    private void BtnCari21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseEntered
        changecolor(PanelCari21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnCari21552011235MouseEntered

    private void BtnCari21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseExited
        changecolor(PanelCari21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnCari21552011235MouseExited

    private void jRadioButtonLakiLaki21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLakiLaki21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonLakiLaki21552011235ActionPerformed

    private void jRadioButtonPerempuan21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPerempuan21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonPerempuan21552011235ActionPerformed

    private void jDateTanggalDaftar21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateTanggalDaftar21552011235MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateTanggalDaftar21552011235MouseClicked

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
        java.awt.EventQueue.invokeLater(() -> {
            new dataPendonor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeartBadan;
    private javax.swing.JLabel BtnAdd21552011235;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnBack77174756;
    private javax.swing.JLabel BtnCari21552011235;
    private javax.swing.JLabel BtnClear21552011235;
    private javax.swing.JLabel BtnDelete21552011235;
    private javax.swing.JLabel BtnEdit21552011235;
    private javax.swing.JLabel BtnRefresh21552011235;
    private javax.swing.JLabel DaftarMenu1;
    private javax.swing.JLabel NamaPendonor;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JLabel NamaPendonor2;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel Navbar1;
    private javax.swing.JPanel PanelAdd21552011235;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelBack77174756;
    private javax.swing.JPanel PanelCari21552011235;
    private javax.swing.JPanel PanelClear21552011235;
    private javax.swing.JPanel PanelDelete21552011235;
    private javax.swing.JPanel PanelEdit21552011235;
    private javax.swing.JPanel PanelRefresh21552011235;
    private javax.swing.JLabel TotalHarga;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel alamat2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel golDarah;
    private javax.swing.JLabel golDarah1;
    private javax.swing.JComboBox<String> jComboBoxGolDarah;
    private javax.swing.JComboBox<String> jComboBoxHemoglobin;
    private com.toedter.calendar.JDateChooser jDateChooserTanggalLahir;
    private com.toedter.calendar.JDateChooser jDateChooserTerakhirTransfusi;
    private com.toedter.calendar.JDateChooser jDateTanggalDaftar21552011235;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonLakiLaki21552011235;
    private javax.swing.JRadioButton jRadioButtonPerempuan21552011235;
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
    private javax.swing.JLabel line16;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel line9;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tableDataPendonor21552011235;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFieldAkunGmail21552011235;
    private javax.swing.JTextField txtFieldAlamat21552011235;
    private javax.swing.JTextField txtFieldBeratBadan21552011235;
    private javax.swing.JTextField txtFieldCari21552011235;
    private javax.swing.JTextField txtFieldJumlahTransfusi21552011235;
    private javax.swing.JTextField txtFieldNamaPendonor21552011235;
    private javax.swing.JTextField txtFieldNoTelp21552011235;
    private javax.swing.JTextField txtFieldRiwayatPenyakit21552011235;
    private javax.swing.JTextField txtFieldUsia21552011235;
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
