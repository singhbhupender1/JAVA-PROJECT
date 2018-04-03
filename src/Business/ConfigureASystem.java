package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Zeppelin
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee("SystemAdministrative");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount
        ("sa", "sa", employee, new SystemAdminRole());
        
        return system;
    }
    
}
