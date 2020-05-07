package com.botpy.sourcecodedemo.view

import android.content.Context

class CommonUtil {

    companion object {
        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        fun  dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }
    }

}
