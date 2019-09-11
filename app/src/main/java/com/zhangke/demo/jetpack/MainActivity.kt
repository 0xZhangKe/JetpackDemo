package com.zhangke.demo.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zhangke.demo.jetpack.databinding.ActivityMainBinding
import com.zhangke.demo.jetpack.entity.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.title = "Title"

        val user = User("ZhangKe")
        binding.user = user

        Thread {
            for (i in 1..100) {
                user.setName("Zhangke:$i")
                Thread.sleep(700)
            }
        }.start()
    }
}
