package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.operations.entries.EntriesFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentComponent {

    fun inject(entriesFragment: EntriesFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FragmentComponent

    }

}