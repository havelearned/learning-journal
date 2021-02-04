package com.yinghua.myapplication.ui.view.top.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public RecommendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ShowFragment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}