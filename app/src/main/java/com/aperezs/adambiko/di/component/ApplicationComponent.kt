package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.ApplicationScope
import com.aperezs.adambiko.di.module.LocalDataSourcesModule
import com.aperezs.adambiko.di.module.ResourcesModule
import dagger.Component

@ApplicationScope
@Component(modules = [ResourcesModule::class, LocalDataSourcesModule::class])
interface ApplicationComponent {

    fun activityComponent(): ActivityComponent.Builder

}
