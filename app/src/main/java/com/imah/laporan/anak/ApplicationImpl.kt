package com.imah.laporan.anak

import android.app.Application
import android.content.Context

class ApplicationImpl : Application() {
    override fun onCreate() {
        super.onCreate()
        // asdasdasdasdasd
        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
    }
}