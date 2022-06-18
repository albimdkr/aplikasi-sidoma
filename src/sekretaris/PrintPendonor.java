/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekretaris;

import petugas.*;
import transaksi.*;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PrintPendonor extends javax.swing.JFrame {
     DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form daftarMenu
     */
   public PrintPendonor() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableData21552011235.setModel(table);
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
        int row = tableData21552011235.getRowCount();
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
                tableData21552011235.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }
    
    private void cari(){
        int row = tableData21552011235.getRowCount();
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
                tableData21552011235.setModel(table);
                
    }catch(SQLException e){
           System.out.println(e);
    }
  }
    
    
    
    
    

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
        DaftarMenu = new javax.swing.JLabel();
        PanelCari21552011235 = new javax.swing.JPanel();
        jPanelTranskasi = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BtnCari21552011235 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PanelCari77174756 = new javax.swing.JPanel();
        jPanelTranskasi1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        BtnCari77174756 = new javax.swing.JLabel();
        line6 = new javax.swing.JLabel();
        txtFieldCari77174756 = new javax.swing.JTextField();
        PanelPrint21552011235 = new javax.swing.JPanel();
        BtnPrint21552011235 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData21552011235 = new javax.swing.JTable();
        txtFieldCari21552011235 = new javax.swing.JTextField();

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

        DaftarMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DaftarMenu.setForeground(new java.awt.Color(255, 255, 255));
        DaftarMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DaftarMenu.setText("Print Data Pendonor");
        Navbar.add(DaftarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 280, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        PanelCari21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelCari21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCari21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTranskasi.setBackground(new java.awt.Color(17, 43, 60));
        jPanelTranskasi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanelTranskasi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(64, 49, 33));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel11.setLayout(new java.awt.GridBagLayout());
        jPanelTranskasi.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cari ");
        jPanelTranskasi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        PanelCari21552011235.add(jPanelTranskasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 140, 50));

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

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line.setForeground(new java.awt.Color(255, 255, 255));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("____________________________");
        jPanel2.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 20));

        jPanel3.setBackground(new java.awt.Color(17, 43, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCari77174756.setBackground(new java.awt.Color(64, 49, 33));
        PanelCari77174756.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCari77174756.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTranskasi1.setBackground(new java.awt.Color(64, 49, 33));
        jPanelTranskasi1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanelTranskasi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(64, 49, 33));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel12.setLayout(new java.awt.GridBagLayout());
        jPanelTranskasi1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cari ");
        jPanelTranskasi1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        PanelCari77174756.add(jPanelTranskasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 140, 50));

        BtnCari77174756.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCari77174756.setForeground(new java.awt.Color(255, 255, 255));
        BtnCari77174756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnCari77174756.setText("Cari ");
        BtnCari77174756.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCari77174756MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCari77174756MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCari77174756MouseExited(evt);
            }
        });
        PanelCari77174756.add(BtnCari77174756, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel3.add(PanelCari77174756, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 140, 50));

        line6.setBackground(new java.awt.Color(255, 255, 255));
        line6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line6.setForeground(new java.awt.Color(255, 255, 255));
        line6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line6.setText("____________________________");
        jPanel3.add(line6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 20));

        txtFieldCari77174756.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCari77174756.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFieldCari77174756.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCari77174756.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCari77174756.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCari77174756.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCari77174756, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 250, 50));

        PanelPrint21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelPrint21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelPrint21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPrint21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPrint21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrint21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPrint21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-print-32.png"))); // NOI18N
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
        PanelPrint21552011235.add(BtnPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 50));

        jPanel3.add(PanelPrint21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1330, 50));

        tableData21552011235.setModel(new javax.swing.table.DefaultTableModel(
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
        tableData21552011235.setSelectionBackground(new java.awt.Color(64, 49, 33));
        jScrollPane1.setViewportView(tableData21552011235);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1330, 340));

        txtFieldCari21552011235.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCari21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFieldCari21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCari21552011235.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCari21552011235.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCari21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 250, 50));

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
        new sekretaris.dashboardSekretaris().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
        changecolor(PanelBack21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    private void BtnBack21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseExited
        changecolor(PanelBack21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnBack21552011235MouseExited

    private void BtnCari21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseClicked
        cari();
    }//GEN-LAST:event_BtnCari21552011235MouseClicked

    private void BtnCari21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseEntered
        changecolor(PanelCari21552011235, new Color (32,108,151));
    }//GEN-LAST:event_BtnCari21552011235MouseEntered

    private void BtnCari21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari21552011235MouseExited
        changecolor(PanelCari21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnCari21552011235MouseExited

    private void BtnCari77174756MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari77174756MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCari77174756MouseExited

    private void BtnCari77174756MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari77174756MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCari77174756MouseEntered

    private void BtnCari77174756MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCari77174756MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCari77174756MouseClicked

    private void BtnPrint21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseExited
        changecolor(PanelPrint21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnPrint21552011235MouseExited

    private void BtnPrint21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseEntered
        changecolor(PanelPrint21552011235, new Color (64,49,33));
    }//GEN-LAST:event_BtnPrint21552011235MouseEntered

    private void BtnPrint21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrint21552011235MouseClicked
//      try{
//            String file = "/laporan/report_barista.jasper";
//            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),null,koneksi.getKoneksi());
//            JasperViewer.viewReport(print, false);
//            
//        }catch(JRException e){
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
    }//GEN-LAST:event_BtnPrint21552011235MouseClicked

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
            java.util.logging.Logger.getLogger(PrintPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintPendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintPendonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnCari21552011235;
    private javax.swing.JLabel BtnCari77174756;
    private javax.swing.JLabel BtnPrint21552011235;
    private javax.swing.JLabel DaftarMenu;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelBack21552011235;
    private javax.swing.JPanel PanelCari21552011235;
    private javax.swing.JPanel PanelCari77174756;
    private javax.swing.JPanel PanelPrint21552011235;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTranskasi;
    private javax.swing.JPanel jPanelTranskasi1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel line;
    private javax.swing.JLabel line6;
    private javax.swing.JTable tableData21552011235;
    private javax.swing.JTextField txtFieldCari21552011235;
    private javax.swing.JTextField txtFieldCari77174756;
    // End of variables declaration//GEN-END:variables
}
