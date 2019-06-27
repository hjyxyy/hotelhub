package com.harrywork.hotelhub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 10:10
 * Desc: DateUtil
 */
public class DateUtil {

    /**
     * @param checkin  YYYY-MM-DD
     * @param checkout YYYY-MM-DD
     * @return
     */
    public static Integer getLenthOfStay(String checkin, String checkout) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date day1 = format.parse(checkin);
        Date day2 = format.parse(checkout);

        return (int)((day2.getTime() - day1.getTime()) / (1000 * 3600 * 24));
    }

    public static void main(String[] args) {
        String checkin = "2019-06-27";
        String checkout = "2020-06-29";

        try {
            System.out.println(getLenthOfStay("2019-06-27","2019-06-29"));
            System.out.println(getLenthOfStay("2019-06-27","2019-06-25"));
            System.out.println(getLenthOfStay("2019-06-27","2020-06-29"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
