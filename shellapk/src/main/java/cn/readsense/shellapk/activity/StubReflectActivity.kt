package cn.readsense.shellapk.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.readsense.shellapk.activity.reflect.ReflectActivity


/**
 * 通过反射掉调用Acvitivy生命周期
 */

class StubReflectActivity : StubBaseActivity() {

    private var reflectActivity: ReflectActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reflectActivity = pluginClassLoader?.let {
            ReflectActivity(
                activityName,
                it
            )
        }
        reflectActivity?.attach(this)
        reflectActivity?.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        reflectActivity?.onStart()
    }

    override fun onResume() {
        super.onResume()
        reflectActivity?.onResume()
    }

    override fun onPause() {
        super.onPause()
        reflectActivity?.onPause()
    }

    override fun onStop() {
        super.onStop()
        reflectActivity?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        reflectActivity?.onDestroy()
    }

    companion object {
        fun startPluginActivity(context: Context, pluginPath: String, activityName: String) {
            val intent = Intent(context, StubReflectActivity::class.java)
            intent.putExtra("pluginPath", pluginPath)
            intent.putExtra("activityName", activityName)
            context.startActivity(intent)
        }
    }
}