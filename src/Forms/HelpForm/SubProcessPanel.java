/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.HelpForm;

import DataEntities.Chemical;
import DataEntities.DyeingChemical;
import DataEntities.DyeingProcess;
import DataEntities.JobOrder;
import Forms.CurrentTableModel;
import Forms.TableRowTransferHandler;
import Handlers.ChemicalHandler;
import Handlers.ComputeHelper;
import Handlers.DyeingChemicalHandler;
import Handlers.DyeingProcessHandler;
import Handlers.JobHandler;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Eldridge
 */
public class SubProcessPanel extends javax.swing.JPanel {

    DyeingProcess ThisDyeingProcess = new DyeingProcess();
    int ChemicalColumn = 0;
    int StateColumn = 1;
    int TypeColumn = 2;
    int ValueColumn = 3;
    private int WindowType = 0;
    int EditableCol = 4;
    boolean ValueTextCheckerTriggered = false;
    ArrayList<String> AllChemical = new ArrayList<String>();
    ArrayList<String> AddedChemicalList = new ArrayList<String>();
    ArrayList<Integer> ChemicalIDtoBeDeleted = new ArrayList<Integer>();
    Color ColorError = new Color(232,228,42);
    JobOrder thisJobOrder = new JobOrder();
    /**
     * Creates new form TrialPanel
     */
    public SubProcessPanel() {
        initComponents();
        addChemicalTextBoxAutoComplete();
        setTableModel(WindowType);
        AddDeleteColumn();   
        //ChemicalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //InitializeChemicalTable();
        //InitializeGPLandPercentColumn();
        //ChemicalTable.getModel().addTableModelListener(newTableListener);   
    }
    
    public SubProcessPanel(int type){
        initComponents();
        WindowType = type;
        addChemicalTextBoxAutoComplete();
        setTableModel(WindowType);
        AddDeleteColumn(); 
    }
    
    public SubProcessPanel(int DyeingProcessID, int type)
    {
        //intialize constructors
        this(DyeingProcessID, type, null);
        //initComponents();
        //addChemicalTextBoxAutoComplete();
        //WindowType = type;
        //setTableModel(WindowType);
        //AddDeleteColumn();
        //SetSubProcessFromDyeingProgram(DyeingProcessID);
        //TableColumn thisColumn = new TableColumn(ChemicalTable.getColumnCount()-2,50);
        //thisColumn.setHeaderValue("Quantity");
        //ChemicalTable.addColumn(thisColumn);  
        //ChemicalTable.removeColumn(thisColumn);
    }
    
    public SubProcessPanel(int DyeingProcessID, int type , JobOrder currentJobOrder)
    {
        //intialize constructors
        initComponents();
        addChemicalTextBoxAutoComplete();
        WindowType = type;
        thisJobOrder = currentJobOrder;
        
        setTableModel(WindowType);
        SetSubProcessFromDyeingProgram(DyeingProcessID);
        //TableColumn thisColumn = new TableColumn(ChemicalTable.getColumnCount()-2,50);
        //thisColumn.setHeaderValue("Quantity");
        //ChemicalTable.addColumn(thisColumn);  
        //ChemicalTable.removeColumn(thisColumn);
        ChemicalTable.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (ValueColumn == e.getColumn() && ValueColumn+1 != EditableCol) {
                    ChemicalTable.getModel().setValueAt(computeQuantity(e.getFirstRow(), e.getColumn()),e.getFirstRow(),e.getColumn()+1);
                    //System.out.println(ChemicalTable.getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                    //System.out.println(e.getColumn() + " " + e.getFirstRow() + " " + e.getSource().toString());

                }
            }
        });
    }
    public float computeQuantity(int row, int column)
    {
         Float Quantity = new ComputeHelper().ComputeDyeingQuantity(GetThisRowOfValues(row), thisJobOrder);
         return Quantity;  
    }
    private void setTableModel(int type)
    {
        String[] TableHeader;
        if(type == 3 || type == 4 || type == 5)
        {
            TableHeader = new String [] {
                "Chemical", "Gram/Liter", "Type", "Value" , "Quantity" ,"Delete", "ID"
            };
            EditableCol++;
        }
        //View from job Order
        else if( type == 6 || type ==7)
        {
            TableHeader = new String [] {
                "Chemical", "Gram/Liter", "Type", "Value" , "Quantity" , "ID"
            };
        }
        else
        {
            TableHeader = new String [] {
                "Chemical", "Gram/Liter", "Type", "Value" ,"Delete" , "ID"
            };
        }
        
        CurrentTableModel tableModel = new CurrentTableModel( ) {
         //    @Override
         //   public boolean isCellEditable(int row, int column) {
            //Only the third column
         //       return column == CellEditable;
         //   }
        };
        for(String Headers : TableHeader)
            tableModel.addColumn(Headers);
       
        ChemicalTable.setDragEnabled(true);
        ChemicalTable.setDropMode(DropMode.INSERT_ROWS);
        ChemicalTable.setTransferHandler(new TableRowTransferHandler(ChemicalTable)); 
        ChemicalTable.setModel(tableModel);
        //ChemicalTable.remove(type);
         
        ChemicalTable.removeColumn(ChemicalTable.getColumnModel().getColumn(EditableCol+1));
        if(type != 7 && type !=6)
        {
            AddDeleteColumn();
        }
    }
    public void DeleteAllChemicaltoBeDeletedFromDB()
    {
        for(int DyeingChemicalID : ChemicalIDtoBeDeleted)
        {
             DyeingChemical ThisDyeingChemical = new DyeingChemical();
             ThisDyeingChemical.setID(DyeingChemicalID);
             new DyeingChemicalHandler().DeleteDyeingChemical(ThisDyeingChemical);
        }
    }
    
    public void AddDeleteColumn()
    {
        Action delete = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                if (JOptionPane.YES_OPTION
                        == JOptionPane.showConfirmDialog(null, "Do you want to delete Chemical: " + table.getModel().getValueAt(modelRow, 0) + " From this Process?", "DELETE this item?", JOptionPane.YES_NO_OPTION)) {
                    
                    //ThisDyeingChemical.setID(ChemicalList.get(LastRow).getID());
                    //int convertedRowNumber = JobOrderTable.convertRowIndexToModel(this.JobOrderTable.getSelectedRow());
                    //String DrNumber = JobOrderTable.getModel().getValueAt(convertedRowNumber , 0).toString();
                    //int JobId = Integer.parseInt(JobOrderTable.getModel().getValueAt(convertedRowNumber , 9).toString());
                    AddedChemicalList.remove(table.getModel().getValueAt(modelRow, 0));
                    ((CurrentTableModel) table.getModel()).removeRow(modelRow);

                }

                
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(ChemicalTable, delete, ChemicalTable.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        //TableColumn thisColumn = new TableColumn(ChemicalTable.getColumnCount()-1,50 ,new ButtonRenderer(),  new ButtonEditor(new JCheckBox()));
        //thisColumn.setHeaderValue("Delete");
        //ChemicalTable.addColumn(thisColumn);
        //DefaultTableModel tableModel = (DefaultTableModel) ChemicalTable.getModel();
        //tableModel.addColumn("Delete");
        //ChemicalTable.setModel(tableModel);
        //ChemicalTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        //ChemicalTable.getColumn("Delete").setCellEditor( new ButtonEditor(new JCheckBox()));
    }
    
    public void SetSubProcessFromDyeingProgram(int SubProcessID)
     {
         DyeingProcessHandler ThisDyeingProcessHandler = new DyeingProcessHandler();
         ThisDyeingProcess = ThisDyeingProcessHandler.GetDyeingProcessDetailsById(SubProcessID);
         this.SubProcessText.setText(ThisDyeingProcess.getDyeingProcessName());
         SetChemicalListFromDyeingProcessID(SubProcessID);
     }
    /*
     public float ComputeQuantityFromWeightOrVol(DyeingChemical thisDyeingChemical)
     {
         Float quantity;
         if(thisDyeingChemical.getType().equals("%"))
         {
             //Old Computation
             //quantity = thisJobOrder.getWeight() * Value;
             //New Computation
             quantity = thisJobOrder.getWeight() * thisDyeingChemical.getValue() * 10;
         }
         else
         {
             if(thisDyeingChemical.getState().equals("G"))
                 quantity = thisJobOrder.getVolumeH20() * thisDyeingChemical.getValue();
             else
                 // Formula = Quantity in ml = Chemical Values in GPL * Vol of Water /1.5 
                 //           Change to Liter = /1000 
                 //           Final formula to get liters = (ChemVal * VolOfWater) / (1.5 * 1000)
                 quantity = thisJobOrder.getVolumeH20() * thisDyeingChemical.getValue() / (float) 1500;
                 
         }
         return quantity;
     }
     */
     public void SetChemicalListFromDyeingProcessID(int DyeingProcessID)
     {
         ArrayList<DyeingChemical> ThisDyeingChemical;
         DyeingChemicalHandler ThisDyeingChemicalHandler = new DyeingChemicalHandler();
         CurrentTableModel model = (CurrentTableModel) ChemicalTable.getModel();
         ThisDyeingChemical = ThisDyeingChemicalHandler.GetAllDyeingChemicalFromDyeingProcessID(DyeingProcessID);
         
         for(DyeingChemical thisDyeingChemical : ThisDyeingChemical)
         {
             //Add Chemical and its details to the Table
             String ChemicalName = getChemicalNameFromID(thisDyeingChemical.getChemicalId());
             //Float Quantity = ComputeQuantityFromWeightOrVol(thisDyeingChemical);
             Float Quantity;
             if(WindowType == 3 || WindowType == 4 || WindowType == 5 || WindowType == 6)
             //if(thisJobOrder.getID() > 0)
             {
                 
                 Quantity = new ComputeHelper().ComputeDyeingQuantity(thisDyeingChemical, thisJobOrder);
                 model.addRow(new Object[] { ChemicalName, thisDyeingChemical.getState(),thisDyeingChemical.getType(), thisDyeingChemical.getValue(),Quantity, "Delete" , thisDyeingChemical.getID()});                 
             }
             else if (WindowType == 7)
             {
                 Quantity = new ComputeHelper().ComputeDyeingQuantity(thisDyeingChemical, thisJobOrder);
                 model.addRow(new Object[] { ChemicalName, thisDyeingChemical.getState(),thisDyeingChemical.getType(), thisDyeingChemical.getValue(),Quantity, thisDyeingChemical.getID()});}
             else
                 model.addRow(new Object[] { ChemicalName, thisDyeingChemical.getState(),thisDyeingChemical.getType(), thisDyeingChemical.getValue(), "Delete" , thisDyeingChemical.getID()});
             
             //ChemicalList
             //After Adding Chemical to table add it to list to check if same chemical will be added
             this.AddedChemicalList.add(ChemicalName);
         }
         //this.ChemicalTable.setModel(model);
     }
     
     public String getChemicalNameFromID(int ChemicalID)
     {
         Chemical thisChemical = new Chemical();
         ChemicalHandler ChemicalHandler = new ChemicalHandler();
         thisChemical.setChemicalId(ChemicalID);
         thisChemical.setChemicalName(ChemicalHandler.GetChemicalNameFromChemicalID(thisChemical.getChemicalId()));
         return thisChemical.getChemicalName();
     }
    
    TableModelListener newTableListener = new TableModelListener() {
        public void tableChanged(TableModelEvent e) 
        {
            // If editing row is last row in table add one more row to table
            if(ChemicalTable.getEditingRow() == (ChemicalTable.getRowCount()-1))
            {
                Object chemical = ChemicalTable.getModel().getValueAt(ChemicalTable.getEditingRow(), 0);
                Object gpl = ChemicalTable.getModel().getValueAt(ChemicalTable.getEditingRow(), 1);
                Object value = ChemicalTable.getModel().getValueAt(ChemicalTable.getEditingRow(), 2);
                Object quantity = ChemicalTable.getModel().getValueAt(ChemicalTable.getEditingRow(), 3);
                if(gpl != null && chemical != null && value != null && quantity != null)
                {
                    ((CurrentTableModel)ChemicalTable.getModel()).addRow(new Object[]{});
                }
            }
        }
    };
    
    public void addChemicalTextBoxAutoComplete()
    {
        //Chemical allChemicals = new Chemical();
        ChemicalHandler ChemHandler = new ChemicalHandler();
        AllChemical = ChemHandler.GetAllChemical();
        auto_complete dropdownAutoComplete = new auto_complete();
        dropdownAutoComplete.setupAutoComplete(this.ChemicalTextfield, AllChemical);
        this.ChemicalTextfield.setColumns(30);
        ChemicalTextfield.setFocusTraversalKeysEnabled(false);
    }
    
    public void HideText()
    {
        this.SubProcessLabel.setVisible(false);
        this.SubProcessText.setVisible(false);
        //this.ChemPanel1.setLocation(1, 1);
    }
    
    public void showText()
    {
        this.SubProcessLabel.setVisible(true);
        this.SubProcessText.setVisible(true);
    }
    
    public DyeingProcess GetSubProcessDetails(String Order, int DyeingProcessID)
    {
        DyeingProcess ThisDyeingProcess = new DyeingProcess();
        ThisDyeingProcess.setDyeingProcessName(this.SubProcessText.getText());
        ThisDyeingProcess.setDyeingProcessOrder(Order);
        ThisDyeingProcess.setChemicalNamesList(GetDyeingChemicalsFromTable(DyeingProcessID));
        
        return ThisDyeingProcess;
    }
    
    
     public ArrayList<DyeingChemical> GetDyeingChemicalsFromTable(int DyeingProcessID)
     {
         if(ChemicalTable.isEditing())
            ChemicalTable.getCellEditor().stopCellEditing();
        ArrayList<DyeingChemical> AllDyeingChemical = new ArrayList<DyeingChemical>();
        DyeingChemical ThisDyeingChemical;
        for (int i = 0; i < ChemicalTable.getRowCount(); i++) {
            
            ThisDyeingChemical = GetThisRowOfValues(i, DyeingProcessID);
            AllDyeingChemical.add(ThisDyeingChemical);
            }
        
        return AllDyeingChemical;
     }
    
     /**
      * Used to add Sub Process in case there are more process below the parent process
      * @param DyeingProgramID ID of the dyeing program that is used
      * @param Order Order String includes a number and a letter after
      */
     public void AddSubProcess(int DyeingProgramID, String Order)
     {
         //if(CheckIfTextIsReady())
         //{

         //SET All Dyeing Process Columns ID, NAME , ORDER
         DyeingProcess ThisDyeingProcess = new DyeingProcess(DyeingProgramID, this.SubProcessText.getText(), Order);
         //ThisDyeingProcess.setDyeingProgramId(DyeingProgramID);
         //ThisDyeingProcess.setDyeingProcessName(this.SubProcessText.getText());
         //ThisDyeingProcess.setDyeingProcessOrder(Order);
         DyeingProcessHandler ThisDyeingProcessHandler = new DyeingProcessHandler();

         //USE Handler To Add Dyeing Process
         int DyeingProcessID = ThisDyeingProcessHandler.AddDyeingProcess(ThisDyeingProcess);
         //ThisDyeingProcess.setId(ThisDyeingProcessHandler.GetDyeingProcessIdByDetails(ThisDyeingProcess));
         ThisDyeingProcess.setId(DyeingProcessID);
         //Add Chemicals After Adding Dyeing Process
         AddChemicals(ThisDyeingProcess.getId());
         //    }
     }
     
     
     /**
      * Add to Dyeing Chemicals Table using previously added Dyeing Process row
      * @param DyeingProcessID ID from Dyeing Process Table
      */
     public void AddChemicals(int DyeingProcessID)
     {
        //IF there is more than one sub-process
        DyeingChemical ThisDyeingChemical;
        DyeingChemicalHandler DyeingChemicalHandler = new DyeingChemicalHandler();
        if(ChemicalTable.isEditing())
            ChemicalTable.getCellEditor().stopCellEditing();
        
        for (int i = 0; i < ChemicalTable.getRowCount(); i++) {
            ThisDyeingChemical = GetThisRowOfValues(i, DyeingProcessID);
            DyeingChemicalHandler.AddNewDyeingChemical(ThisDyeingChemical);
            }
     }
     
     public boolean UpdateSubProcess(int DyeingProcessID, String Order)
     {
         boolean isSuccessful = false;
         
         //if(CheckIfTextIsReady())
         //   {
                //SET All Dyeing Process Columns ID, NAME , ORDER
         DyeingProcess ThisDyeingProcess = new DyeingProcess();
         ThisDyeingProcess.setId(DyeingProcessID);
         ThisDyeingProcess.setDyeingProcessName(this.SubProcessText.getText());
         ThisDyeingProcess.setDyeingProcessOrder(Order);
         DyeingProcessHandler ThisDyeingProcessHandler = new DyeingProcessHandler();       
                //USE Handler To Add Dyeing Process
         if(ThisDyeingProcessHandler.UpdateDyeingProcess(ThisDyeingProcess) != -1)
             //Add Chemicals After Adding Dyeing Process
         {
             UpdateChemicals(ThisDyeingProcess.getId());
             isSuccessful = true;
         } 
        //    }
            
            return isSuccessful;
     }
     
     public void UpdateChemicals(int DyeingProcessID)
     {
        //DyeingChemical ThisDyeingChemical = new DyeingChemical();
        //int TotalNumberOfChemicals = DyeingChemicalHandler.CountDyeingChemicalForThisDyeingProcess(DyeingProcessID);
        //DECLARATION
        ChemicalHandler ChemicalHandler = new ChemicalHandler();
        DyeingChemicalHandler DyeingChemicalHandler = new DyeingChemicalHandler();
        if(ChemicalTable.isEditing())
            ChemicalTable.getCellEditor().stopCellEditing();
        
        
        //Get All Dyeing Chemicals
        ArrayList<DyeingChemical> ChemicalList = 
                DyeingChemicalHandler.GetAllDyeingChemicalFromDyeingProcessID(DyeingProcessID);
        
         for (int OrderNum = 0; OrderNum < ChemicalTable.getRowCount(); OrderNum++) {
             DyeingChemical ThisDyeingChemical = GetThisRowOfValues(OrderNum, DyeingProcessID);
             //IF Chemical Size is still within the number of row that has already been added
             if (OrderNum < ChemicalList.size()) {
                 ThisDyeingChemical.setID(ChemicalList.get(OrderNum).getID());
                 DyeingChemicalHandler.UpdateDyeingChemical(ThisDyeingChemical);
             } else {
                 DyeingChemicalHandler.AddNewDyeingChemical(ThisDyeingChemical);
             }

         }

         for (int x = ChemicalTable.getRowCount(); x < ChemicalList.size(); x++) {
             //if(table.getModel().getColumnCount() > EditableCol+1 && 
             //            table.getModel().getValueAt(modelRow, EditableCol+1) != null)
             ChemicalIDtoBeDeleted.add((int) ChemicalList.get(x).getID());

         }
         this.DeleteAllChemicaltoBeDeletedFromDB();
         
         /*
        //Delete All the Remaining Dyeing Chemical not included in the Update
        for(int LastRow = ChemicalTable.getRowCount(); LastRow < ChemicalList.size(); LastRow++ )
        {
            DyeingChemical ThisDyeingChemical = new DyeingChemical();
            ThisDyeingChemical.setID(ChemicalList.get(LastRow).getID());
            DyeingChemicalHandler.DeleteDyeingChemical(ThisDyeingChemical);
        }
        */
     }
     
     private DyeingChemical GetTextFromTextBox()
     {
         DyeingChemical ThisDyeingChemical = new DyeingChemical();
         ThisDyeingChemical.setChemicalName(ChemicalTextfield.getText().trim().toUpperCase());
         ThisDyeingChemical.setState(this.StateBox.getSelectedItem().toString());
         ThisDyeingChemical.setType(this.TypeBox.getSelectedItem().toString());
         ThisDyeingChemical.setValue(Float.valueOf((ValueText.getText())));
         
         
         return ThisDyeingChemical;
     }
     
     private DyeingChemical GetThisRowOfValues(int rowNumber)
     {
         DyeingChemical ThisDyeingChemical = new DyeingChemical();
         ChemicalHandler ChemicalHandler = new ChemicalHandler();
         
         String Chemical = ChemicalTable.getModel().getValueAt(rowNumber, ChemicalColumn).toString();
         String Type = ChemicalTable.getModel().getValueAt(rowNumber, TypeColumn).toString();
         String Value = ChemicalTable.getModel().getValueAt(rowNumber, ValueColumn).toString();
         String State = ChemicalTable.getModel().getValueAt(rowNumber, StateColumn).toString();
         
         //ThisDyeingChemical.setChemicalId(ThisChemical.getChemicalId());
         //ThisDyeingChemical.setDyeingProcessID(DyeingProcessID);
         ThisDyeingChemical.setType(Type);
         ThisDyeingChemical.setValue(Float.valueOf(Value));//parseFloat(Value));
         ThisDyeingChemical.setOrder(rowNumber + 1);
         ThisDyeingChemical.setState(State);
         return ThisDyeingChemical;
     }
     private DyeingChemical GetThisRowOfValues(int rowNumber, int DyeingProcessID)
     {
         Chemical ThisChemical  = new Chemical();
         DyeingChemical ThisDyeingChemical = new DyeingChemical();
         ChemicalHandler ChemicalHandler = new ChemicalHandler();
         
         String Chemical = ChemicalTable.getModel().getValueAt(rowNumber, ChemicalColumn).toString();
         String Type = ChemicalTable.getModel().getValueAt(rowNumber, TypeColumn).toString();
         String Value = ChemicalTable.getModel().getValueAt(rowNumber, ValueColumn).toString();
         String State = ChemicalTable.getModel().getValueAt(rowNumber, StateColumn).toString();
         if (Chemical.length() > 0)//&& !CheckTextIfItsANumber(Value))
         {
             ThisChemical.setChemicalName(Chemical);
             ThisChemical.setChemicalId(ChemicalHandler.GetChemicalIDFromChemicalName(ThisChemical.getChemicalName()));
             ThisDyeingChemical.setChemicalId(ThisChemical.getChemicalId());
             ThisDyeingChemical.setDyeingProcessID(DyeingProcessID);
             ThisDyeingChemical.setType(Type);
             ThisDyeingChemical.setValue(Float.valueOf(Value));//parseFloat(Value));
             ThisDyeingChemical.setOrder(rowNumber + 1);
             ThisDyeingChemical.setState(State);
             //TO Be FIXED: How to know if this will be Solid or Liquid. G or L               
             //ThisDyeingChemical.setState(State);
         } else {
             return null;
         }

         return ThisDyeingChemical;
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubProcessLabel = new javax.swing.JLabel();
        SubProcessText = new javax.swing.JTextField();
        ChemPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChemicalTable = new JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        ChemicalTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ValueText = new javax.swing.JTextField();
        AddtoTable = new javax.swing.JButton();
        TypeBox = new javax.swing.JComboBox();
        StateBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(739, 400));

        SubProcessLabel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        SubProcessLabel.setText("Sub Process Name :");

        ChemPanel1.setBackground(new java.awt.Color(255, 255, 255));
        ChemPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chemicals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 16))); // NOI18N
        ChemPanel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        ChemicalTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ChemicalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chemical", "Type", "Value", "State", "Delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ChemicalTable.setRowHeight(25);
        ChemicalTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ChemicalTable);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setText("Chemical :");

        ChemicalTextfield.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Value :");

        ValueText.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ValueText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ValueTextKeyReleased(evt);
            }
        });

        AddtoTable.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        AddtoTable.setText("Add");
        AddtoTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddtoTableActionPerformed(evt);
            }
        });

        TypeBox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        TypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GPL", "%" }));
        TypeBox.setBorder(null);

        StateBox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        StateBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "G", "L" }));
        StateBox.setBorder(null);

        javax.swing.GroupLayout ChemPanel1Layout = new javax.swing.GroupLayout(ChemPanel1);
        ChemPanel1.setLayout(ChemPanel1Layout);
        ChemPanel1Layout.setHorizontalGroup(
            ChemPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChemPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChemPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ChemPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChemicalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(StateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValueText, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddtoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChemPanel1Layout.setVerticalGroup(
            ChemPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChemPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(ChemPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChemicalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ValueText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddtoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChemPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubProcessLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubProcessText, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubProcessText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubProcessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(ChemPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean CheckIfTextIsReady()
    {
        boolean validText = true;
        if(SubProcessText.isVisible())
            if(isNullOrWhitespaceOrEmpty(SubProcessText.getText()))
            {
                validText = false;
                SubProcessText.setBackground(ColorError);
                 JOptionPane.showMessageDialog(null, "Please check the sub process text");
            }
        
        if(ChemicalTable.getRowCount() == 0)
        {
            validText = false;
             JOptionPane.showMessageDialog(null, "Please add a Chemical to for this sub process.");
        }
        
        return validText;
    }
    private void AddtoTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddtoTableActionPerformed
        // TODO add your handling code here:
        if(!isNullOrWhitespaceOrEmpty(ChemicalTextfield.getText()) 
                && !isNullOrWhitespaceOrEmpty(ValueText.getText())
                && !CheckTextIfItsANumber(ValueText.getText()))
        {
            String CurrentChemicalText = ChemicalTextfield.getText().trim().toUpperCase();
            if(!this.AddedChemicalList.contains(CurrentChemicalText))
            {
                if(AllChemical.indexOf(CurrentChemicalText) == -1)
                {
                    if(JOptionPane.YES_OPTION == 
                        JOptionPane.showConfirmDialog(null, "This chemical name has not yet been added. Do you want to add it?","Add this chemical?", JOptionPane.YES_NO_OPTION))
                    {
                        //Add the Chemicalname to the database
                        Chemical thisChemical = new Chemical();
                        thisChemical.setChemicalName(CurrentChemicalText);
                        ChemicalHandler ChemHandler = new ChemicalHandler();
                        ChemHandler.AddNewChemical(thisChemical);
                        //End of adding Chemical to the database
                        
                        AddTextToTable();
                        
                        }
                    else
                        JOptionPane.showMessageDialog(null, "Please add or change the Chemical Name to add this row.");
                }
                else
                    AddTextToTable();
            }
            else
                JOptionPane.showMessageDialog(null, "This chemical has already been added to this Process.");
            
        }
        else
            JOptionPane.showMessageDialog(null, "Please check your Chemical Name input and GPL value.");
    }//GEN-LAST:event_AddtoTableActionPerformed

    //Can be updated to add data to a list.
    private void AddTextToTable()
    {
        //String ChemicalName = ChemicalTextfield.getText().trim().toUpperCase();
        CurrentTableModel model = (CurrentTableModel) ChemicalTable.getModel();
        DyeingChemical thisDyeingChemical = GetTextFromTextBox();
        
        if(WindowType == 3 || WindowType == 4 || WindowType == 5 ||  WindowType == 6 )
        {
            Float Quantity = new ComputeHelper().ComputeDyeingQuantity(thisDyeingChemical, thisJobOrder);
            //float Quantity = this.ComputeQuantityFromWeightOrVol(thisDyeingChemical);
            model.addRow(new Object[] {thisDyeingChemical.getChemicalName(), thisDyeingChemical.getState(),thisDyeingChemical.getType(), thisDyeingChemical.getValue(),Quantity, "Delete"});
        }
        else
            //model.addRow(new Object[] {ChemicalName, this.StateBox.getSelectedItem(),this.TypeBox.getSelectedItem().toString(), ValueText.getText(), "Delete"});
            model.addRow(new Object[] {thisDyeingChemical.getChemicalName(), thisDyeingChemical.getState(),thisDyeingChemical.getType(), thisDyeingChemical.getValue(), "Delete"});
        
        //ChemicalList
        //After Adding Chemical to table add it to list to check if same chemical will be added
        this.AddedChemicalList.add(thisDyeingChemical.getChemicalName());
        this.ChemicalTextfield.setText(null);
        ValueText.setText(null);
    }
    private void ValueTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValueTextKeyReleased
        // TODO add your handling code here:
        
        if(!this.ValueTextCheckerTriggered)    
        {
            if(CheckTextIfItsANumber(this.ValueText.getText())){
                AddtoTable.setEnabled(false);
                this.ValueText.setBackground(ColorError);
                ValueTextCheckerTriggered = true;
            }
        }   
        else
        {
             if(!CheckTextIfItsANumber(this.ValueText.getText())){
                 AddtoTable.setEnabled(true);
                this.ValueText.setBackground(Color.white);
                ValueTextCheckerTriggered = false;
             }   
        }
    }//GEN-LAST:event_ValueTextKeyReleased

    /**
      * Checks if text is a validText int or float variable
      * @param this_text String to be checked
      * @return true if String is either empty or text is not a validText int or float variable
      */
      public boolean CheckTextIfItsANumber(String this_text)
    {
        if(this_text.isEmpty())
            return true;
        String regex = "[^0-9]";
        Pattern p = Pattern.compile(regex);
        this_text = this_text.replaceFirst("[.]", "");
        
        return p.matcher(this_text).find();
    }
    
    public static boolean isNullOrWhitespaceOrEmpty(String s) {
        return s == null || isWhitespace(s) || s.length() == 0;
    }
    
    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (!Character.isWhitespace(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddtoTable;
    private javax.swing.JPanel ChemPanel1;
    private javax.swing.JTable ChemicalTable;
    private javax.swing.JTextField ChemicalTextfield;
    private javax.swing.JComboBox StateBox;
    private javax.swing.JLabel SubProcessLabel;
    private javax.swing.JTextField SubProcessText;
    private javax.swing.JComboBox TypeBox;
    private javax.swing.JTextField ValueText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    

//UNUSED
    
    public void InitializeChemicalTable()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> AllChemical = new Handlers.ChemicalHandler().GetAllChemical();
        for(String thisChemical : AllChemical)
        {
            model.addElement(thisChemical);
        }
        InitializeColumns(model, 0);
        //col.setCellRenderer(renderer);
    }
    
     private void InitializeGPLandPercentColumn()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("GPL");
        model.addElement("%");
        ComboBoxTableCellRenderer renderer = new ComboBoxTableCellRenderer();
        renderer.setModel(model);
        InitializeColumns(model, 1);
        //col.setCellRenderer(renderer);
    }
     
     private void InitializeColumns(DefaultComboBoxModel model , int column)
     {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(model);
        ComboBoxTableCellRenderer renderer = new ComboBoxTableCellRenderer();
        renderer.setModel(model);
        TableColumn col = ChemicalTable.getColumnModel().getColumn(column);
        col.setCellEditor(new DefaultCellEditor(comboBox));
     }

    /**
     * @param WindowType the WindowType to set
     */
    public void setWindowType(int WindowType) {
        this.WindowType = WindowType;
    }

}
