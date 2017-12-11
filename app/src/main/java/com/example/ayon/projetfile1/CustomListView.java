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
public class CustomListView extends ArrayAdapter<Product> {

    ArrayList<Product> products;
Context context;
    private int resource;

    public CustomListView(Context context, int resource , ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.itemview, null, true);

        }
        Product product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.with(context).load(product.getImage()).into(imageView);

        TextView imageurl = (TextView) convertView.findViewById(R.id.imageTv);
        imageurl.setText(product.getImage());

      imageurl.setVisibility(View.GONE);

        TextView dist = (TextView) convertView.findViewById(R.id.disttv);
        dist.setText(product.getDist());

        TextView place = (TextView) convertView.findViewById(R.id.placeTv);
        place.setText(product.getPlace());

        TextView details = (TextView) convertView.findViewById(R.id.details);
        details.setText(product.getDetails());
        details.setVisibility(View.INVISIBLE);
        details.setVisibility(View.GONE);

        TextView latitude = (TextView) convertView.findViewById(R.id.latitude);
        latitude.setText(product.getLatitude());

        latitude.setVisibility(View.INVISIBLE);
        latitude.setVisibility(View.GONE);

        TextView longitude = (TextView) convertView.findViewById(R.id.longitude);
        longitude.setText(product.getLongitude());
        longitude.setVisibility(View.INVISIBLE);
        longitude.setVisibility(View.GONE);

        return convertView;
    }
}