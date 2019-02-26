package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.StaffModel;

import java.util.ArrayList;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {

    private Context staffcontext;
    private ArrayList<StaffModel> staff_List;

    public StaffAdapter(Context context, ArrayList<StaffModel> staff_List) {

        this.staffcontext = context;
        this.staff_List = staff_List;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(staff_List.get(position).getDescription());
        holder.description.setText(staff_List.get(position).getDescription());
        Glide.with(staffcontext).load(staff_List.get(position).getImage_link()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return staff_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, description;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.staff_name);
            description = (TextView) itemView.findViewById(R.id.staff_des);
            imageView = (ImageView) itemView.findViewById(R.id.staff_img);
        }
    }
}
