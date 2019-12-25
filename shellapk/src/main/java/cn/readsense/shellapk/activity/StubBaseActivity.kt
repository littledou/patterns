package cn.readsense.shellapk.activity

import android.app.Activity
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import dalvik.system.DexClassLoader
import java.io.File
import java.io.IOException

open class StubBaseActivity : Activity() {
    protected lateinit var pluginPath: String
    private lateinit var nativeLibDir: String
    private lateinit var dexOutPath: String
    private var pluginResources: Resources? = null
    protected var pluginClassLoader: DexClassLoader? = null
    private var pluginassetManager: AssetManager? = null

    protected var activityName = "cn.readsense.pluginapk.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        handleResources()
    }


    override fun getResources(): Resources {
        return pluginResources ?: super.getResources()
    }

    override fun getAssets(): AssetManager {
        return pluginassetManager ?: super.getAssets()
    }

    override fun getClassLoader(): ClassLoader {
        return pluginClassLoader ?: super.getClassLoader()
    }

    fun extractPlugin() {
        //将插件apk复制到应用目录files

        try {
            val millis = System.currentTimeMillis()
            val openAssets = assets.open("plugin.apk")
            File(filesDir.absolutePath, "plugin.apk").writeBytes(openAssets.readBytes())
            println("copy cost: ${System.currentTimeMillis() - millis}")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun init() {
        extractPlugin()
        pluginPath = File(filesDir.absolutePath, "plugin.apk").absolutePath
        nativeLibDir = File(filesDir, "pluginlib").absolutePath
        val dexOutFile = File(filesDir, "dexout")
        dexOutPath = dexOutFile.absolutePath
        if (!dexOutFile.exists()) dexOutFile.mkdirs()
        // 生成 DexClassLoader 用来加载插件apk中的类
        pluginClassLoader =
            DexClassLoader(pluginPath, dexOutPath, nativeLibDir, this::class.java.classLoader)


    }

    fun handleResources() {
        //加载插件app中的资源
        pluginassetManager = AssetManager::class.java.newInstance()
        val addAssetPathMethod =
            pluginassetManager?.javaClass?.getMethod("addAssetPath", String::class.java)
        addAssetPathMethod?.invoke(pluginassetManager, pluginPath)

        pluginResources =
            Resources(pluginassetManager, resources.displayMetrics, resources.configuration)

    }
}