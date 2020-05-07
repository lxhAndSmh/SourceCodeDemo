package com.botpy.baselibrary.customerglide

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

/**
 * @author liuxuhui
 * @date 2020-03-26
 */
class Glidee () : AppCompatActivity(){
    fun main() {
        Glide.with(this)
            .load("")
            .fitCenter()
    }
}