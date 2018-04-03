/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.Queue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Zeppelin
 */

public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private OrganizationType organizationType;
  
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    private int organizationID;
    private static int counter=0;
    
    public enum OrganizationType{
        Admin("Admin Organization"), Doctor("Doctor Organization"), Patient("Patient Organization"),
        Chemist("Chemist Organization"), LabAssistant("Lab Assistant Organization");
        
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        counter++;
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    

    @Override
    public String toString() {
        return name;
    }
    
    
}
