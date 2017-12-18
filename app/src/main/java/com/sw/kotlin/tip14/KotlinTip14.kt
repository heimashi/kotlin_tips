package com.sw.kotlin.tip14


/*
* 运算符重载
* */
class Point(val x: Int, val y: Int) {

    /*
    * plus函数重载对Point对象的加法运算符
    * */
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    /*
    * minus函数重载对Point对象的减法运算符
    * */
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    override fun toString(): String {
        return "[x:$x, y:$y]"
    }

}

/*
* 测试
* */
fun testOperator() {
    val point1 = Point(10, 10)
    val point2 = Point(4, 4)
    val point3 = point1 + point2
    println(point3)
    println(point1 - point2)
}