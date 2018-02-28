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
import payrollsystemnew.model.User;

/**
 *
 * @author User
 */
public class UserController {
    public static int addUser(User user) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into user values(?,?)");
        stm.setObject(1, user.getUserName());
        stm.setObject(2, user.getPassword());
        return stm.executeUpdate();
    }
    
    public static int changeUserPassword(User user) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update user set password=? where userName=?");
        stm.setObject(1, user.getPassword());
        stm.setObject(2, user.getUserName());
        return stm.executeUpdate();
    }
    
    public static boolean isUserPresent() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from user");
        ResultSet rst=stm.executeQuery();
        return rst.next();
    }
    
    public static boolean isUserNameExists(String userName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from user where userName=?");
        stm.setObject(1, userName);
        ResultSet rst=stm.executeQuery();
        return rst.next();
    }
    
    public static java.util.ArrayList<User> getAllUers() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from user");
        ResultSet rst=stm.executeQuery();
        java.util.ArrayList<User> userList=new java.util.ArrayList<>();
        while(rst.next()){
            userList.add(new User(rst.getString(1),rst.getString(2)));
        }
        return userList;
    }
    
    public static User searchUserByName(String userName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from user where userName=?");
        stm.setObject(1, userName);
        ResultSet rst=stm.executeQuery();
        User user=null;
        while(rst.next()){
            user=new User(rst.getString(1),rst.getString(2));
        }
        return user;
    }
    
    public static int userCount() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select count(userName) from user");
        ResultSet rst=stm.executeQuery();
        int count=0;
        while(rst.next()){
            count=rst.getInt(1);
        }
        return count;
    }
    
    public static int addUserLogin(String userName) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into userlogin values(?,?,?)");
        stm.setObject(1, userName);
        stm.setObject(2, null);
        stm.setObject(3, null);
        return stm.executeUpdate();
    }
    
    public static String getCurrentUser() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from userlogin");
        ResultSet rst=stm.executeQuery();
        String userName=null;
        while(rst.next()){
            if(rst.getString(2)!=null && rst.getString(3)==null){
                userName=rst.getString(1);
                break;
            }
        }
        return userName;
    }
    
    public static int userLogIn(String userName ,String logInTime) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update userlogin set logInTime=?, logOutTime=? where userName=?");
        stm.setObject(1, logInTime);
        stm.setObject(2, null);
        stm.setObject(3, userName);
        return stm.executeUpdate();
    }
    
     public static int userLogOut(String userName, String logOutTime) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update userlogin set logOutTime=? where userName=?");
        stm.setObject(1, logOutTime);
        stm.setObject(2, userName);
        return stm.executeUpdate();
    }
        
}

