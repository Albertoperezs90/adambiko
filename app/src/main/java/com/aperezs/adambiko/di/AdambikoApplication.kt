package com.aperezs.adambiko.di

import android.app.Application
import com.aperezs.adambiko.di.component.ApplicationComponent
import com.aperezs.adambiko.di.component.DaggerApplicationComponent
import com.aperezs.adambiko.di.module.ResourcesModule

class AdambikoApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .resourcesModule(ResourcesModule(this))
            .build()
    }

}