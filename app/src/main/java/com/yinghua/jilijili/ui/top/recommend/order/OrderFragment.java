package com.yinghua.jilijili.ui.top.recommend.order;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;

public class OrderFragment extends Fragment {
    ImageView order_break;
    ViewPager2 page_view;
    TabLayout mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order2, container, false);
        page_view = view.findViewById(R.id.page_view);
        mLayout = view.findViewById(R.id.tb_tab);
        order_break=view.findViewById(R.id.order_break);

        getView(view);
        return view;
    }

    private View getView(View view) {
        order_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        page_view.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position==0) {
                    return new UndoneFragment();
                } else if (position==1) {
                    return new SuccessFragment();
                }

                return null;
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });
        page_view.setCurrentItem(0);
        new TabLayoutMediator(mLayout, page_view, new TabLayoutMediator.TabConfigurationStrategy() {

            //设置标题
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("未完成订单");
                } else if (position == 1) {
                    tab.setText("已完成订单");
                }
            }
        }).attach();
        return  view;
    }
}