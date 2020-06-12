package T2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat =new SimpleDateFormat("Gyyyy年MM月dd日 EEEE");
        Calendar a =Calendar.getInstance();
        a.set(2018,3,1);
        Date b =a.getTime();
        dateFormat.format(b);
        System.out.println(dateFormat.format(b));
    }
}
