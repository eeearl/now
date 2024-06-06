package com.eeearl.now

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher: Dispatcher {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}

internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()