package com.imah.laporan.anak.murid.feature.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.imah.laporan.anak.murid.data.local.SetNilai
import com.imah.laporan.anak.murid.view.ContainerFragment

class MainTabAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = SetNilai.TOTAL_FEATURE

    override fun createFragment(position: Int) =
        ContainerFragment.instance(position)
}