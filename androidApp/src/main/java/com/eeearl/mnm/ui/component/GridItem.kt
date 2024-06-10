package com.eeearl.mnm.ui.component

import androidx.compose.runtime.Composable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import androidx.compose.foundation.layout.Column

@Composable
fun GridItem(
    url: String?,
) {
    Column {
        url?.let {
            KamelImage(
                resource = asyncPainterResource(it),
                contentDescription = "",
                onLoading = {

                },
                onFailure = {

                }
            )
        }
    }
}