package com.sw.kotlin.tip4

/*
* 扩展函数
* */
fun String.lastChar(): Char = this.get(this.length - 1)

fun testFunExtension() {
    val str = "test extension fun";
    println(str.lastChar())
}

/*
* 用扩展函数改造Tip3中的列表打印内容函数
* */
fun <T> Collection<T>.joinToString3(separator: String = ", ",
                                    prefix: String = "",
                                    postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun printList4() {
    val list = listOf(2, 4, 0)
    println(list.joinToString3("/"))
}

/*
* 扩展属性 lastChar获取String的最后一个字符
* */
val String.lastChar: Char
    get() = get(length - 1)
/*
* 扩展属性 lastChar获取StringBuilder的最后一个字符
* */
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }
/*
* 测试
* */
fun testExtension(){
    val s = "abc"
    println(s.lastChar)
    val sb = StringBuilder("abc")
    println(sb.lastChar)
}