package cn.readsense.easynet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.readsense.easynet.java.UCNHttp
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    val baseurl: String = "http://10.1.14.192:4040"
    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHttpGet.setOnClickListener {
            httpGetSample()
        }

        buttonOkhttpGet.setOnClickListener {
            okhttpGetSample()
        }

        buttonOkhttpPost.setOnClickListener {
            val postBody = "post str".trimMargin()

//            val request = Request.Builder()
//                .url(baseurl).post(postBody.toRequestBody(MEDIA_TYPE_MARKDOWN)).build()


        }

    }


    fun httpGetSample() {
        Thread(Runnable {
            println(UCNHttp.get(baseurl))

            val request = Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                for ((name, value) in response.headers) {
                    println("$name: $value")
                }

                println(response.body!!.string())
            }
        }).start()


    }

    fun okhttpGetSample() {
        var client = OkHttpClient.Builder().connectTimeout(1L, TimeUnit.SECONDS).build()
        var request = Request.Builder().url(baseurl)
            .header("User-Agent", "OkHttp Headers.java")
            .addHeader("Accept", "application/json; q=0.5")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                for ((name, value) in response.headers) {
                    println("name: $name, value: $value")
                }

                println("response: ${response.body?.string()}")
            }

        })
    }

}