package com.aperezs.adambiko.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.di.AdambikoApplication
import com.aperezs.adambiko.di.component.ActivityComponent
import com.aperezs.adambiko.di.module.ViewModelModule
import javax.inject.Inject

abstract class BaseActivity<V : ViewDataBinding>(private val layoutRes: Int) : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val activityComponent: ActivityComponent by lazy {
        (application as AdambikoApplication).applicationComponent.activityComponent().viewModelModule(ViewModelModule()).build()
    }

    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        initialize()
    }

    abstract fun initialize()
}