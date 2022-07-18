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
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Date;
import java.sql.*;
/**
 *
 * @author albin
 */
public class PrintKeuanganKeluar extends javax.swing.JFrame {
     DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form daftarMenu
     */
    public PrintKeuanganKeluar() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //TimeJSpinner();
        //tanggal();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
         
        tableDataKelompok2.setModel(table);
        table.addColumn("No. Uang");
        table.addColumn("Tanggal");
        table.addColumn("Bulan");
        table.addColumn("Tahun");
        table.addColumn("Keterangan");
        table.addColumn("Uang Keluar");
        //table.addColumn("Waktu");
        tampilData();
    }
    
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tableDataKelompok2.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `data_keuangankeluar`";
        
        try{
            java.sql.Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                    String no_uang = rslt.getString("no_uang");
                    String tanggal = rslt.getString("tanggal");
                    String bulan = rslt.getString("bulan");
                    String tahun = rslt.getString("tahun");
                    String keterangan_uang = rslt.getString("keterangan");
                    String uang_keluar = rslt.getString("uang_keluar");
                //masukan semua data kedalam array
                String[] data = {no_uang,tanggal,bulan,tahun,keterangan_uang,uang_keluar}; //,waktu_uang
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
        
      String query = "SELECT * FROM `data_keuangankeluar` WHERE "
                + "`no_uang` LIKE '%"+cari+"%' OR"
                + "`tanggal`  LIKE '%"+cari+"%' OR "
                + "`bulan`  LIKE '%"+cari+"%' OR "
                + "`tahun`  LIKE '%"+cari+"%' OR "
                + "`keterangan` LIKE '%"+cari+"%' ";
                
       try{
           Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                
                    String no_uang = rslt.getString("no_uang");
                    String tanggal = rslt.getString("tanggal");
                    String bulan = rslt.getString("bulan");
                    String tahun = rslt.getString("tahun");
                    String keterangan_uang = rslt.getString("keterangan");
                    String uang_keluar = rslt.getString("uang_keluar");
                //masukan semua data kedalam array
                String[] data = {no_uang,tanggal,bulan,tahun,keterangan_uang,uang_keluar};  //,waktu_uang
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
        BtnCariKelompok2 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        line6 = new javax.swing.JLabel();
        PanelPrintKelompok2 = new javax.swing.JPanel();
        BtnPrintKelompok2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataKelompok2 = new javax.swing.JTable();
        txtFieldCariKelompok2 = new javax.swing.JTextField();
        jDateChooserAwalKelompok2 = new com.toedter.calendar.JDateChooser();
        jDateChooserAkhirKelompok2 = new com.toedter.calendar.JDateChooser();
        NamaPendonor1 = new javax.swing.JLabel();
        NamaPendonor2 = new javax.swing.JLabel();
        NamaPendonor3 = new javax.swing.JLabel();

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
        DaftarMenu.setText("Print Data Keuangan Masuk");
        Navbar.add(DaftarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 340, 60));

        jPanel2.add(Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        PanelCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        PanelCariKelompok2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelCariKelompok2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        BtnPrintKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPrintKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrintKelompok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPrintKelompok2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-print-32.png"))); // NOI18N
        BtnPrintKelompok2.setText("Print");
        BtnPrintKelompok2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrintKelompok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPrintKelompok2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnPrintKelompok2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnPrintKelompok2MouseExited(evt);
            }
        });
        PanelPrintKelompok2.add(BtnPrintKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 50));

        jPanel3.add(PanelPrintKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 1010, 50));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 1010, 270));

        txtFieldCariKelompok2.setBackground(new java.awt.Color(17, 43, 60));
        txtFieldCariKelompok2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFieldCariKelompok2.setForeground(new java.awt.Color(255, 255, 255));
        txtFieldCariKelompok2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldCariKelompok2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFieldCariKelompok2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtFieldCariKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 250, 50));
        jPanel3.add(jDateChooserAwalKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 260, 40));
        jPanel3.add(jDateChooserAkhirKelompok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 260, 40));

        NamaPendonor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor1.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor1.setText("Input Tanggal Akhir Yang Akan Di Print ");
        jPanel3.add(NamaPendonor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 290, 40));

        NamaPendonor2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor2.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor2.setText("Sampai Tanggal");
        jPanel3.add(NamaPendonor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 110, 40));

        NamaPendonor3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamaPendonor3.setForeground(new java.awt.Color(255, 255, 255));
        NamaPendonor3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaPendonor3.setText("Input Tanggal Awal Yang Akan Di Print ");
        jPanel3.add(NamaPendonor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 290, 40));

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

    private void BtnCariKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseClicked
        cari();
    }//GEN-LAST:event_BtnCariKelompok2MouseClicked

    private void BtnCariKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseEntered
        changecolor(PanelCariKelompok2, new Color (32,108,151));
    }//GEN-LAST:event_BtnCariKelompok2MouseEntered

    private void BtnCariKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCariKelompok2MouseExited
        changecolor(PanelCariKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnCariKelompok2MouseExited

    private void BtnPrintKelompok2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrintKelompok2MouseExited
        changecolor(PanelPrintKelompok2, new Color (17,43,60));
    }//GEN-LAST:event_BtnPrintKelompok2MouseExited

    private void BtnPrintKelompok2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrintKelompok2MouseEntered
        changecolor(PanelPrintKelompok2, new Color (64,49,33));
    }//GEN-LAST:event_BtnPrintKelompok2MouseEntered

    private void BtnPrintKelompok2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrintKelompok2MouseClicked
//      try{
//            String file = "/laporan/report_keuanganMasuk.jasper";
//            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),null,koneksi.getKoneksi());
//            JasperViewer.viewReport(print, false);
//            
//        }catch(JRException e){
//            JOptionPane.showMessageDialog(rootPane, e);
//        }

    try{
        Map<String, Object> parameter = new HashMap <>();
        parameter.put("awal", jDateChooserAwalKelompok2.getDate());
        parameter.put("akhir", jDateChooserAkhirKelompok2.getDate());
        File file = new File ("src/laporan/report_keuanganKeluar.jrxml");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_sidoma","root","");
        JasperDesign jasperDesign = JRXmlLoader.load(file);;
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, con);
        JasperViewer.viewReport(jasperPrint,false);
    
        
    }    catch (JRException ex) {   
             Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(Level.SEVERE, null, ex);
 
    }    catch (SQLException ex) {
             Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_BtnPrintKelompok2MouseClicked

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
            java.util.logging.Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintKeuanganKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new PrintKeuanganKeluar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BtnBackKelompok2;
    private javax.swing.JLabel BtnCariKelompok2;
    private javax.swing.JLabel BtnPrintKelompok2;
    private javax.swing.JLabel DaftarMenu;
    private javax.swing.JLabel NamaPendonor1;
    private javax.swing.JLabel NamaPendonor2;
    private javax.swing.JLabel NamaPendonor3;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PanelBackKelompok2;
    private javax.swing.JPanel PanelCariKelompok2;
    private javax.swing.JPanel PanelPrintKelompok2;
    private com.toedter.calendar.JDateChooser jDateChooserAkhirKelompok2;
    private com.toedter.calendar.JDateChooser jDateChooserAwalKelompok2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel line;
    private javax.swing.JLabel line6;
    private javax.swing.JTable tableDataKelompok2;
    private javax.swing.JTextField txtFieldCariKelompok2;
    // End of variables declaration//GEN-END:variables
}
