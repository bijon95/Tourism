package com.example.ayon.projetfile1;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import static android.content.Context.ACCOUNT_SERVICE;
import static com.example.ayon.projetfile1.R.id.textView;

public class Comments extends android.support.v4.app.Fragment {

    public Comments() {
        // Required empty public constructor
    }

    EditText et1,et3;
    TextView tv;
    Button btn1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_comments, container, false);
        et1=(EditText) view.findViewById(R.id.cmtNme);
        tv=(TextView) view.findViewById(R.id.editText2) ;
        et3=(EditText) view.findViewById(R.id.editText3) ;
        btn1=(Button) view.findViewById(R.id.button);



        AccountManager accountManager = AccountManager.get(getActivity());
        Account[] accounts = accountManager.getAccountsByType("com.google");
        String email = accounts[0].name;
        tv.setText(email);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String name=   et1.getText().toString();
                String location=   tv.getText().toString();
                String data=   et3.getText().toString();

                BackgroundTask backgroundTask = new BackgroundTask();
                backgroundTask.execute(name,location,data);

                Toast.makeText(getActivity(),"DataInserted", Toast.LENGTH_LONG).show();
                et1.setText("");
            }
        });
        Button btn2=(Button) view.findViewById(R.id.btnview);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ViewComments.class);
                startActivity(i);
            }
        });
        return view;
    }




}