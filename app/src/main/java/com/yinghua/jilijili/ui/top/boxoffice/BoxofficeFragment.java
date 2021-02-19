package com.yinghua.jilijili.ui.top.boxoffice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yinghua.jilijili.R;


public class BoxofficeFragment extends Fragment {

    private BoxofficeViewModel mViewModel;

    public static BoxofficeFragment newInstance() {
        return new BoxofficeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(BoxofficeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_boxoffice, container, false);
//        Button button = root.findViewById(R.id.button_BoxofficeFragment);
//        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_boxofficeFragment_to_recommendFragment));


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BoxofficeViewModel.class);
        // TODO: Use the ViewModel
    }

}