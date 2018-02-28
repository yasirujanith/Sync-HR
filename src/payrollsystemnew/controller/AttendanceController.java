/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import payrollsystemnew.dbconnection.DBConnection;
import payrollsystemnew.model.Attendance;

/**
 *
 * @author User
 */
public class AttendanceController {
    
    public static int markIn(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into attendance values(?,?,?,?,?,?,?)");
        stm.setObject(1,attendance.getEmployeeID());
        stm.setObject(2,attendance.getDate());
        stm.setObject(3,attendance.getInTime());
        stm.setObject(4,null);
        stm.setObject(5,null);
        stm.setObject(6,null);
        stm.setObject(7,null);
        
        return stm.executeUpdate();
    }
    
    public static int markLateIn(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into attendance values(?,?,?,?,?,?,?)");
        stm.setObject(1,attendance.getEmployeeID());
        stm.setObject(2,attendance.getDate());
        stm.setObject(3,"08:30:00");
        stm.setObject(4,"08:30:00");
        stm.setObject(5,attendance.getShortLeaveIntime());
        stm.setObject(6,null);
        stm.setObject(7,null);
        
        return stm.executeUpdate();
    }
    
    public static int markOut(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update attendance set outTime=?, OTHours=? where employeeID=? and date=?");
        stm.setObject(1,attendance.getOutTime());
        stm.setObject(2, attendance.getOTHours());
        stm.setObject(3, attendance.getEmployeeID());
        stm.setObject(4, attendance.getDate());
        return stm.executeUpdate();
    }
    
    public static int markShortLeaveOut(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update attendance set shortLeaveOutTime=? where employeeID=? and date=?");
        stm.setObject(1, attendance.getShortLeaveOuttime());
        stm.setObject(2, attendance.getEmployeeID());
        stm.setObject(3, attendance.getDate());
        return stm.executeUpdate();
    }
    
    public static int markShortLeaveIn(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update attendance set shortLeaveInTime=? where employeeID=? and date=?");
        stm.setObject(1,attendance.getShortLeaveIntime());
        stm.setObject(2, attendance.getEmployeeID());
        stm.setObject(3, attendance.getDate());
        return stm.executeUpdate();
    }
    
    public static int removeShortLeave(Attendance attendance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update attendance set shortLeaveOutTime=?, shortLeaveInTime=? where employeeID=? and date=?");
        stm.setObject(1,null);
        stm.setObject(2,null);
        stm.setObject(3, attendance.getEmployeeID());
        stm.setObject(4, attendance.getDate());
        return stm.executeUpdate();
    }
    
    public static boolean isEmployeeMarkedIn(String employeeID, String date) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from attendance where employeeID=? and date=?");
        stm.setObject(1, employeeID);
        stm.setObject(2, date);
        ResultSet rst=stm.executeQuery();
        return rst.next();
    }
    
    public static Attendance searchEmployeeAttendace(String employeeID, String date) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from attendance where employeeID=? and date=?");
        stm.setObject(1, employeeID);
        stm.setObject(2, date);
        ResultSet rst=stm.executeQuery();
        Attendance attendace=null;
        while(rst.next()){
            attendace=new Attendance(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6), rst.getString(7));
        }
        return attendace;
    }
    
    public static int getShortLeaveCount(String employeeID, String toDate) throws ClassNotFoundException, SQLException{
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c=Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 25);
        String fromDate=dateFormat.format(c.getTime());
        
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from attendance where employeeID=? and date between ? and ?");
        stm.setObject(1, employeeID);
        stm.setObject(2, fromDate);
        stm.setObject(3, toDate);
        ResultSet rst=stm.executeQuery();
        int shortLeaveCount=0;
        while(rst.next()){
             if(rst.getString("shortLeaveInTime")!=null){
                 shortLeaveCount++;
             }
        }
        return shortLeaveCount;
    }
     
     public static boolean isShortLeaveValid(String employeeID, String currentDate) throws ClassNotFoundException, SQLException{
        boolean b=false;
         try {
            SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
            Attendance attendance=AttendanceController.searchEmployeeAttendace(employeeID, currentDate);
            Date shortLeaveOutTime=timeFormat.parse(attendance.getShortLeaveOuttime());
            Calendar c=Calendar.getInstance();
            c.setTime(shortLeaveOutTime);
            c.add(Calendar.HOUR, 1);
            c.add(Calendar.MINUTE, 30);
            Date maxShortLeaveTime=timeFormat.parse(timeFormat.format(c.getTime()));
            Date currentTime=timeFormat.parse(timeFormat.format(new Date()));
            
            Connection conn=DBConnection.getDBConnection().getConnection();
            PreparedStatement stm=conn.prepareStatement("select * from attendance where employeeID=? and date=?");
            stm.setObject(1, employeeID);
            stm.setObject(2, currentDate);
            ResultSet rst=stm.executeQuery();
           
            while(rst.next()){
                if(currentTime.before(maxShortLeaveTime)){
                    b=true;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
     
     public static ResultSet viewLeavesViaDate(String deptName, String date) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select employee.employeeID, firstName, lastName, leaveType, reason from employee, leaves, department where department.departmentID=employee.departmentID and employee.employeeID=leaves.employeeID and name=? and date=?");
         stm.setObject(1, deptName);
         stm.setObject(2, date);
       
         return stm.executeQuery();
     }
     
     public static ArrayList<Attendance> getAllAttendance(String currentDate) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from attendance where date=?");
         stm.setObject(1, currentDate);
         ResultSet rst=stm.executeQuery();
         ArrayList<Attendance> attendanceList=new ArrayList();
         while(rst.next()){
            String employeeID=rst.getString("employeeID");
            String date=rst.getString("date");
            String inTime=rst.getString("inTime");
            String shortLeaveOutTime=rst.getString("shortLeaveOutTime");
            String shortLeaveInTime=rst.getString("shortLeaveInTime");
            String outTime=rst.getString("outTime");
            String OTHours=rst.getString("OTHours");
            
            attendanceList.add(new Attendance(employeeID, date, inTime, shortLeaveOutTime, shortLeaveInTime, outTime, OTHours));
         }
         return attendanceList;
     }
     
     public static ArrayList<Attendance> getAllAttendanceViaEmployee(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from attendance where employeeID=? and date between ? and ?");
         stm.setObject(1, employeeID);
         stm.setObject(2, fromDate);
         stm.setObject(3, toDate);
         ResultSet rst=stm.executeQuery();
         ArrayList<Attendance> attendanceList=new ArrayList();
         while(rst.next()){
            String date=rst.getString("date");
            String inTime=rst.getString("inTime");
            String shortLeaveOutTime=rst.getString("shortLeaveOutTime");
            String shortLeaveInTime=rst.getString("shortLeaveInTime");
            String outTime=rst.getString("outTime");
            String OTHours=rst.getString("OTHours");
            
            attendanceList.add(new Attendance(employeeID, date, inTime, shortLeaveOutTime, shortLeaveInTime, outTime, OTHours));
         }
         return attendanceList;
    }
     
     public static ResultSet getAllDates() throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select year(date) as year from attendance group by year(date);");
         return stm.executeQuery();
     }
     
      public static int getOTHourCount(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement(" select sum(OTHours) as 'Total OTHours' from attendance  where date between ? and ? and employeeID=? group by employeeID");
         stm.setObject(1, fromDate);
         stm.setObject(2, toDate);
         stm.setObject(3, employeeID);
         ResultSet rst=stm.executeQuery();
         int hourCount=0;
         while(rst.next()){
             hourCount=rst.getInt(1);
         }
         return hourCount;
     }
      
      public static ResultSet viewAttendaceViaDate(String deptName, String date) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select employee.employeeID, gradeID, inTime, shortLeaveOutTime, shortLeaveInTime, outTime,OTHours from employee, attendance, department where department.departmentID=employee.departmentID and employee.employeeID=attendance.employeeID and name=? and date=?");
         stm.setObject(1, deptName);
         stm.setObject(2, date);
       
         return stm.executeQuery();
     }
}
   