package edu.western.cs.outdoornerd;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by TheOr on 4/2/2018.
 */

public class Wind {
    String speed;
    TextView windView;
    Context context;
    public Wind(String speed, Context c) {
        this.speed = speed;
        windView = new TextView(c.getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        windView.setTextColor(c.getResources().getColor(R.color.Black));
        windView.setTextSize(20);
        windView.setPadding(0,50,0,0);
        windView.setLayoutParams(lp);
        windView.setAllCaps(true);

        windView.setGravity(Gravity.CENTER);
        windView.setText(speed + "mph");

    }

    public TextView getWindView() {
        return windView;
    }
}
