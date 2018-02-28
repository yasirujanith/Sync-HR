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
public class Damage {
    private String damageID;
    private String date;
    private String employeeID;
    private String description;
    private double damageCost;

    public Damage() {
    }

    public Damage(String damageID, String date, String employeeID, String description, double damageCost) {
        this.damageID = damageID;
        this.date = date;
        this.employeeID = employeeID;
        this.description = description;
        this.damageCost = damageCost;
    }

    /**
     * @return the damageID
     */
    public String getDamageID() {
        return damageID;
    }

    /**
     * @param damageID the damageID to set
     */
    public void setDamageID(String damageID) {
        this.damageID = damageID;
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
     * @return the damageCost
     */
    public double getDamageCost() {
        return damageCost;
    }

    /**
     * @param damageCost the damageCost to set
     */
    public void setDamageCost(double damageCost) {
        this.damageCost = damageCost;
    }

    
    
}
