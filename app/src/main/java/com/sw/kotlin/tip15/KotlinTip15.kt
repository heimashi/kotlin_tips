package com.sw.kotlin.tip15


fun test01() {
    val list = listOf(2, 5, 10)
    /*
    * 传人函数来过滤
    * */
    println(list.filter { it > 4 })
}

fun test02() {
    /*
    * 定义函数类型
    * */
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    val sum2: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val action2: () -> Unit = { println(42) }
}

/*
* 定义对2和3的操作函数
* */
fun twoAndThree(operator: (Int, Int) -> Int) {
    val result = operator(2, 3)
    println("Result:$result")
}

fun test03() {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
}

/*
* 函数作为参数，实现String类的字符过滤
* */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun test04() {
    println("12eafsfsfdbzzsa".filter { it in 'a'..'f' })
}

/*
* 函数作为返回值
* */
enum class Delivery {
    STANDARD, EXPEDITED
}

/*
* 根据不同的运输类型返回不同的快递方式
* */
fun getShippingCostCalculator(delivery: Delivery): (Int) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { 6 + 2.1 * it }
    }
    return { 1.3 * it }
}

fun test05(){
    val calculator1 = getShippingCostCalculator(Delivery.EXPEDITED)
    val calculator2 = getShippingCostCalculator(Delivery.STANDARD)
    println("Ex costs ${calculator1(5)}")
    println("St costs ${calculator2(5)}")
}