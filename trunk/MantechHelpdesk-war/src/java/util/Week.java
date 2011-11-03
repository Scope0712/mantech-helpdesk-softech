/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tuyenbui
 */
public class Week {
    public static Date getWeekStartDate(Date date) {

        Calendar calendar = Calendar.getInstance();        
        int dw = date.getDay();
        if (dw == 0) {
            dw = 7; //sunday is 7
        }
        calendar.add(Calendar.DATE, -(dw - 1));
        Date weekStartDate = calendar.getTime();
        return weekStartDate;
    }

    public static Date getWeekEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();        
        int dw = date.getDay();
        if (dw == 0) {
            dw = 7; //sunday is 7
        }
        calendar.add(Calendar.DATE, 7 - dw);
        Date weekEndDate = calendar.getTime();
        return weekEndDate;
    }
}
