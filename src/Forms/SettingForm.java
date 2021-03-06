/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Database.Backupdbtosql;
import static Forms.MainWindow.Backupdbtosql;
import Handlers.PreferenceHandler;
import Handlers.MachineHandler;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eldridge
 */
public class SettingForm extends javax.swing.JFrame {

    PreferenceHandler newPreference = new PreferenceHandler();
    /**
     * Creates new form SettingForm
     */
    public SettingForm() {
        initComponents();
        SetToCenter();
        setItemFromPreference();
    }
    
    public void setItemFromPreference()
    {
        this.CompanyPreference.setSelectedItem(newPreference.getCompanyPreference().toString());
        
        //Selected 0 index is for Dryer and Stenter
        //int ResinInputType = 0;
        if(newPreference.getResinMachineInputPreference())
        {
            //Selected 1 index is for Manual Input
            //ResinInputType = 1;
            this.ResinMachineInputPreference.setSelectedIndex(1);
        }
        
        //int ReviewFormEditingType = 0;
        if(newPreference.getReviewFormEditing())
        {
            //ReviewFormEditingType = 1;
            this.ReviewFormDropDown.setSelectedIndex(1);
        }
        
    }
    
    public void SetToCenter()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
    }
    
    //Check if setting has already be set
    public SettingForm(boolean set)
    {
        this();
        newPreference.initialize();
        new MachineHandler().AddDryerAndStenterMachine();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CompanyPreference = new javax.swing.JComboBox();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ResinMachineInputPreference = new javax.swing.JComboBox();
        backupButton = new javax.swing.JButton();
        backupButton1 = new javax.swing.JButton();
        ReviewType = new javax.swing.JLabel();
        ReviewFormDropDown = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Company Name : ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Settings");

        CompanyPreference.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        CompanyPreference.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Evergrande Greenwood Int'l Corp.", "Mayer Knitting Corp.", "Relianz Int'l Corp", "Colortex Processing Inc." }));

        SaveButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Resin Machine Type :");

        ResinMachineInputPreference.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinMachineInputPreference.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dryer and Stenter", "Manual Input" }));

        backupButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        backupButton.setText("Backup");
        backupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupButtonActionPerformed(evt);
            }
        });

        backupButton1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        backupButton1.setText("Restore");
        backupButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupButton1ActionPerformed(evt);
            }
        });

        ReviewType.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ReviewType.setForeground(new java.awt.Color(255, 255, 255));
        ReviewType.setText("Review Form Editing :");

        ReviewFormDropDown.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ReviewFormDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Enabled" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backupButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ReviewType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReviewFormDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CompanyPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ResinMachineInputPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12))))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CompanyPreference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ResinMachineInputPreference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReviewType)
                    .addComponent(ReviewFormDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(backupButton)
                .addGap(38, 38, 38)
                .addComponent(backupButton1)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        //PreferenceHandler newPreference = new PreferenceHandler();
        boolean ResinType = newPreference.getResinMachineBooleanConversion(ResinMachineInputPreference.getSelectedItem().toString());
        newPreference.setCompanyPreference(CompanyPreference.getSelectedItem().toString());
        
        boolean ReivewFormType = newPreference.getReviewFormBooleanConversion(ReviewFormDropDown.getSelectedItem().toString());
        newPreference.setReviewFormEditing(newPreference.getReviewFormBooleanConversion(ReviewFormDropDown.getSelectedItem().toString()));
        if(ResinType != newPreference.getResinMachineInputPreference())
        {
            newPreference.setResinMachineInputPreference(ResinType);
            newPreference.fixResinMachineDatabase();
        }
        CloseThisWindowOpenMainWindow();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        CloseThisWindowOpenMainWindow();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void backupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupButtonActionPerformed
        // TODO add your handling code here:
        Backupdbtosql thisbackup = new Backupdbtosql();
        thisbackup.backup();
        
    }//GEN-LAST:event_backupButtonActionPerformed

    private void backupButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupButton1ActionPerformed
       
        try {
            // TODO add your handling code here:
            new Backupdbtosql().restore();
        } catch (InterruptedException ex) {
            Logger.getLogger(SettingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_backupButton1ActionPerformed
    
    private void CloseThisWindowOpenMainWindow()
    {
        this.dispose();
        MainWindow thisMain = new MainWindow();
        thisMain.setVisible(true);
    }
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
            java.util.logging.Logger.getLogger(SettingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox CompanyPreference;
    private javax.swing.JComboBox ResinMachineInputPreference;
    private javax.swing.JComboBox ReviewFormDropDown;
    private javax.swing.JLabel ReviewType;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton backupButton;
    private javax.swing.JButton backupButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
