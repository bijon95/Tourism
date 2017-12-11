package com.example.ayon.projetfile1;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

  // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Place(), "PlaceList");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //Boutton view
    public void dhaka(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String url = "?dist=Dhaka";
        intent.putExtra("myData",url);
        startActivity(intent);
    }
    public void chittagong(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Chittagong";
        intent.putExtra("myData",data);
        startActivity(intent);
    }
    public void sylhet(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Sylhet";
        intent.putExtra("myData",data);
        startActivity(intent);
    }
    public void khulna(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Khulna";
        intent.putExtra("myData",data);
        startActivity(intent);
    }
    public void rajshahi(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Rajshahi";
        intent.putExtra("myData",data);
        startActivity(intent);
    }

    public void borishal(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Barisal";
        intent.putExtra("myData",data);
        startActivity(intent);
    }

    public void rongpur(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Rangpur";
        intent.putExtra("myData",data);
        startActivity(intent);
    }

    public void mymansign(View view){
        Intent intent = new Intent(MainActivity.this,Dhaka.class);
        String data = "?dist=Mymensing";
        intent.putExtra("myData",data);
        startActivity(intent);
    }

}
