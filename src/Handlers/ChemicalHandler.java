/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import DataEntities.Chemical;
import Database.ColorTextControlSlipRepository;

/**
 *
 * @author Eldridge
 */
public class ChemicalHandler {
     public void AddNewCustomer(Chemical newChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.AddChemical(newChemical);
        
        if(isSuccessful == false)
        {
            //enter validation 
        }
    }
    
    public void UpdateCustomer(Chemical thisChemical)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.UpdateChemicalByChemicalID(thisChemical);
        
        if(isSuccessful == false)
        {
            //enter validation 
        }
    }
    
     public void DeleteCustomer(int ChemicalID)
    {
        boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.DeleteCustomerByCustomerId(ChemicalID);
        
        if(isSuccessful == false)
        {
            //enter validation 
        }
    }
}
