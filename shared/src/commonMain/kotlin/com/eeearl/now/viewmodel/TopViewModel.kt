package com.eeearl.now.viewmodel

import androidx.lifecycle.ViewModel
import com.eeearl.now.repository.RemoteRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TopViewModel : ViewModel(), KoinComponent {
    private val repository: RemoteRepository by inject()

    suspend fun getTopList() = repository.getTopList()
}