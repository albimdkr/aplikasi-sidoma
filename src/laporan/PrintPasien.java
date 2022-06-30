/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan;

import sekretaris.*;
import admin.*;
import petugas.*;
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
public class PrintPasien extends javax.swing.JFrame {
     DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form daftarMenu
     */
    public PrintPasien() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableDataKelompok2.setModel(table);
        table.addColumn("Tanggal Daftar");
        table.addColumn("No. Pasien");
        table.addColumn("Nama");
        table.addColumn("Jenis Kelamin");
        table.addColumn("Tanggal Lahir");
        table.addColumn("No.Telp");
        table.addColumn("Gmail");
        table.addColumn("Golongan Darah");
        table.addColumn("Usia");
        table.addColumn("Berat Badan");
        table.addColumn("Alamat");
        table.addColumn("Kondisi");
        table.addColumn("Penyakit");
        table.addColumn("Total menerima labu");
        table.addColumn("Tanggal terakhir transfusi");
        tampilData();
    }
    
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataKelompok2.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `data_pasien`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    String no_pasien = rslt.getString("no_pasien");
                    String nama = rslt.getString("nama");
                    String jenis_kelamin = rslt.getString("jenis_kelamin");
                    String tanggal_lahir = rslt.getString("tanggal_lahir");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String golongan_darah = rslt.getString("golongan_darah");
                    String usia = rslt.getString("usia");
                    String berat_badan = rslt.getString("berat_badan");
                    String alamatpendonor = rslt.getString("alamat");
                    String kondisipasien = rslt.getString("kondisi");
                    String penyakit = rslt.getString("penyakit");
                    String total_menerima_labu = rslt.getString("total_menerima_labu");
                    String tanggal_terakhir_transfusi = rslt.getString("tanggal_terakhir_transfusi");
                    
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pasien,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,golongan_darah,usia,berat_badan,alamatpendonor,kondisipasien,penyakit,total_menerima_labu,tanggal_terakhir_transfusi};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataKelompok2.setModel(table);
            
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }
    
    private void cari(){
        int row = tableDataKelompok2.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
      String cari = txtFieldCariKelompok2.getText();
      String query = "SELECT * FROM `data_pasien` WHERE "
                + "`tanggal_daftar` LIKE '%"+cari+"%' OR"
                + "`no_pasien`  LIKE '%"+cari+"%' OR "
                + "`nama` LIKE '%"+cari+"%' OR"
                + "`jenis_kelamin` LIKE '%"+cari+"%' OR"
                + "`tanggal_lahir` LIKE '%"+cari+"%' OR"
                + "`no_telp` LIKE '%"+cari+"%' OR"
                + "`gmail` LIKE '%"+cari+"%' OR"
                + "`golongan_darah` LIKE '%"+cari+"%' OR"
                + "`usia` LIKE '%"+cari+"%' OR"
                + "`berat_badan` LIKE '%"+cari+"%' OR"
                + "`alamat` LIKE '%"+cari+"%' OR"
                + "`kondisi` LIKE '%"+cari+"%' OR"
                + "`penyakit` LIKE '%"+cari+"%' OR"
                + "`total_menerima_labu` LIKE '%"+cari+"%' OR"
                + "`tanggal_terakhir_transfusi` LIKE '%"+cari+"%' ";
                
       try{
           java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                    String tanggal_daftar = rslt.getString("tanggal_daftar");
                    String no_pasien = rslt.getString("no_pasien");
                    String nama = rslt.getString("nama");
                    String jenis_kelamin = rslt.getString("jenis_kelamin");
                    String tanggal_lahir = rslt.getString("tanggal_lahir");
                    String no_telp = rslt.getString("no_telp");
                    String gmail = rslt.getString("gmail");
                    String golongan_darah = rslt.getString("golongan_darah");
                    String usia = rslt.getString("usia");
                    String berat_badan = rslt.getString("berat_badan");
                    String alamatpendonor = rslt.getString("alamat");
                    String kondisipasien = rslt.getString("kondisi");
                    String penyakit = rslt.getString("penyakit");
                    String total_menerima_labu = rslt.getString("total_menerima_labu");
                    String tanggal_terakhir_transfusi = rslt.getString("tanggal_terakhir_transfusi");
                    
                //masukan semua data kedalam array
                String[] data = {tanggal_daftar,no_pasien,nama,jenis_kelamin,tanggal_lahir,no_telp,gmail,golongan_darah,usia,berat_badan,alamatpendonor,kondisipasien,penyakit,total_menerima_labu,tanggal_terakhir_transfusi};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tableDataKelompok2.setModel(table);
                
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
        PanelBackKelompok2 = new javax.swing.JPanel();
        BtnBackKelompok2 = new javax.swing.JLabel();
        DaftarMenu = new javax.swing.JLabel();
        PanelCariKelompok2 = new javax.swing.JPanel();
        jPanelTranskasi = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BtnCariKelompok2 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        line6 = new javax.swing.JLabel();
        PanelPrintKelompok2 = new javax.swing.JPanel();
        BtnPrinKelompok2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataKelompok2 = new javax.swing.JTable();
        txtFieldCariKelompok2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(64, 49, 33));
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

        DaftarMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DaftarMenu.setForeground(new java.awt.Color(255, 255, 255));
        DaftarMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DaftarMenu.setText("Print Data Transfusi");
        Navbar.add(DaftarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 280, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        PanelCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelCariKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCariKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        PanelCariKelompok2.add(jPanelTranskasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 140, 50));

        BtnCariKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnCariKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnCariKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-search-24.png"))); // NOI18N
        BtnCariKelompok2.setText("Cari ");
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
        PanelCariKelompok2.add(BtnCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel2.add(PanelCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 140, 50));

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line.setForeground(new java.awt.Color(255, 255, 255));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("____________________________");
        jPanel2.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 20));

        jPanel3.setBackground(new java.awt.Color(17, 43, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line6.setBackground(new java.awt.Color(255, 255, 255));
        line6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line6.setForeground(new java.awt.Color(255, 255, 255));
        line6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line6.setText("____________________________");
        jPanel3.add(line6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 270, 20));

        PanelPrintKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelPrintKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelPrintKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPrinKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPrinKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrinKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPrinKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-print-32.png"))); // NOI18N
        BtnPrinKelompok2.setText("Print");
        BtnPrinKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrinKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPrinKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPrinKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPrinKelompok2MouseExited(evt);
            }
        });
        PanelPrintKelompok2.add(BtnPrinKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 50));

        jPanel3.add(PanelPrintKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 1330, 50));

        tableDataKelompok2.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDataKelompok2.setSelectionBackground(new java.awt.Color(64, 49, 33));
        jScrollPane1.setViewportView(tableDataKelompok2);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1330, 340));

        txtFieldCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCariKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFieldCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCariKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCariKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCariKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 250, 50));

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
        changecolor(PanelBackKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnBackKelompok2MouseExited

    private void BtnCariKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseClicked
        cari();
    }//GEN-LAST:event_BtnCariKelompok2MouseClicked

    private void BtnCariKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseEntered
        changecolor(PanelCariKelompok2, new Color (32,108,151));
    }//GEN-LAST:event_BtnCariKelompok2MouseEntered

    private void BtnCariKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseExited
        changecolor(PanelCariKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnCariKelompok2MouseExited

    private void BtnPrinKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrinKelompok2MouseExited
        changecolor(PanelPrintKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnPrinKelompok2MouseExited

    private void BtnPrinKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrinKelompok2MouseEntered
        changecolor(PanelPrintKelompok2, new Color (64,49,33));
    }//GEN-LAST:event_BtnPrinKelompok2MouseEntered

    private void BtnPrinKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrinKelompok2MouseClicked
      try{
            String file = "/laporan/report_pasien.jasper";
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),null,koneksi.getKoneksi());
            JasperViewer.viewReport(print, false);
            
        }catch(JRException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_BtnPrinKelompok2MouseClicked

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
            java.util.logging.Logger.getLogger(PrintPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PrintPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBackKelompok2;
    private javax.swing.JLabel BtnCariKelompok2;
    private javax.swing.JLabel BtnPrinKelompok2;
    private javax.swing.JLabel DaftarMenu;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelBackKelompok2;
    private javax.swing.JPanel PanelCariKelompok2;
    private javax.swing.JPanel PanelPrintKelompok2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTranskasi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel line;
    private javax.swing.JLabel line6;
    private javax.swing.JTable tableDataKelompok2;
    private javax.swing.JTextField txtFieldCariKelompok2;
    // End of variables declaration//GEN-END:variables
}
