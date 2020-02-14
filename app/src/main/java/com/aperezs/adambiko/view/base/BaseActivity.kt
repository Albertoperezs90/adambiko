package com.aperezs.adambiko.view.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<V : ViewDataBinding>(layoutRes: Int) : AppCompatActivity(layoutRes) {


}