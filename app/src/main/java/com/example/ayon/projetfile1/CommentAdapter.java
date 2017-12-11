package com.example.ayon.projetfile1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Bj on 17-09-17.
 */

public class CommentAdapter extends ArrayAdapter<Product2> {

    ArrayList<Product2> products2;
    Context context;
    private int resource;

    public CommentAdapter(Context context, int resource , ArrayList<Product2> products2) {
        super(context, resource, products2);
        this.products2 = products2;
        this.context = context;
        this.resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cmtitm, null, true);

        }
        Product2 product2 = getItem(position);

        TextView tv1 = (TextView) convertView.findViewById(R.id.textView14);
tv1.setText(product2.getComment());
        TextView tv2 = (TextView) convertView.findViewById(R.id.textView15);
tv2.setText(product2.getLocation());
        TextView tv3 = (TextView) convertView.findViewById(R.id.textView16);
tv3.setText(product2.getName());

        return convertView;
    }
}