package com.yinghua.viewpager.ui.top.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yinghua.viewpager.bean.Cinema;
import com.yinghua.viewpager.callback.CinemaCallback;

import java.util.List;

public class RecommendViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private MutableLiveData<Integer> count;

    public RecommendViewModel() {
        mText = new MutableLiveData<>();
        count = new MutableLiveData<>();

        count.setValue(0);
        mText.setValue("This is ShowFragment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Integer> getCount(){
        return count;
    }

    public void setCount(){
        count.setValue(getCount().getValue()+1);
    }
}