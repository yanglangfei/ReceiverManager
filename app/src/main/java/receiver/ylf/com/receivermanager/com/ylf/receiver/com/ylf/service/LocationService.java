package receiver.ylf.com.receivermanager.com.ylf.receiver.com.ylf.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by Administrator on 2015/10/9.
 *
 *   监听地理位置
 */
public class LocationService extends Service {
    private LocationClient client;
    private BDLocationListener listener=new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Log.i("111",bdLocation.getLocType()+"");
            int type=bdLocation.getLocType();
            switch (type){
                case  BDLocation.TypeGpsLocation:
                    sendLoadtionInfo(bdLocation);
                    break;
                case  BDLocation.TypeNetWorkLocation:
                    sendLoadtionInfo(bdLocation);
                    break;
                case  BDLocation.TypeOffLineLocation:
                    sendLoadtionInfo(bdLocation);
                    break;
                case  BDLocation.TypeNetWorkException:
                    break;
                case  BDLocation.TypeServerError:
                    break;
                case  BDLocation.TypeCriteriaException:
                    break;
                default:
                    break;
            }
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("111","定位...");
        client=new LocationClient(getApplicationContext());
        client.registerLocationListener(listener);
        LocationClientOption option=new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        client.setLocOption(option);
        client.start();
        Log.i("111","定位启动...");
    }
    public  void sendLoadtionInfo(BDLocation bdLocation){
        String address=bdLocation.getAddrStr();
        Log.i("111","您当前所在位置："+address);

    }
}
