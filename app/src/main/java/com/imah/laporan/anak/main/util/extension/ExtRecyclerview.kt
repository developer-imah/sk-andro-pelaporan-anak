package com.imah.laporan.anak.main.util.extension

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewImpl(val rv: RecyclerView) {
    val noOverScroll = RecyclerView.OVER_SCROLL_NEVER
}

internal fun RecyclerView.asLinear(context: Context, isVertical: Boolean = true): RecyclerViewImpl {
    val linearInstance = object : LinearLayoutManager(
        context,
        if (isVertical) RecyclerView.VERTICAL else RecyclerView.HORIZONTAL,
        false
    ) {
        override fun onLayoutChildren(
            recycler: RecyclerView.Recycler?,
            state: RecyclerView.State?
        ) {
            try {
                super.onLayoutChildren(recycler, state)
            } catch (e: IndexOutOfBoundsException) {
                Log.e("IMAH", e.stackTraceToString())
            } catch (e: Exception) {
                Log.e("IMAH", e.stackTraceToString())
            }
        }
    }
    layoutManager = linearInstance
    return RecyclerViewImpl(this)
}

internal fun RecyclerView.asGrid(context: Context, size: Int = 2): RecyclerViewImpl {
    val linearInstance = object : GridLayoutManager(
        context,
        size
    ) {
        override fun onLayoutChildren(
            recycler: RecyclerView.Recycler?,
            state: RecyclerView.State?
        ) {
            try {
                super.onLayoutChildren(recycler, state)
            } catch (e: IndexOutOfBoundsException) {
                Log.e("IMAH", e.stackTraceToString())
            } catch (e: Exception) {
                Log.e("IMAH", e.stackTraceToString())
            }
        }
    }
    layoutManager = linearInstance
    return RecyclerViewImpl(this)
}

internal fun RecyclerViewImpl.addAdapter(mAdapter: RecyclerView.Adapter<*>): RecyclerViewImpl {
    rv.adapter = mAdapter
    return this
}

internal fun RecyclerViewImpl.addCustomSetup(
    init: RecyclerView.(RecyclerViewImpl) -> Unit
) {
    init.invoke(rv, this)
}

internal val ViewGroup.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(context)