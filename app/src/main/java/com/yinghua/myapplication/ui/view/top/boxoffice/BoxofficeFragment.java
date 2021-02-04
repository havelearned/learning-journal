package com.yinghua.myapplication.ui.view.top.boxoffice;

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

public class BoxofficeFragment extends Fragment {

    private BoxofficeViewModel mViewModel;

    public static BoxofficeFragment newInstance() {
        return new BoxofficeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(BoxofficeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_boxoffice, container, false);
        final TextView textView = root.findViewById(R.id.text_boxoffice);
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
        mViewModel = new ViewModelProvider(this).get(BoxofficeViewModel.class);
        // TODO: Use the ViewModel
    }

}