package cn.readsense.easynet.retrofit

import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class RetrofitCreatTest {
    @Before
    fun create() {
        val retrofit = Retrofit.Builder().baseUrl("https://10.1.1.1:4000").build()




    }

    @Test
    fun test() {
    }
}