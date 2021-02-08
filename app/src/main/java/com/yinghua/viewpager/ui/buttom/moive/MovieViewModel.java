package com.yinghua.viewpager.ui.buttom.moive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MovieViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MovieViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
