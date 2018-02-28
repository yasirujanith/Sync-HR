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
public class Attendance {
    private String employeeID;
    private String date;
    private String inTime;
    private String shortLeaveOuttime;
    private String shortLeaveIntime;
    private String outTime;
    private String OTHours;

    public Attendance() {
    }

    public Attendance(String employeeID, String date, String inTime, String shortLeaveOuttime, String shortLeaveIntime, String outTime, String OTHours) {
        this.employeeID = employeeID;
        this.date = date;
        this.inTime = inTime;
        this.shortLeaveOuttime = shortLeaveOuttime;
        this.shortLeaveIntime = shortLeaveIntime;
        this.outTime = outTime;
        this.OTHours = OTHours;
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
     * @return the inTime
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the shortLeaveOuttime
     */
    public String getShortLeaveOuttime() {
        return shortLeaveOuttime;
    }

    /**
     * @param shortLeaveOuttime the shortLeaveOuttime to set
     */
    public void setShortLeaveOuttime(String shortLeaveOuttime) {
        this.shortLeaveOuttime = shortLeaveOuttime;
    }

    /**
     * @return the shortLeaveIntime
     */
    public String getShortLeaveIntime() {
        return shortLeaveIntime;
    }

    /**
     * @param shortLeaveIntime the shortLeaveIntime to set
     */
    public void setShortLeaveIntime(String shortLeaveIntime) {
        this.shortLeaveIntime = shortLeaveIntime;
    }

    /**
     * @return the outTime
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * @param outTime the outTime to set
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    /**
     * @return the OTHours
     */
    public String getOTHours() {
        return OTHours;
    }

    /**
     * @param OTHours the OTHours to set
     */
    public void setOTHours(String OTHours) {
        this.OTHours = OTHours;
    }
}
