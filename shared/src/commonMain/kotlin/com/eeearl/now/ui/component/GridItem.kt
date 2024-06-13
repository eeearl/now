package com.eeearl.now.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun GridItem(
    url: String?,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio = 0.6f, matchHeightConstraintsFirst = true)
    ) {
        url?.let {
            KamelImage(
                resource = asyncPainterResource(it),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp)),
                onLoading = {

                },
                onFailure = {

                }
            )
        }
    }
}