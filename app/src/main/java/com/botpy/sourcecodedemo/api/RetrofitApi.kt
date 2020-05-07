package com.botpy.sourcecodedemo.api

import okhttp3.Call
import retrofit2.http.GET

/**
 * @author liuxuhui
 * @date 2020-04-23
 */
interface RetrofitApi {

    @GET("wxarticle/chapters/json")
    fun getWxarticleJson() : Call
}