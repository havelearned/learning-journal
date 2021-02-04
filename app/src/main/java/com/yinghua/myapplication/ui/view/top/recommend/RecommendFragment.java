package com.yinghua.myapplication.ui.view.top.recommend;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yinghua.myapplication.R;
import com.yinghua.myapplication.ui.view.top.comingsoon.ComingSoonViewModel;

public class RecommendFragment extends Fragment {

    private RecommendViewModel mViewModel;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(RecommendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recommend, container, false);
        final TextView textView = root.findViewById(R.id.text_recommend);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel
    }

}