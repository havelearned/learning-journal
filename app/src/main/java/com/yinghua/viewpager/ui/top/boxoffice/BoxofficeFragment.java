package com.yinghua.viewpager.ui.top.boxoffice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yinghua.viewpager.R;


public class BoxofficeFragment extends Fragment {

    private BoxofficeViewModel mViewModel;

    public static BoxofficeFragment newInstance() {
        return new BoxofficeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(BoxofficeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_2, container, false);

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BoxofficeViewModel.class);
        // TODO: Use the ViewModel
    }

}