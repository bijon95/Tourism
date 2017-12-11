package com.example.ayon.projetfile1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ayon on 9/14/2017.
 */

public class OfflineListView extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] videoName;
    private final Integer[] imgID;


    public OfflineListView(Activity context, Integer[] imageID, String[] name ) {
        super(context, R.layout.videoitem, name);
        this.context = context;
        this.videoName = name;
        this.imgID = imageID;
    }


    public View getView(int position, View view, ViewGroup viewGroup){

        LayoutInflater inflater = context.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.videoitem,null,true);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.videoImg);
        TextView tv = (TextView) itemView.findViewById(R.id.tvVideo);
        imageView.setImageResource(imgID[position]);
        tv.setText(videoName[position]);

        return itemView;

    }
}