package com.sw.kotlin.tip7


class User(val id: Int, val name: String, val address: String, val email: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    if (user.email.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Email")
    }
    //save to db ...
}

/*
*利用局部函数抽取相同的逻辑，去除重复的代码
* */
fun saveUser2(user: User) {
    fun validate(value: String, fildName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fildName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
    validate(user.email, "Email")
    //save to db ...
}

/*
* 利用扩展函数抽取逻辑
* */
fun User.validateAll() {
    fun validate(value: String, fildName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fildName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
    validate(email, "Email")
}

fun saveUser3(user: User) {
    user.validateAll()
    //save to db ...
}