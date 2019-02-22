package com.hiccs.arish.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.utils.ConnectionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StaffActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private StaffAdapter adabter ;
    private List<StaffModel> sttaffList;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        if (ConnectionManager.isIntenetConectted(this))
        {
            load_data_from_server(0);
        }
        else

            Toast.makeText(this, "Please check internet", Toast.LENGTH_SHORT).show();


        recyclerView = (RecyclerView) findViewById(R.id.staff_recycler);
       sttaffList  = new ArrayList<>();
        load_data_from_server(0);

        gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);

        adabter = new StaffAdapter(this, (ArrayList<StaffModel>) sttaffList);
        recyclerView.setAdapter(adabter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if(gridLayoutManager.findLastCompletelyVisibleItemPosition() == sttaffList.size()-1){
                    load_data_from_server(sttaffList.get(sttaffList.size()-1).getId());
                }

            }
        });

    }

    private void load_data_from_server(int id) {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://192.168.178.26/test/script.php?id="+integers[0])
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0; i<array.length(); i++){

                        JSONObject object = array.getJSONObject(i);

                       StaffModel  data = new StaffModel(object.getInt("id"),
                                 object.getString("name"),
                                 object.getString("description"),
                                object.getString("image"));

                        sttaffList.add(data);
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adabter.notifyDataSetChanged();
            }
        };

        task.execute(id);
    }


}