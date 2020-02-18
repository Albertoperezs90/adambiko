package com.aperezs.adambiko.operations.fullscren

import com.aperezs.adambiko.common.base.BaseDialogFragment

fun FullScrenDialog.injectDependencies() {
    (this as BaseDialogFragment<*>).fragmentDialogComponent.inject(this)
}