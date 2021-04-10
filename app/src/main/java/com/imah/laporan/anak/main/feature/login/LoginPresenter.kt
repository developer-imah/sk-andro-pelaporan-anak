package com.imah.laporan.anak.main.feature.login

import com.imah.laporan.anak.main.util.base.BasePresenter

class LoginPresenter : BasePresenter<LoginAction> {

    private var mvpAction: LoginAction? = null

    override fun onDestroy() {
        detachView()
    }

    override fun attachView(view: LoginAction) {
        mvpAction = view
    }

    override fun detachView() {
        mvpAction = null
    }

}