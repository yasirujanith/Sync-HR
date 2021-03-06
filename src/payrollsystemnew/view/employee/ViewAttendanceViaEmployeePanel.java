/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.view.employee;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import payrollsystemnew.controller.AttendanceController;
import payrollsystemnew.controller.DepartmentController;
import payrollsystemnew.controller.EmployeeController;
import payrollsystemnew.model.Attendance;
import payrollsystemnew.model.Department;
import payrollsystemnew.model.Employee;

/**
 *
 * @author User
 */
public class ViewAttendanceViaEmployeePanel extends javax.swing.JPanel {
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private DefaultTableModel tableModel;
    /**
     * Creates new form employeePanel
     */
    public ViewAttendanceViaEmployeePanel() {
        initComponents();
        try {
            tableModel=(DefaultTableModel) attendenceTable.getModel();
            fillDeptNameCombo();
            fromDate.setDateFormat(dateFormat);
            toDate.setDateFormat(dateFormat);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAttendanceViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        printButton.setEnabled(false);
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
        jLabel4 = new javax.swing.JLabel();
        departmentNameCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        employeeIDCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendenceTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        proceedButton = new javax.swing.JButton();
        fromDate = new org.freixas.jcalendar.JCalendarCombo();
        toDate = new org.freixas.jcalendar.JCalendarCombo();
        employeeNameText = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Department :");

        departmentNameCombo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        departmentNameCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentNameComboItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Employee ID :");

        employeeIDCombo.setEditable(true);
        employeeIDCombo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        employeeIDCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeeIDComboItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Name :");

        attendenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "In Time", "Short Leave Out Time", "Short Leave In Time", "Out Time", "OverTime Hours"
            }
        ));
        jScrollPane1.setViewportView(attendenceTable);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("From :");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("To :");

        proceedButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        fromDate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        toDate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        employeeNameText.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        printButton.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(employeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employeeNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(proceedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(departmentNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(employeeNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(proceedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printButton)
                .addGap(20, 20, 20))
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
            employeeIDCombo.removeAllItems();
            for(Employee employee : employeeList){
                employeeIDCombo.addItem(employee.getEmployeeID());
            }
            AutoCompleteDecorator.decorate(employeeIDCombo);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAttendanceViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_departmentNameComboItemStateChanged

    private void employeeIDComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeeIDComboItemStateChanged
        try {
            if(employeeIDCombo.getSelectedIndex()!=-1){
                Employee employee=EmployeeController.searchEmployee(employeeIDCombo.getSelectedItem().toString());
                employeeNameText.setText(employee.getFirstName()+" "+employee.getLastName());
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAttendanceViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_employeeIDComboItemStateChanged

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        try {
            if(employeeIDCombo.getSelectedIndex()!=-1){
                ArrayList<Attendance> attendanceList=AttendanceController.getAllAttendanceViaEmployee(employeeIDCombo.getSelectedItem().toString(), dateFormat.format(fromDate.getDate()),dateFormat.format(toDate.getDate()));
                tableModel=(DefaultTableModel) attendenceTable.getModel();
                tableModel.setRowCount(0);
                for(Attendance attendance : attendanceList){
                    Object[] rowData={attendance.getDate(),attendance.getInTime(),(attendance.getShortLeaveOuttime()!=null)?attendance.getShortLeaveOuttime():"-",(attendance.getShortLeaveIntime()!=null)?attendance.getShortLeaveIntime():"-",attendance.getOutTime(),attendance.getOTHours()};
                    tableModel.addRow(rowData);
                }
                printButton.setEnabled(true);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAttendanceViaEmployeePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_proceedButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        printAttendanceTable();
    }//GEN-LAST:event_printButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendenceTable;
    private javax.swing.JComboBox departmentNameCombo;
    private javax.swing.JComboBox employeeIDCombo;
    private javax.swing.JTextField employeeNameText;
    private org.freixas.jcalendar.JCalendarCombo fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JButton proceedButton;
    private org.freixas.jcalendar.JCalendarCombo toDate;
    // End of variables declaration//GEN-END:variables
    private void fillDeptNameCombo() throws ClassNotFoundException, SQLException{
        ArrayList<Department> deptNameList=DepartmentController.getAllDepartments();
        for(Department department : deptNameList){
            departmentNameCombo.addItem(department.getName());
        }
    }
    
    private void printAttendanceTable(){
        HashMap<String,Object> map=new HashMap<String,Object>();
        JRTableModelDataSource dataSource=new JRTableModelDataSource(tableModel);   
        try {
            JasperReport compileReport=JasperCompileManager.compileReport(getClass().getResourceAsStream("AttendanceViaEmployeeReport.jrxml"));
            map.put("Department", departmentNameCombo.getSelectedItem().toString());
            map.put("Name", employeeNameText.getText());
            map.put("FromDate", dateFormat.format(fromDate.getDate()));
            map.put("ToDate", dateFormat.format(toDate.getDate()));
            JasperPrint fillReport=JasperFillManager.fillReport(compileReport, map, dataSource);
            JasperViewer.viewReport(fillReport,false);
        } catch (JRException ex) {
            Logger.getLogger(ViewEmployeeViaDeptPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
