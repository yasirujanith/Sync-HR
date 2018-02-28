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
public class LeaveCount {
    private int noPayCount;
    private int halfDayCount;

    public LeaveCount() {
    }

    public LeaveCount(int noPayCount, int halfDayCount) {
        this.noPayCount = noPayCount;
        this.halfDayCount = halfDayCount;
    }

    /**
     * @return the noPayCount
     */
    public int getNoPayCount() {
        return noPayCount;
    }

    /**
     * @param noPayCount the noPayCount to set
     */
    public void setNoPayCount(int noPayCount) {
        this.noPayCount = noPayCount;
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
