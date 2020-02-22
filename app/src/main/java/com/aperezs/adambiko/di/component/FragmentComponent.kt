package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.FragmentScope
import com.aperezs.adambiko.di.module.FragmentScopeViewModelModule
import com.aperezs.adambiko.operations.entries.EntriesFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [FragmentScopeViewModelModule::class])
interface FragmentComponent {

    fun inject(entriesFragment: EntriesFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FragmentComponent

    }

}