package cn.readsense.easynet

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        llog("onTouchEvent")
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        llog("dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }


    fun llog(log: String) {
        println("MainActivity: ${log}")
    }
}