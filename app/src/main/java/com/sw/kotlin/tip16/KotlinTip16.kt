package com.sw.kotlin.tip16

/**
 * 策略实施者
 * @param strategy lambda类型的策略
 */
class Worker(private val strategy: () -> Unit) {
    fun work() {
        println("START")
        strategy.invoke()
        println("END")
    }

}

/*
* 测试
* */
fun testStrategy() {
    val worker1 = Worker({
        println("Do A Strategy")
    })
    val bStrategy = {
        println("Do B Strategy")
    }
    val worker2 = Worker(bStrategy)
    worker1.work()
    worker2.work()
}

