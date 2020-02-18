package com.aperezs.adambiko.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.aperezs.adambiko.di.component.FragmentDialogComponent

abstract class BaseDialogFragment<V : ViewDataBinding>(private val layoutRes: Int) : DialogFragment() {

    protected val viewModelProvider: ViewModelProvider.Factory by lazy {
        (activity as BaseActivity<*>).viewModelFactory
    }

    val fragmentDialogComponent: FragmentDialogComponent by lazy {
        (activity as BaseActivity<*>).activityComponent.fragmentDialogBuilder().build()
    }

    lateinit var binding: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    abstract fun initialize()

}