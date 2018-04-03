/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.PatientWorkArea.PatientWorkAreaJPanel;

/**
 *
 * @author ptari
 */
public class PatientRole extends Role{

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network) {
        return new PatientWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
    }
    
    @Override
    public String toString(){
        return RoleType.Patient.getValue();
    }
    
}
