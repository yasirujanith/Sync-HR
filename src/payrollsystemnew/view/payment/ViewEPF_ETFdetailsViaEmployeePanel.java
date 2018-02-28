/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.view.payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import payrollsystemnew.controller.DepartmentController;
import payrollsystemnew.controller.EmployeeController;
import payrollsystemnew.controller.PaymentController;
import payrollsystemnew.model.Department;
import payrollsystemnew.model.Employee;

/**
 *
 * @author User
 */
public class ViewEPF_ETFdetailsViaEmployeePanel extends javax.swing.JPanel {
    public static ViewEPF_ETFdetailsViaEmployeePanel ePF_ETFdetailsViaEmployeePanel;
    
    /**
     * Creates new form employeePanel
     */
    public ViewEPF_ETFdetailsViaEmployeePanel() {
        initComponents();
        try {
            ePF_ETFdetailsViaEmployeePanel=this;
            fillDepartmentNameCombo();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewEPF_ETFdetailsViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        departmentNameCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        epfEtfDetailTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Department  :");

        departmentNameCombo.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        departmentNameCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentNameComboItemStateChanged(evt);
            }
        });

        epfEtfDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "Name", "Total EPF ", "Total ETF"
            }
        ));
        jScrollPane1.setViewportView(epfEtfDetailTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(departmentNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane1)
                    .addGap(48, 48, 48)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(departmentNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(503, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 580));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystemnew/images/Background.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void departmentNameComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentNameComboItemStateChanged
        try {
            Department department=DepartmentController.searchDepartmentByName(departmentNameCombo.getSelectedItem().toString());
            ArrayList<Employee> employeeList=EmployeeController.getAllEmployeesViaDepartment(department.getDepartmentID());
            DefaultTableModel tableModel=(DefaultTableModel) epfEtfDetailTable.getModel();
            tableModel.setRowCount(0);
            for(Employee employee : employeeList){
                ResultSet rst=PaymentController.getEPF_ETFAmount(employee.getEmployeeID());
                while(rst.next()){
                    Object[] rowData={employee.getEmployeeID(),employee.getFirstName()+" "+employee.getLastName(),rst.getString(1),rst.getString(2)};
                    tableModel.addRow(rowData);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewEPF_ETFdetailsViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departmentNameComboItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox departmentNameCombo;
    private javax.swing.JTable epfEtfDetailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private void fillDepartmentNameCombo() throws ClassNotFoundException, SQLException{
        ArrayList<Department> deptList=DepartmentController.getAllDepartments();
        for(Department department : deptList){
            departmentNameCombo.addItem(department.getName());
        }
    }


}