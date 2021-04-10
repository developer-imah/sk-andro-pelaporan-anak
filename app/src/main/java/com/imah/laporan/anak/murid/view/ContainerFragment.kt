package com.imah.laporan.anak.murid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.imah.laporan.anak.databinding.FragmentMuridContainerBinding
import com.imah.laporan.anak.murid.data.local.SetNilai
import com.imah.laporan.anak.murid.feature.adapter.LaporanAdapter
import com.imah.laporan.anak.main.util.extension.*

class ContainerFragment : Fragment() {
    private lateinit var bindings: FragmentMuridContainerBinding
    private var page = 0
    private val adapter by lazy {
        LaporanAdapter.instance
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            page = it.getInt(SetNilai.FLAG_BUNDLE_PAGE_VP)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentMuridContainerBinding.inflate(inflater)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.useView()
    }

    private fun FragmentMuridContainerBinding.useView() {
        when (page) {
            SetNilai.TYPE_PAGE_PROFIL -> {
                muridContainerProfil.viewVisible
                muridContainerLaporan.viewGone
                profilSetupView()
            }
            SetNilai.TYPE_PAGE_LAPORAN -> {
                muridContainerLaporan.viewVisible
                muridContainerProfil.viewGone
                laporanSetupView()
            }
            else -> "halaman tidak diketahui".toast(true)
        }
    }

    private fun FragmentMuridContainerBinding.profilSetupView() {

    }

    private fun FragmentMuridContainerBinding.laporanSetupView() {
        muridContainerLaporanRv.recycler
            .asLinear(requireContext())
            .addAdapter(adapter)

    }

    companion object {
        fun instance(pageNumber: Int) =
            ContainerFragment().apply {
                arguments = bundleOf(SetNilai.FLAG_BUNDLE_PAGE_VP to pageNumber)
            }
    }
}
