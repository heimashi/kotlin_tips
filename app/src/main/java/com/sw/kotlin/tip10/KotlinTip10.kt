package com.sw.kotlin.tip10

import android.content.Context
import android.widget.TextView


fun testL(context: Context) {
    val textView = TextView(context)

    /*
    * 传统形势
    * */
    textView.setOnClickListener(object : android.view.View.OnClickListener {
        override fun onClick(v: android.view.View?) {
            //handle click
        }
    })

    /*
    * lambda的形势
    * */
    textView.setOnClickListener({ v ->
        {
            //handle click
        }
    })

    /*
    * lambda的参数如果没有使用可以省略，省略的时候用it来替代
    * */
    textView.setOnClickListener({
        //handle click
    })

    /*
    * lambda在参数的最后一个的情况可以将之提出去
    * */
    textView.setOnClickListener() {
        //handle click
    }

    /*
    * lambda提出去之后，函数如果没有其他参数括号可以省略
    * */
    textView.setOnClickListener {
        //handle click
    }
}

interface OnClickListener {
    fun onClick()
}

class View {
    var listener: OnClickListener? = null;

    /*
    * 传统方式的
    * */
    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    fun doSth() {
        //some case:
        listener?.onClick()
    }

    /*
    * 声明lambda形势
    * */
    fun setOnClickListener(listener: () -> Unit) {

    }
}

fun testL2() {
    val view = View()
    view.setOnClickListener(object : OnClickListener {
        override fun onClick() {
            //handle click
        }
    })

    view.setOnClickListener {
        //handle click
    }
}
