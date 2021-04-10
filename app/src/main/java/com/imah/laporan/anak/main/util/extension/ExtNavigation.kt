package com.imah.laporan.anak.main.util.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun <reified T : Fragment> Fragment.doTransaction(
    name: String,
    allowStateLoss: Boolean = false,
    args: Bundle? = null,
    block: FragmentTransactionImpl.() -> Unit
) {
    val transaction = childFragmentManager.beginTransaction()
    transaction.setReorderingAllowed(true)
    block(FragmentTransactionImpl(name, childFragmentManager.getFragment<T>(name, args), transaction))
    if (allowStateLoss) {
        transaction.commitAllowingStateLoss()
    } else {
        transaction.commit()
    }
}

inline fun <reified T : Fragment> AppCompatActivity.doTransaction(
    name: String,
    allowStateLoss: Boolean = false,
    args: Bundle? = null,
    block: FragmentTransactionImpl.() -> Unit
) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.setReorderingAllowed(true)
    block(FragmentTransactionImpl(name, supportFragmentManager.getFragment<T>(name, args), transaction))
    if (allowStateLoss) {
        transaction.commitAllowingStateLoss()
    } else {
        transaction.commit()
    }
}

class FragmentTransactionImpl(
    private val name: String,
    private val fragment: Fragment,
    private val fragmentTransaction: FragmentTransaction
) {
    fun navigateWithOrBackstack(@IdRes layout: Int) {
        fragmentTransaction.replace(layout, fragment)
        fragmentTransaction.addToBackStack(name)
    }
}

inline fun <reified T : Fragment> FragmentManager.getFragment(name: String, args: Bundle? = null): Fragment {
    val clazz = T::class.java
    return findFragmentByTag(name) ?: return (clazz.getConstructor()
        .newInstance() as T).apply {
        args?.let {
            it.classLoader = javaClass.classLoader
            arguments = it
        }
    }
}