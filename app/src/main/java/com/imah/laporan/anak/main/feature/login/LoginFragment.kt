package com.imah.laporan.anak.main.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.imah.laporan.anak.databinding.FragmentMainLoginBinding
import com.imah.laporan.anak.main.util.base.BaseFragment

class LoginFragment : BaseFragment(), LoginAction {

    private lateinit var binding: FragmentMainLoginBinding

    private var presenter: LoginPresenter? = null

    override fun initView(q: LayoutInflater, w: ViewGroup?, e: Boolean): ViewBinding {
        binding = FragmentMainLoginBinding.inflate(q,w,e)
        return binding
    }

    override fun setupPresenter() {
        presenter = LoginPresenter()
        presenter?.attachView(this)
    }

    override fun startUse(view: View, savedInstanceState: Bundle?) {
        binding.useView()
    }


    private fun FragmentMainLoginBinding.useView() {

    }
}