package com.aperezs.adambiko.operations.fullscren

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseDialogFragment
import com.aperezs.adambiko.databinding.FullscreenDialogFragmentBinding

class FullScrenDialog : BaseDialogFragment<FullscreenDialogFragmentBinding>(R.layout.fullscreen_dialog_fragment) {


    companion object {

        const val DRAWABLE_RES_KEY = "DRAWABLE_RES_KEY"

        fun newInstance(drawableResource: Int): FullScrenDialog {
            val fullScrenDialog = FullScrenDialog()
            fullScrenDialog.arguments = bundleOf(DRAWABLE_RES_KEY to drawableResource)
            return fullScrenDialog
        }
    }

    private lateinit var fullScreenViewModel: FullScreenViewModel

    override fun initialize() {
        injectDependencies()
        val drawableRes = arguments?.get(DRAWABLE_RES_KEY) as Int
        fullScreenViewModel = ViewModelProviders.of(this, viewModelFactory)[FullScreenViewModel::class.java]
        binding.viewModel = fullScreenViewModel
        fullScreenViewModel.loadDrawableResource(drawableRes)
    }


}