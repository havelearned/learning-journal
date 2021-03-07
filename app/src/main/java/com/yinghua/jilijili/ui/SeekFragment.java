package com.yinghua.jilijili.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.SeekActivity;
import com.yinghua.jilijili.adapter.SeekAdapter;
import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeekFragment extends Fragment {
    EditText et_centent;
    TextView tv_seek;
    ImageView iv_break;
    RecyclerView seekf_relativelayout;

    Intent mIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seek, container, false);


        getInit(view);
        iv_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });


        seekf_relativelayout.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        seekf_relativelayout.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        //点击搜索事件
        tv_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_centent.getText().toString().trim();
                    MoviesRetrofitClient.getInstance()
                            .movieService()
                            .getSeekMovies(content)
                            .enqueue(new Callback<List<Movie>>() {
                                @Override
                                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                                    if(response.code()==200){
                                        List<Movie> body = response.body();
                                        seekf_relativelayout.setAdapter(new SeekAdapter(getContext(),body));
                                        Log.e(Consts.TAG, "Login_EmailFragment_请求成功：" + response.raw()+"\n");
                                    }else{
                                        Log.e(Consts.TAG, "Login_EmailFragment_请求失败：" + response.raw());
                                    }

                                }
                                @Override
                                public void onFailure(Call<List<Movie>> call, Throwable t) {
                                    Log.e(Consts.TAG, "Login_EmailFragment_请求失败：" + t.getMessage());
                                }
                            });

            }
        });
//        et_centent.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Toast.makeText(getContext(), "beforeTextChanged", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Toast.makeText(getContext(), "onTextChanged", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Toast.makeText(getContext(), "afterTextChanged", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }


    private void getInit(View view) {
        et_centent = view.findViewById(R.id.et_centent);
        iv_break = view.findViewById(R.id.iv_break);
        tv_seek = view.findViewById(R.id.tv_seek);
        seekf_relativelayout=view.findViewById(R.id.seekf_relativelayout);

    }
}