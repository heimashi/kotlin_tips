package com.sw.kotlin.tip3


fun printList() {
    val list = listOf(2, 4, 0)
    println(list)
}

/*
* 打印列表的内容
* */
fun <T> joinToString(collection: Collection<T>,
                     separator: String,
                     prefix: String,
                     postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun printList2() {
    val list = listOf(2, 4, 0)
    /*不标明参数名*/
    println(joinToString(list, " - ", "[", "]"))
    /*显示的标明参数名称*/
    println(joinToString(list, separator = " - ", prefix = "[", postfix = "]"))
}

/*
* 打印列表的内容，带有默认的参数，可以避免java的函数重载
* */
fun <T> joinToString2(collection: Collection<T>,
                      separator: String = ", ",
                      prefix: String = "",
                      postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


fun printList3() {
    val list = listOf(2, 4, 0)
    println(joinToString2(list, " - "))
}


/*
* 通过注解@JvmOverloads解决java调用kotlin时不支持默认参数的问题
* */
@JvmOverloads
fun <T> joinToString2New(collection: Collection<T>,
                         separator: String = ", ",
                         prefix: String = "",
                         postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}