package com.botpy.sourcecodedemo.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import com.botpy.sourcecodedemo.aidl.AIDL_Service

/**
 * @author liuxuhui
 * @date 2020-05-06
 */
class BookService : Service() {

    private var mBinder: AIDL_Service.Stub = object : AIDL_Service.Stub() {
        @Throws(RemoteException::class)
        override fun AIDL_service() {
            println("--AIDL_SERVICE--客户端通过 AIDL 与远程后台成功通信")
        }
    }

    override fun onCreate() {
        super.onCreate()
        println("--AIDL_SERVICE--执行了onCreat()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("--AIDL_SERVICE--执行了onStartCommand()")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("--AIDL_SERVICE--执行了onDestory()")
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("--AIDL_SERVICE--执行了onBind()")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("--AIDL_SERVICE--执行了onUnbind()")
        return super.onUnbind(intent)
    }

}