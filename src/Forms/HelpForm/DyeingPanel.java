/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.HelpForm;

/**
 *
 * @author Eldridge
 */
public class DyeingPanel extends javax.swing.JPanel {

    /**
     * Creates new form DyeingPanel
     */
    public DyeingPanel() {
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

        Process = new javax.swing.JTabbedPane();
        ProgramNameLabel = new javax.swing.JLabel();
        ProgramNameText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Process.setBackground(new java.awt.Color(255, 255, 255));
        Process.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add(Process, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 770, 500));

        ProgramNameLabel.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        ProgramNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProgramNameLabel.setText("Program Name :");
        add(ProgramNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 165, 34));

        ProgramNameText.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        add(ProgramNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 580, 34));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Process;
    private javax.swing.JLabel ProgramNameLabel;
    private javax.swing.JTextField ProgramNameText;
    // End of variables declaration//GEN-END:variables
}
