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
public class PaymentType {
    private String employeeID;
    private boolean isCash;
    private boolean isCheque;
    private boolean isDeposit;
    private String bankName;
    private String accNumber;

    public PaymentType() {
    }

    public PaymentType(String employeeID, boolean isCash, boolean isCheque, boolean isDeposit, String bankName, String accNumber) {
        this.employeeID = employeeID;
        this.isCash = isCash;
        this.isCheque = isCheque;
        this.isDeposit = isDeposit;
        this.bankName = bankName;
        this.accNumber = accNumber;
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
     * @return the isCash
     */
    public boolean isCash() {
        return isCash;
    }

    /**
     * @param isCash the isCash to set
     */
    public void setIsCash(boolean isCash) {
        this.isCash = isCash;
    }

    /**
     * @return the isCheque
     */
    public boolean isCheque() {
        return isCheque;
    }

    /**
     * @param isCheque the isCheque to set
     */
    public void setIsCheque(boolean isCheque) {
        this.isCheque = isCheque;
    }

    /**
     * @return the isDeposit
     */
    public boolean isDeposit() {
        return isDeposit;
    }

    /**
     * @param isDeposit the isDeposit to set
     */
    public void setIsDeposit(boolean isDeposit) {
        this.isDeposit = isDeposit;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the accNumber
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    
    
}
