/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

//import Business.Doctor.Doctor;

/**
 *
 * @author Zeppelin
 */
public class Employee {
    
    private String name;
    private int id;
    private String speciality;
    private static int count=1;

    public Employee() {
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }   
    
    @Override
    public String toString() {
        return name;
    }   
}
