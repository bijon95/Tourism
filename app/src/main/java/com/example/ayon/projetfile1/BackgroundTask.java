package com.example.ayon.projetfile1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Bj on 11-04-17.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context context;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String reg_url="http://appsticit.com/myC/addsms.php";
        String data_one=strings[0];
        String data_two=strings[1];
       String data_three=strings[2];
        try{
            URL url=new URL(reg_url);
            HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(data_one,"UTF-8")+"&"+
                    URLEncoder.encode("data","UTF-8")+"="+URLEncoder.encode(data_three,"UTF-8")+"&"+
                    URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(data_two,"UTF-8")+"&";
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.close();
            return "Data inserted";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);


    }
}
