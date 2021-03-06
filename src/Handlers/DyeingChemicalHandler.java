/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import DataEntities.DyeingChemical;
import Database.ColorTextControlSlipRepository;
import java.util.ArrayList;
/**
 *
 * @author Eldridge
 */
public class DyeingChemicalHandler {
    
     public boolean AddNewDyeingChemical(DyeingChemical newDyeingChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        if(repo.CheckIfDyeingChemicalExistsOnThisProcess(newDyeingChemical) == 0)
            isSuccessful = repo.AddDyeingChemical(newDyeingChemical);
        
        return isSuccessful;
    }
    
    public boolean UpdateDyeingChemical(DyeingChemical newDyeingChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        //if(repo.CheckIfSameDyeingChemicalExistsOnThisProcess(newDyeingChemical) == 0)
        isSuccessful = repo.UpdateDyeingChemicalByDyeingChemicalID(newDyeingChemical);
        
        return isSuccessful;        
    }
    
     public boolean UpdateDyeingChemicalWithOrder(DyeingChemical newDyeingChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        if(repo.CheckIfSameDyeingChemicalExistsOnThisProcess(newDyeingChemical) == 0)
            isSuccessful = repo.UpdateDyeingChemicalByDyeingChemicalID(newDyeingChemical);
        
        return isSuccessful;        
    }
    
    public void DeleteDyeingChemical(DyeingChemical thisDyeingChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.DeleteDyeingChemicalByDyeingChemicalID(thisDyeingChemical);
        
    }
    
    public void DeleteDyeingChemicalByDyeingProcessID(DyeingChemical thisDyeingChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.DeleteDyeingChemicalByDyeingProcessID(thisDyeingChemical);
        
    }
    
    public ArrayList<DyeingChemical> GetAllDyeingChemicalFromDyeingProcessID(int DyeingProcessID)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetAllDyeingChemicalsFromDyeingProcessID(DyeingProcessID);
    }
    
    public int CountDyeingChemicalForThisDyeingProcess(int DyeingProcessID)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.CountNumberOfDyeingChemicalForThisProcess(DyeingProcessID);
    }
}
