package com.example.vaheed.cloriktask;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Belal on 2/3/2016.
 */
//Our class extending fragment
public class Tab1 extends Fragment {
    //private AppAdapter mAdapter;
    private ListView mListView;
    ListView list;
    String[] web = {
            "User1",
            "User2",
            "Content1",
            "Content2",
            "Choice1",
            "Content3",
            "User3"
    } ;
    Integer[] imageId = {
            R.drawable.add,
            R.drawable.add,
            R.drawable.send,
            R.drawable.send,
            R.drawable.copy,
            R.drawable.send,
            R.drawable.add

    };

    Integer[] select = {
            R.drawable.circular,
            R.drawable.circular,
            R.drawable.circular,
            R.drawable.circular,
            R.drawable.circular,
            R.drawable.circular,
            R.drawable.circular
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);
        CustomList adapter = new
                CustomList(getActivity(), web, imageId,select);
        list=(ListView)v.findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }
    public class CustomList extends ArrayAdapter<String>{

        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;
        private final Integer[] select;

        public CustomList(Activity context,
                          String[] web, Integer[] imageId,Integer[] select) {
            super(context, R.layout.cards_layout, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
            this.select=select;

        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.cards_layout, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_android);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.img_android);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            ImageView sel=(ImageView)rowView.findViewById(R.id.imageView2);
            sel.setImageResource(select[position]);

            return rowView;
        }
    }
}