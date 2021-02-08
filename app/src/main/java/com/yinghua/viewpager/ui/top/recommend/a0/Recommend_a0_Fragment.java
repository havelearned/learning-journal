package com.yinghua.viewpager.ui.top.recommend.a0;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.viewpager.R;

public class Recommend_a0_Fragment extends Fragment {

    private RecommendA0ViewModel mViewModel;

    public static Recommend_a0_Fragment newInstance() {
        return new Recommend_a0_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_recommend_a0, container, false);
        //获取下拉刷新组件
        PullRefreshLayout pullRefreshLayout = root.findViewById(R.id.pullRefesh);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();

//                    //获取线性布局对象
//                    LinearLayout linearLayout = root.findViewById(R.id.linearLayout_fragment_1);
//
//                    //设置行，还是列 （水平，垂直）
//                    linearLayout.setOrientation(LinearLayout.VERTICAL);
//                    //删除页面中的所有布局组件
//                    linearLayout.removeAllViews();
//
//                    for(int i=0;i<=4;i++){
//                        ImageView imageView = new ImageView(getContext());
//                        imageView.setImageResource(R.drawable.ic_app_title);
//                        linearLayout.addView(imageView);
//                    }

                    // refresh complete(完成下拉刷新布局)
                    pullRefreshLayout.setRefreshing(false);
                }
        });
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendA0ViewModel.class);
        // TODO: Use the ViewModel
    }

}