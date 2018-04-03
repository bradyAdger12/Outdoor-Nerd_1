package edu.western.cs.outdoornerd;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static edu.western.cs.outdoornerd.Table.hMap;
import static edu.western.cs.outdoornerd.Table.tNameList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //Layouts
        LinearLayout titleBar = findViewById(R.id.titleBar);
        LinearLayout qTable = findViewById(R.id.queryTables);
        LinearLayout dateLayout = findViewById(R.id.Date_Layout);



        //This is how to enter data. Date, Table Name, Date Layout, Title Layout, Results layout, Context.
        Table t1 = new Table("1/15/1995", dateLayout, titleBar, qTable,this);
        Table t2 = new Table("6/5/1997", dateLayout, titleBar, qTable, this);
        Table t3 = new Table("4/7/1962", dateLayout, titleBar, qTable, this);
        Table t4 = new Table("6/23/1984", dateLayout, titleBar, qTable, this);
        Table t5 = new Table("1/7/1954", dateLayout, titleBar, qTable, this);
        Table t6 = new Table("6/23/1984", dateLayout, titleBar, qTable, this);
        Table t7 = new Table("3/8/1971", dateLayout, titleBar, qTable, this);
        Table t8 = new Table("12/7/1964", dateLayout, titleBar, qTable, this);
        Table t9 = new Table("2/12/1984", dateLayout, titleBar, qTable, this);
        Table t10 = new Table("4/20/1969", dateLayout, titleBar, qTable, this);
        //this is how to add data to a particular table. Needs Work to add multiple queries.
        t1.addResult("Temp", "19F");
        t1.addResult("Wind", "N/A");
        t2.addResult("Temp", "24F");
        t2.addResult("Wind", "N/A");
        t3.addResult("Temp", "23F");
        t3.addResult("Wind", "N/A");
        t4.addResult("Temp", "23F");
        t4.addResult("Wind", "16mph");
        t5.addResult("Temp", "23F");
        t5.addResult("Wind", "18mph");
        t6.addResult("Temp", "23F");
        t6.addResult("Wind", "N/A");
        t7.addResult("Temp", "N/A");
        t7.addResult("Wind", "18mph");
        t8.addResult("Temp", "N/A");
        t8.addResult("Wind", "N/A");
        t9.addResult("Temp", "18F");
        t9.addResult("Wind", "18mph");
        t10.addResult("Temp", "32F");
        t10.addResult("Wind", "18mph");










    }
    @Override
    public void onResume() {
        super.onResume();
        hMap.clear();
        tNameList.clear();



    }

}
