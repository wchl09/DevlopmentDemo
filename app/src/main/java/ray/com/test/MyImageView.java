package ray.com.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;

/**
 * 视差移动的ImageView
 * <p>
 * 设计思路：计算当前组件到父布局中可以滚动的的布局的头部和尾部的距离再映射到图片上，再把映射的图片部分绘制到组件上
 * </p>
 * 父布局滚动或当前组件在父布局中位置发生改变时，调用当前组件的再次计算，重新绘制图片
 * <p>
 * PS:只写了上下的视差效果，左右的视差原理也一样
 * </p>
 * Created by wangchunlei on 16/1/14.
 */
public class MyImageView extends ImageView {
    private final String TAG = "ray";
    /**
     * 视图的坐标
     */
    private Rect parentRect = new Rect(), thisRect = new Rect();
    /**
     * 要绘制的图片
     */
    private Bitmap mBitmap;
    /**
     * 视差度数，是组件到可以滚动的父组件的上下的高度分别乘以度数
     */
    private float radius = 0.2f;
    /**
     * 等比放大，宽也要放大
     */
    private int bitmapLeft = 0, bitmapRight = 0;

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (parentRect.height() == 0 && getParent() != null) {
            findListView(this);
            bitmapLeft = getBitmapLeft();
            bitmapRight = mBitmap.getWidth() - bitmapLeft;
        }
        drawBitmap(canvas);
    }

    /**
     * 初始化父组件的坐标，必须是AbsListView（其它的也可以替换名称）
     *
     * @param view
     */
    private void findListView(View view) {
        View parent = (View) view.getParent();
        if (parent instanceof AbsListView) {
            parent.getGlobalVisibleRect(parentRect);
        } else {
            findListView(parent);
        }
    }

    /**
     * 画图片
     *
     * @param canvas
     */
    private void drawBitmap(Canvas canvas) {
        if (mBitmap == null) {
            mBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            return;
        }
        getGlobalVisibleRect(thisRect);
        int top = getTopHeight();
        int bottom = getBottomHeight();
        Rect src = new Rect(bitmapLeft, top, bitmapRight, mBitmap.getHeight() - bottom);
        Rect dst = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(mBitmap, src, dst, null);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            mBitmap = ((BitmapDrawable) drawable).getBitmap();
            invalidate();
        }
//        super.setImageDrawable();
    }


    /**
     * 获取ImageView到可以滚动的View的上部分的距离
     *
     * @return
     */
    private int getTopHeight() {
        if (thisRect.top <= parentRect.top) {//超出后返回0
            return 0;
        } else if (thisRect.bottom >= parentRect.bottom) {//如果是下边超出，高度就不用变化
            return (int) (mBitmap.getHeight() * Double.valueOf(parentRect.height() - getHeight()) / parentRect.height() * radius);
        }
        return (int) (mBitmap.getHeight() * Double.valueOf(thisRect.top - parentRect.top) / parentRect.height() * radius);
    }

    /**
     * 获取ImageView到可以滚动的View的下部分的距离
     *
     * @return
     */
    private int getBottomHeight() {
        if (thisRect.bottom >= parentRect.bottom) {//超出后返回0
            return 0;
        } else if (thisRect.top <= parentRect.top) {//如果是上边超出，高度就不能变化了
            return (int) (mBitmap.getHeight() * Double.valueOf(parentRect.height() - getHeight()) / parentRect.height() * radius);
        }
        return (int) (mBitmap.getHeight() * Double.valueOf(parentRect.bottom - thisRect.bottom) / parentRect.height() * radius);
    }

    /**
     * 获取图片的左边距
     *
     * @return
     */
    private int getBitmapLeft() {
        //根据imageview的宽高比，用绘制的高度求出宽度
//         (parentRect.height() - ((parentRect.height() - getHeight()) * radius)) / parentRect.height() * mBitmap.getHeight() * getWidth() / getHeight();
        //分解上边的公式
        float scale = Float.valueOf(getWidth()) / getHeight();
        float width = (1 - radius + getHeight() * radius / parentRect.height()) * mBitmap.getHeight() * scale;
        if (width > mBitmap.getWidth()) {
            return 0;
        } else {
            return (int) ((mBitmap.getWidth() - width)) >> 1;
        }
    }

    /**
     * 设置视差度数
     *
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mBitmap != null)
            mBitmap.recycle();
        super.onDetachedFromWindow();
    }
}
