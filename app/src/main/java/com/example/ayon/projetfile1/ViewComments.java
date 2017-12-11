package com.example.ayon.projetfile1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

public class ViewComments extends AppCompatActivity {


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



    ArrayList<Product2> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);

        listView=(ListView) findViewById(R.id.cdlist);

        contactList = new ArrayList<>();
        dataurl=getIntent().getStringExtra("myData");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ViewComments.GetContacts().execute("https://appsticit.com/myC/commentView.php");
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
                contactList.add(new Product2(
                        productObject.getString("name"),
                        productObject.getString("comment"),
                        productObject.getString("location")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final CommentAdapter adapter = new CommentAdapter(
                getApplicationContext(),R.layout.cmtitm,contactList);

        listView.setAdapter(adapter);


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
}
