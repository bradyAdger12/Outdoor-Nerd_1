package edu.western.cs.outdoornerd;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by TheOr on 4/11/2018.
 */

public class DateTime {
    String year;
    String month;
    String day;
    String hour;
    public static List<DateTime> dateList = new ArrayList<>();
    Context c;
    public DateTime(String month, String day, String year, String hour, Context c) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.c = c;
        dateList.add(this);
        TextView t = new TextView(c);
        t.setTextColor(c.getResources().getColor(R.color.Black));
        t.setTextSize(25);
        t.setPadding(0, 50, 0, 0);
        t.setGravity(Gravity.CENTER);
        t.setText(month + "/" + day + " " + hour + ":00" + "\n");
        ResultActivity.dateLayout.addView(t);
    }


    public String toString() {
        return month + "/" + day + "/" + year + " " + hour + ":00";
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
