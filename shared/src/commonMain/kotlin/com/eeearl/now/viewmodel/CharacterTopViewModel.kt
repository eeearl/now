package com.eeearl.now.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeearl.now.data.Character
import com.eeearl.now.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharacterTopViewModel : ViewModel(), KoinComponent {
    private val repository: CharacterRepository by inject()

    private val _uiState= MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    var page = 0

    init {
        viewModelScope.launch {
            getCharacterList()
        }
    }

    suspend fun getCharacterList() {
        repository.getTopCharacterList(page = page, limit = 10)
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
        getCharacterList()
    }

    data class UiState(
        val isLoading: Boolean = true,
        val list: List<Character> = emptyList(),
        val hasNext: Boolean = true,
    )
}
