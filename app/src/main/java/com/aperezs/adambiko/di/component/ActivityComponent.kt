package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.module.ViewModelModule
import com.aperezs.adambiko.view.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}
