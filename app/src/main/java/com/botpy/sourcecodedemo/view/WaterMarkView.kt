package com.botpy.sourcecodedemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.text.TextPaint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.RequiresApi
import com.botpy.sourcecodedemo.R

/**
 * 仿企业微信水印功能
 * @author liuxuhui
 * @date 2020-05-07
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class WaterMarkView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : View(context, attrs, defStyleAttr, defStyleRes)  {

    private var textSize = 0
    private var textColor = 0
    private var textStr = ""
    init {
        var typedArray = context?.obtainStyledAttributes(attrs, R.styleable.WaterMarkView)
        textSize = typedArray?.getDimensionPixelSize(R.styleable.WaterMarkView_water_mark_text_size
                , TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12F, context?.resources?.displayMetrics).toInt())!!
        textColor = typedArray?.getColor(R.styleable.WaterMarkView_water_mark_text_color
                , Color.parseColor("#4D999999"))
        textStr = typedArray?.getString(R.styleable.WaterMarkView_water_mark_text_str).toString()
        typedArray.recycle()
        initPaint()
    }

    private lateinit var textPaint: TextPaint
    private fun initPaint() {
        textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        textPaint.textSize = textSize.toFloat()
        textPaint.color = textColor
        textPaint.textAlign = Paint.Align.CENTER
    }

    private var viewWidth = 0
    private var viewHeight = 0
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        require("null" != textStr) { "water_mark_text_str can't empty" }
        var rect = Rect()
        textPaint.getTextBounds(textStr, 0, textStr.length, rect)

        var width = CommonUtil.dip2px(context, 30f)
        var height = CommonUtil.dip2px(context, 30f)
        var count = 0
        while (height < viewHeight) {
            while(width < viewWidth) {
                canvas?.save()
                // 旋转角度
                canvas?.rotate((-30).toFloat())
                canvas?.drawText(textStr, width.toFloat(), height.toFloat(), textPaint)
                canvas?.restore()
                width += rect.width() + CommonUtil.dip2px(context, 30f)
            }

            width = CommonUtil.dip2px(context, -80f) * count
            count++
            height += CommonUtil.dip2px(context, 100f)
        }
    }

    constructor(context: Context?) : this(context, null, 0, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
}