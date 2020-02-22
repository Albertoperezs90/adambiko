package com.aperezs.adambiko.operations.modify

import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseDialogFragment
import com.aperezs.adambiko.databinding.ModifyDialogFragmentBinding
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.utils.edittext.disableEdit

class ModifyEntryFragment : BaseDialogFragment<ModifyDialogFragmentBinding>(R.layout.modify_dialog_fragment) {

    private lateinit var modifyEntryViewModel: ModifyEntryViewModel

    companion object {

        private const val ENTRY_UI = "ENTRY_UI"

        fun newInstance(entryUI: EntryUI): ModifyEntryFragment {
            return ModifyEntryFragment().apply {
                arguments = bundleOf(ENTRY_UI to entryUI)
            }
        }
    }

    override fun initialize() {
        injectDependencies()
        val viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)[ModifyEntryViewModel::class.java]
        modifyEntryViewModel = viewModel
        binding.viewModel = modifyEntryViewModel
        modifyEntryViewModel.initializeEntry(arguments?.get(ENTRY_UI) as EntryUI)

        configViews()
    }

    private fun configViews() {
        binding.amountEditText.disableEdit()
        binding.amountEditText.setTextColor(ResourcesCompat.getColor(resources, R.color.colorPrimary, null))
    }


}