package receiver.ylf.com.receivermanager.com.ylf;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.HashMap;

import receiver.ylf.com.receivermanager.R;
import receiver.ylf.com.receivermanager.com.ylf.com.ylf.view.LineChartView;
import receiver.ylf.com.receivermanager.com.ylf.model.PageViewData;

/**
 * Created by Administrator on 2015/10/12.
 *
 *  折线图UI
 */
public class CharView extends Activity {
    private LineChartView lcv;
    private HashMap<Integer,PageViewData> map=new HashMap<Integer,PageViewData>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lcv= (LineChartView) findViewById(R.id.lcv);
        map.put(1,new PageViewData(1,1,9));
        map.put(2,new PageViewData(2,2,10));
        map.put(3,new PageViewData(3,3,11));
        map.put(4,new PageViewData(4,1,12));
        map.put(5,new PageViewData(5,5,13));
        map.put(6,new PageViewData(6,10,14));
        map.put(7,new PageViewData(7,8,15));
        map.put(8,new PageViewData(8,3,16));
        map.put(9,new PageViewData(9,9,17));
        map.put(10,new PageViewData(10,6,18));
        map.put(11,new PageViewData(11,19,16));
        lcv.setDataTotal(map);
        //设置画笔属性
        lcv.setPaints(Color.argb(255, 225, 250, 250),
                Color.argb(255,234, 234, 250), Color.argb(255,74,208, 204),
                Color.argb(255,105, 210, 249),Color.argb(255,203, 203, 203)
                ,Color.argb(255,255, 255, 255),Color.argb(255,105, 210, 249),Color.argb(255,105, 210, 249));
    }
}
