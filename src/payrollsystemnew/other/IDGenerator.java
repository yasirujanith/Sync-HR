/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.other;

import java.sql.SQLException;
import payrollsystemnew.controller.IDController;

/**
 *
 * @author User
 */
public class IDGenerator {
    public static String getNewID(String tableName,String columnName,String prefix) throws ClassNotFoundException, SQLException{
        String lastID=IDController.getLastID(tableName, columnName);
        if(lastID!=null){
            int id=Integer.parseInt(lastID.split(prefix)[1]);
            id++;
            String formattedID = String.format("%03d", id);
            return prefix+formattedID;
            
        }else{
            return prefix+"001";
        }
    }
}
