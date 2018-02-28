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
import payrollsystemnew.model.Bonus;
import payrollsystemnew.model.Damage;
import payrollsystemnew.model.Loan;
import payrollsystemnew.model.LoanPayment;
import payrollsystemnew.model.PaymentType;
import payrollsystemnew.model.Salary;
import payrollsystemnew.model.SalaryAdvance;
import payrollsystemnew.model.SalaryPayment;

/**
 *
 * @author User
 */
public class PaymentController {
     public static int addSalaryAdvanceDetail(SalaryAdvance salaryAdvance) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into advancesalary values(?,?,?)");
        stm.setObject(1,salaryAdvance.getEmployeeID());
        stm.setObject(2,salaryAdvance.getDate());
        stm.setObject(3,salaryAdvance.getAmount());
       
        return stm.executeUpdate();
    }
     
     public static SalaryAdvance searchSalaryAdvanceDetail(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from advancesalary where employeeID=? and date between ? and ?");
        stm.setObject(1, employeeID);
        stm.setObject(2, fromDate);
        stm.setObject(3, toDate);
        ResultSet rst=stm.executeQuery();
        SalaryAdvance salaryAdvance=null;
        while(rst.next()){
            salaryAdvance=new SalaryAdvance(employeeID, rst.getString("date"), rst.getDouble("amount"));
        }
        return salaryAdvance;
    }
     
     public static ArrayList<SalaryAdvance> getAllSalaryAdvance(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from advancesalary where employeeID=?");
        stm.setObject(1, employeeID);
        ResultSet rst=stm.executeQuery();
        ArrayList<SalaryAdvance> salaryAdvanceList=new ArrayList();
        while(rst.next()){
            salaryAdvanceList.add(new SalaryAdvance(rst.getString(1), rst.getString(2), rst.getDouble(3)));
        }
        return salaryAdvanceList;
    }
     
     public static ArrayList<SalaryAdvance> gellAllSalaryAdvanceViaDate(String fromDate, String toDate) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from advancesalary where date between ? and ?");
        stm.setObject(1, fromDate);
        stm.setObject(2, toDate);
        ResultSet rst=stm.executeQuery();
        ArrayList<SalaryAdvance> salaryAdvanceList=new ArrayList();
        while(rst.next()){
            salaryAdvanceList.add(new SalaryAdvance(rst.getString(1), rst.getString(2), rst.getDouble(3)));
        }
        return salaryAdvanceList;
    }
     
     public static int addPaymentTypesDetail(PaymentType paymentType) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into paymenttype values(?,?,?,?,?,?)");
        stm.setObject(1,paymentType.getEmployeeID());
        stm.setObject(2,paymentType.isCash());
        stm.setObject(3,paymentType.isCheque());
        stm.setObject(4,paymentType.isDeposit());
        stm.setObject(5,paymentType.getBankName());
        stm.setObject(6,paymentType.getAccNumber());
        
        return stm.executeUpdate();
    }
     
     public static PaymentType getPaymentTypesDetail(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from paymenttype where employeeID=?");
        stm.setObject(1,employeeID);
        PaymentType paymentType=null;
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            boolean isCash=rst.getString("isCash").equals("1")?true:false;
            boolean isCheque=rst.getString("isCheque").equals("1")?true:false;
            boolean isDeposit=rst.getString("isDeposit").equals("1")?true:false;
            String bankName=rst.getString("bankName");
            String accNumber=rst.getString("accNumber");
            paymentType=new PaymentType(employeeID, isCash, isCheque, isDeposit, bankName, accNumber);
        }
        return paymentType;
     }
     
     public static int updatePaymenTypeDetail(PaymentType paymentType) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update paymenttype set isCash=?,isCheque=?,isDeposit=?,bankName=?,accNumber=? where employeeID=?");
        stm.setObject(6,paymentType.getEmployeeID());
        stm.setObject(1,paymentType.isCash());
        stm.setObject(2,paymentType.isCheque());
        stm.setObject(3,paymentType.isDeposit());
        stm.setObject(4,paymentType.getBankName());
        stm.setObject(5,paymentType.getAccNumber());
        return stm.executeUpdate();
    }
     
     public static int deletePaymenTypeDetail(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("delete from paymenttype where employeeID=?");
        stm.setObject(1,employeeID);
       
        return stm.executeUpdate();
    }
     
      public static boolean isInsentive(String employeeID, String fromDate, String toDate) throws ClassNotFoundException, SQLException{
         Connection conn=DBConnection.getDBConnection().getConnection();
         PreparedStatement stm=conn.prepareStatement("select count(employeeID) as count from attendance where date between ? and ? and employeeID=?");
         stm.setObject(1, fromDate);
         stm.setObject(2, toDate);
         stm.setObject(3, employeeID);
         ResultSet rst=stm.executeQuery();
         while(rst.next()){
             if(rst.getInt(1)>29)
                 return true;
         }
         return false;
    }
       public static int addBonus(Bonus bonus) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into bonus values(?,?,?,?,?)");
        stm.setObject(1,bonus.getEmployeeID());
        stm.setObject(2,bonus.getYear());
        stm.setObject(3,bonus.getMonth());
        stm.setObject(4,bonus.getType());
        stm.setObject(5,bonus.getAmount());
       
        return stm.executeUpdate();
    }
       
    public static Bonus searchBonus(String employeeID, String year, String month, String bonusType) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from bonus where employeeID=? and year=? and month=? and type=?");
        stm.setObject(1, employeeID);
        stm.setObject(2, year);
        stm.setObject(3, month);
        stm.setObject(4, bonusType);
        ResultSet rst=stm.executeQuery();
        Bonus bonus=null;
        while(rst.next()){
            bonus=new Bonus(employeeID, year, month, bonusType, rst.getDouble("amount"));
        }
        return bonus;
    }

    public static int addNewLoan(Loan loan) throws SQLException, ClassNotFoundException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into loan values(?,?,?,?,?,?,?,?,?)");
        stm.setObject(1,loan.getEmployeeID());
        stm.setObject(2,loan.getLoanID());
        stm.setObject(3,loan.getDate());
        stm.setObject(4,loan.getDescription());
        stm.setObject(5,loan.getAmount());
        stm.setObject(6,loan.getMonthlyIntallment());
        stm.setObject(7,loan.getInstallment());
        stm.setObject(8,loan.getDueDate());
        stm.setObject(9,loan.isPaymentOver());
        
        return stm.executeUpdate();
    }
    
     public static int markLoanPaymentOver(String loanID) throws SQLException, ClassNotFoundException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("update loan set isPaymentOver=true where loanID=?");
        stm.setObject(1, loanID);
        return stm.executeUpdate();
     }
    
    public static ArrayList<Loan> searchProcessingLoan(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from loan where employeeID=? and isPaymentOver=0");
        stm.setObject(1, employeeID);
        ResultSet rst=stm.executeQuery();
        ArrayList<Loan> loanList=new ArrayList();
        while(rst.next()){
            String loanID=rst.getString(2);
            String curDate=rst.getString(3);
            String description=rst.getString(4);
            double amount=rst.getDouble(5);
            double monthlyInstallment=rst.getDouble(6);
            int intallments=rst.getInt(7);
            String dueDate=rst.getString(8);
            boolean isPaymentOver=rst.getInt(9)==0?false:true;
            
            loanList.add(new Loan(employeeID, loanID, curDate, description, amount, monthlyInstallment, intallments, dueDate, isPaymentOver));
        }
        return loanList;
    }
    
    public static boolean isThereLoan(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from loan where employeeID=? and isPaymentOver=0");
        stm.setObject(1, employeeID);
        ResultSet rst=stm.executeQuery();
        return rst.next();
    }
    
    public static ArrayList<Loan> getAllLoans(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from loan where employeeID=?");
        stm.setObject(1, employeeID);
        ResultSet rst=stm.executeQuery();
        ArrayList<Loan> loanList=new ArrayList();
        while(rst.next()){
            String loanID=rst.getString(2);
            String curDate=rst.getString(3);
            String description=rst.getString(4);
            double amount=rst.getDouble(5);
            double monthlyInstallment=rst.getDouble(6);
            int intallments=rst.getInt(7);
            String dueDate=rst.getString(8);
            boolean isPaymentOver=rst.getInt(9)==0?false:true;
            
            loanList.add(new Loan(employeeID, loanID, curDate, description, amount, monthlyInstallment, intallments, dueDate, isPaymentOver));
        }
        return loanList;
    }
    
    public static ArrayList<Loan> gellAllLoansViaDate(String fromDate, String toDate) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from loan where date between ? and ?");
        stm.setObject(1, fromDate);
        stm.setObject(2, toDate);
        ResultSet rst=stm.executeQuery();
        ArrayList<Loan> loanList=new ArrayList();
        while(rst.next()){
            String employeeID=rst.getString(1);
            String loanID=rst.getString(2);
            String curDate=rst.getString(3);
            String description=rst.getString(4);
            double amount=rst.getDouble(5);
            double monthlyInstallment=rst.getDouble(6);
            int intallments=rst.getInt(7);
            String dueDate=rst.getString(8);
            boolean isPaymentOver=rst.getInt(9)==0?false:true;
            
            loanList.add(new Loan(employeeID, loanID, curDate, description, amount, monthlyInstallment, intallments, dueDate, isPaymentOver));
        }
        return loanList;
    }
    
     public static int loanPayment(LoanPayment loanPayment) throws SQLException, ClassNotFoundException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into loanpayment values(?,?,?)");
        stm.setObject(1,loanPayment.getLoanID());
        stm.setObject(2,loanPayment.getDate());
        stm.setObject(3,loanPayment.getAmount());
        
        return stm.executeUpdate();
    }
    
    public static double getPaidLoanAmount(String loanID) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select sum(amount) from loanpayment where loanID=? group by loanID;");
        stm.setObject(1, loanID);
        ResultSet rst=stm.executeQuery();
        double paidAmount=0;
        while(rst.next()){
            paidAmount=rst.getDouble(1);
        }
        return paidAmount;
    }
    
     public static int addDamage(Damage damage) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into damage values(?,?,?,?,?)");
        stm.setObject(1,damage.getDamageID());
        stm.setObject(2,damage.getEmployeeID());
        stm.setObject(3,damage.getDate());
        stm.setObject(4,damage.getDescription());
        stm.setObject(5,damage.getDamageCost());
       
        return stm.executeUpdate();
    }
     
     public static ArrayList<Damage> getDamages(String employeeID, String fromTime, String toTime) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from damage where employeeID=? and date between ? and ?");
        stm.setObject(1, employeeID);
        stm.setObject(2, fromTime);
        stm.setObject(3, toTime);
        
        ResultSet rst=stm.executeQuery();
        ArrayList<Damage> damageList=new ArrayList();
        while(rst.next()){
            damageList.add(new Damage(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return damageList;
    }
     
     public static ArrayList<Damage> getAllDamages(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from damage where employeeID=?");
        stm.setObject(1, employeeID);
        ResultSet rst=stm.executeQuery();
        ArrayList<Damage> damageList=new ArrayList();
        while(rst.next()){
            damageList.add(new Damage(rst.getString(1), rst.getString(3), rst.getString(2), rst.getString(4), rst.getDouble(5)));
        }
        return damageList;
    }

    public static int addSalary(Salary salary) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into salary values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stm.setObject(1,salary.getSalaryID());
        stm.setObject(2,salary.getEmployeeID());
        stm.setObject(3,salary.getBasicSalary());
        stm.setObject(4,salary.getOTEarning());
        stm.setObject(5,salary.getBonus());
        stm.setObject(6,salary.getStampFee());
        stm.setObject(7,salary.getTAX());
        stm.setObject(8,salary.getSalaryAdvance());
        stm.setObject(9,salary.getLoan());
        stm.setObject(10,salary.getNoPayLeaves());
        stm.setObject(11,salary.getHalfDay());
        stm.setObject(12,salary.getDamages());
        stm.setObject(13,salary.getEPF());
        stm.setObject(14,salary.getETF());
        return stm.executeUpdate();
    }
    
    public static int addSalaryPayment(SalaryPayment salaryPayment) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("insert into salarypayment values(?,?,?,?)");
        stm.setObject(1,salaryPayment.getSalaryID());
        stm.setObject(2,salaryPayment.getPaymentType());
        stm.setObject(3,salaryPayment.getDate());
        stm.setObject(4,salaryPayment.getNetSalary());
       
        return stm.executeUpdate();
    }

    public static SalaryPayment searchSalaryDetails(String salaryID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from salarypayment,salary where salary.salaryID=salarypayment.salaryID and employeeID=? and date=?");
        stm.setObject(1, salaryID);
        ResultSet rst=stm.executeQuery();
        SalaryPayment payment=null;
        while(rst.next()){
            payment=new SalaryPayment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
        }
        return payment;
    }
    
    public static ResultSet getEPF_ETFAmount(String employeeID) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select sum(EPF) as EPFCounnt, sum(ETF) as ETFCount from salary where employeeID=? group by employeeID;");
        stm.setObject(1, employeeID);
        return stm.executeQuery();
    }
     
    public static ResultSet getPaidSalaryDetailViaEmployee(String employeeID, String date) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from salarypayment,salary where salary.salaryID=salarypayment.salaryID and salary.employeeID=? and salarypayment.date=?");
        stm.setObject(1, employeeID);
        stm.setObject(2, date);
        return stm.executeQuery();
    }
    
    public static ResultSet getPaidSalaryDetailViaDate(String date) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement("select * from salarypayment,salary where salary.salaryID=salarypayment.salaryID and salarypayment.date=?");
        stm.setObject(1, date);
        return stm.executeQuery();
    }
}
