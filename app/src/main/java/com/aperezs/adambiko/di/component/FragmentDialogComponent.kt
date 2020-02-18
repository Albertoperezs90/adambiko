package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.operations.fullscren.FullScrenDialog
import dagger.Subcomponent

@Subcomponent
interface FragmentDialogComponent {

    fun inject(fullScrenDialog: FullScrenDialog)

    @Subcomponent.Builder
    interface Builder {

        fun build(): FragmentDialogComponent

    }

}