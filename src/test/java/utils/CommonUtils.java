package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static String getEmailTimesStamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        return "Dmytro"+formatter.format(date)+"@gmail.com";


    }
}
