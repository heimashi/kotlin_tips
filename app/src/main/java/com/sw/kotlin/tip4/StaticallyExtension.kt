package com.sw.kotlin.tip4

open class A

class B : A()

fun A.foo() = "a"

fun B.foo() = "b"

/*
* https://kotlinlang.org/docs/reference/extensions.html
* Extensions do not actually modify classes they extend. By defining an extension, you do not insert new members into a class,
* but merely make new functions callable with the dot-notation on variables of this type. Extension functions are
* dispatched statically.
* */
fun printFoo(a: A) {
    println(a.foo())
}

fun testStatically() {
    printFoo(A()) // print a
    printFoo(B()) // also print a
}
