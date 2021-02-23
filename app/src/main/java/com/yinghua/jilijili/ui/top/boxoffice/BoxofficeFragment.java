package com.yinghua.jilijili.ui.top.boxoffice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.adapter.BoxofficeAdapter;
import com.yinghua.jilijili.bean.DouBan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BoxofficeFragment extends Fragment {
    private RecyclerView box_recyclerview;
    private RequestQueue mRequestQueue;
    private List<DouBan> mMovieList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_boxoffice, container, false);
        Bundle arguments = getArguments();
        if(arguments!=null){
            String params = arguments.getString("params");
            System.out.println(params+"=========================================================");
        }else{
            System.out.println("===================params空的======================================");
        }
        initData(new VolleyCallback() {
            @Override
            public void onSuccess(List<DouBan> result) {
                box_recyclerview=root.findViewById(R.id.box_recyclerview );
                box_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

                box_recyclerview.setAdapter(new BoxofficeAdapter(result, getContext()));

            }
        });

        return root;
    }

    public List<DouBan>  initData(VolleyCallback callback) {
        mMovieList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(getContext());
        String url = "http://api.douban.com/v2/movie/weekly?apikey=0df993c66c0c636e29ecbb5344252a4a&start=1&count=20";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray subjects = response.getJSONArray("subjects");
                    for (int i = 0; i < subjects.length(); i++) {
                        //如果是分页，这是分页的下标数据
                        JSONObject subject = subjects.getJSONObject(i);

                        //取出subject 节点所有数据
                        JSONObject subject1 = subject.getJSONObject("subject");

                        //导演
                        JSONArray directors = subject1.getJSONArray("directors");
                        JSONObject jsonObject = directors.getJSONObject(0);
                        String name = jsonObject.getString("name");


                        //豆瓣电影详情连接
                        String alt = subject1.getString("alt");

                        //时长
                        String durations = subject1.getString("durations");

                        //上映时间
                        String pubdates = subject1.getString("pubdates");

                        //电影id
                        String id = subject1.getString("id");

                        //评分
                        JSONObject rating = subject1.getJSONObject("rating");
                        String average = rating.getString("average");

                        //标题
                        String title = subject1.getString("title");

                        //图片
                        JSONObject images = subject1.getJSONObject("images");
                        String small = images.getString("small");

                        DouBan movies = new DouBan(id,title,small,average,pubdates, durations,alt,name);
                        System.out.println(movies.toString());
                        mMovieList.add(i,movies);
                    }
                    callback.onSuccess(mMovieList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
        mRequestQueue.add(jsonObjectRequest);
        return mMovieList;
    }

    public interface VolleyCallback {
        void onSuccess(List<DouBan> result);
    }
}