package com.yinghua.viewpager.ui.top.recommend;

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


public class RecommendFragment extends Fragment {

    private RecommendViewModel mViewModel;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(RecommendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel
    }

}