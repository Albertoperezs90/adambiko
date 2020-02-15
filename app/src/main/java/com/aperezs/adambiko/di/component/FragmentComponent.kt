package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.view.entries.EntriesFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentComponent {

    fun inject(entriesFragment: EntriesFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FragmentComponent

    }

}