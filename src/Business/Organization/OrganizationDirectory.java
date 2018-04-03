/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author Zeppelin
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(OrganizationType type){
        Organization organization = null;
        
        if (type.getValue().equals(OrganizationType.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.Chemist.getValue())){
            organization=new ChemistOrganization();
            organizationList.add(organization);   
        }
        else if (type.getValue().equals(OrganizationType.LabAssistant.getValue())){
            organization=new LabAssistantOrganization();
            organizationList.add(organization);   
        }
        return organization;
    }
    
    public void removeOrganization(Organization organization){
        organizationList.remove(organization);
    }
}