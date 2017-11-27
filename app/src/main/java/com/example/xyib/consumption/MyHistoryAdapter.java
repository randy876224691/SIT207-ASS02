/*

 NAME: Yibing XIE
 ID: 214049532
 for listview of history page.
 customer view adapter

*/


package com.example.xyib.consumption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by randy-mac on 15/10/2.
 */
public class MyHistoryAdapter extends ArrayAdapter {


    private final Context context;
    private final List<String> value5;
    private final List<String> value6;

    // Constructor which is called when the custom adapter is created
    public MyHistoryAdapter(Context context, List<String> value5, List<String> value6) {
        // Select the layout for the cell
        super(context, R.layout.list_history, value5);
        this.context = context;
        this.value5 = value5;
        this.value6 = value6;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        //invoke score_list layout

        View rowView = inflater.inflate(R.layout.list_history, parent, false);

        // Link the widgets on the layout with the Java codes
        TextView textView1= (TextView) rowView.findViewById(R.id.textView1);
        TextView textView2 = (TextView) rowView.findViewById(R.id.textView3);

        // Set the content of the text based on the values string in the main activity
        textView1.setText(value5.get(position));
        textView2.setText(value6.get(position));


        return rowView;
    }
}
