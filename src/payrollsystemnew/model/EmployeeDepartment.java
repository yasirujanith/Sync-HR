/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.model;

/**
 *
 * @author User
 */
public class EmployeeDepartment {
    private String employeeID;
    private String departmentID;

    public EmployeeDepartment() {
    }

    public EmployeeDepartment(String employeeID, String departmentID) {
        this.employeeID = employeeID;
        this.departmentID = departmentID;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the departmentID
     */
    public String getDepartmentID() {
        return departmentID;
    }

    /**
     * @param departmentID the departmentID to set
     */
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
    
    
}
