# 怎么用Kotlin去提高生产力：Kotlin Tips

汇总Kotlin相对于Java的优势以及怎么用Kotlin去简洁、务实、高效、安全的开发，每个总结的小点tip都有详细的说明和案例代码。


## tip1-函数默认参数避免函数

详见案例代码[KotlinTip1](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip1/KotlinTip1.kt)



## tip2-Kotlin中大多数控制结构都是表达式

首先，需要弄清楚一个概念**语句和表达式**，然后会介绍控制结构表达式的优点：***简洁***
#### 语句和表达式的区别
- 表达式有值，并且能作为另一个表达式的一部分使用
- 语句总是包围着它的代码块中的顶层元素，并且没有自己的值
#### Kotlin与Java的区别
- Java中，所有的控制结构都是语句，也就是控制结构都没有值
- Kotlin中，除了循环（for、do和do/while）以外，大多数控制结构都是表达式(if\when等)

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
上面是java中的三元运算符，kotlin中if是表达式有值，完全可以替代，**故kotlin中已没有三元运算符了**，用if来替代
上面的max函数还可以简化成下面的形式
```kotlin
/*
* kotlin简化版本
* */
fun max2(a: Int, b: Int) = if (a > b) a else b
```

## tip2-扩展函数



## tip2-懒加载 by lazy




## tip3-不用再手写findViewById







### 参考文档
* 《Kotlin Action》

