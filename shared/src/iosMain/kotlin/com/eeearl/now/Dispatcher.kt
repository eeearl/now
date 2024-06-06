package com.eeearl.now

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
internal class IosDispatcher: Dispatcher {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher():Dispatcher = IosDispatcher()