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
public class UserLogin {
    private String userName;
    private String logInTime;
    private String logOutTime;

    public UserLogin() {
    }

    public UserLogin(String userName, String logInTime, String logOutTime) {
        this.userName = userName;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the logInTime
     */
    public String getLogInTime() {
        return logInTime;
    }

    /**
     * @param logInTime the logInTime to set
     */
    public void setLogInTime(String logInTime) {
        this.logInTime = logInTime;
    }

    /**
     * @return the logOutTime
     */
    public String getLogOutTime() {
        return logOutTime;
    }

    /**
     * @param logOutTime the logOutTime to set
     */
    public void setLogOutTime(String logOutTime) {
        this.logOutTime = logOutTime;
    }
    
    
}
