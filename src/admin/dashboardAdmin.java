/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import admin.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author albi mudakar
 */
public class dashboardAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    boolean a= true;
    public dashboardAdmin() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //usernameAdmin21552011235.setText();
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        header21552011235 = new javax.swing.JPanel();
        iconMenu = new javax.swing.JPanel();
        PanelLogout21552011235 = new javax.swing.JPanel();
        BtnLogout21552011235 = new javax.swing.JLabel();
        BtnMax21552011235 = new javax.swing.JPanel();
        BtnMin21552011235 = new javax.swing.JPanel();
        menu21552011235 = new javax.swing.JPanel();
        sidebar21552011235 = new javax.swing.JPanel();
        homePanel21552011235 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnHome21552011235 = new javax.swing.JLabel();
        FormPanel21552011235 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        BtnForm21552011235 = new javax.swing.JLabel();
        tentangPanel21552011235 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        BtnTentang21552011235 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Dashboardview21552011235 = new javax.swing.JPanel();
        jTabbedPanel21552011235 = new javax.swing.JTabbedPane();
        HomeTabbed21552011235 = new javax.swing.JPanel();
        IconUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        DaftarMenuTabbed21552011235 = new javax.swing.JPanel();
        PanelDaftarmenu21552011235 = new javax.swing.JPanel();
        TabHomePanelDataPendonor = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        TabFormAddUser21552011235 = new javax.swing.JLabel();
        TabFormPanelLaporanKegiatan21552011235 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        TabFormLaporanKegiatan21552011235 = new javax.swing.JLabel();
        TentangTabbed21552011235 = new javax.swing.JPanel();
        PanelTentang21552011235 = new javax.swing.JPanel();
        TabTentangBtn21552011235 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);

        header21552011235.setBackground(new java.awt.Color(32, 83, 117));
        header21552011235.setPreferredSize(new java.awt.Dimension(800, 50));
        header21552011235.setLayout(new java.awt.BorderLayout());

        iconMenu.setBackground(new java.awt.Color(0, 0, 0));
        iconMenu.setPreferredSize(new java.awt.Dimension(150, 50));
        iconMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogout21552011235.setBackground(new java.awt.Color(32, 83, 117));
        PanelLogout21552011235.setPreferredSize(new java.awt.Dimension(50, 50));
        PanelLogout21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnLogout21552011235.setBackground(new java.awt.Color(30, 23, 15));
        BtnLogout21552011235.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLogout21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogout21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnLogout21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-sign-out-20.png"))); // NOI18N
        BtnLogout21552011235.setText("Logout");
        BtnLogout21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogout21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLogout21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnLogout21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnLogout21552011235MouseExited(evt);
            }
        });
        PanelLogout21552011235.add(BtnLogout21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        iconMenu.add(PanelLogout21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, -1));

        BtnMax21552011235.setBackground(new java.awt.Color(32, 83, 117));
        BtnMax21552011235.setPreferredSize(new java.awt.Dimension(50, 50));
        BtnMax21552011235.setLayout(new java.awt.BorderLayout());
        iconMenu.add(BtnMax21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        BtnMin21552011235.setBackground(new java.awt.Color(32, 83, 117));
        BtnMin21552011235.setPreferredSize(new java.awt.Dimension(50, 50));
        BtnMin21552011235.setLayout(new java.awt.BorderLayout());
        iconMenu.add(BtnMin21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        header21552011235.add(iconMenu, java.awt.BorderLayout.LINE_END);

        getContentPane().add(header21552011235, java.awt.BorderLayout.PAGE_START);

        menu21552011235.setBackground(new java.awt.Color(32, 83, 117));
        menu21552011235.setPreferredSize(new java.awt.Dimension(270, 450));
        menu21552011235.setLayout(new java.awt.BorderLayout());

        sidebar21552011235.setBackground(new java.awt.Color(32, 83, 117));
        sidebar21552011235.setMinimumSize(new java.awt.Dimension(200, 210));
        sidebar21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePanel21552011235.setBackground(new java.awt.Color(32, 83, 117));
        homePanel21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePanel21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homePanel21552011235MouseEntered(evt);
            }
        });
        homePanel21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-home-24.png"))); // NOI18N
        homePanel21552011235.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 43, 50));

        BtnHome21552011235.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHome21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnHome21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnHome21552011235.setText("Home");
        BtnHome21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnHome21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnHome21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnHome21552011235MouseExited(evt);
            }
        });
        homePanel21552011235.add(BtnHome21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        sidebar21552011235.add(homePanel21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 50));

        FormPanel21552011235.setBackground(new java.awt.Color(32, 83, 117));
        FormPanel21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-health-book-20.png"))); // NOI18N
        FormPanel21552011235.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 43, 50));

        BtnForm21552011235.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnForm21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnForm21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnForm21552011235.setText("Form");
        BtnForm21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnForm21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnForm21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnForm21552011235MouseExited(evt);
            }
        });
        FormPanel21552011235.add(BtnForm21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        sidebar21552011235.add(FormPanel21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 270, -1));

        tentangPanel21552011235.setBackground(new java.awt.Color(32, 83, 117));
        tentangPanel21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-info-24.png"))); // NOI18N
        tentangPanel21552011235.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 43, 50));

        BtnTentang21552011235.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTentang21552011235.setForeground(new java.awt.Color(255, 255, 255));
        BtnTentang21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnTentang21552011235.setText("Tentang");
        BtnTentang21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTentang21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnTentang21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnTentang21552011235MouseExited(evt);
            }
        });
        tentangPanel21552011235.add(BtnTentang21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        sidebar21552011235.add(tentangPanel21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 270, 50));

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pddm_100px-removebg-preview.png"))); // NOI18N
        sidebar21552011235.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 190, 130));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackLOGO.png"))); // NOI18N
        sidebar21552011235.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 230, 110));

        menu21552011235.add(sidebar21552011235, java.awt.BorderLayout.CENTER);

        getContentPane().add(menu21552011235, java.awt.BorderLayout.LINE_START);

        Dashboardview21552011235.setBackground(new java.awt.Color(17, 43, 60));
        Dashboardview21552011235.setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPanel21552011235.setBackground(new java.awt.Color(17, 43, 60));
        jTabbedPanel21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(64, 49, 33), new java.awt.Color(64, 49, 33), new java.awt.Color(64, 49, 33), new java.awt.Color(64, 49, 33)));
        jTabbedPanel21552011235.setForeground(new java.awt.Color(17, 43, 60));

        HomeTabbed21552011235.setBackground(new java.awt.Color(17, 43, 60));
        HomeTabbed21552011235.setLayout(new java.awt.GridBagLayout());

        IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-male-user-96.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 270, 0, 0);
        HomeTabbed21552011235.add(IconUser, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("dan data transfusi.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 217;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 196, 133, 121);
        HomeTabbed21552011235.add(jLabel4, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Anda bisa menambah data pendonor, pasien ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 196, 0, 121);
        HomeTabbed21552011235.add(jLabel7, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("___________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 312, 0, 0);
        HomeTabbed21552011235.add(jLabel3, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Dashboard Admin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 270, 0, 0);
        HomeTabbed21552011235.add(jLabel6, gridBagConstraints);

        usernameAdmin21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameAdmin21552011235.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 6, 0, 0);
        HomeTabbed21552011235.add(usernameAdmin21552011235, gridBagConstraints);

        UserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setText("Admin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 62;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 6, 0, 0);
        HomeTabbed21552011235.add(UserName, gridBagConstraints);

        jTabbedPanel21552011235.addTab("", HomeTabbed21552011235);

        DaftarMenuTabbed21552011235.setBackground(new java.awt.Color(17, 43, 60));
        DaftarMenuTabbed21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDaftarmenu21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelDaftarmenu21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelDaftarmenu21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DaftarMenuTabbed21552011235.add(PanelDaftarmenu21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TabHomePanelDataPendonor.setBackground(new java.awt.Color(17, 43, 60));
        TabHomePanelDataPendonor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        TabHomePanelDataPendonor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-male-user-96.png"))); // NOI18N
        TabHomePanelDataPendonor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 90, 90));

        TabFormAddUser21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TabFormAddUser21552011235.setForeground(new java.awt.Color(255, 255, 255));
        TabFormAddUser21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TabFormAddUser21552011235.setText("Form Add User");
        TabFormAddUser21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabFormAddUser21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabFormAddUser21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabFormAddUser21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabFormAddUser21552011235MouseExited(evt);
            }
        });
        TabHomePanelDataPendonor.add(TabFormAddUser21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 230));

        DaftarMenuTabbed21552011235.add(TabHomePanelDataPendonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 132, 210, 230));

        TabFormPanelLaporanKegiatan21552011235.setBackground(new java.awt.Color(17, 43, 60));
        TabFormPanelLaporanKegiatan21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        TabFormPanelLaporanKegiatan21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-activity-history-96.png"))); // NOI18N
        TabFormPanelLaporanKegiatan21552011235.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 100, 100));

        TabFormLaporanKegiatan21552011235.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TabFormLaporanKegiatan21552011235.setForeground(new java.awt.Color(255, 255, 255));
        TabFormLaporanKegiatan21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TabFormLaporanKegiatan21552011235.setText("Laporan Kegiatan");
        TabFormLaporanKegiatan21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabFormLaporanKegiatan21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabFormLaporanKegiatan21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabFormLaporanKegiatan21552011235MouseExited(evt);
            }
        });
        TabFormPanelLaporanKegiatan21552011235.add(TabFormLaporanKegiatan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 230));

        DaftarMenuTabbed21552011235.add(TabFormPanelLaporanKegiatan21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 130, 210, 230));

        jTabbedPanel21552011235.addTab("", DaftarMenuTabbed21552011235);

        TentangTabbed21552011235.setBackground(new java.awt.Color(17, 43, 60));
        TentangTabbed21552011235.setLayout(new java.awt.GridBagLayout());

        PanelTentang21552011235.setBackground(new java.awt.Color(17, 43, 60));
        PanelTentang21552011235.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PanelTentang21552011235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabTentangBtn21552011235.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        TabTentangBtn21552011235.setForeground(new java.awt.Color(255, 255, 255));
        TabTentangBtn21552011235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TabTentangBtn21552011235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconOutline/icons8-info-96.png"))); // NOI18N
        TabTentangBtn21552011235.setText("Tentang");
        TabTentangBtn21552011235.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabTentangBtn21552011235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabTentangBtn21552011235MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabTentangBtn21552011235MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabTentangBtn21552011235MouseExited(evt);
            }
        });
        PanelTentang21552011235.add(TabTentangBtn21552011235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 200));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(120, 130, 152, 74);
        TentangTabbed21552011235.add(PanelTentang21552011235, gridBagConstraints);

        jTabbedPanel21552011235.addTab("", TentangTabbed21552011235);

        Dashboardview21552011235.add(jTabbedPanel21552011235);

        getContentPane().add(Dashboardview21552011235, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(975, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    public void clickmenu (JPanel h1, JPanel h2, int numberbool){
//        if(numberbool == 1){
//            h1.setBackground(new Color(45,35,23));
//            h2.setBackground(new Color(20,15,10));
//        }else{
//            h1.setBackground(new Color(45,35,23));
//            h2.setBackground(new Color(20,15,10));
//        }
    }
    
    
     public void changeimage(JLabel button, String resourcheimg){
//        ImageIcon aimg = new ImageIcon(getClass().getResource(resourcheimg));
//        button.setIcon(aimg);
    }
    
    
//    
//    public void hideshow (JPanel menushowhide, boolean dashboard, JLabel button){
//        if (dashboard == true){
//            menushowhide.setPreferredSize(new Dimension(50, menushowhide.getHeight()));
//            changeimage(button, "/iconOutline/icons8-menu-32.png");
//        }else{
//            menushowhide.setPreferredSize(new Dimension(200, menushowhide.getHeight()));
//            changeimage(button, "/iconOutline/icons8-back-32.png");
//        }
//    }
//    
   
    
    
    
    private void homePanel21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanel21552011235MouseEntered
        
    }//GEN-LAST:event_homePanel21552011235MouseEntered

    private void homePanel21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanel21552011235MouseClicked

    }//GEN-LAST:event_homePanel21552011235MouseClicked

    private void BtnHome21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHome21552011235MouseEntered
        changecolor(homePanel21552011235, new Color (32,108,151));
    }//GEN-LAST:event_BtnHome21552011235MouseEntered

    private void BtnHome21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHome21552011235MouseExited
        changecolor(homePanel21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnHome21552011235MouseExited

    private void BtnForm21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnForm21552011235MouseEntered
       changecolor(FormPanel21552011235, new Color (32,108,151));
    }//GEN-LAST:event_BtnForm21552011235MouseEntered

    private void BtnForm21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnForm21552011235MouseExited
        changecolor(FormPanel21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnForm21552011235MouseExited

    private void BtnTentang21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTentang21552011235MouseEntered
        changecolor(tentangPanel21552011235, new Color (32,108,151));
    }//GEN-LAST:event_BtnTentang21552011235MouseEntered

    private void BtnTentang21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTentang21552011235MouseExited
        changecolor(tentangPanel21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnTentang21552011235MouseExited

    private void BtnLogout21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogout21552011235MouseExited
        changecolor(PanelLogout21552011235, new Color (32,83,117));
    }//GEN-LAST:event_BtnLogout21552011235MouseExited

    private void BtnLogout21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogout21552011235MouseEntered
        changecolor(PanelLogout21552011235, new Color (255,24,24));
    }//GEN-LAST:event_BtnLogout21552011235MouseEntered

    private void BtnLogout21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLogout21552011235MouseClicked
        new login.loginUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnLogout21552011235MouseClicked

    private void BtnHome21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHome21552011235MouseClicked
       jTabbedPanel21552011235.setSelectedIndex(0);
    }//GEN-LAST:event_BtnHome21552011235MouseClicked

    private void BtnForm21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnForm21552011235MouseClicked
        jTabbedPanel21552011235.setSelectedIndex(1);
    }//GEN-LAST:event_BtnForm21552011235MouseClicked

    private void BtnTentang21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTentang21552011235MouseClicked
        jTabbedPanel21552011235.setSelectedIndex(2);
    }//GEN-LAST:event_BtnTentang21552011235MouseClicked

    private void TabTentangBtn21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTentangBtn21552011235MouseExited
        changecolor(PanelTentang21552011235, new Color (17,43,60));
    }//GEN-LAST:event_TabTentangBtn21552011235MouseExited

    private void TabTentangBtn21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTentangBtn21552011235MouseEntered
        changecolor(PanelTentang21552011235, new Color (32,108,151));
    }//GEN-LAST:event_TabTentangBtn21552011235MouseEntered

    private void TabTentangBtn21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTentangBtn21552011235MouseClicked
        new petugas.TentangPetugas().setVisible(true);
        dispose();
    }//GEN-LAST:event_TabTentangBtn21552011235MouseClicked

    private void TabFormLaporanKegiatan21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormLaporanKegiatan21552011235MouseExited
        changecolor(TabFormPanelLaporanKegiatan21552011235, new Color (17,43,60));
    }//GEN-LAST:event_TabFormLaporanKegiatan21552011235MouseExited

    private void TabFormLaporanKegiatan21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormLaporanKegiatan21552011235MouseEntered
        changecolor(TabFormPanelLaporanKegiatan21552011235, new Color (32,108,151));
    }//GEN-LAST:event_TabFormLaporanKegiatan21552011235MouseEntered

    private void TabFormLaporanKegiatan21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormLaporanKegiatan21552011235MouseClicked
        new transfusi.FormPasien().setVisible(true);
        dispose();
    }//GEN-LAST:event_TabFormLaporanKegiatan21552011235MouseClicked

    private void TabFormAddUser21552011235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormAddUser21552011235MouseExited
        changecolor(TabHomePanelDataPendonor, new Color (17,43,60));
    }//GEN-LAST:event_TabFormAddUser21552011235MouseExited

    private void TabFormAddUser21552011235MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormAddUser21552011235MouseEntered
        changecolor(TabHomePanelDataPendonor, new Color (32,108,151));
    }//GEN-LAST:event_TabFormAddUser21552011235MouseEntered

    private void TabFormAddUser21552011235MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabFormAddUser21552011235MouseClicked
        new admin.FormAddUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_TabFormAddUser21552011235MouseClicked

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
            java.util.logging.Logger.getLogger(dashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new dashboardAdmin().setVisible(true);
////            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnForm21552011235;
    private javax.swing.JLabel BtnHome21552011235;
    private javax.swing.JLabel BtnLogout21552011235;
    private javax.swing.JPanel BtnMax21552011235;
    private javax.swing.JPanel BtnMin21552011235;
    private javax.swing.JLabel BtnTentang21552011235;
    private javax.swing.JPanel DaftarMenuTabbed21552011235;
    private javax.swing.JPanel Dashboardview21552011235;
    private javax.swing.JPanel FormPanel21552011235;
    private javax.swing.JPanel HomeTabbed21552011235;
    private javax.swing.JLabel IconUser;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel PanelDaftarmenu21552011235;
    private javax.swing.JPanel PanelLogout21552011235;
    private javax.swing.JPanel PanelTentang21552011235;
    private javax.swing.JLabel TabFormAddUser21552011235;
    private javax.swing.JLabel TabFormLaporanKegiatan21552011235;
    private javax.swing.JPanel TabFormPanelLaporanKegiatan21552011235;
    private javax.swing.JPanel TabHomePanelDataPendonor;
    private javax.swing.JLabel TabTentangBtn21552011235;
    private javax.swing.JPanel TentangTabbed21552011235;
    private javax.swing.JLabel UserName;
    private javax.swing.JPanel header21552011235;
    private javax.swing.JPanel homePanel21552011235;
    private javax.swing.JPanel iconMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPanel21552011235;
    private javax.swing.JPanel menu21552011235;
    private javax.swing.JPanel sidebar21552011235;
    private javax.swing.JPanel tentangPanel21552011235;
    public static final javax.swing.JLabel usernameAdmin21552011235 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables

    private static class color {

        public color() {
        }
    }

}
