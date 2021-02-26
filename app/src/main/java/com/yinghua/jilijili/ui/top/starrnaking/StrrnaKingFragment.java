package com.yinghua.jilijili.ui.top.starrnaking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.adapter.StrrnaKingAdapter;
import com.yinghua.jilijili.bean.Journalism;
import com.yinghua.jilijili.bean.JournalismCount;
import com.yinghua.jilijili.pagding.jouralism.JournalismAdpater;
import com.yinghua.jilijili.pagding.jouralism.JournalismMode;
import com.yinghua.jilijili.pagding.moviepagding.MovieViewMode;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StrrnaKingFragment extends Fragment {

    RecyclerView rv_journalism;
    JournalismAdpater mJournalismAdpater;
    LiveData<PagedList<Journalism>> mPagedListLiveData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_strrnaking, container, false);
        rv_journalism = view.findViewById(R.id.rv_journalism);
        rv_journalism.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rv_journalism.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        rv_journalism.setHasFixedSize(true);

        mJournalismAdpater= new JournalismAdpater(getContext());


        JournalismMode journalismMode = new ViewModelProvider(this).get(JournalismMode.class);
        journalismMode.moviePageList.observe(getViewLifecycleOwner() , new Observer<PagedList<Journalism>>() {
            @Override
            public void onChanged(PagedList<Journalism> journalisms) {
                mJournalismAdpater.submitList(journalisms);
            }
        });

        rv_journalism.setAdapter(mJournalismAdpater);

 /*       MoviesRetrofitClient
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
                                rv_journalism.setAdapter(new StrrnaKingAdapter(getContext(),list));
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
*/

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}