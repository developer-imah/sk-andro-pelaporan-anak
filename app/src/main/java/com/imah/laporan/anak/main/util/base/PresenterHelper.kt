package com.imah.laporan.anak.main.util.base

interface PresenterHelper {
    fun onLoading() {/* no-op */
    }

    fun onLoadingFinished() {/* no-op */
    }

    fun onFailed(throwable: Throwable?) {/* no-op */
    }

    fun onSuccess() {/* no-op */
    }

}