/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
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

/**
 *
 * @author albin
 */
public class pageTransaksi extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
  

    /**
     * Creates new form daftarMenu
     */
    public pageTransaksi() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        koneksi.getKoneksi();
        totalnya();
        tanggal();
        
        tb_keranjang.setModel(table);
        table.addColumn("ID");
        table.addColumn("Nama Menu");
        table.addColumn("Harga");
        table.addColumn("Jumlah");
        table.addColumn("Total Harga");
        
        tampilData();
    }
     private void tanggal(){
        Date now = new Date();  
        tgl_transaksi.setDate(now);
    }
     
//    
     
     private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tb_keranjang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String sql = "SELECT * FROM penjualan ORDER BY id_transaksi ";
        String procedures = "CALL `total_harga_transaksi`()";
        try{
            Connection c = koneksi.getKoneksi();//memanggil koneksi
            Statement s = c.createStatement();//membuat statement
            ResultSet rslt = s.executeQuery(sql);//menjalanakn query
//            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("id_transaksi");
                    String nama = rslt.getString("nama_menu");
                    String harga = rslt.getString("harga");
                    String jumlah = rslt.getString("jumlah");
                    String total = rslt.getString("total_harga");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,jumlah,total};
                
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
              
            tb_keranjang.setModel(table);
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }
     
     private void clear(){
        txFieldKodeMenu21552011235.setText(null);
        txtFieldNamaMenu21552011235.setText(null);
        txtFieldHarga21552011235.setText(null);
        txtFieldJumlah21552011235.setText(null);
        txtFieldTotalHarga21552011235.setText(null);
    }
     
     private void penjualan(){
        String kode = txFieldKodeMenu21552011235.getText();
        String nama = txtFieldNamaMenu21552011235.getText();
        String harga = txtFieldHarga21552011235.getText();
        String jumlah = txtFieldJumlah21552011235.getText();
        String total = txtFieldTotalHarga21552011235.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(date.format(tgl_transaksi.getDate()));
      
        //panggil koneksi
        Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `transaksi` (`tgl_transaksi`, `id_transaksi`, `kode_menu`, `nama_menu`,`harga`, `jumlah_menu`, `total_harga`) "
                + "VALUES ('"+tanggal+"', NULL, '"+kode+"', '"+nama+"', '"+harga+"', '"+jumlah+"', '"+total+"')";
        
        try{
            //menyiapkan statement untuk di eksekusi
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Pesanan Berhasil Masuk Ke Struk Penjualan");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Pesanan Gagal!!!");
            
        }finally{
            tampilData();
            clear();
            
        }
        totalnya();
    }
     
     private void hapusData(){
        int i = tb_keranjang.getSelectedRow();
        
        String kode = table.getValueAt(i, 0).toString();
        
        Connection connect = koneksi.getKoneksi();
        String sql = "DELETE FROM penjualan WHERE id_transaksi = "+kode+"";
        try{
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(sql);
            ps.execute();
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }finally{
            tampilData();
            clear();
        }
        totalnya();
    }
     
     private void totalnya(){
        String procedures = "CALL `total_harga_transaksi`()";
        
        try{
            Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(procedures);//menjalanakn query\
                while(rslt.next()){
                    txtFieldTotalBayar21552011235.setText(rslt.getString(1));
                }
                
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
     
     private void total(){
        String harga = txtFieldHarga21552011235.getText();
        String jumlah = txtFieldJumlah21552011235.getText();
        
        int hargaa = Integer.parseInt(harga);
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = hargaa * jumlahh;
        String total_harga = Integer.toString(total);
        
        txtFieldTotalHarga21552011235.setText(total_harga);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txtFieldJumlah21552011235.setText(null);
        }
    }
     
     private void reset(){
        txtFieldMasukanUang21552011235.setText(null);
    }
     
     private void kembalian(){
        String total = txtFieldTotalBayar21552011235.getText();
        String uang = txtFieldMasukanUang21552011235.getText();
        
        int totals = Integer.parseInt(total);
        try{
            int uangs = Integer.parseInt(uang);     
            int kembali = (uangs - totals);
            String fix = Integer.toString(kembali);
            txtFieldUangKembali21552011235.setText(fix);
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Transaksi Gagal, Ulang Kembali!!!");
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

        jPanel2 = new javax.swing.JPanel();
        Navbar = new javax.swing.JPanel();
        PanelBack21552011235 = new javax.swing.JPanel();
        BtnBack21552011235 = new javax.swing.JLabel();
        DaftarMenu = new javax.swing.JLabel();
        PanelCari21552011235 = new javax.swing.JPanel();
        BtnCari21552011235 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        line5 = new javax.swing.JLabel();
        Navbar1 = new javax.swing.JPanel();
        PanelBack77174756 = new javax.swing.JPanel();
        BtnBack77174756 = new javax.swing.JLabel();
        DaftarMenu1 = new javax.swing.JLabel();
        PanelBayar21552011235 = new javax.swing.JPanel();
        BtnBayar21552011235 = new javax.swing.JLabel();
        PanelAdd21552011235 = new javax.swing.JPanel();
        BtnAdd21552011235 = new javax.swing.JLabel();
        NamaMenu2 = new javax.swing.JLabel();
        line12 = new javax.swing.JLabel();
        line6 = new javax.swing.JLabel();
        txFieldKodeMenu21552011235 = new javax.swing.JTextField();
        NamaMenu3 = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        txtFieldNamaMenu21552011235 = new javax.swing.JTextField();
        line2 = new javax.swing.JLabel();
        txtFieldJumlah21552011235 = new javax.swing.JTextField();
        Jumlah = new javax.swing.JLabel();
        PaneDelete21552011235 = new javax.swing.JPanel();
        BtnDelete21552011235 = new javax.swing.JLabel();
        line11 = new javax.swing.JLabel();
        PanelPrint21552011235 = new javax.swing.JPanel();
        BtnPrint21552011235 = new javax.swing.JLabel();
        PanelReset21552011235 = new javax.swing.JPanel();
        BtnReset21552011235 = new javax.swing.JLabel();
        line4 = new javax.swing.JLabel();
        txtFieldHarga21552011235 = new javax.swing.JTextField();
        txtFieldTotalHarga21552011235 = new javax.swing.JTextField();
        totalHarga = new javax.swing.JLabel();
        txtFieldMasukanUang21552011235 = new javax.swing.JTextField();
        MasukanUang = new javax.swing.JLabel();
        txtFieldUangKembali21552011235 = new javax.swing.JTextField();
        uangKembali = new javax.swing.JLabel();
        tgl_transaksi = new com.toedter.calendar.JDateChooser();
        MasukanUang1 = new javax.swing.JLabel();
        txtFieldTotalBayar21552011235 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_keranjang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(64, 49, 33));
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navbar.setBackground(new java.awt.Color(45, 35, 23));
        Navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBack21552011235.setBackground(new java.awt.Color(45, 35, 23));
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

        DaftarMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DaftarMenu.setForeground(new java.awt.Color(255, 255, 255));
        DaftarMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DaftarMenu.setText("Transaksi");
        Navbar.add(DaftarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 280, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        PanelCari21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelCari21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCari21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnCari21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCari21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnCari21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnCari21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-search-24.png"))); // NOI18N
        BtnCari21552011235.setText("Cari ");
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
        PanelCari21552011235.add(BtnCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel2.add(PanelCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 140, 50));

        jPanel3.setBackground(new java.awt.Color(64, 49, 33));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line5.setBackground(new java.awt.Color(255, 255, 255));
        line5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line5.setForeground(new java.awt.Color(255, 255, 255));
        line5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line5.setText("____________________________");
        jPanel3.add(line5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 270, 20));

        Navbar1.setBackground(new java.awt.Color(45, 35, 23));
        Navbar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBack77174756.setBackground(new java.awt.Color(45, 35, 23));
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
        DaftarMenu1.setText("Transaksi");
        Navbar1.add(DaftarMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 280, 60));

        jPanel3.add(Navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        PanelBayar21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelBayar21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelBayar21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBayar21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnBayar21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnBayar21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBayar21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-credit-card-20.png"))); // NOI18N
        BtnBayar21552011235.setText("Bayar");
        BtnBayar21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBayar21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBayar21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBayar21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBayar21552011235MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnBayar21552011235MousePressed(evt);
            }
        });
        PanelBayar21552011235.add(BtnBayar21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 60));

        jPanel3.add(PanelBayar21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 540, 400, 60));

        PanelAdd21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelAdd21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelAdd21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAdd21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAdd21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnAdd21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAdd21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-plus-+-24.png"))); // NOI18N
        BtnAdd21552011235.setText("Add Whislist");
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
        PanelAdd21552011235.add(BtnAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 50));

        jPanel3.add(PanelAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 590, 50));

        NamaMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaMenu2.setForeground(new java.awt.Color(255, 255, 255));
        NamaMenu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaMenu2.setText("Harga");
        jPanel3.add(NamaMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 90, 40));

        line12.setBackground(new java.awt.Color(255, 255, 255));
        line12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line12.setForeground(new java.awt.Color(255, 255, 255));
        line12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line12.setText("_________________________________________________________________");
        jPanel3.add(line12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 620, 20));

        line6.setBackground(new java.awt.Color(255, 255, 255));
        line6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line6.setForeground(new java.awt.Color(255, 255, 255));
        line6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line6.setText("____________________________");
        jPanel3.add(line6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 20));

        txFieldKodeMenu21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txFieldKodeMenu21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txFieldKodeMenu21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txFieldKodeMenu21552011235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txFieldKodeMenu21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txFieldKodeMenu21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txFieldKodeMenu21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 250, 40));

        NamaMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaMenu3.setForeground(new java.awt.Color(255, 255, 255));
        NamaMenu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaMenu3.setText("Nama Menu");
        jPanel3.add(NamaMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, 40));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("____________________________");
        jPanel3.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 270, 20));

        txtFieldNamaMenu21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldNamaMenu21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNamaMenu21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNamaMenu21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNamaMenu21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldNamaMenu21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 280, 40));

        line2.setBackground(new java.awt.Color(255, 255, 255));
        line2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line2.setForeground(new java.awt.Color(255, 255, 255));
        line2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line2.setText("____________________________");
        jPanel3.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 270, 20));

        txtFieldJumlah21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldJumlah21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldJumlah21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldJumlah21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldJumlah21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldJumlah21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldJumlah21552011235ActionPerformed(evt);
            }
        });
        txtFieldJumlah21552011235.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldJumlah21552011235KeyReleased(evt);
            }
        });
        jPanel3.add(txtFieldJumlah21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 260, 40));

        Jumlah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jumlah.setForeground(new java.awt.Color(255, 255, 255));
        Jumlah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jumlah.setText("Jumlah");
        jPanel3.add(Jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, 40));

        PaneDelete21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PaneDelete21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PaneDelete21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDelete21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDelete21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnDelete21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-trash-24.png"))); // NOI18N
        BtnDelete21552011235.setText("Delete");
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
        PaneDelete21552011235.add(BtnDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jPanel3.add(PaneDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 110, 50));

        line11.setBackground(new java.awt.Color(255, 255, 255));
        line11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line11.setForeground(new java.awt.Color(255, 255, 255));
        line11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line11.setText("____________________________________________");
        jPanel3.add(line11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 400, 20));

        PanelPrint21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelPrint21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelPrint21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPrint21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPrint21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrint21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPrint21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-print-24.png"))); // NOI18N
        BtnPrint21552011235.setText("Print");
        BtnPrint21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrint21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPrint21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPrint21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPrint21552011235MouseExited(evt);
            }
        });
        PanelPrint21552011235.add(BtnPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jPanel3.add(PanelPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 610, 160, 50));

        PanelReset21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelReset21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelReset21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnReset21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnReset21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnReset21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnReset21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-reset-24.png"))); // NOI18N
        BtnReset21552011235.setText("Reset");
        BtnReset21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReset21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnReset21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnReset21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnReset21552011235MouseExited(evt);
            }
        });
        PanelReset21552011235.add(BtnReset21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jPanel3.add(PanelReset21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 110, 50));

        line4.setBackground(new java.awt.Color(255, 255, 255));
        line4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line4.setForeground(new java.awt.Color(255, 255, 255));
        line4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line4.setText("____________________________");
        jPanel3.add(line4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 270, 20));

        txtFieldHarga21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldHarga21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldHarga21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldHarga21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldHarga21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldHarga21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldHarga21552011235ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldHarga21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 270, 40));

        txtFieldTotalHarga21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldTotalHarga21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldTotalHarga21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldTotalHarga21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldTotalHarga21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldTotalHarga21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 260, 40));

        totalHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalHarga.setForeground(new java.awt.Color(255, 255, 255));
        totalHarga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalHarga.setText("Total Harga");
        jPanel3.add(totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 110, 40));

        txtFieldMasukanUang21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldMasukanUang21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldMasukanUang21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldMasukanUang21552011235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldMasukanUang21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldMasukanUang21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldMasukanUang21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 400, 40));

        MasukanUang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MasukanUang.setForeground(new java.awt.Color(255, 255, 255));
        MasukanUang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MasukanUang.setText("Total Bayar");
        jPanel3.add(MasukanUang, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 240, 30));

        txtFieldUangKembali21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldUangKembali21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldUangKembali21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldUangKembali21552011235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldUangKembali21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldUangKembali21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldUangKembali21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 580, 40));

        uangKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uangKembali.setForeground(new java.awt.Color(255, 255, 255));
        uangKembali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uangKembali.setText("Uang Kembalian");
        jPanel3.add(uangKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 140, 40));

        tgl_transaksi.setDateFormatString("dd-MM-yyyy");
        tgl_transaksi.setEnabled(false);
        tgl_transaksi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel3.add(tgl_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 400, 40));

        MasukanUang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MasukanUang1.setForeground(new java.awt.Color(255, 255, 255));
        MasukanUang1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MasukanUang1.setText("Masukan Uang Bayar");
        jPanel3.add(MasukanUang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 160, 30));

        txtFieldTotalBayar21552011235.setEditable(false);
        txtFieldTotalBayar21552011235.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtFieldTotalBayar21552011235.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldTotalBayar21552011235.setEnabled(false);
        txtFieldTotalBayar21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtFieldTotalBayar21552011235MouseReleased(evt);
            }
        });
        txtFieldTotalBayar21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTotalBayar21552011235ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldTotalBayar21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, 400, 50));

        tb_keranjang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tb_keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_keranjang.setSelectionBackground(new java.awt.Color(64, 49, 33));
        tb_keranjang.setSelectionForeground(new java.awt.Color(204, 204, 255));
        tb_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_keranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_keranjang);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 400, 120));

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
        new petugas.dashboardPetugas().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
        changecolor(PanelBack21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    private void BtnBack21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseExited
        changecolor(PanelBack21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnBack21552011235MouseExited

    private void BtnCari21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseClicked
//     new transaksi.stokMenu().setVisible(true);
//     dispose(); 
     new stokMenu().setVisible(true);
     dispose();
    }//GEN-LAST:event_BtnCari21552011235MouseClicked

    private void BtnCari21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseEntered
        changecolor(PanelCari21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnCari21552011235MouseEntered

    private void BtnCari21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseExited
        changecolor(PanelCari21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnCari21552011235MouseExited

    private void BtnReset21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReset21552011235MouseClicked
        try{
            String clear = "TRUNCATE `penjualan`";
            Connection connect = koneksi.getKoneksi();
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(clear);
            ps.execute();
  
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            tampilData();
            totalnya();
            txtFieldMasukanUang21552011235.setText(null);
            txtFieldUangKembali21552011235.setText(null);
        }
    }//GEN-LAST:event_BtnReset21552011235MouseClicked

    private void BtnReset21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReset21552011235MouseEntered
        changecolor(PanelReset21552011235, new Color (224,77,1));
    }//GEN-LAST:event_BtnReset21552011235MouseEntered

    private void BtnReset21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReset21552011235MouseExited
        changecolor(PanelReset21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnReset21552011235MouseExited

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
        penjualan();
    }//GEN-LAST:event_BtnAdd21552011235MouseClicked

    private void BtnAdd21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAdd21552011235MouseEntered
       changecolor(PanelAdd21552011235, new Color (78,159,61));
    }//GEN-LAST:event_BtnAdd21552011235MouseEntered

    private void BtnAdd21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAdd21552011235MouseExited
       changecolor(PanelAdd21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnAdd21552011235MouseExited

    private void BtnDelete21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseClicked
        hapusData();
        txtFieldMasukanUang21552011235.setText(null);
        txtFieldUangKembali21552011235.setText(null);
    }//GEN-LAST:event_BtnDelete21552011235MouseClicked

    private void BtnDelete21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseEntered
      changecolor(PaneDelete21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnDelete21552011235MouseEntered

    private void BtnDelete21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseExited
      changecolor(PaneDelete21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnDelete21552011235MouseExited

    private void BtnPrint21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseClicked
      try{
            String file = "/struk/struk.jasper";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            HashMap param = new HashMap();
            
            param.put("total",txtFieldTotalBayar21552011235.getText());
            param.put("uang",txtFieldMasukanUang21552011235.getText());
            param.put("kembalian",txtFieldUangKembali21552011235.getText());
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,koneksi.getKoneksi());
            JasperViewer.viewReport(print, false);
            
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | JRException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnPrint21552011235MouseClicked

    private void BtnPrint21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseEntered
      changecolor(PanelPrint21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnPrint21552011235MouseEntered

    private void BtnPrint21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseExited
       changecolor(PanelPrint21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnPrint21552011235MouseExited

    private void BtnBayar21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBayar21552011235MouseClicked
        kembalian();
    }//GEN-LAST:event_BtnBayar21552011235MouseClicked

    private void BtnBayar21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBayar21552011235MouseEntered
        changecolor(PanelBayar21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnBayar21552011235MouseEntered

    private void BtnBayar21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBayar21552011235MouseExited
        changecolor(PanelBayar21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnBayar21552011235MouseExited

    private void BtnBayar21552011235MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBayar21552011235MousePressed
        
    }//GEN-LAST:event_BtnBayar21552011235MousePressed

    private void txtFieldJumlah21552011235KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldJumlah21552011235KeyReleased
        total();
    }//GEN-LAST:event_txtFieldJumlah21552011235KeyReleased

    private void txtFieldTotalBayar21552011235MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldTotalBayar21552011235MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTotalBayar21552011235MouseReleased

    private void txtFieldTotalBayar21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldTotalBayar21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTotalBayar21552011235ActionPerformed

    private void tb_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_keranjangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_keranjangMouseClicked

    private void txtFieldHarga21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldHarga21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldHarga21552011235ActionPerformed

    private void txtFieldJumlah21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldJumlah21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldJumlah21552011235ActionPerformed

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
            java.util.logging.Logger.getLogger(pageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pageTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnAdd21552011235;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnBack77174756;
    private javax.swing.JLabel BtnBayar21552011235;
    private javax.swing.JLabel BtnCari21552011235;
    private javax.swing.JLabel BtnDelete21552011235;
    private javax.swing.JLabel BtnPrint21552011235;
    private javax.swing.JLabel BtnReset21552011235;
    private javax.swing.JLabel DaftarMenu;
    private javax.swing.JLabel DaftarMenu1;
    private javax.swing.JLabel Jumlah;
    private javax.swing.JLabel MasukanUang;
    private javax.swing.JLabel MasukanUang1;
    private javax.swing.JLabel NamaMenu2;
    private javax.swing.JLabel NamaMenu3;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel Navbar1;
    private javax.swing.JPanel PaneDelete21552011235;
    private javax.swing.JPanel PanelAdd21552011235;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelBack77174756;
    private javax.swing.JPanel PanelBayar21552011235;
    private javax.swing.JPanel PanelCari21552011235;
    private javax.swing.JPanel PanelPrint21552011235;
    private javax.swing.JPanel PanelReset21552011235;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel line11;
    private javax.swing.JLabel line12;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel line4;
    private javax.swing.JLabel line5;
    private javax.swing.JLabel line6;
    private javax.swing.JLabel line8;
    private javax.swing.JTable tb_keranjang;
    private com.toedter.calendar.JDateChooser tgl_transaksi;
    private javax.swing.JLabel totalHarga;
    public javax.swing.JTextField txFieldKodeMenu21552011235;
    public javax.swing.JTextField txtFieldHarga21552011235;
    public javax.swing.JTextField txtFieldJumlah21552011235;
    public static javax.swing.JTextField txtFieldMasukanUang21552011235;
    public javax.swing.JTextField txtFieldNamaMenu21552011235;
    public static javax.swing.JTextField txtFieldTotalBayar21552011235;
    public javax.swing.JTextField txtFieldTotalHarga21552011235;
    public static javax.swing.JTextField txtFieldUangKembali21552011235;
    private javax.swing.JLabel uangKembali;
    // End of variables declaration//GEN-END:variables

    private static class r {
        
    }
}
