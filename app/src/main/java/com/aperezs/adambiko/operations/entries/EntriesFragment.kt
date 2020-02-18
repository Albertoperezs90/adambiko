package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseFragment
import com.aperezs.adambiko.databinding.EntriesFragmentBinding
import com.aperezs.adambiko.operations.fullscren.FullScrenDialog

class EntriesFragment : BaseFragment<EntriesFragmentBinding>(R.layout.entries_fragment) {

    private lateinit var entriesViewModel: EntriesViewModel

    private val adapter: EntriesAdapter by lazy {
        EntriesAdapter()
    }

    override fun initialize() {
        injectDependencies()
        entriesViewModel = ViewModelProviders.of(requireActivity(), viewModelProvider)[EntriesViewModel::class.java]
        binding.viewModel = entriesViewModel
        binding.entriesRecyclerView.adapter = adapter

        initializeObservers()
        entriesViewModel.loadInitialData()
    }

    private fun initializeObservers() {
        entriesViewModel.onNavigation.observe(this, Observer {
            when (it) {
                is EntriesNavigation.FullScreen -> FullScrenDialog.newInstance(it.drawableResource).show(childFragmentManager, FullScrenDialog.toString())
            }
        })
    }

}