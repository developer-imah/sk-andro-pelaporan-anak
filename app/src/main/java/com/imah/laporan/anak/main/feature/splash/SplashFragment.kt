package com.imah.laporan.anak.main.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.imah.laporan.anak.databinding.FragmentMainSplashBinding
import com.imah.laporan.anak.main.util.base.BaseFragment
import com.imah.laporan.anak.main.util.extension.showToLog

class SplashFragment : BaseFragment(), SplashAction {

    private lateinit var binding: FragmentMainSplashBinding

    private var presenter: SplashPresenter? = null

    override fun initView(q: LayoutInflater, w: ViewGroup?, e: Boolean): ViewBinding {
        binding = FragmentMainSplashBinding.inflate(q, w, e)
        return binding
    }

    override fun setupPresenter() {
        presenter = SplashPresenter()
        presenter?.attachView(this)
    }

    override fun startUse(view: View, savedInstanceState: Bundle?) {
        "test".showToLog
        presenter?.checkOpened(dbVm)
    }

    override fun onCheckingOk() {

    }
}