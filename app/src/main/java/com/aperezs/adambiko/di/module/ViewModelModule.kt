package com.aperezs.adambiko.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.di.annotation.ViewModelKey
import com.aperezs.adambiko.viewmodel.entries.EntriesViewModel
import com.aperezs.adambiko.viewmodel.base.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule  {

    @Provides
    fun providesViewModelFactory(map: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactory(map)
    }

    @Provides
    @IntoMap
    @ViewModelKey(EntriesViewModel::class)
    fun provideMainViewModel(): ViewModel {
        return EntriesViewModel()
    }

}