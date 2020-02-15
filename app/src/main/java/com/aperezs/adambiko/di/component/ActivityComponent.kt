package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.ActivityScope
import com.aperezs.adambiko.di.module.ViewModelModule
import com.aperezs.adambiko.view.entries.EntriesActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {

    fun fragmentComponentBuilder(): FragmentComponent.Builder
    fun inject(entriesActivity: EntriesActivity)

    @Subcomponent.Builder
    interface Builder {

        fun viewModelModule(viewModelModule: ViewModelModule): Builder
        fun build(): ActivityComponent

    }
}
