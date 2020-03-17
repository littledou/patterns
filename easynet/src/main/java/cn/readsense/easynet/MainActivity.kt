package cn.readsense.easynet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.readsense.easynet.java.UCNHttp
import cn.readsense.easynet.retrofit.DartService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {


    val baseurl: String = "http://10.1.14.195:4040"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHttpGet.setOnClickListener {
            httpGetSample()
        }

//        buttonOkhttpGet.setOnClickListener {
//            okhttpGetSample()
//        }

//        buttonOkhttpPost.setOnClickListener {
//
//            Thread(Runnable {
//                val postBody = "{\"name\":\"dou\"}"
//
//                val request = Request.Builder()
//                    .url("${baseurl}/postjson")
//                    .post(postBody.toRequestBody())
//                    .build()
//                client.newCall(request).execute().use { response ->
//                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                    for ((name, value) in response.headers) {
//                        println("$name: $value")
//                    }
//                    println(response.body!!.string())
//                }
//
//            }).start()
//
//        }

//        buttonOkhttpPostForm.setOnClickListener {
//            var formBody = FormBody.Builder()
//                .add("name", "dou")
//                .add("age", "27")
//                .build()
//            val request = Request.Builder()
//                .url("${baseurl}/postform")
//                .post(formBody)
//                .build()
//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                    for ((name, value) in response.headers) {
//                        println("name: $name, value: $value")
//                    }
//
//                    println("response: ${response.body?.string()}")
//                }
//
//            })
//        }

//        buttonOkhttpPostmulti.setOnClickListener {
//
//            var logo = File("/sdcard/logo.png")
//
//            var requestBody = MultipartBody.Builder()
//                .addFormDataPart("name", "dou")
//                .addFormDataPart("image", "logo.png", logo.asRequestBody("image/png".toMediaType()))
//                .build()
//
//            val request = Request.Builder()
//                .url("${baseurl}/postmulti")
//                .post(requestBody)
//                .build()
//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                    for ((name, value) in response.headers) {
//                        println("name: $name, value: $value")
//                    }
//
//                    println("response: ${response.body?.string()}")
//                }
//
//            })
//        }

        buttonretrofitget.setOnClickListener {
            val retrofit = Retrofit.Builder().baseUrl(baseurl).build()

            val dartService = retrofit.create(DartService::class.java)

            dartService.getMsg("dou")
                .enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onFailure(
                        call: retrofit2.Call<ResponseBody>,
                        t: Throwable
                    ) {
                        println("onFailure: ${t.message}")
                    }

                    override fun onResponse(
                        call: retrofit2.Call<ResponseBody>,
                        response: retrofit2.Response<ResponseBody>
                    ) {
                        println("code: ${response.code()}, response: ${response.body()?.string()}")
                    }

                })


        }

    }


    fun httpGetSample() {
        Thread(Runnable {
            println(UCNHttp.get("${baseurl}/ucnhttpget"))

//            val request = Request.Builder()
//                .url("https://publicobject.com/helloworld.txt")
//                .build()
//
//            client.newCall(request).execute().use { response ->
//                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                for ((name, value) in response.headers) {
//                    println("$name: $value")
//                }
//
//                println(response.body!!.string())
//            }
        }).start()


    }

//    fun okhttpGetSample() {
//        var client = OkHttpClient.Builder()
//            .connectTimeout(1L, TimeUnit.SECONDS)
//            .cache(Cache(File("/sdcard/cache"), 1024 * 1024 * 10))
//            .build()
//
//        var request = Request.Builder().url("https://www.v2ex.com/api/topics/hot.json")
//            .build()
//
//        val newCall = client.newCall(request)
//
//        newCall.enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                for ((name, value) in response.headers) {
//                    println("name: $name, value: $value")
//                }
//
//                println("response: ${response.body?.string()}")
//            }
//        })
//    }


}