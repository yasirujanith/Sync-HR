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
public class SalaryPayment {
    private String salaryID;
    private String paymentType;
    private String date;
    private double netSalary;

    public SalaryPayment() {
    }

    public SalaryPayment(String salaryID, String paymentType, String date, double netSalary) {
        this.salaryID = salaryID;
        this.paymentType = paymentType;
        this.date = date;
        this.netSalary = netSalary;
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
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
     * @return the netSalary
     */
    public double getNetSalary() {
        return netSalary;
    }

    /**
     * @param netSalary the netSalary to set
     */
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
