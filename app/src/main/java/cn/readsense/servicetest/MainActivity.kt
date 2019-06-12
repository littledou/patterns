package cn.readsense.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Parcel
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent()
        intent.component = ComponentName("cn.readsense.servicetest", "cn.readsense.servicetest.ManualCalculatorService")

        bindService(intent, object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {

            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                llog("servicetest running")

                val data = Parcel.obtain()
                val reply = Parcel.obtain()

                data.writeInt(1)
                data.writeInt(2)

                service?.transact(1000, data, reply, 0)

                val result = reply.readInt()
                data.recycle()
                reply.recycle()

                llog("reply: $result")

            }
        }, Context.BIND_AUTO_CREATE)

    }

    fun llog(str: String) {
        Log.d("servicetest", str)
    }
}
