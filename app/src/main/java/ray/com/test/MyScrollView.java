package ray.com.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 * 下拉可以越界
 * <p>
 *     遇到的问题
 *     1、使用修改overScrollBy的maxOverScrollY值得方法存在BUG，filling时不能回弹
 *     2、使用overScrollBy方法+修改Layoutparmar，会出现抖动，overScrollyBy传入的参数不是线性变化
 *     <p/>
 * Created by wangchunlei on 16/2/16.
 */
public class MyScrollView extends ScrollView {
    private static final String TAG = "ray";
    /**
     * 下拉可以超出的范围（像素）
     */
    private final int DEFAULT_MAXOVERSCROLLY = 200;
    private MyScrollViewInterface myScrollViewInterface;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Log.e(TAG, "overScrollBy:" + "deltay=" + deltaY + "scrolly=" + scrollY + "maxOverScrolly=" + maxOverScrollY + "isTouch=" + isTouchEvent);
        if (myScrollViewInterface != null) {
            myScrollViewInterface.overScrollY(scrollY);
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, 6000, isTouchEvent);
//        final int overScrollMode = getOverScrollMode();
//        final boolean canScrollHorizontal =
//                computeHorizontalScrollRange() > computeHorizontalScrollExtent();
//        final boolean canScrollVertical =
//                computeVerticalScrollRange() > computeVerticalScrollExtent();
//        final boolean overScrollHorizontal = overScrollMode == OVER_SCROLL_ALWAYS ||
//                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollHorizontal);
//        final boolean overScrollVertical = overScrollMode == OVER_SCROLL_ALWAYS ||
//                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollVertical);
//
//        int newScrollX = scrollX + deltaX;
//        if (!overScrollHorizontal) {
//            maxOverScrollX = 0;
//        }
//
//        int newScrollY = scrollY + deltaY;
//        if (!overScrollVertical) {
//            maxOverScrollY = 0;
//        }
//
//        // Clamp values if at the limits and record
//        final int left = -maxOverScrollX;
//        final int right = maxOverScrollX + scrollRangeX;
//        final int top = -maxOverScrollY;
//        final int bottom = maxOverScrollY + scrollRangeY;
//
//        boolean clampedX = false;
//        if (newScrollX > right) {
//            newScrollX = right;
//            clampedX = true;
//        } else if (newScrollX < left) {
//            newScrollX = left;
//            clampedX = true;
//        }
//
//        boolean clampedY = false;
//        if (newScrollY > bottom) {
//            newScrollY = bottom;
//            clampedY = true;
//        } else if (newScrollY < top - DEFAULT_MAXOVERSCROLLY) {//改变下拉的range
//            newScrollY = top - DEFAULT_MAXOVERSCROLLY;
//            clampedY = true;
//        }
//
//        onOverScrolled(newScrollX, newScrollY, clampedX, clampedY);
//
//        return clampedX || clampedY;
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
//        Log.e(TAG, "onOVerScrolled:" + "scrolly=" + scrollY + "clampedy=" + clampedY);
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
//        computeScroll();
//        if (clampedY){
//            scrollTo(0,DEFAULT_MAXOVERSCROLLY);
//        }
    }

    public void setScrollListener(MyScrollViewInterface listener) {
        this.myScrollViewInterface = listener;
    }

    interface MyScrollViewInterface {
        public void overScrollY(int deltaY);
    }
}
