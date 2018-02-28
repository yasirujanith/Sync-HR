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
public class Salary {
    private String salaryID;
    private String employeeID;
    private String basicSalary;
    private String OTEarning;
    private String bonus;
    private String stampFee;
    private String TAX;
    private String salaryAdvance;
    private String loan;
    private String noPayLeaves;
    private String halfDay;
    private String damages;
    private String EPF;
    private String ETF;

    public Salary() {
    }

    public Salary(String salaryID, String employeeID, String basicSalary, String OTEarning, String bonus, String stampFee, String TAX, String salaryAdvance, String loan, String noPayLeaves, String halfDay, String damages, String EPF, String ETF) {
        this.salaryID = salaryID;
        this.employeeID = employeeID;
        this.basicSalary = basicSalary;
        this.OTEarning = OTEarning;
        this.bonus = bonus;
        this.stampFee = stampFee;
        this.TAX = TAX;
        this.salaryAdvance = salaryAdvance;
        this.loan = loan;
        this.noPayLeaves = noPayLeaves;
        this.halfDay = halfDay;
        this.damages = damages;
        this.EPF = EPF;
        this.ETF = ETF;
    }

    /**
     * @return the salaryID
     */
    public String getSalaryID() {
        return salaryID;
    }

    /**
     * @param salaryID the salaryID to set
     */
    public void setSalaryID(String salaryID) {
        this.salaryID = salaryID;
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
     * @return the basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the OTEarning
     */
    public String getOTEarning() {
        return OTEarning;
    }

    /**
     * @param OTEarning the OTEarning to set
     */
    public void setOTEarning(String OTEarning) {
        this.OTEarning = OTEarning;
    }

    /**
     * @return the bonus
     */
    public String getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the stampFee
     */
    public String getStampFee() {
        return stampFee;
    }

    /**
     * @param stampFee the stampFee to set
     */
    public void setStampFee(String stampFee) {
        this.stampFee = stampFee;
    }

    /**
     * @return the TAX
     */
    public String getTAX() {
        return TAX;
    }

    /**
     * @param TAX the TAX to set
     */
    public void setTAX(String TAX) {
        this.TAX = TAX;
    }

    /**
     * @return the salaryAdvance
     */
    public String getSalaryAdvance() {
        return salaryAdvance;
    }

    /**
     * @param salaryAdvance the salaryAdvance to set
     */
    public void setSalaryAdvance(String salaryAdvance) {
        this.salaryAdvance = salaryAdvance;
    }

    /**
     * @return the loan
     */
    public String getLoan() {
        return loan;
    }

    /**
     * @param loan the loan to set
     */
    public void setLoan(String loan) {
        this.loan = loan;
    }

    /**
     * @return the noPayLeaves
     */
    public String getNoPayLeaves() {
        return noPayLeaves;
    }

    /**
     * @param noPayLeaves the noPayLeaves to set
     */
    public void setNoPayLeaves(String noPayLeaves) {
        this.noPayLeaves = noPayLeaves;
    }

    /**
     * @return the halfDay
     */
    public String getHalfDay() {
        return halfDay;
    }

    /**
     * @param halfDay the halfDay to set
     */
    public void setHalfDay(String halfDay) {
        this.halfDay = halfDay;
    }

    /**
     * @return the damages
     */
    public String getDamages() {
        return damages;
    }

    /**
     * @param damages the damages to set
     */
    public void setDamages(String damages) {
        this.damages = damages;
    }

    /**
     * @return the EPF
     */
    public String getEPF() {
        return EPF;
    }

    /**
     * @param EPF the EPF to set
     */
    public void setEPF(String EPF) {
        this.EPF = EPF;
    }

    /**
     * @return the ETF
     */
    public String getETF() {
        return ETF;
    }

    /**
     * @param ETF the ETF to set
     */
    public void setETF(String ETF) {
        this.ETF = ETF;
    }
    
    
    
}
