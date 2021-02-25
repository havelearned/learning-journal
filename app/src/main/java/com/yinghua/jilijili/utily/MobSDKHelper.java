package com.yinghua.jilijili.utily;


public class MobSDKHelper {
    private static MobSDKHelper mMobSDKHelper;

    public MobSDKHelper() {
    }

    public static synchronized MobSDKHelper getInstance(){
        if (mMobSDKHelper != null) {
            mMobSDKHelper = new MobSDKHelper();
        }
        return mMobSDKHelper;
    }
}
