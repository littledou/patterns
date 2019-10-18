package cn.readsense.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MessengerService::class.java)
//        intent.component = ComponentName("cn.readsense.servicetest", "cn.readsense.servicetest.ManualCalculatorService")

        var conn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                llog("onServiceDisconnected")
                mService = null
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                llog("servicetest running")
                mService = Messenger(service)
            }
        }


        /**
         * test bind send receiver unbind
         * unbindService之后，仍可通信
         */
        Thread(Runnable {

            bindService(intent, conn, Context.BIND_AUTO_CREATE)
            Thread.sleep(1000)

            var message = Message.obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0)
            var bundle = Bundle()
            bundle.putString("req", "hello server, this is client!")
            message.data = bundle
            message.replyTo = Messenger(clientHandler)
            mService?.send(message)

            Thread.sleep(1000)
            unbindService(conn)


        }).start()

    }



    class ClientHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            when {
                msg?.what == MessengerService.MSG_SAY_HELLO -> {
                    llog("server: ${msg.data.getString("res")}")

                    var message = Message.obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0)
                    var bundle = Bundle()
                    bundle.putString("req", "hello server, this is client!")
                    message.data = bundle
                    message.replyTo = Messenger(clientHandler)
                    mService?.send(message)
                    return
                }
            }

            super.handleMessage(msg)
        }
    }

    companion object {
        val clientHandler: ClientHandler = ClientHandler()
        var mService: Messenger? = null
        fun llog(str: String) {
            println("activity: $str")
        }
    }


}
