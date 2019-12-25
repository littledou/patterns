package cn.readsense.shellapk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.readsense.shellapk.activity.StubInterfaceActivity
import cn.readsense.shellapk.activity.StubReflectActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var pluginPath: String
    var activityName = "cn.readsense.pluginapk.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pluginPath = File(filesDir.absolutePath, "plugin.apk").absolutePath
        reflect_activity.setOnClickListener {
            StubReflectActivity.startPluginActivity(this, pluginPath, activityName)
        }

        interface_activity.setOnClickListener {
            StubInterfaceActivity.startPluginActivity(this, pluginPath, activityName)
        }

    }


}