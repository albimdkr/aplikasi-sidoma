/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekretaris;

//import com.toedter.calendar.JDateChooser;
import sekretaris.*;
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





/**
 *
 * @author albin
 */
public class FormPetugas extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form daftarMenu
     */
    
        private void tanggal(){
        Date now = new Date();  
        jDateTanggalDaftarKelompok2.setDate(now);    
    }
    
    public FormPetugas() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableDataPetugas21552011235.setModel(table);
        table.addColumn("Id Petugas");
        table.addColumn("Nama");
        table.addColumn("Jenis Kelamin");
        table.addColumn("No Telp");
        table.addColumn("Gmail");
        table.addColumn("Alamat");
        table.addColumn("Jabatan");
        table.addColumn("Tanggal Daftar");
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataPetugas21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `data_petugas`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                    String id_petugas = rslt.getString("id_petugas");
                    String nama = rslt.getString("nama");
                    String jk = rslt.getString("jenis_kelamin");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String alamatpetugas = rslt.getString("alamat");
                    String jabatan = rslt.getString("jabatan");
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    
                    
                //masukan semua data kedalam array
                String[] data = {id_petugas,nama,jk,no_telp,gmail,alamatpetugas,jabatan,tanggal_daftar};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPetugas21552011235.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }  

    
    private void clear(){
          //*id_petugas
          txtFieldNamaPetugasKelompok2.setText(null);
          buttonGroup2.clearSelection();
          txtFieldNoTelpKelompok2.setText(null);
          txtFieldAkunGmailKelompok2.setText(null);
          txtFieldAlamatKelompok2.setText(null);
          jComboBoxJabatanKelompok2.setSelectedIndex(0);
          //jDateChooserTanggalDaftar.setCalendar(null);
    }
    
    
    private void tambahData(){
        //String id_petugas
        String nama = txtFieldNamaPetugasKelompok2.getText();
        String jk;
        if (jRadioButtonLakiLakiKelompok2.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        String no_telp = txtFieldNoTelpKelompok2.getText();
        String gmail = txtFieldAkunGmailKelompok2.getText();
        String alamatpetugas = txtFieldAlamatKelompok2.getText();
        String jabatan = (String) jComboBoxJabatanKelompok2.getSelectedItem();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_daftar = tanggal.format(jDateTanggalDaftarKelompok2.getDate());
       
        //panggil koneksi
        java.sql.Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `data_petugas` (`id_petugas`,`nama`,`jenis_kelamin`,`no_telp`,`gmail`,`alamat`,`jabatan`,`tanggal_daftar`) " 
                     + "VALUES (NULL,'"+nama+"','"+jk+"','"+no_telp+"','"+gmail+"','"+alamatpetugas+"','"+jabatan+"','"+tanggal_daftar+"')";
        
        try{ 
            //menyiapkan statement untuk di eksekusi
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan!!!");
            
        }finally{
            tampilData();
            clear();
            
        }
    }
    

    
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tableDataPetugas21552011235.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data ?","Konfirmasi Hapus Data Petugas ", JOptionPane.YES_NO_OPTION);
        
        if (ok==0){
            String id_petugas = table.getValueAt(i, 0).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "DELETE FROM `data_petugas` WHERE `data_petugas`.`id_petugas` = "+id_petugas+" ";
   
            try {
                PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
                ps.execute();
                JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!!!"+e);
            }finally{
                tampilData();
                clear();
            }
        }
    }
    
    
    private void editData(){
        int i = tableDataPetugas21552011235.getSelectedRow();
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Mengedit Data ?","Konfirmasi Edit Kegiatan", JOptionPane.YES_NO_OPTION);
        
        //String id_petugas
        String nama = txtFieldNamaPetugasKelompok2.getText();
        String jk;
        if (jRadioButtonLakiLakiKelompok2.isSelected()){
            jk = "Laki-Laki";
        }else {
            jk = "Perempuan";
        }
        String no_telp = txtFieldNoTelpKelompok2.getText();
        String gmail = txtFieldAkunGmailKelompok2.getText();
        String alamatpetugas = txtFieldAlamatKelompok2.getText();
        String jabatan = (String) jComboBoxJabatanKelompok2.getSelectedItem();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal_daftar = tanggal.format(jDateTanggalDaftarKelompok2.getDate());
        
        if (ok==0){
            String id_petugas = table.getValueAt(i, 0).toString();
            java.sql.Connection connect = koneksi.getKoneksi();
            String query = "UPDATE `data_petugas` SET `nama` = '"+nama+"',`jenis_kelamin` = '"+jk+"', `no_telp` = '"+no_telp+"',`gmail` = '"+gmail+"',`alamat` = '"+alamatpetugas+"',`jabatan` = '"+jabatan+"',`tanggal_daftar` = '"+tanggal_daftar+"'"
                + "WHERE `data_petugas`.`id_petugas` = '"+id_petugas+"';";
            
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
        int row = tableDataPetugas21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
      String cari = txtFieldCariKelompok2.getText();
      String query = "SELECT * FROM `data_petugas` WHERE "
                + "`id_petugas` LIKE '%"+cari+"%' OR"
                + "`nama`  LIKE '%"+cari+"%' OR "
                + "`jenis_kelamin` LIKE '%"+cari+"%' OR"
                + "`no_telp` LIKE '%"+cari+"%' OR"
                + "`gmail` LIKE '%"+cari+"%' OR"
                + "`alamat` LIKE '%"+cari+"%' OR"
                + "`jabatan` LIKE '%"+cari+"%' OR"
                + "`tanggal_daftar` LIKE '%"+cari+"%'  ";
                
       try{
           java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                    String id_petugas = rslt.getString("id_petugas");
                    String nama = rslt.getString("nama");
                    String jk = rslt.getString("jenis_kelamin");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String alamatpetugas = rslt.getString("alamat");
                    String jabatan = rslt.getString("jabatan");
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    
                String[] data = {id_petugas,nama,jk,no_telp,gmail,alamatpetugas,jabatan,tanggal_daftar};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataPetugas21552011235.setModel(table);
                
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
        jPanel3 = new javax.swing.JPanel();
        PanelAddKelompok2 = new javax.swing.JPanel();
        BtnAddKelompok2 = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        PanelClearKelompok2 = new javax.swing.JPanel();
        BtnClearKelompok2 = new javax.swing.JLabel();
        PanelRefreshKelompok2 = new javax.swing.JPanel();
        BtnRefreshKelompok2 = new javax.swing.JLabel();
        PanelDeleteKelompok2 = new javax.swing.JPanel();
        BtnDeleteKelompok2 = new javax.swing.JLabel();
        PanelEditKelompok2 = new javax.swing.JPanel();
        BtnEditKelompok2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataPetugas21552011235 = new javax.swing.JTable();
        txtFieldNamaPetugasKelompok2 = new javax.swing.JTextField();
        tanggalLahir = new javax.swing.JLabel();
        line16 = new javax.swing.JLabel();
        txtFieldCariKelompok2 = new javax.swing.JTextField();
        PanelCariKelompok2 = new javax.swing.JPanel();
        BtnCari21552011235 = new javax.swing.JLabel();
        jComboBoxJabatanKelompok2 = new javax.swing.JComboBox<>();
        NamaPendonor1 = new javax.swing.JLabel();
        jDateTanggalDaftarKelompok2 = new com.toedter.calendar.JDateChooser();
        TotalHarga = new javax.swing.JLabel();
        jRadioButtonLakiLakiKelompok2 = new javax.swing.JRadioButton();
        jRadioButtonPerempuanKelompok2 = new javax.swing.JRadioButton();
        NamaPendonor = new javax.swing.JLabel();
        line9 = new javax.swing.JLabel();
        txtFieldNoTelpKelompok2 = new javax.swing.JTextField();
        noTelp = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        txtFieldAkunGmailKelompok2 = new javax.swing.JTextField();
        kondisi = new javax.swing.JLabel();
        line10 = new javax.swing.JLabel();
        txtFieldAlamatKelompok2 = new javax.swing.JTextField();
        alamat = new javax.swing.JLabel();
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
        title.setText(" Form Petugas");
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
        PanelAddKelompok2.add(BtnAddKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        jPanel3.add(PanelAddKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 950, 50));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("___________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 260, 20));

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

        tableDataPetugas21552011235.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tableDataPetugas21552011235.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDataPetugas21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableDataPetugas21552011235.setSelectionBackground(new java.awt.Color(32, 83, 117));
        tableDataPetugas21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPetugas21552011235MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataPetugas21552011235);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1320, 130));

        txtFieldNamaPetugasKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNamaPetugasKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaPetugasKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaPetugasKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaPetugasKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaPetugasKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 250, 40));

        tanggalLahir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLahir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalLahir.setText("Jabatan PDDM");
        jPanel3.add(tanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 120, 20));

        line16.setBackground(new java.awt.Color(255, 255, 255));
        line16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line16.setForeground(new java.awt.Color(255, 255, 255));
        line16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        line16.setText("_________________");
        jPanel3.add(line16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 160, 20));

        txtFieldCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCariKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCariKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCariKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCariKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 160, 50));

        PanelCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelCariKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCariKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PanelCariKelompok2.add(BtnCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel3.add(PanelCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 130, 50));

        jComboBoxJabatanKelompok2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Pembina", "Ketua", "Wakil Ketua", "Sekretaris", "Wakil Sekretaris", "Bendahara", "Wakil Bendahara", "Kodinator Lapangan", "Anggota Lapangan", "KordinatorLogistik", "Anggota Logistik", "Kordinator Humas", "Anggota Humas", "Petugas Medis", "Anggota", " " }));
        jComboBoxJabatanKelompok2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBoxJabatanKelompok2InputMethodTextChanged(evt);
            }
        });
        jPanel3.add(jComboBoxJabatanKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 280, 40));

        NamaPendonor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor1.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor1.setText("Nama");
        jPanel3.add(NamaPendonor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 50, 40));

        jDateTanggalDaftarKelompok2.setDateFormatString("d MMM, yyyy");
        jDateTanggalDaftarKelompok2.setEnabled(false);
        jDateTanggalDaftarKelompok2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jDateTanggalDaftarKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateTanggalDaftarKelompok2MouseClicked(evt);
            }
        });
        jPanel3.add(jDateTanggalDaftarKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 180, 40));

        TotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        TotalHarga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalHarga.setText("Tanggal");
        TotalHarga.setToolTipText("");
        jPanel3.add(TotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, 40));

        jRadioButtonLakiLakiKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup2.add(jRadioButtonLakiLakiKelompok2);
        jRadioButtonLakiLakiKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonLakiLakiKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonLakiLakiKelompok2.setText("Laki-laki");
        jRadioButtonLakiLakiKelompok2.setActionCommand("");
        jPanel3.add(jRadioButtonLakiLakiKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jRadioButtonPerempuanKelompok2.setBackground(new java.awt.Color(32, 83, 117));
        buttonGroup2.add(jRadioButtonPerempuanKelompok2);
        jRadioButtonPerempuanKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonPerempuanKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPerempuanKelompok2.setText("Perempuan");
        jRadioButtonPerempuanKelompok2.setActionCommand("");
        jPanel3.add(jRadioButtonPerempuanKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        NamaPendonor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor.setText("Jenis Kelamin");
        jPanel3.add(NamaPendonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 100, 50));

        line9.setBackground(new java.awt.Color(255, 255, 255));
        line9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line9.setForeground(new java.awt.Color(255, 255, 255));
        line9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line9.setText("___________________________");
        jPanel3.add(line9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, 20));

        txtFieldNoTelpKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldNoTelpKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNoTelpKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNoTelpKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNoTelpKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNoTelpKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 250, 40));

        noTelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noTelp.setForeground(new java.awt.Color(255, 255, 255));
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noTelp.setText("No Telephone");
        jPanel3.add(noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 40));

        line12.setBackground(new java.awt.Color(255, 255, 255));
        line12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line12.setForeground(new java.awt.Color(255, 255, 255));
        line12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line12.setText("___________________________");
        jPanel3.add(line12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 260, 20));

        txtFieldAkunGmailKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAkunGmailKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAkunGmailKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAkunGmailKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAkunGmailKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAkunGmailKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 260, 40));

        kondisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kondisi.setForeground(new java.awt.Color(255, 255, 255));
        kondisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kondisi.setText("Gmail");
        jPanel3.add(kondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 120, 40));

        line10.setBackground(new java.awt.Color(255, 255, 255));
        line10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line10.setForeground(new java.awt.Color(255, 255, 255));
        line10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line10.setText("___________________________________________________________________");
        jPanel3.add(line10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 610, 20));

        txtFieldAlamatKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldAlamatKelompok2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldAlamatKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldAlamatKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldAlamatKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldAlamatKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 600, 40));

        alamat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        alamat.setText("Alamat");
        jPanel3.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 40));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hexa-shape.png"))); // NOI18N
        jPanel3.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1390, -1));

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
        new sekretaris.dashboardSekretaris().setVisible(true);
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

    private void tableDataPetugas21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPetugas21552011235MouseClicked
        // TODO add your handling code here:
          int baris = tableDataPetugas21552011235.getSelectedRow();
          
          //String id_petugas = table.getValueAt(baris,0).toString();
          String nama = table.getValueAt(baris,1).toString();
          txtFieldNamaPetugasKelompok2.setText(nama);
          
          String jenis_kelamin = table.getValueAt(baris,2).toString();
            if (jenis_kelamin.equals("Laki-laki")) {
                jRadioButtonPerempuanKelompok2.setSelected(true);
            } else if (jenis_kelamin.equals("Perempuan")) {
                jRadioButtonLakiLakiKelompok2.setSelected(true);
            }
            
          String no_telp = table.getValueAt(baris,3).toString();
          txtFieldNoTelpKelompok2.setText(no_telp);

          String gmail  = table.getValueAt(baris,4).toString();
          txtFieldAkunGmailKelompok2.setText(gmail);
          
          String alamatpetugas =  table.getValueAt(baris,5).toString();
          txtFieldAlamatKelompok2.setText(alamatpetugas);
          
          String jabatan = table.getValueAt(baris,6).toString();
          for (int i = 0; i <jComboBoxJabatanKelompok2.getItemCount(); i++ ){
              if (jComboBoxJabatanKelompok2.getItemAt(i).equalsIgnoreCase(jabatan)){
                  jComboBoxJabatanKelompok2.setSelectedIndex(i);
              }
          }
          
        Date tanggal_daftar = null;
        try{
            tanggal_daftar = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(baris,7));
        }catch(ParseException e){  
            System.out.println(e);
        }
        jDateTanggalDaftarKelompok2.setDate(tanggal_daftar); 
    }//GEN-LAST:event_tableDataPetugas21552011235MouseClicked

    private void BtnCari21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseClicked
        cari();
    }//GEN-LAST:event_BtnCari21552011235MouseClicked

    private void BtnCari21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseEntered
        changecolor(PanelCariKelompok2, new Color (32,83,117));
    }//GEN-LAST:event_BtnCari21552011235MouseEntered

    private void BtnCari21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseExited
        changecolor(PanelCariKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnCari21552011235MouseExited

    private void jComboBoxJabatanKelompok2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBoxJabatanKelompok2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxJabatanKelompok2InputMethodTextChanged

    private void jDateTanggalDaftarKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateTanggalDaftarKelompok2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateTanggalDaftarKelompok2MouseClicked
    
   
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
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new FormPetugas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnAddKelompok2;
    private javax.swing.JLabel BtnBackKelompok2;
    private javax.swing.JLabel BtnCari21552011235;
    private javax.swing.JLabel BtnClearKelompok2;
    private javax.swing.JLabel BtnDeleteKelompok2;
    private javax.swing.JLabel BtnEditKelompok2;
    private javax.swing.JLabel BtnRefreshKelompok2;
    private javax.swing.JLabel NamaPendonor;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelAddKelompok2;
    private javax.swing.JPanel PanelBackKelompok2;
    private javax.swing.JPanel PanelCariKelompok2;
    private javax.swing.JPanel PanelClearKelompok2;
    private javax.swing.JPanel PanelDeleteKelompok2;
    private javax.swing.JPanel PanelEditKelompok2;
    private javax.swing.JPanel PanelRefreshKelompok2;
    private javax.swing.JLabel TotalHarga;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBoxJabatanKelompok2;
    private com.toedter.calendar.JDateChooser jDateTanggalDaftarKelompok2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonLakiLakiKelompok2;
    private javax.swing.JRadioButton jRadioButtonPerempuanKelompok2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kondisi;
    private javax.swing.JLabel line10;
    private javax.swing.JLabel line12;
    private javax.swing.JLabel line16;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel line9;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tableDataPetugas21552011235;
    private javax.swing.JLabel tanggalLahir;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFieldAkunGmailKelompok2;
    private javax.swing.JTextField txtFieldAlamatKelompok2;
    private javax.swing.JTextField txtFieldCariKelompok2;
    private javax.swing.JTextField txtFieldNamaPetugasKelompok2;
    private javax.swing.JTextField txtFieldNoTelpKelompok2;
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
