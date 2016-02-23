package ray.com.test;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 可以随意上下拖动的FrameLayout，FrameLayout必须设置点击事件才能捕获到event
 * Created by wangchunlei on 16/2/17.
 */
public class Draglayout extends FrameLayout {
    private ViewDragHelper helper;

    public Draglayout(Context context) {
        super(context);
        initDragHelper();
    }

    public Draglayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDragHelper();
    }

    public Draglayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDragHelper();
    }

    private void initDragHelper() {
        helper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
//                Log.e("ray","tryCaptureView");
                return true;
            }

            @Override
            public void onViewCaptured(View capturedChild, int activePointerId) {
                super.onViewCaptured(capturedChild, activePointerId);
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
//              Log.e("ray","return top="+top);
//              child.findViewById(R.id.view1).invalidate();
                return top;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return super.clampViewPositionHorizontal(child, left, dx);
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return getMeasuredHeight() - child.getMeasuredHeight();
            }

            @Override
            public int getOrderedChildIndex(int index) {
                return super.getOrderedChildIndex(index);
            }
        });
        helper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_BOTTOM);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        helper.processTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return helper.shouldInterceptTouchEvent(ev);
    }
}
