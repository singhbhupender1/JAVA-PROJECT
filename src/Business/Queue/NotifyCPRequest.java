/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Queue;

import Business.Employee.Employee;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Zeppelin
 */
public class NotifyCPRequest extends WorkRequest{
    
    private String status4;
    private UserAccount doctor;
    private String notifyDrugResult;

    public NotifyCPRequest(){
      //  status4 = new String();
    }
    public String getNotifyDrugResult() {
        return notifyDrugResult;
    }

    public void setNotifyDrugResult(String  notifyDrugResult) {
        this.notifyDrugResult =  notifyDrugResult;
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public String getStatus4() {
        return status4;
    }

    public void setStatus4(String status4) {
        this.status4 = status4;
    }
    
    @Override 
    public String toString(){
    return status4;
    }
}
