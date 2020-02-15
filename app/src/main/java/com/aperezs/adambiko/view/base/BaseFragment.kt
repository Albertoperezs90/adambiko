package com.aperezs.adambiko.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.di.component.FragmentComponent

abstract class BaseFragment<V : ViewDataBinding>(private val layoutRes: Int) : Fragment() {

    protected val viewModelProvider: ViewModelProvider.Factory by lazy {
        (activity as BaseActivity<*>).viewModelFactory
    }

    val fragmentComponent: FragmentComponent by lazy {
        (activity as BaseActivity<*>).activityComponent.fragmentComponentBuilder().build()
    }

    protected lateinit var binding: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    abstract fun initialize()

}