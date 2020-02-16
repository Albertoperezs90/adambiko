package com.aperezs.adambiko.di.module

import android.app.Application
import android.content.res.Resources
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import dagger.Module
import dagger.Provides

@Module
class ResourcesModule(private val application: Application) {

    @Provides
    fun provideResources(): Resources {
        return application.resources
    }

    @Provides
    fun provideEntryUIMock(resources: Resources): EntryUIMock {
        return EntryUIMock(resources)
    }
}