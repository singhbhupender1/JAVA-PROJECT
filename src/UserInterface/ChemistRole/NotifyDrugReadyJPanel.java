/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ChemistRole;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Network.Network;
import Business.Organization.ChemistOrganization;
import Business.Organization.DoctorOrganization;

import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Queue.AppointmentVisitRequest;
import Business.Queue.NotifyCPRequest;
import Business.Queue.WorkRequest;
import Business.UserAccount.UserAccount;
import Business.Validations.StringThenSpaceVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
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
public class NotifyDrugReadyJPanel extends javax.swing.JPanel {

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
    public NotifyDrugReadyJPanel(JPanel userProcessContainer, UserAccount account,
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
        
        addStringThenSpaceVerifiers();
        checkBlankInput();
        
    }
    
    
    
     private Boolean checkBlankInput()
    {
        if(messageJTextField.getText().length()==0
                ||patientEmailJTextField.getText().length()==0)
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
       // patientEmailJTextField.setInputVerifier(stringThenSpaceVerifier);
    }
    
    public void populateTable(){
        
        patientMedicinesJTable.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        patientMedicinesJTable.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        
        DefaultTableModel model = (DefaultTableModel)patientMedicinesJTable.getModel();
        
        model.setRowCount(0);
        
        for(Network net : business.getNetworkList()){
            
      for(Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()){
          if(enter instanceof PharmacyEnterprise){
            for(Organization organization : enter.getOrganizationDirectory().getOrganizationList()){        
              if (organization instanceof ChemistOrganization){
           for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
               AppointmentVisitRequest drug = (AppointmentVisitRequest)request;
               if(drug.getpPreferredChemist()==userAccount){
            
            Object[] row = new Object[9];
            
            row[0] = drug;
            row[1] = drug.getReceiver();
            row[2] = drug.getSender();
            row[3] = drug.getpEmail();
            row[4] = (drug.getMedicineOne())+"-"+(drug.getDosageOne()+"mg");
            row[5] = (drug.getMedicineTwo())+"-"+(drug.getDosageTwo()+"mg");
            row[6] = (drug.getMedicineThree())+"-"+(drug.getDosageThree()+"mg");
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
        collectionJDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientMedicinesJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        patientEmailJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestDrugJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        requestDrugJButton.setText("Notify & E-mail Patient");
        requestDrugJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestDrugJButtonActionPerformed(evt);
            }
        });
        add(requestDrugJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 469, -1, 49));

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 489, -1, -1));

        patientJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(patientJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 219, 200, -1));

        doctorJComboBox.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(doctorJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 269, 200, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Drugs for Patient");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 219, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Prescription by Doctor");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 269, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Collection Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 319, -1, -1));
        add(collectionJDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 319, 190, -1));

        patientMedicinesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Illness", "Prescribing Doctor", "Patient Name", "Patient's Email", "Medicine 1", "Medicine 2", "Medicine 3", "Appointment Status", "Notification Sent?"
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 570, 109));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("View the request and notify patient");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 44, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Note: Please select patient from the table & continue below");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Mention the medicines(Separate by commas)");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 369, -1, -1));

        messageJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 364, 190, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Enter Email Address of the selected patient");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 419, -1, -1));

        patientEmailJTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        add(patientEmailJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 409, 190, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("CHEMIST TO PATIENT");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 12, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestDrugJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestDrugJButtonActionPerformed

        
        if(checkBlankInput()){
        int selectedRow = patientMedicinesJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        else {
        AppointmentVisitRequest appt = (AppointmentVisitRequest)patientMedicinesJTable.getValueAt(selectedRow, 0);
        appt.setMessage("Yes");
 
        NotifyCPRequest request = new NotifyCPRequest();
        
        request.setStatus4("Sent");
        request.setSender(userAccount);
        
        request.setInformation(messageJTextField.getText());
        
        patient = (UserAccount)patientJComboBox.getSelectedItem();                   
        request.setReceiver(patient);
        
        doctor = (UserAccount)doctorJComboBox.getSelectedItem();
        request.setDoctor(doctor);
        
        request.setResolveDate(collectionJDateChooser.getDate());
       
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
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
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
                    return new PasswordAuthentication("hospital.final.project@gmail.com","aedfinalproject");
                }
            }

        );
        try{

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hospital.final.project@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(patientEmailJTextField.getText()));
            message.setText("Hey, your drugs are ready to be collected!!");
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
        
        ChemistToPatientJPanel dtprjp = (ChemistToPatientJPanel) component;
        dtprjp.populatenotifyDrugTable();
               
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private com.toedter.calendar.JDateChooser collectionJDateChooser;
    private javax.swing.JComboBox doctorJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTextField patientEmailJTextField;
    private javax.swing.JComboBox patientJComboBox;
    private javax.swing.JTable patientMedicinesJTable;
    private javax.swing.JButton requestDrugJButton;
    // End of variables declaration//GEN-END:variables
}
