package com.yinghua.jilijili.ui.top.recommend;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.utily.Consts;



public class RecommendFragment extends Fragment {
    private RecommendViewModel mViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(Consts.TAG,"");
        //获取layout
        View root = inflater.inflate(R.layout.fragment_top_recommend, container, false);

        return root;
    }

    private void getData() {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel

    }
}