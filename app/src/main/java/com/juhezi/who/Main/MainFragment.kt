package com.juhezi.who.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import com.juhezi.who.R
import com.juhezi.who.other.DividerItemDecoration
import java.util.*

/**
 * Created by qiao1 on 2016/9/30.
 */
class MainFragment : MainContract.View,Fragment(){
    private var TAG = "MainFragment"

    private var rootView: View? = null

    private var mPresenter: MainContract.Presenter? = null

    private var mRvList :RecyclerView? = null

    private var mImgRandom: ImageView? = null
    private var mRlEmpty: RelativeLayout? = null
    private var mBtnOK: Button? = null

    private var mAdapter: MainAdapter? = null
    private var mList: ArrayList<Int> = ArrayList<Int>()
    private var result: Int? = null

    private var anim: ObjectAnimator? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.main_frag,container,false)
        mRvList = rootView?.findViewById(R.id.rv_main_list) as RecyclerView
        mImgRandom = rootView?.findViewById(R.id.img_main_random) as ImageView
        mRlEmpty = rootView?.findViewById(R.id.rl_main_empty) as RelativeLayout
        mBtnOK = rootView?.findViewById(R.id.btn_main_ok) as Button
        initRecyclerView()
        initEvent()
        initAnim()
        return rootView
    }

    private fun initEvent() {
        mImgRandom?.setOnClickListener {
            if(!anim?.isRunning()!!) {
                anim?.start()
            }
            result = mPresenter?.getCount(mAdapter!!.list,{
                Toast.makeText(context,"找不到合适的数字啦！！！",Toast.LENGTH_SHORT).show()
            })
            addCount(result!!)
        }
        mBtnOK?.setOnClickListener {
            mAdapter?.clear()
            showEmptyView()
        }
    }

    private fun initRecyclerView() {
        var layoutManager = LinearLayoutManager(context)
        mAdapter = MainAdapter()
        mRvList?.layoutManager = layoutManager
        mRvList?.adapter = mAdapter
        /*mRvList?.addItemDecoration(DividerItemDecoration(
                context,LinearLayoutManager.VERTICAL
        ))*/
    }

    private fun initAnim() {
        anim = ObjectAnimator.ofFloat(mImgRandom,"rotation",0f,180f)
        anim?.interpolator = AccelerateDecelerateInterpolator()
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
                {position ->
                    if(position == 1) {
                        hideEmptyView()
                    }
                    mRvList?.scrollToPosition(position - 1)
                })
    }

    override fun showEmptyView() {
        mRlEmpty?.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
        mRlEmpty?.visibility = View.INVISIBLE
    }



}
