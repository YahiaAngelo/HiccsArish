package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hiccs.arish.R;
import com.hiccs.arish.models.news.AboutListModel;

import java.util.ArrayList;
public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final   ArrayList<AboutListModel> Items=new ArrayList<AboutListModel>();
        Items.add(new AboutListModel(getString(R.string.creation_title),getString(R.string.creation)));
        Items.add(new AboutListModel(getString(R.string.granted_degrees_title),getString(R.string.granted_degrees)));
        Items.add(new AboutListModel(getString(R.string.duration_of_study_title),getString(R.string.duration_of_study)));
        Items.add(new AboutListModel(getString(R.string.departments_title),getString(R.string.departments)));
        Items.add(new AboutListModel(getString(R.string.admission_requirements_title),getString(R.string.admission_requirements)));
        Items.add(new AboutListModel(getString(R.string.goals_title),getString(R.string.goals)));
        Items.add(new AboutListModel(getString(R.string.address_title),getString(R.string.address)));
        Items.add(new AboutListModel(getString(R.string.connection_info_title),getString(R.string.connection_info)));

        final MyCustomAdapter myadpter= new MyCustomAdapter(Items);

        ListView ls=(ListView)findViewById(R.id.listView);
        ls.setAdapter(myadpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title =(TextView) view.findViewById(R.id.title);
                TextView txtdes =(TextView) view.findViewById(R.id.desc);
                Toast.makeText(getApplicationContext(),title.getText(),Toast.LENGTH_LONG).show();
                Items.add(new AboutListModel("rana", "he is okey "));
                Items.add(new AboutListModel("sama", "he is well "));
                myadpter.notifyDataSetChanged();

            }
        });

    }


    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<AboutListModel> Items=new ArrayList<AboutListModel>();
        MyCustomAdapter(ArrayList<AboutListModel> Items ) {
            this.Items=Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).title;

        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.about_list_row, null);

            TextView txtname =(TextView) view1.findViewById(R.id.title);
            TextView txtdes =(TextView) view1.findViewById(R.id.desc);
            txtname.setText(Items.get(i).title);
            txtdes.setText(Items.get(i).Desc);
            return view1;

        }



    }
}