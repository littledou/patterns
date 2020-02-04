package cn.readsense.aac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.readsense.aac.databinding.ActivityMainBinding
import cn.readsense.aac.enity.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var user = User()
        binding.user =user



        binding.user = user

    }
}
