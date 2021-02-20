package com.yinghua.jilijili.ui.top.recommend;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.utily.Consts;

import java.util.Arrays;


public class Reommend_Movie_Info extends Fragment {


    RecyclerView recyclerView;
    TextView text1_Movie_info_info, text2_Movie_info_info,
            text3_Movie_info_in, brief;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reommend__movie__info, container, false);

        inIt_tv(v);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String[] movies = arguments.getStringArray("movies");

            for (int i = 0; i < movies.length; i++) {
                text1_Movie_info_info.setText(movies[1]);
                text2_Movie_info_info.setText(movies[4]);
                text3_Movie_info_in.setText(movies[2]);
                brief.setText(movies[6]);//简介下标 3
                Log.e(Consts.TAG, movies[i] + "---->" + i);
            }
        } else {

        }


        return v;
    }

    private void inIt_tv(View v) {
        text1_Movie_info_info = v.findViewById(R.id.text1_Movie_info_info);
        text2_Movie_info_info = v.findViewById(R.id.text2_Movie_info_info);
        text3_Movie_info_in = v.findViewById(R.id.text3_Movie_info_in);
        brief = v.findViewById(R.id.brief);
    }
}