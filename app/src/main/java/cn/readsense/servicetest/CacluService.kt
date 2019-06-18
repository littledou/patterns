package cn.readsense.servicetest

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CacluService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }


    var binder: CalcManage.Stub = object : CalcManage.Stub() {
        override fun plus(a: Int, b: Int): Int {
            return a + b
        }

        override fun min(a: Int, b: Int): Int {
            return a - b
        }

    }


}
