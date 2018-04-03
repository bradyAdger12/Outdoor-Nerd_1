package edu.western.cs.outdoornerd;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TheOr on 4/2/2018.
 */

public class Table {
    String tName;
    Context c;
    static int colorChange = 0;
    LinearLayout titleLayout;
    LinearLayout content;
    LinearLayout linearLayout;
    LinearLayout dateLayout;
    TextView dateView;
    String date;
    public Table(String tName,LinearLayout dateLayout, LinearLayout titleLayout, LinearLayout content, Context c) {
        this.tName = tName;  //TextView Name/Id
        this.c = c;
        this.titleLayout = titleLayout;
        this.dateLayout = dateLayout;
        this.content = content;

        Log.d("ddd", Integer.toString(colorChange));


        //instantiate titleName and linearLayout body
        TextView tableName = new TextView(c);
        linearLayout = new LinearLayout(c);

        //change every other columns color
        if(colorChange % 2 == 0) {
            linearLayout.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
            tableName.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
        }
        else {
            linearLayout.setBackgroundColor(c.getResources().getColor(R.color.colorPrimaryDark));
            tableName.setBackgroundColor(c.getResources().getColor(R.color.colorPrimaryDark));

        }

        //Generate LinearLayout
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        content.addView(linearLayout, params2);

        //Generate TextView
        tableName.setText(tName);
        tableName.setTextSize(25);
        tableName.setPadding(0, 8, 0, 0);
        tableName.setGravity(Gravity.CENTER);
        tableName.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        titleLayout.addView(tableName, params);

        colorChange++;
    }

    public int getColor() {
        return colorChange;
    }

    public void addResult(String d, String t) {

        //add date table
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
        dateView.setText(d);
        dateLayout.addView(dateView);


        //add queried text view
        TextView r = new TextView(c);
        r.setText(t);
        r.setTextSize(20);
        r.setPadding(0, 50, 0, 0);
        r.setTextColor(c.getResources().getColor(R.color.Black));
        r.setGravity(Gravity.CENTER);
        linearLayout.addView(r);

    }
}
