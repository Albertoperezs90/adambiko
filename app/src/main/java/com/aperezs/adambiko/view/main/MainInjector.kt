package com.aperezs.adambiko.view.main

import com.aperezs.adambiko.di.AdambikoApplication
import com.aperezs.adambiko.di.module.ViewModelModule

fun MainActivity.injectDependencies() {
    (application as AdambikoApplication).applicationComponent.activityComponent()
        .viewModelModule(ViewModelModule())
        .build()
        .inject(this)
}