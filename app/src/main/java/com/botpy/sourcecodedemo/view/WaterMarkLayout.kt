package com.botpy.sourcecodedemo.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi

/**
 * 添加水印的布局
 * @author liuxuhui
 * @date 2020-04-17
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class WaterMarkLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes)  {

    init {
        Log.d("WaterMarkLayout", "4")

    }
    constructor(context: Context?) : this(context, null, 0, 0) {
        Log.d("WaterMarkLayout", "1")
    }
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0) {
        Log.d("WaterMarkLayout", "3")
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context?, dpValue: Float): Int {
        val scale = context?.resources?.displayMetrics?.density
        return (dpValue * scale!! + 0.5f).toInt()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("WaterMarkLayout", "2")
        var width = 0
        var height = 0
        var textView = TextView(context)
        textView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView.text = "李雷\n18301421070"
        textView.setTextColor(Color.parseColor("#69467798"))
        textView.textSize = 16f
        var textViewWidth = textView.width
        while (height < getHeight()) {
            if(width + textViewWidth < getWidth() || width < 0) {
                width += dip2px(context, 30f)
            }else {
                width -= dip2px(context, 30f)
            }
            textView.left = width
            textView.top = height
//            var layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
//            addView(textView, layoutParams)
            addView(textView)
            height += dip2px(context, 30f)
        }
    }
}