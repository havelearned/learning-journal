package com.yinghua.viewpager.ui.buttom.show;

import android.animation.ObjectAnimator;
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
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yinghua.viewpager.R;
import com.yinghua.viewpager.ui.top.boxoffice.BoxofficeFragment;
import com.yinghua.viewpager.ui.top.comingsoon.ComingSoonFragment;
import com.yinghua.viewpager.ui.top.recommend.RecommendFragment;
import com.yinghua.viewpager.ui.top.starrnaking.StrrnaKingFragment;


/**
 * 首页展示页面
 * 首先默认选中推荐的Fragment 数据都在 推荐的页面中
 * 这个页面是头部的头像 搜索 。。 和 ViewPager2 导航工具页面
 * 底部的 首页 电影院 。。。 是activity_main.xml管理
 */
public class ShowFragment extends Fragment {

    ViewPager2 viewPager2;
    TabLayout tableLayout;
    private ShowViewModel showViewModel;


    //创建者Fragment是执行的方法
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        showViewModel = new ViewModelProvider(this).get(ShowViewModel.class);
        //获取视图对象，最后 return
        View root = inflater.inflate(R.layout.fragment_show, container, false);
        ObjectAnimator.ofFloat(root.findViewById(R.id.touxing), "scaleX", 1.4f, 1f).setDuration(3000).start();
        //Navigation通过反射获取页面这个组件执行，更具这个组件导航到相应的Fragment
        final TextView textView = root.findViewById(R.id.text_show);
        showViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            //当ViewModel发生改变的时候调用这个方法
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        /**
         * 给这个碎片添加左右滑动效果
         *  获取tableLayout布局组件
         *  获取ViewPager2 布局组件对象
         */
        tableLayout = root.findViewById(R.id.tableLayout);
        viewPager2 = root.findViewById(R.id.viewPager2);

        //适配器分配多少个页面
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            //对应的位置，分配哪个一页面
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return new RecommendFragment();
                } else if (position == 1) {
                    return new BoxofficeFragment();
                } else if (position == 2) {
                    return new StrrnaKingFragment();
                } else if (position == 3) {
                    return new ComingSoonFragment();
                }
                return null;
            }

            //告诉 viewPage2有多少个页面
            @Override
            public int getItemCount() {
                return 4;
            }
        });

        //设置ViewPager2的预加载数，传入大于1的值来设置预加载数量，默认不预加载
        viewPager2.setOffscreenPageLimit(1);

        new TabLayoutMediator(tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {

            //设置标题
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("推荐");
                } else if (position == 1) {
                    tab.setText("票房");
                } else if (position == 2) {
                    tab.setText("明星排行");
                } else if (position == 3) {
                    tab.setText("即将上映");
                }

            }
        }).attach();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}