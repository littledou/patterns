package cn.readsense.demo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import cn.readsense.demo.activity.jetpackshow.UploadWorker

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        var dataSet = arrayOf(
            "Jetpack",
            "Activity",
            "IPC",
            "View Touch",
            "Custom View",
            "RemoteViews",
            "Drawable",
            "Animation",
            "Window WindowManager",
            "四大组件",
            "Handler",
            "Thread ThreadPool",
            "Bitmap",
            "Dex",
            "NDK",
            "性能优化"
        )

        recyclerView.adapter = FuncAdapter(dataSet)

    }

    class FuncAdapter(private val dataSet: Array<String>) :
        RecyclerView.Adapter<FuncAdapter.ViewHolder>() {


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(R.id.main_itemview)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.main_item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = dataSet[position]
            holder.textView.setOnClickListener {
                when (position) {
                    0 -> {
                        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>().build()

                        WorkManager.getInstance(holder.textView.context).enqueue(oneTimeWorkRequest)

                        println("push worker: thread - ${Thread.currentThread().name}")

//                        WorkManager.getInstance(holder.textView.context).getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
//                            .observe(lifecycleOwner, Observer { workInfo ->
//                                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
//                                    println("Work finished - ${Thread.currentThread().name}")
//                                }
//                            })
                    }
                    else -> {
                        Log.d(TAG, "未定义的position $position")
                    }

                }
            }
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }


}
