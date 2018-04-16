package edu.western.cs.outdoornerd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.western.cs.outdoornerd.models.DataW;
import io.realm.Realm;
import io.realm.RealmResults;


public class ResultActivity extends AppCompatActivity {
    static ListView lv;
    static int num;
    static LinearLayout titleBar;
    LinearLayout dateLayout;
    LinearLayout queryLayout;
    LinearLayout rPage;
    TextView queryTitle;
    TextView r;
    static List<String> listviewItems;
    CustomAdapter customAdapter;
    ArrayList<String[]> items = new ArrayList<>();
    static ArrayList<TextView> tv = new ArrayList<>();
    private RealmResults<DataW> realmResults;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        realm = Realm.getDefaultInstance();
        realmResults = realm.where(DataW.class).findAll();
        Log.d("MICA", realmResults.toString());



        //ListView Array
        listviewItems = new ArrayList<>();
        queryTitle = findViewById(R.id.queryTitle);


        //Layouts
        titleBar = findViewById(R.id.titleBar);
        dateLayout = findViewById(R.id.Date_Layout);
        rPage = findViewById(R.id.resultPage);
        queryLayout = findViewById(R.id.queryLayout);


        queryData();

        //set up ListView
        lv = findViewById(R.id.queryListView);
        lv.setBackgroundColor(getResources().getColor(R.color.White));
        customAdapter = new CustomAdapter(this,listviewItems);
        lv.setAdapter(customAdapter);




        //generate dummy data
        for(int i = 0; i < num; i++) {
            addData("42F");
            String date = "1/15/1995" + "\n" + (i + 1) + ":00";
            createDates(date);
        }


        //Set initial textviews to invisible
        for(TextView v: tv) {
            v.setVisibility(View.INVISIBLE);
        }

        //ListView Click Listener
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String item = (String) lv.getItemAtPosition(position);
                Log.d("ddd", item);
                changeTitle(item.toUpperCase());    //change title to queried item

                for(int i = 0; i < num; i++) {
                    tv.get(i).setText(Data.hm.get(item).data.get(i));  //access all textViews in query column and set text to queried items data

                }
                for(String s: Data.hm.get(item).data) {
                 Log.d("ddd", s);}

                for(TextView v: tv) {     //change TextViews to Visible
                    v.setVisibility(View.VISIBLE);
                }

                Log.d("ddd", Integer.toString(tv.size()) + "\n" + Integer.toString(num));

            }
        });

        }


    @Override
    public void onStop() {
        super.onStop();
        tv.clear();
        Log.d("ddd", "App Stopped..");
    }
    //fill date layout with queried dates


    public void createDates(String s) {
        TextView c = new TextView(this);
        c.setTextColor(getResources().getColor(R.color.Black));
        c.setTextSize(25);
        c.setPadding(0, 50, 0, 0);
        c.setGravity(Gravity.CENTER);
        c.setText(s);
        dateLayout.addView(c);

        }

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



        String temps[] = {"Temp", "20" + (char) 0x00B0 + "F", "21" + (char) 0x00B0 + "F", "18" + (char) 0x00B0 + "F", "20" + (char) 0x00B0 + "F", "20" + (char) 0x00B0 + "F", "19" + (char) 0x00B0 + "F", "21" + (char) 0x00B0 + "F"};
        String rain[] = {"Rain", "6in", "2in", "4in", "2in", "2in", "N/A", "1in"};
        String snow[] = {"Snow Depth", "4in", "8in", "6in", "3in", "N/A", "1in", "7in"};
        String hum[] = {"Humidity", "50%", "51%", "50%", "50%", "45%", "52%", "52%"};
        String soil[] = {"Soil Depth", "5ft", "5ft", "5ft", "5ft", "5ft", "5ft", "5ft"};
        String stream[] = {"Stream Vol", "400g", "400g", "400g", "400g ", "400g", "400g", "400g"};

        items.add(temps);
        items.add(rain);
        items.add(snow);
        items.add(hum);
        items.add(soil);
        items.add(stream);

        num = temps.length - 1;


        for(String[] s: items) {
            Data c = new Data(s[0]);
            Data.hm.get(c.getName()).compileData(num, Arrays.copyOfRange(s, 1, s.length));
        }

    }




    }


