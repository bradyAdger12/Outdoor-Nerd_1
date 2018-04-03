package edu.western.cs.outdoornerd;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by TheOr on 4/2/2018.
 */

public class Table {
    String tName;
    Context c;
    static int colorChange = 0;
    LinearLayout titleLayout;
    LinearLayout content;
    LinearLayout dateLayout;
    TextView dateView;
    static HashMap<String, LinearLayout> hMap = new HashMap<>();
    static ArrayList<String> tNameList = new ArrayList<>();
    String date;
    public Table(String date,  LinearLayout dateLayout, LinearLayout titleLayout, LinearLayout content, Context c) {
        this.tName = tName;  //TextView Name/Id
        this.c = c;
        this.date = date;
        this.titleLayout = titleLayout;
        this.dateLayout = dateLayout;
        this.content = content;

        Log.d("ddd", Integer.toString(colorChange));


        //add Date table
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
        dateLayout.addView(dateView);


    }



    public int getColor() {
        return colorChange;
    }

    public void addResult(String tName, String s) {


        TextView tableName = new TextView(c);
        LinearLayout linearLayout = new LinearLayout(c);
        tName = tName.toUpperCase();


        if (!tNameList.contains(tName)) {
            tNameList.add(tName);
            hMap.put(tName, linearLayout);

            //change every other columns color
            if (colorChange % 2 == 0) {
                linearLayout.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
                tableName.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
            } else {
                linearLayout.setBackgroundColor(c.getResources().getColor(R.color.colorPrimaryDark));
                tableName.setBackgroundColor(c.getResources().getColor(R.color.colorPrimaryDark));

            }

            ///Generate LinearLayout
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            content.addView(linearLayout, params2);


            //Generate title TextView
            tableName.setText(tName);
            tableName.setTextSize(25);
            tableName.setGravity(Gravity.CENTER);
            tableName.setBackground(ContextCompat.getDrawable(c, R.drawable.border));
            tableName.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            titleLayout.addView(tableName, params);

            TextView r = new TextView(c);
            r.setText(s);
            r.setTextSize(15);
            r.setPadding(0, 50, 0, 0);
            r.setTextColor(c.getResources().getColor(R.color.Black));
            r.setGravity(Gravity.CENTER);
            linearLayout.addView(r);

        } else {
            TextView r = new TextView(c);
            r.setText(s);
            r.setTextSize(15);
            r.setPadding(0, 50, 0, 0);
            r.setTextColor(c.getResources().getColor(R.color.Black));
            r.setGravity(Gravity.CENTER);
            hMap.get(tName).addView(r);
        }


        colorChange++;
    }


}
