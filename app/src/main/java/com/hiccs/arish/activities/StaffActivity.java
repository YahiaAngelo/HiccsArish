package com.hiccs.arish.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.utils.ConnectionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StaffActivity extends AppCompatActivity {
    RecyclerView recyclerView;
ArrayList<StaffModel> sttaffList;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        if (ConnectionManager.isIntenetConectted(this))
        {
            new MyCustome().execute("http://localhost/hicss.php/include/staff.php" );
        }
        else
            Toast.makeText(this, "Please check internet", Toast.LENGTH_SHORT).show();






    }




    public class MyCustome extends AsyncTask<String, String, List<StaffModel>>
            implements com.hiccs.arish.activities.MyCustome {

        @Override
        protected List<StaffModel> doInBackground(String... strings) {
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            StringBuilder stringBuilder = null;
            try {

                URL myurl = new URL(strings[0]);

                urlConnection = (HttpURLConnection) myurl.openConnection(

                );
                 // وخزنتهم ف المتغير الي انا عملته جديدinputstream

                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                    //append اضافه
                    inputStream.close();
                    urlConnection.disconnect();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String res = stringBuilder.toString();
            List<StaffModel> result = new ArrayList<>();
            try {
                JSONArray jsrray = new JSONArray(res);
                JSONObject object = null;
                for (int i = 0; i < jsrray.length(); i++) {
                    object = jsrray.getJSONObject(i);
                    result.add(new StaffModel(object.getInt("dr_img"),
                            object.getString("dr_name"), object.getString("dr_des") )/*R.drawable.e*/);

                }

            } catch (JSONException e1) {
                e1.printStackTrace();
            }

            //   String res="";
            //بحول الداتا الي جبتها من السيرفروخزنتها ف inputstreem دلوقتي بحولها ل bufferd

            return result;
        }

        @Override
        protected void onPostExecute(List<StaffModel> mList) {
            super.onPostExecute(mList);
            StaffAdapter adapter = new StaffAdapter(mList);
           recyclerView.setAdapter(adapter);

        }


    }

}
