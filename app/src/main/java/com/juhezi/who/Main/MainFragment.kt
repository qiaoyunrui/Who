package com.juhezi.who.Main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juhezi.who.R

/**
 * Created by qiao1 on 2016/9/30.
 */
public class MainFragment : MainContract.View,Fragment(){

    private var rootView: View? = null
    private var mPresenter: MainContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.main_frag,container,false)
        return rootView
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.start()
    }

    override fun onDestroy() {
        mPresenter = null
        System.gc()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

}