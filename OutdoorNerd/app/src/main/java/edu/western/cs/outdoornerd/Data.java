package edu.western.cs.outdoornerd;

import android.content.Context;
import android.view.Gravity;
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
    static ArrayList<Data> collectiveDataObject = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();
    static HashMap<String, Data> hm = new HashMap<>();
    public Data(String name) {
        this.name = name;
        collectiveDataObject.add(this);
        ResultActivity.listviewItems.add(name);
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
}
