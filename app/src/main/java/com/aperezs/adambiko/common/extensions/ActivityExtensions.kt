package com.aperezs.adambiko.common.extensions

import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseActivity
import com.aperezs.adambiko.common.base.BaseFragment
import com.google.android.material.snackbar.Snackbar

fun BaseActivity<*>.addFragment(fragmentClazz: Class<out Fragment>, data: Bundle? = null) {
    val fragment = fragmentClazz.newInstance()
    fragment.arguments = data
    supportFragmentManager.beginTransaction().add(android.R.id.content, fragment, fragmentClazz.canonicalName).addToBackStack(fragment.tag).commit()
}

fun BaseActivity<*>.replaceFragment(fragmentClazz: Class<out Fragment>) {
    val fragment = fragmentClazz.newInstance()
    supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment).addToBackStack(fragment.tag).commit()
}

fun BaseFragment<*>.showSnackbar(titleRes: Int, actionRes: Int, onAction: () -> Unit) {
    Snackbar.make(requireActivity().findViewById(android.R.id.content), titleRes, Snackbar.LENGTH_LONG)
        .setAction(actionRes) {
            onAction()
        }
        .setActionTextColor(ResourcesCompat.getColor(resources, R.color.colorAccent, null))
        .show()
}