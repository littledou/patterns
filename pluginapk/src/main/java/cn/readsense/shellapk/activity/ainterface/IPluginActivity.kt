package cn.readsense.shellapk.activity.ainterface

import android.app.Activity
import android.os.Bundle

interface IPluginActivity {

    fun attach(proxyActivity: Activity)

    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

}