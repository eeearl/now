package com.eeearl.mnm.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.eeearl.mnm.ui.component.GridItem
import com.eeearl.now.viewmodel.TopViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<TopViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(uiState.list) {
            Box {
                Text(text = it.title ?: "")
                GridItem(url = it.images.jpg.imageUrl)
            }
        }
    }
}