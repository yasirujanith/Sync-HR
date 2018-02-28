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
import payrollsystemnew.model.Department;

/**
 *
 * @author User
 */
public class DepartmentController {
    public static int addDepartment(Department dept) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into department values(?,?,0)");
        stm.setObject(1, dept.getDepartmentID());
        stm.setObject(2, dept.getName());
        return stm.executeUpdate();
    }
    
    public static Department searchDepartment(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from department where departmentID=?");
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        Department dept=null;
        if(rst.next()){
            String name=rst.getString("name");
          
            int numOfEmployees=rst.getInt("numOfEmployees");
            dept=new Department(id,name,numOfEmployees);
        }
        return dept;
    }
    
    public static Department searchDepartmentByName(String name) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from department where name=?");
        stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        Department dept=null;
        if(rst.next()){
            String id=rst.getString("departmentID");
            int numOfEmployees=rst.getInt("numOfEmployees");
            dept=new Department(id,name,numOfEmployees);
        }
        return dept;
    }
    
    public static int updateDepartment(Department dept) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update department set name=?,numOfEmployees=? where departmentID=?");
        stm.setObject(3, dept.getDepartmentID() );
        stm.setObject(1, dept.getName());
        stm.setObject(2, dept.getNumOfEmployees());
        return stm.executeUpdate();
    }
    
     public static int deleteDepartment(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("delete from department where departmentID=?");
        stm.setObject(1, id);
        return stm.executeUpdate();
    }
    
     public static ArrayList<Department> getAllDepartments() throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from department");
         ResultSet rst=stm.executeQuery();
         ArrayList<Department> deptList=new ArrayList();
        
         while(rst.next()){
             deptList.add(new Department(rst.getString("departmentID"),rst.getString("name"),rst.getInt("numOfEmployees")));
         }
         return deptList;
     }
     
     public static String getDepartmentID(String departmentName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from department where name=?");
        stm.setObject(1, departmentName);
        ResultSet rst= stm.executeQuery();
        String deptID="";
        while(rst.next()){
            deptID=rst.getString("departmentID");
        }
        return deptID;
    }
}
