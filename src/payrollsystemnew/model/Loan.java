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
public class Loan {
    private String employeeID;
    private String loanID;
    private String date;
    private String description;
    private double amount;
    private double monthlyIntallment;
    private double installment;
    private String dueDate;
    private boolean isPaymentOver;

    public Loan() {
    }

    public Loan(String employeeID, String loanID, String date, String description, double amount, double monthlyIntallment, double installment, String dueDate, boolean isPaymentOver) {
        this.employeeID = employeeID;
        this.loanID = loanID;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.monthlyIntallment = monthlyIntallment;
        this.installment = installment;
        this.dueDate = dueDate;
        this.isPaymentOver = isPaymentOver;
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
     * @return the loanID
     */
    public String getLoanID() {
        return loanID;
    }

    /**
     * @param loanID the loanID to set
     */
    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the monthlyIntallment
     */
    public double getMonthlyIntallment() {
        return monthlyIntallment;
    }

    /**
     * @param monthlyIntallment the monthlyIntallment to set
     */
    public void setMonthlyIntallment(double monthlyIntallment) {
        this.monthlyIntallment = monthlyIntallment;
    }

    /**
     * @return the installment
     */
    public double getInstallment() {
        return installment;
    }

    /**
     * @param installment the installment to set
     */
    public void setInstallment(double installment) {
        this.installment = installment;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the isPaymentOver
     */
    public boolean isPaymentOver() {
        return isPaymentOver;
    }

    /**
     * @param isPaymentOver the isPaymentOver to set
     */
    public void setIsPaymentOver(boolean isPaymentOver) {
        this.isPaymentOver = isPaymentOver;
    }

    
}
