package com.imah.laporan.anak.murid.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imah.laporan.anak.databinding.ItemMuridLaporanChildBinding
import com.imah.laporan.anak.databinding.ItemMuridLaporanHeadBinding
import com.imah.laporan.anak.murid.data.model.MuridLaporanModel
import com.imah.laporan.anak.murid.data.local.SetNilai
import com.imah.laporan.anak.main.util.extension.layoutInflater
import com.imah.laporan.anak.main.util.base.recyclerview.HolderView

class LaporanAdapter : RecyclerView.Adapter<HolderView>() {
    private val masterData = mutableListOf<MuridLaporanModel>()

    class ItemChild(binding: ItemMuridLaporanChildBinding) : HolderView(binding.root)
    class ItemHead(binding: ItemMuridLaporanHeadBinding) : HolderView(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == SetNilai.ITEM_LAPORAN_HEAD)
            ItemHead(ItemMuridLaporanHeadBinding.inflate(parent.layoutInflater, parent, false))
        else
            ItemChild(ItemMuridLaporanChildBinding.inflate(parent.layoutInflater, parent, false))

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val data = masterData[position]
    }

    override fun getItemViewType(position: Int) = masterData[position].type

    override fun getItemCount() = masterData.size

    fun loadData(data: List<MuridLaporanModel>?) {
        data?.let {
            masterData.clear()
            masterData.addAll(it)
            notifyDataSetChanged()
        }
    }

    companion object {
        val instance = LaporanAdapter()
    }
}