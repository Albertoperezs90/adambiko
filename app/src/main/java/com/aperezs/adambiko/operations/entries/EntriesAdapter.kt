package com.aperezs.adambiko.operations.entries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.common.adapter.CommonAdapter
import com.aperezs.adambiko.databinding.EntriesItemBinding
import com.aperezs.adambiko.operations.entries.model.EntryUI

class EntriesAdapter : CommonAdapter<EntriesAdapter.ViewHolder, EntriesViewModel, EntryUI>() {

    private var data: List<EntryUI> = emptyList()

    override fun setData(data: List<EntryUI>) {
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

        fun bind(item: EntryUI) {
            binding.viewModel = viewModel
            binding.entry = item
            binding.avatarImageView.setImageDrawable(this.itemView.resources.getDrawable(item.avatar, null))
            binding.executePendingBindings()
        }
    }
}