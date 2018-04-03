/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.EmployeeDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author Zeppelin
 */
public abstract class Enterprise extends Organization{

    private String enterpriseName;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int enterpriseID;
    private static int counter=0;
   
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.enterpriseName = name;
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        enterpriseID = counter;
        counter++;
    }
    
    public enum EnterpriseType{
        Hospital("Hospital Enterprise"), Pharmacy("Pharmacy Enterprise"), PathologyLab("Pathology Lab Enterprise");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    @Override
    public String toString(){
        return enterpriseName;
    }

}
