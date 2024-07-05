package com.eeearl.now.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.eeearl.now.ui.AppScreen

@Composable
fun CharacterTopScreen(
    onNavigate: (String) -> Unit,
) {
    Column {

        Text(text = "CharacterTopScreen")

        Button(
            onClick = { onNavigate(AppScreen.CharacterDetail.route) },
            ) {
            Text(text = "CharacterDetailScreen")
        }
    }
}