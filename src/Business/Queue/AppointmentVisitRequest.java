/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Queue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Zeppelin
 */
public class AppointmentVisitRequest extends WorkRequest{

    //Patient To Doctor
    private String pFullName;
    private String pEmail;
    private String pNumber;
    private String pGender;
    private int pAge;
    private Date pDOB;
    private String status1;
    private String dayTime;
    private String symptom;
    private Date appointmentDate;
    private UserAccount pPreferredChemist;
    private UserAccount pPreferredLabAssistant;
    private String appointmentResult;
 
    //for the doctor to chemist-
    private String status2;
    private String medicineOne;
    private String medicineTwo;
    private String medicineThree;
    private int dosageOne;
    private int dosageTwo;
    private int dosageThree;
    private String prescriptionResult;
    
    //for the doctor to lab assistant-
    private String status3;
    private String testOne;
    private String testTwo;
    private String testThree;
    private String pathologyTestResult;
    
    
    
    public AppointmentVisitRequest(){
        appointmentDate = new Date();
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public String getTestOne() {
        return testOne;
    }

    public void setTestOne(String testOne) {
        this.testOne = testOne;
    }

    public String getTestTwo() {
        return testTwo;
    }

    public void setTestTwo(String testTwo) {
        this.testTwo = testTwo;
    }

    public String getTestThree() {
        return testThree;
    }

    public void setTestThree(String testThree) {
        this.testThree = testThree;
    }

    public String getPathologyTestResult() {
        return pathologyTestResult;
    }

    public void setPathologyTestResult(String pathologyTestResult) {
        this.pathologyTestResult = pathologyTestResult;
    }
    
    
    public String getMedicineOne() {
        return medicineOne;
    }

    public void setMedicineOne(String medicineOne) {
        this.medicineOne = medicineOne;
    }

    public String getMedicineTwo() {
        return medicineTwo;
    }

    public void setMedicineTwo(String medicineTwo) {
        this.medicineTwo = medicineTwo;
    }

    public String getMedicineThree() {
        return medicineThree;
    }

    public void setMedicineThree(String medicineThree) {
        this.medicineThree = medicineThree;
    }

    public int getDosageOne() {
        return dosageOne;
    }

    public void setDosageOne(int dosageOne) {
        this.dosageOne = dosageOne;
    }

    public int getDosageTwo() {
        return dosageTwo;
    }

    public void setDosageTwo(int dosageTwo) {
        this.dosageTwo = dosageTwo;
    }

    public int getDosageThree() {
        return dosageThree;
    }

    public void setDosageThree(int dosageThree) {
        this.dosageThree = dosageThree;
    }

    public String getPrescriptionResult() {
        return prescriptionResult;
    }

    public void setPrescriptionResult(String prescriptionResult) {
        this.prescriptionResult = prescriptionResult;
    }
 

     public String getAppointmentResult() {
        return appointmentResult;
    }

    public void setAppointmentResult(String appointmentResult) {
        this.appointmentResult = appointmentResult;
    } 

    public String getpFullName() {
        return pFullName;
    }

    public void setpFullName(String pFullName) {
        this.pFullName = pFullName;
    }
    
   
    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpGender(String pGender) {
        this.pGender = pGender;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public UserAccount getpPreferredChemist() {
        return pPreferredChemist;
    }

    public void setpPreferredChemist(UserAccount pPreferredChemist) {
        this.pPreferredChemist = pPreferredChemist;
    }

    public UserAccount getpPreferredLabAssistant() {
        return pPreferredLabAssistant;
    }

    public void setpPreferredLabAssistant(UserAccount pPreferredLabAssistant) {
        this.pPreferredLabAssistant = pPreferredLabAssistant;
    }

    public Date getpDOB() {
        return pDOB;
    }

    public void setpDOB(Date pDOB) {
        this.pDOB = pDOB;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }


    @Override
    public String toString() {
        return symptom ;
    }
   
}
