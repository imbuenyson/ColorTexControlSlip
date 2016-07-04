/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DataEntities.ResinProgram;
import Handlers.ColorHandler;
import Handlers.ResinProgramHandler;
import Handlers.ResinChemicalHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;

/**
 *
 * @author Eldridge
 */
public class ViewResinProgram extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    ResinProgram thisResin = new ResinProgram();
    
    /**
     * Creates new form ViewResinProgram
     */
    public ViewResinProgram() {
        initComponents();
        this.set_to_center();
        this.GetUpdatedTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BgPanel = new javax.swing.JPanel();
        ResinHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResinTable = new javax.swing.JTable();
        ResinLabel = new javax.swing.JLabel();
        BackBut = new javax.swing.JButton();
        DeleteBut = new javax.swing.JButton();
        SearchTextBox = new javax.swing.JTextField();
        SelectBut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BgPanel.setBackground(new java.awt.Color(102, 102, 102));
        BgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResinHeader.setBackground(new java.awt.Color(255, 255, 255));
        ResinHeader.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        ResinHeader.setForeground(new java.awt.Color(255, 255, 255));
        ResinHeader.setText("Resin Program List");
        BgPanel.add(ResinHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 19, 360, 40));
        ResinHeader.getAccessibleContext().setAccessibleName("ResinProgram");

        jScrollPane1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        ResinTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ResinTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ResinTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ResinTable.setRowHeight(20);
        ResinTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ResinTable);

        BgPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 123, 470, 200));

        ResinLabel.setBackground(new java.awt.Color(255, 255, 255));
        ResinLabel.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        ResinLabel.setForeground(new java.awt.Color(255, 255, 255));
        ResinLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ResinLabel.setText("  Resin Program List");
        ResinLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        BgPanel.add(ResinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 85, 470, 40));

        BackBut.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        BackBut.setText("Back");
        BackBut.setToolTipText("");
        BgPanel.add(BackBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 220, 42));

        DeleteBut.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        DeleteBut.setText("Delete");
        DeleteBut.setToolTipText("");
        DeleteBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButActionPerformed(evt);
            }
        });
        BgPanel.add(DeleteBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 220, 42));

        SearchTextBox.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        SearchTextBox.setForeground(new java.awt.Color(204, 204, 204));
        SearchTextBox.setText("Search :");
        SearchTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextBoxActionPerformed(evt);
            }
        });
        SearchTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchTextBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTextBoxFocusLost(evt);
            }
        });
        SearchTextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextBoxKeyReleased(evt);
            }
        });
        BgPanel.add(SearchTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 470, -1));

        SelectBut1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        SelectBut1.setText("Select");
        SelectBut1.setToolTipText("");
        SelectBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectBut1ActionPerformed(evt);
            }
        });
        BgPanel.add(SelectBut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 220, 42));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextBoxFocusGained
        // TODO add your handling code here:
        if(SearchTextBox.getText().equals("Search :"))
        {
            SearchTextBox.setText("");
            SearchTextBox.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_SearchTextBoxFocusGained

    private void SearchTextBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTextBoxFocusLost
        // TODO add your handling code here:
        if(SearchTextBox.getText().equals(""))
        this.ResetResinText();
    }//GEN-LAST:event_SearchTextBoxFocusLost

    private void SearchTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextBoxActionPerformed

    public void set_to_center()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
    }
    
    private void UpdateRowFilter(String row_filter_text)
    {
        TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(this.ResinTable.getModel());
        
        this.ResinTable.setRowSorter(rowSorter);
        
        if (row_filter_text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + row_filter_text));        
        }
    }
    
    private void GetUpdatedTable()
    {
        model = getUpdatedResinTableModel();
        this.ResinTable.setModel(model);
    }
    
    public DefaultTableModel getUpdatedResinTableModel() {      
        
        DefaultTableModel model_original = new DefaultTableModel();
        model_original.addColumn("Program Name");
        
        ArrayList<String> ResinList = new ResinProgramHandler().GetAllResinProgram();
        for(int x=0; x<ResinList.size(); x++)
        {
            model_original.addRow(new Object[]{ResinList.get(x).toString()});
        }
        return model_original;
    }
    
    public void ResetResinText()
    {
        this.SearchTextBox.setText("Search :");
        SearchTextBox.setForeground(new Color(204,204,204));
    }
    
    private void SearchTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextBoxKeyReleased
        // TODO add your handling code here:
        UpdateRowFilter(this.SearchTextBox.getText());

    }//GEN-LAST:event_SearchTextBoxKeyReleased

    private void DeleteButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButActionPerformed
        if(ResinTable.getSelectedRowCount() > 0 )
        {
            int CloseorNoreply = JOptionPane.showConfirmDialog(null,"Delete this Program? "
                  ,"Delete Resin Program?", JOptionPane.YES_NO_OPTION);
            if(CloseorNoreply == JOptionPane.YES_OPTION)
            {
                String resinProgramName = this.ResinTable.getModel().getValueAt(this.ResinTable.getSelectedRow(), 0).toString();
                thisResin.setName(resinProgramName);
                thisResin.setID(new ResinProgramHandler().GetResinProgramIDFromResinProgramName(resinProgramName));
                new ResinChemicalHandler().DeleteResinChemicalByResinProgramId(thisResin.getID());
                new ResinProgramHandler().DeleteResinProgram(thisResin.getID());
                this.GetUpdatedTable();
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Please select an Item in the table to be deleted.");
        }
    }//GEN-LAST:event_DeleteButActionPerformed

    private void SelectBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectBut1ActionPerformed
        String resinProgramName = ResinTable.getModel().getValueAt(ResinTable.getSelectedRow(),0).toString();
        
        if(resinProgramName != null && !resinProgramName.equals(""))
        {
        //    new ViewResinProgramChemicals(resinProgramName).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please select a resin program.");
        }
    }//GEN-LAST:event_SelectBut1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewResinProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewResinProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewResinProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewResinProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewResinProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBut;
    private javax.swing.JPanel BgPanel;
    private javax.swing.JButton DeleteBut;
    private javax.swing.JLabel ResinHeader;
    private javax.swing.JLabel ResinLabel;
    private javax.swing.JTable ResinTable;
    private javax.swing.JTextField SearchTextBox;
    private javax.swing.JButton SelectBut1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
