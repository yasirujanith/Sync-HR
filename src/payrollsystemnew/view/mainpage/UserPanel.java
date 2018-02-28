/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.view.mainpage;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import payrollsystemnew.controller.UserController;
import payrollsystemnew.view.user.AddNewUserForm;
import payrollsystemnew.view.user.ChangePasswordForm;
import payrollsystemnew.view.user.UserLoginForm;

/**
 *
 * @author User
 */
public class UserPanel extends javax.swing.JPanel {
    private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
    /**
     * Creates new form employeePanel
     */
    public UserPanel() {
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

        jPanel1 = new javax.swing.JPanel();
        addNewUserButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        userPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addNewUserButton.setBackground(new java.awt.Color(0, 0, 0));
        addNewUserButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        addNewUserButton.setForeground(new java.awt.Color(255, 255, 255));
        addNewUserButton.setText("Add New User");
        addNewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addNewUserButtonMouseEntered(evt);
            }
        });
        addNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addNewUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 60));

        logOutButton.setBackground(new java.awt.Color(0, 0, 0));
        logOutButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log Out");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
        });
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 60));

        changePasswordButton.setBackground(new java.awt.Color(0, 0, 0));
        changePasswordButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        changePasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordButton.setText("Change Password");
        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePasswordButtonMouseEntered(evt);
            }
        });
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        jPanel1.add(changePasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 250, 60));

        userPanel.setOpaque(false);

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jPanel1.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 650, 630));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystemnew/images/Background.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void addNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserButtonActionPerformed
        new AddNewUserForm().setVisible(true);
    }//GEN-LAST:event_addNewUserButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        try {
            UserController.userLogOut(UserController.getCurrentUser(),timeFormat.format(new Date()));
            new UserLoginForm().setVisible(true);
            MainFrameForm.form.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        new ChangePasswordForm().setVisible(true);
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void addNewUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewUserButtonMouseEntered
        userPanel.removeAll();
        BlankSubPanel p1=new BlankSubPanel();
        p1.setSize(userPanel.getSize());
        p1.repaint();
        p1.revalidate();
        userPanel.add(p1);
    }//GEN-LAST:event_addNewUserButtonMouseEntered

    private void changePasswordButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordButtonMouseEntered
        userPanel.removeAll();
        BlankSubPanel p1=new BlankSubPanel();
        p1.setSize(userPanel.getSize());
        p1.repaint();
        p1.revalidate();
        userPanel.add(p1);
    }//GEN-LAST:event_changePasswordButtonMouseEntered

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        userPanel.removeAll();
        BlankSubPanel p1=new BlankSubPanel();
        p1.setSize(userPanel.getSize());
        p1.repaint();
        p1.revalidate();
        userPanel.add(p1);
    }//GEN-LAST:event_logOutButtonMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewUserButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
