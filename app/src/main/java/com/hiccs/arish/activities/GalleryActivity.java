package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.GalleryAdapter;
import com.hiccs.arish.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {

    @BindView(R.id.galleryRecyclerView)
    RecyclerView galleryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        setupGalleryRecyclerView();
    }

    private void setupGalleryRecyclerView() {
        GalleryAdapter adapter = new GalleryAdapter(this, DataUtils.getGalleryImages());
        galleryRecyclerView.setAdapter(adapter);
    }


}
