package receiver.ylf.com.receivermanager;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import receiver.ylf.com.receivermanager.com.ylf.receiver.BoothReceiver;
import receiver.ylf.com.receivermanager.com.ylf.receiver.ReceiverMessage;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView=new MyView(this);
        setContentView(myView);
       /* findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              *//*  IntentFilter filter=new IntentFilter();
                filter.addAction("android.intent.action.BOOT_COMPLETED");
                filter.addAction("android.intent.action.ACTION_SHUTDOWN");
                BoothReceiver receiver=new BoothReceiver();
                registerReceiver(receiver, filter);
                IntentFilter msgFilter=new IntentFilter();
                msgFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                ReceiverMessage receiverMessage=new ReceiverMessage();
                registerReceiver(receiverMessage,msgFilter);
                Log.i("111","注册...");*//*
            }
        });*/
    }
    class   MyView extends  View{

        public MyView(Context context) {
            super(context);
            initView();
        }

        private void initView() {
            Paint paint=new Paint();
            paint.setColor(Color.parseColor("#ff00ff"));
            paint.setStyle(Paint.Style.FILL);
            Canvas canvas=new Canvas();
            canvas.drawCircle(0,0,20,paint);
        }
    }


}
