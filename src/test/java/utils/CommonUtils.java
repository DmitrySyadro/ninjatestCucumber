package utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class CommonUtils {
    public static String getEmailTimesStamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        return "Dmytro"+formatter.format(date)+"@gmail.com";


    }
    public static String name(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        return "Vasyl"+format(date)+"Petro";

    }
}
