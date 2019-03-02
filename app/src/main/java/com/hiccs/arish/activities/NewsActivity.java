package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.NewsAdapter;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    private static final String TAG = NewsActivity.class.getSimpleName();
    @BindView(R.id.newsRecyclerView)
    RecyclerView mNewsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        loadNews();
    }

    private void loadNews() {
        APIUtils.getHiccsAPI().getHICCSNews()
                .enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        if (response.isSuccessful()) {
                            setNewsToAdapter(response.body());
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String msg) {
        Log.d(TAG, msg);
    }

    private void setNewsToAdapter(List<News> body) {
        NewsAdapter adapter = new NewsAdapter(this, body);
        mNewsRecyclerView.setAdapter(adapter);
    }
}
