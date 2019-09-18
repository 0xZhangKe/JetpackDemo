package com.zhangke.demo.jetpack

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.zhangke.demo.jetpack.entity.Person
import com.zhangke.demo.jetpack.entity.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.title = "Title"

        val user = User()
        user.name.set("ZhangKe")
        user.age.set(18)
        binding.user = user

        val map = ObservableArrayMap<String, Any>().apply { put("count", 0) }
        binding.map = map

        val list = ObservableArrayList<Any>().apply { add(0) }
        binding.list = list

        val person = Person().apply {
            country = "China"
            sex = "boy"
        }
        binding.person = person

        val desc = MutableLiveData<String>()
        binding.desc = desc

        val input = ObservableField<String>()
        binding.input = input

        binding.handler = EventHandler()

        binding.imageUrl = "https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=9a9304a3242eb938ec6d7df4ed59e208/3812b31bb051f819486c0408d1b44aed2e73e723.jpg"

        Thread {
            for (i in 1..100) {
                map["count"] = i
                list[0] = i
                user.name.set("ZhangKe:$i")
                user.age.set(i)
                person.country = "China:$i"
                person.sex = "Sex:$i"
                runOnUiThread { desc.value = "desc:$i" }
                Thread.sleep(700)
            }
        }.start()
    }

    inner class EventHandler {

        fun onToastBtnClick(v: View) {
            Toast.makeText(this@MainActivity, "Click", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
