/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PathologyLabEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Network.Network;
import Business.Organization.ChemistOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.LabAssistantOrganization;
import Business.Queue.AppointmentVisitRequest;
import Business.Queue.WorkRequest;
import Business.UserAccount.UserAccount;
import Business.Validations.AgeVerifier;
import Business.Validations.DateVerifier;
import Business.Validations.EmailVerifier;
import Business.Validations.NumericVerifier;
import Business.Validations.StringThenSpaceVerifier;
import Business.Validations.StringVerifier;

import java.awt.CardLayout;
import java.awt.Component;

import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Zeppelin
 */
public class RequestAppointmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private UserAccount doctor;
    private UserAccount chemist;
    private UserAccount labAssistant;
    private EcoSystem system;
    private WorkRequest workRequest;
    
    
    
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestAppointmentJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = system;
        valueLabel.setText(enterprise.getName());
        populateDoctorJComboBox();
        populatelabAssistantJComboBox();
        populatechemistJComboBox();
        Date date = new Date();
        dobJDateChooser.setDate(date);
        
        addStringVerifiers();
        addEmailVerifier();
        addDateVerifiers();
        addIntegerVerifiers();
        addStringThenSpaceVerifiers();
        checkBlankInput();
        addAgeVerifier();
       
    }
    
   
    
    private void addAgeVerifier(){
        InputVerifier ageVerifier = new AgeVerifier();
        ageJTextField.setInputVerifier(ageVerifier);
    }
    
    private Boolean checkBlankInput()
    {
        if(fullJTextField.getText().length()==0
            ||numberJTextField.getText().length()==0
            ||ageJTextField.getText().length()==0
            ||genderJTextField.getText().length()==0
            ||idJTextField.getText().length()==0
            ||symptomJTextField.getText().length()==0)
            {
                return false;
            }
        else
        {
            return true;
        }
    }  
    
    private void addStringThenSpaceVerifiers(){
        InputVerifier stringThenSpaceVerifier = new StringThenSpaceVerifier();
        fullJTextField.setInputVerifier(stringThenSpaceVerifier);
        symptomJTextField.setInputVerifier(stringThenSpaceVerifier);
    }
    
    private void addEmailVerifier(){
          InputVerifier emailVerifier = new EmailVerifier();
       //   idJTextField.setInputVerifier(emailVerifier);
          
     }
    
    private void addStringVerifiers() {
        InputVerifier stringVerifier = new StringVerifier();
        genderJTextField.setInputVerifier(stringVerifier);
       
     }
     
     private void addIntegerVerifiers(){
          InputVerifier integerVerifier = new NumericVerifier();
          dobJDateChooser.setInputVerifier(integerVerifier);
          apptJDateChooser.setInputVerifier(integerVerifier);
     }
     
     private void addDateVerifiers(){
         
         InputVerifier dateVerifier = new DateVerifier();
         dobJDateChooser.setInputVerifier(dateVerifier);
         apptJDateChooser.setInputVerifier(dateVerifier);
         
     }
     
    
     public void populateDoctorJComboBox(){
        doctorJComboBox.removeAll();
      
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
           for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
            
                if (organization instanceof DoctorOrganization){
             
                 doctorJComboBox.addItem(ua);    
            }
           } 
         
     }
     }
     
         public void populatechemistJComboBox() {
        chemistJComboBox.removeAll();
        for (Network net : system.getNetworkList()) {
            for (Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter instanceof PharmacyEnterprise) {
                    for (Organization org : enter.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof ChemistOrganization) {
                            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {

                                chemistJComboBox.addItem(ua);
                            }
                        }
                    }
                }
            }
        }
    }
     
    public void populatelabAssistantJComboBox() {
        labAssistantJComboBox.removeAll();
        for (Network net : system.getNetworkList()) {
            for (Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter instanceof PathologyLabEnterprise) {
                    for (Organization org : enter.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof LabAssistantOrganization) {
                            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {

                                labAssistantJComboBox.addItem(ua);
                            }
                        }
                    }
                }
            }
        }
    }
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        requestApptJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        symptomJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doctorJComboBox = new javax.swing.JComboBox();
        timeJComboBox = new javax.swing.JComboBox();
        dobJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fullJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        genderJTextField = new javax.swing.JTextField();
        maleJRadioButton = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        numberJTextField = new javax.swing.JTextField();
        idJTextField = new javax.swing.JTextField();
        apptJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        chemistJComboBox = new javax.swing.JComboBox();
        labAssistantJComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();

        requestApptJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        requestApptJButton.setText("Request Appointment");
        requestApptJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestApptJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Illness Symptom Heading");

        symptomJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        valueLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        valueLabel.setText("<value>");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date for the appointment");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Time Preference");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Select Doctor");

        doctorJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        timeJComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        timeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Available", "10am-12pm", "12pm-2pm", "2pm-4pm", "4pm-6pm" }));
        timeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeJComboBoxActionPerformed(evt);
            }
        });

        dobJDateChooser.setDateFormatString("MM/dd/yyyy");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("APPOINTMENT FILLING PAGE");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Full name");

        fullJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Gender");

        genderJTextField.setEditable(false);
        genderJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        genderJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderJTextFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleJRadioButton);
        maleJRadioButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        maleJRadioButton.setSelected(true);
        maleJRadioButton.setText("Male");
        maleJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleJRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Number");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Email Id");

        numberJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        idJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        apptJDateChooser.setDateFormatString("MM/dd/yyyy");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Date of birth");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("@gmail.com");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Preferred Chemist Pharmacy");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Preferred Pathology Lab Assistant");

        chemistJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        labAssistantJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Age");

        ageJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79)
                        .addComponent(symptomJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(155, 155, 155)
                        .addComponent(doctorJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(apptJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(137, 137, 137)
                        .addComponent(timeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(187, 187, 187)
                        .addComponent(fullJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(225, 225, 225)
                        .addComponent(ageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maleJRadioButton)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addGap(192, 192, 192)
                        .addComponent(idJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11)
                        .addGap(157, 157, 157)
                        .addComponent(dobJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel13)
                        .addGap(53, 53, 53)
                        .addComponent(chemistJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel14)
                        .addGap(14, 14, 14)
                        .addComponent(labAssistantJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(backJButton)
                        .addGap(105, 105, 105)
                        .addComponent(requestApptJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(symptomJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(doctorJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(apptJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(timeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fullJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(ageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genderJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(numberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(maleJRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10))
                    .addComponent(idJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addComponent(dobJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(chemistJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(labAssistantJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(requestApptJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestApptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestApptJButtonActionPerformed

        if (checkBlankInput())
     {
        AppointmentVisitRequest req = new AppointmentVisitRequest();
        
       req.setSymptom(symptomJTextField.getText());
       req.setpFullName(fullJTextField.getText());
       req.setpDOB(dobJDateChooser.getDate());
       req.setAppointmentDate(apptJDateChooser.getDate());
       req.setpGender(genderJTextField.getText());
       req.setpNumber(numberJTextField.getText());
       req.setpEmail(idJTextField.getText());
       req.setpAge(Integer.parseInt(ageJTextField.getText()));
       
       doctor = (UserAccount)doctorJComboBox.getSelectedItem();
       req.setReceiver(doctor);
       
       String time = (String)timeJComboBox.getSelectedItem();
       req.setDayTime(time);
       
        chemist = (UserAccount)chemistJComboBox.getSelectedItem();
        req.setpPreferredChemist(chemist);
       
        labAssistant = (UserAccount)labAssistantJComboBox.getSelectedItem();
        req.setpPreferredLabAssistant(labAssistant);
      
        req.setMedicineOne(null);
        req.setMedicineTwo(null);
        req.setMedicineThree(null);
        req.setDosageOne(0);
        req.setDosageTwo(0);
        req.setDosageThree(0);
        req.setPrescriptionResult(null);
        req.setTestOne(null);
        req.setTestTwo(null);
        req.setTestThree(null);
        req.setPathologyTestResult(null);
        req.setSender(userAccount);
        req.setStatus1("Sent");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DoctorOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(req);
            userAccount.getWorkQueue().getWorkRequestList().add(req);
        }
        
        JOptionPane.showMessageDialog(null, "Appointment request is made. Check your account regularly for confirmation.", "Information", JOptionPane.INFORMATION_MESSAGE);
     }
        else{
        
        JOptionPane.showMessageDialog(null, "Please Enter all values.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_requestApptJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PatientToDoctorRequestJPanel pbaajp = (PatientToDoctorRequestJPanel) component;
        pbaajp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void timeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeJComboBoxActionPerformed

    private void maleJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleJRadioButtonActionPerformed
        // TODO add your handling code here:
         genderJTextField.setText("Male");
    }//GEN-LAST:event_maleJRadioButtonActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        genderJTextField.setText("Female");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void genderJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderJTextFieldActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_genderJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageJTextField;
    private com.toedter.calendar.JDateChooser apptJDateChooser;
    private javax.swing.JButton backJButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox chemistJComboBox;
    private com.toedter.calendar.JDateChooser dobJDateChooser;
    private javax.swing.JComboBox doctorJComboBox;
    private javax.swing.JTextField fullJTextField;
    private javax.swing.JTextField genderJTextField;
    private javax.swing.JTextField idJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JComboBox labAssistantJComboBox;
    private javax.swing.JRadioButton maleJRadioButton;
    private javax.swing.JTextField numberJTextField;
    private javax.swing.JButton requestApptJButton;
    private javax.swing.JTextField symptomJTextField;
    private javax.swing.JComboBox timeJComboBox;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
