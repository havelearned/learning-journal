package com.yinghua.myapplication.ui.view.bottom.moive;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yinghua.myapplication.R;


public class MovieFragment extends Fragment {

    private MovieViewModel movieViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        movieViewModel =
                new ViewModelProvider(this).get(com.yinghua.myapplication.ui.view.bottom.moive.MovieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        final TextView textView = root.findViewById(R.id.text_movie);
        movieViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}