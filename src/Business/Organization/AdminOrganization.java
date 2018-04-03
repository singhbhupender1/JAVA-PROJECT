/*
 * To change this template, choose Tools | Templates
 * and open the temp

late in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Zeppelin
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(OrganizationType.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
     
}
