/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PathologyLabEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.LabAssistantOrganization;
import Business.Queue.LabLaPRequest;
import Business.Queue.WorkRequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zeppelin
 */
public class LabAssistantToPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabAssistantToPatientJPanel
     */
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private Network network;
    private Organization org;
    private LabAssistantOrganization labAssistantOrg;
    
    public LabAssistantToPatientJPanel(JPanel userProcessContainer,
                     UserAccount account, Organization organization,
                   EcoSystem business,Enterprise enterprise) {
        
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        
        for(Network net : business.getNetworkList()){
            for(Enterprise enter:net.getEnterpriseDirectory().getEnterpriseList()){
              if(enter instanceof PathologyLabEnterprise){
        for(Organization or : enterprise.getOrganizationDirectory().getOrganizationList() )
            if(or instanceof LabAssistantOrganization){
                labAssistantOrg=(LabAssistantOrganization)or;
                break;
            }
         
       
            populateTable();
        } 
    }}}
    
    public void populateTable(){
        
        notifyDrugJTable.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        notifyDrugJTable.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        
        DefaultTableModel model = (DefaultTableModel) notifyDrugJTable.getModel();
        
        model.setRowCount(0);
            
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
                 
                    Object[] row = new Object[9];
                    
                    LabLaPRequest lab = (LabLaPRequest)request;
                    
                    row[0] = lab;
                    row[1] = lab.getSender(); 
                    row[2] = lab.getReceiver();
                    row[3] = lab.getDoctor();
                    row[4] = lab.getTestFromDate();
                    row[5] = lab.getTestToDate();
                    row[6] = lab.getResolveDate();
                    String result = lab.getLabTestRequestResult();
                    row[7] = result == null ? "Informed" : result;
                    row[8] = lab.getInformation();
                    
                    model.addRow(row);
                 
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

        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notifyDrugJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("LAB ASSISTANT TO PATIENT INFORMATION");

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        notifyDrugJTable.setAutoCreateRowSorter(true);
        notifyDrugJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Status", "Chemist Name", "Patient Name", "Requested By Doctor", "Date From", "Date to", "Performed Date", "Result", "Test Information"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(notifyDrugJTable);

        requestTestJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        requestTestJButton.setText("Send Test Details To Patient");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton)
                        .addGap(97, 97, 97)
                        .addComponent(refreshTestJButton)
                        .addGap(44, 44, 44)
                        .addComponent(requestTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)))
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backJButton))
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        LabTestTakingJPanel ndrjp = new LabTestTakingJPanel(userProcessContainer, userAccount, enterprise, org, business, network);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", ndrjp );
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestTestJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notifyDrugJTable;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    // End of variables declaration//GEN-END:variables
}
