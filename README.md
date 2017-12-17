# 怎么用Kotlin去提高生产力：Kotlin Tips

汇总Kotlin相对于Java的优势以及怎么用Kotlin去简洁、务实、高效、安全的开发，每个总结的小点tip都有详细的说明和案例代码。


## Tip1-更简洁的字符串

详见案例代码[KotlinTip1](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip1/KotlinTip1.kt)

Kotlin中的字符串基本Java中的类似，有一点区别是加入了三个引号"""来方便长篇字符的编写。
而在Java中，这些都需要转义，先看看java中的式例
```java
    public void testString1() {
        String str1 = "abc";
        String str2 = "line1\n" +
                "line2\n" +
                "line3";
        String js = "function myFunction()\n" +
                "{\n" +
                "    document.getElementById(\"demo\").innerHTML=\"My First JavaScript Function\";\n" +
                "}";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(js);
    }
```
kotlin除了有单个双引号的字符串，还对字符串的加强，引入了**三个引号**，"""中可以包含换行、反斜杠等等特殊字符：
```kotlin
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
```
同时，Kotlin中引入了**字符串模版**，方便字符串的拼接，可以用$符号拼接变量和表达式
```kotlin
/*
* kotlin字符串模版，可以用$符号拼接变量和表达式
* */
fun testString2() {
    val strings = arrayListOf("abc", "efd", "gfg")
    println("First content is $strings")
    println("First content is ${strings[0]}")
    println("First content is ${if (strings.size > 0) strings[0] else "null"}")
}
```

## Tip2-Kotlin中大多数控制结构都是表达式

首先，需要弄清楚一个概念**语句和表达式**，然后会介绍控制结构表达式的优点：**简洁**
#### 语句和表达式是什么？
- 表达式有值，并且能作为另一个表达式的一部分使用
- 语句总是包围着它的代码块中的顶层元素，并且没有自己的值
#### Kotlin与Java的区别
- Java中，所有的控制结构都是语句，也就是控制结构都没有值
- Kotlin中，除了循环（for、do和do/while）以外，大多数控制结构都是表达式(if/when等)


详见案例代码[tip2](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip2)
#### Example1：if语句
java中，if 是语句，没有值，必须显示的return
```java
/*
* java中的if语句
* */
public int max(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
```
kotlin中，if 是表达式，不是语句，因为表达式有值，可以作为值return出去
```kotlin
/*
* kotlin中，if 是表达式，不是语句，类似于java中的三木运算符a > b ? a : b
* */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```
上面的if中的分支最后一行语句就是该分支的值，会作为函数的返回值。这其实跟java中的三元运算符类似，
```java
/*
* java的三元运算符
* */
public int max2(int a, int b) {
    return a > b ? a : b;
}
```
上面是java中的三元运算符，kotlin中if是表达式有值，完全可以替代，**故kotlin中已没有三元运算符了**，用if来替代。
上面的max函数还可以简化成下面的形式
```kotlin
/*
* kotlin简化版本
* */
fun max2(a: Int, b: Int) = if (a > b) a else b
```

#### Example2：when语句
Kotlin中的when非常强大，完全可以取代Java中的switch和if/else，同时，**when也是表达式**，when的每个分支的最后一行为当前分支的值
先看一下java中的switch
```java
    /*
    * java中的switch
    * */
    public String getPoint(char grade) {
        switch (grade) {
            case 'A':
                return "GOOD";
            case 'B':
            case 'C':
                return "OK";
            case 'D':
                return "BAD";
            default:
                return "UN_KNOW";
        }
    }
```
java中的switch有太多限制，我们再看看Kotlin怎样去简化的
```kotlin
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
```
同样的，when语句还可以取代java中的if/else if，其是表达式有值，并且更佳简洁
```java
    /*
    * java中的if else
    * */
    public String getPoint2(Integer point) {
        if (point > 100) {
            return "GOOD";
        } else if (point > 60) {
            return "OK";
        } else if (point.hashCode() == 0x100) {
            //...
            return "STH";
        } else {a
            return "UN_KNOW";
        }
    }
```
再看看kotlin的版本，使用**不带参数的when**，只需要6行代码
```kotlin
/*
* kotlin中，when是表达式，可以取代java的if/else，when的每个分支的最后一行为当前分支的值
* */
fun getPoint2(grade: Int) = when {
    grade > 90 -> "GOOD"
    grade > 60 -> "OK"
    grade.hashCode() == 0x100 -> "STH"
    else -> "UN_KNOW"
}
```

## Tip3-更好调用的函数：显示参数名/默认参数值
Kotlin的函数更加好调用，主要是表现在两个方面：1，显示的标示参数名，可以方便代码阅读；2，函数可以有默认参数值，可以大大减少Java中的函数重载。
例如现在需要实现一个工具函数，打印列表的内容：
```kotlin
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
/*
* 测试
* */
fun printList() {
    val list = listOf(2, 4, 0)
    /*不标明参数名*/
    println(joinToString(list, " - ", "[", "]"))
    /*显示的标明参数名称*/
    println(joinToString(list, separator = " - ", prefix = "[", postfix = "]"))
}
```
如上面的代码所示，函数joinToString想要打印列表的内容，需要传人四个参数：列表、分隔符、前缀和后缀。
由于参数很多，在后续使用该函数的时候不是很直观的知道每个参数是干什么用的，这时候可以显示的标明参数名称，增加代码可读性。
同时，定义函数的时候还可以给函数默认的参数，如下所示：
```kotlin
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
/*
* 测试
* */
fun printList3() {
    val list = listOf(2, 4, 0)
    println(joinToString2(list, " - "))
    println(joinToString2(list, " , ", "["))
}
```
这样有了默认参数后，在使用函数时，如果不传入该参数，默认会使用默认的值，这样可以避免Java中大量的函数重载。

## Tip-扩展函数



## Tip-懒加载 by lazy




## Tip-不用再手写findViewById







### 参考文档
* 《Kotlin in Action》

