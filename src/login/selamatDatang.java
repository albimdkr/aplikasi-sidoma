/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import static com.sun.deploy.uitoolkit.impl.fx.ui.MixedCodeInSwing.show;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Compiler.disable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author albi mudakar
 */
public class selamatDatang extends javax.swing.JFrame {

    /**
     * Creates new form loginUser
     */
    public selamatDatang() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jpanelLogin21552011235 = new javax.swing.JPanel();
        CloseBtn21552011235 = new javax.swing.JLabel();
        SelamatDatang = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        Sistem = new javax.swing.JLabel();
        sidoma = new javax.swing.JLabel();
        panelLogin21552011235 = new javax.swing.JPanel();
        BtnLogin21552011235 = new javax.swing.JLabel();
        panelBantuan21552011235 = new javax.swing.JPanel();
        BtnBantuan21552011235 = new javax.swing.JLabel();
        versi = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        sidoma3 = new javax.swing.JLabel();
        sidoma2 = new javax.swing.JLabel();
        sidoma1 = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        Developed1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LoadingLabel = new javax.swing.JLabel();
        hexaBackgorund = new javax.swing.JLabel();
        Map = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelLogin21552011235.setBackground(new java.awt.Color(17, 43, 60));
        jpanelLogin21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CloseBtn21552011235.setBackground(new java.awt.Color(0, 0, 0));
        CloseBtn21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-close-32.png"))); // NOI18N
        CloseBtn21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseBtn21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseBtn21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseBtn21552011235MouseEntered(evt);
            }
        });
        jpanelLogin21552011235.add(CloseBtn21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        SelamatDatang.setBackground(new java.awt.Color(255, 255, 255));
        SelamatDatang.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        SelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        SelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelamatDatang.setText("Selamat Datang");
        jpanelLogin21552011235.add(SelamatDatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setForeground(new java.awt.Color(255, 255, 255));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("___________");
        jpanelLogin21552011235.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 80, -1));

        Sistem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Sistem.setForeground(new java.awt.Color(255, 255, 255));
        Sistem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Sistem.setText("Di Sistem Informasi Donor Darah Majalaya");
        jpanelLogin21552011235.add(Sistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 330, 36));

        sidoma.setBackground(new java.awt.Color(0, 0, 0));
        sidoma.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma.setForeground(new java.awt.Color(255, 255, 255));
        sidoma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma.setText("MAJALAYA");
        jpanelLogin21552011235.add(sidoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, 36));

        panelLogin21552011235.setBackground(new java.awt.Color(17, 43, 60));
        panelLogin21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelLogin21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnLogin21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnLogin21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnLogin21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-login-24.png"))); // NOI18N
        BtnLogin21552011235.setText("Login");
        BtnLogin21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogin21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLogin21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnLogin21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnLogin21552011235MouseExited(evt);
            }
        });
        panelLogin21552011235.add(BtnLogin21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        jpanelLogin21552011235.add(panelLogin21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 280, 50));

        panelBantuan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        panelBantuan21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelBantuan21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBantuan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        BtnBantuan21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnBantuan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnBantuan21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBantuan21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-help-24.png"))); // NOI18N
        BtnBantuan21552011235.setText("Bantuan");
        BtnBantuan21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBantuan21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBantuan21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBantuan21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBantuan21552011235MouseExited(evt);
            }
        });
        panelBantuan21552011235.add(BtnBantuan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        jpanelLogin21552011235.add(panelBantuan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 280, 50));

        versi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        versi.setForeground(new java.awt.Color(255, 255, 255));
        versi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        versi.setText("v1.0");
        jpanelLogin21552011235.add(versi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 80, 30));

        LoadingValue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(255, 255, 255));
        LoadingValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadingValue.setText("0%");
        jpanelLogin21552011235.add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 40, 36));

        sidoma3.setBackground(new java.awt.Color(0, 0, 0));
        sidoma3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma3.setForeground(new java.awt.Color(255, 255, 255));
        sidoma3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma3.setText("PDDM");
        jpanelLogin21552011235.add(sidoma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 120, 36));

        sidoma2.setBackground(new java.awt.Color(0, 0, 0));
        sidoma2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma2.setForeground(new java.awt.Color(255, 255, 255));
        sidoma2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pddm_100px-removebg-preview.png"))); // NOI18N
        jpanelLogin21552011235.add(sidoma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, 100));

        sidoma1.setBackground(new java.awt.Color(0, 0, 0));
        sidoma1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma1.setForeground(new java.awt.Color(255, 255, 255));
        sidoma1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma1.setText("SIDOMA");
        jpanelLogin21552011235.add(sidoma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 120, 36));

        LoadingBar.setBackground(new java.awt.Color(255, 0, 0));
        jpanelLogin21552011235.add(LoadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 530, 10));

        Developed1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Developed1.setForeground(new java.awt.Color(255, 255, 255));
        Developed1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Developed1.setText("Developed By © Kelompok II  2022");
        jpanelLogin21552011235.add(Developed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 240, 36));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colorRED1234.png"))); // NOI18N
        jpanelLogin21552011235.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 290, 40));

        LoadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LoadingLabel.setText("Loading...");
        jpanelLogin21552011235.add(LoadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 280, 36));

        hexaBackgorund.setBackground(new java.awt.Color(255, 255, 255));
        hexaBackgorund.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/HEXABACKCONNECT.png"))); // NOI18N
        jpanelLogin21552011235.add(hexaBackgorund, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 520, 440));

        Map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/map-majalaya-logo-FIKS.png"))); // NOI18N
        jpanelLogin21552011235.add(Map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 250));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linePNG.png"))); // NOI18N
        jpanelLogin21552011235.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 440));

        getContentPane().add(jpanelLogin21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 813, -1));

        setSize(new java.awt.Dimension(813, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    
    private void CloseBtn21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBtn21552011235MouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseBtn21552011235MouseClicked

    private void CloseBtn21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBtn21552011235MouseEntered
       
    }//GEN-LAST:event_CloseBtn21552011235MouseEntered

    private void BtnLogin21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogin21552011235MouseClicked
        new login.loginUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnLogin21552011235MouseClicked

    private void BtnLogin21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogin21552011235MouseEntered
       changecolor(panelLogin21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnLogin21552011235MouseEntered

    private void BtnLogin21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogin21552011235MouseExited
        changecolor(panelLogin21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnLogin21552011235MouseExited

    private void BtnBantuan21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBantuan21552011235MouseClicked
        new login.bantuan().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnBantuan21552011235MouseClicked

    private void BtnBantuan21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBantuan21552011235MouseEntered
        changecolor(panelBantuan21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnBantuan21552011235MouseEntered

    private void BtnBantuan21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBantuan21552011235MouseExited
         changecolor(panelBantuan21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnBantuan21552011235MouseExited

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        selamatDatang sp = new selamatDatang();
        sp.setVisible(true);
        
        try {
            for (int i=0;i<=100;i++){
                Thread.sleep(100);
                sp.LoadingValue.setText(i+ "%");
                
                if (i==10){
                    sp.LoadingLabel.setText("Turning On Module...");
                }
                
                if (i==20){
                   sp.LoadingLabel.setText("Loading Module...");
                }
                
                if (i==30){
                    sp.LoadingLabel.setText("Connecting To Database...");
                }
                
                if (i==80){
                    sp.LoadingLabel.setText("Connecting Successfull...");
                }
                
                 if (i==90){
                     sp.LoadingLabel.setText("Launching Application SIDOMA...");
                 }
                 
                 sp.LoadingBar.setValue(i);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBantuan21552011235;
    private javax.swing.JLabel BtnLogin21552011235;
    private javax.swing.JLabel CloseBtn21552011235;
    private javax.swing.JLabel Developed1;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel Map;
    private javax.swing.JLabel SelamatDatang;
    private javax.swing.JLabel Sistem;
    private javax.swing.JLabel hexaBackgorund;
    private javax.swing.JLabel image;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpanelLogin21552011235;
    private javax.swing.JLabel line;
    private javax.swing.JPanel panelBantuan21552011235;
    private javax.swing.JPanel panelLogin21552011235;
    private javax.swing.JLabel sidoma;
    private javax.swing.JLabel sidoma1;
    private javax.swing.JLabel sidoma2;
    private javax.swing.JLabel sidoma3;
    private javax.swing.JLabel versi;
    // End of variables declaration//GEN-END:variables

    private void changecolor(JLabel CloseBtn21552011235, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
