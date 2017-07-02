package Pages;

import java.util.Calendar;

public class AbstractPage {

    public static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        String mon = String.valueOf(cal.get(Calendar.MONTH) + 1);
        String d = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        String h = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        String min = String.valueOf(cal.get(Calendar.MINUTE));
        String s = String.valueOf(cal.get(Calendar.SECOND));
        String y = String.valueOf(cal.get(Calendar.YEAR));
        return d + "-" + mon + "-" + h + "-" + min + "-" + s;
    }
}
