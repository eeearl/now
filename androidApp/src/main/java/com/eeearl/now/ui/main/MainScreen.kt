package com.eeearl.now.ui.main

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eeearl.now.ui.component.GridItem
import com.eeearl.now.ui.component.NowTopBar
import com.eeearl.now.ui.component.ProgressIndicator
import com.eeearl.now.ui.theme.NowTheme
import com.eeearl.now.viewmodel.TopViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val viewModel = koinViewModel<TopViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            NowTopBar(
                modifier = Modifier,
                title = "Now",
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar {

            }
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
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
                    Text(
                        text = it.title ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
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

@Preview
@Composable
private fun MainScreenPreview() {
    NowTheme {
        Surface {
        }
    }
}
