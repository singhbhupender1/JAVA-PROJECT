/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PathologyLabEnterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.LabAssistantOrganization;
import Business.Organization.PatientOrganization;
import Business.Queue.AppointmentVisitRequest;
import Business.Queue.LabLaPRequest;
import Business.Queue.WorkRequest;
import Business.UserAccount.UserAccount;
import Business.Validations.StringThenSpaceVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zeppelin
 */
public class LabTestTakingJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private UserAccount doctor;
    private EcoSystem business;
    private Network network;
    private Organization org;
    private PatientOrganization patientOrg;
    private UserAccount patient;
    
    
    /**
     * Creates new form RequestLabTestJPanel
     */
    public LabTestTakingJPanel(JPanel userProcessContainer, UserAccount account,
            Enterprise enterprise,Organization org, EcoSystem business, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        userAccount = account;
        this.business = business;
        this.org=org;
        
       
        
        populatepatientJComboBox();
        populatedoctorJComboBox();
        populateTable();
      
        checkBlankInput();
        addStringThenSpaceVerifiers();
        
    }
    
     private void addStringThenSpaceVerifiers(){
        InputVerifier stringThenSpaceVerifier = new StringThenSpaceVerifier();
        //patientEmailJTextField.setInputVerifier(stringThenSpaceVerifier);
    }
    
      private Boolean checkBlankInput()
    {
        if(messageJTextField.getText().length()==0)
            {
                return false;
            }
        else
        {
            return true;
        }
    }  
    
    
    
    
     public void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel)patientMedicinesJTable.getModel();
        
        model.setRowCount(0);
        
        for(Network net : business.getNetworkList()){
            
      for(Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()){
          if(enter instanceof PathologyLabEnterprise){
            for(Organization organization : enter.getOrganizationDirectory().getOrganizationList()){        
              if (organization instanceof LabAssistantOrganization){
           for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
               
               AppointmentVisitRequest drug = (AppointmentVisitRequest)request;
               if(drug.getpPreferredLabAssistant()==userAccount){
            
            Object[] row = new Object[9];
            
            row[0] = drug;
            row[1] = drug.getReceiver();
            row[2] = drug.getSender();
            row[3] = drug.getpEmail();
            row[4] = drug.getTestOne();
            row[5] = drug.getTestTwo();
            row[6] = drug.getTestThree();
            row[7] = drug.getAppointmentResult();
           
            row[8] = drug.getMessage();
   
             model.addRow(row);
            }
        }
     }
            }}}}}

    public void populatepatientJComboBox(){
        
        patientJComboBox.removeAll();
    
    for(Network net : business.getNetworkList()){
      for(Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()){
          if(enter instanceof HospitalEnterprise){
            for(Organization organization : enter.getOrganizationDirectory().getOrganizationList()){        
              if (organization instanceof PatientOrganization){
                for(UserAccount ua:organization.getUserAccountDirectory().getUserAccountList()){
                    
                patientJComboBox.addItem(ua); 
               }  
             }
           }
         }
       }
     }
   }
       
    public void populatedoctorJComboBox(){
        
         doctorJComboBox.removeAll();
        for(Network net : business.getNetworkList()){
      for(Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()){
          if(enter instanceof HospitalEnterprise){
            for(Organization organization : enter.getOrganizationDirectory().getOrganizationList()){        
              if (organization instanceof DoctorOrganization){
                for(UserAccount ua:organization.getUserAccountDirectory().getUserAccountList()){
                    
                doctorJComboBox.addItem(ua); 
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

        requestDrugJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        patientJComboBox = new javax.swing.JComboBox();
        doctorJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fromJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        toJDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientMedicinesJTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        patientEmailJTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestDrugJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        requestDrugJButton.setText("Inform Patient & E-mail Patient");
        requestDrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestDrugJButtonActionPerformed(evt);
            }
        });
        add(requestDrugJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, -1, 50));

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        patientJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(patientJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 180, -1));

        doctorJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(doctorJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 180, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Drugs for Patient");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Prescription by Doctor");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Date Range for Lab Test");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 20));
        add(fromJDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("From");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("To");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));
        add(toJDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        patientMedicinesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Illness", "Requesting Doctor", "Patient Name", "Patient EmailID", "Test 1", "Test 2", "Test 3", "Appointment Result", "Information Sent?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientMedicinesJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 630, 130));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Mention the tests(Separate by commas)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        messageJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 210, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Enter Email Address of the selected patient");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, 20));

        patientEmailJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        patientEmailJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientEmailJTextFieldActionPerformed(evt);
            }
        });
        add(patientEmailJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 200, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("LAB ASSISTANT TO PATIENT");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("View the request and notify patient");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestDrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestDrugJButtonActionPerformed
        
         if(checkBlankInput()){
         int selectedRow = patientMedicinesJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        else
        {
      
        
        LabLaPRequest lab = new LabLaPRequest();
        
        lab.setStatus5("Sent");
        lab.setSender(userAccount);
        
        patient = (UserAccount)patientJComboBox.getSelectedItem();                   
        lab.setReceiver(patient);
        
        doctor = (UserAccount)doctorJComboBox.getSelectedItem();
        lab.setDoctor(doctor);
        
        lab.setInformation(messageJTextField.getText());
        
        lab.setTestFromDate(fromJDateChooser.getDate());
        lab.setTestToDate(toJDateChooser.getDate());
        
            Organization org = null;
            Enterprise ent = null;
          
      
            for(Network net : business.getNetworkList())  {
          
        for (Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList())    {
         if(enter instanceof HospitalEnterprise)  {
           for (Organization organization : enter.getOrganizationDirectory().getOrganizationList())   {        
            if (organization instanceof PatientOrganization){                
                org= (PatientOrganization)organization; 
                break;
            }
           }
          }
         }
        }
            if(org != null)
            {
            org.getWorkQueue().getWorkRequestList().add(lab);
            userAccount.getWorkQueue().getWorkRequestList().add(lab);
            }
            
           populateTable();
           
           
           Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("rameshkumarsardana5@gmail.com","13987$$13987");
                }
            }

        );
        try{

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rameshkumarsardana5@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(patientEmailJTextField.getText()));
            message.setText("Hey, your tests are ready to be taken!!");
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"Message sent");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
           JOptionPane.showMessageDialog(null,"Notification has been sent to the patient.",
        "Information", JOptionPane.INFORMATION_MESSAGE);
        
        }  
        }
      
         else{
         JOptionPane.showMessageDialog(null,"You cannot leave fields blank,","Warning", JOptionPane.WARNING_MESSAGE);
        
     }
          
    }//GEN-LAST:event_requestDrugJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabAssistantToPatientJPanel latpjp = (LabAssistantToPatientJPanel) component;
        latpjp.populateTable();
               
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void patientEmailJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientEmailJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientEmailJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox doctorJComboBox;
    private com.toedter.calendar.JDateChooser fromJDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTextField patientEmailJTextField;
    private javax.swing.JComboBox patientJComboBox;
    private javax.swing.JTable patientMedicinesJTable;
    private javax.swing.JButton requestDrugJButton;
    private com.toedter.calendar.JDateChooser toJDateChooser;
    // End of variables declaration//GEN-END:variables
}
