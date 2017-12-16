package com.sw.kotlin.tip2


/*
* kotlin中，if 是表达式，不是语句，类似于java中的三木运算符a > b ? a : b
* */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

/*
* kotlin简化版本
* */
fun max2(a: Int, b: Int) = if (a > b) a else b
