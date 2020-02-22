package com.aperezs.adambiko.operations.modify

import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.common.base.BaseDialogFragment
import com.aperezs.adambiko.databinding.ModifyDialogFragmentBinding
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.utils.edittext.disableEdit


class ModifyEntryFragment : BaseDialogFragment<ModifyDialogFragmentBinding>(com.aperezs.adambiko.R.layout.modify_dialog_fragment) {

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
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        val window = dialog?.window
        if (window != null) {
            val lp = WindowManager.LayoutParams()
            lp.copyFrom(window.attributes)
            //This makes the dialog take up the full width
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            window.attributes = lp
        }
    }

    private fun configViews() {
        binding.amountEditText.disableEdit()
        binding.amountEditText.setTextColor(ResourcesCompat.getColor(resources, com.aperezs.adambiko.R.color.colorPrimary, null))
    }

    private fun setListeners() {
        binding.firstValueEditText.addTextChangedListener {
            modifyEntryViewModel.updateFirstValue(it.toString())
        }

        binding.amountEditText.addTextChangedListener {
            modifyEntryViewModel.updateAmountValue(it.toString())
        }
    }


}