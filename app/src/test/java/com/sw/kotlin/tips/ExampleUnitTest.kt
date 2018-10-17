package com.sw.kotlin.tips

import com.sw.kotlin.tip1.JavaExample1
import com.sw.kotlin.tip1.testString
import com.sw.kotlin.tip1.testString3
import com.sw.kotlin.tip11.alphabet
import com.sw.kotlin.tip14.testOperator
import com.sw.kotlin.tip16.testStrategy
import com.sw.kotlin.tip3.JavaExample3
import com.sw.kotlin.tip3.printList
import com.sw.kotlin.tip4.testAsMembers
import com.sw.kotlin.tip5.testLateInit
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun test00() {
        val j = JavaExample3()
        j.test01()
        j.test02()
    }

    @Test
    fun test01() {
        testString3()
    }

    @Test
    fun test02() {
        testString()
        val j = JavaExample1()
        j.testString1()
    }

    @Test
    fun test03() {
        printList()
    }

    @Test
    fun test04() {
        println(alphabet())
    }

    @Test
    fun test05() {
        "testRun".run {
            println("this = " + this)
            "ss"
        }.let { println(it) }
    }

    @Test
    fun test06() {
        testOperator()
    }

    @Test
    fun test07() {
        testStrategy()
    }

    @Test
    fun test08(){
        testAsMembers()
    }

    @Test
    fun test09(){
        testLateInit()
    }
}
