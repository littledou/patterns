package cn.readsense.servicetest

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log

/**
 * 使用Messenger方式来实现IBinder
 */
class MessengerService : Service() {


    class ServerHandler : Handler() {

        override fun handleMessage(msg: Message?) {

            when {

                msg?.what == MSG_SAY_HELLO -> {
                    llog("client: ${msg.data.getString("req")}")

                    var client = msg.replyTo
                    var messageReply = Message.obtain(null, MSG_SAY_HELLO)
                    var bundle = Bundle()
                    bundle.putString("res", " client , server looking at you")
                    messageReply.data = bundle
                    client.send(messageReply)

                    return
                }

            }

            super.handleMessage(msg)
        }
    }


    override fun onBind(intent: Intent): IBinder {
        llog("onBind")

        return messenger.binder
    }

    override fun onCreate() {
        llog("onCreate")
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        llog("onStart")
        super.onStart(intent, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        llog("onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        llog("onDestroy")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        llog("onStartCommand")

        return super.onStartCommand(intent, flags, startId)
    }


    companion object {
        val messenger = Messenger(ServerHandler())
        const val MSG_SAY_HELLO = 1
        val TAG = "hz"
        fun llog(str: String) {
            Log.d(TAG, str)
        }
    }
}
