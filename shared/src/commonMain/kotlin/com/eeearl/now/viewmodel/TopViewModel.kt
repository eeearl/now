package com.eeearl.now.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeearl.now.data.Anime
import com.eeearl.now.repository.AnimeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TopViewModel : ViewModel(), KoinComponent {
    private val repository: AnimeRepository by inject()

    private val _uiState= MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    var page = 0

    init {
        viewModelScope.launch {
            getTopAnimeList()
        }
    }

    suspend fun getTopAnimeList() {
        repository.getTopAnimeList(page = page)
            .onStart {
                _uiState.update {
                    it.copy(isLoading = true)
                }
            }
            .onCompletion {
                _uiState.update {
                    it.copy(isLoading = false)
                }
            }
            .collect { response ->
                _uiState.update {
                    it.copy(
                        list = it.list + response.list,
                        hasNext = response.pagination?.hasNextPage ?: false
                    )
                }
            }
    }

    suspend fun loadMore() {
        page++
        getTopAnimeList()
    }
}

data class UiState(
    val isLoading: Boolean = true,
    val list: List<Anime> = emptyList(),
    val hasNext: Boolean = true,
)