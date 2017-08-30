package com.levcode.vs.netflixapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-29.
 */

public class SearchActivity extends Activity {

    ListView lstVwSearch;
    TextView txtVwSearch;
    ArrayList<String> arrLst0 = new ArrayList<String>();
    ArrayList<String> arrLst1 = new ArrayList<String>();
    ArrayList<String> arrLst2 = new ArrayList<String>();
    ArrayList<String> arrLst3 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        lstVwSearch=(ListView)findViewById(R.id.SrhlstVw);
        //SrhtxtVw=(TextView)findViewById(R.id.SrhtxtVw);

        arrLst0=getIntent().getStringArrayListExtra("atitle");
        arrLst1=getIntent().getStringArrayListExtra("ayear");
        arrLst2=getIntent().getStringArrayListExtra("arating");
        arrLst3=getIntent().getStringArrayListExtra("aposter");

        //lstVwSearch.set

        ArrayAdapter<String> arrAdapt =new ArrayAdapter<String>(SearchActivity.this,android.R.layout.simple_list_item_1,arrLst0);

        //Toast.makeText(MainActivity.this, n, 3000).show();
        //CustomAdapter cA = new CustomAdapter(MainActivity.this, arrLst0, arrLst1, arrLst2, arrLst3);
        lstVwSearch.setAdapter(arrAdapt);

        lstVwSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

                if(arg2==0)
                {
                    Intent intent=new Intent(SearchActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), arrLst0.get(arg2), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //SearchAdapter sA=new SearchAdapter(SearchActivity.this,arrLst0,arrLst1,arrLst2);
        //SrhlstVw.setAdapter(sA);
    }
}
