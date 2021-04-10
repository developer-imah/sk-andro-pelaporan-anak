package com.imah.laporan.anak.main.feature.splash

import androidx.lifecycle.LifecycleOwner
import com.imah.laporan.anak.main.util.base.BasePresenter
import com.imah.laporan.anak.main.util.extension.showToLog
import com.imah.laporan.anak.main.viewmodel.DbViewmodel
import java.util.*

class SplashPresenter : BasePresenter<SplashAction> {

    private var mvpAction: SplashAction? = null
    private var lifecycleOwner: LifecycleOwner? = null

    fun checkOpened(dbVm: DbViewmodel?) {
        dbVm?.storageData?.observe(lifecycleOwner ?: (mvpAction as LifecycleOwner)) {
            it?.opened.showToLog
            val opened = it?.opened ?: 0
            if (opened == 0) {
                "not opened yet".showToLog
//                    dbVm.setStorageData(StorageEntity(opened = 0))
//                    onNewOpened()
//                    dbVm.setStorageOpened(1)
            } else {
                "already opened".showToLog
            }
        }
    }

    private fun onNewOpened() {

    }

    override fun onDestroy() {
        detachView()
    }

    override fun attachView(view: SplashAction) {
        mvpAction = view
        if (mvpAction is LifecycleOwner) {
            (mvpAction as LifecycleOwner).apply {
                lifecycle.addObserver(this@SplashPresenter)
                lifecycleOwner = this
            }
        }
    }

    override fun detachView() {
        lifecycleOwner = null
        mvpAction = null
    }
}