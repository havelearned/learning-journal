package com.yinghua.viewpager.ui.top.comingsoon;

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


public class ComingSoonFragment extends Fragment {

    private ComingSoonViewModel mViewModel;

    public static ComingSoonFragment newInstance() {
        return new ComingSoonFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(ComingSoonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_3, container, false);

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ComingSoonViewModel.class);
        // TODO: Use the ViewModel
    }

}