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
public class LoanPayment {
    private String loanID;
    private String date;
    private double amount;

    public LoanPayment() {
    }

    public LoanPayment(String loanID, String date, double amount) {
        this.loanID = loanID;
        this.date = date;
        this.amount = amount;
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

    
}
