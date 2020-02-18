package com.aperezs.adambiko.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.common.viewmodel.ViewModelFactory
import com.aperezs.adambiko.di.annotation.ViewModelKey
import com.aperezs.adambiko.operations.entries.EntriesViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import com.aperezs.adambiko.operations.fullscren.FullScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @Provides
    fun providesViewModelFactory(map: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactory(map)
    }

    @Provides
    @IntoMap
    @ViewModelKey(EntriesViewModel::class)
    fun provideMainViewModel(entryUIMock: EntryUIMock): ViewModel {
        return EntriesViewModel(entryUIMock)
    }


    @Provides
    @IntoMap
    @ViewModelKey(FullScreenViewModel::class)
    fun provideFullScreenViewModel(): ViewModel {
        return FullScreenViewModel()
    }

}