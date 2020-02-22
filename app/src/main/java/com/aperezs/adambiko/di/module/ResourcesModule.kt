package com.aperezs.adambiko.di.module

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.common.viewmodel.ViewModelFactory
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import com.aperezs.adambiko.utils.encoding.Base64Utils
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ResourcesModule(private val application: Application) {

    @Provides
    @Reusable
    fun providesViewModelFactory(map: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactory(map)
    }

    @Provides
    fun provideResources(): Resources {
        return application.resources
    }

    @Provides
    fun provideEntryUIMock(resources: Resources): EntryUIMock {
        return EntryUIMock(resources)
    }

    @Provides
    fun provideBase64Utils(): Base64Utils {
        return Base64Utils()
    }
}