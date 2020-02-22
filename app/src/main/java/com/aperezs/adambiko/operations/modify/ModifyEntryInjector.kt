package com.aperezs.adambiko.operations.modify

import com.aperezs.adambiko.common.base.BaseDialogFragment

fun ModifyEntryFragment.injectDependencies() {
    (this as BaseDialogFragment<*>).fragmentDialogComponent.inject(this)
}