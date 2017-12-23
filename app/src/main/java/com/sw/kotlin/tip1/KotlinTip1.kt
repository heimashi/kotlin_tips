package com.sw.kotlin.tip1

/*
* kotlin对字符串的加强，三个引号"""中可以包含换行、反斜杠等等特殊字符
* */
fun testString() {
    val str1 = "abc"
    val str2 = """line1\n
        line2
        line3
        """
    val js = """
        function myFunction()
        {
            document.getElementById("demo").innerHTML="My First JavaScript Function";
        }
        """.trimIndent()
    println(str1)
    println(str2)
    println(js)
}


/*
* kotlin字符串模版，可以用$符号拼接变量和表达式
* */
fun testString2() {
    val strings = arrayListOf("abc", "efd", "gfg")
    println("First content is $strings")
    println("First content is ${strings[0]}")
    println("First content is ${if (strings.size > 0) strings[0] else "null"}")
}

/*
*Kotlin中，美元符号$是特殊字符，在字符串中不能直接显示，必须经过转义，方法1是用反斜杠，方法二是${'$'}
* */
fun testString3() {
    println("First content is \$strings")
    println("First content is ${'$'}strings")
}

