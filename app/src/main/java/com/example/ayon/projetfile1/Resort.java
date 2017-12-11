package com.example.ayon.projetfile1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Resort extends android.support.v4.app.Fragment {

    String [] videoName={"Dhaka",
            "Chittagong",
            "Sylhet",
            "Khulna",
            "Rajshahi",
            "Barisal",
            "Rangpur",
            "Mymensing"};
    Integer [] img = {R.drawable.y1, R.drawable.y2,R.drawable.y3,R.drawable.y4, R.drawable.y5,R.drawable.y6,R.drawable.y7,R.drawable.y8};
    String[] link = {"www.tripadvisor.co.uk/Hotels-g293936-Dhaka_City_Dhaka_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667480-Chittagong_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667997-Sylhet_City_Sylhet_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667481-Khulna_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667998-Rajshahi_City_Rajshahi_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667461-Barisal_City_Barisal_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g667999-Rangpur_Rajshahi_Division-Hotels.html",
            "www.tripadvisor.co.uk/Hotels-g668002-Mymensing_Dhaka_Division-Hotels.html"};
    public Resort() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_video, container, false);
        ListView lv = (ListView) view.findViewById(R.id.listview);
        OfflineListView addapter = new OfflineListView(getActivity(),img,videoName);
        lv.setAdapter(addapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent inte = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+link[position]));
                startActivity(inte);
            }
        });
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
