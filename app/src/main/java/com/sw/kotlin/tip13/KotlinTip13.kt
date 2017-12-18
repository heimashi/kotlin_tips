package com.sw.kotlin.tip13

import com.sw.kotlin.tip8.JavaExample8.User


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
    val user = User()
    user!!.name!!.subSequence(0, 5)!!.length
}


fun testNullType2() {
    val user: User? = User()

    /*
    * 每次访问都用用?.判断
    * */
    user?.name
    user?.age
    user?.toString()

    /*
    * 或者提前判断是否为空，如果不为空在这个分支里会自动转化为非空类型就可以直接访问了
    * */
    if (user != null) {
        user.name
        user.age
        user.toString()
    }

    /*
    * 还可以通过let语句，在?.let之后，如果为空不会有任何操作，只有在非空的时候才会执行let之后的操作
    * */
    user?.let {
        it.name
        it.age
        it.toString()
    }
}