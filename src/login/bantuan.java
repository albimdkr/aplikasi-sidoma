/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

//import static petugas.dashboardPetugas.UserNamePetugas21552011235;
import com.mysql.jdbc.Connection;
import koneksi.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author albi mudakar
 */
public class bantuan extends javax.swing.JFrame {

    /**
     * Creates new form loginUser
     */
    public bantuan() {
        initComponents();
//        txtusernamePetugas21552011235.setBackground(new java.awt.Color(0,0,0,1));
//        txtpasswordPetugas21552011235.setBackground(new java.awt.Color(0,0,0,1));
          //koneksi.getKoneksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
//    private void loginUser(){
//       
//        try{
//            Connection connect = (Connection) koneksi.getKoneksi();
//            Statement sttmnt = connect.createStatement();
//            String query = "SELECT * FROM `petugas` WHERE `username` = '"+txtusernamePetugas21552011235.getText()+"' && `password`= '"+txtpasswordPetugas21552011235.getText()+"' ";
//            
//           
//            
////            int row = 0;
////            while(rs.next()){
////                row = rs.getRow();
////            }
//            ResultSet rs = sttmnt.executeQuery(query);
//            if(rs.next()){
//                JOptionPane.showMessageDialog(null, "Login Success");
//                //UserNamePetugas21552011235.setText(rs.getString(2));
//                new petugas.dashboardPetugas().setVisible(true);
//                dispose();
//            }else{
//                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
//                txtusernamePetugas21552011235.setText(null);
//                txtpasswordPetugas21552011235.setText(null);
//            }
//            
//        }catch(SQLException | HeadlessException e ){
//            System.out.println(e);
//        }
//    }
    
    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jpanelPetugas21552011235 = new javax.swing.JPanel();
        BtnBack21552011235 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        txt8 = new javax.swing.JLabel();
        txt6 = new javax.swing.JLabel();
        txt5 = new javax.swing.JLabel();

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

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/HEXABACKCONNECT.png"))); // NOI18N
        jpanelPetugas21552011235.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 510, 440));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Bantuan");
        jpanelPetugas21552011235.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 180, -1));

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        line.setForeground(new java.awt.Color(255, 255, 255));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("____________");
        jpanelPetugas21552011235.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 140, 20));

        txt2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt2.setText("Jika belum terdaftar");
        jpanelPetugas21552011235.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 420, 36));

        txt3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt3.setText("Jika anda belum terdaftar di sistem, maka hubungi admin");
        jpanelPetugas21552011235.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 420, 36));

        txt1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("admin mempunyai hak untuk menambahkan user.");
        jpanelPetugas21552011235.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 420, 36));

        txt7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txt7.setForeground(new java.awt.Color(255, 255, 255));
        txt7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt7.setText("Jika sudah terdaftar");
        jpanelPetugas21552011235.add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 420, 36));

        txt4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt4.setForeground(new java.awt.Color(255, 255, 255));
        txt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt4.setText("Jika anda sudah terdaftar dalam sistem, silahkan login");
        jpanelPetugas21552011235.add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 420, 36));

        txt8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt8.setForeground(new java.awt.Color(255, 255, 255));
        txt8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt8.setText("sesuai role yang telah di tentukan oleh admin.");
        jpanelPetugas21552011235.add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 420, 36));

        txt6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt6.setForeground(new java.awt.Color(255, 255, 255));
        txt6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt6.setText("Terima Kasih.");
        jpanelPetugas21552011235.add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 100, 36));

        txt5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txt5.setForeground(new java.awt.Color(255, 255, 255));
        txt5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt5.setText("SIDOMA v1.0");
        jpanelPetugas21552011235.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 110, 36));

        getContentPane().add(jpanelPetugas21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 813, -1));

        setSize(new java.awt.Dimension(813, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void BtnBack21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseClicked
      new login.selamatDatang().setVisible(true);
      dispose();
    }//GEN-LAST:event_BtnBack21552011235MouseClicked

    private void BtnBack21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBack21552011235MouseEntered
       
    }//GEN-LAST:event_BtnBack21552011235MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new bantuan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel BtnBack21552011235;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jpanelPetugas21552011235;
    private javax.swing.JLabel line;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    // End of variables declaration//GEN-END:variables

    private void changecolor(JLabel CloseBtn21552011235, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
