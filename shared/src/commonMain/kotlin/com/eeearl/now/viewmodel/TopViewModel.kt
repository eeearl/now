package com.eeearl.now.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeearl.now.data.Anime
import com.eeearl.now.repository.RemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TopViewModel : ViewModel(), KoinComponent {
    private val repository: RemoteRepository by inject()

    private val _uiState= MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getTopList()
        }
    }
//        field = MutableStateFlow<UiState>

    suspend fun getTopList() =
            repository.getTopList()
                .collect { response ->
                    _uiState.update {
                        it.copy(list = it.list + response.list)
                    }
                }
//                .stateIn(viewModelScope, SharingStarted.Lazily, )
//    fun getTopList() = flow<AnimeResponse> {
//        repository.getTopList()
//    }.stateIn(viewModelScope, SharingStarted.Lazily, null)
}

data class UiState(
    val list: List<Anime> = emptyList()
)