package edu.western.cs.outdoornerd;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //Layouts
        LinearLayout titleBar = findViewById(R.id.titleBar);
        LinearLayout qTable = findViewById(R.id.queryTables);
        LinearLayout dateLayout = findViewById(R.id.Date_Layout);

        DummyAL dummyAL = new DummyAL();

        ArrayList<String> time =  dummyAL.getDummytime1();
        ArrayList<Integer> temperature = dummyAL.getDummytemp1();
        ArrayList<Integer> wind = dummyAL.getDummywind1();
        ArrayList<Integer> rain = dummyAL.getDummyrain1();

        Log.d("dummydata", String.valueOf(time.size()));


        DummyData dummyData = new DummyData(time, temperature, wind, rain);



        //This is how to enter data. Date, Table Name, Date Layout, Title Layout, Results layout, Context.
        Table t1 = new Table("Temp",dateLayout, titleBar, qTable,this);

        //this is how to add data to a particular table. Needs Work to add multiple queries.

        for (int i = 0; i < time.size(); i++){
            t1.addResult(time.get(i), String.valueOf(temperature.get(i)));
        }



        //t1.addResult("8/2/1799", "85F");









    }

}
