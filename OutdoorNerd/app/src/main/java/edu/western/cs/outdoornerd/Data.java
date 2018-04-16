package edu.western.cs.outdoornerd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.Result;

/**
 * Created by TheOr on 4/1/2018.
 */

public class Data {
    String name;
    String measurement;
    ImageView img;
    int pic;
    ArrayList<String> data = new ArrayList<>();
    static HashMap<String, Data> hm = new HashMap<>();
    public Data(String name, String measurement) {
        this.name = name;
        this.measurement = measurement;
        ResultActivity.listviewItems.add(this);
        hm.put(name, this);
    }

    public void compileData(int n, String[] d) {
        for(String s: d) {
            data.add(s + "\n");
        }
    }

    public ArrayList getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setImage(ImageView i, int d) {
         img = i;
         img.setVisibility(View.VISIBLE);
         img.setBackground(ResultActivity.c.getResources().getDrawable((d)));
    }

    public void setDrawable(int d) {
        pic = d;
    }

    public int getDrawable(){
        return pic;
    }





}
