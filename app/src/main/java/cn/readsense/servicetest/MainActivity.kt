package cn.readsense.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    var binder: ManualCalculatorService.LocalBinder? = null
    var manualCalculatorService: ManualCalculatorService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ManualCalculatorService::class.java)
//        intent.component = ComponentName("cn.readsense.servicetest", "cn.readsense.servicetest.ManualCalculatorService")

        var conn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {

            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                llog("servicetest running")
                binder = service as ManualCalculatorService.LocalBinder?

                manualCalculatorService = binder?.service


            }
        }

        bindService(intent, conn, Context.BIND_AUTO_CREATE)


        Thread(Runnable {
            Thread.sleep(1000)
            while(manualCalculatorService?.count!! <=20){

                llog("count : "+manualCalculatorService?.count)
                Thread.sleep(1000)
            }
            unbindService(conn)

        }).start()

    }

    fun llog(str: String) {
        println("activity: $str")
    }
}
