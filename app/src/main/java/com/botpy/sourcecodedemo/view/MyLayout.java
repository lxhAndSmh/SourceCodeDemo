package com.botpy.sourcecodedemo.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author liuxuhui
 * @date 2020-04-17
 */
public class MyLayout extends RelativeLayout {
    private Context context;
    public MyLayout(Context context) {
        this(context, null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context.getApplicationContext();

    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int layoutWidth = MeasureSpec.getSize(widthMeasureSpec);
        int layoutHeight = MeasureSpec.getSize(heightMeasureSpec);

        int height = 0;
        int width = 0;
        while (height < layoutHeight) {
            TextView textView = new TextView(context);
            textView.setText("李雷\n18310245689");
            textView.setTextColor(Color.parseColor("#33000056"));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            textView.measure(spec, spec);
            if(width + textView.getMeasuredWidth() + dip2px(context, 80)< layoutWidth) {
                width += dip2px(context, 80);
            }else {
                width = 0;
            }
            layoutParams.leftMargin = width;
            layoutParams.topMargin = height;
            addView(textView, layoutParams);

            height += dip2px(context, 50);

        }
    }
}
