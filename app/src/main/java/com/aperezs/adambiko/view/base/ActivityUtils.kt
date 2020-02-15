package com.aperezs.adambiko.view.base

import androidx.fragment.app.Fragment

fun BaseActivity<*>.addFragment(fragmentClazz: Class<out Fragment>) {
    val fragment = fragmentClazz.newInstance()
    supportFragmentManager.beginTransaction().add(android.R.id.content, fragment).addToBackStack(fragment.tag).commit()
}

fun BaseActivity<*>.replaceFragment(fragmentClazz: Class<out Fragment>) {
    val fragment = fragmentClazz.newInstance()
    supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment).addToBackStack(fragment.tag).commit()
}