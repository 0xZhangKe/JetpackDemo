package com.zhangke.demo.jetpack.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.zhangke.demo.jetpack.BR

/**
 * Created by ZhangKe on 2019/9/11.
 */

class User {
    var age = ObservableInt()
    var name = ObservableField<String>()
}

class Person : BaseObservable() {
    @get:Bindable
    var country: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.country)
        }

    @get:Bindable
    var sex: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.sex)
        }
}