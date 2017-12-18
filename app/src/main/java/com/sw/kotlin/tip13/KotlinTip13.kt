package com.sw.kotlin.tip13

import com.sw.kotlin.tip8.JavaExample8


fun testNullType() {
    val a: String = "aa"
    /*
    * a是非空类型，下面的给a赋值为null将会编译不通过
    * */
    //a = null
    a.length

    /*
   * ？声明是可空类型，可以赋值为null
   * */
    var b: String? = "bb"
    b = null

    /*
   * b是可空类型，直接访问可空类型将编译不通过，需要通过?.或者!!.来访问
   * */
    //b.length
    b?.length
    b!!.length

    /*
    * 不用链式的连续用!!.
    * */
    val user = JavaExample8.User()
    user!!.name!!.subSequence(0,5)!!.length
}