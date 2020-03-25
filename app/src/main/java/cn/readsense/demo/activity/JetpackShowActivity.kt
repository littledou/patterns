package cn.readsense.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import cn.readsense.demo.R
import cn.readsense.demo.activity.jetpackshow.UploadWorker

class JetpackShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_show)



    }
}
