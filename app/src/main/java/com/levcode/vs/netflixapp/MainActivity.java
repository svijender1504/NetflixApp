package com.levcode.vs.netflixapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        URL url = null;
        try {
            url = new URL("http://netflixroulette.net/api/api.php?actor=Nicolas%20Cage");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String read1;
            while ((read1 = bufferedReader.readLine()) != null) {
                strBuilder1.append(read1);
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuilder1.toString();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

}