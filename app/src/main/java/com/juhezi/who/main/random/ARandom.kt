package com.juhezi.who.main.random

/**
 *  产生随机数的抽象类
 *
 * Created by qiao1 on 2016/10/1.
 */
abstract class ARandom{

    /**
     * 随机数种子
     */
    abstract var seed: Long

    /**
     * 随机数上界
     */
    abstract var upRange: Int

    /**
     * 随机数下界
     */
    abstract var lowRange: Int

    /**
     * 获取下一个随机数
     */
    abstract fun next(): Int

}