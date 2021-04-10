package com.imah.laporan.anak.main.util.extension

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.viewbinding.ViewBinding

val View.viewDisabled: Unit
    get() {
        isEnabled = false
    }

val View.viewEnabled: Unit
    get() {
        isEnabled = true
    }

val ViewBinding.viewDisabled: Unit
    get() = root.viewDisabled

val ViewBinding.viewEnabled: Unit
    get() = root.viewEnabled

val View.viewAlpha0: Unit
    get() {
        alpha = 0f
    }

val View.viewAlpha1: Unit
    get() {
        alpha = 1f
    }

val ViewBinding.viewAlpha0: Unit
    get() = root.viewAlpha0

val ViewBinding.viewAlpha1: Unit
    get() = root.viewAlpha1

val View.viewVisible: Unit
    get() {
        visibility = View.VISIBLE
    }

val View.viewInvisible: Unit
    get() {
        visibility = View.INVISIBLE
    }

val View.viewGone: Unit
    get() {
        visibility = View.GONE
    }

val ViewBinding.viewVisible: Unit
    get() = root.viewVisible

val ViewBinding.viewInvisible: Unit
    get() = root.viewInvisible

val ViewBinding.viewGone: Unit
    get() = root.viewGone

val EditText.texter: String
    get() = text.toString()

internal fun TextView.tulis(msg: Any?, setup: TextView.() -> Unit = {/* no-op */ }) {
    text = msg.toString()
    apply(setup)
}

internal fun Any?.bindTo(view: TextView) {
    view.tulis(this)
}

internal fun Any?.bindTo(view: EditText) {
    view.tulis(this)
}