package com.yinghua.myapplication.ui.view.bottom.dynamic;

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


public class DynamicFragment extends Fragment {
    private DynamicViewModel dynamicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dynamicViewModel =
                new ViewModelProvider(this).get(com.yinghua.myapplication.ui.view.bottom.dynamic.DynamicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dynamic, container, false);
        final TextView textView = root.findViewById(R.id.text_dynamic);
        dynamicViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}