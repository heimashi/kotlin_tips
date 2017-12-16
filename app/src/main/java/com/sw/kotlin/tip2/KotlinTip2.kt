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


/*
* kotlin中，when是表达式，可以取代Java 中的switch，when的每个分支的最后一行为当前分支的值
* */
fun getPoint(grade: Char) = when (grade) {
    'A' -> "GOOD"
    'B', 'C' -> {
        println("test when")
        "OK"
    }
    'D' -> "BAD"
    else -> "UN_KNOW"
}


/*
* kotlin中，when是表达式，可以取代java的if/else，when的每个分支的最后一行为当前分支的值
* */
fun getPoint2(grade: Int) = when {
    grade > 90 -> "GOOD"
    grade > 60 -> "OK"
    grade.hashCode() == 0x100 -> "STH"
    else -> "UN_KNOW"
}

