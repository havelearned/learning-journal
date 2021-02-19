package com.yinghua.jilijili.ui.buttom.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DynamicViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DynamicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is DynamicViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
