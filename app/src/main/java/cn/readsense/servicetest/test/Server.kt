package cn.readsense.servicetest.test

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import cn.readsense.servicetest.MemoryService
import java.lang.reflect.Method

class Server : Service() {
    private var memoryService: MemoryService? = null

    override fun onCreate() {
        super.onCreate()
        llog("create memory service")

        memoryService = MemoryService("Ashmem_test1", 4)


        var method: Method? = null
        try {
            method = Class.forName("android.os.ServiceManager")
                .getMethod("addService", String::class.java, Binder::class.java)
            method!!.invoke(null, "AnonymousSharedMemory", memoryService)

            llog("Succeed to add memory service.")
        } catch (e: Exception) {
            e.printStackTrace()
            llog("Failed to add Memory Service ${e.message}")
        }


    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    fun llog(str: String) {
        Log.d("Server", str)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        llog("start Memory service")
    }

    override fun onDestroy() {
        llog("Destroy Memory service")
    }

}
