package cn.readsense.aac

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import cn.readsense.aac.databinding.ActivityMainBinding
import cn.readsense.aac.room.AppDatabase
import cn.readsense.aac.viewmodel.NameViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cameraManager: CameraManager

    private lateinit var model: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.text = "点击"//视图绑定示例

        val user = User()//数据绑定示例
        user.name = "before"
        binding.user = user

        cameraManager = CameraManager()//生命周期示例
        lifecycle.addObserver(cameraManager!!)

        //LiveData示例
        model = ViewModelProvider(this).get(NameViewModel::class.java)
        val nameObserver = Observer<String> {
            binding.tv1.text = it
        }
        model.currentName.observe(this, nameObserver)

        binding.btn1.setOnClickListener {
            model.currentName.postValue("update str")
        }

        Thread(Runnable {

            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "database_itest"
            ).build()

            db.userDao().insertAll(cn.readsense.aac.room.User(1, "hongbin", "dou"))

            val roomUser = db.userDao().findByName(first = "hongbin", last = "dou")

            println("find user : $roomUser")

            var all = db.userDao().getAll()
            println("find user size : ${all.size}")

            db.userDao().delete(roomUser)

            all = db.userDao().getAll()
            println("after delete find user size : ${all.size}")

        }).start()


    }
}