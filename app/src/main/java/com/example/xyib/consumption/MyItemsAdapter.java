/*

 NAME: Yibing XIE
 ID: 214049532
 for listview of record page.
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
public class MyItemsAdapter extends ArrayAdapter {


    private final Context context;
    private final List<String> value11;
    private final List<String> value12;
    private final List<String> value13;
    private final List<String> value14;
    public String a;
    public int b;

    // Constructor which is called when the custom adapter is created
    public MyItemsAdapter(Context context, List<String> value1, List<String> value2, List<String> value3, List<String> value4) {
        // Select the layout for the cell
        super(context, R.layout.list_record, value1);
        this.context = context;
        this.value11 = value1;
        this.value12 = value2;
        this.value13 = value3;
        this.value14 = value4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //invoke score_list layout

        View rowView = inflater.inflate(R.layout.list_record, parent, false);

        // Link the widgets on the layout with the Java codes
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView textView11= (TextView) rowView.findViewById(R.id.textView1);
        TextView textView12 = (TextView) rowView.findViewById(R.id.textView2);
        TextView textView13 = (TextView) rowView.findViewById(R.id.textView3);
        a = value11.get(position);
        if (a.equals("Swimming"))
        {
            b = R.mipmap.sporticonswimming;
        }
        else if (a.equals("Running"))
        {
            b = R.mipmap.sporticonrunning;
        }
        else if (a.equals("Skipping"))
        {
            b = R.mipmap.sporticonskipping;
        }
        else if (a.equals("Cycle"))
        {
            b = R.mipmap.sporticoncycle;
        }
        else if (a.equals("Walking"))
        {
            b = R.mipmap.sporticonwalk;
        }
        else if (a.equals("Daily"))
        {
            b = R.mipmap.sporticondaily;
        }

        // Set the content of the text based on the values string in the main activity
        imageView.setImageResource(b);
        textView11.setText(value11.get(position));
        textView12.setText(value12.get(position));
        textView13.setText(value13.get(position));



       /* switch (position){
            case 0:
                a = "Swimming";
                imageView.setImageResource(R.mipmap.sporticonswimming);
                break;
            case 1:
                a = "Running";
                imageView.setImageResource(R.mipmap.sporticonrunning);
                break;
            case 2:
                a = "Skipping";
                imageView.setImageResource(R.mipmap.sporticonskipping);
                break;
            case 3:
                a = "Cycle";
                imageView.setImageResource(R.mipmap.sporticoncycle);
                break;
            case 4:
                a = "Walking";
                imageView.setImageResource(R.mipmap.sporticonwalk);
                break;
            case 5:
                a = "Daily";
                imageView.setImageResource(R.mipmap.sporticondaily);
                break;
        }*/

        return rowView;
    }
}
