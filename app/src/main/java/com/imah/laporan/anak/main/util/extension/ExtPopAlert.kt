package com.imah.laporan.anak.main.util.extension

import android.widget.Toast
import com.imah.laporan.anak.ApplicationImpl

internal fun Any?.toast(isError: Boolean = false) =
    Toast.makeText(
        ApplicationImpl.appContext,
        "${if (isError) "Error " else ""}$this",
        if (isError) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    ).show()