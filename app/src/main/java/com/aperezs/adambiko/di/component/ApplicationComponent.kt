package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.ApplicationScope
import com.aperezs.adambiko.di.module.ResourcesModule
import dagger.Component

@ApplicationScope
@Component(modules = [ResourcesModule::class])
interface ApplicationComponent {

    fun activityComponent(): ActivityComponent.Builder

}
