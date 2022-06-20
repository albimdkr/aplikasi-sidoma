/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import admin.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import login.loginUser;
import com.toedter.calendar.JDateChooser;
import koneksi.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author albin
 */
public class akunBarista extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form daftarMenu
     */
    public akunBarista() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        
        Date now = new Date();  
        txtTanggal21552011235.setDate(now); 
        
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
        
        tableAkunBarista21552011235.setModel(table);
        table.addColumn("ID");
        table.addColumn("Nama Barista");
        table.addColumn("Email");
        table.addColumn("Alamat");
        table.addColumn("Username");
        table.addColumn("Password");
        table.addColumn("Tanggal Pendaftaran");
        
        tampilData();
    }
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableAkunBarista21552011235.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `barista` ";
        
        try{
            Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String id = rslt.getString("id_barista");
                    String nama = rslt.getString("nama_barista");
                    String email = rslt.getString("email");
                    String alamat = rslt.getString("alamat");
                    String username = rslt.getString("username");
                    String password = rslt.getString("password");
                    String tanggal = rslt.getString("tanggal_pendaftaran");
                    
                //masukan semua data kedalam array
                String[] data = {id,nama,email,alamat,username,password,tanggal};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableAkunBarista21552011235.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }
    
    private void clear(){
//        txt_kodebarang.setText(null);
        txtFieldNama21552011235.setText(null);
        txtFieldEmail21552011235.setText(null);
        txtAlamat21552011235.setText(null);
        txtFieldUsername21552011235.setText(null);
        txtFieldPassword21552011235.setText(null);
//        tgl_daftar.setDate(null);
    }
    
    private void tambahData(){
//        String kode = txt_kodebarang.getText();
        String nama = txtFieldNama21552011235.getText();
        String email = txtFieldEmail21552011235.getText();
        String alamat = txtAlamat21552011235.getText();
        String username = txtFieldUsername21552011235.getText();
        String password = txtFieldPassword21552011235.getText();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(txtTanggal21552011235.getDate());
        
        //panggil koneksi
        Connection connect = koneksi.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `barista` (`id_barista`, `nama_barista`, `email`,`alamat`, `username`, `password`, `tanggal_pendaftaran`) "
                     + "VALUES (NULL, '"+nama+"', '"+email+"','"+alamat+"', '"+username+"', '"+password+"','"+tanggal+"')";
        
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
    
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tableAkunBarista21552011235.getSelectedRow();
        
        String id = table.getValueAt(i, 0).toString();
        
        Connection connect = koneksi.getKoneksi();
        
        String query = "DELETE FROM `barista` WHERE `barista`.`id_barista` = "+id+" ";
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
        int i = tableAkunBarista21552011235.getSelectedRow();
        
        String id = table.getValueAt(i, 0).toString();
        String nama = txtFieldNama21552011235.getText();
        String email = txtFieldEmail21552011235.getText();
        String alamat = txtAlamat21552011235.getText();
        String username = txtFieldUsername21552011235.getText();
        String password = txtFieldPassword21552011235.getText();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(txtTanggal21552011235.getDate());
        
        Connection connect = koneksi.getKoneksi();
        
        String query = "UPDATE `barista` SET `nama_barista` = '"+nama+"', `email` = '"+email+"', `alamat` = '"+alamat+"', `tanggal_pendaftaran` = '"+tanggal+"', "
                + "`username` = '"+username+"', `password` = '"+password+"' "
                + "WHERE `barista`.`id_barista` = '"+id+"';";

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
        alamat = new javax.swing.JPanel();
        line5 = new javax.swing.JLabel();
        Navbar1 = new javax.swing.JPanel();
        PanelBack77174756 = new javax.swing.JPanel();
        BtnBack77174756 = new javax.swing.JLabel();
        DaftarMenu1 = new javax.swing.JLabel();
        txtFieldUsername21552011235 = new javax.swing.JTextField();
        PanelAdd21552011235 = new javax.swing.JPanel();
        BtnAdd21552011235 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        txtFieldNama21552011235 = new javax.swing.JTextField();
        line2 = new javax.swing.JLabel();
        txtFieldEmail21552011235 = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        line10 = new javax.swing.JLabel();
        txtFieldPassword21552011235 = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        PanelClear21552011235 = new javax.swing.JPanel();
        BtnClear21552011235 = new javax.swing.JLabel();
        PanelDelete21552011235 = new javax.swing.JPanel();
        BtnDelete21552011235 = new javax.swing.JLabel();
        PanelPrint21552011235 = new javax.swing.JPanel();
        BtnPrint21552011235 = new javax.swing.JLabel();
        PanelEdit21552011235 = new javax.swing.JPanel();
        BtnEdit21552011235 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat21552011235 = new javax.swing.JTextArea();
        Email1 = new javax.swing.JLabel();
        Email2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAkunBarista21552011235 = new javax.swing.JTable();
        txtTanggal21552011235 = new com.toedter.calendar.JDateChooser();

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
        DaftarMenu.setText("Data Barista");
        Navbar.add(DaftarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 280, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        alamat.setBackground(new java.awt.Color(64, 49, 33));
        alamat.setPreferredSize(new java.awt.Dimension(1366, 768));
        alamat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line5.setBackground(new java.awt.Color(255, 255, 255));
        line5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line5.setForeground(new java.awt.Color(255, 255, 255));
        line5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line5.setText("_________________________________________");
        alamat.add(line5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 380, 20));

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

        alamat.add(Navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        txtFieldUsername21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldUsername21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldUsername21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldUsername21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldUsername21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldUsername21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUsername21552011235ActionPerformed(evt);
            }
        });
        alamat.add(txtFieldUsername21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 370, 40));

        PanelAdd21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelAdd21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelAdd21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAdd21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAdd21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnAdd21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAdd21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-plus-+-24.png"))); // NOI18N
        BtnAdd21552011235.setText("Add");
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
        PanelAdd21552011235.add(BtnAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 50));

        alamat.add(PanelAdd21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 490, 50));

        Username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Username.setText("Username");
        alamat.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 90, 40));

        Nama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Nama.setForeground(new java.awt.Color(255, 255, 255));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nama.setText("Nama");
        alamat.add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, 40));

        line8.setBackground(new java.awt.Color(255, 255, 255));
        line8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line8.setForeground(new java.awt.Color(255, 255, 255));
        line8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line8.setText("_________________________________________");
        alamat.add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 380, 20));

        txtFieldNama21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldNama21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldNama21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldNama21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldNama21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        alamat.add(txtFieldNama21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 370, 40));

        line2.setBackground(new java.awt.Color(255, 255, 255));
        line2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line2.setForeground(new java.awt.Color(255, 255, 255));
        line2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line2.setText("_________________________________________");
        alamat.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 380, 20));

        txtFieldEmail21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldEmail21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldEmail21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldEmail21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldEmail21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        alamat.add(txtFieldEmail21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 380, 40));

        Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Tanggal Pendaftaran");
        alamat.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 150, 40));

        line10.setBackground(new java.awt.Color(255, 255, 255));
        line10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line10.setForeground(new java.awt.Color(255, 255, 255));
        line10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line10.setText("_________________________________________");
        alamat.add(line10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 380, 20));

        txtFieldPassword21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtFieldPassword21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldPassword21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldPassword21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldPassword21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        alamat.add(txtFieldPassword21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 370, 40));

        password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        password.setText("Password");
        alamat.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 150, 40));

        PanelClear21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelClear21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelClear21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnClear21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnClear21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnClear21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnClear21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-minus-sign-24.png"))); // NOI18N
        BtnClear21552011235.setText("Clear");
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
        PanelClear21552011235.add(BtnClear21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        alamat.add(PanelClear21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 210, 50));

        PanelDelete21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelDelete21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDelete21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PanelDelete21552011235.add(BtnDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        alamat.add(PanelDelete21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 630, 210, 50));

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
        PanelPrint21552011235.add(BtnPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        alamat.add(PanelPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, 210, 50));

        PanelEdit21552011235.setBackground(new java.awt.Color(64, 49, 33));
        PanelEdit21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelEdit21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnEdit21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEdit21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnEdit21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnEdit21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-edit-24.png"))); // NOI18N
        BtnEdit21552011235.setText("Edit");
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
        PanelEdit21552011235.add(BtnEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        alamat.add(PanelEdit21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 210, 50));

        txtAlamat21552011235.setBackground(new java.awt.Color(64, 49, 33));
        txtAlamat21552011235.setColumns(20);
        txtAlamat21552011235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAlamat21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtAlamat21552011235.setRows(5);
        jScrollPane2.setViewportView(txtAlamat21552011235);

        alamat.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 370, 40));

        Email1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Email1.setForeground(new java.awt.Color(255, 255, 255));
        Email1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email1.setText("Email");
        alamat.add(Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 100, 40));

        Email2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Email2.setForeground(new java.awt.Color(255, 255, 255));
        Email2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email2.setText("Alamat");
        alamat.add(Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 100, 40));

        tableAkunBarista21552011235.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableAkunBarista21552011235.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAkunBarista21552011235.setSelectionBackground(new java.awt.Color(64, 49, 33));
        tableAkunBarista21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAkunBarista21552011235MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAkunBarista21552011235);

        alamat.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 1020, 210));

        txtTanggal21552011235.setEnabled(false);
        txtTanggal21552011235.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTanggal21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTanggal21552011235MouseClicked(evt);
            }
        });
        alamat.add(txtTanggal21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 380, 40));

        jPanel2.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 780));

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
        new admin.dashboardAdmin2().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
        changecolor(PanelBack21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    private void BtnBack21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseExited
        changecolor(PanelBack21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnBack21552011235MouseExited

    private void BtnEdit21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseClicked
        editData();
    }//GEN-LAST:event_BtnEdit21552011235MouseClicked

    private void BtnEdit21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseEntered
        changecolor(PanelEdit21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnEdit21552011235MouseEntered

    private void BtnEdit21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEdit21552011235MouseExited
        changecolor(PanelEdit21552011235, new Color (64,49,33));
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
       changecolor(PanelAdd21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnAdd21552011235MouseExited

    private void BtnClear21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseClicked
        clear();
    }//GEN-LAST:event_BtnClear21552011235MouseClicked

    private void BtnClear21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseEntered
      changecolor(PanelClear21552011235, new Color (224,77,1));
    }//GEN-LAST:event_BtnClear21552011235MouseEntered

    private void BtnClear21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClear21552011235MouseExited
      changecolor(PanelClear21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnClear21552011235MouseExited

    private void BtnPrint21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseClicked
       try{
            String file = "/laporan/report_barista.jasper";
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),null,koneksi.getKoneksi());
            JasperViewer.viewReport(print, false);
            
        }catch(JRException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    
    }//GEN-LAST:event_BtnPrint21552011235MouseClicked

    private void BtnPrint21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseEntered
      changecolor(PanelPrint21552011235, new Color (45,35,23));
    }//GEN-LAST:event_BtnPrint21552011235MouseEntered

    private void BtnPrint21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseExited
       changecolor(PanelPrint21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnPrint21552011235MouseExited

    private void txtFieldUsername21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUsername21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldUsername21552011235ActionPerformed

    private void BtnDelete21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseClicked
       hapusData();
    }//GEN-LAST:event_BtnDelete21552011235MouseClicked

    private void BtnDelete21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseEntered
      changecolor(PanelDelete21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnDelete21552011235MouseEntered

    private void BtnDelete21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDelete21552011235MouseExited
       changecolor(PanelDelete21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnDelete21552011235MouseExited

    private void tableAkunBarista21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAkunBarista21552011235MouseClicked
        int baris = tableAkunBarista21552011235.getSelectedRow();

        String nama = table.getValueAt(baris,1).toString();
        txtFieldNama21552011235.setText(nama);

        String email = table.getValueAt(baris, 2).toString();
        txtFieldEmail21552011235.setText(email);

        String alamat = table.getValueAt(baris, 3).toString();
        txtAlamat21552011235.setText(alamat);

        String username = table.getValueAt(baris, 4).toString();
        txtFieldUsername21552011235.setText(username);

        String password = table.getValueAt(baris, 5).toString();
        txtFieldPassword21552011235.setText(password);

        String tanggal = table.getValueAt(baris, 6).toString();

        Date convert = null;
        try{
            convert = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
        }catch(Exception e){
            System.out.println(e);
        }
        txtTanggal21552011235.setDate(convert);

    }//GEN-LAST:event_tableAkunBarista21552011235MouseClicked

    private void txtTanggal21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTanggal21552011235MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggal21552011235MouseClicked

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
            java.util.logging.Logger.getLogger(akunBarista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(akunBarista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(akunBarista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(akunBarista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new akunBarista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnAdd21552011235;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnBack77174756;
    private javax.swing.JLabel BtnClear21552011235;
    private javax.swing.JLabel BtnDelete21552011235;
    private javax.swing.JLabel BtnEdit21552011235;
    private javax.swing.JLabel BtnPrint21552011235;
    private javax.swing.JLabel DaftarMenu;
    private javax.swing.JLabel DaftarMenu1;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Email1;
    private javax.swing.JLabel Email2;
    private javax.swing.JLabel Nama;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel Navbar1;
    private javax.swing.JPanel PanelAdd21552011235;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelBack77174756;
    private javax.swing.JPanel PanelClear21552011235;
    private javax.swing.JPanel PanelDelete21552011235;
    private javax.swing.JPanel PanelEdit21552011235;
    private javax.swing.JPanel PanelPrint21552011235;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel alamat;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel line10;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel line5;
    private javax.swing.JLabel line8;
    private javax.swing.JLabel password;
    private javax.swing.JTable tableAkunBarista21552011235;
    private javax.swing.JTextArea txtAlamat21552011235;
    private javax.swing.JTextField txtFieldEmail21552011235;
    private javax.swing.JTextField txtFieldNama21552011235;
    private javax.swing.JTextField txtFieldPassword21552011235;
    private javax.swing.JTextField txtFieldUsername21552011235;
    private com.toedter.calendar.JDateChooser txtTanggal21552011235;
    // End of variables declaration//GEN-END:variables
}
