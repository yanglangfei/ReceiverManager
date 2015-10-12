package receiver.ylf.com.receivermanager.com.ylf.com.ylf.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;

import receiver.ylf.com.receivermanager.com.ylf.model.HistogramData;

/**
 * Created by Administrator on 2015/10/12.
 *
 *  柱形图
 */
public class HistogramView extends View{
    private int width;
    private int height;
    private Paint mBgPaint;
    private Paint mHistogramBgPaint;
    private Paint mHistogramPaint;
    private Paint mTextPaint;

    private HashMap<Integer,HistogramData> dataTotal;


    public HistogramView(Context context) {
        super(context);
    }
    public void setPaints(int bgColor,int histogramBgColor,int histogramColor,int textColor){

        mBgPaint.setColor(bgColor);
        mBgPaint.setStyle(Paint.Style.FILL);

        mHistogramBgPaint.setColor(histogramBgColor);
        mHistogramBgPaint.setStyle(Paint.Style.FILL);

        mHistogramPaint.setColor(histogramColor);
        mHistogramPaint.setStyle(Paint.Style.FILL);

        mTextPaint.setColor(textColor);
        mTextPaint.setTextSize(9);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        invalidate();
    };

    public void setDataTotal(HashMap<Integer, HistogramData> dataTotal) {
        this.dataTotal = dataTotal;
        invalidate();
    }


    public HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHistogramBgPaint = new Paint();
        mHistogramPaint = new Paint();
        mTextPaint = new Paint();
        mBgPaint = new Paint();

        dataTotal = new HashMap<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(dataTotal!=null){
            width = dataTotal.size()*60;
        }
        height = getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int mHistogramHeight;
    int startX = 20;
    int startY = 20;
    int radius = 45;
    int greyValueAlignLeft = 5;
    int nameAlignLeft = 15;
    int greyValueAlignBottom = 5;
    int nameAlignBottom = 15;
    int histogramWidth = 18;    //柱状图宽度
    int xAddedNum = 40;
    int histogramAlignTop = 2;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mHistogramHeight = height-40;
        canvas.drawRect(0,startY,width,mHistogramHeight,mBgPaint);
        for(int key:dataTotal.keySet()){
            String name = dataTotal.get(key).getName();
            int greyValue = dataTotal.get(key).getGreyValue();

            canvas.drawText(greyValue + "%", startX + greyValueAlignLeft, startY-greyValueAlignBottom , mTextPaint);
            canvas.drawRect(startX, startY+histogramAlignTop, startX + histogramWidth, mHistogramHeight, mHistogramBgPaint);
            canvas.drawRect(startX, startY+(1f - greyValue / 100f) * (mHistogramHeight - startY-histogramAlignTop)+histogramAlignTop, startX + histogramWidth, mHistogramHeight, mHistogramPaint);

            canvas.save();
            canvas.rotate(-radius, startX,height);
            canvas.drawText(name, startX + nameAlignLeft, height-nameAlignBottom, mTextPaint);
            canvas.restore();
            startX+=xAddedNum;
        }
        startX = 20;
    }
}
