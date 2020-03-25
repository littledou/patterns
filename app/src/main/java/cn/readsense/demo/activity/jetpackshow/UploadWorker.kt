package cn.readsense.demo.activity.jetpackshow

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {

        println("do upload work : thread - ${Thread.currentThread().name}")

        return Result.success()
    }

}