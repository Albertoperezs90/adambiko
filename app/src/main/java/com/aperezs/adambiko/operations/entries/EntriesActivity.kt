package com.aperezs.adambiko.operations.entries

import com.aperezs.adambiko.R
import com.aperezs.adambiko.common.base.BaseActivity
import com.aperezs.adambiko.common.extensions.addFragment
import com.aperezs.adambiko.databinding.EntriesActivityBinding

class EntriesActivity : BaseActivity<EntriesActivityBinding>(R.layout.entries_activity) {

    override fun initialize() {
        injectDependencies()
        addFragment(EntriesFragment::class.java)
    }
}
