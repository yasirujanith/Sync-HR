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
import payrollsystemnew.model.Grade;

/**
 *
 * @author User
 */
public class GradeController {
    public static int addGrade(Grade grade) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into grade values(?,?,?,?,?,?,?,?,?,?)");
        stm.setObject(1, grade.getGradeID());
        stm.setObject(2, grade.getBasicSalary());
        stm.setObject(3, grade.getOTRate());
        stm.setObject(4, grade.getNoPayRate());
        stm.setObject(5, grade.getMaxLoanAmount());
        stm.setObject(6, grade.getVehicleAllowence());
        stm.setObject(7, grade.getTransportAmount());
        stm.setObject(8, grade.getLeavesCount());
        stm.setObject(9, grade.getNoPayLeaveCount());
        stm.setObject(10, grade.getHalfDayCount());
        return stm.executeUpdate();
    }
    
    public static Grade searchGrade(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from grade where gradeID=?");
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        Grade grade=null;
        if(rst.next()){
            double basicSalary=rst.getDouble("basicSalary");
            double otRate=rst.getDouble("OTRate");
            double noPayRate=rst.getDouble("noPayRate");
            double maxLoanAmt=rst.getDouble("maxLoanAmount");
            double vehicleAllowence=rst.getDouble("vehicleAllowence");
            double transportAmt=rst.getDouble("transportAmount");
            int leavesCount=rst.getInt("leavesCount");
            int noPayLeavesCount=rst.getInt("noPayLeavesCount");
            int halfDayCount=rst.getInt("halfDayCount");
            grade=new Grade(id,basicSalary, otRate, noPayRate, maxLoanAmt, vehicleAllowence, transportAmt, leavesCount, noPayLeavesCount, halfDayCount);
        }
        return grade;
    }
    
    public static int updateGrade(Grade grade) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update grade set basicSalary=?, OTRate=?,noPayRate=?,maxLoanAmount=?,vehicleAllowence=?,transportAmount=?,leavesCount=?,noPayLeavesCount=?,halfDayCount=? where gradeID=?");
        stm.setObject(10, grade.getGradeID());
        stm.setObject(1, grade.getBasicSalary());
        stm.setObject(2, grade.getOTRate());
        stm.setObject(3, grade.getNoPayRate());
        stm.setObject(4, grade.getMaxLoanAmount());
        stm.setObject(5, grade.getVehicleAllowence());
        stm.setObject(6, grade.getTransportAmount());
        stm.setObject(7, grade.getLeavesCount());
        stm.setObject(8, grade.getNoPayLeaveCount());
        stm.setObject(9, grade.getHalfDayCount());
        return stm.executeUpdate();
    }
    
     public static int deleteGrade(String id) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("delete from grade where gradeID=?");
        stm.setObject(1, id);
        return stm.executeUpdate();
    }
    
     public static ArrayList<Grade> getAllGrades() throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select * from grade");
         ResultSet rst=stm.executeQuery();
         ArrayList<Grade> gradeList=new ArrayList();
         while(rst.next()){
             gradeList.add(new Grade(rst.getString("gradeID"),rst.getDouble("basicSalary"),rst.getDouble("OTRate"),rst.getDouble("noPayRate"),rst.getDouble("maxLoanAmount"),rst.getDouble("vehicleAllowence"),rst.getDouble("transportAmount"),rst.getInt("leavesCount"),rst.getInt("noPayLeavesCount"),rst.getInt("halfDayCount")));
         }
         return gradeList;
     }
}
