package com.sw.kotlin.tips

import com.sw.kotlin.tip1.JavaExample1
import com.sw.kotlin.tip1.testString
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test01(){
        testString()
        val j = JavaExample1()
        j.testString1()
    }

}
