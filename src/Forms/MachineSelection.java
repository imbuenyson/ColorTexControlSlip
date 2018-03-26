/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DataEntities.JobOrder;
import DataEntities.Machine;
import Handlers.LiquidRatioHandler;
import Handlers.MachineHandler;
import Handlers.PreferenceHandler;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class MachineSelection extends javax.swing.JFrame {

    Machine thisMachine = new Machine();
    int WindowType = 1;
    private JobOrder thisJob = new JobOrder();
    /**
     * Creates new form MachineSelection
     */
    public MachineSelection() {
        initComponents();
        SetToCenter();
        //this.populateLiquorRatioDropDown();
        populateResinMachineDropDown();
    }
    
    public MachineSelection(JobOrder currentJob)
    {
        this();
        thisJob = currentJob;
        if(thisJob.getResinMachineID()!= 0 )
        SetValuesFromThisJob();
    }
    
    public void SetValuesFromThisJob()
    {
        
        MachineHandler tempResMachineHandler = new MachineHandler();
        
        MachineDropDownList.setSelectedItem(tempResMachineHandler.GetMachineDetailsById(thisJob.getResinMachineID()).getMachineName());
        Weight.setText(Float.toString(thisJob.getResinWeight()));
        VolumeTextField.setText(Float.toString(thisJob.getResinVolumeH20()));
        
    }
    
    public void SetToCenter()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
    }
    
    private void populateResinMachineDropDown(){
        //PopulateList(new MachineHandler().GetAllDyeingMachines() , MachineDropDownList);
        ArrayList<Machine> MachineList;
        //Return true if manual
        if(new PreferenceHandler().getResinMachineInputPreference())
        {
            MachineList = new MachineHandler().GetAllManualResinMachines();
        }
        else
            MachineList = new MachineHandler().GetAllAutomaticResinMachines();
        
        //ArrayList<Machine> MachineList = new MachineHandler().GetAllResinMachines();
        
        if(MachineList != null){
            for(int x=0; x<MachineList.size(); x++)
            {
                MachineDropDownList.addItem(MachineList.get(x).getMachineName());
            }
        }   
    }
    
    private void CheckValuesAndComputeForVolumeUsingFabricStyle()
    {
        String weight = Weight.getText();
        String FabricType = FabricDropDown.getSelectedItem().toString();
        if(!weight.isEmpty() && !FabricType.equals("Fabric"))
        {
            this.computeForVolumeByFabric();
        } 
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
        Header = new javax.swing.JLabel();
        MachineDropDownList = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        VolumeTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SelectBut = new javax.swing.JButton();
        FabricDropDown = new javax.swing.JComboBox<>();
        LiquidRatioDropDown = new javax.swing.JComboBox<>();
        BackBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("Resin Machine Selection");
        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 470, 40));

        MachineDropDownList.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MachineDropDownList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Machine" }));
        MachineDropDownList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineDropDownListActionPerformed(evt);
            }
        });
        jPanel1.add(MachineDropDownList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 78, 470, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Weight :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 117, 80, 30));

        Weight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Weight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                WeightFocusLost(evt);
            }
        });
        Weight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                WeightKeyReleased(evt);
            }
        });
        jPanel1.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 118, 140, 30));

        VolumeTextField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        VolumeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                VolumeTextFieldFocusLost(evt);
            }
        });
        VolumeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VolumeTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(VolumeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 159, 299, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Volume of Water :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 158, -1, 30));

        SelectBut.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        SelectBut.setText("Next");
        SelectBut.setToolTipText("");
        SelectBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButActionPerformed(evt);
            }
        });
        jPanel1.add(SelectBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 215, 145, 42));

        FabricDropDown.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        FabricDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fabric Type", "TC 0.3 +30 liters", "CVC 0.4 + 30 liters", "CC 0.5 + 30 liters", "Polyester and Spun 0.65 + 30 liters", "TC 0.5" }));
        FabricDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FabricDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(FabricDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 117, 228, 30));

        LiquidRatioDropDown.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LiquidRatioDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liquid Ratio" }));
        LiquidRatioDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiquidRatioDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(LiquidRatioDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 117, 228, 30));

        BackBut.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        BackBut.setText("Back");
        BackBut.setToolTipText("");
        BackBut.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BackBut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BackBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButActionPerformed(evt);
            }
        });
        jPanel1.add(BackBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 216, 145, 42));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MachineDropDownListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineDropDownListActionPerformed

        Machine machineDetails = new Machine();
        MachineHandler handler = new MachineHandler();
        int machineId = -1;
        String machineName = "";

        if(!MachineDropDownList.getSelectedItem().toString().equals("Choose Machine"))
        {
            machineName = MachineDropDownList.getSelectedItem().toString();
            machineId = handler.GetMachineIdByName(machineName);

            //if(!machineName.equals(""))
            //{}

            thisMachine.setMachineId(machineId);
            
            if (new PreferenceHandler().getResinMachineInputPreference()) {
                if (machineId > -1) {
                    machineDetails = handler.GetMachineDetailsById(machineId);
                }

                thisMachine.setMachineName(machineDetails.getMachineName());
                thisMachine.setMaxCapacity(machineDetails.getMaxCapacity());
                thisMachine.setMaxVolume(machineDetails.getMaxVolume());
                thisMachine.setMinCapacity(machineDetails.getMinCapacity());
                thisMachine.setMinVolume(machineDetails.getMinVolume());

                VolumeTextField.setText(Float.toString(thisMachine.getMaxVolume()));
                Weight.setText(Float.toString(thisMachine.getMaxCapacity()));
            }

        }

    }//GEN-LAST:event_MachineDropDownListActionPerformed

    private void WeightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_WeightFocusLost
        String weight = Weight.getText();
        if (!weight.isEmpty()) {
            weight = weight.replaceAll("[^\\d.]", "");
            Float ConvertedWeight = Float.parseFloat(weight);
            /*if (new PreferenceHandler().getResinMachineInputPreference()) {
                if (ConvertedWeight > thisMachine.getMaxCapacity()) {
                    Weight.setText(Float.toString(thisMachine.getMaxCapacity()));
                } else if (ConvertedWeight < thisMachine.getMinCapacity()) {
                    Weight.setText(Float.toString(thisMachine.getMinCapacity()));
                }
            }*/
            //Weight.setText(new LiquidRatioHandler().RoundToHundreds(Float.parseFloat(Weight.getText())).toString());
            //else
            computeForVolumeByFabric();
            //    Weight.setText(weight);
        }
    }//GEN-LAST:event_WeightFocusLost

    private void computeForVolumeByFabric()
    {
        if (this.FabricDropDown.getSelectedIndex() != 0) {
            String selected = FabricDropDown.getSelectedItem().toString();
            float weight = Float.parseFloat(Weight.getText());
            float volume = 0;

            String[] WeightMultiplier = selected.split("\\+");
            float multiplier = Float.parseFloat(WeightMultiplier[0].replaceAll("[^0-9\\.]", ""));
            if (WeightMultiplier.length > 1) {
                volume = (float) (weight * multiplier + Float.parseFloat(WeightMultiplier[1].replaceAll("[^0-9]", "")));
            } else {
                volume = (float) (weight * multiplier);
            }

            //VolumeTextField.setText(Float.toString(volume));
            VolumeTextField.setText(new LiquidRatioHandler().RoundToHundreds(volume).toString());
        }
    }
    
    private void VolumeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VolumeTextFieldFocusLost
        // TODO add your handling code here:
        String Volume = this.VolumeTextField.getText();
        Pattern p = Pattern.compile("[^\\d.]");
        Matcher m = p.matcher(Volume);
        //boolean b = m.find();
        if (Volume.length() > 0 && m.find()) {
            Volume = Volume.replaceAll("[^\\d.]", "");
            VolumeTextField.setText(new LiquidRatioHandler().RoundToHundreds(Float.parseFloat(Volume)).toString());

            //this.VolumeTextField.setText(Volume);
            if (new PreferenceHandler().getResinMachineInputPreference()) {
                Float ConvertedVolume = Float.parseFloat(Volume);
                if (ConvertedVolume > thisMachine.getMaxVolume()) {
                    this.VolumeTextField.setText(Float.toString(thisMachine.getMaxVolume()));
                } else if (ConvertedVolume < thisMachine.getMinVolume()) {
                    this.VolumeTextField.setText(Float.toString(thisMachine.getMinVolume()));
                }
            }
        }
        //else
        //    this.VolumeTextField.setText(Volume);
    }//GEN-LAST:event_VolumeTextFieldFocusLost

    private void LiquidRatioDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiquidRatioDropDownActionPerformed
        //ComputeForVolume();
        this.computeForVolumeWithLiquidRatio();
    }//GEN-LAST:event_LiquidRatioDropDownActionPerformed

    //Old Method
    private void CheckValuesAndComputeForVolumeUsingLiquidRatio()
    {
        String weight = Weight.getText();
        String liquidRatio = LiquidRatioDropDown.getSelectedItem().toString();
        if(!weight.equals("") && !liquidRatio.equals("Liquid Ratio"))
        {
            computeForVolumeWithLiquidRatio();
        } 
    }
    
    private void populateLiquorRatioDropDown() {
        ArrayList<String> LiquidRatioList = new ArrayList<String>();

        LiquidRatioList.add("1:6");
        LiquidRatioList.add("1:8");
        LiquidRatioList.add("1:9");
        LiquidRatioList.add("1:10");
        LiquidRatioList.add("1:12");

        for (int x = 0; x < LiquidRatioList.size(); x++) {

            LiquidRatioDropDown.addItem(LiquidRatioList.get(x));
        }
    }

    private void computeForVolumeWithLiquidRatio()
    {
        int weightMultiplier = 0;
        
        String selected = LiquidRatioDropDown.getSelectedItem().toString();
        float weight = Float.parseFloat(Weight.getText());
        
        if(selected.equals("1:6"))
        {
            weightMultiplier = 6;
        }
        else if(selected.equals("1:8"))
        {
            weightMultiplier = 8;
        }
        else if(selected.equals("1:9"))
        {
            weightMultiplier = 9;
        }
        else if(selected.equals("1:10"))
        {
            weightMultiplier = 10;
        }
        else if(selected.equals("1:12"))
        {
            weightMultiplier = 12;
        }
        
        int volume = (((int) (weight * weightMultiplier)) + 9) / 10 * 10;
        
        VolumeTextField.setText(Double.toString(volume));
    }
    
    private void BackButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButActionPerformed
        // TODO add your handling code here:
        
        //For Dyeing Machine if it will be used
        if(WindowType == 1)
        {
            JobOrderForm newJobOrderForm = new JobOrderForm(thisJob);
            newJobOrderForm.setVisible(true);
            newJobOrderForm.SetCustomerAndDesignDetails();
        }
        //Return to Dyeing Form if used as resin machine selector
        else if(WindowType == 2)
        {
            DyeingForm thisDyeingForm = new DyeingForm(thisJob);
            thisDyeingForm.setVisible(true);
        }
        this.dispose();

    }//GEN-LAST:event_BackButActionPerformed

    private void SelectButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButActionPerformed
        // TODO add your handling code here:
        if (CheckIfMachineDetailsIsValid()) {
            addDataToJobOrder();
            ViewResinProgramList thisResinProgram = new ViewResinProgramList(thisJob, 3);
            thisResinProgram.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_SelectButActionPerformed

    private void FabricDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FabricDropDownActionPerformed
        // TODO add your handling code here:
       this.CheckValuesAndComputeForVolumeUsingFabricStyle();
    }//GEN-LAST:event_FabricDropDownActionPerformed

    private void WeightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WeightKeyReleased
        // TODO add your handling code here:
        CheckTextValues(Weight);
        computeForVolumeByFabric();
    }//GEN-LAST:event_WeightKeyReleased

    private void VolumeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VolumeTextFieldKeyReleased
        // TODO add your handling code here:
        CheckTextValues(VolumeTextField);
    }//GEN-LAST:event_VolumeTextFieldKeyReleased

    public void CheckTextValues(JTextField thisTextBox)
    {
        String CheckThisValue = thisTextBox.getText();
        Pattern p = Pattern.compile("[^\\d.]");
        Matcher m = p.matcher(CheckThisValue);
        //boolean b = m.find();
        if (CheckThisValue.length() > 0 && m.find()) {
            
            CheckThisValue = CheckThisValue.replaceAll("[^\\d.]", "");
            //try{
            
            //    Float ConvertedValue = Float.parseFloat(CheckThisValue);
            //}
            //catch(NumberFormatException e)
            //{
                
            //}
            /*if (ConvertedWeight > thisMachine.getMaxCapacity()) {
                Weight.setText(Float.toString(thisMachine.getMaxCapacity()));
            } else if (ConvertedWeight < thisMachine.getMinCapacity()) {
                Weight.setText(Float.toString(thisMachine.getMinCapacity()));
            }*/
            //else    
            //ComputeVolume();
            //CheckValuesAndComputeForVolume();
                thisTextBox.setText(CheckThisValue);
        }
    }
    
    private boolean CheckIfMachineDetailsIsValid()
    {
        boolean isSuccessful = true;
        if(thisMachine.getMachineId() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the Machine details.");  
        }
        else if(this.VolumeTextField.getText().length() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the value in Volume of Water."); 
        }
        else if(this.Weight.getText().length() < 1)
        {
            isSuccessful = false;
            JOptionPane.showMessageDialog(null, "Please check the value in the Weight."); 
        }
        
        return isSuccessful;
    }
    private void addDataToJobOrder()
    {
        thisJob.setResinMachineID(thisMachine.getMachineId());
        thisJob.setResinVolumeH20(Float.parseFloat(this.VolumeTextField.getText()));
        thisJob.setResinWeight(Float.parseFloat(this.Weight.getText()));
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
            java.util.logging.Logger.getLogger(MachineSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachineSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachineSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachineSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachineSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBut;
    private javax.swing.JComboBox<String> FabricDropDown;
    private javax.swing.JLabel Header;
    private javax.swing.JComboBox<String> LiquidRatioDropDown;
    private javax.swing.JComboBox<String> MachineDropDownList;
    private javax.swing.JButton SelectBut;
    private javax.swing.JTextField VolumeTextField;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
