package com.yinghua.jilijili;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yinghua.jilijili.adapter.RecommenAdapter;
import com.yinghua.jilijili.utily.ActivityCollector;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    int[] image = {R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3,
            R.drawable.guide_4};
    public List<View> lv = new ArrayList<>();
    private ViewPager2 vp_guide;
    private Button bu_guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        this.getSupportActionBar().hide();
        if (WoelcomActivity.activity != null) {
            WoelcomActivity.activity.finish();
        }
        vp_guide = findViewById(R.id.vp_guide);
        bu_guide = findViewById(R.id.bu_guide);

        vp_guide.setAdapter(new mPageAdapter(this));
        bu_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //滚动监听
        vp_guide.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            //viewPage滚动第几张
            @Override
            public void onPageSelected(int position) {
                if(position==image.length-1){
                    bu_guide.setVisibility(View.VISIBLE);
                }else {
                    bu_guide.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }


    class mPageAdapter extends RecyclerView.Adapter<mPageAdapter.mViewHolder> {
        Context mContext;

        public mPageAdapter(Context context) {
            mContext = context;
        }

        @NonNull
        @Override
        public mPageAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_gride, parent, false);
            return new mViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull mPageAdapter.mViewHolder holder, int position) {
            holder.iv_gride.setImageResource(image[position]);
        }

        @Override
        public int getItemCount() {
            return image.length;
        }

        class mViewHolder extends RecyclerView.ViewHolder {
            ImageView iv_gride;

            public mViewHolder(@NonNull View itemView) {
                super(itemView);
                iv_gride = itemView.findViewById(R.id.iv_gride);
            }
        }
    }

}