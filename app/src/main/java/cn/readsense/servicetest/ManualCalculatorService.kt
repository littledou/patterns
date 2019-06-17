package cn.readsense.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder


/**
 * 采用扩展Binder方式来实现IBinder
 */
class ManualCalculatorService : Service() {


    internal var binder = LocalBinder()

    var count = 0

    var quit = false

    inner class LocalBinder : Binder() {
        // 声明一个方法，getService。（提供给客户端调用）
        // 返回当前对象LocalService,这样我们就可在客户端端调用Service的公共方法了
        internal val service: ManualCalculatorService
            get() = this@ManualCalculatorService
    }

    override fun onBind(intent: Intent): IBinder {
        println("onBind invoke")
        return binder

    }

    override fun onCreate() {
        println("onCreate invoke")
        super.onCreate()

        Thread(Runnable {

            while (!quit) {
                Thread.sleep(1000)

                count++

                println("count: $count")
            }

        }).start()
    }


    override fun onStart(intent: Intent?, startId: Int) {
        println("onStart invoke")
        super.onStart(intent, startId)
        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onStartCommand invoke")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("onUnbind invoke")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        println("onDestroy invoke")
        super.onDestroy()
        quit = true
    }


}
