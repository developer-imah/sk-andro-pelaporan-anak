package com.imah.laporan.anak.main.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.imah.laporan.anak.main.util.extension.showToLog
import com.imah.laporan.anak.main.viewmodel.DbViewmodel

abstract class BaseFragment : Fragment() {

    abstract fun initView(q: LayoutInflater, w: ViewGroup?, e: Boolean): ViewBinding

    abstract fun setupPresenter()

    abstract fun startUse(view: View, savedInstanceState: Bundle?)

    var dbVm: DbViewmodel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        "onCreateView".showToLog
        dbVm = ViewModelProvider(requireActivity())[DbViewmodel::class.java]
        return initView(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        "onViewCreated".showToLog
        setupPresenter()
        startUse(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy".showToLog
        dbVm = null
    }

}