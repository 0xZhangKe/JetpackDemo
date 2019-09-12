package com.zhangke.demo.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.zhangke.demo.jetpack.databinding.ActivityMainBinding
import com.zhangke.demo.jetpack.entity.Content
import com.zhangke.demo.jetpack.entity.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var content: Content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.title = "Title"

        val user = User()
        user.name = "ZhangKe"
        binding.user = user

        content = Content("desc")
        binding.content = content

        Thread {
            for (i in 1..100) {
                user.name = "Zhangke:$i"
                runOnUiThread{ content.desc.value = "desc:$i" }
                Thread.sleep(700)
            }
        }.start()
    }
}
