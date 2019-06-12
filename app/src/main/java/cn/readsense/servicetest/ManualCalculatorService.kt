package cn.readsense.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.os.RemoteException

class ManualCalculatorService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return object : Binder() {
            @Throws(RemoteException::class)
            override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {

                when (code) {
                    1000 -> {
                        val num1 = data.readInt()
                        val num2 = data.readInt()
                        println("get $num1 , $num2")
                        reply?.writeInt(num1 + num2)
                        return true
                    }
                }

                return super.onTransact(code, data, reply, flags)
            }
        }
    }
}
