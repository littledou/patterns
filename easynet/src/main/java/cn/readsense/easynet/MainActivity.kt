package cn.readsense.easynet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.readsense.easynet.java.HttpDownLoad
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var adapter: MySimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListView()


        Thread(object : Runnable {
            override fun run() {

                HttpDownLoad.downLoadFast("https://www.charlesproxy.com/assets/release/4.5.4/charles-proxy-4.5.4.dmg","/sdcard/test.dmg")
            }

        }).start()


    }

    fun initListView() {
        listView.layoutManager = LinearLayoutManager(this)
        adapter = MySimpleAdapter()

        listView.adapter = adapter
    }
}