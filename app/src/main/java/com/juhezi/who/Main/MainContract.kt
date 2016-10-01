package com.juhezi.who.main

import com.juhezi.who.BasePresenter
import com.juhezi.who.BaseView

/**
 * Created by qiao1 on 2016/9/30.
 */
public interface MainContract{

    interface Presenter : BasePresenter {

    }

    interface View : BaseView<Presenter> {

    }

}