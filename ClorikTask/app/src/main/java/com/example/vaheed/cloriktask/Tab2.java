package com.example.vaheed.cloriktask;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Belal on 2/3/2016.
 */

public class Tab2 extends Fragment {

    String given_url="https://cdn.pixabay.com/photo/2015/04/22/12/02/butterfly-734654_960_720.jpg";
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab2, container, false);

        //Initializing the ImageView
        imageView = (ImageView)v.findViewById(R.id.imageView);
        TextView url=(TextView)v.findViewById(R.id.url);
        Picasso.with(getContext())
                .load("https://cdn.pixabay.com/photo/2015/04/22/12/02/butterfly-734654_960_720.jpg")
                //.placeholder(R.drawable.placeholder)   // optional
                //.error(R.drawable.error)      // optional
                .resize(580,520)
                .into(imageView);
        url.setText(given_url);


      return v;
    }
}