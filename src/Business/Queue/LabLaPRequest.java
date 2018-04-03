/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Queue;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Zeppelin
 */

public class LabLaPRequest extends WorkRequest{
    
    private String status5;
    private Date testFromDate;
    private Date testToDate;
    private UserAccount doctor;
    private String labTestRequestResult;

    public LabLaPRequest(){
        
        testFromDate = new Date();
    }
    
     public String getLabTestRequestResult() {
        return labTestRequestResult;
    }

    public void setLabTestRequestResult(String labTestRequestResult) {
        this.labTestRequestResult = labTestRequestResult;
    }
   

    public Date getTestFromDate() {
        return testFromDate;
    }

    public void setTestFromDate(Date testFromDate) {
        this.testFromDate = testFromDate;
    }

    public Date getTestToDate() {
        return testToDate;
    }

    public void setTestToDate(Date testToDate) {
        this.testToDate = testToDate;
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public String getStatus5() {
        return status5;
    }

    public void setStatus5(String status5) {
        this.status5 = status5;
    }
    
    

    @Override
    public String toString() {
        return status5;
    } 
}
