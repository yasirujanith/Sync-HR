/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystemnew.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class GetDOBFromID {
    public static String getDOB(String NIC){
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd");
        String year=Integer.toString(1900+Integer.parseInt(NIC.substring(0, 2)));
        int dayOfYear=Integer.parseInt(NIC.substring(2, 5));
        if(dayOfYear>90){
            dayOfYear-=1;
        }
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        String month_date=dateFormat.format(calendar.getTime());
	return (year+"-"+month_date);
    }
}
