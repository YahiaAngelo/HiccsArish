package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiccs.arish.R;
import com.hiccs.arish.models.coursestable.CoursesDays;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AbdullahAtta on 2/28/2019.
 */
public class CoursesTableAdapter extends RecyclerView.Adapter<CoursesTableAdapter.CoursesTableViewHolder> {

    private List<CoursesDays> mCoursesDays;
    private Context mContext;

    public CoursesTableAdapter(List<CoursesDays> mCoursesDays, Context mContext) {
        this.mCoursesDays = mCoursesDays;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CoursesTableViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View coursesTableView = LayoutInflater.from(mContext).inflate(R.layout.list_item_table_day, viewGroup, false);
        return new CoursesTableViewHolder(coursesTableView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesTableViewHolder holder, int i) {
        CourseTableDayAdapter adapter = new CourseTableDayAdapter(mCoursesDays.get(i).getCourseTimes(), mContext);
        holder.courseDayRecyclerView.setAdapter(adapter);
        holder.dayName.setText(mCoursesDays.get(i).getDayName());
    }

    @Override
    public int getItemCount() {
        return mCoursesDays == null ? 0 : Constants.WORKING_DAYS_OF_WEEK;
    }

    public class CoursesTableViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listItemCourseTableTimeRecyclerView)
        RecyclerView courseDayRecyclerView;
        @BindView(R.id.listItemTableDayLabel)
        TextView dayName;

        public CoursesTableViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
