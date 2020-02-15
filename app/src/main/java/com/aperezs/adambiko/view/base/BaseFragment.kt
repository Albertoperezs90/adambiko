package com.aperezs.adambiko.view.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.di.component.FragmentComponent

abstract class BaseFragment<V : ViewDataBinding>(layoutRes: Int) : Fragment(layoutRes) {

    protected val viewModelProvider: ViewModelProvider.Factory by lazy {
        (activity as BaseActivity<*>).viewModelFactory
    }

    val fragmentComponent: FragmentComponent by lazy {
        (activity as BaseActivity<*>).activityComponent.fragmentComponentBuilder().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    abstract fun initialize()

}