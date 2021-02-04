package com.yinghua.viewpager.ui.top.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    private MutableLiveData<Integer> count;

    public RecommendViewModel() {
        mText = new MutableLiveData<>();
        count = new MutableLiveData<>();
        mText.setValue("This is ShowFragment fragment");
        count.setValue(0);
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