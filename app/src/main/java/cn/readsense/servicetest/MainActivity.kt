package cn.readsense.servicetest

import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.os.MemoryFile
import android.os.RemoteException
import android.system.OsConstants.PROT_READ
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ms = getMemoryService()

        if (ms == null) {
            val intent = Intent()
            intent.action = "cn.readsense.servicetest.test.Server"
            intent.setPackage(packageName)
            startService(intent)
        } else {
            llog("Memory Service has started.")
        }


//        Thread(
//            object : Runnable {
//                override fun run() {
//                    while (true) {
//
//                        llog("thread start")
//                        Thread.sleep(1000)
//                    }
//                }
//
//            }
//        ).start()


    }

    private var memoryService: IMemoryService? = null

    private fun getMemoryService(): IMemoryService? {
        if (memoryService != null) return memoryService
        var method: Method? = null
        try {
            method = Class.forName("android.os.ServiceManager").getMethod("getService", String::class.java)
            val binder = method!!.invoke(null, "cn.readsense.servicetest.IMemoryService") as? IBinder
            memoryService = IMemoryService.Stub.asInterface(binder)
            return memoryService
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return null
    }

    internal var memoryFile: MemoryFile? = null

    private fun getMemoryFile(): MemoryFile? {
        if (memoryFile != null) {
            return memoryFile
        }

        val ms = getMemoryService()
        if (ms != null) {
            try {
                val pfd = ms.fileDescriptor
                if (pfd == null) {
                    llog("Failed to get memory file descriptor.")
                    return null
                }

                try {
                    val fd = pfd.fileDescriptor
                    if (fd == null) {
                        llog("Failed to get memeory file descriptor.")
                        return null
                    }

                    memoryFile = MemoryFileHelper.openMemoryFile(fd, 4, PROT_READ)
                } catch (ex: IOException) {
                    llog("Failed to create memory file.")
                    ex.printStackTrace()
                }

            } catch (ex: RemoteException) {
                llog("Failed to get file descriptor from memory service.")
                ex.printStackTrace()
            }

        }
        return memoryFile
    }

    fun llog(str: String) {
        Log.d("servicetest", str)
    }
}
