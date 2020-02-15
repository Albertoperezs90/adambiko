package com.aperezs.adambiko.view.entries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.databinding.EntriesItemBinding
import com.aperezs.adambiko.view.base.CommonAdapter
import com.aperezs.adambiko.viewmodel.entries.EntriesViewModel

class EntriesAdapter : CommonAdapter<EntriesAdapter.ViewHolder, EntriesViewModel, String>() {

    private var data: List<String> = emptyList()

    override fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EntriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(private val binding: EntriesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }
    }
}