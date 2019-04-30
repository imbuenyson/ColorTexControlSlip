/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.HelpForm;

import DataEntities.Machine;
import DataEntities.ResinJob;
import Forms.AddResinForm;
import Forms.ReviewFormV3;
import Forms.ViewResinProgramList;
import Handlers.MachineHandler;
import Handlers.PreferenceHandler;
import Handlers.ResinProgramHandler;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class ResinPanel extends javax.swing.JPanel {

    private Machine machineDetails = new Machine();
    ResinJob thisResinJob;
    /**
     * @return the machineDetails
     */
    public Machine getMachineDetails() {
        return machineDetails;
    }

    /**
     * @param machineDetails the machineDetails to set
     */
    public void setMachineDetails(Machine machineDetails) {
        this.machineDetails = machineDetails;
    }

    /**
     * Creates new form ResinPanel
     */
    public ResinPanel() {
        initComponents();
    }
    
    public ResinPanel(ResinJob currentResinJob)
    {
        this();
        thisResinJob = currentResinJob;
        SetResinProgramName(thisResinJob.getResinProgramID());
        populateResinMachineDropDown();
        SetResinMachineNameDropDown();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ResinMachineDropDown = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ResinWeight = new javax.swing.JTextField();
        ResinVolumeTextField = new javax.swing.JTextField();
        ResinProgramText = new javax.swing.JTextField();
        ResinLabel = new javax.swing.JLabel();
        EditResinProgram = new javax.swing.JButton();
        ResinFabricTypeDropDown = new javax.swing.JComboBox<>();
        FabricTypeLabel = new javax.swing.JLabel();
        EditResinProgram1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResinMachineDropDown.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinMachineDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Machine" }));
        ResinMachineDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResinMachineDropDownActionPerformed(evt);
            }
        });
        add(ResinMachineDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 275, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Weight :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Volume of Water :");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 145, 30));

        ResinWeight.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ResinWeightKeyReleased(evt);
            }
        });
        add(ResinWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 205, 30));

        ResinVolumeTextField.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinVolumeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ResinVolumeTextFieldKeyReleased(evt);
            }
        });
        add(ResinVolumeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 170, 30));

        ResinProgramText.setEditable(false);
        ResinProgramText.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinProgramText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ResinProgramText.setEnabled(false);
        add(ResinProgramText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 280, 30));

        ResinLabel.setBackground(new java.awt.Color(255, 255, 255));
        ResinLabel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinLabel.setForeground(new java.awt.Color(255, 255, 255));
        ResinLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ResinLabel.setText("Resin Program :");
        ResinLabel.setToolTipText("");
        add(ResinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, 30));

        EditResinProgram.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EditResinProgram.setText("Change");
        EditResinProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditResinProgramActionPerformed(evt);
            }
        });
        add(EditResinProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 110, 30));

        ResinFabricTypeDropDown.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ResinFabricTypeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fabric Type", "TC 0.3 + 30 liters", "CVC 0.4 + 30 liters", "CC 0.5 + 30 liters", "Polyester and Spun 0.65 + 30 liters", "TC 0.5" }));
        ResinFabricTypeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResinFabricTypeDropDownActionPerformed(evt);
            }
        });
        add(ResinFabricTypeDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 170, 30));

        FabricTypeLabel.setBackground(new java.awt.Color(255, 255, 255));
        FabricTypeLabel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        FabricTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        FabricTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FabricTypeLabel.setText("Fabric Type :");
        add(FabricTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 145, 30));

        EditResinProgram1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EditResinProgram1.setText("Edit");
        EditResinProgram1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditResinProgram1ActionPerformed(evt);
            }
        });
        add(EditResinProgram1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void SetResinProgramName(int resinProgramID) {
        if (resinProgramID > 0) {
            String ResinProgramName
                    = new ResinProgramHandler().GetResinProgramNameFromResinProgramID(resinProgramID);
            ResinProgramText.setText(ResinProgramName);
        }
    }
    
    private void populateResinMachineDropDown() {
        //if Resin requires custom Machine
        ArrayList<Machine> MachineList;
        if(new PreferenceHandler().getResinMachineInputPreference())
        {
            MachineList = new MachineHandler().GetAllManualResinMachines();
        }
        else
            MachineList = new MachineHandler().GetAllAutomaticResinMachines();
        
        //ArrayList<Machine> MachineList = new MachineHandler().GetAllResinMachines();

        if (MachineList != null) {
            for (int x = 0; x < MachineList.size(); x++) {
                ResinMachineDropDown.addItem(MachineList.get(x).getMachineName());
            }
        }
    }
    
    private void SetResinMachineNameDropDown() 
    {
        //this.machineDetails.setMachineId(thisResinJob.getResinMachineID());
        MachineHandler thisMachineHandler = new MachineHandler();
        machineDetails = new MachineHandler().GetMachineDetailsById(thisResinJob.getResinMachineID());
        ResinMachineDropDown.setSelectedItem(machineDetails.getMachineName());
        ResinWeight.setText(Float.toString(thisResinJob.getResinWeight()));
        ResinVolumeTextField.setText(Float.toString(thisResinJob.getResinVolH2O()));
    }
    
    private void ResinMachineDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResinMachineDropDownActionPerformed
        // TODO add your handling code here:
        
        MachineHandler handler = new MachineHandler();
        int machineId = -1;
        String machineName = "";

        if (!ResinMachineDropDown.getSelectedItem().toString().equals("Choose Machine")) {
            machineName = ResinMachineDropDown.getSelectedItem().toString();

            if (!machineName.equals("")) {
                machineId = handler.GetMachineIdByName(machineName);

                if (machineId > -1) {
                    setMachineDetails(handler.GetMachineDetailsById(machineId));

                }
            }
        }

        //thisResinMachine.setMachineName(getMachineDetails().getMachineName());
    }//GEN-LAST:event_ResinMachineDropDownActionPerformed

    private boolean CheckIfResinMachineHasInputs()
    {
        boolean isSuccessful = true;
        
        if(this.machineDetails.getMachineId() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the Resin Machine.");  
        }
        else if(this.ResinVolumeTextField.getText().length() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the value in Volume of Water in Resin Machine."); 
        }
        else if(this.ResinWeight.getText().length() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the value in the Weight in Resin Machine."); 
        }
        
        return isSuccessful;
    }
    
     private void ComputeForResinVolume() {
        String weight = ResinWeight.getText();
        //String liquidRatio = this.ResinMachineLiquidRatioDropDown.getSelectedItem().toString();
        if (!weight.isEmpty() && ResinFabricTypeDropDown.getSelectedIndex()!= 0 )//liquidRatio.equals("Liquid Ratio"))
        {
            //String selected = DyeingMachineLiquidRatioDropDown.getSelectedItem().toString();
            ResinVolumeTextField.setText(Float.toString(new MachineHandler().ComputeVolumeOfWaterFromWeight(Float.parseFloat(weight), ResinFabricTypeDropDown.getSelectedItem().toString())));
        }
    }
     
    private boolean CheckTextBoxIsParseValid(JTextField thisTextField) {
        return thisTextField.getText().length() >= 1;
    }
    
    private void ResinWeightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResinWeightKeyReleased
        // TODO add your handling code here:
        String weight = ResinWeight.getText();
        weight = weight.replaceAll("[^\\d.]", "");
        ResinWeight.setText(weight);
        if (this.CheckTextBoxIsParseValid(ResinWeight)) {
            thisResinJob.setResinWeight(Float.parseFloat(weight));
            ComputeForResinVolume();
        }
    }//GEN-LAST:event_ResinWeightKeyReleased

    private void ResinVolumeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResinVolumeTextFieldKeyReleased
        // TODO add your handling code here:
        String volume = this.ResinVolumeTextField.getText();
        volume = volume.replaceAll("[^\\d.]", "");
        ResinVolumeTextField.setText(volume);
        if (this.CheckTextBoxIsParseValid(ResinVolumeTextField)) {
            thisResinJob.setResinVolH2O(Float.parseFloat(volume));
        }
    }//GEN-LAST:event_ResinVolumeTextFieldKeyReleased

    private void EditResinProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditResinProgramActionPerformed
        // TODO add your handling code here:
        if (CheckIfResinMachineHasInputs() ) {
                //&& CheckCustomerAndJobOrderFromTextBox()
            thisResinJob.setResinMachineID(machineDetails.getMachineId());
            ReviewFormV3 ReviewForm = (ReviewFormV3) this.getTopLevelAncestor();
            
            ReviewForm.AddTextToJobOrderObject();
            
            ViewResinProgramList thisResinProgram;
            thisResinProgram = new ViewResinProgramList(ReviewForm.getThisJob(), ReviewForm.getWindowType());
            thisResinProgram.setVisible(true);
            ReviewForm.dispose();
        }
    }//GEN-LAST:event_EditResinProgramActionPerformed

    private void ResinFabricTypeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResinFabricTypeDropDownActionPerformed
        // TODO add your handling code here:
        if(!ResinWeight.getText().isEmpty() && this.ResinFabricTypeDropDown.getSelectedIndex() != 0)
        {
            ResinVolumeTextField.setText(
                Float.toString(
                    new MachineHandler().ComputeVolumeOfWaterFromWeight(
                        Float.parseFloat(ResinWeight.getText()), ResinFabricTypeDropDown.getSelectedItem().toString())));
        }
    }//GEN-LAST:event_ResinFabricTypeDropDownActionPerformed

    private void EditResinProgram1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditResinProgram1ActionPerformed
        // TODO add your handling code here:
        ReviewFormV3 ReviewForm = (ReviewFormV3) this.getTopLevelAncestor();
        new AddResinForm(this.ResinProgramText.getText(), ReviewForm.getThisJob(), ReviewForm.getWindowType()).setVisible(true);
        //new ViewResinProgramChemicals(resinProgramName).setVisible(true);
        ReviewForm.dispose();


    }//GEN-LAST:event_EditResinProgram1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditResinProgram;
    private javax.swing.JButton EditResinProgram1;
    private javax.swing.JLabel FabricTypeLabel;
    private javax.swing.JComboBox<String> ResinFabricTypeDropDown;
    private javax.swing.JLabel ResinLabel;
    private javax.swing.JComboBox<String> ResinMachineDropDown;
    private javax.swing.JTextField ResinProgramText;
    private javax.swing.JTextField ResinVolumeTextField;
    private javax.swing.JTextField ResinWeight;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    // End of variables declaration//GEN-END:variables

    public void setResinJobDataFromPanel()
    {
        thisResinJob.setResinWeight(Float.parseFloat(ResinWeight.getText()));
        thisResinJob.setResinVolH2O(Float.parseFloat(ResinVolumeTextField.getText()));
        thisResinJob.setResinMachineID(machineDetails.getMachineId());
        //thisResinJob.setResinProgramID(ERROR);
    }
    public ResinJob getDataInThisPanel() 
    {
        setResinJobDataFromPanel();
        return thisResinJob;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
