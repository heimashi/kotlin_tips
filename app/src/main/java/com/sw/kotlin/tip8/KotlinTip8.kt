package com.sw.kotlin.tip8

/*
* Kotlin会为类的参数自动实现get set方法
* */
class User(val name: String, val age: Int, val gender: Int, var address: String)

/*
* 用data关键词来声明一个数据类，除了会自动实现get set，还会自动生成equals hashcode toString
* */
data class User2(val name: String, val age: Int, val gender: Int, var address: String)