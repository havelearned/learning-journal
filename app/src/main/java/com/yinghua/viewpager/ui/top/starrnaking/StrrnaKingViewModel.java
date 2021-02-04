package com.yinghua.viewpager.ui.top.starrnaking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StrrnaKingViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public StrrnaKingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ShowFragment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}