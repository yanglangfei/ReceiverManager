package receiver.ylf.com.receivermanager.com.ylf;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.HashMap;

import receiver.ylf.com.receivermanager.R;
import receiver.ylf.com.receivermanager.com.ylf.model.HistogramData;

/**
 * Created by Administrator on 2015/10/12.
 *
 * 柱状图UI
 */
public class HistogramView extends Activity {
    private HashMap<Integer, HistogramData> mDataHistogramTotal;
    private receiver.ylf.com.receivermanager.com.ylf.com.ylf.view.HistogramView lcv;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataHistogramTotal = new HashMap<>();
        lcv= (receiver.ylf.com.receivermanager.com.ylf.com.ylf.view.HistogramView) findViewById(R.id.lcv);
        mDataHistogramTotal.put(1,new HistogramData(1,"海萌",10));
        mDataHistogramTotal.put(2,new HistogramData(2,"涛涛",18));
        mDataHistogramTotal.put(3,new HistogramData(3,"火风",17));
        mDataHistogramTotal.put(4,new HistogramData(4,"周杰伦",16));
        mDataHistogramTotal.put(5,new HistogramData(5,"王宝强",15));
        mDataHistogramTotal.put(6,new HistogramData(6,"林俊杰",14));
        mDataHistogramTotal.put(7,new HistogramData(7,"孙悟空",11));
        mDataHistogramTotal.put(8,new HistogramData(8,"钟航",10));
        mDataHistogramTotal.put(9,new HistogramData(9,"小明",8));
        mDataHistogramTotal.put(10, new HistogramData(10, "小红", 5));

        lcv.setDataTotal(mDataHistogramTotal);
        lcv.setPaints(Color.argb(255, 250, 250, 250),
                Color.argb(255,238, 238, 238), Color.argb(255,240,141, 77),
                Color.argb(255,168, 168, 168));
        // initWidget();

    }
}
