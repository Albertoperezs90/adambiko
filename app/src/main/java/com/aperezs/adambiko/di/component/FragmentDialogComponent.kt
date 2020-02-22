package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.FragmentScope
import com.aperezs.adambiko.di.module.FragmentScopeViewModelModule
import com.aperezs.adambiko.operations.fullscren.FullScrenDialog
import com.aperezs.adambiko.operations.modify.ModifyEntryFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [FragmentScopeViewModelModule::class])
interface FragmentDialogComponent {

    fun inject(fullScrenDialog: FullScrenDialog)
    fun inject(modifyEntryFragment: ModifyEntryFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FragmentDialogComponent

    }

}