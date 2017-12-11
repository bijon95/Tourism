package com.example.ayon.projetfile1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;


public class Dhaka extends AppCompatActivity {
    ListView listView;
    private String TAG = Dhaka.class.getSimpleName();
    private ProgressDialog pDialog, sendProcess;
    private ListView lv;
    TextView tvListItem;
    Button send;
    String dataurl;
    TextView dataTV, idtv;
    EditText msgEt;
    Integer intListCount;
    JSONArray contacts;
    ListAdapter adapter;
    JSONObject jsonObj;
    JSONObject c;



    ArrayList<Product> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);

        listView=(ListView) findViewById(R.id.dhakalistView);

        if(isNetworkAvailable()==false){
            Alert();
        }




        contactList = new ArrayList<>();
        dataurl=getIntent().getStringExtra("myData");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new GetContacts().execute("http://appsticit.com/myC/tour.php"+dataurl);
            }
        });
    }




    private class GetContacts extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return  readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try{
                JSONObject jsonObject= new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("server_response");

                for(int i = 0; i<jsonArray.length();i++){
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    contactList.add(new Product(
                            productObject.getString("Dist"),
                            productObject.getString("Place"),
                            productObject.getString("Image"),
                            productObject.getString("Details"),
                            productObject.getString("Latitude"),
                            productObject.getString("Langitude")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final CustomListView adapter = new CustomListView(
                    getApplicationContext(),R.layout.itemview,contactList);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String dist = ((TextView) view.findViewById(R.id.disttv)).getText().toString();
                    String place = ((TextView) view.findViewById(R.id.placeTv)).getText().toString();
                    String image = ((TextView) view.findViewById(R.id.imageTv)).getText().toString();
                    String details = ((TextView) view.findViewById(R.id.details)).getText().toString();
                    String latitude = ((TextView) view.findViewById(R.id.latitude)).getText().toString();

                    String longtude = ((TextView) view.findViewById(R.id.longitude)).getText().toString();

                    Intent intent = new Intent(Dhaka.this,PlaceView.class);
                    intent.putExtra("imageurl",image);
                    intent.putExtra("dist",dist);
                    intent.putExtra("place",place);
                    intent.putExtra("details",details);
                    intent.putExtra("latitude",latitude);
                    intent.putExtra("longtude",longtude);
                    startActivity(intent);
                }
            });

        }

    }

    private  static String  readURL(String theUrl){
        StringBuilder content = new StringBuilder();
        try{
            URL url = new URL(theUrl);

            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while((line= bufferedReader.readLine())!=null){
                content.append(line+"\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void Alert() {
        AlertDialog alertDialog = new AlertDialog.Builder(Dhaka.this).create();
        alertDialog.setTitle("No NetWork Found");
        alertDialog.setMessage("Please Open Internet Connection");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",
                new DialogInterface.OnClickListener()

        {
            public void onClick (DialogInterface dialog,int which){
                Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
        }
        }

        );
        alertDialog.show();
    }
}