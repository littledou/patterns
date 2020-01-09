package cn.readsense.aac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.readsense.aac.databinding.ActivityMainBinding
import cn.readsense.aac.enity.User
import cn.readsense.aac.handler.MyHandler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.user =  User("aaa", "bbb")

        binding.handler = MyHandler()

        binding.btn2.setOnClickListener {
            println("btn2 setOnClickListener")
        }

    }
}
