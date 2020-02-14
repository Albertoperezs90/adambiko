package com.aperezs.adambiko.view.main

import com.aperezs.adambiko.R
import com.aperezs.adambiko.databinding.ActivityMainBinding
import com.aperezs.adambiko.view.base.BaseActivity
import com.aperezs.adambiko.view.main.injectDependencies
import com.aperezs.adambiko.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun initialize() {
        injectDependencies()
    }
}
