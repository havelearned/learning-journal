package com.yinghua.jilijili.ui.top.starrnaking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yinghua.jilijili.R;


public class StrrnaKingFragment extends Fragment {

    private StrrnaKingViewModel mViewModel;

    public static StrrnaKingFragment newInstance() {
        return new StrrnaKingFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(StrrnaKingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_strrnaking, container, false);

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StrrnaKingViewModel.class);
        // TODO: Use the ViewModel
    }

}