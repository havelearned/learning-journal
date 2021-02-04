package com.yinghua.myapplication.ui.view.bottom.my;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinghua.myapplication.R;

public class MyFragment extends Fragment {

    private MyViewModel myViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myViewModel =
                new ViewModelProvider(this).get(com.yinghua.myapplication.ui.view.bottom.my.MyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my, container, false);
        /*final TextView textView = root.findViewById(R.id.text_my);
        myViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}