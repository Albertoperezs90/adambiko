package com.aperezs.adambiko.common.binding

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.common.adapter.CommonAdapter
import com.aperezs.adambiko.common.base.BaseViewModel

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


    @JvmStatic
    @BindingAdapter("binding:onLongClick")
    fun setOnLongClick(view: View, function: Runnable) {
        view.setOnLongClickListener {
            function.run()
            true
        }
    }

}