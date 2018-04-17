package edu.western.cs.outdoornerd;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheOr on 4/9/2018.
 */

public class CustomAdapter extends ArrayAdapter<Data> {

    private Context mContext;
    private List<Data> itemList;

    public CustomAdapter(Context context,  List<Data> list) {
        super(context, 0, list);
        mContext = context;
        itemList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.textvlayout,parent,false);

        if (position == mSelectedItem) {
            listItem.setBackgroundColor(getContext().getResources().getColor(R.color.appMain));

        }

            TextView name = listItem.findViewById(R.id.nameText);
            name.setText(itemList.get(position).getName());
            ImageView img = listItem.findViewById(R.id.imgIcon);
            itemList.get(position).setImage(img,itemList.get(position).getDrawable());
/*
        if (position % 2 == 1) {
            listItem.setBackgroundColor(getContext().getResources().getColor(R.color.appSecondary));
        } else {
            listItem.setBackgroundColor(getContext().getResources().getColor(R.color.White));
        }

*/


        return listItem;
    }

}
