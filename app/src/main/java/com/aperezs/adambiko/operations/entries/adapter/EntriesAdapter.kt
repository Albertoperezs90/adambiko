package com.aperezs.adambiko.operations.entries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.common.adapter.CommonAdapter
import com.aperezs.adambiko.databinding.EntriesItemBinding
import com.aperezs.adambiko.operations.entries.EntriesViewModel
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


    inner class ViewHolder(val binding: EntriesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EntryUI) {
            binding.viewModel = viewModel
            binding.entry = item
            binding.avatarImageView.setImageDrawable(this.itemView.resources.getDrawable(item.avatar, null))
            binding.executePendingBindings()

            if (item.isDisabled) lock(binding.lockView) else unlock(binding.lockView)
        }


        private fun lock(view: View) {
            view.visibility = VISIBLE
        }

        private fun unlock(view: View) {
            view.visibility = GONE
        }

    }
}