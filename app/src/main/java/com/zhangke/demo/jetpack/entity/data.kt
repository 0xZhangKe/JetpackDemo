package com.zhangke.demo.jetpack.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.zhangke.demo.jetpack.BR

/**
 * Created by ZhangKe on 2019/9/11.
 */

class User : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

}

class Content(_desc: String) {

    val desc = MutableLiveData<String>()

    init {
        desc.value = _desc
    }
}