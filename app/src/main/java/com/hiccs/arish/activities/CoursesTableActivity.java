package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.CoursesTableAdapter;
import com.hiccs.arish.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursesTableActivity extends AppCompatActivity {

    @BindView(R.id.courseTableRecyclerView)
    RecyclerView courseTableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_table);
        ButterKnife.bind(this);
        setupCoursesTable();
    }

    private void setupCoursesTable() {
        courseTableRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        CoursesTableAdapter adapter = new CoursesTableAdapter(DataUtils.getCourseDays(), this);
        courseTableRecyclerView.setAdapter(adapter);
    }
}
