/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ChemistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Zeppelin
 */
public class ChemistOrganization extends Organization{

    public ChemistOrganization() {
        super(Organization.OrganizationType.Chemist.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ChemistRole());
        return roles;
    }
     
    
}
