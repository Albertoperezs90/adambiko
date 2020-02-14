package com.aperezs.adambiko.view.main

import com.aperezs.adambiko.di.component.DaggerActivityComponent
import com.aperezs.adambiko.view.MainActivity

fun MainActivity.injectDependencies() {
    DaggerActivityComponent.builder()
        .build()
        .inject(this)
}