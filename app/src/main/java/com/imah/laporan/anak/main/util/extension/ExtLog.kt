package com.imah.laporan.anak.main.util.extension

import android.util.Log
import com.imah.laporan.anak.BuildConfig

val Any?.showToLog: Unit
    get() {
//        if (BuildConfig.DEBUG)
        Log.d("RZ_DEBUG", toString())
    }