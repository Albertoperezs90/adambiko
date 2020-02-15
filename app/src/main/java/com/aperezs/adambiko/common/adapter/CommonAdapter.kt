package com.aperezs.adambiko.common.adapter

import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.common.base.BaseViewModel

abstract class CommonAdapter<VH : RecyclerView.ViewHolder, VM : BaseViewModel, T> : RecyclerView.Adapter<VH>() {

    lateinit var viewModel: VM

    abstract fun setData(data: List<T>)

}