/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities;

import Database.ColorTextControlSlipRepository;
import java.util.ArrayList;
/**
 *
 * @author imbuenyson
 */
public class DyeingProcess {

    private int DyeingID;
    private int dyeingProgramId;
    private String dyeingProcessName;
    private String dyeingProcessOrder;
    private ArrayList<DyeingChemical> ChemicalNamesList = new ArrayList<DyeingChemical>();
    private ArrayList<DyeingProcess> DyeingProcess = new ArrayList<DyeingProcess>();
    
    public DyeingProcess(){}
    
    public DyeingProcess(int DyeingProgID, String processName, String Order )
    {
        this.dyeingProgramId = DyeingProgID;
        this.dyeingProcessName = processName.toUpperCase();
        this.dyeingProcessOrder = Order.toUpperCase();
    }
    
    public int getId() {
        return DyeingID;
    }

    public void setId(int dyeingID) {
        this.DyeingID = dyeingID;
    }
    
    public int getDyeingProgramId() {
        return dyeingProgramId;
    }

    public void setDyeingProgramId(int dyeingProgramId) {
        this.dyeingProgramId = dyeingProgramId;
    }
    
    public String getDyeingProcessName() {
        return dyeingProcessName;
    }

    public void setDyeingProcessName(String dyeingProcessName) {
        this.dyeingProcessName = dyeingProcessName.toUpperCase();
    }
    
    public String getdyeingProcessOrder() {
        return dyeingProcessOrder;
    }

    public void setDyeingProcessOrder(String dyeingProcessOrder) {
        this.dyeingProcessOrder = dyeingProcessOrder.toUpperCase();
    }
    
    /**
     * @return the ChemicalNamesList
     */
    public ArrayList<DyeingChemical> getChemicalNamesList() {
        return ChemicalNamesList;
    }

    /**
     * @param ChemicalNamesList the ChemicalNamesList to set
     */
    public void setChemicalNamesList(ArrayList<DyeingChemical> ChemicalNamesList) {
        this.ChemicalNamesList = ChemicalNamesList;
    }
    
    /**
     * @return the DyeingProcess
     */
    public ArrayList<DyeingProcess> getDyeingProcess() {
        return DyeingProcess;
    }

    /**
     * @param DyeingProcess the DyeingProcess to set
     */
    public void setDyeingProcess(ArrayList<DyeingProcess> DyeingProcess) {
        this.DyeingProcess = DyeingProcess;
    }

}
