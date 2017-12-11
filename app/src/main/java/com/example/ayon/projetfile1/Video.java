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

public class Video extends android.support.v4.app.Fragment {

String [] videoName={"Beautiful Bangladesh - Land Of Stories",
        "Travel in Beautiful Bangladesh: Land of Stories & Rivers",
        "All About Sylhet",
        "Beautiful Bangladesh Land Of Stories and Land Of Rivers",
        "Visit Bangladesh - Life Happens Here",
        "Discover Bangladesh: Quick Tour into the Sundarbans",
        "Beautiful Bangladesh - School of life",
        "Bangladesh tourism....an overview of Bangladesh",
        "Cox's Bazar",
        "Top 10 Places To Visit In Bangladesh",
        "Ratargul Swamp Forest & Bisnakandi",
        "Travel to Barisal Floating Market"};
    Integer [] img = {R.drawable.y1, R.drawable.y2,R.drawable.y3,R.drawable.y4, R.drawable.y5,R.drawable.y6,R.drawable.y7,R.drawable.y8,R.drawable.y9,R.drawable.y10,R.drawable.y11,R.drawable.y12};
    String[] link = {"QNUSIOMb6vI","LqmratdBFNw","OQejR42TAyw&feature=youtu.be","E2_iSXGv0Ww&feature=youtu.be","2hgJs1vlqYs&feature=youtu.be",
            "Fj-AOewfUeM&feature=youtu.be","8sQd4f76iF0&feature=youtu.be","MlH44TZyp_Q&feature=youtu.be","TV3UyYxFBCg",
            "doDouRq7uFA&feature=youtu.be","bUHyfDrgpm4","zrL7U0pDbnY"};
    public Video() {
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
                Intent inte = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+link[position]));
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
