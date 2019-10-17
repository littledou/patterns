package cn.readsense.easynet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var adapter: MySimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListView()
    }

    fun initListView() {
        listView.layoutManager = LinearLayoutManager(this)
        adapter = MySimpleAdapter()

        listView.adapter = adapter
    }
}