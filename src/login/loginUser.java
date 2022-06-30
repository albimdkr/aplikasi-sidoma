/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

//import static petugas.dashboardPetugas.UserNamePetugas21552011235;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import koneksi.koneksi;
import static admin.dashboardAdmin.usernameAdminKelompok2;
import static sekretaris.dashboardSekretaris.usernameSekretarisKelompok2;
import static bendahara.dashboardBendahara.usernameBendaharaKelompok2;
import static petugas.dashboardPetugas.usernamePetugasKelompok2;
//import admin.dashboardAdmin;
//import sekretaris.dashboardSekretaris;
//import bendahara.dashboardBendahara;
//import petugas.dashboardPetugas;

/**
 *
 * @author albi mudakar
 */
public class loginUser extends javax.swing.JFrame {
    
        
    
    /**
     * Creates new form login
     */
    
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
    //private Object usernameAdmin21552011235;
    
        

    public loginUser() {
        initComponents();
        txtusername21552011235.setBackground(new java.awt.Color(0,0,0,1));
        txtpasswordPetugas21552011235.setBackground(new java.awt.Color(0,0,0,1));
        koneksi.getKoneksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void login(){
        String username = txtusername21552011235.getText();
        String password = txtpasswordPetugas21552011235.getText();
        String role = jComboBoxRoleUser21552011235.getSelectedItem().toString();
        
        if (username.equals("")|| password.equals("")||role.equals("Select")){
            JOptionPane.showMessageDialog(null, "Username atau Password anda Salah");
        } else {
            try{
            con = (Connection) koneksi.getKoneksi();
            pst = con.prepareStatement ("select * from data_user where username=? and password=?");
            pst.setString(1,username);
            pst.setString(2, password);
            
            rs = pst.executeQuery();
            if(rs.next()){
                String s1 = rs.getString("role");
                String un = rs.getString("username");
                if(role.equalsIgnoreCase("Admin")&& s1.equalsIgnoreCase("Admin")){
//                    dashboardAdmin adm = new admin.dashboardAdmin(un);
//                    adm.setVisible(true);
//                    setVisible(false);
//                    dispose();
                    new admin.dashboardAdmin().setVisible(true);
                    dispose();
                    usernameAdminKelompok2.setText(rs.getString(2));
                    
                    }
                if(role.equalsIgnoreCase("Sekretaris")&& s1.equalsIgnoreCase("Sekretaris")){
//                    dashboardSekretaris skr = new sekretaris.dashboardSekretaris(un);
//                    skr.setVisible(true);
//                    setVisible(false);
//                    dispose();
                    new sekretaris.dashboardSekretaris().setVisible(true);
                    dispose();
                    usernameSekretarisKelompok2.setText(rs.getString(2));
                    }
                if(role.equalsIgnoreCase("Bendahara")&& s1.equalsIgnoreCase("Bendahara")){
//                    dashboardBendahara bdr = new bendahara.dashboardBendahara(un);
//                    bdr.setVisible(true);
//                    setVisible(false);
//                    dispose();
                    new bendahara.dashboardBendahara().setVisible(true);
                    dispose();
                    usernameBendaharaKelompok2.setText(rs.getString(2));
                    }
                if(role.equalsIgnoreCase("Petugas")&& s1.equalsIgnoreCase("Petugas")){
//                    dashboardPetugas ptgs = new petugas.dashboardPetugas(un);
//                    ptgs.setVisible(true);
//                    setVisible(false);
//                    dispose();
                   new petugas.dashboardPetugas().setVisible(true);
                   dispose();
                   usernamePetugasKelompok2.setText(rs.getString(2));
                    }
                } else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!!!");
                txtusername21552011235.setText(null);
                txtpasswordPetugas21552011235.setText(null);
                jComboBoxRoleUser21552011235.setSelectedIndex(0);
            }
            
        }catch(SQLException | HeadlessException e ){
            System.out.println(e);
        }
      }
    }
       
       
            
//    catch(SQLException | HeadlessException e ){
//            System.out.println(e);
//        }
//    }
//    
    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jpanelPetugas21552011235 = new javax.swing.JPanel();
        BtnBack21552011235 = new javax.swing.JLabel();
        txtusername21552011235 = new javax.swing.JTextField();
        txtpasswordPetugas21552011235 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sidoma = new javax.swing.JLabel();
        sidoma3 = new javax.swing.JLabel();
        sidoma2 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        langkop = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PanelLoginPetugas21552011235 = new javax.swing.JPanel();
        BtnLoginBarista21552011235 = new javax.swing.JLabel();
        jComboBoxRoleUser21552011235 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        sidoma1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelPetugas21552011235.setBackground(new java.awt.Color(17, 43, 60));
        jpanelPetugas21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBack21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-forward-32.png"))); // NOI18N
        BtnBack21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBack21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBack21552011235MouseEntered(evt);
            }
        });
        jpanelPetugas21552011235.add(BtnBack21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        txtusername21552011235.setFont(txtusername21552011235.getFont().deriveFont(txtusername21552011235.getFont().getSize()+2f));
        txtusername21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtusername21552011235.setBorder(null);
        txtusername21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusername21552011235ActionPerformed(evt);
            }
        });
        jpanelPetugas21552011235.add(txtusername21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 350, 40));

        txtpasswordPetugas21552011235.setFont(txtpasswordPetugas21552011235.getFont().deriveFont(txtpasswordPetugas21552011235.getFont().getSize()+2f));
        txtpasswordPetugas21552011235.setForeground(new java.awt.Color(255, 255, 255));
        txtpasswordPetugas21552011235.setBorder(null);
        txtpasswordPetugas21552011235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordPetugas21552011235ActionPerformed(evt);
            }
        });
        jpanelPetugas21552011235.add(txtpasswordPetugas21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 350, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jpanelPetugas21552011235.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("____________________________________________________________");
        jpanelPetugas21552011235.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 420, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        jpanelPetugas21552011235.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 360, 36));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-male-user-32.png"))); // NOI18N
        jpanelPetugas21552011235.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 40, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jpanelPetugas21552011235.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 360, 36));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");
        jpanelPetugas21552011235.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 420, 30));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clrredLOGIN.png"))); // NOI18N
        jpanelPetugas21552011235.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 300, 40));

        sidoma.setBackground(new java.awt.Color(0, 0, 0));
        sidoma.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma.setForeground(new java.awt.Color(255, 255, 255));
        sidoma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma.setText("MAJALAYA");
        jpanelPetugas21552011235.add(sidoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, 36));

        sidoma3.setBackground(new java.awt.Color(0, 0, 0));
        sidoma3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma3.setForeground(new java.awt.Color(255, 255, 255));
        sidoma3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma3.setText("PDDM");
        jpanelPetugas21552011235.add(sidoma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 120, 36));

        sidoma2.setBackground(new java.awt.Color(0, 0, 0));
        sidoma2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma2.setForeground(new java.awt.Color(255, 255, 255));
        sidoma2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pddm_100px-removebg-preview.png"))); // NOI18N
        jpanelPetugas21552011235.add(sidoma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, 100));

        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eyewhite20.png"))); // NOI18N
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jpanelPetugas21552011235.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, 28));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showEye.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jpanelPetugas21552011235.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, 28));

        langkop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        langkop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/map-majalaya-logo-FIKS.png"))); // NOI18N
        jpanelPetugas21552011235.add(langkop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 260));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-male-user-24.png"))); // NOI18N
        jpanelPetugas21552011235.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, 28));

        PanelLoginPetugas21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelLoginPetugas21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelLoginPetugas21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnLoginBarista21552011235.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        BtnLoginBarista21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnLoginBarista21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnLoginBarista21552011235.setText("Login");
        BtnLoginBarista21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLoginBarista21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLoginBarista21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnLoginBarista21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnLoginBarista21552011235MouseExited(evt);
            }
        });
        PanelLoginPetugas21552011235.add(BtnLoginBarista21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jpanelPetugas21552011235.add(PanelLoginPetugas21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 140, 40));

        jComboBoxRoleUser21552011235.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxRoleUser21552011235.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- pilih --", "Admin", "Sekretaris", "Bendahara", "Petugas" }));
        jpanelPetugas21552011235.add(jComboBoxRoleUser21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 130, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linePNG.png"))); // NOI18N
        jpanelPetugas21552011235.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 440));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/HEXABACKCONNECT.png"))); // NOI18N
        jpanelPetugas21552011235.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 510, 440));

        sidoma1.setBackground(new java.awt.Color(0, 0, 0));
        sidoma1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sidoma1.setForeground(new java.awt.Color(255, 255, 255));
        sidoma1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidoma1.setText("MAJALAYA");
        jpanelPetugas21552011235.add(sidoma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, 36));

        getContentPane().add(jpanelPetugas21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 813, -1));

        setSize(new java.awt.Dimension(813, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtpasswordPetugas21552011235.setEchoChar((char)8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    
    
    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtpasswordPetugas21552011235.setEchoChar((char)0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void BtnBack21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseClicked
      new login.selamatDatang().setVisible(true);
      dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void txtpasswordPetugas21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordPetugas21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordPetugas21552011235ActionPerformed

    private void txtusername21552011235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusername21552011235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusername21552011235ActionPerformed

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
       
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    private void BtnLoginBarista21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginBarista21552011235MouseClicked
        login();
    }//GEN-LAST:event_BtnLoginBarista21552011235MouseClicked

    private void BtnLoginBarista21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginBarista21552011235MouseEntered
        changecolor(PanelLoginPetugas21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnLoginBarista21552011235MouseEntered

    private void BtnLoginBarista21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLoginBarista21552011235MouseExited
        changecolor(PanelLoginPetugas21552011235, new Color (17,43,60));
    }//GEN-LAST:event_BtnLoginBarista21552011235MouseExited

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
            java.util.logging.Logger.getLogger(loginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new loginUser().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JLabel BtnLoginBarista21552011235;
    private javax.swing.JPanel PanelLoginPetugas21552011235;
    private javax.swing.JLabel disable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxRoleUser21552011235;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jpanelPetugas21552011235;
    private javax.swing.JLabel langkop;
    private javax.swing.JLabel show;
    private javax.swing.JLabel sidoma;
    private javax.swing.JLabel sidoma1;
    private javax.swing.JLabel sidoma2;
    private javax.swing.JLabel sidoma3;
    private javax.swing.JPasswordField txtpasswordPetugas21552011235;
    private javax.swing.JTextField txtusername21552011235;
    // End of variables declaration//GEN-END:variables

    private void changecolor(JLabel CloseBtn21552011235, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

   


    

    

    
