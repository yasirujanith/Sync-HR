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
import java.util.ArrayList;
import payrollsystemnew.dbconnection.DBConnection;
import payrollsystemnew.model.Employee;
import payrollsystemnew.model.LeaveCount;
import payrollsystemnew.model.Leaves;


/**
 *
 * @author User
 */
public class EmployeeController {
    public static int addEmployee(Employee emp) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)");
        stm.setObject(1,emp.getEmployeeID());
        stm.setObject(2,emp.getFirstName());
        stm.setObject(3,emp.getLastName());
        stm.setObject(4,emp.getNIC());
        stm.setObject(5,emp.getAddress());
        stm.setObject(6,emp.getDateOfBirth());
        stm.setObject(7,emp.getGender());
        stm.setObject(8,emp.getMaritalStatus());
        stm.setObject(9, emp.getContactNumber());
        stm.setObject(10,emp.getJoiningDate());
        stm.setObject(11,emp.getGradeID());
        stm.setObject(12,emp.getDepartmentID());
        
        return stm.executeUpdate();
    }
    
    public static Employee searchEmployee(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from employee where employeeID=?");
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        Employee employee=null;
        if(rst.next()){
            String employeeID=rst.getString("employeeID");
            String firstName=rst.getString("firstName");
            String lastName=rst.getString("lastName");
            String NIC=rst.getString("NIC");
            String address=rst.getString("address");
            String dateOfBirth=rst.getString("dateOfBirth");
            String gender=rst.getString("gender");
            String maritalStatus=rst.getString("maritalStatus");
            String contactNumber=rst.getString("contactNumber");
            String joiningDate=rst.getString("joiningDate");
            String gradeID=rst.getString("gradeID");
            String departmentID=rst.getString("departmentID");
            
            employee=new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID);
        }
        return employee;
    }
    
    public static Employee searchEmployeeByName(String firstName, String lastName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from employee where firstName=? and lastName=?");
        stm.setObject(1, firstName);
        stm.setObject(2, lastName);
        ResultSet rst=stm.executeQuery();
        Employee employee=null;
        if(rst.next()){
            String employeeID=rst.getString("employeeID");
            String NIC=rst.getString("NIC");
            String address=rst.getString("address");
            String dateOfBirth=rst.getString("dateOfBirth");
            String gender=rst.getString("gender");
            String maritalStatus=rst.getString("maritalStatus");
            String contactNumber=rst.getString("contactNumber");
            String joiningDate=rst.getString("joiningDate");
            String gradeID=rst.getString("gradeID");
            String departmentID=rst.getString("departmentID");
            
            employee=new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID);
        }
        return employee;
    }
    
     public static ArrayList<Employee> searchEmployeeByFirstName(String firstName) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from employee where firstName=?");
        stm.setObject(1, firstName);
        ResultSet rst=stm.executeQuery();
        ArrayList<Employee> employeeList=new ArrayList<>();
        while(rst.next()){
            String employeeID=rst.getString("employeeID");
            String lastName=rst.getString("lastName");
            String NIC=rst.getString("NIC");
            String address=rst.getString("address");
            String dateOfBirth=rst.getString("dateOfBirth");
            String gender=rst.getString("gender");
            String maritalStatus=rst.getString("maritalStatus");
            String contactNumber=rst.getString("contactNumber");
            String joiningDate=rst.getString("joiningDate");
            String gradeID=rst.getString("gradeID");
            String departmentID=rst.getString("departmentID");
            
            employeeList.add(new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID));
        }
        return employeeList;
    }
    
    public static int updateEmployee(Employee emp) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update employee set firstName=?,lastName=?,NIC=?,address=?,dateOfBirth=?,gender=?,maritalStatus=?,contactNumber=?,joiningDate=?,gradeID=?,departmentID=? where employeeID=?");
        stm.setObject(12,emp.getEmployeeID());
        stm.setObject(1,emp.getFirstName());
        stm.setObject(2,emp.getLastName());
        stm.setObject(3,emp.getNIC());
        stm.setObject(4,emp.getAddress());
        stm.setObject(5,emp.getDateOfBirth());
        stm.setObject(6,emp.getGender());
        stm.setObject(7,emp.getMaritalStatus());
        stm.setObject(8, emp.getContactNumber());
        stm.setObject(9,emp.getJoiningDate());
        stm.setObject(10,emp.getGradeID());
        stm.setObject(11,emp.getDepartmentID());
        return stm.executeUpdate();
    }
    
     public static int deleteEmployee(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("delete from employee where employeeID=?");
        stm.setObject(1, id);
        return stm.executeUpdate();
    }
     
    public static ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from employee");
         ResultSet rst=stm.executeQuery();
         ArrayList<Employee> employeeList=new ArrayList();
         while(rst.next()){
            String employeeID=rst.getString("employeeID");
            String firstName=rst.getString("firstName");
            String lastName=rst.getString("lastName");
            String NIC=rst.getString("NIC");
            String address=rst.getString("address");
            String dateOfBirth=rst.getString("dateOfBirth");
            String gender=rst.getString("gender");
            String maritalStatus=rst.getString("maritalStatus");
            String contactNumber=rst.getString("contactNumber");
            String joiningDate=rst.getString("joiningDate");
            String gradeID=rst.getString("gradeID");
            String departmentID=rst.getString("departmentID");
            
            employeeList.add(new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID));
         }
         return employeeList;
     }
    
    public static ArrayList<Employee> getAllEmployeesViaGrade(String gradeID) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from employee where gradeID=?");
         stm.setObject(1, gradeID);
         ResultSet rst=stm.executeQuery();
         ArrayList<Employee> employeeList=new ArrayList();
         while(rst.next()){
            String employeeID=rst.getString("employeeID");
            String firstName=rst.getString("firstName");
            String lastName=rst.getString("lastName");
            String NIC=rst.getString("NIC");
            String address=rst.getString("address");
            String dateOfBirth=rst.getString("dateOfBirth");
            String gender=rst.getString("gender");
            String maritalStatus=rst.getString("maritalStatus");
            String contactNumber=rst.getString("contactNumber");
            String joiningDate=rst.getString("joiningDate");
            String departmentID=rst.getString("departmentID");
            
            employeeList.add(new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID));
         }
         return employeeList;
     }
    
    public static ArrayList<Employee> getAllEmployeesViaDepartment(String departmentID) throws ClassNotFoundException, SQLException{
      Connection conn=DBConnection.getDBConnection().getConnection();
      PreparedStatement stm=conn.prepareStatement("select * from employee where departmentID=?");
      stm.setObject(1, departmentID);
      ResultSet rst=stm.executeQuery();
      ArrayList<Employee> employeeList=new ArrayList();
      while(rst.next()){
         String employeeID=rst.getString("employeeID");
         String firstName=rst.getString("firstName");
         String lastName=rst.getString("lastName");
         String NIC=rst.getString("NIC");
         String address=rst.getString("address");
         String dateOfBirth=rst.getString("dateOfBirth");
         String gender=rst.getString("gender");
         String maritalStatus=rst.getString("maritalStatus");
         String contactNumber=rst.getString("contactNumber");
         String joiningDate=rst.getString("joiningDate");
         String gradeID=rst.getString("gradeID");

         employeeList.add(new Employee(employeeID, firstName, lastName, NIC, address, contactNumber, dateOfBirth, gender, maritalStatus, joiningDate, gradeID, departmentID));
      }
      return employeeList;
    }
       
    public static int addLeaveDetail(Leaves leave) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("insert into leaves values(?,?,?,?)");
         stm.setObject(1,leave.getEmployeeID());
         stm.setObject(2,leave.getDate());
         stm.setObject(3,leave.getLeaveType());
         stm.setObject(4,leave.getReason());

         return stm.executeUpdate();
     }
    
    public static int updateShortLeaveDetail(String employeeID, String date) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("update leaves set leaveType=?, reason=? where employeeID=? and date=?");
         stm.setObject(3,employeeID);
         stm.setObject(4,date);
         stm.setObject(1,"Leave");
         stm.setObject(2,"Emergency Leave");
         
         return stm.executeUpdate();
     }
     
    public static LeaveCount getUsedLeaveCount(String employeeID, String year) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from leaves where employeeID=? and date like ?");
        stm.setObject(1, employeeID);
        stm.setObject(2, year+"%");
        ResultSet rst=stm.executeQuery();
        LeaveCount leaveCount=null;
        int noPay=0,halfDay=0;
        while(rst.next()){
            if("Leave".equals(rst.getString(3))){
                halfDay+=2;
            }else if("No Pay Leave".equals(rst.getString(3))){
                noPay++;
            }else{
                halfDay++;
            }
        }
        leaveCount=new LeaveCount(noPay, halfDay);
        return leaveCount;
    }
     
    public static LeaveCount getUsedLeaveCountInMonth(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from leaves where employeeID=? and date between ? and ?");
        stm.setObject(1, employeeID);
        stm.setObject(2, fromDate);
        stm.setObject(3, toDate);
        ResultSet rst=stm.executeQuery();
        LeaveCount leaveCount=null;
        int noPay=0,halfDay=0;
        while(rst.next()){
            if("Leave".equals(rst.getString(3))){
                halfDay+=2;
            }else if("No Pay Leave".equals(rst.getString(3))){
                noPay++;
            }else{
                halfDay++;
            }
        }
        leaveCount=new LeaveCount(noPay, halfDay);
        return leaveCount;
    }
    
    public static ArrayList<Leaves> getAllLeave(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from leaves where employeeID=? and date between ? and ?");
         stm.setObject(1, employeeID);
         stm.setObject(2, fromDate);
         stm.setObject(3, toDate);
         ResultSet rst=stm.executeQuery();
         ArrayList<Leaves> leavesList=new ArrayList();
         while(rst.next()){
            String date=rst.getString("date");
            String leaveType=rst.getString("leaveType");
            String reason=rst.getString("reason");
            leavesList.add(new Leaves(employeeID, date, leaveType, reason));
         }
         
         return leavesList;
    }
       
    public static ResultSet getAllEmployees_PaymentDetails(String employeeID) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select employee.employeeID,firstName,lastName,bankName,AccNumber,isCash,isCheque,isDeposit from employee, paymenttype where employee.employeeID=paymenttype.employeeID and employee.employeeID=?");
         stm.setObject(1, employeeID);
         return stm.executeQuery();
    }
    
    public static ResultSet getAllEmployees_GradeDetails(String employeeID) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select employeeID,basicSalary,OTRate from employee, grade where employee.gradeID=grade.gradeID and employee.employeeID=?");
         stm.setObject(1, employeeID);
         return stm.executeQuery();
    }
    
    public static boolean isThereLeave(String employeeID, String date) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from leaves where employeeID=? and date=? and leaveType=?");
         stm.setObject(1, employeeID);
         stm.setObject(2, date);
         stm.setObject(3, "Leave");
         
         ResultSet rst=stm.executeQuery();
         return rst.next();
     }
      
      public static boolean isThereHalfDayLeave(String employeeID, String date) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from leaves where employeeID=? and date=? and leaveType=?");
         stm.setObject(1, employeeID);
         stm.setObject(2, date);
         stm.setObject(3, "Half Day Leave");
         
         ResultSet rst=stm.executeQuery();
         return rst.next();
     }
}
