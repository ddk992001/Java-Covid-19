/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javacovid19app.ManagedUser.ManagedUserHomePage;

import javax.swing.JOptionPane;
import javacovid19app.HomePage.*;
import javacovid19app.ManagedUser.ManagedUserHomePage.ChangePassword.ChangePassword;
import javacovid19app.ManagedUser.ManagedUserHomePage.Infomation.InformationMenu;
import javacovid19app.ManagedUser.ManagedUserSupplies.ManagedUserSupplies;
import javacovid19app.ManagedUser.ManagedUserTransaction.ManagedUserTransaction;

/**
 *
 * @author DELL
 */
public class ManagedUserHomePage extends javax.swing.JFrame {

    String userID="";
    public ManagedUserHomePage() {
        initComponents();
        this.setResizable(false); // can not fix size of a Frame;
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    public ManagedUserHomePage(String username) {
        this.userID=username;
        System.out.println(userID);
        initComponents();
        this.setResizable(false); // can not fix size of a Frame;
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnUserInfo = new javax.swing.JLabel();
        BtnUserSupplies = new javax.swing.JLabel();
        BtnUserTransaction = new javax.swing.JLabel();
        BtnBackSignIn = new javax.swing.JLabel();
        changePasswordLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUserInfoMouseClicked(evt);
            }
        });
        getContentPane().add(BtnUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 300, 370));

        BtnUserSupplies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUserSuppliesMouseClicked(evt);
            }
        });
        getContentPane().add(BtnUserSupplies, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 300, 370));

        BtnUserTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUserTransactionMouseClicked(evt);
            }
        });
        getContentPane().add(BtnUserTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, 300, 370));

        BtnBackSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackSignInMouseClicked(evt);
            }
        });
        getContentPane().add(BtnBackSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 70, 60));

        changePasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswordLabelMouseClicked(evt);
            }
        });
        getContentPane().add(changePasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 120, 160, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javacovid19app/ManagedUser/ManagedUserHomePage/UserHomePageBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUserInfoMouseClicked
        // TODO add your handling code here:
        InformationMenu infoMenu=new InformationMenu(userID);
        this.dispose();
        infoMenu.show();
    }//GEN-LAST:event_BtnUserInfoMouseClicked

    private void BtnUserSuppliesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUserSuppliesMouseClicked
        // TODO add your handling code here:
        ManagedUserSupplies sup = new ManagedUserSupplies(userID);
        sup.show();
        dispose();
    }//GEN-LAST:event_BtnUserSuppliesMouseClicked

    private void BtnBackSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackSignInMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Log out the system!");
        HomePage homepage = new HomePage();
        homepage.show();
        dispose();
    }//GEN-LAST:event_BtnBackSignInMouseClicked

    private void BtnUserTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUserTransactionMouseClicked
        // TODO add your handling code here:
         ManagedUserTransaction trans = new ManagedUserTransaction(userID);
        trans.show();
        dispose();
    }//GEN-LAST:event_BtnUserTransactionMouseClicked

    private void changePasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordLabelMouseClicked
        ChangePassword changePassMenu=new ChangePassword(userID);
        changePassMenu.show();
        dispose();
    }//GEN-LAST:event_changePasswordLabelMouseClicked

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
            java.util.logging.Logger.getLogger(ManagedUserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagedUserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagedUserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagedUserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagedUserHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBackSignIn;
    private javax.swing.JLabel BtnUserInfo;
    private javax.swing.JLabel BtnUserSupplies;
    private javax.swing.JLabel BtnUserTransaction;
    private javax.swing.JLabel changePasswordLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
