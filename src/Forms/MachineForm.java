/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DataEntities.Machine;
import Handlers.MachineHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Eldridge
 */
public class MachineForm extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    Machine thisMachine = new Machine();
    /**
     * Creates new form AddMachine
     */
    public MachineForm() {
        initComponents();
        this.get_updated_table();
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
        AddMachineButton = new javax.swing.JButton();
        EditMachineButton = new javax.swing.JButton();
        DeleteMachineButton = new javax.swing.JButton();
        MachineName = new javax.swing.JTextField();
        MachineMinimumVolume = new javax.swing.JTextField();
        MachineMaximumVolume = new javax.swing.JTextField();
        MachineMaximumCapacity = new javax.swing.JTextField();
        MachineMinimumCapacity = new javax.swing.JTextField();
        MachineTable = new javax.swing.JScrollPane();
        MachineListTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DeleteMachineButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddMachineButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        AddMachineButton.setText("Add Machine");
        AddMachineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMachineButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddMachineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 185, 46));

        EditMachineButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        EditMachineButton.setText("Edit Machine");
        EditMachineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMachineButtonActionPerformed(evt);
            }
        });
        jPanel1.add(EditMachineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 185, 46));

        DeleteMachineButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        DeleteMachineButton.setText("Delete Machine");
        DeleteMachineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMachineButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteMachineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 185, 46));

        MachineName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineName.setText("Name");
        MachineName.setToolTipText("");
        MachineName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MachineNameFocusGained(evt);
            }
        });
        MachineName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineNameActionPerformed(evt);
            }
        });
        MachineName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MachineNameKeyReleased(evt);
            }
        });
        jPanel1.add(MachineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 730, -1));

        MachineMinimumVolume.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineMinimumVolume.setText("Min Volume");
        MachineMinimumVolume.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MachineMinimumVolumeFocusGained(evt);
            }
        });
        MachineMinimumVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineMinimumVolumeActionPerformed(evt);
            }
        });
        jPanel1.add(MachineMinimumVolume, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 260, 40));

        MachineMaximumVolume.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineMaximumVolume.setText("Max Volume");
        MachineMaximumVolume.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MachineMaximumVolumeFocusGained(evt);
            }
        });
        jPanel1.add(MachineMaximumVolume, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 260, 40));

        MachineMaximumCapacity.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineMaximumCapacity.setText("Max Capacity");
        MachineMaximumCapacity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MachineMaximumCapacityFocusGained(evt);
            }
        });
        jPanel1.add(MachineMaximumCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 260, 40));

        MachineMinimumCapacity.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineMinimumCapacity.setText("Min Capacity");
        MachineMinimumCapacity.setToolTipText("");
        MachineMinimumCapacity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MachineMinimumCapacityFocusGained(evt);
            }
        });
        MachineMinimumCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineMinimumCapacityActionPerformed(evt);
            }
        });
        jPanel1.add(MachineMinimumCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 260, 40));

        MachineListTable.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        MachineListTable.setModel(new javax.swing.table.DefaultTableModel(
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
        MachineTable.setViewportView(MachineListTable);

        jPanel1.add(MachineTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 73, 760, 212));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Machine");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 18, 228, 44));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Volume");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 730, -1));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Capacity");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 730, -1));

        DeleteMachineButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        DeleteMachineButton1.setText("Delete Machine");
        DeleteMachineButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMachineButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteMachineButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 185, 46));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MachineMinimumCapacityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MachineMinimumCapacityFocusGained
        // TODO add your handling code here:
        if(MachineMinimumCapacity.getText().equals("Min Capacity"))
        {
            MachineMinimumCapacity.setText("");
            MachineMinimumCapacity.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_MachineMinimumCapacityFocusGained

    private void MachineMinimumCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineMinimumCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MachineMinimumCapacityActionPerformed

    private void MachineMaximumCapacityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MachineMaximumCapacityFocusGained
        // TODO add your handling code here:MachineMaximumCapacity
        if(MachineMaximumCapacity.getText().equals("Max Capacity"))
        {
            MachineMaximumCapacity.setText("");
            MachineMaximumCapacity.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_MachineMaximumCapacityFocusGained

    private void MachineNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MachineNameFocusGained
        // TODO add your handling code here:
        if(MachineName.getText().equals("Name"))
        {
            MachineName.setText("");
            MachineName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_MachineNameFocusGained

    private void MachineNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MachineNameActionPerformed

    private void DeleteMachineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMachineButtonActionPerformed
        // TODO add your handling code here:

        if(MachineListTable.getSelectedRowCount() > 0 )
        {
            MachineHandler handler = new MachineHandler();
            int CloseorNoreply = JOptionPane.showConfirmDialog(null,"Delete this machine? "
                ,"Delete Machine?", JOptionPane.YES_NO_OPTION);
            if(CloseorNoreply == JOptionPane.YES_OPTION)
            {
                String machineName = MachineListTable.getModel().getValueAt(MachineListTable.getSelectedRow(),0).toString();
                thisMachine.setMachineName(machineName);
                int machineId = handler.GetMachineIdByName(thisMachine.getMachineName());
                thisMachine.setMachineId(machineId);
                handler.DeleteMachineById(thisMachine.getMachineId());
                this.get_updated_table();
                this.UpdateRowFilter("");
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Please select an Item in the table to be deleted");
        }
    }//GEN-LAST:event_DeleteMachineButtonActionPerformed

    private void EditMachineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMachineButtonActionPerformed
        
            if(EditMachineButton.getText().equals("Edit Machine"))
            {
                if(MachineListTable.getSelectedRowCount() > 0 )
                {
                    MachineName.setForeground(Color.BLACK);
                    MachineMinimumCapacity.setForeground(Color.BLACK);
                    MachineMaximumCapacity.setForeground(Color.BLACK);
                    MachineMinimumVolume.setForeground(Color.BLACK);
                    MachineMaximumVolume.setForeground(Color.BLACK);

                    thisMachine.setMachineName(this.MachineListTable.getModel().getValueAt(this.MachineListTable.getSelectedRow(), 0).toString());
                    MachineName.setText(thisMachine.getMachineName());

                    thisMachine.setMinCapacity(Integer.parseInt(this.MachineListTable.getModel().getValueAt(this.MachineListTable.getSelectedRow(), 1).toString()));
                    MachineMinimumCapacity.setText(Integer.toString(thisMachine.getMinCapacity()));

                    thisMachine.setMaxCapacity(Integer.parseInt(this.MachineListTable.getModel().getValueAt(this.MachineListTable.getSelectedRow(), 2).toString()));
                    MachineMaximumCapacity.setText(Integer.toString(thisMachine.getMaxCapacity()));

                    thisMachine.setMinVolume(Integer.parseInt(this.MachineListTable.getModel().getValueAt(this.MachineListTable.getSelectedRow(), 3).toString()));
                    MachineMinimumVolume.setText(Integer.toString(thisMachine.getMinVolume()));

                    thisMachine.setMaxVolume(Integer.parseInt(this.MachineListTable.getModel().getValueAt(this.MachineListTable.getSelectedRow(), 4).toString()));
                    MachineMaximumVolume.setText(Integer.toString(thisMachine.getMaxVolume()));

                    thisMachine.setMachineId(new MachineHandler().GetMachineIdByName(thisMachine.getMachineName()));
                    model.removeRow(this.MachineListTable.getSelectedRow());

                    this.EditMachineButton.setText("Cancel");
                    this.AddMachineButton.setText("Save");
                    this.DeleteMachineButton.setEnabled(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an Item in the table to be edited");     
            }
        }
        else
        {
            model.addRow((new Object[]{
                thisMachine.getMachineName(), 
                thisMachine.getMinCapacity(), 
                thisMachine.getMaxCapacity(), 
                thisMachine.getMinVolume(), 
                thisMachine.getMaxVolume()}));
                
                thisMachine.setMachineId(-1);
                thisMachine.setMachineName("");
                thisMachine.setMinCapacity(-1);
                thisMachine.setMaxCapacity(-1);
                thisMachine.setMinVolume(-1);
                thisMachine.setMaxVolume(-1);
                
                this.UpdateRowFilter("");
                
                this.ResetColorText();
        }
    }//GEN-LAST:event_EditMachineButtonActionPerformed
    
    private void ResetColorText()
    {
        EditMachineButton.setText("Edit Machine");
        this.AddMachineButton.setText("Add Machine");
        this.DeleteMachineButton.setEnabled(true);
        
        this.MachineName.setText("Name");
        MachineName.setForeground(new Color(204,204,204));
        
        this.MachineMinimumCapacity.setText("Min Capacity");
        MachineMinimumCapacity.setForeground(new Color(204,204,204));
        
        this.MachineMaximumCapacity.setText("Max Capacity");
        MachineMaximumCapacity.setForeground(new Color(204,204,204));
        
        this.MachineMinimumVolume.setText("Min Volume");
        MachineMinimumVolume.setForeground(new Color(204,204,204));
        
        this.MachineMaximumVolume.setText("Max Volume");
        MachineMaximumVolume.setForeground(new Color(204,204,204));
    }
    
    private void UpdateRowFilter(String row_filter_text)
    {
        TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(this.MachineListTable.getModel());
        
        this.MachineListTable.setRowSorter(rowSorter);
        
        if (row_filter_text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + row_filter_text));        
        }
    }

    private void AddMachineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMachineButtonActionPerformed
        // TODO add your handling code here:

        Machine newMachineDetails = new Machine();
        MachineHandler handler = new MachineHandler();
        if(MachineName.getText().length() > 0 && MachineName.getText() != "Name")
        {
            newMachineDetails.setMachineName(MachineName.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please input the machine's name");
        }

        if(MachineMaximumCapacity.getText().matches("/^[a-zA-Z]+$/") == true)
        {
            //TODO numeric characters only validation message
        }
        else if(MachineMaximumCapacity.getText().length() <= 0)
        {
            //TODO please input machine name
        }
        else
        {
            newMachineDetails.setMaxCapacity(Integer.parseInt(MachineMaximumCapacity.getText()));
        }

        if(MachineMinimumCapacity.getText().matches("/^[a-zA-Z]+$/") == true)
        {
            //TODO numeric characters only validation message
        }
        else if(MachineMinimumCapacity.getText().length() <= 0)
        {
            //TODO please input machine name
        }
        else
        {
            newMachineDetails.setMinCapacity(Integer.parseInt(MachineMinimumCapacity.getText()));
        }

        if(MachineMaximumVolume.getText().matches("/^[a-zA-Z]+$/") == true)
        {
            //TODO numeric characters only validation message
        }
        else if(MachineMaximumVolume.getText().length() <= 0)
        {
            //TODO please input machine name
        }
        else
        {
            newMachineDetails.setMaxVolume(Integer.parseInt(MachineMaximumVolume.getText()));
        }

        if(MachineMinimumVolume.getText().matches("/^[a-zA-Z]+$/") == true)
        {
            //TODO numeric characters only validation message
        }
        else if(MachineMinimumVolume.getText().length() <= 0)
        {
            //TODO please input machine name
        }
        else
        {
            newMachineDetails.setMinVolume(Integer.parseInt(MachineMinimumVolume.getText()));
        }

        if(AddMachineButton.getText() == "Add Machine")
        {
            handler.AddNewMachine(newMachineDetails);
            
        }
        else
        {
            newMachineDetails.setMachineId(thisMachine.getMachineId());
            handler.UpdateMachine(newMachineDetails);
        }
        get_updated_table();
        this.UpdateRowFilter("");
    }//GEN-LAST:event_AddMachineButtonActionPerformed

    private void MachineMinimumVolumeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MachineMinimumVolumeFocusGained
        // TODO add your handling code here:
        if(MachineMinimumVolume.getText().equals("Min Volume"))
        {
            MachineMinimumVolume.setText("");
            MachineMinimumVolume.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_MachineMinimumVolumeFocusGained

    private void MachineMinimumVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineMinimumVolumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MachineMinimumVolumeActionPerformed

    private void MachineMaximumVolumeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MachineMaximumVolumeFocusGained
        // TODO add your handling code here:
        if(MachineMaximumVolume.getText().equals("Max Volume"))
        {
            MachineMaximumVolume.setText("");
            MachineMaximumVolume.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_MachineMaximumVolumeFocusGained

    private void MachineNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MachineNameKeyReleased
        // TODO add your handling code here:
        UpdateRowFilter(this.MachineName.getText());
    }//GEN-LAST:event_MachineNameKeyReleased

    private void DeleteMachineButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMachineButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_DeleteMachineButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MachineForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachineForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachineForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachineForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachineForm().setVisible(true);
            }
        });
    }
    
    public DefaultTableModel GetAllMachines() {      
        
        DefaultTableModel model_original = new DefaultTableModel();
        model_original.addColumn("Name");
        model_original.addColumn("Minimum Capacity");
        model_original.addColumn("Maximum Capacity");
        model_original.addColumn("Minimum Volume");
        model_original.addColumn("Maximum Volume");
        
       
        ArrayList<Machine> MachineList = new MachineHandler().GetAllMachines();
        for(int x=0; x<MachineList.size(); x++)
        {
            model_original.addRow(new Object[]{
                MachineList.get(x).getMachineName(), 
                MachineList.get(x).getMinCapacity(), 
                MachineList.get(x).getMaxCapacity(), 
                MachineList.get(x).getMinVolume(), 
                MachineList.get(x).getMaxVolume()});
        }
        
        //pigment_table.setTableHeader(null);
        this.ResetColorText();
        return model_original;
    }
    
    private void get_updated_table()
    {
        model = GetAllMachines();
        this.MachineListTable.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMachineButton;
    private javax.swing.JButton DeleteMachineButton;
    private javax.swing.JButton DeleteMachineButton1;
    private javax.swing.JButton EditMachineButton;
    private javax.swing.JTable MachineListTable;
    private javax.swing.JTextField MachineMaximumCapacity;
    private javax.swing.JTextField MachineMaximumVolume;
    private javax.swing.JTextField MachineMinimumCapacity;
    private javax.swing.JTextField MachineMinimumVolume;
    private javax.swing.JTextField MachineName;
    private javax.swing.JScrollPane MachineTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}