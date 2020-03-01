package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseFragment
import com.aperezs.adambiko.common.extensions.showSnackbar
import com.aperezs.adambiko.databinding.EntriesFragmentBinding
import com.aperezs.adambiko.operations.entries.adapter.EntriesAdapter
import com.aperezs.adambiko.operations.entries.adapter.SwipeCallback
import com.aperezs.adambiko.operations.fullscren.FullScrenDialog
import com.aperezs.adambiko.operations.modify.ModifyEntryFragment

class EntriesFragment : BaseFragment<EntriesFragmentBinding>(R.layout.entries_fragment) {

    private lateinit var entriesViewModel: EntriesViewModel

    private val adapter: EntriesAdapter by lazy {
        EntriesAdapter()
    }

    override fun initialize() {
        injectDependencies()
        entriesViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)[EntriesViewModel::class.java]
        binding.viewModel = entriesViewModel
        binding.entriesRecyclerView.configWithSwipe()
        initializeObservers()
        entriesViewModel.loadInitialData()
    }

    private fun initializeObservers() {
        entriesViewModel.onNavigation.observe(this, Observer {
            when (it) {
                is EntriesNavigation.FullScreen -> FullScrenDialog.newInstance(it.drawableResource).show(childFragmentManager, FullScrenDialog.toString())
                is EntriesNavigation.ModifyEntry -> ModifyEntryFragment.newInstance(it.entryUI).show(childFragmentManager, ModifyEntryFragment.toString())
            }
        })
    }

    private fun RecyclerView.configWithSwipe() {
        this.adapter = this@EntriesFragment.adapter
        val itemTouchHelper = ItemTouchHelper(SwipeCallback(
            onDelete = {
                entriesViewModel.removeEntry(it)
                showSnackbar(R.string.entry_removed, R.string.entry_removed_cancel) {
                    entriesViewModel.cancelRemove()
                }
            },
            onRead = { entriesViewModel.toggleDisable(it) }
        ))
        itemTouchHelper.attachToRecyclerView(this)
    }

}