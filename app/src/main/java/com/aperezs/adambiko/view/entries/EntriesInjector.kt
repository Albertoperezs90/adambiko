package com.aperezs.adambiko.view.entries

import com.aperezs.adambiko.view.base.BaseActivity
import com.aperezs.adambiko.view.base.BaseFragment

fun EntriesActivity.injectDependencies() {
    (this as BaseActivity<*>).activityComponent.inject(this)
}

fun EntriesFragment.injectDependencies() {
    (this as BaseFragment<*>).fragmentComponent.inject(this)
}