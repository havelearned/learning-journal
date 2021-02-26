package com.yinghua.jilijili.pagding.jouralism;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yinghua.jilijili.bean.Journalism;

public class JournalismFactory extends DataSource.Factory<Integer, Journalism> {
    private MutableLiveData<JournalismDataSource> mMutableLiveData=new MutableLiveData();
    @NonNull
    @Override
    public DataSource<Integer, Journalism> create() {
        JournalismDataSource dataSource=new JournalismDataSource();
        mMutableLiveData.postValue(dataSource);
        return dataSource;
    }
}
