package com.eeearl.now.ui.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eeearl.now.ui.component.GridItem
import com.eeearl.now.ui.component.NowTopBar
import com.eeearl.now.ui.component.ProgressIndicator
import com.eeearl.now.viewmodel.CharacterTopViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen() {
    val viewModel = koinViewModel<CharacterTopViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            NowTopBar(
                modifier = Modifier,
                title = "Now",
            )
        },
        bottomBar = {
            BottomAppBar {

            }
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(uiState.list) {
                Column {
                    GridItem(
                        url = it.images.jpg.imageUrl,
                    )
                }
            }

//            item {
//                if (uiState.hasNext) {
//                    scope.launch {
//                        viewModel.loadMore()
//                    }
//                }
//            }
        }
    }

    if (uiState.isLoading) {
        ProgressIndicator()
    }
}