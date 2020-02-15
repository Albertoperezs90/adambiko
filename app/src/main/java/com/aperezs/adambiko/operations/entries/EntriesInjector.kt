package com.aperezs.adambiko.operations.entries

import com.aperezs.adambiko.common.base.BaseActivity
import com.aperezs.adambiko.common.base.BaseFragment

fun EntriesActivity.injectDependencies() {
    (this as BaseActivity<*>).activityComponent.inject(this)
}

fun EntriesFragment.injectDependencies() {
    (this as BaseFragment<*>).fragmentComponent.inject(this)
}