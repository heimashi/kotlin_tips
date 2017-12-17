package com.sw.kotlin.tip9

/*
* 常见的装饰器模式，为了修改部分的函数，却需要实现所有的接口函数
* */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> {

    var objectAdded = 0

    override val size: Int
        get() = innerSet.size

    /*
    * 需要修改的方法
    * */
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    /*
    * 需要修改的方法
    * */
    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }

    override fun contains(element: T): Boolean {
        return innerSet.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerSet.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerSet.isEmpty()
    }

    override fun clear() {
        innerSet.clear()
    }

    override fun iterator(): MutableIterator<T> {
        return innerSet.iterator()
    }

    override fun remove(element: T): Boolean {
        return innerSet.remove(element)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return innerSet.removeAll(elements)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return innerSet.retainAll(elements)
    }

}


/*
* 通过by关键字将接口的实现委托给innerSet成员变量，需要修改的函数再去override就可以了
* */
class CountingSet2<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {

    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}