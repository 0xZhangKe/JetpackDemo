package com.zhangke.demo.jetpack

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by ZhangKe on 2019/9/18.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) =
    Glide.with(this.context).load(url).into(this)