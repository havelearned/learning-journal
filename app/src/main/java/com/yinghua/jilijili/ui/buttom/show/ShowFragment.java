package com.yinghua.jilijili.ui.buttom.show;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yinghua.jilijili.OrderActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.SeekActivity;
import com.yinghua.jilijili.ui.top.boxoffice.BoxofficeFragment;
import com.yinghua.jilijili.ui.top.comingsoon.ComingSoonFragment;
import com.yinghua.jilijili.ui.top.recommend.RecommendFragment;
import com.yinghua.jilijili.ui.top.starrnaking.StrrnaKingFragment;


/**
 * 首页展示页面
 * 首先默认选中推荐的Fragment 数据都在 推荐的页面中
 * 这个页面是头部的头像 搜索 。。 和 ViewPager2 导航工具页面
 * 底部的 首页 电影院 。。。 是activity_main.xml管理
 */
public class ShowFragment extends Fragment {
    ImageButton app_search;
    ImageView touxing, to_order;
    ViewPager2 viewPager2;
    TabLayout tableLayout;
    ImageButton search;

    private ShowViewModel showViewModel;


    //创建者Fragment是执行的方法
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        showViewModel = new ViewModelProvider(this).get(ShowViewModel.class);
        //获取视图对象，最后 return
        View root = inflater.inflate(R.layout.fragment_show, container, false);


        appSearch(root);

        //点击头像跳转到我的界面
        ImageOnclick(root);

        ObjectAnimator.ofFloat(root.findViewById(R.id.touxing), "scaleX", 1.4f, 1f).setDuration(3000).start();
        InitViewPage(root);

        return root;
    }

    private void appSearch(View root) {
        app_search = root.findViewById(R.id.app_search);
        app_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到另一个活动搜索
            }
        });
    }

    private void ImageOnclick(View root) {
        touxing = root.findViewById(R.id.touxing);
        to_order=root.findViewById(R.id.to_order);
        root.findViewById(R.id.app_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SeekActivity.class);
                getContext().startActivity(intent);

            }
        });

        touxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.navigation_my);
            }
        });

        to_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), OrderActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void InitViewPage(View root) {
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
                    tab.setText("推荐电影");
                } else if (position == 1) {
                    tab.setText("北美票房榜");
                } else if (position == 2) {
                    tab.setText("新片榜");
                } else if (position == 3) {
                    tab.setText("电影条目剧照");
                }

            }
        }).attach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}