package com.juhezi.who.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.juhezi.who.R
import java.util.*

/**
 * Created by qiao1 on 2016/9/30.
 */
public class MainFragment : MainContract.View,Fragment(){
    private var TAG = "MainFragment"

    private var rootView: View? = null

    private var mPresenter: MainContract.Presenter? = null
    private var mRvList :RecyclerView? = null

    private var mRlRandom: RelativeLayout? = null
    private var mBtnOK: Button? = null
    private var mAdapter: MainAdapter? = null
    private var mList: ArrayList<Int> = ArrayList<Int>()

    private var result: Int? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.main_frag,container,false)
        mRvList = rootView?.findViewById(R.id.rv_main_list) as RecyclerView
        mRlRandom = rootView?.findViewById(R.id.rl_main_random) as RelativeLayout
        mBtnOK = rootView?.findViewById(R.id.btn_main_ok) as Button
        initRecyclerView()
        initEvent()
        return rootView
    }

    private fun initEvent() {
        mRlRandom?.setOnClickListener {
            result = mPresenter?.getCount()
            addCount(result!!)
        }
    }

    private fun initRecyclerView() {

        var layoutManager = LinearLayoutManager(context)
        mAdapter = MainAdapter()
        mRvList?.layoutManager = layoutManager
        mRvList?.adapter = mAdapter
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

    override fun addCount(count: Int) {
        mAdapter?.addItem(count,
                {position -> mRvList?.scrollToPosition(position - 1)})
    }

}
