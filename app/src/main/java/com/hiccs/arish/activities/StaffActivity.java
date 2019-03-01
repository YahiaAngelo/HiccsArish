package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.rest.APIUtils;

import java.io.IOException;
import java.util.List;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffActivity extends AppCompatActivity {

    private static final String TAG = StaffActivity.class.getSimpleName();
    @BindView(R.id.staff_recycler)
    RecyclerView StaffRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        ButterKnife.bind(this);
        StaffData();

    }


    private void StaffData() {
        Log.v("server_data", "Started to fetch staff");


        APIUtils.getHiccsAPI().getStaffModel()
                .enqueue(new Callback<List<StaffModel>>() {
                    @Override
                    public void onResponse(Call<List<StaffModel>> call, Response<List<StaffModel>> response) {
                        Log.v("server_data", "Started to get response");

                        if (response.isSuccessful()) {
                            linkstaffAdapter(response.body());

                            Log.v("server_data", response.body().get(0).toString());
                        } else {
                            Log.v("server_data", "response code = " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<StaffModel>> call, Throwable t) {

                    }
                });
    }

    private void linkstaffAdapter(List<StaffModel> body) {
        StaffAdapter adapter = new StaffAdapter(this, body);
        StaffRecyclerView.setAdapter(adapter);
    }

}
