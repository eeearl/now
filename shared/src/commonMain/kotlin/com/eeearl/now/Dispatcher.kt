package com.eeearl.now

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val ioDispatcher: CoroutineDispatcher
}

internal expect fun provideDispatcher(): Dispatcher