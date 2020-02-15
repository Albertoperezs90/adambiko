package com.aperezs.adambiko.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.view.base.CommonAdapter
import com.aperezs.adambiko.viewmodel.base.BaseViewModel

object BindingAdapters {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("binding:viewmodel")
    fun setViewModelForAdapter(recyclerView: RecyclerView, viewModel: BaseViewModel) {
        val adapter = recyclerView.adapter as CommonAdapter<*, BaseViewModel, *>?
        adapter?.viewModel = viewModel
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("binding:data")
    fun <T> setDataForAdapter(recyclerView: RecyclerView, data: List<T>?) {
        val adapter = recyclerView.adapter as CommonAdapter<*, *, T>?
        data?.let { adapter?.setData(it) }
    }

}