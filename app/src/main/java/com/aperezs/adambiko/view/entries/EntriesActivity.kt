package com.aperezs.adambiko.view.entries

import androidx.lifecycle.ViewModelProviders
import com.aperezs.adambiko.R
import com.aperezs.adambiko.databinding.EntriesActivityBinding
import com.aperezs.adambiko.view.base.BaseActivity
import com.aperezs.adambiko.view.base.addFragment
import com.aperezs.adambiko.viewmodel.entries.EntriesViewModel

class EntriesActivity : BaseActivity<EntriesActivityBinding>(R.layout.entries_activity) {

    private lateinit var entriesViewModel: EntriesViewModel

    override fun initialize() {
        injectDependencies()
        entriesViewModel = ViewModelProviders.of(this, viewModelFactory)[EntriesViewModel::class.java]
        addFragment(EntriesFragment::class.java)
    }
}
