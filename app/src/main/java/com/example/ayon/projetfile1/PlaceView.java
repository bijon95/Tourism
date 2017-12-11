package com.example.ayon.projetfile1;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaceView extends AppCompatActivity {

    TextView dist, place,image,details,latutide,langtitude;
    String mapdata;

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);

        dist = (TextView) findViewById(R.id.distTVitm) ;
        place =(TextView) findViewById(R.id.placeTVitm);
        details = (TextView) findViewById(R.id.detailsTVitm);
        latutide=(TextView) findViewById(R.id.latuTVitm);
        langtitude = (TextView) findViewById(R.id.longTVitm);

         webView = (WebView) findViewById(R.id.webView);


        webView.loadUrl(getIntent().getStringExtra("imageurl"));
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);


        dist.setText( getIntent().getStringExtra("dist"));
     place.setText( getIntent().getStringExtra("place"));
        details.setText( getIntent().getStringExtra("details"));
       // latutide.setText( getIntent().getStringExtra("latitude"));
        //langtitude.setText( getIntent().getStringExtra("longtude"));

        mapdata=getIntent().getStringExtra("latitude")+","+getIntent().getStringExtra("longtude");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.placemenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+mapdata));
            i.setClassName("com.google.android.apps.maps",
                    "com.google.android.maps.MapsActivity");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
