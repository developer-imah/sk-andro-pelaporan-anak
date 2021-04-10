package com.imah.laporan.anak.murid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.imah.laporan.anak.databinding.FragmentMuridMainBinding
import com.imah.laporan.anak.murid.data.local.SetNilai
import com.imah.laporan.anak.murid.feature.adapter.MainTabAdapter

class MainFragment : Fragment() {
    private lateinit var bindings: FragmentMuridMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentMuridMainBinding.inflate(inflater)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.useView()
    }

    private fun FragmentMuridMainBinding.useView() {
        muridVp.adapter = MainTabAdapter(this@MainFragment)
        TabLayoutMediator(muridTab, muridVp) { tab, pos ->
            tab.text = when (pos) {
                SetNilai.TYPE_PAGE_LAPORAN -> "Laporan"
                SetNilai.TYPE_PAGE_PROFIL -> "Profil"
                else -> "Tidak diketahui"
            }
        }.attach()
    }
}