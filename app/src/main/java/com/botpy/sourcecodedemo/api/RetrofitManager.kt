package com.botpy.sourcecodedemo.api

import com.botpy.baselibrary.api.RetrofitFactory

/**
 * @author liuxuhui
 * @date 2020-04-23
 */
class RetrofitManager : RetrofitFactory<RetrofitApi>() {
    override fun getService(): Class<RetrofitApi> = RetrofitApi::class.java
}

