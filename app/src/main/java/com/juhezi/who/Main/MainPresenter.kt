package com.juhezi.who.main

import android.util.Log

/**
 * Created by qiao1 on 2016/9/30.
 */
class MainPresenter(var mView: MainContract.View):MainContract.Presenter {

    private var TAG: String = "MainPresenter"

    init {
        mView.setPresenter(this)
    }

    override fun start() {
        Log.i(TAG,"HelloWorld")
    }

}