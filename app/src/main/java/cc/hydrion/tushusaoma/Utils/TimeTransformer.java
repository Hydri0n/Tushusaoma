package cc.hydrion.tushusaoma.Utils;

/**
 * Created by Hydrion on 2018/4/9.
 */

public class TimeTransformer {

    public static String transfrom1(String text){

        int hour;
        int day;
        int month;
        int year;
        int minute;

        String[] time = text.split(",|\\s|:");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        day = Integer.parseInt(time[2]);
        month = Integer.parseInt(time[3]);
        year = Integer.parseInt(time[4]);

        return hour + ":" + minute + "  " + year + "年" + month + "月" + day + "日";

    }
}

/*class Time{
    int hour;
    int day;
    int month;
    int year;

    public Time(int hour, int day, int month, int year) {
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}*/
