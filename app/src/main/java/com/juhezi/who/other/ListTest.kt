package com.juhezi.who.other

import java.util.*

/**
 * Created by qiao1 on 2016/10/2.
 */
class ListTest {
    private var TAG = "ListTest"
    fun test() {
        var list: ArrayList<Int> = ArrayList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        list.forEach {
            println(it)
        }
    }

}
