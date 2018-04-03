/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Zeppelin
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Pharmacy){
            enterprise = new PharmacyEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.PathologyLab){
            enterprise = new PathologyLabEnterprise(name);
            enterpriseList.add(enterprise);
        } 
        return enterprise;
    }
    
    public void removeEnterprise(Enterprise ent){
        enterpriseList.remove(ent);
        
    }
}
