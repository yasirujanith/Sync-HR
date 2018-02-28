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
import payrollsystemnew.dbconnection.DBConnection;

/**
 *
 * @author User
 */
public class IDController {
    public static String getLastID(String tableName,String columnName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select "+columnName+" from "+tableName+" order by "+columnName+" desc limit 1");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            return rst.getString(columnName);
        }
        return null;
    } 
}
