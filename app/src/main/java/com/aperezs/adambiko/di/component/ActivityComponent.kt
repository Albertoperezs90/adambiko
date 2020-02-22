package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.ActivityScope
import com.aperezs.adambiko.di.module.ActivityScopeViewModelModule
import com.aperezs.adambiko.operations.entries.EntriesActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityScopeViewModelModule::class])
interface ActivityComponent {

    fun fragmentComponentBuilder(): FragmentComponent.Builder
    fun fragmentComponentDialogBuilder(): FragmentDialogComponent.Builder
    fun inject(entriesActivity: EntriesActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ActivityComponent

    }
}
