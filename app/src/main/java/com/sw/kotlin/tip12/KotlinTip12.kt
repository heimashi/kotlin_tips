package com.sw.kotlin.tip12

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.sw.kotlin.tip8.JavaExample8.User


/*
* 用apply语句简化代码，在apply的大括号里可以访问类的公有属性和方法
* */
fun alphabet5() = StringBuilder().apply {
    append("START\n")
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nEND")
}.toString()


/*
* 用apply语句简化类的初始化，在类实例化的时候，就可以通过apply把需要初始化的步骤全部实现，非常的简洁
* */
fun testApply(context: Context) {
    var imgView = ImageView(context).apply {
        setBackgroundColor(0)
        setImageBitmap(null)
    }

    var textView = TextView(context).apply {
        text = "content"
        textSize = 20.0f
        setPadding(10, 0, 0, 0)
    }

    var user = User().apply {
        age = 15
        name = "Jack"
        val a = address
        address = "bbb"
    }
}