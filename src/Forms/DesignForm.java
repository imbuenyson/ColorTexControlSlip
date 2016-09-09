/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DataEntities.Design;
import Handlers.DesignHandler;
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

/**
 *
 * @author Eldridge
 */
public class DesignForm extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    Design thisDesign = new Design();
    /**
     * Creates new Design Form
     */
    public DesignForm() {
        initComponents();
        this.SetToCenter();
        this.GetUpdatedTable();
    }

    public void SetToCenter()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
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
        DesignHeader = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        DesignLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DesignTable = new javax.swing.JTable();
        DesignText = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Color Text Control Slip");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        DesignHeader.setBackground(new java.awt.Color(255, 255, 255));
        DesignHeader.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        DesignHeader.setForeground(new java.awt.Color(255, 255, 255));
        DesignHeader.setText("Design");
        jPanel1.add(DesignHeader);
        DesignHeader.setBounds(20, 20, 360, 40);

        DeleteButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteButton);
        DeleteButton.setBounds(212, 390, 100, 50);

        DesignLabel.setBackground(new java.awt.Color(255, 255, 255));
        DesignLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        DesignLabel.setForeground(new java.awt.Color(255, 255, 255));
        DesignLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DesignLabel.setText("Design List");
        DesignLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(DesignLabel);
        DesignLabel.setBounds(10, 80, 400, 40);

        AddButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        AddButton.setText("Add");
        AddButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddButton);
        AddButton.setBounds(7, 390, 100, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.setOpaque(false);

        DesignTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        DesignTable.setModel(new javax.swing.table.DefaultTableModel(
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
        DesignTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DesignTable.setRowHeight(20);
        DesignTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(DesignTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 117, 400, 200);

        DesignText.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        DesignText.setForeground(new java.awt.Color(204, 204, 204));
        DesignText.setText("Name :");
        DesignText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DesignTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DesignTextFocusLost(evt);
            }
        });
        DesignText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DesignTextKeyReleased(evt);
            }
        });
        jPanel1.add(DesignText);
        DesignText.setBounds(10, 330, 400, 30);

        EditButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        EditButton.setText("Edit");
        EditButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        jPanel1.add(EditButton);
        EditButton.setBounds(110, 390, 100, 50);

        CloseButton.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        CloseButton.setText("Close");
        CloseButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CloseButton);
        CloseButton.setBounds(315, 390, 100, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        if(DesignText.getText().length()>0 && !DesignText.getText().equals("Name :"))
        {
            thisDesign.setDesignName(this.DesignText.getText());
            DesignHandler thisDesignHandler = new DesignHandler();
            thisDesign.setDesignId(thisDesignHandler.GetDesignIDFromName(thisDesign.getDesignName()));
            if(AddButton.getText().equals("Save"))
            {
               if(this.thisDesign.getDesignId()!= -1)
               {
                   thisDesignHandler.UpdateDesign(thisDesign); 
                   thisDesign.setDesignName("");
                   thisDesign.setDesignId(-1);
                   this.DeleteButton.setEnabled(true);
                   this.EditButton.setText("Edit");
                   AddButton.setText("Add");
               }
            }
            else
            {
                if(thisDesignHandler.AddNewDesign(thisDesign)){
                    JOptionPane.showMessageDialog(null, "Successfully added Design : "+DesignText.getText());
                    this.dispose();
                }
                else if(DesignText.getText() == "Name :")
                {
                    JOptionPane.showMessageDialog(null, "Please input a text.");
                }
                else
                    JOptionPane.showMessageDialog(null, "Design with the same name has already been added.");
            }
            
            this.GetUpdatedTable();
            this.ResetDesignText();
        }
        else
        JOptionPane.showMessageDialog(null, "Please add a character/letter to the Design name");
            
    }//GEN-LAST:event_AddButtonActionPerformed

    public void ResetDesignText()
    {
        this.DesignText.setText("Name :");
        DesignText.setForeground(new Color(204,204,204));
        this.UpdateRowFilter("");
    }
    
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        if(DesignTable.getSelectedRowCount() > 0 )
        {
            int CloseorNoreply = JOptionPane.showConfirmDialog(null,"Delete this Design? "
                  ,"Delete Design?", JOptionPane.YES_NO_OPTION);
            if(CloseorNoreply == JOptionPane.YES_OPTION)
            {
                setDesignDetails();
                new DesignHandler().DeleteDesign(thisDesign.getDesignId());
                this.GetUpdatedTable();
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Please select an Item in the table to be edited");
        }
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void GetUpdatedTable()
    {
        model = getUpdatedDesignTableModel();
        this.DesignTable.setModel(model);
    }
    
    private void UpdateRowFilter(String row_filter_text)
    {
        TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(this.DesignTable.getModel());
        
        this.DesignTable.setRowSorter(rowSorter);
        
        if (row_filter_text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + row_filter_text));        
        }
    }
    
    private void DesignTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesignTextKeyReleased
        // TODO add your handling code here:
        UpdateRowFilter(this.DesignText.getText());
        
    }//GEN-LAST:event_DesignTextKeyReleased

    private void DesignTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesignTextFocusGained
        // TODO add your handling code here:
        if(DesignText.getText().equals("Name :"))
        {
            DesignText.setText("");
            DesignText.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_DesignTextFocusGained

    private void DesignTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DesignTextFocusLost
        // TODO add your handling code here:
        if(DesignText.getText().equals(""))
            this.ResetDesignText();
    }//GEN-LAST:event_DesignTextFocusLost

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:

        if(EditButton.getText().equals("Edit"))
        {
            if(DesignTable.getSelectedRowCount() > 0 )
            {
                DesignText.setForeground(Color.BLACK);
                //thisDesign.setDesignName(this.DesignTable.getModel().getValueAt(getUpdatedSelectedRowIndex(), 0).toString());
                //thisDesign.setDesignId(new DesignHandler().GetDesignIDFromName(thisDesign.getDesignName()));
                //model.removeRow(getUpdatedSelectedRowIndex());
                setDesignDetails();
                DesignText.setText(thisDesign.getDesignName());
            
                this.EditButton.setText("Cancel");
                this.AddButton.setText("Save");
                this.DeleteButton.setEnabled(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an Item in the table to be edited");
            }
        }
        else
        {
            model.addRow(new String[]{thisDesign.getDesignName()});
            thisDesign.setDesignName("");
            
            EditButton.setText("Edit");
            this.AddButton.setText("Add");
            this.DeleteButton.setEnabled(true);
            this.ResetDesignText();
        }
       
    }//GEN-LAST:event_EditButtonActionPerformed

    private void setDesignDetails()
    {
        String DesignName = this.DesignTable.getModel().getValueAt(getUpdatedSelectedRowIndex(), 0).toString();
        thisDesign.setDesignName(DesignName);
        thisDesign.setDesignId(new DesignHandler().GetDesignIDFromName(DesignName));
        model.removeRow(getUpdatedSelectedRowIndex()); 
    }
    
    private int getUpdatedSelectedRowIndex()
    {
        return DesignTable.convertRowIndexToModel(this.DesignTable.getSelectedRow());
    }
    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        // TODO add your handling code here:
            this.dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DesignForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesignForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesignForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesignForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesignForm().setVisible(true);
            }
        });
    }
    
    public DefaultTableModel getUpdatedDesignTableModel() {      
        
        DefaultTableModel model_original = new DefaultTableModel();
        model_original.addColumn("Design Name");
        
        ArrayList<String> DesignList = new DesignHandler().GetAllDesigns();
        for(int x=0; x<DesignList.size(); x++)
        {
            model_original.addRow(new Object[]{DesignList.get(x).toString()});
        }
        return model_original;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DesignHeader;
    private javax.swing.JLabel DesignLabel;
    private javax.swing.JTable DesignTable;
    private javax.swing.JTextField DesignText;
    private javax.swing.JButton EditButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
