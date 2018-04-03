package edu.western.cs.outdoornerd;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.xml.transform.Result;

/**
 * Created by TheOr on 4/1/2018.
 */

public class Date {
    String date;
    TextView dateView;
    Context context;
    public Date(String date, Context c) {
        this.date = date;
        dateView = new TextView(c.getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        dateView.setTextColor(c.getResources().getColor(R.color.Black));
        dateView.setTextSize(20);
        dateView.setPadding(0,50,0,0);
        dateView.setLayoutParams(lp);
        dateView.setAllCaps(true);

        dateView.setGravity(Gravity.CENTER);
        dateView.setText(date);

    }

    public TextView getDateView() {
        return dateView;
    }
}
