package com.imah.laporan.anak.main.feature

import androidx.lifecycle.LifecycleOwner
import com.imah.laporan.anak.main.util.base.BasePresenter

class MainPresenter : BasePresenter<MainAction> {

    private var mvpAction: MainAction? = null

    fun doSomething() {
        mvpAction?.doSomething()
    }

    override fun onDestroy() {
        detachView()
    }

    override fun attachView(view: MainAction) {
        mvpAction = view
        if (mvpAction is LifecycleOwner) {
            (mvpAction as LifecycleOwner).lifecycle.addObserver(this)
        }
    }

    override fun detachView() {
        mvpAction = null
    }
}