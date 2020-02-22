package com.aperezs.adambiko.operations.entries

import com.aperezs.adambiko.operations.entries.model.EntryUI

sealed class EntriesNavigation {

    data class FullScreen(val drawableResource: Int) : EntriesNavigation()
    data class ModifyEntry(val entryUI: EntryUI): EntriesNavigation()

}