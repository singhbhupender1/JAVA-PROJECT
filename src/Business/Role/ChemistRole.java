/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ChemistRole.ChemistWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author ptari
 */
public class ChemistRole extends Role {

    @Override 
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new ChemistWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
    @Override
    public String toString(){
        return RoleType.Chemist.getValue();
    }

    
    
}
