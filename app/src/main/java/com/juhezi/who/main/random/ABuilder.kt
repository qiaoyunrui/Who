package com.juhezi.who.main.random

/**
 * Created by qiao1 on 2016/10/1.
 */
abstract class ABuilder {
    /**
     * 设置随机数种子
     */
    abstract fun setSeed(seed: Long) : ABuilder

    /**
     * 设置随机数上界
     */
    abstract fun setUpRange(up: Int) : ABuilder

    /**
     * 设置随机数下界
     */
    abstract fun setLowRange(low: Int) : ABuilder

    /**
     * 创建ARandom
     */
    abstract fun build(): ARandom

}