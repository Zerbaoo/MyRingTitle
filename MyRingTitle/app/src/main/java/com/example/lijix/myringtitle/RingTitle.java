package com.example.lijix.myringtitle;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lijix on 2017/8/29.
 */

public class RingTitle extends View{
    private Paint mPaint;
    private int bgColor_ringTitle;
    private float radius_ringTitle;
    private float textSize_ringTitle;
    private String text_ringTitle;

    public RingTitle(Context context) {
        super(context);
    }

    public RingTitle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RingTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       /*获取自定义属性集合*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StyleRingTitle);
        bgColor_ringTitle = typedArray.getColor(R.styleable.StyleRingTitle_bgColor_ringTitle,Color.BLUE);
        radius_ringTitle = typedArray.getDimension(R.styleable.StyleRingTitle_radius_ringTitle,100f);
        textSize_ringTitle = typedArray.getDimension(R.styleable.StyleRingTitle_textSize_ringTitle,100f);
        text_ringTitle = typedArray.getString(R.styleable.StyleRingTitle_text_ringTitle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        toDrawRingTitle(canvas);

    }

    private RectF mCircleRect;
    private RectF mRingRect;
    private void toDrawRingTitle(Canvas canvas) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint.setAntiAlias(true);                       //设置画笔为无锯齿
        mPaint.setColor(bgColor_ringTitle);                    //设置画笔颜色
        mPaint.setStrokeWidth((float) 3.0);              //线宽
        mPaint.setStyle(Paint.Style.FILL);
        //圆心
        float circleCenter = getWidth() / 2;
        /*画圆*/
        canvas.drawCircle(circleCenter, circleCenter, radius_ringTitle, mPaint);

        mPaint.setStrokeWidth((float) 3.0);              //线宽
        mPaint.setStyle(Paint.Style.STROKE);

       RectF oval = new RectF(circleCenter - radius_ringTitle-10, circleCenter - radius_ringTitle-10, circleCenter
                + radius_ringTitle+10, circleCenter + radius_ringTitle+10);
        canvas.drawArc(oval, 110, 200, false, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(textSize_ringTitle);

        Rect rect = new Rect();
        String text = text_ringTitle;
        mPaint.getTextBounds(text, 0, text.length(), rect);
        int width = rect.width();//文本的宽度
        int height = rect.height();//文本的高度
        canvas.drawText(text,circleCenter-width/2,circleCenter+height/2,mPaint);
    }

    public void setBgColor_ringTitle(int bgColor_ringTitle) {
        this.bgColor_ringTitle = bgColor_ringTitle;
    }

    public void setRadius_ringTitle(float radius_ringTitle) {
        this.radius_ringTitle = radius_ringTitle;
    }

    public void setTextSize_ringTitle(float textSize_ringTitle) {
        this.textSize_ringTitle = textSize_ringTitle;
    }

    public void setText_ringTitle(String text_ringTitle) {
        this.text_ringTitle = text_ringTitle;
    }
}
