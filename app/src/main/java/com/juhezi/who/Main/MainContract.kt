package com.juhezi.who.main

import com.juhezi.who.BasePresenter
import com.juhezi.who.BaseView
import java.text.FieldPosition
import java.util.*

/**
 * Created by qiao1 on 2016/9/30.
 */
public interface MainContract{

    interface Presenter : BasePresenter {

        /**
         * 获取随机数字
         */
        fun getCount(list: ArrayList<Int>,error: () -> Unit) : Int
    }

    interface View : BaseView<Presenter> {
        /**
         * 向列表中添加随机数字
         */
        fun addCount(count : Int)   //Glide

    }

}