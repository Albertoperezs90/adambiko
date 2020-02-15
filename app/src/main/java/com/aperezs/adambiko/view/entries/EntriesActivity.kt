package com.aperezs.adambiko.view.entries

import com.aperezs.adambiko.R
import com.aperezs.adambiko.databinding.EntriesActivityBinding
import com.aperezs.adambiko.view.base.BaseActivity
import com.aperezs.adambiko.view.base.addFragment

class EntriesActivity : BaseActivity<EntriesActivityBinding>(R.layout.entries_activity) {

    override fun initialize() {
        injectDependencies()
        addFragment(EntriesFragment::class.java)
    }
}
