package com.aperezs.adambiko.di.module

import androidx.lifecycle.ViewModel
import com.aperezs.adambiko.di.annotation.ViewModelKey
import com.aperezs.adambiko.operations.modify.ModifyEntryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentScopeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ModifyEntryViewModel::class)
    abstract fun bindModifyEntryViewModel(modifyEntryViewModel: ModifyEntryViewModel): ViewModel

}