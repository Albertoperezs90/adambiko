package com.aperezs.adambiko.view.entries

import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.R
import com.aperezs.adambiko.databinding.EntriesFragmentBinding
import com.aperezs.adambiko.view.base.BaseFragment
import com.aperezs.adambiko.viewmodel.entries.EntriesViewModel

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
    }

}