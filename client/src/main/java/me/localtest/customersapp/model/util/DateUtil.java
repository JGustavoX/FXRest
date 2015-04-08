package me.localtest.customersapp.model.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gus Garsaky
 */
public class DateUtil {
    
    public static Date toDate(String format, String date) {
        Date newDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat(format);
            newDate = formatter.parse(date);
        } catch(ParseException e) {
            e.getMessage();
        }
        return newDate;
    }
    public static String toString(String format, Date date) {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    public static Date format(String format, Date date) {
        Date newDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat(format);
            String strDate = formatter.format(date);
            newDate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.getMessage();
        }
        return newDate;
    }
}
