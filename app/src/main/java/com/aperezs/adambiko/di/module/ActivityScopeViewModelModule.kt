package com.aperezs.adambiko.di.module

import androidx.lifecycle.ViewModel
import com.aperezs.adambiko.di.annotation.ViewModelKey
import com.aperezs.adambiko.operations.entries.EntriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityScopeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EntriesViewModel::class)
    abstract fun bindMainViewModel(entriesViewModel: EntriesViewModel): ViewModel

}