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
public class Department {
    private String departmentID;
    private String name;
    private int numOfEmployees;

    public Department() {
    }

    public Department(String departmentID, String name, int numOfEmployees) {
        this.departmentID = departmentID;
        this.name = name;
        this.numOfEmployees = numOfEmployees;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numOfEmployees
     */
    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    /**
     * @param numOfEmployees the numOfEmployees to set
     */
    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }
    
    
}
