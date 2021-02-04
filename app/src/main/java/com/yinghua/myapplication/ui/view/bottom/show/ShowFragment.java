package com.yinghua.myapplication.ui.view.bottom.show;

import android.content.ContextWrapper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yinghua.myapplication.IndexMain;
import com.yinghua.myapplication.R;
import com.yinghua.myapplication.utily.HandTools;


public class ShowFragment extends Fragment  {

    private ShowViewModel showViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) { showViewModel =new ViewModelProvider(this).get(com.yinghua.myapplication.ui.view.bottom.show.ShowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_show, container, false);



        /*final TextView textView = root.findViewById(R.id.text_show);
        showViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/



        //给这个碎片添加左右滑动效果

        return root;
    }
}