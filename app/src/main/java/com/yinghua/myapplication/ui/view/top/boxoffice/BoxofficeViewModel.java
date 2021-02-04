package com.yinghua.myapplication.ui.view.top.boxoffice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BoxofficeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BoxofficeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ShowFragment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}