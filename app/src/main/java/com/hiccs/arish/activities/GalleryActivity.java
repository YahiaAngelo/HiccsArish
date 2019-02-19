package com.hiccs.arish.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.GalleryAdapter;
import com.hiccs.arish.models.GalleryImages;

import java.util.ArrayList;

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
        GalleryAdapter adapter = new GalleryAdapter(this, getGalleryImages());
        galleryRecyclerView.setAdapter(adapter);
    }

    private ArrayList<GalleryImages> getGalleryImages() {
        String[] images = getImages();
        ArrayList<GalleryImages> gallery = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            gallery.add(new GalleryImages("Image: " + String.valueOf(i), images[i]));
        }
        return gallery;
    }

    private String[] getImages() {
        return new String[]{"https://goo.gl/qExfGq", "https://goo.gl/K9MWfn",
                "https://goo.gl/FtTkcR", "https://goo.gl/FN5aaD"};
    }
}
