package com.sw.kotlin.tip11

/*
*打印字母表函数，在函数内result变量在好几处有使用到
* */
fun alphabet(): String {
    val result = StringBuilder()
    result.append("START\n")
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nEND")
    return result.toString()
}

/*
* 通过with语句，将result作为参数传人，在内部就可以通过this来表示result变量了
* */
fun alphabet2(): String {
    val result = StringBuilder()
    return with(result) {
        this.append("START\n")
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nEND")
        this.toString()
    }
}


/*
* 通过with语句，将result参数作为参数，在内部this也可以省略掉
* */
fun alphabet3(): String {
    val result = StringBuilder()
    return with(result) {
        append("START\n")
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nEND")
        toString()
    }
}


/*
* 通过with语句，可以直接将对象传人，省掉对象的声明
* */
fun alphabet4(): String {
    return with(StringBuilder()) {
        append("START\n")
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nEND")
        toString()
    }
}