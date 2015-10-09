package receiver.ylf.com.receivermanager.com.ylf.receiver.com.ylf.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Administrator on 2015/10/9.
 *
 *  监听通话
 */
public class CallService extends Service {
    private TelephonyManager telephonyManager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("111","监听通话....");
        telephonyManager= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        final MediaRecorder recorder=new MediaRecorder();
        //设置录制声音来源：MIC 麦克风 DEFAULT 默认声源
        recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //设置audio的编码格式
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //设置录音文件保存路径
        recorder.setOutputFile("");
        PhoneStateListener listener=new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state){
                    case  TelephonyManager.CALL_STATE_IDLE:
                        //无任何状态
                        break;
                    case  TelephonyManager.CALL_STATE_OFFHOOK:
                        //挂机
                        recorder.stop();
                        recorder.release();
                        recorder.reset();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        //响铃
                        try {
                            Log.i("111",incomingNumber+"：来电");
                            recorder.prepare();
                            recorder.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        telephonyManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }
}
