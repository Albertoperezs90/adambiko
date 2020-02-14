package com.aperezs.adambiko.di.component

import com.aperezs.adambiko.di.annotation.ApplicationScope
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    fun activityComponent(): ActivityComponent.Builder

}
