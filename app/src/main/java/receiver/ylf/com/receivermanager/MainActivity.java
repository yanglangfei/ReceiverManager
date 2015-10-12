package receiver.ylf.com.receivermanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    private ViewFlipper viewFlipper;
    private float start;
    private float end;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();

    }

    private void initWidget() {
        inflater=LayoutInflater.from(this);
        viewFlipper= (ViewFlipper) findViewById(R.id.viewFilpper);
        View view1=inflater.inflate(R.layout.pager1,null);
        View view2=inflater.inflate(R.layout.pager2,null);
        View view3=inflater.inflate(R.layout.pager3,null);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.addView(view3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                start=event.getX();
                break;
            case  MotionEvent.ACTION_UP:
                end=event.getX();
                if(end>start){
                    viewFlipper.setInAnimation(this,R.anim.in_leftright);
                    viewFlipper.setOutAnimation(this,R.anim.out_rightleft);
                    viewFlipper.showNext();
                }else if(end<start){
                    viewFlipper.setInAnimation(this,R.anim.in_rightleft);
                    viewFlipper.setOutAnimation(this,R.anim.out_leftright);
                   viewFlipper.showPrevious();
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
