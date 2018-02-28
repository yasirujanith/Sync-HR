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
public class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private String contactNumber;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String joiningDate;
    private String gradeID;
    private String departmentID;

    public Employee() {
    }

    public Employee(String employeeID, String firstName, String lastName, String NIC, String address, String contactNumber, String dateOfBirth, String gender, String maritalStatus, String joiningDate, String gradeID, String departmentID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.NIC = NIC;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.joiningDate = joiningDate;
        this.gradeID = gradeID;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the joiningDate
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * @param joiningDate the joiningDate to set
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * @return the gradeID
     */
    public String getGradeID() {
        return gradeID;
    }

    /**
     * @param gradeID the gradeID to set
     */
    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
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