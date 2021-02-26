package com.yinghua.jilijili.ui.top.starrnaking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.adapter.StrrnaKingAdapter;
import com.yinghua.jilijili.bean.Journalism;
import com.yinghua.jilijili.bean.JournalismCount;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StrrnaKingFragment extends Fragment {

    RecyclerView rv_journalism;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_strrnaking, container, false);
        rv_journalism = view.findViewById(R.id.rv_journalism);
        MoviesRetrofitClient
                .getInstance("https://way.jd.com/jisuapi/")
                .mJournalismService()
                .requestJournalismList("头条", 10, 1, "4e69e20b3c7f735e7a6ba1ad250c4ef3")
                .enqueue(new Callback<Journalism>() {
                    @Override
                    public void onResponse(Call<Journalism> call, Response<Journalism> response) {
                        Log.e(Consts.TAG, "请求：" + response.raw());
                        if (response.body() != null) {
                            if (response.code() == 200) {
                                List<Journalism.ResultDTOX.ResultDTO.ListDTO> list = response.body().getResult().getResult().getList();
                                rv_journalism.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                rv_journalism.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                                rv_journalism.setAdapter(new StrrnaKingAdapter(getContext(), list));
                            }
                        } else {
                            Log.e(Consts.TAG, "请求：" + response.raw());
                        }
                    }

                    @Override
                    public void onFailure(Call<Journalism> call, Throwable t) {
                        Log.e(Consts.TAG, "请求：" + t.getMessage());
                    }
                });


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}