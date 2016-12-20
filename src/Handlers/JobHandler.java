/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import DataEntities.JobOrder;
import DataEntities.JobOrderExtended;
import Database.ColorTextControlSlipRepository;
import java.util.ArrayList;

/**
 *
 * @author Eldridge
 */
public class JobHandler {
    public int AddNewJobOrder(JobOrder newJobOrder)
    {
        //boolean isSuccessful = false;
        
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        return repo.AddJobOrder(newJobOrder);
        
    }
    
    public boolean UpdateJobOrder(JobOrder thisJobOrder)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        return repo.UpdateJobOrderByJobOrderID(thisJobOrder);
        
    }
    
     public void DeleteJobOrder(int JobOrderId)
    {
        boolean isSuccessful = false;
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        
        isSuccessful = repo.DeleteJobOrderByJobOrderID(JobOrderId);
    }
     
     public JobOrder GetJobOrderDetailsFromJobId(int JobOrderID)
     {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetJobOrderDetailsFromJobOrderID(JobOrderID);
     }

    public boolean CheckIfThisJobOrderHasBeenAdded(JobOrder thisJob) {
        boolean itExist = false;
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        if(repo.CheckIfJobOrderExists(thisJob) == 1)
            itExist = true;
        return !itExist;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<JobOrder> GetAllJobOrderHistoryByCustomerId (int customerID)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetAllJobOrderHistoryByCustomerId(customerID);
    }
    
    public ArrayList<JobOrder> GetAllJobOrderHistoryByJobOrderNumber (int customerID)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetAllJobOrderHistoryByJobOrderNumber(customerID);
    }
    
    public ArrayList<JobOrderExtended> GetAllExtendedJobOrderDetails()
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetConnectedJobOrderDetails();
    }
    
    public ArrayList<JobOrderExtended> GetAllExtendedJobOrderDetails(int customerId)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        return repo.GetConnectedJobOrderDetails(customerId);
    }
    
    public boolean CheckIfResinNewToCustomer(int customerId, int resinProgramNameId)
    {
        ColorTextControlSlipRepository repo = new ColorTextControlSlipRepository();
        ArrayList<JobOrder> jobOrderList = new ArrayList<JobOrder>();
        boolean isExisting = false;
        
        jobOrderList = repo.GetAllJobOrderHistoryByCustomerId(customerId);
        
        for(int x=0; x<jobOrderList.size(); x++)
        {
            int oldResinProgramNameId = repo.GetResinProgramNameIDByResinProgramID(jobOrderList.get(x).getResinProgramID());
            if(resinProgramNameId == oldResinProgramNameId)
            {
                isExisting = true;
                break;
            }
        }
        return isExisting;
    }

}
