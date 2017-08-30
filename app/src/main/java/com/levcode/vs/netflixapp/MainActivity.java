package com.levcode.vs.netflixapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtSearch;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Search().execute("");

            }
        });

    }
}

class Search extends AsyncTask <String, String, String> {

    String text;
    StringBuilder strBuilder1 = new StringBuilder();
    JSONArray jsonArray;
    JSONObject jsonObj;

    int n;
    String show_title = null, release_year = null, rating = null, poster = null;
    String ushow_title = null, urelease_year = null, urating = null, uposter = null;
    ArrayList<String> arrLst0 = new ArrayList<String>();
    ArrayList<String> arrLst1 = new ArrayList<String>();
    ArrayList<String> arrLst2 = new ArrayList<String>();
    ArrayList<String> arrLst3 = new ArrayList<String>();
    ArrayList<String> arrLst4 = new ArrayList<String>();
    ArrayList<String> arrLst5 = new ArrayList<String>();
    ArrayList<String> arrLst6 = new ArrayList<String>();
    ArrayList<String> arrLst7 = new ArrayList<String>();
    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
    pre
}