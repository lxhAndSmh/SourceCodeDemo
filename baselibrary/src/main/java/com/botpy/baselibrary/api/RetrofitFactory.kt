package com.botpy.baselibrary.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author liuxuhui
 * @date 2020-04-23
 */
abstract class RetrofitFactory<T> {
    var service: T
    private var baseUrl = "https://www.wanandroid.com/"
    private lateinit var retrofit: Retrofit
    abstract fun getService(): Class<T>

    init {
        service = getRetrofit()!!.create(this.getService())
    }

    private fun getRetrofit(): Retrofit? {
        if(retrofit == null) {
            synchronized(RetrofitFactory::class.java) {
                if(retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(attachOkHttpClient())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
        }
        return retrofit
    }

    private fun attachOkHttpClient(): OkHttpClient {
        var builder = OkHttpClient().newBuilder()
        builder.readTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        return builder.build()
    }
}