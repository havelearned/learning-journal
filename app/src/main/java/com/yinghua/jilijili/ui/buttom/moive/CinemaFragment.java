package com.yinghua.jilijili.ui.buttom.moive;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Cinema;
import com.yinghua.jilijili.adapter.CinemaPageListAdapter;
import com.yinghua.jilijili.service.CinemaService;
import com.yinghua.jilijili.utily.Consts;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CinemaFragment extends Fragment {
        Handler handler=new Handler();
    RecyclerView recyclerView_CinemaFragment;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView_CinemaFragment = root.findViewById(R.id.recyclerView_CinemaFragment);
        recyclerView_CinemaFragment.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView_CinemaFragment.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView_CinemaFragment.setHasFixedSize(true);

        getData();
        return root;
    }

    public void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(Consts.DDSP_URL)
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();
                CinemaService cinemaService = retrofit.create(CinemaService.class);
                Call<List<Cinema>> allCinema = cinemaService.getAllCinema();
                try {
                    Response<List<Cinema>> execute = allCinema.execute();
                    Log.e(Consts.TAG, "CinemaDataSource_请求成功" + execute.code());
                    List<Cinema> body = execute.body();
                    Looper looper = handler.getLooper();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView_CinemaFragment.setAdapter(new CinemaPageListAdapter(body, getContext()));
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

       /* allCinema.enqueue(new Callback<List<Cinema>>() {
            @Override
            public void onResponse(Call<List<Cinema>> call, Response<List<Cinema>> response) {
                if (response.body() != null) {

                    Log.e(Consts.TAG, "CinemaDataSource_请求成功" + response.body());
                    List<Cinema> body = response.body();
                    recyclerView_CinemaFragment.setAdapter(new CinemaPageListAdapter(body, getContext()));
                }
            }

            @Override
            public void onFailure(Call<List<Cinema>> call, Throwable t) {
                Log.e(Consts.TAG, "CinemaDataSource_请求失败" + t);
            }
        });*/

}