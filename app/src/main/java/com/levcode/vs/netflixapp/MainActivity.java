package com.levcode.vs.netflixapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
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

    Button btnSearch;
    private static final String TAG_TITLE = "show_title";
    private static final String TAG_RELEASE = "release_year";
    private static final String TAG_RATING = "rating";
    private static final String TAG_POSTER = "poster";

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


    class Search extends AsyncTask<String, String, String> {

        EditText txtSearch;
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
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            txtSearch = (EditText) findViewById(R.id.txtSearch);


            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(result);
                jsonObj = jsonObject.getJSONObject("request_result");
                jsonArray = jsonObj.getJSONArray("results");
                n = jsonArray.length();

                for (int i = 0; i < n; i++) {
                    //nume= jsonObj.getString(TAG_NAME);
                    show_title = jsonArray.getJSONObject(i).getString(TAG_TITLE);
                    release_year = jsonArray.getJSONObject(i).getString(TAG_RELEASE);
                    rating = jsonArray.getJSONObject(i).getString(TAG_RATING);
                    poster = jsonArray.getJSONObject(i).getString(TAG_POSTER);

                    arrLst0.add(show_title);
                    arrLst1.add(release_year);
                    arrLst2.add(rating);
                    arrLst3.add(poster);
                }

                text = txtSearch.getText().toString();
                for (int j = 0; j < n; j++) {
                    if (text.equalsIgnoreCase(arrLst0.get(j))) {
                        ushow_title = arrLst0.get(j);
                        urelease_year = arrLst1.get(j);
                        urating = arrLst2.get(j);
                        uposter = arrLst3.get(j);

                        arrLst4.add(ushow_title);
                        arrLst5.add(urelease_year);
                        arrLst6.add(urating);
                        arrLst7.add(uposter);

                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        intent.putStringArrayListExtra("aname", arrLst3);
                        intent.putStringArrayListExtra("aprice", arrLst4);
                        intent.putStringArrayListExtra("aimg_url", arrLst5);

                        startActivity(intent);


                    } else {
                        Toast.makeText(getApplicationContext(), "No match found", Toast.LENGTH_SHORT).show();
                    }
//			else if(!(text.equalsIgnoreCase(arrLst0.get(j))))
//			{
//				Toast.makeText(getApplicationContext(), "No match found", 3000).show();
//				break;
//			}
                }

//	}
//});

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}