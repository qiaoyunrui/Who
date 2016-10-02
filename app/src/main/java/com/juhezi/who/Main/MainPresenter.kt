package com.juhezi.who.main

import android.util.Log
import com.juhezi.who.main.random.ARandom
import com.juhezi.who.main.random.CountRandom
import java.util.*

/**
 * Created by qiao1 on 2016/9/30.
 */
class MainPresenter(var mView: MainContract.View) : MainContract.Presenter {

    private var TAG: String = "MainPresenter"

    private var mRandom: ARandom? = null

    init {
        mRandom = CountRandom.Builder()
                    .setSeed(System.currentTimeMillis())
                    .setLowRange(0)
                    .setUpRange(100)
                    .build()
        mView.setPresenter(this)
    }

    override fun getCount(list: ArrayList<Int>,error: () -> Unit): Int{
        var result = mRandom?.next()
        var index = 0
        while (judgeRepeat(result!!,list)) { //如果有重复
            if(index >= 16) {    //循环次数太多，可与理解为都是重复的了
                error()
            }
            result = mRandom?.next()
            index++
        }
        return result!!
    }

    /**
     * 判断是否为重复元素(there are problem!!!)
     */
    fun judgeRepeat(param: Int,list: ArrayList<Int>) : Boolean{
        list.forEach {
            if(param == it) {
                return true
            }
        }
        return false
    }

    override fun start() {

    }

}