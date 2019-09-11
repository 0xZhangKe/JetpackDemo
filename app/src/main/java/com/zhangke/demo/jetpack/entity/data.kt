package com.zhangke.demo.jetpack.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.zhangke.demo.jetpack.BR

/**
 * Created by ZhangKe on 2019/9/11.
 */

class User(private var name: String):BaseObservable(){

    @Bindable
    fun getName(): String = name

    fun setName(_name: String){
        name = _name
        notifyPropertyChanged(BR.name)
    }

}