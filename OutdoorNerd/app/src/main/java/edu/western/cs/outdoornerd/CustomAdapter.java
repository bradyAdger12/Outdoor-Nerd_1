package edu.western.cs.outdoornerd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheOr on 4/9/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> itemList;

    public CustomAdapter(Context context,  List<String> list) {
        super(context, 0, list);
        mContext = context;
        itemList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.textvlayout,parent,false);

            TextView name = listItem.findViewById(R.id.nameText);
            name.setText(itemList.get(position));


        return listItem;
    }
}
