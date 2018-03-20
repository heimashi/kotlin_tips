package com.sw.kotlin.tip5

/*
* 懒初始化api实例
* */
/*
val purchasingApi: PurchasingApi by lazy {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    retrofit.create(PurchasingApi::class.java)
}*/

class User(var name: String, var age: Int)

/*
* 懒初始化by lazy
* */
val user1: User by lazy {
    User("jack", 15)
}

/*
* 延迟初始化lateinit
* */
lateinit var user2: User

fun testLateInit() {
    //println(user2.age)
    user2 = User("Lily", 14)
}