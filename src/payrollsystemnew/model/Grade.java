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
public class Grade {
    private String gradeID;
    private double basicSalary;
    private double OTRate;
    private double noPayRate;
    private double maxLoanAmount;
    private double vehicleAllowence;
    private double transportAmount;
    private int leavesCount;
    private int noPayLeaveCount;
    private int halfDayCount;

    public Grade() {
    }

    public Grade(String gradeID, double basicSalary, double OTRate, double noPayRate, double maxLoanAmount, double vehicleAllowence, double transportAmount, int leavesCount, int noPayLeaveCount, int halfDayCount) {
        this.gradeID = gradeID;
        this.basicSalary = basicSalary;
        this.OTRate = OTRate;
        this.noPayRate = noPayRate;
        this.maxLoanAmount = maxLoanAmount;
        this.vehicleAllowence = vehicleAllowence;
        this.transportAmount = transportAmount;
        this.leavesCount = leavesCount;
        this.noPayLeaveCount = noPayLeaveCount;
        this.halfDayCount = halfDayCount;
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
     * @return the basicSalary
     */
    public double getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the OTRate
     */
    public double getOTRate() {
        return OTRate;
    }

    /**
     * @param OTRate the OTRate to set
     */
    public void setOTRate(double OTRate) {
        this.OTRate = OTRate;
    }

    /**
     * @return the noPayRate
     */
    public double getNoPayRate() {
        return noPayRate;
    }

    /**
     * @param noPayRate the noPayRate to set
     */
    public void setNoPayRate(double noPayRate) {
        this.noPayRate = noPayRate;
    }

    /**
     * @return the maxLoanAmount
     */
    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    /**
     * @param maxLoanAmount the maxLoanAmount to set
     */
    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    /**
     * @return the vehicleAllowence
     */
    public double getVehicleAllowence() {
        return vehicleAllowence;
    }

    /**
     * @param vehicleAllowence the vehicleAllowence to set
     */
    public void setVehicleAllowence(double vehicleAllowence) {
        this.vehicleAllowence = vehicleAllowence;
    }

    /**
     * @return the transportAmount
     */
    public double getTransportAmount() {
        return transportAmount;
    }

    /**
     * @param transportAmount the transportAmount to set
     */
    public void setTransportAmount(double transportAmount) {
        this.transportAmount = transportAmount;
    }

    /**
     * @return the leavesCount
     */
    public int getLeavesCount() {
        return leavesCount;
    }

    /**
     * @param leavesCount the leavesCount to set
     */
    public void setLeavesCount(int leavesCount) {
        this.leavesCount = leavesCount;
    }

    /**
     * @return the noPayLeaveCount
     */
    public int getNoPayLeaveCount() {
        return noPayLeaveCount;
    }

    /**
     * @param noPayLeaveCount the noPayLeaveCount to set
     */
    public void setNoPayLeaveCount(int noPayLeaveCount) {
        this.noPayLeaveCount = noPayLeaveCount;
    }

    /**
     * @return the halfDayCount
     */
    public int getHalfDayCount() {
        return halfDayCount;
    }

    /**
     * @param halfDayCount the halfDayCount to set
     */
    public void setHalfDayCount(int halfDayCount) {
        this.halfDayCount = halfDayCount;
    }

    
    
}
