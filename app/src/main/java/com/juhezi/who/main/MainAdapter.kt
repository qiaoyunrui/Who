package com.juhezi.who.main

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.juhezi.who.R
import java.util.*

/**
 * Created by qiao1 on 2016/10/1.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var list: ArrayList<Int> = ArrayList<Int>()
    set(value) {
        list.clear()
        list.addAll(value!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        var v: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.random_count_item,parent,false)
        return MainViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.mTvSerialNum?.text = "${position + 1}"
        holder?.mTvCount?.text = "${list?.get(position)}"
        holder?.mImgTag?.visibility = View.INVISIBLE
    }

    /**
     * 添加元素
     */
    fun addItem(param: Int,action: (Int) -> Unit){
        list?.add(param)
        notifyItemInserted(itemCount)   //显示添加动画
        action(itemCount)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mTvCount: TextView? = null
        var mTvSerialNum: TextView? = null
        var mImgTag: ImageView? = null

        init {
            mTvSerialNum = itemView.findViewById(R.id.tv_ramdom_count_item_serial_number) as TextView
            mTvCount = itemView.findViewById(R.id.tv_random_count_item_count) as TextView
            mImgTag = itemView.findViewById(R.id.img_random_count_item_tag) as ImageView
        }

    }

}


