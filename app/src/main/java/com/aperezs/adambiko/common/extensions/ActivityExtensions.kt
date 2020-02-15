package com.aperezs.adambiko.common.extensions

import androidx.fragment.app.Fragment
import com.aperezs.adambiko.common.base.BaseActivity

fun BaseActivity<*>.addFragment(fragmentClazz: Class<out Fragment>) {
    val fragment = fragmentClazz.newInstance()
    supportFragmentManager.beginTransaction().add(android.R.id.content, fragment).addToBackStack(fragment.tag).commit()
}

fun BaseActivity<*>.replaceFragment(fragmentClazz: Class<out Fragment>) {
    val fragment = fragmentClazz.newInstance()
    supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment).addToBackStack(fragment.tag).commit()
}