package com.yinghua.jilijili;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.LocaleListCompat;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;


public class LocalhostActivity extends AppCompatActivity {
    private TextView mMapView = null;
    LocationClient localeListCompat;

    MapView mapView;
    BaiduMap baiduMap;

    boolean isFirstLocate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_localhost);
        this.getSupportActionBar().hide();
        mMapView = findViewById(R.id.bmapView);

        /**
         * 获取位置信息
         * 需要一个监听器适配
         * */
        localeListCompat = new LocationClient(getApplicationContext());

        /**
         * 注册一个监听器
         * */
        localeListCompat.registerLocationListener(new MyLocationListener());


        mapView = findViewById(R.id.bdmapview);
        baiduMap = mapView.getMap();//获得百度地图

        /**
         * BaiduMap.MAP_TYPE_SATELLITE 卫星地图
         * BaiduMap.MAP_TYPE_NONE 百度地图
         * */
        baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        baiduMap.setMyLocationEnabled(true);//当前是可以定位的


        /**
         * 权限判断
         * */
        List<String> permissionList = new ArrayList<String>();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        /**
         * 权限给予
         * */
        if (!permissionList.isEmpty()) {
            String[] permissionstr = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(this, permissionstr, 1);
        } else {
            /* *
             * 定位信息的获取是在后台
             * 不能防止主线程上
             * */
            requestLocation();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int resout : grantResults) {
                        if (resout != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须给予权限，否则无法使用改功能", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    /**
                     * 定位信息的获取是在后台
                     * 不能防止主线程上
                     * */
                    requestLocation();
                } else {
                    Toast.makeText(this, "未知的错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    private void requestLocation() {
        //初始化当前位置的参数
        inItLocaion();
        localeListCompat.start();//开始监听客户端的位置
    }

    private void inItLocaion() {
        //配置位置参数
        LocationClientOption option = new LocationClientOption();

        /**
         * 可选，设置定位模式，默认高精度 Hight_Accuracy
         * LocationMode.Hight_Accuracy 高精度
         * LocationMode.Battery_Saving 低功耗
         * LocationMode.Device_Sensors 仅使用设备；
         * */
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);


        /**
         * 可选，设置返回经纬度坐标类型，默认GCJ02
         * GCJ02:国测局坐标；
         * DB09ll:百度经纬度坐标
         * DB09:百度墨卡托坐标
         * 海外地区定位，无需设置坐标类型，同意返回WGS84类型坐标
         * */
        option.setCoorType("bd0911");

        /**
         * 可选，设置发起定位请求的时隔，int类型，单位ms
         * */
        option.setScanSpan(1000);

        /**
         * 是否打开GPS，默认是false
         * 使用高精度和仅使用设备 必须为true
         * */
        option.setOpenGps(true);

        /**
         * 可选，定位SDK内部是一个Service，并放到独立进程
         * 设置是否zaiStop的时候杀死这个进程，默认不杀死，
         * */
        option.setIgnoreKillProcess(false);


        /**
         * 可选，设置是否搜集Crash信息，默认为true 收集，
         * */
        option.SetIgnoreCacheException(false);

        /**
         * 可选，v7.2版本新增能力
         * 如果设置了这个接口，首次启动时，会先判断当前Wifi是否超出有效期，
         * 否则从新扫描Wifi
         * */
        option.setWifiCacheTimeOut(5 * 60 * 100);

        /**
         * 可选，设置是否需要过滤GPS仿真结果，默认需要
         * */
        option.setEnableSimulateGps(false);


        //显示地理位置信息
        option.setIsNeedAddress(true);


        localeListCompat.setLocOption(option);

    }

    /**
     * 继承百度的
     */
    private class MyLocationListener extends BDAbstractLocationListener {

        /**
         * 收到定位信息后需要做什么
         */
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            //定位到客户端所在位置
            navigatTo(bdLocation);

          /*  StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("维度").append(bdLocation.getLatitude()).append("\n");
            currentPosition.append("经度").append(bdLocation.getLongitude()).append("\n");
            currentPosition.append("国家").append(bdLocation.getCountry()).append("\n");
            currentPosition.append("省").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区").append(bdLocation.getDistrict()).append("\n");
            currentPosition.append("村").append(bdLocation.getTown()).append("\n");
            currentPosition.append("街道").append(bdLocation.getStreet()).append("\n");
            currentPosition.append("地址").append(bdLocation.getAddrStr()).append("\n");
            currentPosition.append("定位方式");
            if (bdLocation.getLocType() == bdLocation.TypeGpsLocation) {
                currentPosition.append("GPS");

            } else if (bdLocation.getLocType() == bdLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }

            mMapView.setText(currentPosition.toString());*/
        }
    }

    private void navigatTo(BDLocation bdLocation) {
        if(isFirstLocate) { //如果是第一次定位
            LatLng ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());//获取当前的经纬度

            //更新当前的经纬度
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);

            //将视图缩放到客户端上
            update = MapStatusUpdateFactory.zoomTo(15);
            baiduMap.animateMapStatus(update);

            isFirstLocate=false;
        }
        MyLocationData.Builder builder=new MyLocationData.Builder();
        builder.latitude(bdLocation.getLatitude());
        builder.longitude(bdLocation.getLongitude());

        MyLocationData locationData=builder.build();
        baiduMap.setMyLocationData(locationData);

    }

    //当不需要定位时关闭
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
        localeListCompat.stop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();

    }

}