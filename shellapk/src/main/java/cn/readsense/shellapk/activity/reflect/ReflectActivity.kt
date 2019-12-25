package cn.readsense.shellapk.activity.reflect

import android.app.Activity
import android.os.Bundle
import java.lang.reflect.Method

class ReflectActivity(activityName: String, activityClassLoader: ClassLoader) {
    private var clazz: Class<Activity> =
        activityClassLoader.loadClass(activityName) as Class<Activity>
    private var activity: Activity = clazz.newInstance()


    fun attach(proxyActivity: Activity?) {
        getMethod("attach", Activity::class.java).invoke(activity, proxyActivity)
    }

    fun onCreate(saveInstanceState: Bundle?) {
        getMethod("onCreate", Bundle::class.java).invoke(activity, saveInstanceState)
    }

    fun onStart() {
        getMethod("onStart").invoke(activity)
    }

    fun onResume() {
        getMethod("onResume").invoke(activity)
    }

    fun onPause() {
        getMethod("onPause").invoke(activity)
    }

    fun onStop() {
        getMethod("onStop").invoke(activity)
    }

    fun onDestroy() {
        getMethod("onDestroy").invoke(activity)
    }

    fun getMethod(methodName: String, vararg params: Class<*>): Method {
        return clazz.getMethod(methodName, *params)
    }
}