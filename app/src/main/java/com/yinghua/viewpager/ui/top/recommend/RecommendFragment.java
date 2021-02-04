package com.yinghua.viewpager.ui.top.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.viewpager.R;


public class RecommendFragment extends Fragment {

    private RecommendViewModel mViewModel;
    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        //获取下拉刷新组件
        PullRefreshLayout pullRefreshLayout = root.findViewById(R.id.pullRefesh);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();

                mViewModel.setCount();
                Integer value = mViewModel.getCount().getValue();
                if(value<2){
                    LinearLayout linearLayout = root.findViewById(R.id.linearLayout_fragment_1);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    Button button = new Button(getContext());
                    Button button2 = new Button(getContext());
                    button.setText("button1");
                    button2.setText("button2");
                    linearLayout.addView(button);
                    linearLayout.addView(button2);
                    // refresh complete(完成下拉刷新布局)
                    pullRefreshLayout.setRefreshing(false);
                }

                Toast.makeText(getContext(), ""+value, Toast.LENGTH_SHORT).show();
                pullRefreshLayout.setRefreshing(false);

            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel

    }




}