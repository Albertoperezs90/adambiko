package com.aperezs.adambiko.operations.entries

sealed class EntriesNavigation {

    data class FullScreen(val drawableResource: Int) : EntriesNavigation()

}