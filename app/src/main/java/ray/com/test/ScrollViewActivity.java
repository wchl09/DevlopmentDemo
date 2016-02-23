package ray.com.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;

public class ScrollViewActivity extends AppCompatActivity {
    private MyScrollView myScrollView;
    private View topView;
    //    private LinearLayout.LayoutParams params;
    private int topViewHeight, topViewWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        myScrollView = (MyScrollView) findViewById(R.id.myScrollView);
        topView = myScrollView.findViewById(R.id.topImage);
        myScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
//                params= (LinearLayout.LayoutParams) topView.getLayoutParams();
                    topViewHeight = topView.getHeight();
                    topViewWidth = topView.getWidth();
                myScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        myScrollView.setScrollListener(new MyScrollView.MyScrollViewInterface() {
            @Override
            public void overScrollY(int deltaY) {
//                Log.e("Ray", "overScrolly:deltaY=" + deltaY + ",params.height=" + topViewHeight);
//                topView.setScaleY(Math.abs(deltaY));
//                params=topView
//                params.height+=Math.abs(deltaY);
                if (deltaY < 0) {//下拉超过时才触发
                    topView.setScaleY(deltaY);
//                    topView.setLayoutParams(new LinearLayout.LayoutParams(topViewWidth, topViewHeight + Math.abs(deltaY*20)));
                }
            }
        });
    }

}
