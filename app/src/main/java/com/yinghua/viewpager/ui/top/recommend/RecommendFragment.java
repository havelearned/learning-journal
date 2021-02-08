package com.yinghua.viewpager.ui.top.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
        View root = inflater.inflate(R.layout.fragment_top_recommend, container, false);
        Button button =root.findViewById(R.id.button7);


//        pullMonitor(root,5);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel

    }


    /**
     * 下拉刷新 监听
     * @param howMany 刷新多少个;
     *
     * */
    public void pullMonitor (View root,int howMany ){
        PullRefreshLayout pullRefreshLayout = root.findViewById(R.id.recommend_pullRefesh);
        LinearLayout linearLayout = root.findViewById(R.id.recommend_linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                linearLayout.removeAllViews();
                MediaController mediaController = new MediaController(getContext());

                for(int i=0;i<=howMany;i++){
                    VideoView videoView = new VideoView(getContext());
                    videoView.setVideoPath("http://jilijili.fun/%E5%93%B2%E5%AD%A6.mp4");
                    if(i==0){
                        videoView.start();
                        videoView.setMediaController(mediaController);
                    }else{

                        videoView.stopPlayback();
                    }


                    linearLayout.addView(videoView,1200,400);

                    TextView textView = new TextView(getContext());
                    textView.setText("Test");
                    textView.setTextSize(20);
                    textView.setBackgroundColor(R.drawable.ic_app_indexmain_bg);
                    linearLayout.addView(textView,1200,200);

                    Button button = new Button(getContext());
                    button.setText("查看详情");
                    button.setPadding(0,100,0,0);
                    linearLayout.addView(button);

                }

                pullRefreshLayout.setRefreshing(false);
            }
        });
    }




}