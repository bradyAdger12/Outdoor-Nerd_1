package edu.western.cs.outdoornerd;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

import edu.western.cs.outdoornerd.models.DataW;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class ResultActivity extends AppCompatActivity {
    static ListView lv;
    static int num;
    static LinearLayout titleBar;
    static LinearLayout dateLayout;
    LinearLayout queryLayout;
    LinearLayout rPage;
    TextView queryTitle;
    TextView r;
    TextView timeTitle;
    static List<Data> listviewItems;
    CustomAdapter customAdapter;
    ArrayList<String[]> items = new ArrayList<>();
    static ArrayList<TextView> tv = new ArrayList<>();
    static Context c;
    public Realm realm;
    public RealmQuery<DataW> mResults;
    public String triplet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = new Intent();
        triplet = intent.getStringExtra("triplet");

        realm = Realm.getDefaultInstance();


        mResults = realm.where(DataW.class).contains("triplet", triplet);

        Log.d("ooo", String.valueOf(mResults.average("temp")));

        //set context
        c = this;


        //ListView Array
        listviewItems = new ArrayList<>();
        queryTitle = findViewById(R.id.queryTitle);


        //Layouts
        titleBar = findViewById(R.id.titleBar);
        dateLayout = findViewById(R.id.Date_Layout);
        rPage = findViewById(R.id.resultPage);
        queryLayout = findViewById(R.id.queryLayout);

        //TextView
        timeTitle = findViewById(R.id.timeTitle);


        //set up ListView
        lv = findViewById(R.id.queryListView);
        lv.setBackgroundColor(getResources().getColor(R.color.White));
        customAdapter = new CustomAdapter(this,listviewItems);
        lv.setAdapter(customAdapter);

        //build data set and display in query
        queryData();


        //generate dummy textviews for query table and add dates
        for(int i = 0; i < num; i++) {
            addData("42F");
            new DateTime("1", "15", "1995", Integer.toString(i + 1), this);
        }


         timeTitle.setText("TIME" + "\n" + DateTime.dateList.get(0).toString() + " - " + DateTime.dateList.get(DateTime.dateList.size()-1).toString());

        //Set initial textviews to invisible
        for(TextView v: tv) {
            v.setVisibility(View.INVISIBLE);
        }

        //add icons to listview for each item and set to visible
        Data.hm.get("Temp").setDrawable(R.drawable.thermometer);
        Data.hm.get("Snow Depth").setDrawable(R.drawable.snowflake);
        Data.hm.get("Rain").setDrawable(R.drawable.weather_pouring);
        Data.hm.get("Soil Depth").setDrawable(R.drawable.earth);
        Data.hm.get("Stream Vol").setDrawable(R.drawable.water);
        Data.hm.get("Humidity").setDrawable(R.drawable.water_percent);

        //ListView Click Listener
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Data item = (Data) lv.getItemAtPosition(position);
                Log.d("ddd", item.getName());
                Data data = item;
                changeTitle(data.getName().toUpperCase() + "(" + data.getMeasurement() + ")");    //change title to queried item

                for(int i = 0; i < num; i++) {
                    tv.get(i).setText(data.data.get(i));  //access all textViews in query column and set text to queried items data
                }
                for(String s: data.data) {
                 Log.d("ddd", s);}

                for(TextView v: tv) {     //change TextViews to Visible
                    v.setVisibility(View.VISIBLE);
                }

                //Log.d("ddd", Integer.toString(tv.size()) + "\n" + Integer.toString(num)); //Used to find difference of textview list and num.*
            }
        });




        }


    @Override
    public void onPause() {
        super.onPause();
        tv.clear();
        Log.d("ddd", "App Paused..");
    }
    //fill date layout with queried dates



    public void addData(String v) {

        //Add Values
        r = new TextView(this);
        r.setText(v);
        r.setTextSize(25);
        r.setPadding(0, 50, 0, 0);
        r.setTextColor(getResources().getColor(R.color.Black));
        r.setGravity(Gravity.CENTER);
        queryLayout.addView(r);
        tv.add(r);

    }

    public void changeTitle(String t) {

        queryTitle.setText(t);
    }

    public void queryData() {

        String temps[] = {"Temp", (char) 0x00B0 + "F", "20", "21", "18", "20", "20", "19", "21", "21", "22"};
        String rain[] = {"Rain", "L", "6", "2", "4", "2", "2", "N/A", "1", "2", "2"};
        String snow[] = {"Snow Depth", "m", "4", "8", "6", "3", "N/A", "1", "7", "6", "7"};
        String hum[] = {"Humidity", "%", "50", "51", "50", "50", "45", "52", "52", "51", "51"};
        String soil[] = {"Soil Depth", "m", "5", "5", "5", "5", "5", "5", "5", "5", "5"};
        String stream[] = {"Stream Vol", "L", "400", "400", "400", "400", "400", "400", "400", "400", "400"};

        items.add(temps);
        items.add(rain);
        items.add(snow);
        items.add(hum);
        items.add(soil);
        items.add(stream);

        num = temps.length - 2;


        for(String[] s: items) {
            Data c = new Data(s[0], s[1]);
            Data.hm.get(c.getName()).compileData(num, Arrays.copyOfRange(s, 2, s.length));
        }

    }

    }


