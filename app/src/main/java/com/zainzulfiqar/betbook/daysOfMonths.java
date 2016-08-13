package com.zainzulfiqar.betbook;

/**
 * Created by zain on 8/13/16.
 */
public class daysOfMonths {
    public int days (String month) {
        switch (month) {
            case "January":
                return 31;
            case "February":
                return 29;
            case "March":
                return 31;
            case "April":
                return 30;
            case "May":
                return 31;
            case "June":
                return 30;
            case "July":
                return 31;
            case "August":
                return 31;
            case "September":
                return 30;
            case "October":
                return 31;
            case "November":
                return 30;
            default:
                return 31;
        }
    }
}
